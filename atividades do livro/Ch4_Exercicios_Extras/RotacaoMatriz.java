/*
Leia números inteiros para preencher uma matriz 10x10.

Gire os elementos dessa matriz em 90° no sentido horário, de modo que:

A primeira coluna se torne a última linha

A segunda coluna se torne a penúltima linha

(...)

A última coluna se torne a primeira linha
 */
package Ch4_Exercicios_Extras;

import java.util.Scanner;

public class RotacaoMatriz {
    public static void main(String[] args) {
 Scanner ler = new Scanner(System.in);
        int tamanho = 10;
        int[][] matrizOriginal = new int[tamanho][tamanho];
        int[][] matrizRotacionada = new int[tamanho][tamanho];
        
        // Leitura da matriz original
        System.out.println("Digite os elementos da matriz 10x10:");
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.printf("Elemento [%d][%d]: ", i, j);
                matrizOriginal[i][j] = ler.nextInt();
            }
        }
        
        // Rotação de 90° no sentido horário
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matrizRotacionada[j][tamanho - 1 - i] = matrizOriginal[i][j];
            }
        }
        
        // Exibição da matriz original
        System.out.println("\nMatriz Original:");
        imprimirMatriz(matrizOriginal);
        
        // Exibição da matriz rotacionada
        System.out.println("\nMatriz Rotacionada 90° no sentido horário:");
        imprimirMatriz(matrizRotacionada);
        
        ler.close();
    }
    
    // Método para imprimir uma matriz
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }
    }
}
