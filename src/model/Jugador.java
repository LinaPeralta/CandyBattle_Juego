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
			
			//array de las balas
			balas = new ArrayList <>();
			
		}
		
		public void moverJugador() {
			switch (accion) {
			//mover a la izquierda al jugador
			case "izquierda":
				x-=velocidad;
				break;
				// mover a la derecha al jugador
			case "derecha":
				x+=velocidad;
				break;
				//el jugador dispara
			case "disparo":
				crearBalita();
				System.out.println("disparo");
				//el jugador no hace nada
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

		public ArrayList<Bala> getBalas() {
			return balas;
		}

		public void setBalas(ArrayList<Bala> balas) {
			this.balas = balas;
		}
		
		
		


}
