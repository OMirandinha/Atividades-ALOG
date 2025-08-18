package Ch4;

import java.util.Scanner;

class Produto {
    String nome;
    float preco;
    int codigo;
    int[] baixasDiarias = new int[6]; // Baixas de 6 dias
} 

public class ExMatriz6 {
    public static void main(String[] args) {
        Produto[] estoque = new Produto[500];
        Scanner ler = new Scanner(System.in);
        int totalCadastrados = 0;

        System.out.println("CADASTRO DE ESTOQUE (Digite 'sair' no nome para encerrar)");

        // Cadastro de produtos
        for (int i = 0; i < estoque.length; i++) {
            Produto p = new Produto();
            p.codigo = i;

            System.out.print("\nDigite o nome do produto " + (i + 1) + " (ou 'sair' para encerrar): ");
            String nome = ler.nextLine();
            
            if (nome.equalsIgnoreCase("sair")) {
                break;
            }
            
            p.nome = nome;

            System.out.print("Digite o preço do produto " + p.nome + ": ");
            p.preco = ler.nextFloat();
            ler.nextLine(); // Limpa o buffer

            // Cadastro das baixas diárias (opcional)
            System.out.println("Digite as baixas diárias (6 dias):");
            for (int dia = 0; dia < p.baixasDiarias.length; dia++) {
                System.out.print("Dia " + (dia + 1) + ": ");
                p.baixasDiarias[dia] = ler.nextInt();
            }
            ler.nextLine(); // Limpa o buffer

            estoque[i] = p;
            totalCadastrados++;
        }

        // Exibição dos produtos cadastrados
        System.out.println("\nProdutos cadastrados (" + totalCadastrados + " no total):");
        for (int i = 0; i < totalCadastrados; i++) {
            Produto p = estoque[i];
            System.out.printf("Código: %d | Nome: %s | Preço: R$%.2f%n",
                            p.codigo, p.nome, p.preco);
            
            // Opcional: mostrar baixas diárias
            System.out.print("Baixas diárias: ");
            for (int baixa : p.baixasDiarias) {
                System.out.print(baixa + " ");
            }
            System.out.println("\n");
        }

        // Encontrar o produto mais vendido
        Produto produtoMaisVendido = null;
        int maiorVendas = -1;

        for (int i = 0; i < totalCadastrados; i++) {
            Produto p = estoque[i];
            int totalBaixas = 0;
            
            for (int baixa : p.baixasDiarias) {
                totalBaixas += baixa;
            }
            
            if (totalBaixas > maiorVendas) {
                maiorVendas = totalBaixas;
                produtoMaisVendido = p;
            }
        }

        // Exibir resultado
        if (produtoMaisVendido != null) {
            System.out.printf("\nProduto mais vendido: %s (Código: %d) com %d unidades vendidas%n",
                            produtoMaisVendido.nome, produtoMaisVendido.codigo, maiorVendas);
        } else {
            System.out.println("\nNenhum produto cadastrado ou vendido.");
        }

        ler.close();
    }
}