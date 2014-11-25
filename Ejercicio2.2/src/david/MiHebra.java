package david;

import java.applet.Applet;

public class MiHebra extends Thread{
	private int contador;
	private Applet applet;
	private boolean parar = false;
	
	public MiHebra(int contador, Applet a){
		this.contador = contador;
		applet = a;
	}
	
	public void run(){
		while (!parar) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			contador++;
			applet.repaint();
		}
	}
	
	public void parar(){
		parar = true;
	}
	
	public int getContador() {
		return contador;
	}

}
