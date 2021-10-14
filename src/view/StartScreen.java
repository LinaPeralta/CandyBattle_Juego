package view;

import processing.core.PApplet;
import processing.core.PImage;

public class StartScreen {
	
	private PApplet app;
	private PImage start;

	public StartScreen(PApplet app) {
		this.app = app;
		start = app.loadImage("./data/StartScreen.png");
		
	}
	
	public void draw() {
		app.image(start, 0, 0, 1200, 700);
	}

}
