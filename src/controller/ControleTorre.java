package controller;

import java.util.List;

import edu.curso.pecas.Peca;

public class ControleTorre implements FortementeMovimentavel{
	
	private int deltaY;
	private int deltaX;
	
	@Override
	public boolean movimentoPossivel(Peca movida, Peca destino, List<Peca> pecasTab) {
		deltaY = destino.getY() - movida.getY();
		deltaX = destino.getX() - movida.getX();
		if(andaIgualTorre()) {
			if(validaCaminho(movida, destino,pecasTab) && (movida.isWhite() != destino.isWhite() || destino.getName().equals("espaco"))){
				return true;
			}
			System.out.println("false");
		}
		return false;
	}

	public boolean andaIgualTorre() {
		if((deltaY==0 && deltaX != 0) || (deltaY != 0 && deltaX == 0)) {
			return true;
		}
		return false;
	}
	
	public boolean validaCaminho(Peca movida, Peca destino, List<Peca> pecasTab) {
		boolean valido = true;
		if(isX(destino)) {
			valido = temPecaAliada(movida, destino, pecasTab, 0);
		}else {
			valido = temPecaAliada(movida, destino, pecasTab, 1);
		}
		return valido;
	}
	public boolean temPecaAliada(Peca movida, Peca destino, List<Peca> pecasTab,int position) {
		boolean valido = true;
		int destinoPeca = pegaDestino(destino);
		int[] tester = new int[2];
		tester[0] = movida.getX();
		tester[1] = movida.getY();
		tester = getNewPosition(destinoPeca, tester, position);
		while(tester[position] != destinoPeca) {
			for(Peca testada : pecasTab) {
				if(testada.getX() == tester[0] && testada.getY() == tester[1]) {
					if(!testada.getName().equals("espaco")) {
						valido = false;
					}
				}
				
			}
			tester = getNewPosition(destinoPeca, tester, position);
		}while(tester[position] != destinoPeca) ;
		return valido;
	}

	private int[] getNewPosition(int destinoPeca, int[] tester, int position) {
		if(destinoPeca > tester[position]) {
			tester[position] += 1;
		}else if(destinoPeca < tester[position]){
			tester[position] += -1;
		}
		return tester;
	}
	

	private int pegaDestino(Peca destino) {
		int destinoPeca;
		if(this.deltaX != 0) {
			destinoPeca = destino.getX();
		}else {
			destinoPeca = destino.getY();
		}
		return destinoPeca;
	}
	
	public boolean isX(Peca destino) {
		return this.deltaX != 0;
	}
}
