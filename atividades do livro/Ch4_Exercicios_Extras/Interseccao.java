package Ch4_Exercicios_Extras;
/*
Construa um algoritmo que permita informar dados para 2 vetores inteiros 
de 20 posições, e apresente a intersecção dos vetores. Lembrando que
intersecção são os elementos repetidos em ambos os vetores, mas sem repetição 
(cada número pode aparecer uma única vez no resultado).
*/
import java.util.Scanner;

public class Interseccao {

    public static void main(String[] args) {
        int[] vetorA = new int[20];
        int[] vetorB = new int[20];
        int[] interseccao = new int[20]; // Corrigido: vetor declarado
        int tamanhoInterseccao = 0;

        Scanner ler = new Scanner(System.in);

        // Preenchimento dos vetores
        System.out.println("Digite os valores do vetor A");
        for (int i = 0; i < 20; i++) {
            vetorA[i] = ler.nextInt();
        }

        System.out.println("Digite os valores do vetor B");
        for (int i = 0; i < 20; i++) {
            vetorB[i] = ler.nextInt();
        }

        // Percorre os vetores e identifica valores em comum
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (vetorA[i] == vetorB[j]) {
                    // Verifica se o valor já está na intersecção
                    boolean jaExiste = false;
                    for (int k = 0; k < tamanhoInterseccao; k++) {
                        if (interseccao[k] == vetorA[i]) {
                            jaExiste = true;
                            break;
                        }
                    }
                    if (!jaExiste) {
                        interseccao[tamanhoInterseccao++] = vetorA[i];
                    }
                }
            }
        }

        // Exibe os resultados
        System.out.print("Intersecção: ");
        for (int i = 0; i < tamanhoInterseccao; i++) {
            System.out.print(interseccao[i]);
            if (i < tamanhoInterseccao - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(); // Pula linha no final
        
        ler.close();
    }
}