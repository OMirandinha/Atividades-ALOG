/*
 O tempo que um determinado avião dispensa para percorrer o trecho entre duas localidades distintas está disponível através da seguinte tabela:


     1   2   3   4   5   6   7
1  | -   02  11  06  15  11  01
2  | 02  -   07  12  04  02  15
3  | 11  07  -   11  08  03  13
4  | 06  12  11  -   10  02  01
5  | 15  04  08  10  -   05  13
6  | 11  02  03  02  05  -   14
7  | 01  15  13  01  13  14  -

a) Construa um algoritmo que:

Leia a tabela de tempos entre cidades.

Permita ao usuário consultar o tempo entre duas cidades (origem e destino).

Repita as consultas até que o usuário digite duas cidades iguais (ex: 3 3).

b) Desenvolva um algoritmo que:

Permita ao usuário informar uma sequência de cidades (ex: 1 → 3 → 5 → 2).

Calcule e imprima o tempo total do percurso.

Encerre quando uma cidade 0 for informada.

d) Escreva um algoritmo para planejamento de roteiro de férias:

O usuário informa 4 cidades: origem, alternativa1, alternativa2, destino.

O algoritmo deve comparar os dois possíveis percursos:

Opção 1: origem → alternativa1 → destino

Opção 2: origem → alternativa2 → destino

Retornar qual das alternativas resulta no menor tempo total de viagem.
 */
package Ch4;

import java.util.Scanner;

public class ExMatriz2 {
    
 // Matriz de tempos entre cidades (índices 1-7)
    private static final int[][] TEMPOS = {
        {0,  2, 11,  6, 15, 11,  1},  // Cidade 1
        {2,  0,  7, 12,  4,  2, 15},  // Cidade 2
        {11, 7,  0, 11,  8,  3, 13},  // Cidade 3
        {6, 12, 11,  0, 10,  2,  1},  // Cidade 4
        {15, 4,  8, 10,  0,  5, 13},  // Cidade 5
        {11, 2,  3,  2,  5,  0, 14},  // Cidade 6
        {1, 15, 13,  1, 13, 14,  0}   // Cidade 7
    };

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE CONSULTA DE TEMPOS DE VOO ===");
        System.out.println("1. Consultar tempo entre duas cidades");
        System.out.println("2. Calcular tempo total de um percurso");
        System.out.println("3. Planejar roteiro de férias");
        System.out.print("Escolha uma opção: ");
        
        int opcao = ler.nextInt();
        
        switch(opcao) {
            case 1:
                parteA(ler);
                break;
            case 2:
                parteB(ler);
                break;
            case 3:
                parteD(ler);
                break;
            default:
                System.out.println("Opção inválida!");
        }
        
        ler.close();
    }

    // Parte a: Consulta de tempo entre duas cidades
    public static void parteA(Scanner ler) {
        System.out.println("\nCONSULTA DE TEMPO ENTRE CIDADES (Digite duas iguais para sair)");
        
        while(true) {
            System.out.print("Informe a cidade de origem e destino (1-7): ");
            int origem = ler.nextInt();
            int destino = ler.nextInt();
            
            if(origem == destino) {
                System.out.println("Consulta encerrada.");
                break;
            }
            
            if(origem < 1 || origem > 7 || destino < 1 || destino > 7) {
                System.out.println("Cidade inválida! Digite valores entre 1 e 7.");
                continue;
            }
            
            int tempo = TEMPOS[origem-1][destino-1];
            System.out.println("Tempo entre cidade " + origem + " e cidade " + 
                              destino + ": " + tempo + " horas");
        }
    }

    // Parte b: Cálculo de tempo total de um percurso
    public static void parteB(Scanner ler) {
        System.out.println("\nCALCULAR TEMPO TOTAL DE PERCURSO (Digite 0 para encerrar)");
        System.out.println("Informe a sequência de cidades (1-7):");
        
        int cidadeAnterior = -1;
        int tempoTotal = 0;
        boolean primeiraCidade = true;
        
        while(true) {
            int cidade = ler.nextInt();
            
            if(cidade == 0) {
                System.out.println("Tempo total do percurso: " + tempoTotal + " horas");
                break;
            }
            
            if(cidade < 1 || cidade > 7) {
                System.out.println("Cidade inválida! Digite valores entre 1 e 7.");
                continue;
            }
            
            if(!primeiraCidade) {
                tempoTotal += TEMPOS[cidadeAnterior-1][cidade-1];
            }
            
            cidadeAnterior = cidade;
            primeiraCidade = false;
        }
    }

    // Parte d: Planejamento de roteiro de férias
    public static void parteD(Scanner ler) {
        System.out.println("\nPLANEJAMENTO DE ROTEIRO DE FÉRIAS");
        System.out.print("Informe a cidade de origem (1-7): ");
        int origem = ler.nextInt();
        
        System.out.print("Informe a primeira cidade de descanso (1-7): ");
        int descanso1 = ler.nextInt();
        
        System.out.print("Informe a segunda cidade de descanso (1-7): ");
        int descanso2 = ler.nextInt();
        
        System.out.print("Informe o destino final (1-7): ");
        int destino = ler.nextInt();
        
        // Calcula tempo para ambas as opções
        int tempoOpcao1 = TEMPOS[origem-1][descanso1-1] + TEMPOS[descanso1-1][destino-1];
        int tempoOpcao2 = TEMPOS[origem-1][descanso2-1] + TEMPOS[descanso2-1][destino-1];
        
        System.out.println("\nOpção 1 (via cidade " + descanso1 + "): " + tempoOpcao1 + " horas");
        System.out.println("Opção 2 (via cidade " + descanso2 + "): " + tempoOpcao2 + " horas");
        
        if(tempoOpcao1 < tempoOpcao2) {
            System.out.println("Melhor opção: Via cidade " + descanso1);
        } else if(tempoOpcao2 < tempoOpcao1) {
            System.out.println("Melhor opção: Via cidade " + descanso2);
        } else {
            System.out.println("Ambas as opções têm o mesmo tempo de viagem");
        }
    }
}
