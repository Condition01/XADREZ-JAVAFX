package controller;

import java.util.List;

import edu.curso.pecas.Peca;

public interface FortementeMovimentavel {
	public boolean movimentoPossivel(Peca movida, Peca destino,List<Peca> pecasTab);
}
