package Ch4;

/* 
    Com base em seu conhecimento, defina um registro para um cheque bancário
*/

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExMatriz3 {
    
    public static void main(String[] args) {
        // Inicializa os componentes principais
        Scanner leitura = new Scanner(System.in);
        GerenciadorCheques gerenciador = new GerenciadorCheques();
        
        int opcao;
        do {
            // Menu principal do sistema
            System.out.println("\n --- SISTEMA DE REGISTRO DE CHEQUES ---");
            System.out.println("1. Cadastrar novo cheque");
            System.out.println("2. Listar todos os cheques");
            System.out.println("3. Buscar cheque por número");
            System.out.println("4. Calcular total de cheques por banco");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = leitura.nextInt();
            leitura.nextLine(); // Limpa o buffer do scanner
            
            // Processa a opção selecionada pelo usuário
            switch(opcao) {
                case 1:
                    cadastrarCheque(leitura, gerenciador);
                    break;
                    
                case 2:
                    gerenciador.listarCheques();
                    break;
                    
                case 3:
                    buscarChequePorNumero(leitura, gerenciador);
                    break;
                    
                case 4:
                    calcularTotalPorBanco(leitura, gerenciador);
                    break;
                    
                case 0:
                    System.out.println("Saindo do sistema... ");
                    break;
                    
                default: 
                    System.out.println("Opção inválida, digite outro valor.");    
            }
        } while(opcao != 0); // Repete até o usuário escolher sair
        
        leitura.close(); // Fecha o scanner para liberar recursos
    }
    
    // Método para cadastrar um novo cheque no sistema
    private static void cadastrarCheque(Scanner leitura, GerenciadorCheques gerenciador) {
        System.out.println("\nCADASTRO DE NOVO CHEQUE");
        
        // Coleta os dados do cheque
        System.out.print("Número do cheque: ");
        String numero = leitura.nextLine();
        
        System.out.print("Nome do beneficiário: ");
        String beneficiario = leitura.nextLine();
        
        System.out.print("Valor do cheque: ");
        double valor = leitura.nextDouble();
        leitura.nextLine(); // Limpa o buffer
        
        System.out.print("Número do banco: ");
        int banco = leitura.nextInt();
        leitura.nextLine(); // Limpa o buffer
        
        System.out.print("Data de emissão (dd/MM/yyyy): ");
        String dataStr = leitura.nextLine();
        
        try {
            // Converte a string de data para objeto Date
            Date dataEmissao = new SimpleDateFormat("dd/MM/yyyy").parse(dataStr);
            
            // Cria o novo cheque e adiciona ao gerenciador
            Cheque novoCheque = new Cheque(numero, beneficiario, valor, banco, dataEmissao);
            gerenciador.adicionarCheque(novoCheque);
            System.out.println("Cheque cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro no formato da data! Use dd/MM/yyyy");
        }
    }
    
    // Busca um cheque pelo número e exibe seus dados
    private static void buscarChequePorNumero(Scanner leitura, GerenciadorCheques gerenciador) {
        System.out.print("\nDigite o número do cheque: ");
        String numero = leitura.nextLine();
        
        // Busca o cheque no gerenciador
        Cheque cheque = gerenciador.buscarCheque(numero);
        
        if(cheque != null) {
            System.out.println("\nCHEQUE ENCONTRADO:");
            System.out.println(cheque); // Usa o toString() da classe Cheque
        } else {
            System.out.println("Cheque não encontrado.");
        }
    }
    
    // Calcula o valor total dos cheques de um determinado banco
     
    private static void calcularTotalPorBanco(Scanner leitura, GerenciadorCheques gerenciador) {
        System.out.print("\nDigite o número do banco: ");
        int banco = leitura.nextInt();
        
        // Obtém e exibe o total
        double total = gerenciador.calcularTotalPorBanco(banco);
        System.out.println("Total de cheques do banco " + banco + ": R$ " + total);
    }
}

// Classe que representa um cheque bancário com todos seus atributos
class Cheque {
    private String numero;
    private String beneficiario;
    private double valor;
    private int banco;
    private Date dataEmissao;
    
    public Cheque(String numero, String beneficiario, double valor, int banco, Date dataEmissao) {
        this.numero = numero;
        this.beneficiario = beneficiario;
        this.valor = valor;
        this.banco = banco;
        this.dataEmissao = dataEmissao;
    }
    
    // Métodos getters para acessar os atributos privados
    public String getNumero() { return numero; }
    public String getBeneficiario() { return beneficiario; }
    public double getValor() { return valor; }
    public int getBanco() { return banco; }
    public Date getDataEmissao() { return dataEmissao; }

    // Retorna uma representação em string formatada do cheque
     
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Número: " + numero + 
               "\nBeneficiário: " + beneficiario + 
               "\nValor: R$ " + String.format("%.2f", valor) + 
               "\nBanco: " + banco + 
               "\nData de emissão: " + sdf.format(dataEmissao);
    }
}

// Classe responsável por gerenciar a coleção de cheques

class GerenciadorCheques {
    private java.util.List<Cheque> cheques = new java.util.ArrayList<>();

    /**
     * Adiciona um novo cheque à lista
     * @param cheque Objeto Cheque a ser adicionado
     */
    public void adicionarCheque(Cheque cheque) {
        cheques.add(cheque);
    }

    // Lista todos os cheques cadastrados no sistema
     
    public void listarCheques() {
        if(cheques.isEmpty()) {
            System.out.println("Nenhum cheque cadastrado!");
            return;
        }
        
        System.out.println("\nLISTA DE CHEQUES:");
        for(Cheque cheque : cheques) {
            System.out.println(cheque);
            System.out.println("-------------------");
        }
    }

    // Busca um cheque pelo número
    public Cheque buscarCheque(String numero) {
        for(Cheque cheque : cheques) {
            if(cheque.getNumero().equals(numero)) {
                return cheque;
            }
        }
        return null;
    }

    // Calcula o valor total dos cheques de um determinado banco
    public double calcularTotalPorBanco(int banco) {
        double total = 0;
        for(Cheque cheque : cheques) {
            if(cheque.getBanco() == banco) {
                total += cheque.getValor();
            }
        }
        return total;
    }
}