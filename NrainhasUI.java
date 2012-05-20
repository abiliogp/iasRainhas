import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

/*
 * Cria o painel de interface com o usuário
 *      com botões e quadro de jogo
 */
public class NrainhasUI extends JPanel {

	private int entrada [] = new int[8];
	private int npassos, nvisitados, ipasso = 0;
	private Tabuleiro tabuleiroInicial, tabuleiroResultado;
	private ArrayList<Tabuleiro> resultado;
	
	private GraphicsPanel rainhasUI;
	private NrainhasModel rainhasModel;

	private JPanel controlPanel;
	private JPanel statusBar;

	private JButton tempera;
	private JButton aestrela;
	private JButton encosta;
	private JButton passos;
	private JButton anterior;

	private JLabel label;
	private JTextField text;
	private JButton iniciar;

	public NrainhasUI() {
		rainhasModel = new NrainhasModel();

		iniciar = new JButton("Vai!");
		iniciar.addActionListener(new Iniciar());

		text = new JTextField("01234567");


		aestrela = new JButton("A *");
		aestrela.addActionListener(new AestrelaExc());

		encosta = new JButton("Encosta");
		encosta.addActionListener(new Encosta());

		tempera = new JButton("Tempera");
		tempera.addActionListener(new TemperaExc());

		passos = new JButton("Passos");
		passos.addActionListener(new Passos());

		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		controlPanel.add(text);
		controlPanel.add(iniciar);
		controlPanel.add(aestrela);
		controlPanel.add(encosta);
		controlPanel.add(tempera);
		//controlPanel.add(anterior);
		controlPanel.add(passos);

		label = new JLabel("De a entrada e clique em Vai!");

		statusBar = new JPanel();
		statusBar.setLayout(new FlowLayout());

		statusBar.add(label);
		
		rainhasUI = new GraphicsPanel();

		this.setLayout(new BorderLayout());
		this.add(controlPanel, BorderLayout.NORTH);

		this.add(rainhasUI, BorderLayout.CENTER);
		this.add(statusBar, BorderLayout.SOUTH);
	}

	public class GraphicsPanel extends JPanel implements MouseListener {
		private static final int ROWS = 8;
		private static final int COLS = 8;

		private static final int CELL_SIZE = 60;
		private Font _biggerFont;

		public GraphicsPanel() {
			_biggerFont = new Font("", Font.PLAIN, CELL_SIZE - 10);
			this.setPreferredSize(new Dimension(CELL_SIZE * COLS, CELL_SIZE
					* ROWS));
			this.setBackground(Color.black);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (int r = 0; r < ROWS; r++) {
				for (int c = 0; c < COLS; c++) {
					int x = c * CELL_SIZE;
					int y = r * CELL_SIZE;
					String text = rainhasModel.getFace(r, c);
					if (text != null) {
						if ((r + c) % 2 == 0) {
							g.setColor(Color.white);
							g.fillRect(x + 1, y + 1, CELL_SIZE - 3,
									CELL_SIZE - 3);
							g.setColor(Color.black);
						} else {
							g.setColor(Color.black);
							g.fillRect(x + 1, y + 1, CELL_SIZE - 3,
									CELL_SIZE - 3);
							g.setColor(Color.white);
						}
						g.setFont(_biggerFont);
						g.drawString(text, x + 7, y + 50);
					}
				}
			}
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}
	}

	public int[] convertStringIntArray(char[] sarray)  {
		if (sarray != null) {
			int intarray[] = new int[sarray.length];
			for (int i = 0; i < sarray.length; i++) {
				intarray[i] = Character.getNumericValue(sarray[i]);
			}
			return intarray;
		}
		return null;
	}

	public void geraResultado() {
		resultado = new ArrayList<Tabuleiro>();
		Tabuleiro novo = this.tabuleiroResultado;
		while (novo.getFather() != null) {
			resultado.add(0, novo);
			novo = novo.getFather();
		}
	}
	
	/*
	 * Botões de ação do jogo
	 */
	

	public class AestrelaExc implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(tabuleiroInicial == null){
				label.setText("Sem Entrada Inicial!");
				return;
			}
			
			Aestrela aestrela = new Aestrela(tabuleiroInicial);
			tabuleiroResultado = aestrela.run();
			
			rainhasModel.reset(tabuleiroResultado.getBoard());
		    rainhasUI.repaint();
			
			geraResultado();
			npassos = resultado.size();
			nvisitados = Tabuleiro.visited.size();
			
			label.setText("Visitados: " + nvisitados + " || Passos: " + npassos + " || " + npassos + "º Passo || Ataques: 0");
			
			Tabuleiro.visited.clear();
		}
	}

	public class Encosta implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}

	public class TemperaExc implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(tabuleiroInicial == null){
				label.setText("Sem Entrada Inicial!");
				return;
			}
			
			Tempera tempera = new Tempera(tabuleiroInicial);
			tabuleiroResultado = tempera.executa();
			
			rainhasModel.reset(tabuleiroResultado.getBoard());
		    rainhasUI.repaint();
			
			geraResultado();
			npassos = resultado.size();
			nvisitados = Tabuleiro.visited.size();
			
			label.setText("Visitados: " + nvisitados + " || Passos: " + npassos + " || " + npassos + "º Passo || Ataques: 0");
			
			Tabuleiro.visited.clear();
		}
	}
	
	public class Passos implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(tabuleiroInicial == null){
				label.setText("Sem Entrada Inicial!");
				return;
			}
			if(ipasso == resultado.size()){
				ipasso = 0;
			}
			int ataques = resultado.get(ipasso).getAttack();
			rainhasModel.reset(resultado.get(ipasso).getBoard());
		    rainhasUI.repaint();
			ipasso++;
			label.setText("Visitados: " + nvisitados + " || Passos: " + npassos + " || " + ipasso + "º Passo || Ataques: " + ataques);
		}
	}

	

	public class Iniciar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!text.getText().isEmpty()) {
				if (text.getText().length() != 8) {
					label.setText("Entrada Inválida!");
					return;
				}
			    entrada = convertStringIntArray(text.getText().toCharArray());
			    tabuleiroInicial = new Tabuleiro(entrada);
			    rainhasModel.reset(entrada);
			    label.setText("Escolha o Algoritmo!");
				rainhasUI.repaint();
			}
		}
	}
}