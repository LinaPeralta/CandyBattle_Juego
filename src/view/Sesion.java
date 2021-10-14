package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Sesion extends Thread{

	private String id;
	private BufferedWriter bw;
	private BufferedReader bf;
	private Socket socket;
	private IObserver observer;
	
	public Sesion(Socket socket, IObserver observer, String id) {
		this.socket = socket;
		this.observer = observer;
		this.id = id;
	}
	
	public Sesion() {
		
	}
	
	@Override
	public void run() {
		try {
			//To receive
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			bf = new BufferedReader(isr);
			
			//To transmit
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			
			recibirMensaje();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void recibirMensaje() {
		new Thread(
				() -> {
					while(true) {
						try {
							String msj = bf.readLine(); 
							observer.notificarMensaje(this, msj);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}).start();	
	}
	
	public void enviarMensaje(String mensaje) {
		new Thread(()->{
			//Write message
			try {
				bw.write(mensaje + "\n");
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
		
	}
	
	public String getID() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}



	
}
