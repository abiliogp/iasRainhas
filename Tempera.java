import java.util.ArrayList;


public class Tempera {
	
	ArrayList<Tabuleiro> resultado = new ArrayList<Tabuleiro>();
	Tabuleiro atual;
	Tabuleiro proximo;
	Tabuleiro melhor;
	int t;
	
	
	public Tempera(Tabuleiro atual){
		this.atual = atual;
		this.melhor = atual;
		this.t = atual.getAttack();
	}
	
	public ArrayList executa(){
		int avalia; 
		double p;
		do{
			proximo = new Tabuleiro(atual);
			proximo.gerarFilhoAleatorio();
			avalia = proximo.getAttack() - atual.getAttack();
			if(avalia <= 0){
				atual = proximo;
				if(atual.getAttack() <= melhor.getAttack() ){
					melhor = atual;
					resultado.add(0, melhor);
					t = melhor.getAttack();
				}
			} else{
				p = Math.exp(-avalia/t);
				if(p > Math.random()){
					atual = proximo;
				}
			}
			
			
		}while(!(atual.getAttack() == 0));
		return resultado;
	}
	

}
