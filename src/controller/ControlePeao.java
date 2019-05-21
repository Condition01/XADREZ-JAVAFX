package controller;

import edu.curso.pecas.Peca;

public class ControlePeao implements PrimeiramenteMovimental{
	private boolean primeiraJogadaPreto = true;
	private boolean primeiraJogadaBranco = true;

	@Override
	public boolean movimentoPossivel(Peca movida, Peca destino) {
		boolean possivel = false;
		int delta = movida.getY() - destino.getY();
		
	
		
		boolean primeiraJogada = isPrimeiraJogada(movida);
		
		int moviment = movimentacao(movida, primeiraJogada);
		
		System.out.println("movida y : " + movida.getY() + " destino y " + destino.getY());
		System.out.println("movida x : " + movida.getY() + " destino x " + destino.getY());

		if(primeiraJogada) {
			
			if((delta == deltaUm(moviment) | delta == deltaDois(moviment)) && destino.getName() == "espaco" && destino.getX() == movida.getX()) {
				possivel = true;
			}else {
				if((destino.isWhite() != movida.isWhite()) && destino.getY() == movida.getY()+moviment && destino.getX() == movida.getX()+moviment  && destino.getName() != "espaco") {
					possivel = true;
				}else if((destino.isWhite() != movida.isWhite()) && destino.getY() == movida.getY()+moviment && destino.getX() == movida.getX()-moviment  && destino.getName() != "espaco"){
					possivel = true;
				}
			}
		}else {
			if(delta == deltaUm(moviment) && destino.getName() == "espaco" && destino.getX() == movida.getX()) {
				possivel = true;
			}else {
				if((destino.isWhite() != movida.isWhite()) && destino.getY() == movida.getY()+moviment && destino.getX() == movida.getX()+moviment && destino.getName() != "espaco") {
					possivel = true;
				}else if((destino.isWhite() != movida.isWhite()) && destino.getY() == movida.getY()+moviment && destino.getX() == movida.getX()-moviment && destino.getName() != "espaco"){
					possivel = true;
				}
			}
		}

		return possivel;
	}


	public int movimentacao(Peca movida, boolean primeiraJogada) {
		if(movida.isWhite()) {
			return -1;
		}else {
			return 1;
		}
	}
	
	public int deltaUm(int result) {
		if(result == -1) {
			return 1;
		}else {
			return -1;
		}
	}
	
	public int deltaDois(int result) {
		if(result == -1) {
			return 2;
		}else {
			return -2;
		}
	}
	

	
	public boolean isPrimeiraJogada(Peca movida) {
		if(movida.isWhite()) {
			return this.primeiraJogadaBranco;
		}else {
			return this.primeiraJogadaPreto;
		}
	}
	
	@Override
	public void setPrimeiraJogadaPreto(boolean primeiraJogadaPreto) {
		this.primeiraJogadaPreto = primeiraJogadaPreto;
	}
	
	@Override
	public void setPrimeiraJogadaBranco(boolean primeiraJogadaBranco) {
		this.primeiraJogadaBranco = primeiraJogadaBranco;
	}
	
}
