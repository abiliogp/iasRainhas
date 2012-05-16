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
		for(int i=0;i<65;i++){
			filho = new Tabuleiro(tab);
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
