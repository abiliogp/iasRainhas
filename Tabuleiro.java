import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
    
/* 
 * Esta classe possui todos os metodos necessários de um tabuleiro para resolução do problema das 8 rainhas
 * Autores: Vanderson Oliveira,Abilio Parada e Eliane.
 */
public class Tabuleiro {
    private int position[];
    private int attack;
    
    public Tabuleiro(int entrada[]){
       this.position=(entrada);//verificar se vai pegar certo
       //metodo que verifica os ataques
    }

    Tabuleiro() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    /* Autor: Vanderson Oliveira.
     * Metodo get do numero de rainhas se atacando no tabuleiro
     * P@r@metros: {void}
     * Return:{int attack}
     */
    public int getAttack(){
    	return this.attack;
    }
   
    /*
     * Função q de avaliação
     */
    public int avalia_rainhas() {
        int []vet=this.position;
        int cont = 0; //contador de rainhas que se atacam
        for (int i = 0; i < 8; i++) {
            int x = 1;
            for (int j = i + 1; j < 8; j++) {  // avalia as diagonais à direita
                 
                if ((vet[j] == vet[i] + x) || (vet[j] == vet[i] - x) ||(vet[j]==vet[i])) {
                    cont++;
                }
                x++;
            }
            x = 1;
            for (int j = i - 1; j >= 0; j--) {  //avalia as diagonais à esquerda
              
                if ((vet[j] == vet[i] + x) || (vet[j] == vet[i] - x) || (vet[j] ==vet[i])) {
                    cont++;
                }
                x++;
            }
        }
        return cont;  //retorna quantas rainhas foram atacadas
    }
    /* Autor: Vanderson Oliveira.
	 * Metodo que retorna o vetor com o tabuleiro. 
	 * P@r@metros: {void}.
	 * Return: {position}.
	 */
    public int[] getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}
    
    public Tabuleiro expandeChildrens() {
        Tabuleiro tabFilho = new Tabuleiro();
         ArrayList<Object> arvore = null;
         int [] vetFilho;
         arvore.add(position);//aqui tem que ser o tabFilho pois precisamos de uma lista de objtos<Tabuleiro> (filhos)
        
        //gerar uma arvore com todos os filhos primeiro para depois cada algoritmo
         //analise com cada nodo da arvore, mas qual será o tamanho dessa arvore e 
         //que todos os nodos serão diferentes.
         
         
        return tabFilho;
    }

    /*
     * acho q temos q gerar um filho a cada vez a função é chamada
     * para está função ficar uniforme para todos algoritmos
     */
	public void gerarFilhos() {
		// TODO Auto-generated method stub
		
	}
        
        
     
    
    
}