package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Mint {

	// variables
	public int x, y;
	private boolean move;
	public int velocidad;

	// mint
	private PImage MINT;

	public Mint(PApplet app, int x, int y, int velocidad) {
		MINT = app.loadImage("data/MINT.png");

		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		move = true;
	}

	//dibujar enemigo
	public void pintarMint(PApplet app) {
		app.imageMode(app.CENTER);
		app.image(MINT, x, y,100,100);
		app.imageMode(app.CORNER);
	}

	//mover enemigo
	public void mover() {

		if (move) {
			y += velocidad;
		}

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public PImage getMINT() {
		return MINT;
	}

	public void setMINT(PImage mINT) {
		MINT = mINT;
	}

}
