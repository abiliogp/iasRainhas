import java.util.ArrayList;
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
	public static Map<String, String> visited = new TreeMap<String, String>();
	
	private int[] board = new int[8];
	private int attack = -1;
	private Tabuleiro father;
	private int count = 0;

	public Tabuleiro(int[] board) {
		this.board = board;
		this.attack = this.avalia_rainhas();
	}

	public Tabuleiro(Tabuleiro father) {
		this.father = father;
	}

	public Tabuleiro(int[] board, Tabuleiro father) {
		this.board = board;
		this.attack = this.avalia_rainhas();
		this.father = father;
	}

	public Tabuleiro getFather() {
		return this.father;
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
		Tabuleiro tabFilho = null;
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
		String str;
		this.board = father.board.clone();
		do {
			if (father.count >= 63) {
				father.count = 0;
			}
			if (board[father.count / 8] == father.count % 8) {
				father.count++;
			}
			board[father.count / 8] = father.count % 8;
			father.count++;
			str = this.convert(board);			
		} while (visited.containsKey(str));
		visited.put(str, str);
	}

	public void gerarFilhoAleatorio() {
		String str;
		int count;
		this.board = father.board.clone();
		do {
			count = (int) (Math.random() * 63);
			if (board[count / 8] == count % 8) {
				count = (int) (Math.random() * 63);
			}
			board[count / 8] = count % 8;
			str = this.convert(board);
		} while (visited.containsKey(str));
		visited.put(str, str);
	}

	/*
	 * classe de teste de saida
	 */
	public void printResult(Tabuleiro novo) {
		while (novo.getFather() != null) {
			print(novo.getBoard());
			novo = novo.getFather();
		}
		print(novo.getBoard());
		return;
	}

	

	// Substituir a interface aqui
	private static void print(int[] board) {
		for (int i = 0; i < 9; i += 3) {
			System.out.println(board[i] + "  " + board[i + 1] + "  "
					+ board[i + 2]);
		}
		System.out.println(".......");
	}

	/*
	 * Autor: Vanderson Oliveira. Metodo que retona o vetor com as posições. NÃO
	 * APAGa TO USANDO !!! P@r@metros: {void}. Return: {INT[]}.
	 */
	public int[] getBoard() {
		return board;
	}

	/*
	 * Autor: Vanderson Oliveira. Metodo que retona o vetor com as posições do
	 * novo filho PRECISO disso pois tenho uma fila de PRIORIDADE não posso usar
	 * a visited. NÃO APAGa TO USANDO !!! P@r@metros: {void}. Return: {INT[]}.
	 */
	public int[] gerarFilhoEstrela() {

		int[] board2 = board.clone();
		if (this.count >= 63) {
			this.count = 0;
		}
		if (board2[this.count / 8] == this.count % 8) {
			this.count++;
		}
		board2[this.count / 8] = this.count % 8;
		this.count++;
		String s = this.convert(board2);
		if (visited.containsValue(s)) {
			return null;// o filho ja existe então mando ele criar outro no
						// estrela.estendeCaminhos
		} else {
			// Main.visited.put(s, s);
			return board2;// retorna o filho para adicionar a fila de prioridade
		}

	}

	public String convert(int[] aux) {
		String aus = "";
		for (int i = 0; i < 8; i++) {
			aus = aus.concat(String.valueOf(aux[i]));
		}
		return aus;
	}

}