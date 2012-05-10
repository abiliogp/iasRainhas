import java.lang.reflect.Array;
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
    static int avalia_rainhas(int vet[]) {
        int cont = 0; //contador de rainhas que se atacam
        for (int i = 0; i < 8; i++) {
            int x = 1;
            for (int j = i + 1; j < 8; j++) {  // avalia as diagonais à direita
                  if(vet[i]==j){ //mesma coluna
                    cont++;
                }
                if ((vet[j] == vet[i] + x) || (vet[j] == vet[i] - x) ||(vet[j]==vet[i])) {
                    cont++;
                }
                x++;
            }
            x = 1;
            for (int j = i - 1; j > 0; j--) {  //avalia as diagonais à esquerda
               if(vet[i]==j){ //mesma coluna
                    cont++;
                }
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

         
    
}
