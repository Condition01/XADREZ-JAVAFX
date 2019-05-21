package view;



import java.io.FileInputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import controller.ControleAJogo;
import edu.curso.pecas.Bispo;
import edu.curso.pecas.Cavalo;
import edu.curso.pecas.Peao;
import edu.curso.pecas.Peca;
import edu.curso.pecas.Rainha;
import edu.curso.pecas.Rei;
import edu.curso.pecas.Torre;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Xadrez extends Application implements EventHandler<MouseEvent>{

	private double x1;
	private double y1;
	private double x2;
	private double y2;

	

	private ControleAJogo cp = new ControleAJogo();
	
	GridPane painelTabuleiro = new GridPane();
	VBox paneInfo = new VBox();
	
	Scene scn = new Scene(painelTabuleiro, 670, 520);
	
	Label lblQuemJoga = new Label("Quem joga");

	Text txtQuemJoga = new Text("BRANCO");
	
	ImageView imgView = new ImageView();
	
	//fiz um preenchimento manual, pois é mais eficiente em termos computacionais, ja que o jogo vai começar sempre da mesma forma.
	
	@Override
	public void start(Stage stage) throws Exception {
		
		paint();
		imprimirTabuleiro();
		int moviment = -1;
		int moviment2 = +3;
		
		txtQuemJoga.setFill(Color.BLUE);
		
		

	
		stage.setScene(scn);
		stage.show();
//		Peca bispo = new Bispo(0,1,true);
//		imgView = bispo.getImgView();
//		painelTabuleiro.add(imgView, 1, 0);
	}
	
	public void imprimirTabuleiro() {
		ImageView img;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				switch (this.cp.getTabuleiro()[i][j]) {
				case "TP": 
							cp.adicionarList(new Torre(i, j, false));
							img = cp.pegarImgListaFim();
							img.setPickOnBounds(true);
							img.addEventFilter(MouseEvent.MOUSE_CLICKED, this);
							painelTabuleiro.add(img, j, i);	
					break;
				case "CP": 	
							cp.adicionarList(new Cavalo(i, j, false));
							img = cp.pegarImgListaFim();
							img.setPickOnBounds(true);
							img.addEventFilter(MouseEvent.MOUSE_CLICKED, this);
							painelTabuleiro.add(img, j, i);	
					break; 
				case "BP": 
							cp.adicionarList(new Bispo(i, j, false));
							img = cp.pegarImgListaFim();
							img.setPickOnBounds(true);
							img.addEventFilter(MouseEvent.MOUSE_CLICKED, this);
							painelTabuleiro.add(img, j, i);	
					break;
				case "KP": 
							cp.adicionarList(new Rei(i, j, false));
							img = img = cp.pegarImgListaFim();
							img.addEventFilter(MouseEvent.MOUSE_CLICKED, this);
							painelTabuleiro.add(img, j, i);	
					break;
				case "QP": 
							cp.adicionarList(new Rainha(i, j, false));
							img = img = cp.pegarImgListaFim();
							img.setPickOnBounds(true);
							img.addEventFilter(MouseEvent.MOUSE_CLICKED, this);
							painelTabuleiro.add(img, j, i);	
					break;
				case "PP": 
							cp.adicionarList(new Peao(i, j, false));
							img = img = cp.pegarImgListaFim();
							img.setPickOnBounds(true);
							img.addEventFilter(MouseEvent.MOUSE_CLICKED, this);
							painelTabuleiro.add(img, j, i);	
					break;
				case "TB": 
							cp.adicionarList(new Torre(i, j, true));
							img = img = cp.pegarImgListaFim();
							img.setPickOnBounds(true);
							img.addEventFilter(MouseEvent.MOUSE_CLICKED, this);
							painelTabuleiro.add(img, j, i);	
					break;
				case "CB": 
							cp.adicionarList(new Cavalo(i, j, true));
							img = img = cp.pegarImgListaFim();
							img.setPickOnBounds(true);
							img.addEventFilter(MouseEvent.MOUSE_CLICKED, this);
							painelTabuleiro.add(img, j, i);	
					break;
				case "BB": 
							cp.adicionarList(new Bispo(i, j, true));
							img = img = cp.pegarImgListaFim();
							img.setPickOnBounds(true);
							img.addEventFilter(MouseEvent.MOUSE_CLICKED, this);
							painelTabuleiro.add(img, j, i);	
					break;
				case "KB": 
							cp.adicionarList(new Rei(i, j, true));
							img = img = cp.pegarImgListaFim();
							img.setPickOnBounds(true); //pra pegar em qualquer lugar da area da imagem
							img.addEventFilter(MouseEvent.MOUSE_CLICKED, this);
							painelTabuleiro.add(img, j, i);	
					break;
				case "QB": 
							cp.adicionarList(new Rainha(i, j, true));
							img = img = cp.pegarImgListaFim();
							img.setPickOnBounds(true);
							img.addEventFilter(MouseEvent.MOUSE_CLICKED, this);
							painelTabuleiro.add(img, j, i);	
					break;
				case "PB": 
							cp.adicionarList(new Peao(i, j, true));
							img = img = cp.pegarImgListaFim();
							img.setPickOnBounds(true);
							img.addEventFilter(MouseEvent.MOUSE_CLICKED, this);
							painelTabuleiro.add(img, j, i);	
					break;
				default : 	cp.adicionarList(new Peca(i, j, true));
							img = img = cp.pegarImgListaFim();
							img.setPickOnBounds(true);
							img.addEventFilter(MouseEvent.MOUSE_CLICKED, this);
							painelTabuleiro.add(img, j, i);	
					break;
				}
			}
		}
	}

    public void paint() {
		boolean white = false;
		for(int i=0;i<8;i++) {
			white = whiteOrBlack(white);
			for(int j=0;j<8;j++) {
				Rectangle quadradinho = new Rectangle(64,64,64,64);
				if(white) {
					quadradinho.setFill(Color.WHITE);
					quadradinho.setStroke(Color.GRAY);
					white = false;
				}else {
					quadradinho.setFill(Color.GRAY);
					white = true;
					
				}
				painelTabuleiro.add(quadradinho, j, i);
			}
		}
		constroiTextoLateral();
    }
    
    public void constroiTextoLateral() {
    	this.lblQuemJoga.setStyle("-fx-font-weight: bold");
    	this.txtQuemJoga.setStyle("-fx-font-weight: bold");
		this.paneInfo.getChildren().add(lblQuemJoga);
		this.paneInfo.getChildren().add(txtQuemJoga);
		this.paneInfo.setMargin(txtQuemJoga, new Insets(20, 0, 0, 0));
		
		painelTabuleiro.add(new Label("          "), 8 , 0);
		painelTabuleiro.add(paneInfo, 9 , 0);

    }
    
    public boolean whiteOrBlack(boolean white) {
    	if(white) {
    		white = false;
    	}else {
    		white =  true;
    	}
    	return white;
    }
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void handle(MouseEvent e) {
		boolean found = false;
		if(e.getButton() == MouseButton.PRIMARY) {
			for(Peca p : cp.getListaPecas()) {
				if(p.getImgView() == (ImageView)e.getTarget()) {
					if(!cp.isClicado()) { //se nao esta clicado
						selecionaOrigem(p);
					}else if(cp.getPecaMovida() != p){
						selecionaDestino(p);
						
					}
				}
			}
		}else {
			cp.setPecaMovida(null);
			cp.setClicado(false);
		}
	}

	public void selecionaDestino(Peca p) {
		boolean valido = cp.fazerJogada(p);
		if(valido) {
			quemJoga();
			cp.setClicado(false);
			cp.setListaPecas(new LinkedList<Peca>());
			this.painelTabuleiro.getChildren().clear();
			this.paneInfo.getChildren().clear();
			paint();
			imprimirTabuleiro();
		}
	}

	public void selecionaOrigem(Peca p) {
		if(cp.isTurnoBranco() == p.isWhite() && !p.getName().equals("espaco")) {
			if(p.getName() != "espaco") {
				cp.setPecaMovida(p);
				cp.setClicado(true);
				cp.setTurnoBranco(!cp.isTurnoBranco());
			}
		}
	}
	
	public void quemJoga() {
		if(this.txtQuemJoga.getText().equals("BRANCO")) {
			this.txtQuemJoga.setText("PRETO"); 
			this.txtQuemJoga.setFill(Color.BLACK);
	
			
		}else {
			this.txtQuemJoga.setText("BRANCO"); 
			this.txtQuemJoga.setFill(Color.BLUE);
		}
		
	}
}
