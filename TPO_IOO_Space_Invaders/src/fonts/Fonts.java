package fonts;

import java.awt.Font;
import java.io.InputStream;

/**
 *@author Gimenez Aiello, Mariño
 */
public class Fonts {
	
	private Font font;
	
	public Font cargarFont(String nombre, float tamaño) {
		
		try {
			InputStream strm = getClass().getResourceAsStream(nombre);
			font = Font.createFont(Font.TRUETYPE_FONT, strm); 
		}
		catch(Exception e){
			System.out.println("ERROR AL CARGAR LA FUENTE");
		}
		Font ret = font.deriveFont(tamaño);
		return ret;
	}
}
