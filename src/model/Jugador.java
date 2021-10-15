package model;

import java.util.ArrayList;

public class Jugador {
	
	private int x,y;
	private String accion;
	private int velocidad;
	private ArrayList<Bala> balas;
	
	public Jugador (int x, int y, String accion) {
		this.x = x;
		this.y=y;  
		this.velocidad = 30;
		this.accion = accion;
		
		//array
		balas = new ArrayList <>();
		
	}
	
	public void moverJugador() {
		switch (accion) {
		case "izquierda":
			x-=velocidad;
			break;
		case "derecha":
			x+=velocidad;
			break;
		case "disparo":
			crearBalita();
			System.out.println("disparo");
		case "quieto nene":
			System.out.println("no me muevo jiji");
			break;
		}
		
		}
	
	

	
	private void crearBalita() {
		
			Bala bala = new Bala(x, y);
			balas.add(bala);
		

		
	}
	
	public void eliminarBalita() {
		for (int i = 0; i < balas.size(); i++) {
			if (balas.get(i).getY() < 0) {
				balas.remove(i);
			}
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

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public ArrayList<Bala> getBalitas() {
		return balas;
	}

	public void setBalitas(ArrayList<Bala> balitas) {
		this.balas = balitas;
	}
	
	
	
	
	
	

}
