package controller;

import edu.curso.pecas.Peca;

public class ControleRei implements Movimentavel{

	private int deltaY;
	private int deltaX;
	
	@Override
	public boolean movimentoPossivel(Peca movida, Peca destino) {
		deltaY = destino.getY() - movida.getY();
		deltaX = destino.getX() - movida.getX();
		if(andaIgualRei()) {
			if((movida.isWhite() != destino.isWhite() || destino.getName().equals("espaco"))){
				return true;
			}
		}
		return false;
	}

	public boolean andaIgualRei() {
		boolean valido = false;
		if(deltaX == 1 && deltaY == 1) {
			valido = true;
		}else if(deltaX == -1 && deltaY == -1) {
			valido = true;
		}else if(deltaX == -1 && deltaY == 1) {
			valido = true;
		}else if(deltaX == 1 && deltaY == -1) {
			valido = true;
		}else {
			valido = andaIgualReiVertical();
		}
		return valido;
	}
	
	public boolean andaIgualReiVertical() {
		boolean valido = false;
		if(deltaX == 0 && deltaY == 1) {
			valido = true;
		}else if(deltaX == 0 && deltaY == -1) {
			valido = true;
		}else if(deltaX == 1 && deltaY == 0) {
			valido = true;
		}else if(deltaX == -1 && deltaY == 0) {
			valido = true;
		}
		return valido;
	}

}
