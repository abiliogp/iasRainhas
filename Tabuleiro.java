import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.bind.ParseConversionEvent;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author vanderson
 */
public class Tabuleiro {
	private char[] board = new char[8];
	private int attack = -1;
	private Tabuleiro father;
	private int count = 0;

	
	
	public Tabuleiro(char[] board) {
		this.board = board;
	}

	public Tabuleiro(Tabuleiro father) {
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
	public void gerarFilho() {
		this.board = father.board.clone();
		do{
			if (father.count >= 63) {
				father.count = 0;
			}
			if (board[father.count / 8] == father.count % 8) {
				father.count++;
			}
			board[father.count / 8] =  String.valueOf((father.count % 8)).charAt(0);
			father.count++;
		} while(Main.visited.containsKey(new String(board)));
		Main.visited.put(new String(board), this);
	}
	
	public void gerarFilhoAleatorio() {
		int count;
		this.board = father.board.clone();
		do{
			count = (int) (Math.random()*63);
			if (board[count / 8] == count % 8) {
				count = (int) (Math.random()*63);
			}
			board[count / 8] = String.valueOf((count % 8)).charAt(0);;
		} while(Main.visited.containsKey(new String(board)));
		Main.visited.put(new String(board), this);
	}

}