/*
Baseado no mesmo contexto de biblioteca do exercício anterior, elabore um algoritmo
que permita a um funcionário da biblioteca exercer qualquer espécie de manipulação 
dos dados a partir de um código de livro.
*/
package Ch5;

import java.util.ArrayList;
import java.util.Scanner;

class Livro {
    String codigo;
    String titulo;
    String autor;
    ArrayList<String> assuntos;
    String editora;
    int ano;
    int edicao;

    public Livro(String codigo, String titulo, String autor, ArrayList<String> assuntos, String editora, int ano, int edicao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.assuntos = assuntos;
        this.editora = editora;
        this.ano = ano;
        this.edicao = edicao;
    }
}

public class ExArq2 {
    private static ArrayList<Livro> biblioteca = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Cadastro inicial de livros (opcional)
        inicializarBiblioteca();

        int opcao;
        do {
            System.out.println("\n=== SISTEMA DE GERENCIAMENTO DA BIBLIOTECA ===");
            System.out.println("1. Cadastrar novo livro");
            System.out.println("2. Buscar livro por código");
            System.out.println("3. Atualizar dados de um livro");
            System.out.println("4. Remover livro");
            System.out.println("5. Listar todos os livros");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            
            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    buscarLivro();
                    break;
                case 3:
                    atualizarLivro();
                    break;
                case 4:
                    removerLivro();
                    break;
                case 5:
                    listarLivros();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        
        scanner.close();
    }

    private static void inicializarBiblioteca() {
        ArrayList<String> assuntos1 = new ArrayList<>();
        assuntos1.add("Programação");
        assuntos1.add("Java");
        biblioteca.add(new Livro("L001", "Java para Iniciantes", "Ana Silva", assuntos1, "Editora Tech", 2023, 1));

        ArrayList<String> assuntos2 = new ArrayList<>();
        assuntos2.add("Literatura");
        assuntos2.add("Romance");
        biblioteca.add(new Livro("L002", "Amor em Tempos Modernos", "Carlos Andrade", assuntos2, "Editora Letras", 2022, 2));
    }

    private static void cadastrarLivro() {
        System.out.println("\n--- CADASTRO DE NOVO LIVRO ---");
        
        System.out.print("Código do livro: ");
        String codigo = scanner.nextLine();
        
        if (buscarPorCodigo(codigo)) {
            System.out.println("Já existe um livro com este código!");
            return;
        }
        
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        
        ArrayList<String> assuntos = new ArrayList<>();
        System.out.println("Assuntos (digite um por linha, 'fim' para terminar):");
        String assunto;
        while (true) {
            assunto = scanner.nextLine();
            if (assunto.equalsIgnoreCase("fim")) break;
            assuntos.add(assunto);
        }
        
        System.out.print("Editora: ");
        String editora = scanner.nextLine();
        
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        
        System.out.print("Edição: ");
        int edicao = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        biblioteca.add(new Livro(codigo, titulo, autor, assuntos, editora, ano, edicao));
        System.out.println("Livro cadastrado com sucesso!");
    }

    private static boolean buscarPorCodigo(String codigo) {
        for (Livro livro : biblioteca) {
            if (livro.codigo.equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }

    private static void buscarLivro() {
        System.out.print("\nDigite o código do livro: ");
        String codigo = scanner.nextLine();
        
        for (Livro livro : biblioteca) {
            if (livro.codigo.equalsIgnoreCase(codigo)) {
                exibirLivro(livro);
                return;
            }
        }
        
        System.out.println("Livro não encontrado!");
    }

    private static void atualizarLivro() {
        System.out.print("\nDigite o código do livro a ser atualizado: ");
        String codigo = scanner.nextLine();
        
        for (Livro livro : biblioteca) {
            if (livro.codigo.equalsIgnoreCase(codigo)) {
                System.out.println("\nDados atuais do livro:");
                exibirLivro(livro);
                
                System.out.println("\nDigite os novos dados (deixe em branco para manter o atual):");
                
                System.out.print("Título [" + livro.titulo + "]: ");
                String novoTitulo = scanner.nextLine();
                if (!novoTitulo.isEmpty()) livro.titulo = novoTitulo;
                
                System.out.print("Autor [" + livro.autor + "]: ");
                String novoAutor = scanner.nextLine();
                if (!novoAutor.isEmpty()) livro.autor = novoAutor;
                
                System.out.println("Assuntos atuais: " + String.join(", ", livro.assuntos));
                System.out.println("Deseja alterar os assuntos? (s/n)");
                if (scanner.nextLine().equalsIgnoreCase("s")) {
                    livro.assuntos.clear();
                    System.out.println("Digite os novos assuntos (um por linha, 'fim' para terminar):");
                    String assunto;
                    while (true) {
                        assunto = scanner.nextLine();
                        if (assunto.equalsIgnoreCase("fim")) break;
                        livro.assuntos.add(assunto);
                    }
                }
                
                System.out.print("Editora [" + livro.editora + "]: ");
                String novaEditora = scanner.nextLine();
                if (!novaEditora.isEmpty()) livro.editora = novaEditora;
                
                System.out.print("Ano [" + livro.ano + "]: ");
                String novoAno = scanner.nextLine();
                if (!novoAno.isEmpty()) livro.ano = Integer.parseInt(novoAno);
                
                System.out.print("Edição [" + livro.edicao + "]: ");
                String novaEdicao = scanner.nextLine();
                if (!novaEdicao.isEmpty()) livro.edicao = Integer.parseInt(novaEdicao);
                
                System.out.println("Livro atualizado com sucesso!");
                return;
            }
        }
        
        System.out.println("Livro não encontrado!");
    }

    private static void removerLivro() {
        System.out.print("\nDigite o código do livro a ser removido: ");
        String codigo = scanner.nextLine();
        
        for (int i = 0; i < biblioteca.size(); i++) {
            if (biblioteca.get(i).codigo.equalsIgnoreCase(codigo)) {
                System.out.println("Livro a ser removido:");
                exibirLivro(biblioteca.get(i));
                
                System.out.print("Confirmar remoção? (s/n): ");
                if (scanner.nextLine().equalsIgnoreCase("s")) {
                    biblioteca.remove(i);
                    System.out.println("Livro removido com sucesso!");
                } else {
                    System.out.println("Remoção cancelada.");
                }
                return;
            }
        }
        
        System.out.println("Livro não encontrado!");
    }

    private static void listarLivros() {
        System.out.println("\n--- LISTA DE TODOS OS LIVROS ---");
        if (biblioteca.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        
        for (Livro livro : biblioteca) {
            exibirLivro(livro);
            System.out.println("-----------------------------");
        }
    }

    private static void exibirLivro(Livro livro) {
        System.out.println("\nCódigo: " + livro.codigo);
        System.out.println("Título: " + livro.titulo);
        System.out.println("Autor: " + livro.autor);
        System.out.println("Assuntos: " + String.join(", ", livro.assuntos));
        System.out.println("Editora: " + livro.editora);
        System.out.println("Ano: " + livro.ano);
        System.out.println("Edição: " + livro.edicao);
    }
}