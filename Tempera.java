
public class Tempera {
	
	Tabuleiro current;
	Tabuleiro next;
	int avalia;
	//T controle de passos
	//int T = 0; 
	for(;;){
		//if(T == 0){
			//return current;
		//}
		// gerador Filhos
		//next = current.gerarFilhos(); aleatório???
		avalia = next.avalia_rainhas() - current.avalia_rainhas();
		if(avalia > 0){
			current = next;
		}
	}

}
