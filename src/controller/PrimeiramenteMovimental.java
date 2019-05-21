package controller;

import edu.curso.pecas.Peca;

public interface PrimeiramenteMovimental {
	public boolean movimentoPossivel(Peca movida, Peca destino);
	public void setPrimeiraJogadaPreto(boolean primeiraJogadaPreto);
	public void setPrimeiraJogadaBranco(boolean primeiraJogadaPreto);
}
