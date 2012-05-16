import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
	private int[] board = new int[8];
	private int attack = -1;
	private Tabuleiro father;
	private int count = 0;

	
	
	public Tabuleiro(int[] board) {
		this.board = board;
		this.father = father;
	}

	public Tabuleiro(Tabuleiro father) {
		this.board = father.gerarFilho();
		this.father = father;
	}

	/*
	 * Metodo get do numero de rainhas se atacando no tabuleiro
	 */
	public int getAttack() {
		if (attack == -1) {
			attack = avalia_rainhas();
		}
		return this.attack;
	}

	/*
	 * Função q de avaliação
	 */
	private int avalia_rainhas() {
		int[] vet = this.board;
		int cont = 0; // contador de rainhas que se atacam
		for (int i = 0; i < 8; i++) {
			int x = 1;
			for (int j = i + 1; j < 8; j++) { // avalia as diagonais à direita

				if ((vet[j] == vet[i] + x) || (vet[j] == vet[i] - x)
						|| (vet[j] == vet[i])) {
					cont++;
				}
				x++;
			}
			x = 1;
			for (int j = i - 1; j >= 0; j--) { // avalia as diagonais à esquerda

				if ((vet[j] == vet[i] + x) || (vet[j] == vet[i] - x)
						|| (vet[j] == vet[i])) {
					cont++;
				}
				x++;
			}
		}
		return cont; // retorna quantas rainhas foram atacadas
	}

	public Tabuleiro expandeChildrens() {
		Tabuleiro tabFilho = new Tabuleiro();
		ArrayList<Object> arvore = null;
		int[] vetFilho;
		arvore.add(board);

		// gerar uma arvore com todos os filhos primeiro para depois cada
		// algoritmo
		// analise com cada nodo da arvore, mas qual será o tamanho dessa arvore
		// e
		// que todos os nodos serão diferentes.

		return tabFilho;
	}

	/*
	 * acho q temos q gerar um filho a cada vez a função é chamada para está
	 * função ficar uniforme para todos algoritmos
	 */
	public int[] gerarFilho() {
		int[] board = this.board.clone();
		do{
			if (count >= 63) {
				count = 0;
			}
			if (board[count / 8] == count % 8) {
				count++;
			}
			board[count / 8] = count % 8;
			count++;
		} while(Main.visited.containsValue(board.toString()));
		Main.visited.put(board.toString(), board.toString());
		return board;
	}

}