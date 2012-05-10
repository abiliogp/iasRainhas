/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eliane
 */
public class hill_climbing {
    
    private Tabuleiro tabAtual = new Tabuleiro();
    private Tabuleiro tabProximo = new Tabuleiro();
    
    public Tabuleiro hill_climbing(){
        
        for(;;){
            tabProximo = tabAtual.expandeChildrens();
            int valor1 = tabAtual.avalia_rainhas();
            int valor2 = tabProximo.avalia_rainhas();
            if(valor1<valor2){
                return tabAtual;
            }
            tabAtual = tabProximo;
        }
    }
   
}
