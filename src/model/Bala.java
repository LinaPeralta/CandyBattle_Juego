package model;

import processing.core.PApplet;

public class Bala {
	
		
		private int x, y, velocidad;

		public Bala (int x, int y) {
			this.x = x;
			this.y = y;
			this.velocidad = 3;
		}
		
		public void draw(PApplet app) {
			
				app.fill (50,23,16);
				app.rect (x+10,y,5,20);
			
		}
		
		//movimineto bala de player
		public void moveBullet() {
			y-=velocidad;
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

}
