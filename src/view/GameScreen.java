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

	ArrayList<Waffle> waffles;
	ArrayList<Mint> mints;
	ArrayList<Twinkie> twinkies;

	public GameScreen(PApplet app) {

		// img fondo
		this.app = app;
		game = app.loadImage("./data/GameScreen.png");
		
		
		// arraylists
		waffles = new ArrayList<Waffle>();
		mints = new ArrayList<Mint>();
		twinkies = new ArrayList<Twinkie>();

		// contadores
		count = 0;
		seg = 0;

	}

	public void draw() {
		// img fondo
		app.image(game, 0, 0, 1200, 700);

		// contadores
		count++;

		// INTERVALOS DE TIEMPO
		// waffles
		if (count == 60) {

			count = 0;
			int x = (int) app.random(50, 500);
			int y = 50;
			// int velocidad = 2;

			waffles.add(new Waffle(app, x, y, 2));
			System.out.println(waffles.size());

			// numero random para generar los diferentes enemigos
			float num = (int) app.random(0, 10);

			if (seg < 15) {

				if (num == 1) {
					// mints

					mints.add(new Mint(app, x, y, 3));
					System.out.println(mints.size());

				}

			}

			else if (seg >= 15) {
				if (num == 1 || num == 3 || num == 6) {
					// arrayList, pintar y mover los twinkies

					twinkies.add(new Twinkie(app, x, y, 5));
					System.out.println(twinkies.size());

				}

			}

			else if (seg >= 30) {

				if (num == 1 || num == 2 || num == 5 || num == 7 || num == 8 || num == 9) {
					// ALIENS ROJOS
					mints.add(new Mint(app, x, y, 3));
					System.out.println(mints.size());
				}

			}
		}

	}


	public void initWaffle() {

		// arrayList, pintar y mover los aliens verdes
		for (int i = 0; i < waffles.size(); i++) {

			waffles.get(i).pintarWaffle(app);
			waffles.get(i).mover();

		}

	}

	public void initMint() {

		// arrayList, pintar y mover los aliens verdes
		for (int i = 0; i < mints.size(); i++) {

			mints.get(i).pintarMint(app);
			mints.get(i).mover();

		}
	}

	public void initTwinkie() {

		// arrayList, pintar y mover los aliens verdes
		for (int i = 0; i < waffles.size(); i++) {

			waffles.get(i).pintarWaffle(app);
			waffles.get(i).mover();
		}
	}
}
