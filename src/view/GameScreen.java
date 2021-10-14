package view;

import processing.core.PApplet;
import processing.core.PImage;

public class GameScreen {
	
	private PApplet app;
	private PImage game;
	
	public GameScreen (PApplet app) {
		this.app = app;
		game = app.loadImage("./data/GameScreen.png");
		
	}
	
	public void draw() {
		app.image(game, 0, 0, 1200, 700);
	}

}
