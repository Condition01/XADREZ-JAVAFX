package controller;

import edu.curso.pecas.Peca;

public interface Movimentavel {
	public boolean movimentoPossivel(Peca movida, Peca destino);
}
