package view;

	import java.io.IOException;
	import java.net.ServerSocket;
	import java.net.Socket;
	import java.util.ArrayList;

public class TCPConnection extends Thread{


		private static TCPConnection tcp;
		private ServerSocket server;
		private IObserver observer;
		private ArrayList<Sesion> sesiones;
		
		private TCPConnection() {
			this.sesiones = new ArrayList<>();
		}

		public static TCPConnection getInstance() {
			if(tcp == null) {
				tcp = new TCPConnection();
				tcp.start();
			}
			
			return tcp;	
		}
		
		@Override
		public void run() {
			initConnection();
		}
		
		private void initConnection(){
			try {
				
				System.out.println("Iniciando servidor");
				server = new ServerSocket(9000);
				
				while(sesiones.size() < 2) {
					System.out.println("Esperando clientes");
					Socket socket = server.accept(); 
					
					Sesion sesion = new Sesion(socket, observer, "jugador" + sesiones.size());
					sesiones.add(sesion);
					sesion.start();
					System.out.println("Cliente "+ sesiones.size() + " conectado");
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public IObserver getObserver() {
			return observer;
		}

		public void setObserver(IObserver observer) {
			this.observer = observer;
		}
		
		public ArrayList<Sesion> getSesiones() {
			return sesiones;
		}



	}

