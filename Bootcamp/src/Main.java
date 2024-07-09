import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
    private static Set<Bootcamp> bootcampsAtivos = new LinkedHashSet<>();
    private static Set<Bootcamp> bootcampsInativos = new HashSet<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        executar();
    }

    public static void executar(){
        while(true) {
            int opcao = menu();
            if(opcao == 0){
                cadastrarBootcamp();
            } else if(opcao == 1){
                listarBootcampsAtivos();
            } else if(opcao == 2){
                listarBootcampsInativos();
            }else if(opcao == 3){
                cadastrarDevs();
            }else if(opcao == 4){
                inscreverBootcamp();
            }else if(opcao == 5){
                avancarBootcamp();
            }else if(opcao == 6){
                visualizarXpAdquirido();
            }else if(opcao == 7){
                visualizarDevs();
            } else if(opcao == 8){
                visualizarConteudosInscritos();
            }else if(opcao == 9){
                visualizarConteudosConcluidos();
            }else if(opcao == 10){
                System.out.println("######## Obrigado por utilizar o DEV_DO_FUTURO_BOOTCAMPS, até a próxima! ########");
                break;
            }else {
                System.out.println("Opção invalida, informe a opção desejada.");
            }

            verificarBootcampExpirado();
        }
    }

    private static int menu() {
        System.out.println("\n################ Bem-vindo ao DEV_DO_FUTURO_BOOTCAMPS aqui ajudamos a ser destaque na carreira DEV! ################\n" + //
                        "    Para começar escolha uma opção:");
        System.out.println("0 - Cadastrar Bootcamp");
        System.out.println("1 - Listar Bootcamp Ativos");
        System.out.println("2 - Listar Bootcamp Inativos");
        System.out.println("3 - Cadastrar DEV");
        System.out.println("4 - Inscrever em Bootcamp");
        System.out.println("5 - Avançar Bootcamp");
        System.out.println("6 - Visualizar XP");
        System.out.println("7 - Visualizar Devs Inscritos");
        System.out.println("8 - Visualizar Conteudos inscritos");
        System.out.println("9 - Visualizar Conteudos concluidos");
        System.out.println("10 - Sair");
        System.out.print("Escolha uma operação: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    private static void cadastrarBootcamp(){
        System.out.println("####### Bem Vindo, vamos começar a cadastrar seus bootcamps: Siga os passos solicitados #######");
        System.out.println("\nDigite o nome do bootcamp: ");
        String nome = scanner.next();
        scanner.nextLine();
        System.out.println("\nDigite a descrição do bootcamp: ");
        String descricao = scanner.next();
        scanner.nextLine();

        Bootcamp bootcamp = new Bootcamp(nome, descricao);
        while (true) {
            System.out.println("Agora precisamos cadastrar os conteudos: Para Curso digite [c] ou [m] para Monitoria: ");
            String cadastroConteudo = scanner.next().toUpperCase();
            scanner.nextLine();
            if("C".equalsIgnoreCase(cadastroConteudo)){
                System.out.println("\nNome Curso: ");
                String nomeCurso = scanner.next();
                scanner.nextLine();
                System.out.println("\nDescrição Curso: ");
                String descricaoCurso = scanner.next();
                scanner.nextLine();
                System.out.println("\nCarga Horária: ");
                int cargaHoraria = scanner.nextInt();
                scanner.nextLine();
                Curso curso = new Curso(nomeCurso, descricaoCurso, cargaHoraria);
                bootcamp.getConteudos().add(curso);
                String mensagem = curso.toString();
                System.out.println(mensagem + "Cadastrado com sucesso!");
            } else if("M".equalsIgnoreCase(cadastroConteudo)){
                System.out.println("\nNome Mentoria: ");
                String nomeMentoria = scanner.next();
                scanner.nextLine();
                System.out.println("\nDescrição Mentoria: ");
                String descricaoMentoria = scanner.next();
                scanner.nextLine();
                System.out.println("\nData (formato DD/MM/AAAA): ");
                String data = scanner.next();
                scanner.nextLine();
                LocalDate dataInicio = LocalDate.parse(data, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                System.out.println("\nHora Inicio (formato HH:mm): ");
                String hora = scanner.next();
                scanner.nextLine();
                LocalTime horaInicio = LocalTime.parse(hora);
                Mentoria mentoria = new Mentoria(nomeMentoria, descricaoMentoria, dataInicio, horaInicio);
                bootcamp.getConteudos().add(mentoria);
                String mensagem = mentoria.toString();
                System.out.println(mensagem + "Cadastrado com sucesso!");
            }else{
                System.out.println("Opção Inválida!");
            }

            System.out.println("\nDeseja continuar (S / N): ");
            String continuar = scanner.next().toUpperCase();
            scanner.nextLine();
            
            if("N".equalsIgnoreCase(continuar)){
                break;
            }
        }

        bootcampsAtivos.add(bootcamp);
        System.out.println("Bootcamp " + nome + " cadastrado com sucesso!");
    }

    private static void verificarBootcampExpirado(){
        LocalDate hoje = LocalDate.now();
        Set<Bootcamp> expirados = new HashSet<>();
    
        for (Bootcamp bootcamp : bootcampsAtivos) {
            LocalDate dataFinal = bootcamp.getDataFinal();
            if(hoje.isAfter(dataFinal)){
                expirados.add(bootcamp);
            }
        }
    
        for (Bootcamp bootcamp : expirados) {
            bootcampsAtivos.remove(bootcamp);
            bootcampsInativos.add(bootcamp);
            System.out.println("Bootcamp expirado movido para Inativos: " + bootcamp.getNome());
        }
    
    }
    
    private static void listarBootcampsAtivos() {
        System.out.println("\n### Bootcamps Ativos ###");
        for (Bootcamp bootcamp : bootcampsAtivos) {
            System.out.println(bootcamp);
        }
    }
    
    private static void listarBootcampsInativos() {
        System.out.println("\n### Bootcamps Inativos ###");
        for (Bootcamp bootcamp : bootcampsInativos) {
            System.out.println(bootcamp);
        }
    }

    private static void cadastrarDevs(){}

    private static void inscreverBootcamp(){}

    private static void avancarBootcamp(){}

    private static void visualizarXpAdquirido(){}

    private static void visualizarDevs(){}

    private static void visualizarConteudosInscritos(){}

    private static void visualizarConteudosConcluidos(){}
}

