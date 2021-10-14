package view;

import com.google.gson.Gson;

import model.Jugador;
import processing.core.PApplet;

public class Main extends PApplet implements IObserver {

	//TCP
	private TCPConnection tcp;
	
	//Pantallas
	private StartScreen startScreen;
	private InstructionScreen instructionsScreen;
	private ConnectionScreen connectionScreen;
	private GameScreen gameScreen;
	private FinishScreen finishScreen;
	
	private Sesion sesion;
	
	
	//Cambio de pantallas
	private int screen;
	
	public static void main(String[] args) {
		PApplet.main("view.Main");
	}
		
	
	@Override
	public void settings() {
		size(1200,700);

	}

	@Override
	public void setup() {

		// clase TPC
		tcp = TCPConnection.getInstance();
		tcp.setObserver(this);
		
	
		// Clase pantallas
		startScreen = new StartScreen(this);
		instructionsScreen = new InstructionScreen(this);
		connectionScreen = new ConnectionScreen(this);
		gameScreen = new GameScreen(this);
		finishScreen = new FinishScreen(this);
		
		sesion= new Sesion();

		// aja cambio de pantallas
		screen = 4;


		
	}
	
	@Override
	public void draw() {
		background(255);
		
		switch (screen) {
		//Start screen 
		case 1:
			startScreen.draw();
			break;
		//Instruction screen
		case 2:
			instructionsScreen.draw();
			break;
		//Connection screen
		case 3:
			connectionScreen.draw();
			
			break;
		//Play screen
		case 4:
			gameScreen.draw();
			break;
			
		case 5:
			finishScreen.draw();
			break;

		}
	}
	
	@Override
	public void mousePressed() {
		
		
		switch (screen) {
		//Start screen 
		case 1:
			if (mouseX > 515 && mouseX < 706 && mouseY > 605 && mouseY < 671) {
				screen = 2;
			}
			break;
		//Instruction screen
		case 2:
			if (mouseX > 965 && mouseX < 1142 && mouseY > 561 && mouseY < 624) {
				screen = 3;
			}
			break;
		//Connection screen
		case 3:
			if (mouseX > 965 && mouseX < 1142 && mouseY > 561 && mouseY < 624) {
					screen = 4;
			}
		//Game screen	
		case 4:
			
			
			
			if (mouseX > 515 && mouseX < 706 && mouseY > 605 && mouseY < 671) {
					screen = 5;
			}
			break;
		
		//Finish screen
		case 5:
			if (mouseX > 965 && mouseX < 1142 && mouseY > 561 && mouseY < 624 ) {
					exit();
			}
			break;
		}
	}
	
	


	

	@Override
	public void notificarMensaje(Sesion sesion, String mensaje) {
		

		
		
	}
	
}
