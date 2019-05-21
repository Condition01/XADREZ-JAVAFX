package edu.curso.pecas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cavalo extends Peca{
	public Cavalo(int y, int x, boolean white) {
		super(y, x, white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ImageView getImgView() {
		Image img;
		if(isWhite()) {
			img = new Image("file:src/edu/curso/images/CB.PNG");
		}else {
			img = new Image("file:src/edu/curso/images/CP.PNG");
		}
		imgView.setImage(img);
		return super.getImgView();
	}
}
