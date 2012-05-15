import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

//jogador
public class Aestrela {
	private PriorityQueue<Tabuleiro> apesquisar;//conjunto de nós a serem pesquizados
	private PriorityQueue<Tabuleiro> filhos;//tem que ver que tipo vao definir para os filhos
	private TreeMap<String,Tabuleiro>last;//nós ja visitados

	/* Autor: Vanderson Oliveira.
	 * Metodo criador do A-estrela. 
	 * P@r@metros: {void}.
	 * Return: {Tabuleiro}.
	 */
	public  Aestrela(int entrada[]){
		Tabuleiro aux=new Tabuleiro(entrada);
		this.filhos=new PriorityQueue();//inicializa lista auxiliar de filhos
		this.apesquisar=new PriorityQueue();//inicializa lista de tabuleiros a pesquisar
		apesquisar.add(aux);//insere ondenado
		
	}
	/* Autor: Vanderson Oliveira.
	 * Metodo que executa o algoritmo A-estrela e retorna o tabuleiro resultado.
	 * P@r@metros: {void}.
	 * Return: {Tabuleiro}.
	 */
	public Tabuleiro run(){
		Tabuleiro aux=new Tabuleiro(null);
		while(!apesquisar.isEmpty()){
			aux=apesquisar.remove();//remove o melhor
			last.put((aux.getPosition()).toString(), aux);//coloca no tremap de visitados
			if(aux.getAttack()==0){
				return aux;
			}else{
				//this.filhos=aux.expandeChildrens();tem que ver que tipo vao definir para os filhos
				this.insereNaPesquisa();
			}
		}
		return aux;
	}
	/* Autor: Vanderson Oliveira.
	 * Metodo que pega o resultado da expanção de filhos e insere na lista de nós a pesquisar.
	 * P@r@metros: {void}.
	 * Return: {void}.
	 */
	private void insereNaPesquisa() {
		while(!this.filhos.isEmpty()){
			this.apesquisar.add(this.filhos.remove());
		}

	}
}


	
