
public class Tempera {
	
	Tabuleiro atual;
	Tabuleiro proximo;
	Tabuleiro melhor;
	int t;
	
	
	public Tempera(Tabuleiro atual){
		this.atual = atual;
		this.melhor = atual;
		this.t = atual.getAttack();
	}
	
	public Tabuleiro executa(){
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
					t = melhor.getAttack();
				}
			} else{
				p = Math.exp(-avalia/t);
				if(p > Math.random()){
					atual = proximo;
				}
			}
			
			
		}while(!(atual.getAttack() == 0));
		return melhor;
	}
	

}
