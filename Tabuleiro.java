import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
    
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vanderson
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
    /*
     * Metodo get do numero de rainhas se atacando no tabuleiro
     */
    public int getAttack(){
    	return this.attack;
    }
    
    
    /*
     * Metodo responsavel por contar o numero de rainhas se atacando e setar 
     * o valor de attack 
     * P@rametros: void
     * Return: void
     */
    public void attackingqueen(){
        //implementar
    }
    public void Aestrela(){
    	
    }
    
    //Precisa testar.......................
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
	public int[] getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}
    public Tabuleiro expandeChildrens() {
        Tabuleiro tabFilho = new Tabuleiro();
         ArrayList<Object> arvore = null;
         int [] vetFilho;
         arvore.add(position);
        
        //gerar uma arvore com todos os filhos primeiro para depois cada algoritmo
         //analise com cada nodo da arvore, mas qual será o tamanho dessa arvore e 
         //que todos os nodos serão diferentes.
         
         
        return tabFilho;
    }
        
        
     
    
    
}