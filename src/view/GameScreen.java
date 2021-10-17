package view;

import java.util.ArrayList;

import org.w3c.dom.events.MouseEvent;

import com.google.gson.Gson;

import model.Jugador;
import model.Mint;
import model.Twinkie;
import model.Waffle;
import processing.core.PApplet;
import processing.core.PImage;

public class GameScreen implements IObserver {

	private PApplet app;
	
	private TCPConnection tcp;
	
	private PImage game, j1, j2;

	//clases enemigos
	Waffle waffle;
	Mint mint;
	Twinkie twinkie;

	//clase jugador
	Jugador Jugador1, Jugador2;

	//serializacion
	private Gson gson;

	// variables
	private int count;
	private int seg;
	int  puntaje1, puntaje2;	
	boolean GameOver;
	
	//jugadores variables
	int x1,y1;
	


	// arraylist enemigos
	ArrayList<Waffle> waffles1, waffles2;
	ArrayList<Mint> mints1, mints2;
	ArrayList<Twinkie> twinkies1, twinkies2;
	
	//timer
	int s, m, h;

	
	public GameScreen(PApplet app) {

		this.app = app;
		
		// img fondo
		game = app.loadImage("./data/GameScreen.png");

		//img jugadores
		j1 = app.loadImage("./data/jugador1.png");
		j2 = app.loadImage("./data/jugador2.png");

		//serializacion
		gson = new Gson();
		
		// arraylists enemigos
		waffles1 = new ArrayList<Waffle>();
		mints1 = new ArrayList<Mint>();
		twinkies1 = new ArrayList<Twinkie>();

		waffles2 = new ArrayList<Waffle>();
		mints2 = new ArrayList<Mint>();
		twinkies2 = new ArrayList<Twinkie>();

		// Jugadores
		Jugador1 = new Jugador(0, 600, "quieto nene");
		Jugador2 = new Jugador(650,600, "quieto nene");

		// contadores
		count = 0;
		
		//coneccion 
		tcp = TCPConnection.getInstance();
		tcp.setObserver(this);
		
		//timer
		s = 0;
		m = 59;
		h = 0;
		
		GameOver= false;
		
		//puntajes
		puntaje1=50;
		puntaje2=0;
		
		x1= Jugador1.getX();
		y1= Jugador1.getY();
		

	}

	public void draw() {
		// img fondo
		app.image(game, 0, 0, 1200, 700);
		 
		//puntajes en pantalla
		app.text(puntaje1, 280, 40);
		app.text(puntaje2, 925, 40);

		// contadores
		count++;

		//condicion finalizar juego
		if (m == 0) {

			GameOver = true;
		}

		
	
		
		initWaffle();
		initMint();
		initTwinkie();
		pintarEnemigos();
		initJugadores(); 
		//desaparecerEnemigos();
		//jugadorDispara();
	//	timer();
		
		
		

	}
	
///inicializacion enemigos
	public void initWaffle() {

		// arrayList, pintar y mover los waffles
		for (int i = 0; i < waffles1.size(); i++) {

			waffles1.get(i).pintarWaffle(app);
			waffles1.get(i).mover();

		}

		for (int i = 0; i < waffles2.size(); i++) {

			waffles2.get(i).pintarWaffle(app);
			waffles2.get(i).mover();

		}

	}

	public void initMint() {

		// arrayList, pintar y mover los mints
		for (int i = 0; i < mints1.size(); i++) {

			mints1.get(i).pintarMint(app);
			mints1.get(i).mover();

		}

		for (int i = 0; i < mints2.size(); i++) {

			mints2.get(i).pintarMint(app);
			mints2.get(i).mover();

		}
	}

