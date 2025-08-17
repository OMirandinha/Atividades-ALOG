package Ch4;
/*
Utilizando o conjunto de registros mostrado no exemplo anterior, definido para guardar
as baixas diárias no estoque de 500 produtos, elabore um algoritmo que leia 
o preço e o nome de todos os produtos e, como é o primeiro cadastro do estoque, 
armazene zero como baixa em todos os dias. Como estratégia de identificação dos 
produtos, faça com que o código seja atribuído automaticamente com o valor da 
posição do produto no vetor (o código do produto ficará sendo igual a posição
que seu registro ocupa no vetor).
*/
import java.util.Scanner;

class Produto {
    String nome;
    float preco;
    int codigo;
    int[] baixasDiarias = new int[6];
}

public class ExMatriz5 {
    public static void main(String[] args) {
        Produto[] estoque = new Produto[500];
        Scanner ler = new Scanner(System.in);

        System.out.println("CADASTRO DE ESTOQUE (até 500 produtos)");

        for (int i = 0; i < estoque.length; i++) {
            Produto p = new Produto();
            p.codigo = i; // Código = posição no vetor (conforme enunciado)

            System.out.print("\nDigite o nome do produto " + (i + 1) + ": ");
            p.nome = ler.nextLine();

            System.out.print("Digite o preço do produto " + p.nome + ": ");
            p.preco = ler.nextFloat();
            ler.nextLine(); // Limpa o buffer

            // Inicializa baixas diárias com zero
            for (int dia = 0; dia < p.baixasDiarias.length; dia++) {
                p.baixasDiarias[dia] = 0;
            }

            estoque[i] = p;
        }

        // Exibe todos os produtos cadastrados (após o loop)
        System.out.println("\nProdutos cadastrados:");
        for (Produto p : estoque) {
            if (p != null) { // Verifica se o produto foi cadastrado
                System.out.printf("Código: %d | Nome: %s | Preço: R$%.2f%n",
                                p.codigo, p.nome, p.preco);
            }
        }

        ler.close();
    }
}