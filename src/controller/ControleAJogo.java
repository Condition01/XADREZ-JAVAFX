package controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import edu.curso.pecas.Peao;
import edu.curso.pecas.Peca;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ControleAJogo {
	private List<Peca> listaPecas = new LinkedList<Peca>();


	private Peca pecaMovida;
	private boolean clicado = false;
	private boolean turnoBranco = true;
	PrimeiramenteMovimental cPeao = new ControlePeao();
	Movimentavel cCavalo = new ControleCavalo();
	Movimentavel cRei = new ControleRei();
	FortementeMovimentavel cTorre = new ControleTorre();
	FortementeMovimentavel cBispo = new ControleBispo();
	FortementeMovimentavel cRainha = new ControleRainha();
	
	private String[][] tabuleiro = {
			{"TP", "CP", "BP", "KP", "QP", "BP", "CP", "TP"},
			{"PP", "PP", "PP", "PP", "PP", "PP", "PP", "PP"},
			{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
			{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
			{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
			{"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
			{"PB", "PB", "PB", "PB", "PB", "PB", "PB", "PB"},
			{"TB", "CB", "BB", "KB", "QB", "BB", "CB", "TB"} };



	public boolean fazerJogada(Peca p) {
		boolean valido = false;
		if(pecaMovida.getName().equals("edu.curso.pecas.PeaoBranco") || pecaMovida.getName().equals("edu.curso.pecas.PeaoPreto")) {
			valido = movimentaPeao(p, valido);
		}else if(pecaMovida.getName().equals("edu.curso.pecas.CavaloBranco") || pecaMovida.getName().equals("edu.curso.pecas.CavaloPreto")) {
			valido = movimentaCavalo(p, valido);
		}else if(pecaMovida.getName().equals("edu.curso.pecas.TorreBranco") || pecaMovida.getName().equals("edu.curso.pecas.TorrePreto")) {
			valido = movimentaTorre(p, valido);
		}else if(pecaMovida.getName().equals("edu.curso.pecas.BispoBranco") || pecaMovida.getName().equals("edu.curso.pecas.BispoPreto")) {
			valido = movimentaBispo(p, valido);
		}else if(pecaMovida.getName().equals("edu.curso.pecas.RainhaBranco") || pecaMovida.getName().equals("edu.curso.pecas.RainhaPreto")) {
			valido = movimentaRainha(p, valido);
		}else if(pecaMovida.getName().equals("edu.curso.pecas.ReiBranco") || pecaMovida.getName().equals("edu.curso.pecas.ReiPreto")) {
			valido = movimentaRei(p, valido);
		}
		return valido;
	}
	
	private boolean movimentaRei(Peca p, boolean valido) {
		if(cRei.movimentoPossivel(pecaMovida, p)) {
			valido = true;
			String peca ;
			this.tabuleiro[pecaMovida.getY()][pecaMovida.getX()] = "  ";
			if(pecaMovida.getName().equals("edu.curso.pecas.ReiPreto")) {
				peca = "KP";
			}else {
				peca = "KB";
			}
			 this.tabuleiro[p.getY()][ p.getX()] = peca;
		}
		return valido;
	}

	private boolean movimentaRainha(Peca p, boolean valido) {
		if(cRainha.movimentoPossivel(pecaMovida, p, this.listaPecas)) {
			valido = true;
			String peca ;
			this.tabuleiro[pecaMovida.getY()][pecaMovida.getX()] = "  ";
			if(pecaMovida.getName().equals("edu.curso.pecas.RainhaPreto")) {
				peca = "QP";
			}else {
				peca = "QB";
			}
			 this.tabuleiro[p.getY()][ p.getX()] = peca;
		}
		return valido;
	}

	public boolean movimentaBispo(Peca p, boolean valido) {
		if(cBispo.movimentoPossivel(pecaMovida, p, this.listaPecas)) {
			valido = true;
			String peca ;
			this.tabuleiro[pecaMovida.getY()][pecaMovida.getX()] = "  ";
			if(pecaMovida.getName().equals("edu.curso.pecas.BispoPreto")) {
				peca = "BP";
			}else {
				peca = "BB";
			}
			 this.tabuleiro[p.getY()][ p.getX()] = peca;
		}
		return valido;
	}
	

	public boolean movimentaTorre(Peca p, boolean valido) {
		if(cTorre.movimentoPossivel(pecaMovida, p, this.listaPecas)) {
			valido = true;
			String peca ;
			this.tabuleiro[pecaMovida.getY()][pecaMovida.getX()] = "  ";
			if(pecaMovida.getName().equals("edu.curso.pecas.TorrePreto")) {
				peca = "TP";
			}else {
				peca = "TB";
			}
			 this.tabuleiro[p.getY()][ p.getX()] = peca;
		}
		return valido;
	}

	public boolean movimentaCavalo(Peca p, boolean valido) {
		if(cCavalo.movimentoPossivel(pecaMovida, p)) {
			valido = true;
			String peca ;
			this.tabuleiro[pecaMovida.getY()][pecaMovida.getX()] = "  ";
			if(pecaMovida.getName().equals("edu.curso.pecas.CavaloPreto")) {
				peca = "CP";
			}else {
				peca = "CB";
			}
			 this.tabuleiro[p.getY()][ p.getX()] = peca;
		}
		return valido;
	}

	public boolean movimentaPeao(Peca p, boolean valido) {
		if(cPeao.movimentoPossivel(pecaMovida, p)) {
			valido = true;
			String peca ;
			this.tabuleiro[pecaMovida.getY()][pecaMovida.getX()] = "  ";
			if(pecaMovida.getName().equals("edu.curso.pecas.PeaoPreto")) {
				cPeao.setPrimeiraJogadaPreto(false);
				peca = "PP";
			}else {
				cPeao.setPrimeiraJogadaBranco(false);
				peca = "PB";
			}
			 this.tabuleiro[p.getY()][ p.getX()] = peca;
		}
		return valido;
	}
	
	public String[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(String[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public Peca getPecaMovida() {
		return pecaMovida;
	}

	public void setPecaMovida(Peca pecaMovida) {
		this.pecaMovida = pecaMovida;
	}


	public boolean isClicado() {
		return clicado;
	}

	public void setClicado(boolean clicado) {
		this.clicado = clicado;
	}
	
	
	public void removerList(Peca p) {
		this.listaPecas.remove(p);
	}
	
	public void adicionarList(Peca p) {
		this.listaPecas.add(p);
	}
	
	public ImageView pegarImgListaFim() {
		return this.listaPecas.get(this.listaPecas.size()-1).getImgView();
	}
	
	public List<Peca> getListaPecas() {
		return listaPecas;
	}

	public void setListaPecas(List<Peca> listaPecas) {
		this.listaPecas = listaPecas;
	}
	
	public void limparLista() {
		this.listaPecas = new LinkedList<Peca>();
	}

	public boolean isTurnoBranco() {
		return turnoBranco;
	}

	public void setTurnoBranco(boolean turnoBranco) {
		this.turnoBranco = turnoBranco;
	}

}
