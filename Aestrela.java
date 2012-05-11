import java.util.List;
import java.util.TreeMap;

//jogador
public class Aestrela {
	private List<Tabuleiro> tabuleiros;
	private TreeMap<String,Tabuleiro>last;

	public Tabuleiro Aestrela(int entrada[]){
		Tabuleiro aux=new Tabuleiro(entrada);
		tabuleiros.add(aux);
		while(!tabuleiros.isEmpty()){
			aux=this.melhorTab();
			last.put((aux.getPosition()).toString(), aux);
			if(aux.getAttack()==0){
				return aux;
			}else{
				this.expandeChildrens();
			}
		}
		return aux;
	}
	
	/*
	 * Metodo que espande todos os filhos do tabuleiro que não foram visitados
	 * e adciona a lista de tabuleiros
	 * como vamos expandir????
	 */

	private void expandeChildrens() {
		// TODO Auto-generated method stub
		
	}

	private Tabuleiro melhorTab() {
		// TODO Auto-generated method stub
		return null;
	}
	}
