
public class hill_climbing {

    Tabuleiro tabAtual;
    Tabuleiro tabProximo;

    public hill_climbing(Tabuleiro atual) {
        this.tabAtual = atual;

    }

    public Tabuleiro run() {
        int valor1, valor2;
        do {
            tabProximo = new Tabuleiro(tabAtual);
            tabProximo.gerarFilhoAleatorio();
            valor1 = tabAtual.getAttack();
            valor2 = tabProximo.getAttack();
            
            if (valor1 < valor2) {
                String s = tabAtual.convert(tabAtual.getBoard());
                Tabuleiro.visited.put(s, s);//coloca no tremap de visitados
            } else {
                String s = tabProximo.convert(tabProximo.getBoard());
                Tabuleiro.visited.put(s, s);//coloca no tremap de visitados
            }
            tabAtual = tabProximo;
            
        } while (!(valor2 == 0));
        
        return tabAtual;
    }
}
