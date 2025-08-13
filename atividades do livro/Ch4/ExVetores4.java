/* Desenvolva um algoritmo que leia um vetor de 20 posições inteiras
e o coloque em ordem crescente, utilizando como estratégia de ordenação
a comparação de pares de elementos adjacentes, permutando-os quando estiverem
fora de ordem, até que todos estejam ordenados.
 */
package Ch4;

import java.util.Arrays;
import java.util.Scanner;

public class ExVetores4 {
    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        int[] valores = new int[20];  
        int[] comparar = new int[20]; 
        
        System.out.println("Digite 20 valores inteiros:"); 
        for (int i = 0; i < 20; i++){  
            valores[i] = ler.nextInt();
        }
        
        // Copia os valores de um vetor para o outro
        comparar = valores.clone();
        
        // Método de comparação usando loop for
        for (int i = 0; i < comparar.length - 1; i++) {
            for (int j = 0; j < comparar.length - 1 - i; j++) {
                if (comparar[j] > comparar[j + 1]) {
                    int val = comparar[j];
                    comparar[j] = comparar[j + 1];
                    comparar[j + 1] = val;
                }
            }
        }
        
        System.out.println("Vetor ordenado: " + Arrays.toString(comparar));
        ler.close();
    } 
}
