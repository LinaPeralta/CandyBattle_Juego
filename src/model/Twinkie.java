package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Twinkie {

	// variables
	public int x, y;
	private boolean move;
	public int velocidad;

	// Twinkie
	private PImage TWINKIE;

	public Twinkie(PApplet app, int x, int y, int velocidad) {
		TWINKIE = app.loadImage("data/TWINKIE.png");

		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		move = true;
	}

	public void pintarWaffle(PApplet app) {
		app.imageMode(app.CENTER);
		app.image(TWINKIE, x, y,100,100);
		app.imageMode(app.CORNER);
	}

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

	public PImage getTWINKIE() {
		return TWINKIE;
	}

	public void setTWINKIE(PImage tWINKIE) {
		TWINKIE = tWINKIE;
	}
	

}
