import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;

/*
 * Trabalho para a disciplina de Inteligência Artificial - prof.: Anderson Ferrugem
 * 		Alunos: Abilio Gambim Parada
 * 			Vanderson Oliveira da Silva
 *			Eliane Siegert
 */
public class Main {
	
	public static Map<String, String> visited = new TreeMap<String, String>();
	
	public static void main(String[] args) throws IOException {
		int [] vet = {0,1,2,3,4,5,6,7};
		
		Tabuleiro tab ,filho;
		tab = new Tabuleiro(vet);
		visited.put(new String(String.valueOf(vet)), new String(String.valueOf(vet)));
		
		Tempera tempera = new Tempera(tab);
		tab = tempera.tempera();
		/*for(int i=0;i<64;i++){
			filho = new Tabuleiro(tab);
			filho.gerarFilho();
			//filho.gerarFilhoAleatorio();
		}
		
		/*
		JFrame window = new JFrame("N-Rainhas IA");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new NrainhasUI());
        window.pack();  
        window.show();  
        window.setResizable(false);
        */
	}
		
}
