package Ch4;
/*
Usando como base o Algoritmo 4.10, que mostra um vetor de 44 posições com os dados
dos passageiros de um ônibus, altere o processamento de forma que seja mostrada a média
de idade dos passageiros e o nome daqueles acima desta média.
*/
import java.util.Scanner;

public class ExMatriz4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nomes = new String[44];
        int[] idades = new int[44];
        int totalPassageiros = 0;

        System.out.println("Cadastro de Passageiros (Máximo 44)");
        System.out.println("Digite 'sair' no nome para encerrar.\n");

        // Loop para entrada de dados
        for (int i = 0; i < 44; i++) {
            System.out.print("Nome do passageiro " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            
            if (nome.equalsIgnoreCase("sair")) {
                break;
            }
            
            System.out.print("Idade de " + nome + ": ");
            int idade = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado
            
            nomes[i] = nome;
            idades[i] = idade;
            totalPassageiros++;
        }

        // Cálculo da média
        if (totalPassageiros > 0) {
            int somaIdades = 0;
            for (int i = 0; i < totalPassageiros; i++) {
                somaIdades += idades[i];
            }
            int mediaIdade = somaIdades / totalPassageiros;

            System.out.println("\nMédia de idade: " + mediaIdade);
            System.out.println("Passageiros acima da média:");

            // Identificação dos passageiros acima da média
            for (int i = 0; i < totalPassageiros; i++) {
                if (idades[i] > mediaIdade) {
                    System.out.println(nomes[i] + " - " + idades[i] + " anos");
                }
            }
        } else {
            System.out.println("Nenhum passageiro cadastrado.");
        }

        scanner.close();
    }
}