/*
Escreva um algoritmo que leia a matriz de três dimensões caracter do Exercício 2.2, item a.

Depois faça um deslocamento à direita das matrizes bidimensionais componentes, 
ou seja, coloque os dados da matriz bidimensional da terceira dimensão = 1 
na terceira dimensão = 2, da 2 na 3, da 3 na 4 e da 4 na 1, sem perder os dados.
 */
package Ch4;

import java.util.Scanner;


public class ExMatriz1 {
    
public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        // Definindo as dimensões da matriz (3x3x4 como exemplo)
        int dim1 = 3, dim2 = 3, dim3 = 4;
        char[][][] matriz = new char[dim1][dim2][dim3];
        
        // Leitura da matriz tridimensional
        System.out.println("Digite os elementos da matriz 3D (3x3x4):");
        for (int i = 0; i < dim1; i++) {
            for (int j = 0; j < dim2; j++) {
                for (int k = 0; k < dim3; k++) {
                    System.out.printf("Elemento [%d][%d][%d]: ", i, j, k);
                    matriz[i][j][k] = ler.next().charAt(0);
                }
            }
        }
        
        // Exibindo a matriz original
        System.out.println("\nMatriz original:");
        exibirMatriz(matriz);
        
        // Realizando o deslocamento circular à direita das matrizes bidimensionais
        char[][][] matrizDeslocada = deslocarMatrizes(matriz);
        
        // Exibindo a matriz após o deslocamento
        System.out.println("\nMatriz após deslocamento:");
        exibirMatriz(matrizDeslocada);
        
        ler.close();
    }
    
    // Método para deslocar as matrizes bidimensionais
    public static char[][][] deslocarMatrizes(char[][][] matriz) {
        int dim3 = matriz[0][0].length;
        char[][][] novaMatriz = new char[matriz.length][matriz[0].length][dim3];
        
        // Realiza o deslocamento circular
        for (int k = 0; k < dim3; k++) {
            int novaPosicao = (k + 1) % dim3; // Deslocamento à direita (k+1) com wrap-around
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    novaMatriz[i][j][novaPosicao] = matriz[i][j][k];
                }
            }
        }
        
        return novaMatriz;
    }
    
    // Método para exibir a matriz tridimensional
    public static void exibirMatriz(char[][][] matriz) {
        for (int k = 0; k < matriz[0][0].length; k++) {
            System.out.println("Matriz bidimensional " + (k + 1) + ":");
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
