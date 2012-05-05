import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;

/*
 * Trabalho para a disciplina de Inteligência Artificial - prof.: Anderson Ferrugem
 * 		Alunos: Abilio Gambim Parada
 * 			Vanderson Oliveira da Silva
 *			Eliane Siegert
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		JFrame window = new JFrame("N-Rainhas IA");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new NrainhasUI());
        window.pack();  
        window.show();  
        window.setResizable(false);
	}
	
	
	//Precisa testar.......................
	static int avalia_rainhas(int vet[]) {
        int cont = 0; //contador de rainhas que se atacam
        for (int i = 0; i < 8; i++) {
            int x = 1;
            for (int j = i + 1; j < 8; j++) {  // avalia as diagonais à direita
                  if(vet[i]==j){ //mesma coluna
                    cont++;
                }
                if ((vet[j] == vet[i] + x) || (vet[j] == vet[i] - x) ||(vet[j]==vet[i])) {
                    cont++;
                }
                x++;
            }
            x = 1;
            for (int j = i - 1; j > 0; j--) {  //avalia as diagonais à esquerda
               if(vet[i]==j){ //mesma coluna
                    cont++;
                }
                if ((vet[j] == vet[i] + x) || (vet[j] == vet[i] - x) || (vet[j])==vet[i])) {
                    cont++;
                }
                x++;
            }
        }
        return cont;  //retorna quantas rainhas foram atacadas
    }
}
