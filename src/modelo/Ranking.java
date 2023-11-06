package modelo;

import java.util.HashMap;
import java.util.LinkedHashMap;


public class Ranking {
		
	class nodo{
		String nombre;
		int puntaje;
		nodo sig;
	}
	
	nodo head;
    
    public void inicializarRanking() {
    	head = null;
    }
    
    
    public void agregarRanking(String nombre, int puntaje) {
		nodo nuevo = new nodo();
		nuevo.nombre = nombre;
		nuevo.puntaje = puntaje;
		if(head == null || puntaje > head.puntaje) { // Si lo tiene que agregar al principio
    		nuevo.sig = head;
    		head = nuevo;
    	}
		else {
			nodo aux = head;
	    	while(aux.sig != null && puntaje <= aux.sig.puntaje) {
	    		aux = aux.sig;
	    	}
	    	nuevo.sig = aux.sig;
	    	aux.sig = nuevo;
		}
		
		// Eliminar nodo n° 11
		int cont = 0;
		nodo aux = head;
		while(aux != null) {
			aux = aux.sig;
			cont++;
		}
		if(cont == 11) {
			nodo aux2 = head;
			while(aux2.sig.sig != null) {
				aux2 = aux2.sig;
			}
			aux2.sig = null;
		}
    }
    
    
    // Agrega los elementos del ranking a un arreglo de dos dimensiones para pasarlos a JLabels
    public HashMap<String, String> rankingToArray() {
    	HashMap<String, String> ret = new LinkedHashMap<String, String>();
    	String nombre;
    	String puntaje;
    	int puntos;
    	nodo aux = head;
    	while(aux != null) {
    		nombre = aux.nombre;
    		puntos = aux.puntaje;
    		puntaje = Integer.toString(puntos);
    		ret.put(nombre, puntaje);
    		aux = aux.sig;
    	}
    	return ret;
    }
    	
}