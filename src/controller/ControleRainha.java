package controller;

import java.util.List;

import edu.curso.pecas.Peca;

public class ControleRainha implements FortementeMovimentavel{
	private int deltaY;
	private int deltaX;
	
	@Override
	public boolean movimentoPossivel(Peca movida, Peca destino, List<Peca> pecasTab) {
		boolean movimentoValido = false;
		deltaY = destino.getY() - movida.getY();
		deltaX = destino.getX() - movida.getX();
		if(andaIgualRainhaReto()) {
			movimentoValido = validaCaminho(movida, destino, pecasTab, true);
		}else if(andaIgualRainhaDiagonal()) {
			movimentoValido = validaCaminho(movida, destino, pecasTab, false);
		}
		if(movimentoValido) {
			if((movida.isWhite() != destino.isWhite() || destino.getName().equals("espaco"))){
				movimentoValido = true;
			}else {
				movimentoValido = false;
			}
		}
		return movimentoValido;
	}

	
	private boolean andaIgualRainhaDiagonal() {
		boolean valido = false;
		if(this.deltaX == this.deltaY) {
			valido = true;
		}else if (this.deltaX == -this.deltaY) {
			valido = true;
		}else if (-this.deltaX == this.deltaY) {
			valido = true;
		}
		return valido;
	}
	
	private boolean andaIgualRainhaReto() {
		boolean valido = false;
		if((deltaY==0 && deltaX != 0) || (deltaY != 0 && deltaX == 0)) {
			valido = true;
		}
		return valido;
	}

	
	private boolean validaCaminho(Peca movida, Peca destino, List<Peca> pecasTab, boolean andaReto) {
		boolean validaCaminho;
		if(andaReto) {
			if(isX(destino)) {
				validaCaminho = temPecaAliadaReto(movida, destino, pecasTab, 0);
			}else {
				validaCaminho = temPecaAliadaReto(movida, destino, pecasTab, 1);
			}
		}else {
			validaCaminho = temPecaAliadaDiagonal(movida, destino, pecasTab);
		}
		return validaCaminho;
	}
	
	public boolean temPecaAliadaDiagonal(Peca movida, Peca destino, List<Peca> pecasTab) {
		boolean valido = true;
		int[] tester = new int[2];
		tester[0] = movida.getX();
		tester[1] = movida.getY();
		tester = getNewPositionDiagonal(tester);
		while(tester[0] != destino.getX() && tester[1] != destino.getY()) {
			for(Peca testada : pecasTab) {
				if(testada.getX() == tester[0] && testada.getY() == tester[1]) {
					if(!testada.getName().equals("espaco")) {
						valido = false;
					}
				}
			}
			tester = getNewPositionDiagonal(tester);
		}
		return valido;
	}

	public boolean temPecaAliadaReto(Peca movida, Peca destino, List<Peca> pecasTab,int position) {
		boolean valido = true;
		int destinoPeca = pegaDestino(destino);
		int[] tester = new int[2];
		tester[0] = movida.getX();
		tester[1] = movida.getY();
		tester = getNewPositionReto(destinoPeca, tester, position);
		while(tester[position] != destinoPeca) {
			for(Peca testada : pecasTab) {
				if(testada.getX() == tester[0] && testada.getY() == tester[1]) {
					if(!testada.getName().equals("espaco")) {
						valido = false;
					}
				}
				
			}
			tester = getNewPositionReto(destinoPeca, tester, position);
		}while(tester[position] != destinoPeca) ;
		return valido;
	}
	
	private int[] getNewPositionReto(int destinoPeca, int[] tester, int position) {
		if(destinoPeca > tester[position]) {
			tester[position] += 1;
		}else if(destinoPeca < tester[position]){
			tester[position] += -1;
		}
		return tester;
	}

	public int [] getNewPositionDiagonal(int tester[]) {
		if(this.deltaX > 0) {
			tester[0] += 1;
		}else if(this.deltaX < 0) {
			tester[0] += -1;
		}
		if(this.deltaY > 0) {
			tester[1] += 1;
		}else if(this.deltaY < 0) {
			tester[1] += -1;
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
