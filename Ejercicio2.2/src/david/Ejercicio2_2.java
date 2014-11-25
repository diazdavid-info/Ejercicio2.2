package david;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio2_2 extends Applet implements ActionListener{
	private static final long serialVersionUID = 1L;
	private Button boton1;
	private Button boton2;
	private MiHebra miHebra1;
	private MiHebra miHebra2;
	private int contador1 = 10;
	private int contador2 = 100;
	
	public void init(){
		setBackground(Color.yellow);
		add(boton1 = new Button("Iniciar hilo 1"));
		boton1.addActionListener(this);
		
		add(boton2 = new Button("Iniciar hilo 2"));
		boton2.addActionListener(this);
	}
	
	public void start(){
		miHebra1 = new MiHebra(contador1,this);
		miHebra2 = new MiHebra(contador2,this);
		
		miHebra1.start();
		miHebra2.start();
	}
	
	public void paint(Graphics g){
		contador1 = miHebra1.getContador();
		contador2 = miHebra2.getContador();
		g.drawString(Integer.toString(contador1), 80, 100);
		g.drawString(Integer.toString(contador2), 80, 120);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton1){
			//miHebra1.stop();
			miHebra1.parar();
			boton1.setLabel("Finalizado hilo 1");
		}else if(e.getSource() == boton2){
			//miHebra2.stop();
			miHebra2.parar();
			boton2.setLabel("Finalizado hilo 2");
		}
		
	}

}
