package modelo;


import controlador.Controlador;


public class Partida {

	// Constructor
    public Partida(String dificultad) {
    	this.dificultad = dificultad;
    	this.puntaje = 0;
    	this.nivel = 1;
    	this.altoPantalla = 800;
    	this.anchoPantalla = 600;
    }

    public String dificultad; 
    
    public int puntaje;
    
    public int nivel;

    public int anchoPantalla;

    public int altoPantalla;
    
    public int velocidadNavesMS; public int velocidadNavesPX;
        
    public Jugador jugador;
    
    public Bateria bateria;

    public ProyectilBateria pb;

    public ProyectilEnemigo pe;

    public NaveEnemiga nave;
    public NaveEnemiga[] naves;
    
    public Muro muro;
    public Muro[] muros;
        

    public void nuevaPartida(String nombre, String dificultad) {
    	this.jugador = new Jugador(nombre);
    	this.bateria = new Bateria();
    	this.muros = new Muro[4];
    	this.pb = new ProyectilBateria(0, 0);
    	this.pe = new ProyectilEnemigo(0, 0);
		this.velocidadNavesPX = 20;

    	// Asignar velocidad movimiento naves en milisegundos para el timer
    	if(dificultad.equals("Cadete")) {
    		this.velocidadNavesMS = 1000;
    	}
    	else if(dificultad.equals("Guerrero")) {
    		this.velocidadNavesMS = 800;
    	}
    	else if(dificultad.equals("Maestro")){
    		this.velocidadNavesMS = 600;
    	}
    	
    	// Ciclo muros
    	int x = 72; int y = 460;
    	for(int i = 0; i < 4; i++) {
    		muro = new Muro(x, y);
    		muros[i] = muro;
    		x += 180;
    	}
    }
    
    public void generarNaves() {
    	this.naves = new NaveEnemiga[15];
    	int cont = 0;
    	// Ciclo naves
    	int y = 80;
    	for(int i = 0; i < 3; i++) {
    		int x = 220;
    		for(int j = 0; j < 5; j++) {
    			nave = new NaveEnemiga(x, y, velocidadNavesPX);
    			naves[cont] = nave;
    			x += 70; // distancia entre columnas
    			cont++;
    		}
    		y += 50; // distancia entre filas
    	}
    }
    
    public void sumarPuntos(int x) {
    	puntaje += x;
    }
    
    public void agregarRanking() {
    	String nombre = jugador.devolverNombre();
    	String puntos = Integer.toString(puntaje);
    	Controlador.getInstance().editarRanking(nombre, puntos);
    }

   
}