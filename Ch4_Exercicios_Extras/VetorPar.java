/*
 */
package Ch4_Exercicios_Extras;

import java.util.Arrays;
import java.util.Scanner;

public class VetorPar {

    public static void main(String[] args) {

        int[] vetorOriginal = new int[30];
        int[] vetorAlterado = new int[30];
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite os valores do vetor (30 total)");
        // Atribui valores ao vetor original
        for (int i = 0; i < 30; i++) {

            vetorOriginal[i] = leitura.nextInt();

        }
        //Percorre o vetor original e efetua os calculos de acordo com o indice
        for (int i = 0; i < 30; i++) {
            if (i % 2 == 0) {

                vetorAlterado[i] = vetorOriginal[i] * 2;
            } else {
                vetorAlterado[i] = vetorOriginal[i] * 3;
            }
        }
        
        // Exibe os valores ao usuário
        System.out.println("O vetor original era: " + Arrays.toString(vetorOriginal));
        System.out.println("O vetor alterado é: " + Arrays.toString(vetorAlterado));
    }
}