	public void initTwinkie() {

		// arrayList, pintar y mover los Twinkies
		for (int i = 0; i < twinkies1.size(); i++) {

			twinkies1.get(i).pintarTwinkie(app);
			twinkies1.get(i).mover();
		}

		for (int i = 0; i < twinkies2.size(); i++) {

			twinkies2.get(i).pintarTwinkie(app);
			twinkies2.get(i).mover();
		}
	}

	
	///eliminar enemigos
	public void desaparecerEnemigos() {
		
		for (int i = 0; i < twinkies1.size(); i++) {

			if (twinkies1.get(i).getY()>600) {
				twinkies1.remove(i);
			}

		}

		for (int i = 0; i < twinkies2.size(); i++) {

			if (twinkies2.get(i).getY()>600) {
				twinkies2.remove(i);
			}
		}
		
		

	
		for (int i = 0; i < mints1.size(); i++) {

			if (mints1.get(i).getY()>600) {
				mints1.remove(i);
			}
		

		}

		for (int i = 0; i < mints2.size(); i++) {

			if (mints2.get(i).getY()>600) {
				mints2.remove(i);
			}

		}

		// 
		for (int i = 0; i < waffles1.size(); i++) {

			if (waffles1.get(i).getY()>600) {
				waffles1.remove(i);
			}
			

		}

		for (int i = 0; i < waffles2.size(); i++) {

			if (waffles2.get(i).getY()>600) {
				waffles2.remove(i);
			}
			

		}
	}

	public void pintarEnemigos() {
		
		// INTERVALOS DE TIEMPO
		// waffles
		if (count == 60) {

			count = 0;
			int x1 = (int) app.random(50, 500);
			int y1 = 150;

			int x2 = (int) app.random(610, 1200);
			int y2 = 150;
			// int velocidad = 2;

			waffles1.add(new Waffle(app, x1, y1, 1));
			//System.out.println("waffles1: " + waffles1.size());

			waffles2.add(new Waffle(app, x2, y2, 1));
			//System.out.println("waffles2: " + waffles2.size());

			// numero random para generar los diferentes enemigos
			int num = (int) app.random(0, 10);

			if (s <= 50) { 

				if (num == 0 || num == 3 || num == 6) {

					
					twinkies1.add(new Twinkie(app, x1, y1, 2));
					//System.out.println("twinkie1: " + twinkies1.size());

					twinkies2.add(new Twinkie(app, x2, y2, 2));
					//System.out.println("twinkie2: " + twinkies2.size());

				}

			}


			 if (s <= 40) {

				if (num == 1 || num == 2 || num == 5 || num == 7 || num == 8 || num == 9) {
					// ALIENS ROJOS
					mints1.add(new Mint(app, x1, y1, 3));
					//System.out.println(mints1.size());

					mints2.add(new Mint(app, x2, y2, 3));
					//System.out.println(mints2.size());
				}

			}
		}

	}
	
