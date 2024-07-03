package Contas;
import Cliente.Cliente;

public class ContaCorrente extends Conta {
    
    public ContaCorrente(String numeroAgencia, int numeroConta, Cliente cliente){
        super(numeroAgencia, numeroConta, cliente);
    }

    @Override
    public void sacar(double valor){
        if(valor > saldo)
            System.out.println("Saldo insuficiente.");
        else
            System.out.println("Saque de R$ %.2f " + valor + " realizado com sucesso.");
    }

    @Override
    public void depositar(double valor){
        saldo += valor;
        System.out.println();
    }

    @Override
    public void transferir(Conta contaDestino, double valor){
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para transferência.");
        } else {
            saldo -= valor;
            contaDestino.depositar(valor);
            System.out.println("Transferência de R$ %.2f " + valor + " realizada para conta " + contaDestino.getNumeroConta());
        }
    }

    @Override
    public void extrato(){
        System.out.println("=== Extrato Conta Corrente ===");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Saldo: R$ %.2f" + getSaldo());
    }
}
