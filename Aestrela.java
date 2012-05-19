import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;


public class Aestrela {
	private List<Tabuleiro> apesquisar;//conjunto de nós a serem pesquizados
	private TreeMap<String,Tabuleiro>last;//nós ja visitados
	private static int i=0;

	/* Autor: Vanderson Oliveira.
	 * Metodo criador do A-estrela. 
	 * P@r@metros: {void}.
	 * Return: {Tabuleiro}.
	 */
	public  Aestrela(Tabuleiro entrada){
		this.apesquisar=new LinkedList<Tabuleiro>();//inicializa lista auxiliar de filhos
		apesquisar.add(entrada);//insere 
		
	}
	/* Autor: Vanderson Oliveira.
	 * Metodo que executa o algoritmo A-estrela e retorna o tabuleiro resultado.
	 * P@r@metros: {void}.
	 * Return: {Tabuleiro}.
	 */
	public Tabuleiro run(){
		Tabuleiro aux=null;
		while(!apesquisar.isEmpty()){
			aux=this.getBetter();//remove o melhor da fila de prioridade
			String s=aux.convert(aux.getBoard());
			Main.visited.put(s,s);//coloca no tremap de visitados
			if(aux.getAttack()==0){
				return aux;
			}else{
				this.estendeCaminhos(aux);//cria todos os filhos de aux
			}
		}
		return aux;
	}
	/* Autor: Vanderson Oliveira.
	 * Metodo que pega o melhor tabuleiro da lista à pesquisar.
	 * P@r@metros: {void}.
	 * Return: {Tabuleiro}.
	 */
	private Tabuleiro getBetter() {
		int ponteiro=0;
		int ofBetter=0;
		Object[] filhos=null;
		filhos= apesquisar.toArray();
		if(filhos.length==1){
			ponteiro=1000;
		}else{
			ofBetter=1;
		}
		while(ponteiro<(filhos.length)){
			if(((Tabuleiro) filhos[ponteiro]).getAttack() < ((Tabuleiro) filhos[ofBetter]).getAttack()){
				ofBetter=ponteiro;				
			}
			ponteiro++;
		}
		return this.apesquisar.remove(ofBetter);
	}
	/* Autor: Vanderson Oliveira.
	 * Metodo que pega o resultado da expanção de filhos e insere na lista de nós a pesquisar.
	 * P@r@metros: {void}.
	 * Return: {void}.
	 */
	private void estendeCaminhos(Tabuleiro x){
		Tabuleiro aux;
		int[] novo;
		for(int i=0;i<64;i++){
			novo=x.gerarFilhoEstrela();
			if(novo!=null){
				aux=new Tabuleiro(novo,x);//cria o novo filho
				this.apesquisar.add(aux);//add na lista de nós a pesquisar
			}
			
		}
	}
}


	
