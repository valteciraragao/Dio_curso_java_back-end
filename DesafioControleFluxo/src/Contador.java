import java.util.Scanner;

/**
* <h1>Desafio Controle de Fluxo</h1>
* O Contador recebe dois numeros inteiros, onde o segundo numero é maior que o primeiro e imprimi a quantidade de interações pela subtração dos números passados.
* @author  Valtecir Aragao
* @version 1.0
* @since   30/04/2024
*/

public class Contador {

    public static void main(String[] args) {
        /**
        * Este método é utilizado para contar interações apartir dos parametros solicitados
        * @param numeroHum este é o primeiro parâmetro do método
        * @param numeroDois este é o segundo parâmetro do método
        * @return int o resultado deste método uma lista numerica de interações.
        * @throws dispara uma exceção de o numeroHum for maior que o numeroDois
        */

        Scanner scr = new Scanner(System.in);
        System.out.println("Digite o primeiro parametro: ");
        int numeroHum = scr.nextInt();
        System.out.println("Digite o segundo parametro: ");
        int numeroDois = scr.nextInt();

        scr.close();

        try {
            contarInteracao(numeroHum, numeroDois);
        } catch (ParametrosInvalidosException e) {
            System.out.println("Dados inválido: o primeiro parametro e maior do que o segundo.");
        }       
    }

    static void contarInteracao(int paramentroHum, int paramentroDois) throws ParametrosInvalidosException {
            
        Boolean parametroExcepcional = paramentroHum > paramentroDois;

        if(parametroExcepcional){
           throw new ParametrosInvalidosException();
        } else {
            int numeroIteracoes = paramentroDois - paramentroHum;
            for(int i = 1; i <= numeroIteracoes; i++){
                System.out.println("Imprimindo o número: " + i);
            }
        }

        
    }
}