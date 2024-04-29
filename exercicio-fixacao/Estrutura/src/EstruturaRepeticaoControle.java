/*
 * Exercícios retirados do livro da Caelum de Java.
 * 1-) Imprima todos os números de 150 a 1500 (inclusive).
 * 2-) Imprima a soma de 1 até 1000 (inclusive).
 *  3-) Imprima todos os múltiplos de 3, entre 1 e 100 (inclusive).
 * 4-) Imprima todos os números entre 1 e 100 (inclusive) dizendo se ele é ou não é múltiplo de 3. (dica: use o operador de resto: %)
 */

public class EstruturaRepeticaoControle {
    public static void main(String[] args) throws Exception {
        mostrarNumerosDe150A1500();
        somarNumeroDe1A1000();
        imprimirDivisivelPor3();
        imprimirDe1A100VerificaDivisivelPor3();
    }
    
    static void mostrarNumerosDe150A1500(){
        for(int i = 150; i <= 1500; i++){
            System.out.println(i);
        }
    }

    static void somarNumeroDe1A1000(){
        int i = 1;
        int somaDeGauss = 0;

        while (i <= 1000) {
            somaDeGauss += i;
            i++;
        }

        System.out.println("A soma de 1 a 1000 inclusive é: " + somaDeGauss);
    }

    static void imprimirDivisivelPor3(){
        for(int i = 1; i <= 100; i++){
            if( i % 3 == 0){
                System.out.println("Multiplo de 3: " + i);
            }
        }
    }

    static void imprimirDe1A100VerificaDivisivelPor3(){
        for(int i = 1; i <= 100; i++){
            if( i % 3 == 0){
                System.out.println("Numero: " + i + " " + " é divisível por 3");
            }
            else{
                System.out.println("Numero: " + i + " " + " não é divisível por 3");  
            }
        }
    }
}
