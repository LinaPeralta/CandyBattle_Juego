package view;

import processing.core.PApplet;
import processing.core.PImage;

public class FinishScreen {
	
	private PApplet app;
	private PImage finish;
	
	public FinishScreen (PApplet app) {
		this.app = app;
		finish= app.loadImage("./data/FinishScreen.png");
		
	}
	
	public void draw() {
		app.image(finish, 0, 0, 1200, 700);
	}

}
