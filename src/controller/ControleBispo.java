package controller;

import java.util.List;

import edu.curso.pecas.Peca;

public class ControleBispo implements FortementeMovimentavel{

	private int deltaY;
	private int deltaX;
	
	@Override
	public boolean movimentoPossivel(Peca movida, Peca destino, List<Peca> pecasTab) {
		deltaY = destino.getY() - movida.getY();
		deltaX = destino.getX() - movida.getX();
		if(andaIgualBispo()) {
			if(validaCaminho(movida, destino,pecasTab) && (movida.isWhite() != destino.isWhite() || destino.getName().equals("espaco"))){
				return true;
			}
		}
		return false;
	}

	
	private boolean validaCaminho(Peca movida, Peca destino, List<Peca> pecasTab) {
		boolean validaCaminho = temPecaAliada(movida, destino, pecasTab);
		return validaCaminho;
	}
	
	public boolean temPecaAliada(Peca movida, Peca destino, List<Peca> pecasTab) {
		boolean valido = true;
		int[] tester = new int[2];
		tester[0] = movida.getX();
		tester[1] = movida.getY();
		tester = getNewPosition(tester);
		while(tester[0] != destino.getX() && tester[1] != destino.getY()) {
			for(Peca testada : pecasTab) {
				if(testada.getX() == tester[0] && testada.getY() == tester[1]) {
					if(!testada.getName().equals("espaco")) {
						valido = false;
					}
				}
			}
			tester = getNewPosition(tester);
		}
		return valido;
	}

	public int [] getNewPosition(int tester[]) {
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


	public boolean andaIgualBispo() {
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

}