	public void jugadorDispara() {
		
		//jugador 1 dispara
				for (int i = 0; i < Jugador1.getBalas().size(); i++) {
					for (int j = 0; j < twinkies1.size(); j++) {

						if (PApplet.dist(Jugador1.getBalas().get(i).getX(), Jugador1.getBalas().get(i).getY(),
								twinkies1.get(j).getX(), twinkies1.get(j).getY()) < 25) {
							puntaje1 += 5;
							twinkies1.remove(j);
							//Jugador1.getBalitas().remove(i);
						}
					}
					
					for (int k = 0; k < waffles1.size(); k++) {

						if (PApplet.dist(Jugador1.getBalas().get(i).getX(), Jugador1.getBalas().get(i).getY(),
								waffles1.get(k).getX(), waffles1.get(k).getY()) < 25) {
							puntaje1 += 6;
							waffles1.remove(k);
							//Jugador1.getBalitas().remove(i);
						}
					}
					
					for (int l = 0; l < mints1.size(); l++) {

						if (PApplet.dist(Jugador1.getBalas().get(i).getX(), Jugador1.getBalas().get(i).getY(),
								mints1.get(l).getX(), mints1.get(l).getY()) < 25) {
							puntaje1 += 7;
							mints1.remove(l);
							//Jugador1.getBalitas().remove(i);
						}
					}
					
					//enviar puntaje al control
					tcp.getSesiones().get(0).enviarMensaje(" " + puntaje1);
				}
				
				//Jugador 2 dispara
				for (int i = 0; i < Jugador2.getBalas().size(); i++) {
					for (int j = 0; j < twinkies2.size(); j++) {

						if (PApplet.dist(Jugador2.getBalas().get(i).getX(), Jugador2.getBalas().get(i).getY(),
								twinkies2.get(j).getX(), twinkies2.get(j).getY()) < 25) {
							puntaje2 += 5;
							twinkies1.remove(j);
							//Jugador2.getBalitas().remove(i);
						}
					}
					
					for (int k = 0; k < waffles2.size(); k++) {

						if (PApplet.dist(Jugador2.getBalas().get(i).getX(), Jugador2.getBalas().get(i).getY(),
								waffles2.get(k).getX(), waffles2.get(k).getY()) < 25) {
							puntaje2 += 6;
							waffles2.remove(k);
							//Jugador2.getBalitas().remove(i);
						}
					}
					
					for (int l = 0; l < mints2.size(); l++) {

						if (PApplet.dist(Jugador2.getBalas().get(i).getX(), Jugador2.getBalas().get(i).getY(),
								mints2.get(l).getX(), mints2.get(l).getY()) < 25) {
							puntaje2 += 7;
							mints2.remove(l);
							//Jugador2.getBalitas().remove(i);
						}
					}
					
					//enviar puntaje al control
					tcp.getSesiones().get(1).enviarMensaje(" " + puntaje2);
				}
	}
	
	
	public void timer() {
		
		app.fill(0);
		app.textSize(35);

		if (s <= 59) {
			
			s = s + 1;
			app.text(h + " : " + m, 550, 40);
			
		} else {
			
			m = m - 1;
			s = 0;
		}
		if (m <= 59) {
			
		

		} else {
			
			h = 0;
			m = 0;
		}
	}
	
	

	private void initJugadores() {

		
		// inicializar Jugador1
		app.image(j1, x1, y1);

		for (int i = 0; i < Jugador1.getBalas().size(); i++) {
			System.out.println(Jugador1.getX()); 
			Jugador1.getBalas().get(i).draw(app);
			Jugador1.getBalas().get(i).moveBullet();
		}
		

		// inicializar Jugador2
		app.image(j2, Jugador2.getX(), Jugador2.getY());

		for (int i = 0; i < Jugador2.getBalas().size(); i++) {
			Jugador2.getBalas().get(i).draw(app);
			Jugador2.getBalas().get(i).moveBullet();
		}

	}

	@Override
	public void recibirMensaje(Sesion sesion, String mensaje) {
		
		
		
		if (sesion.getID().equals("Jugador0")) {
			Jugador jugador = gson.fromJson(mensaje, Jugador.class);
			Jugador1.setAccion(jugador.getAccion());
			Jugador1.moverJugador();
			


		} else if (sesion.getID().equals("Jugador1")) {

			Jugador jugador = gson.fromJson(mensaje, Jugador.class);
			Jugador2.setAccion(jugador.getAccion()); 
			Jugador2.moverJugador();

		}
		
	}
	
	public boolean isGameOver() {
		return GameOver;
	} 

	public void setGameOver(boolean gameOver) {
		GameOver = gameOver;
	}


	public PImage getJ1() {
		return j1;
	}

	public void setJ1(PImage j1) {
		this.j1 = j1;
	}

	public PImage getJ2() {
		return j2;
	}

	public void setJ2(PImage j2) {
		this.j2 = j2;
	}

	public Jugador getJugador1() {
		return Jugador1;
	}

	public void setJugador1(Jugador jugador1) {
		Jugador1 = jugador1;
	}

	public Jugador getJugador2() {
		return Jugador2;
	}

	public void setJugador2(Jugador jugador2) {
		Jugador2 = jugador2;
	}

	public int getPuntaje1() {
		return puntaje1;
	}

	public void setPuntaje1(int puntaje1) {
		this.puntaje1 = puntaje1;
	}

	public int getPuntaje2() {
		return puntaje2;
	}

	public void setPuntaje2(int puntaje2) {
		this.puntaje2 = puntaje2;
	}
	
	
	
}
