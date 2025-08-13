/* Desenvolva um algoritmo que leia um vetor de 20 posições inteiras 
e o coloque em ordem crescente, utilizando a seguinte estratégia de ordenação:

Selecione o elemento do vetor de 20 posições que apresenta o menor valor;

Troque este elemento pelo primeiro;

Repita estas operações, envolvendo agora apenas os 19 elementos restantes 
(selecionando o de menor valor com a segunda posição), depois os 18 elementos 
(trocando o de menor valor com a terceira posição), depois os 17, os 16
e assim por diante, até restar um único elemento, o maior deles.

 */
package Ch4;

import java.util.Arrays;
import java.util.Scanner;

public class ExVetores3 {
    public static void main(String[] args) {
        
    
    Scanner leitura = new Scanner(System.in);
    
    //Inicialização das variáveis
    int [] original = new int [20];
    int [] ordenado = new int [20];
    
    
    //Preenchimento do vetor original
    System.out.println("Digite 20 valores inteiros: ");
    for (int i = 0; i < 20; i++){
        original[i] = leitura.nextInt();
    }
    
    int[] copia = original.clone(); //copia os valores do vetor original para um novo 
 
    //Loop para ordenar através de seleção
    for(int i = 0; i < 20; i++){
        int menor = i;
        
    //Loop para verificar qual é o menor valor do vetor original
        for (int j = i + 1; j < original.length; j++){
            if(copia[j] < copia[menor]) {
                menor = j; //Adiciona o valor mais baixo ao um vetor novo
            }
    }        
        // Adiciona os valores ao vetor ordenado
        ordenado[i] = copia[menor];
        
        // remove o valor já ordenado, trocando por um atual
        int temp = copia[i];
        copia[i] = copia[menor];
        copia[menor] = temp;
        
       
    }
    
   System.out.println("Vetor ordenado: " + Arrays.toString(ordenado));
    leitura.close();
    
    
   } 
}
