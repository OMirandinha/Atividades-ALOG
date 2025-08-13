package ch4;
/*Elabore um algoritmo que,
dados dois vetores inteiros de 20 posições, 
efetue as respectivas operações indicadas por outro vetor de 20 posições 
de caracteres também fornecido pelo usuário, contendo as quatro operações 
aritméticas em qualquer combinação e armazenando os resultados 
em um terceiro vetor. */
import java.util.Scanner;

public class ExVetores1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Vetores de entrada
        int[] vetorA = new int[20];
        int[] vetorB = new int[20];
        char[] operacoes = new char[20];
        int[] resultados = new int[20];
        
        // Preencher vetorA
        System.out.println("Digite os 20 elementos do vetor A:");
        for (int i = 0; i < 20; i++) {
            vetorA[i] = scanner.nextInt();
        }
        
        // Preencher vetorB
        System.out.println("Digite os 20 elementos do vetor B:");
        for (int i = 0; i < 20; i++) {
            vetorB[i] = scanner.nextInt();
        }
        
        // Preencher vetor de operações
        System.out.println("Digite as 20 operações (+, -, *, /):");
        for (int i = 0; i < 20; i++) {
            operacoes[i] = scanner.next().charAt(0);
        }
        
        // Realizar operações e armazenar resultados
        for (int i = 0; i < 20; i++) {
            switch (operacoes[i]) {
                case '+':
                    resultados[i] = vetorA[i] + vetorB[i];
                    break;
                case '-':
                    resultados[i] = vetorA[i] - vetorB[i];
                    break;
                case '*':
                    resultados[i] = vetorA[i] * vetorB[i];
                    break;
                case '/':
                    if (vetorB[i] != 0) {
                        resultados[i] = vetorA[i] / vetorB[i];
                    } else {
                        System.out.println("Divisão por zero na posição " + i + ". Resultado definido como 0.");
                        resultados[i] = 0;
                    }
                    break;
                default:
                    System.out.println("Operação inválida na posição " + i + ". Resultado definido como 0.");
                    resultados[i] = 0;
            }
        }
        
        // Exibir resultados
        System.out.println("\nResultados das operações:");
        for (int i = 0; i < 20; i++) {
            System.out.println("Posição " + i + ": " + vetorA[i] + " " + operacoes[i] + " " + vetorB[i] + " = " + resultados[i]);
        }
        
        scanner.close();
    }
}
