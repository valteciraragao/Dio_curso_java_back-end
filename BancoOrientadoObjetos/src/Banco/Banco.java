import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Cliente.Cliente;
import Contas.Conta;
import Contas.ContaCorrente;

public class Banco {
    private List<Cliente> clientes;
    private List<Conta> contas;
    private static final String AGENCIA = "003";
    private int numeroContaCorrente = 30000;
    private int numeroContaPoupanca = 70000;
    private static final int LIMITE_SAQUE_DIARIO = 4;
    private double valorLimiteSaque = 1000;
    private Scanner scanner;

    public Banco(){
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.executar();
    }

    public void executar(){
        while(true) {
            int opcao = menu();
            if(opcao == 0){
                cadastrarCliente();
            } else if(opcao == 1){
                criarContaCorrente();
            } else if(opcao == 2){
                criarContaPoupanca();
            }else if(opcao == 3){
                realizarDeposito();
            }else if(opcao == 4){
                realizarSaque();
            }else if(opcao == 5){
                mostrarExtrato();
            }else if(opcao == 6){
                realizarTransferencia();
            }else if(opcao == 7){
                listarClientes();
            } else if(opcao == 8){
                listarContas();
            }else if(opcao == 9){
                System.out.println("######## Obrigado por utilizar o DIOBANK, até a próxima! ########");
                break;
            }else{
                System.out.println("Opção invalida, informe a opção desejada.");
            }
            
        }
    }

    private int menu() {
        System.out.println("\n################ Bem-vindo ao DIOBANK o banco que pensa em você! ################\n" + //
                        "    Para começar escolha uma opção:");
        System.out.println("0 - Cadastrar Cliente");
        System.out.println("1 - Criar Conta COrrente");
        System.out.println("2 - Criar Conta Poupança");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sacar");
        System.out.println("5 - Extrato");
        System.out.println("6 - Trasnferir");
        System.out.println("7 - Listar Clientes");
        System.out.println("8 - Listar Contas");
        System.out.println("9 - Sair");
        System.out.print("Escolha uma operação: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    private void realizarDeposito() {
        System.out.print("Número da conta: ");
        int numeroConta = scanner.nextInt();
        Conta conta = procurarConta(numeroConta);
        if (conta != null) {
            System.out.print("Valor a depositar: ");
            double valor = scanner.nextDouble();
            conta.depositar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private void realizarSaque() {
        System.out.print("Número da conta: ");
        int numeroConta = scanner.nextInt();
        Conta conta = procurarConta(numeroConta);
        if(conta != null){
            if(conta.getQuantidadeSaqueDiario() >= LIMITE_SAQUE_DIARIO){
                System.out.println("Quantidade diária de saque excedida.");
                return;
            }

            System.out.println("Valor que deseja sacar: R$ ");
            double valor = scanner.nextDouble();

            if(valor <= 0){
                System.out.println("Não é possível realizar seu saque com o valor informado, tente novamente.");
                return;
            }

            if(valor > valorLimiteSaque){
                System.out.println("O valor máximo permitido para saque é R$ %.2f" + valorLimiteSaque);
                return;
            }

            if(valor > conta.getSaldo()) {
                System.out.println("Saldo insuficiente");
                return;
            } else {
                conta.sacar(valor);
                conta.incrementarQuantidadeSaqueDiario();
                System.out.println("======= Saque realizado com sucesso R$  %.2f" + valor + " =======");
            }
        }else{
            System.out.println("Conta não localizada. Digite uma conta válida.");
        }
        
    }

    private void realizarTransferencia(){
        System.out.print("Número da conta cliente: ");
        int numeroConta = scanner.nextInt();
        Conta conta = procurarConta(numeroConta);
        if(conta != null){
            System.out.print("Número da conta para transferência: ");
            int numeroContaTransferencia = scanner.nextInt();
            Conta contaTransferencia = procurarConta(numeroContaTransferencia);
            if(contaTransferencia != null){
                System.out.println("Valor que deseja sacar: R$ ");
                double valor = scanner.nextDouble();

                if(valor <= 0){
                    System.out.println("Não é possível realizar sua transferência com o valor informado, tente novamente.");
                    return;
                }

                if (valor > conta.getSaldo()) {
                    System.out.println("Saldo insuficiente");
                    return;
                } else {
                    conta.transferir(contaTransferencia, valor);
                    System.out.println("======= Tranferência realizada com sucesso para conta: " + contaTransferencia + " R$  %.2f" + valor + " =======");
                }
            }
        }
    }

    private void mostrarExtrato() {
        System.out.print("Número da conta: ");
        int numeroConta = scanner.nextInt();
        Conta conta = procurarConta(numeroConta);
        if (conta != null) {
            conta.extrato();
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private void cadastrarCliente() {
        
        System.out.print("CPF do cliente: ");
        String cpf = scanner.next();
                
        if(cpf.length() != 11){

            System.out.println("CPF inválido. O documento deve conter 11 dígitos.");

        }else{

            System.out.print("Nome do cliente: ");
            String nome = scanner.next();
            System.out.print("Data de nascimento do cliente: Ex.:00-00-0000:  ");
            String dataNascimentoStr = scanner.next();
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            System.out.print("Endereço do cliente: Ex.: Logradouro, numero - bairro cidade / UF:  ");
            String endereco = scanner.next();
            Cliente cliente = new Cliente(nome, cpf, dataNascimento, endereco);
            clientes.add(cliente);
            System.out.println("Cliente cadastrado com sucesso.");
        }

        
        
    }

    private void criarContaCorrente() {
        String numeroAgencia = AGENCIA;
        numeroContaCorrente++;
        System.out.print("CPF do cliente: ");
        String cpf = scanner.next();
        Cliente cliente = procurarCliente(cpf);
        if (cliente != null) {
            ContaCorrente contaCorrente = new ContaCorrente(numeroAgencia, numeroContaCorrente, cliente);
            contas.add(contaCorrente);
            System.out.println("Conta corrente criada com sucesso. Número da conta: " + numeroContaCorrente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void criarContaPoupanca() {
        String numeroAgencia = AGENCIA;
        numeroContaPoupanca++;
        System.out.print("CPF do cliente: ");
        String cpf = scanner.next();
        Cliente cliente = procurarCliente(cpf);
        if (cliente != null) {
            ContaCorrente contaPoupanca = new ContaCorrente(numeroAgencia, numeroContaPoupanca, cliente);
            contas.add(contaPoupanca);
            System.out.println("Conta poupança criada com sucesso. Número da conta: " + numeroContaPoupanca);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void listarClientes() {
        System.out.println("\n=== Lista de Clientes ===");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    private void listarContas() {
        System.out.println("\n=== Lista de Contas ===");
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }

    private Cliente procurarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    private Conta procurarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

}



