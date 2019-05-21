package controller;

import edu.curso.pecas.Peca;

public class ControleCavalo implements Movimentavel{

	private int deltaY;
	private int deltaX;
	
	
	@Override
	public boolean movimentoPossivel(Peca movida, Peca destino) {
		deltaY = destino.getY() - movida.getY();
		deltaX = destino.getX() - movida.getX();
		
		if(andaIgualCavalo() && destino.getName() == "espaco") {
			return true;
		}else {
			if(andaIgualCavalo() && (movida.isWhite() != destino.isWhite())) {
				return true;
			}
			return false;
		}
		
	}

	
	
	public boolean andaIgualCavalo() {
		if((deltaY == 1 || deltaY == -1) && (deltaX == 2 || deltaX == -2)) {
			return true;
		}else if((deltaY == -2 || deltaY == 2) && (deltaX == -1 || deltaX == 1)){
			return true;
		}
		return false;
	}

}
