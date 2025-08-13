package Ch4;
/*Altere o exemplo de soma de vetores para que este realize a seguinte operação:
o produto do primeiro vetor pelo inverso do segundo, armazenado a partir 
do centro para as bordas, de modo alternado. 
O vetor é de reais e possui 20 posições. */
import java.util.Scanner;

public class ExVetores2 {
    public static void main(String[] args) {
        
    
    double[] vetorA = new double [20];
    double[] vetorB = new double [20];
    double[] resultados = new double [20];
    
    Scanner leitura = new Scanner(System.in);
    
    //Preenchimento dos vetores
    System.out.println("Digite os valores do vetor A");
    for (int i = 0; i < 20; i++){
        vetorA[i] = leitura.nextDouble();
    }
    
    System.out.println("Digite os valores do vetor B");
    for (int i = 0; i < 20; i++){
        vetorB[i] = leitura.nextDouble();
    }
    
    //Cálculo do produto de A pelo inverso de B e armazenamento alternado
    int centrodireita = 10;
    int centroesquerda = 9;
    boolean trocadelugar = false; // <- variável do controle de alternância

    for (int i = 0; i < 20; i++) {
        double inversoB = 1.0 / vetorB[i]; // Calcula o inverso de B
        double valor = vetorA[i] * inversoB;
        
        //armazena o valor respectivo no centro do vetor e alterna as bordas
        if (trocadelugar && centroesquerda >= 0){
        resultados[centroesquerda] = valor;
        centroesquerda--;
    } else if (centrodireita < 20){
        resultados[centrodireita] = valor;
        centrodireita++;
        
    }
        trocadelugar = !trocadelugar; //alterna o lado do vetor
    }
    //Exibe o vetor dos resultados
        System.out.println("\nVetor resultado: ");
        for (int i = 0; i < 20; i++){
            System.out.printf("Posição %2d: %.2f\n", i, resultados[i]);
        }
        
        leitura.close();
    }
}
