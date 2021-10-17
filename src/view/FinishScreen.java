package view;

import processing.core.PApplet;
import processing.core.PImage;

public class FinishScreen {
	
	private PApplet app;
	private PImage finish,jugador1,jugador2;
	private GameScreen gameScreen;
	
	
	public FinishScreen (PApplet app) {    
		this.app = app;
		finish= app.loadImage("./data/FinishScreen.png");
		jugador1= app.loadImage("./data/jugador1.png");
		jugador2= app.loadImage("./data/jugador2.png");
		gameScreen = new GameScreen(app);
		
	}
	
	public void draw() {
		//img fondo
		app.image(finish, 0, 0, 1200, 700);
		
		//si jugador 1 gana
		if(gameScreen.getPuntaje1()> gameScreen.getPuntaje2()) {
			app.image(jugador1, 450, 300,300,300);
			app.textSize(45);
			app.fill(50,23,16);
			app.text(gameScreen.getPuntaje1(), 550, 280);
			
			//si jugador2 gana
		}else if(gameScreen.getPuntaje2()> gameScreen.getPuntaje1()) {
			app.image(jugador2, 450, 300,300,300);
			app.textSize(45);
			app.fill(50,23,16);
			app.text(gameScreen.getPuntaje2(), 550, 280);
		}
		//si hay empate
		else if(gameScreen.getPuntaje2()== gameScreen.getPuntaje1()) {
			app.image(jugador2, 620, 300,300,300);
			app.image(jugador1, 280, 300,300,300);
			app.textSize(45);
			app.fill(50,23,16);
			app.text(gameScreen.getPuntaje2(), 550, 280);
		}
	}

}
