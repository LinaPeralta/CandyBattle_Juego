package view;

import processing.core.PApplet;
import processing.core.PImage;

public class InstructionScreen {
	
	private PApplet app;
	private PImage instructions;
	
	public InstructionScreen (PApplet app) {
		this.app = app;
		instructions = app.loadImage("./data/InstructionsScreen.png");
		
	}
	 
	public void draw() {
		app.image(instructions, 0, 0, 1200, 700);
	}

}
