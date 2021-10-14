package view;

import java.util.ArrayList;

import model.Mint;
import model.Twinkie;
import model.Waffle;
import processing.core.PApplet;
import processing.core.PImage;

public class GameScreen {

	private PApplet app;
	private PImage game;
	Waffle waffle;
	Mint mint;
	Twinkie twinkie;

	// variables
	private int count;
	private int seg;

	// arraylist

	ArrayList<Waffle> waffles1, waffles2;
	ArrayList<Mint> mints1, mints2;
	ArrayList<Twinkie> twinkies1, twinkies2;

	public GameScreen(PApplet app) {

		// img fondo
		this.app = app;
		game = app.loadImage("./data/GameScreen.png");
		
		
		// arraylists
		waffles1 = new ArrayList<Waffle>();
		mints1 = new ArrayList<Mint>();
		twinkies1 = new ArrayList<Twinkie>();
		
		waffles2 = new ArrayList<Waffle>();
		mints2 = new ArrayList<Mint>();
		twinkies2 = new ArrayList<Twinkie>();

		// contadores
		count = 0;
		seg = 0;

	}

	public void draw() {
		// img fondo
		app.image(game, 0, 0, 1200, 700);

		// contadores
		count++;
		
		initWaffle();
		initMint();
		initTwinkie();
		pintarEnemigos();
		

		
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
					System.out.println("waffles1: "+waffles1.size());
					
					waffles2.add(new Waffle(app, x2, y2, 2));
					System.out.println("waffles2: "+waffles2.size());

					// numero random para generar los diferentes enemigos
					float num = (int) app.random(0, 10);

					if (seg < 15) {

						if (num == 1) {
							// mints

							mints1.add(new Mint(app, x1, y1, 3));
							System.out.println("mints1: "+mints1.size());
							
							mints2.add(new Mint(app, x2, y2, 3));
							System.out.println("mints2: "+mints2.size());

						}

					}

					else if (seg >= 15) {
						if (num == 1 || num == 3 || num == 6) {
							// arrayList, pintar y mover los twinkies

							twinkies1.add(new Twinkie(app, x1, y1, 5));
							System.out.println("twinkie1: "+twinkies1.size());
							
							twinkies2.add(new Twinkie(app, x2, y2, 5));
							System.out.println("twinkie2: "+twinkies2.size());

						}

					}

					else if (seg >= 30) {

						if (num == 1 || num == 2 || num == 5 || num == 7 || num == 8 || num == 9) {
							// ALIENS ROJOS
							mints1.add(new Mint(app, x1, y1, 3));
							System.out.println(mints1.size());
							
							mints2.add(new Mint(app, x2, y2, 3));
							System.out.println(mints2.size());
						}

					}
				}

		
	}
}
