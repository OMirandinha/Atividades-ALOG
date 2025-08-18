/* Desenvolva um algoritmo que permita a leitura de um vetor de 30 números inteiros, e gere
um segundo vetor com os mesmos dados, só que de maneira invertida, ou seja, o primeiro
elemento ficará na última posição, o segundo na penúltima posição, e assim por diante.
 */
package Ch4_Exercicios_Extras;

import java.util.Arrays;
import java.util.Scanner;

public class VetorInvertido {

    public static void main(String[] args) {

        int[] vetorOriginal = new int[30];
        int[] vetorInvertido = new int[30];

        Scanner ler = new Scanner(System.in);

        //Preenche o vetor original
        System.out.println("Digite os valores: ");
        for (int i = 0; i < 30; i++) {
            vetorOriginal[i] = ler.nextInt();
        }

        // Inverte a posição dos valores
        for (int i = 0; i < 30; i++) {
                vetorInvertido[29-i] = vetorOriginal[i];            
        }

        System.out.println("O vetor invertido ficou como " + Arrays.toString(vetorInvertido));
        
        ler.close();
    }
}
