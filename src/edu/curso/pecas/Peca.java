package edu.curso.pecas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Peca {
	private int x;
	private int y;
	private boolean white;
	private String name;

	ImageView imgView = new ImageView(new Image("file:src/edu/curso/images/SPACE.PNG"));
	
	public Peca(int y, int x, boolean white) {
		this.y = y;
		this.x = x;
		this.white = white;
		nameColor(white);
	}
	private void nameColor(boolean white) {
		if(white) {
			this.name = this.getClass().getName() + "Branco";
		}else {
			this.name = this.getClass().getName() + "Preto";
		}
		
		if(this.getClass().getName() == "edu.curso.pecas.Peca") {
			this.name = "espaco";
		}
	}
	

	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isWhite() {
		return white;
	}
	public void setWhite(boolean white) {
		this.white = white;
	}
	public ImageView getImgView() {
		return imgView;
	}
	public void setImg(ImageView imgView) {
		this.imgView = imgView;
	}
	public String getName() {
		return name;
	}

}
