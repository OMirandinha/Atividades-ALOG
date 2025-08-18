/* Utilizando o problema da biblioteca apresentado no início deste capítulo (Figura 5.1), 
elabore um algoritmo que permita a um usuário da biblioteca obter a listagem com 
as informações sobre todos os livros que tratam do assunto que ele está procurando.
 */
package Ch5;

import java.util.ArrayList;
import java.util.Scanner;

public class ExArq1 {
    public static void main(String[] args) {
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
        
        Scanner ler = new Scanner (System.in);
        
        // Cadastro de livros como exemplo
        ArrayList<Livro> biblioteca = new ArrayList<>();
        ArrayList<String> assuntosLivro1 = new ArrayList<>();
        assuntosLivro1.add("Programação");
        assuntosLivro1.add("Java");
        biblioteca.add(new Livro("Loo1", "Java para Iniciantes", "Autor A", assuntosLivro1, "Editora X", 2022, 3));
        
           
        ArrayList<String> assuntosLivro2 = new ArrayList<>();
        assuntosLivro2.add("Programação");
        assuntosLivro2.add("Python");
        biblioteca.add(new Livro("L002", "Python Avançado", "Autor B", assuntosLivro2, "Editora Y", 2021, 2));
        
        ArrayList<String> assuntosLivro3 = new ArrayList<>();
        assuntosLivro3.add("Matemática");
        assuntosLivro3.add("Álgebra");
        biblioteca.add(new Livro("L003", "Álgebra Linear", "Autor C", assuntosLivro3, "Editora Z", 2020, 1));
        
        System.out.println("SISTEMA DE BUSCA DA BIBLIOTECA");
        System.out.println("Digite o assunto que deseja buscar: ");
        String assuntoBusca = ler.nextLine();
        
        // Busca e exibi os resultados
        System.out.println("Resultados da busca sobre " + assuntoBusca);
        
        boolean encontrou = false;
        
        for (Livro livro : biblioteca) {
            if (livro.assuntos.contains(assuntoBusca)){
                 System.out.println("Código: " + livro.codigo);
                System.out.println("Título: " + livro.titulo);
                System.out.println("Autor: " + livro.autor);
                System.out.println("Assuntos: " + String.join(", ", livro.assuntos));
                System.out.println("Editora: " + livro.editora + " | Ano: " + livro.ano + " | Edição: " + livro.edicao);
                encontrou = true;
            }
        }
        
        if (!encontrou) {
            System.out.println("Nenhum livro encontrado sobre este assunto");
        }
        
        ler.close();
    }
}
