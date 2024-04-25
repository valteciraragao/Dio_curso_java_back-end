import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {

        System.out.println("###### Bem vindo ao DioBank, com você sempre que precisar #####");
        System.out.println("Para abir sua conta por favor, informar os dados solicitados");


        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Digite o seu nome: ");
        String nome = scan.next();

        System.out.println("Digite o seu sobrenome: ");
        String sobrenome = scan.next();

        System.out.println("Digite o sua agência: ");
        String agencia = scan.next();

        System.out.println("Digite sua conta corrente: ");
        int numeroConta = scan.nextInt();

        System.out.println("Digite o valor do seu primeiro deposito: R$ ");
        float saldo = scan.nextFloat();

        scan.close();

        System.out.println("Olá " + nome + " " + sobrenome + " , obrigado por criar uma conta em nosso banco, sua agência é " + agencia + " , conta " + numeroConta + " e seu saldo "+ saldo + " já está disponível para saque");
    }
}
