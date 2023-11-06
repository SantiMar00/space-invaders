package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import modelo.Partida;
import modelo.Ranking;
import views.BateriaView;
import views.ProyectilBateriaView;


public class Controlador { // Singleton
	
	private static Controlador instance;
	
	private Controlador() {}
	
    public static Controlador getInstance() {
    	if(instance == null) {
    		instance = new Controlador();
    	}
    	return instance;
    }
    
    
    public Partida partida;
    public Ranking ranking;
    
    public void iniciarPartida(String dificultad) {
    	
        this.partida = new Partida(dificultad);
        
    }
    
    public void moverBateria(String direccion, BateriaView batView) {
    	
    	if(direccion == "Derecha") {
    		batView.setVelocidad(2);
    	}
    	
    	else if(direccion == "Izquierda") {
    		batView.setVelocidad(-2);
    	}
    	
    	else {
    		batView.setVelocidad(0);
    	}
    	
    }
    
    public void dispararBateria(int batX, int batY, ProyectilBateriaView pbv) {
		pbv.setEstado(true);
		pbv.setPosicionx(batX);
		pbv.setPosiciony(batY);
    }
    
    public void leerRanking() {
    	this.ranking = new Ranking();
    	this.ranking.inicializarRanking();
    	
    	
    	try {
			FileReader bloc = new FileReader("ranking.txt");
			BufferedReader buffer = new BufferedReader(bloc);
	
			String[] fila;
			String nombre; String strPuntaje; int puntaje;
		
			for(String line = buffer.readLine(); line != null; line = buffer.readLine()) {
				fila = line.split(",");
				nombre = fila[0];
				strPuntaje = fila[1];
				puntaje = Integer.parseInt(strPuntaje);
				this.ranking.agregarRanking(nombre, puntaje);
			}
			
			bloc.close();
    	}
    	catch(IOException ex) {
    		System.out.println (ex.toString());
            System.out.println("Could not find file");

    	}
	}
    
    public void editarRanking(String nombre, String puntaje) {
    	try {
    		String texto = nombre + "," + puntaje;
    		
    		FileReader bloc = new FileReader("ranking.txt");
			BufferedReader buffer = new BufferedReader(bloc);
			
			
			String[] fila;
			boolean escribio = false;
			for(String line = buffer.readLine(); line != null; line = buffer.readLine()) {
				fila = line.split(",");
				if(fila[0].equals(nombre) && Integer.parseInt(fila[1]) < Integer.parseInt(puntaje)) {
					FileWriter fw = new FileWriter("ranking.txt", false);
		    		BufferedWriter bw = new BufferedWriter(fw);
					bw.write(texto);
					bw.newLine();
		    		bw.close();
					escribio = true;
				}
				
			}
			
			if(escribio == false) {
				FileWriter fw = new FileWriter("ranking.txt", true);
	    		BufferedWriter bw = new BufferedWriter(fw);
				bw.write(texto);
				bw.newLine();
	    		bw.close();
			}
    		
			buffer.close();
    		
    	}
    	catch(Exception e) {
    		System.out.println("Error escribiendo");
    	}
    	
    }

}