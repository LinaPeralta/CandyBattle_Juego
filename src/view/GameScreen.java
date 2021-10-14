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

	Waffle waffle;
	Mint mint;
	Twinkie twinkie;

	Jugador Jugador1, Jugador2;

	private Gson gson;

	// variables
	private int count;
	private int seg;
	
	boolean GameOver;
	
	int  puntaje1, puntaje2;

	// arraylist

	ArrayList<Waffle> waffles1, waffles2;
	ArrayList<Mint> mints1, mints2;
	ArrayList<Twinkie> twinkies1, twinkies2;
	
	//timer
	int s, m, h;

	public GameScreen(PApplet app) {

		// img fondo
		this.app = app;
		game = app.loadImage("./data/GameScreen.png");

		j1 = app.loadImage("./data/jugador1.png");
		j2 = app.loadImage("./data/jugador2.png");

		gson = new Gson();
		

		// arraylists
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
		seg = 0;
		
		tcp = TCPConnection.getInstance();
		tcp.setObserver(this);
		
		s = 0;
		m = 59;
		h = 0;
		
		GameOver= false;
		
		puntaje1=0;
		puntaje2=0;

	}

	public void draw() {
		// img fondo
		app.image(game, 0, 0, 1200, 700);
		
		app.text(puntaje1, 280, 40);
		app.text(puntaje2, 925, 40);

		// contadores
		count++;
		
		if(m==0) {
		
				
		GameOver=true;
		}

		initWaffle();
		initMint();
		initTwinkie();
		pintarEnemigos();
		initJugadores(); 
		desaparecerEnemigos();
		jugadorDispara();
		timer();

	}
	

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

			twinkies1.get(i).pintarWaffle(app);
			twinkies1.get(i).mover();
		}

		for (int i = 0; i < twinkies2.size(); i++) {

			twinkies2.get(i).pintarWaffle(app);
			twinkies2.get(i).mover();
		}
	}
	
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
		
		

		// arrayList, pintar y mover los mints
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

		// arrayList, pintar y mover los waffles
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
			int y1 = 50;

			int x2 = (int) app.random(600, 1200);
			int y2 = 50;
			// int velocidad = 2;

			waffles1.add(new Waffle(app, x1, y1, 2));
			System.out.println("waffles1: " + waffles1.size());

			waffles2.add(new Waffle(app, x2, y2, 2));
			System.out.println("waffles2: " + waffles2.size());

			// numero random para generar los diferentes enemigos
			int num = (int) app.random(0, 10);

			if (seg < 15) {

				if (num == 1 || num == 3 || num == 6|| num == 9) {
					
					
					twinkies1.add(new Twinkie(app, x1, y1, 3));
					System.out.println("twinkie1: " + twinkies1.size());

					twinkies2.add(new Twinkie(app, x2, y2, 3));
					System.out.println("twinkie2: " + twinkies2.size());

				}

			}


			 if (seg < 15) {

				if (num == 1 || num == 2 || num == 5 || num == 7 || num == 8 || num == 9) {
					// ALIENS ROJOS
					mints1.add(new Mint(app, x1, y1, 4));
					System.out.println(mints1.size());

					mints2.add(new Mint(app, x2, y2, 4));
					System.out.println(mints2.size());
				}

			}
		}

	}
	
	public void jugadorDispara() {
		
		
				for (int i = 0; i < Jugador1.getBalitas().size(); i++) {
					for (int j = 0; j < twinkies1.size(); j++) {

						if (PApplet.dist(Jugador1.getBalitas().get(i).getX(), Jugador1.getBalitas().get(i).getY(),
								twinkies1.get(j).getX(), twinkies1.get(j).getY()) < 25) {
							puntaje1 += 5;
							twinkies1.remove(j);
						}
					}
					
					for (int k = 0; k < waffles1.size(); k++) {

						if (PApplet.dist(Jugador1.getBalitas().get(i).getX(), Jugador1.getBalitas().get(i).getY(),
								waffles1.get(k).getX(), waffles1.get(k).getY()) < 25) {
							puntaje1 += 6;
							waffles1.remove(k);
						}
					}
					
					for (int l = 0; l < mints1.size(); l++) {

						if (PApplet.dist(Jugador1.getBalitas().get(i).getX(), Jugador1.getBalitas().get(i).getY(),
								mints1.get(l).getX(), mints1.get(l).getY()) < 25) {
							puntaje1 += 7;
							mints1.remove(l);
						}
					}
				}
				
				for (int i = 0; i < Jugador2.getBalitas().size(); i++) {
					for (int j = 0; j < twinkies2.size(); j++) {

						if (PApplet.dist(Jugador2.getBalitas().get(i).getX(), Jugador2.getBalitas().get(i).getY(),
								twinkies2.get(j).getX(), twinkies2.get(j).getY()) < 25) {
							puntaje2 += 5;
							twinkies1.remove(j);
						}
					}
					
					for (int k = 0; k < waffles2.size(); k++) {

						if (PApplet.dist(Jugador2.getBalitas().get(i).getX(), Jugador2.getBalitas().get(i).getY(),
								waffles2.get(k).getX(), waffles2.get(k).getY()) < 25) {
							puntaje2 += 6;
							waffles2.remove(k);
						}
					}
					
					for (int l = 0; l < mints2.size(); l++) {

						if (PApplet.dist(Jugador2.getBalitas().get(i).getX(), Jugador2.getBalitas().get(i).getY(),
								mints2.get(l).getX(), mints2.get(l).getY()) < 25) {
							puntaje2 += 7;
							mints2.remove(l);
						}
					}
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

		// Jugador1
		app.image(j1, Jugador1.getX(), Jugador1.getY());

		for (int i = 0; i < Jugador1.getBalitas().size(); i++) {
			Jugador1.getBalitas().get(i).draw(app);
			Jugador1.getBalitas().get(i).moveBullet();
		}

		// Jugador2
		app.image(j2, Jugador2.getX(), Jugador2.getY());

		for (int i = 0; i < Jugador2.getBalitas().size(); i++) {
			Jugador2.getBalitas().get(i).draw(app);
			Jugador2.getBalitas().get(i).moveBullet();
		}

	}

	@Override
	public void notificarMensaje(Sesion sesion, String mensaje) {
		
		if (sesion.getID().equals("Jugador0")) {
			Jugador jugador = gson.fromJson(mensaje, Jugador.class);
            System.out.println("el mensaje al jugador fue:  "+jugador);
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
	
	
}
