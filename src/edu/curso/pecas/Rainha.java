package edu.curso.pecas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rainha extends Peca{
	public Rainha(int y, int x, boolean white) {
		super(y, x, white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ImageView getImgView() {
		Image img;
		if(isWhite()) {
			img = new Image("file:src/edu/curso/images/QB.PNG");
		}else {
			img = new Image("file:src/edu/curso/images/QP.PNG");
		}
		imgView.setImage(img);
		return super.getImgView();
	}
}
