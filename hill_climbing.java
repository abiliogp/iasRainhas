/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eliane
 */
public class hill_climbing {
    
    Tabuleiro tabAtual;
    Tabuleiro tabProximo;
    
    public hill_climbing(Tabuleiro atual){
        this.tabAtual = atual;
        
    }
    
    public Tabuleiro run(){
        int valor1, valor2;
        for(;;){
            tabProximo = new Tabuleiro(tabAtual);
            tabProximo.gerarFilhoAleatorio();
            valor1 = tabAtual.getAttack();
            valor2 = tabProximo.getAttack();
            if(valor1<valor2){
                return tabAtual;
            }
            tabAtual = tabProximo;
        }
    }

   
}
