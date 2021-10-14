package view;

import processing.core.PApplet;
import processing.core.PImage;

public class ConnectionScreen {
	
	private PApplet app;
	private PImage connection;
	
	public ConnectionScreen (PApplet app) {
		this.app = app;
		connection = app.loadImage("./data/ConnectionScreen.png");
		

	}
	
	public void draw() {
		
		app.image(connection, 0, 0, 1200, 700);
	
	}
	
	

}
