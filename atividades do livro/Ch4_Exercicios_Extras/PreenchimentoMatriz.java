/*
 */
package Ch4_Exercicios_Extras;

import java.util.Scanner;

public class PreenchimentoMatriz {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int[][] matriz = new int[5][5];

        // Preenche a matriz
        System.out.println("Digite os 25 elementos da matriz 5x5: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("Elemento [%d][%d]: ", i, j);
                matriz[i][j] = leitura.nextInt();
            }
        }

        // Efetua a soma dos número ímpares
        int somaImpares = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matriz[i][j] % 2 != 0) {
                    somaImpares += matriz[i][j];
                }
            }
        }
        System.out.println("Soma dos números ímapraes" + somaImpares);
        
        // Efetua a soma de cada coluna
        System.out.println("Som das colunas");
        for (int j = 0; j < 5; j++){
            int somaColuna = 0;
            for (int i = 0; i < 5; i++) {
                somaColuna += matriz[i][j];
            }
            System.out.println("Coluna " + j + ": " + somaColuna);
        }
        
        // Edetuia a soma de cada linha
        System.out.println("Soma das linhas: ");
        for (int i = 0; i < 5; i++){
            int somaLinha = 0;
            for (int j = 0; j < 5; j++) {
                somaLinha += matriz[i][j];
            }
            System.out.println("Linha " + i + ": " + somaLinha);
        }
        
        leitura.close();
    }

}
