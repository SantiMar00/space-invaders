package gui;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.Controlador;

import views.BateriaView;
import views.MuroView;
import views.NaveEnemigaView;
import views.ProyectilBateriaView;
import views.ProyectilEnemigoView;

import fonts.Fonts;


public class GUI extends JFrame {
	
	private static final long serialVersionUID = 2661034197545565166L;
	
	GUI g = this;
    Fonts retro = new Fonts();
	JMenuBar mbMenu;
	JMenu mJuego;
	
	// Menu Juego
	JMenuItem miReiniciar; JMenuItem miSalir; JMenuItem miGuardarYSalir;
	
	// Elementos Ventana Inicio
	JFrame frInicio; JPanel pnInicio;
	JLabel lblTitle;
	JButton btnIniciarPartida;
	JButton btnVerRanking;
	JButton btnReglas;
	JButton btnControles;
	
	// Elementos Ventana Ranking
	JPanel pnRanking;
	JLabel lblTituloRanking;
	JLabel lblSubTituloRankingNombre;
	JLabel lblSubTituloRankingPuntaje;
	JLabel lblNombre1; JLabel lblNombre2; JLabel lblNombre3; JLabel lblNombre4; 
	JLabel lblNombre5; JLabel lblNombre6; JLabel lblNombre7; JLabel lblNombre8; 
	JLabel lblNombre9; JLabel lblNombre10;
	JButton btnVolverRanking;
	JLabel[] lblnombresRanking = {lblNombre1, lblNombre2, lblNombre3, lblNombre4, lblNombre5, 
			lblNombre6, lblNombre7, lblNombre8, lblNombre9, lblNombre10};
	JLabel lblPuntaje1; JLabel lblPuntaje2; JLabel lblPuntaje3; JLabel lblPuntaje4;
	JLabel lblPuntaje5; JLabel lblPuntaje6; JLabel lblPuntaje7; JLabel lblPuntaje8;
	JLabel lblPuntaje9; JLabel lblPuntaje10;
	JLabel[] lblpuntajesRanking = {lblPuntaje1, lblPuntaje2, lblPuntaje3, lblPuntaje4, lblPuntaje5,
	lblPuntaje6, lblPuntaje7, lblPuntaje8, lblPuntaje9, lblPuntaje10};
	JLabel lblOrdenRank1; JLabel lblOrdenRank2; JLabel lblOrdenRank3; JLabel lblOrdenRank4;
	JLabel lblOrdenRank5; JLabel lblOrdenRank6; JLabel lblOrdenRank7; JLabel lblOrdenRank8;
	JLabel lblOrdenRank9; JLabel lblOrdenRank10;
	JLabel[] lblOrdenesRank = {lblOrdenRank1, lblOrdenRank2, lblOrdenRank3, lblOrdenRank4, lblOrdenRank5,
			lblOrdenRank6, lblOrdenRank7, lblOrdenRank8, lblOrdenRank9, lblOrdenRank10};


	// Elementos Ventana Nombre
	JPanel pnNombre;
	JLabel lblIngreseNombre;
	JTextField txtfldNombre;
	JButton btnJugar;
	JButton btnVolverNombre;
	JComboBox<String> cboxDificultad;
	
	JDialog dlgErrorNombre;
	JTextArea txtAreaErrorNombre;
	
	// Imágenes
	ImageIcon imgBateria = new ImageIcon(this.getClass().getResource("/images/png_bateria.png")), 
	imgProyBat = new ImageIcon(this.getClass().getResource("/images/png_proy_bat.png")),
	imgMuro1 = new ImageIcon(this.getClass().getResource("/images/png_muro.png")),
	imgMuro2 = new ImageIcon(this.getClass().getResource("/images/png_muro2.png")),
	imgMuro3 = new ImageIcon(this.getClass().getResource("/images/png_muro3.png")),
	imgMuro4 = new ImageIcon(this.getClass().getResource("/images/png_muro4.png")),
	imgNave = new ImageIcon(this.getClass().getResource("/images/png_nave.png")),
	imgNaveMov = new ImageIcon(this.getClass().getResource("/images/png_nave_mov.png")),
	imgProyNav = new ImageIcon(this.getClass().getResource("/images/png_proy_enemigo.png"));
	
	// Elementos Ventana Juego
	BateriaView batView;
	int batX, batY, velocidadBat;
	
	ProyectilBateriaView pbv;
	int proyX, proyY;
	
	ProyectilEnemigoView pev;
	int peX, peY;
    
    MuroView[] muroViews;
    MuroView muroView;
    int vidaMuro; int muroX; int muroY;
    
    NaveEnemigaView naveView;
    NaveEnemigaView[] naveViews;
    int vidaNave; int naveX; int naveY; int anchoNave; int altoNave; int velNave; 
    String flag = "Derecha";
    int flagNaveLabel; // Para cambiar imagen de la nave enemiga
    int contKills; // Verifica que mataste a todas las naves para pasar de nivel
    int contVidaExtra = 0; // el cont vida extra se pone en 0 cada vez que paso por pantalla inicio
    int flagTeclas = 1;
    int flagY = 0;
    
    JFrame frJuego;

	JLabel lblBateria;
	JLabel lblProyBat;
    JLabel lblProyNav;
    JLabel lblPuntaje;
    JLabel lblPuntos;
    JLabel lblNivel;
    JLabel lblNumNivel;
    JLabel lblVidas;
    JLabel lblNumVidas;
    JLabel lblNave1; JLabel lblNave2; JLabel lblNave3; JLabel lblNave4;
    JLabel lblNave5; JLabel lblNave6; JLabel lblNave7; JLabel lblNave8;
    JLabel lblNave9; JLabel lblNave10; JLabel lblNave11; JLabel lblNave12;
    JLabel lblNave13;  JLabel lblNave14; JLabel lblNave15;
    JLabel[] lblNaves = {lblNave1, lblNave2, lblNave3, lblNave4, lblNave5, lblNave6, lblNave7, lblNave8, lblNave9, 
    		lblNave10, lblNave11, lblNave12, lblNave13, lblNave14, lblNave15};
    JLabel lblMuro1; JLabel lblMuro2; JLabel lblMuro3; JLabel lblMuro4;
    JLabel[] lblMuros = {lblMuro1, lblMuro2, lblMuro3, lblMuro4};
    
    
    Timer timerMovBat;
    manejoMovimientoBateria tareaMovBat;
    
    Timer timerMovNav;
    manejoMovimientoNaves tareaMovNav;
    
    Timer timerDisparoBat;
    manejoDisparoBat tareaDisparoBat;
    
    Timer timerDisparoEnemigo; 
    TimerTask tareaDisparoEnemigo;
        
    
    // Elementos mensaje nivel superado
    JDialog dlgNivelSuperado;
    JLabel lblNivelSuperado;
    JButton btnContinuar;
    JButton btnGuardarYSalir;
    JButton btnSalir;
    
    // Elementos mensaje Game Over
    JDialog dlgGameOver;
    JLabel lblGameOver;
    JButton btnGuardarYSalir2;
    JButton btnSalir2;
    
    // Elementos mensaje Reglas
    JDialog dlgReglas;
    JTextArea txtareaReglas;
    
    // Elementos mensaje Controles
    JDialog dlgControles;
    JLabel lblControles;
    
    
//-------- Constructor --------------------------------------------------------------------------------------------------------------------------------    

	public GUI() {
		this.setSize(800, 640);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		this.setTitle("Space Invaders");
		ventanaInicio();
		eventosVentanaInicio();
	}
	
	
//-------- Ventanas --------------------------------------------------------------------------------------------------------------------------------    
	
	private void ventanaInicio() {
		this.setVisible(true);

		pnInicio = new JPanel();
		pnInicio.setSize(800, 640);
		pnInicio.setBackground(Color.black);
		pnInicio.setLayout(null);
		pnInicio.setVisible(true);
		
		lblTitle = new JLabel(new ImageIcon(this.getClass().getResource("/images/logo.png")));
		lblTitle.setBounds(70, 0, 640, 286);
		
		btnIniciarPartida = new JButton("Iniciar Partida");
		btnIniciarPartida.setFont(retro.cargarFont("8-BIT WONDER.TTF", 32));
		btnIniciarPartida.setForeground(Color.GREEN);
		btnIniciarPartida.setBackground(Color.BLACK);
		btnIniciarPartida.setBounds(175, 320, 440, 30);
		btnIniciarPartida.setOpaque(false);
		btnIniciarPartida.setContentAreaFilled(false);
		btnIniciarPartida.setBorderPainted(false);
		btnIniciarPartida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIniciarPartida.setFocusable(false);

		btnVerRanking = new JButton("Hi Scores");
		btnVerRanking.setBounds(250, 380, 300, 30);
		btnVerRanking.setFont(retro.cargarFont("8-BIT WONDER.TTF", 32));
		btnVerRanking.setForeground(Color.GREEN);
		btnVerRanking.setBackground(Color.BLACK);
		btnVerRanking.setOpaque(false);
		btnVerRanking.setContentAreaFilled(false);
		btnVerRanking.setBorderPainted(false);
		btnVerRanking.setFocusable(false);
		btnVerRanking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnReglas = new JButton("Reglas");
		btnReglas.setBounds(285, 440, 230, 30);
		btnReglas.setFont(retro.cargarFont("8-BIT WONDER.TTF", 32));
		btnReglas.setForeground(Color.GREEN);
		btnReglas.setBackground(Color.BLACK);
		btnReglas.setOpaque(false);
		btnReglas.setContentAreaFilled(false);
		btnReglas.setBorderPainted(false);
		btnReglas.setFocusable(false);
		btnReglas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnControles = new JButton("Controles");
		btnControles.setBounds(235, 500, 325, 30);
		btnControles.setFont(retro.cargarFont("8-BIT WONDER.TTF", 32));
		btnControles.setForeground(Color.GREEN);
		btnControles.setBackground(Color.BLACK);
		btnControles.setOpaque(false);
		btnControles.setContentAreaFilled(false);
		btnControles.setBorderPainted(false);
		btnControles.setFocusable(false);
		btnControles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		contVidaExtra = 0;
		
		
		pnInicio.add(lblTitle);
		pnInicio.add(btnIniciarPartida);
		pnInicio.add(btnVerRanking);
		pnInicio.add(btnReglas);
		pnInicio.add(btnControles);
		
		this.add(pnInicio);
		this.repaint();		
	}
	
	private void ventanaRanking() {
		
		this.remove(pnInicio);
		
		pnRanking = new JPanel();
		pnRanking.setSize(800, 640);
		pnRanking.setBackground(Color.black);
		pnRanking.setLayout(null);
		pnRanking.setVisible(true);
		
		lblTituloRanking = new JLabel("Top 10 Highscores");
		lblTituloRanking.setFont(retro.cargarFont("8-BIT WONDER.TTF", 24));
		lblTituloRanking.setForeground(Color.GREEN);
		lblTituloRanking.setBackground(Color.BLACK);
		lblTituloRanking.setBounds(220, 20, 400, 30);
		
		lblSubTituloRankingNombre = new JLabel("Nombre");
		lblSubTituloRankingNombre.setFont(retro.cargarFont("8-BIT WONDER.TTF", 24));
		lblSubTituloRankingNombre.setForeground(Color.GREEN);
		lblSubTituloRankingNombre.setBackground(Color.BLACK);
		lblSubTituloRankingNombre.setBounds(200, 80, 600, 30);
		
		lblSubTituloRankingPuntaje = new JLabel("Puntaje");
		lblSubTituloRankingPuntaje.setFont(retro.cargarFont("8-BIT WONDER.TTF", 24));
		lblSubTituloRankingPuntaje.setForeground(Color.GREEN);
		lblSubTituloRankingPuntaje.setBackground(Color.BLACK);
		lblSubTituloRankingPuntaje.setBounds(450, 80, 600, 30);
		
		btnVolverRanking = new JButton("Volver");
		btnVolverRanking.setBounds(270, 500, 250, 30);
		btnVolverRanking.setFont(retro.cargarFont("8-BIT WONDER.TTF", 24));
		btnVolverRanking.setForeground(Color.GREEN);
		btnVolverRanking.setBackground(Color.BLACK);
		btnVolverRanking.setOpaque(false);
		btnVolverRanking.setContentAreaFilled(false);
		btnVolverRanking.setBorderPainted(false);
		btnVolverRanking.setFocusable(false);
		btnVolverRanking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		String digit; int abscisa = 130;
		for(int i = 0; i < 10; i++) {
			digit = Integer.toString(i+1);
			lblOrdenesRank[i] = new JLabel(digit);
			lblOrdenesRank[i].setFont(retro.cargarFont("8-BIT WONDER.TTF", 24));
			lblOrdenesRank[i].setForeground(Color.WHITE);
			lblOrdenesRank[i].setBackground(Color.BLACK);
			lblOrdenesRank[i].setBounds(100, abscisa, 250, 30);

			pnRanking.add(lblOrdenesRank[i]);
			abscisa += 35;
		}
		
		
		Controlador.getInstance().leerRanking();
		imprimirRanking(lblnombresRanking, lblpuntajesRanking);
		
		pnRanking.add(lblTituloRanking);
		pnRanking.add(lblSubTituloRankingNombre);
		pnRanking.add(lblSubTituloRankingPuntaje);
		pnRanking.add(btnVolverRanking);
		
		this.add(pnRanking);
		this.repaint();
	}
	
	private void ventanaNombre() {
		
		this.remove(pnInicio);
		
		pnNombre = new JPanel();
		pnNombre.setSize(800, 640);
		pnNombre.setBackground(Color.black);
		pnNombre.setLayout(null);
		pnNombre.setVisible(true);
		
		lblIngreseNombre = new JLabel("Ingresar nombre");
		lblIngreseNombre.setFont(retro.cargarFont("8-BIT WONDER.TTF", 32));
		lblIngreseNombre.setForeground(Color.GREEN);
		lblIngreseNombre.setBackground(Color.BLACK);
		lblIngreseNombre.setBounds(165, 80, 640, 60);
		
		txtfldNombre = new JTextField();
		txtfldNombre.setBounds(290, 200, 200, 30);
		txtfldNombre.setBackground(Color.BLACK);
		txtfldNombre.setForeground(Color.GREEN);
		txtfldNombre.setFont(retro.cargarFont("8-BIT WONDER.TTF", 18));
		
		btnJugar = new JButton("Jugar");
		btnJugar.setFont(retro.cargarFont("8-BIT WONDER.TTF", 32));
		btnJugar.setForeground(Color.GREEN);
		btnJugar.setBackground(Color.BLACK);
		btnJugar.setBounds(260, 350, 260, 30);
		btnJugar.setOpaque(false);
		btnJugar.setContentAreaFilled(false);
		btnJugar.setBorderPainted(false);
		btnJugar.setFocusable(false);
		btnJugar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		cboxDificultad = new JComboBox<String>();
		cboxDificultad.setBackground(Color.BLACK);
		cboxDificultad.setForeground(Color.GREEN);
		cboxDificultad.setFont(retro.cargarFont("8-BIT WONDER.TTF", 18));
		cboxDificultad.addItem("Cadete");
		cboxDificultad.addItem("Guerrero");
		cboxDificultad.addItem("Maestro");
		cboxDificultad.setBounds(290, 280, 200, 30);
		
		btnVolverNombre = new JButton("Volver");
		btnVolverNombre.setFont(retro.cargarFont("8-BIT WONDER.TTF", 32));
		btnVolverNombre.setForeground(Color.GREEN);
		btnVolverNombre.setBackground(Color.BLACK);
		btnVolverNombre.setBounds(275, 420, 230, 30);
		btnVolverNombre.setOpaque(false);
		btnVolverNombre.setContentAreaFilled(false);
		btnVolverNombre.setBorderPainted(false);
		btnVolverNombre.setFocusable(false);
		btnVolverNombre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		pnNombre.add(lblIngreseNombre);
		pnNombre.add(txtfldNombre);
		pnNombre.add(btnJugar);
		pnNombre.add(cboxDificultad);
		pnNombre.add(btnVolverNombre);
		
		this.add(pnNombre);
		this.repaint();
	}
	
	private void ventanaJuego() {
		
		this.setVisible(false);
		
		frJuego = new JFrame();
		frJuego.setResizable(false);
		frJuego.getContentPane().setBackground(Color.BLACK);
		frJuego.setSize(800, 640);
		frJuego.setBackground(Color.black);
		frJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frJuego.setLayout(null);
		frJuego.setVisible(true);
		frJuego.setTitle("Space Invaders");
		
		mbMenu = new JMenuBar();
		mbMenu.setBackground(Color.BLACK);
		
		mJuego = new JMenu();
		mJuego.setText("Juego");
		mJuego.setFont(retro.cargarFont("8-BIT WONDER.TTF", 14));
		mJuego.setForeground(Color.WHITE);
		
		miReiniciar = new JMenuItem();
		miReiniciar.setText("Reiniciar");
		
		miSalir = new JMenuItem();
		miSalir.setText("Salir");
		
		miGuardarYSalir = new JMenuItem();
		miGuardarYSalir.setText("Guardar y Salir");
		
		
		mJuego.add(miReiniciar);
		mJuego.add(miSalir);
		mJuego.add(miGuardarYSalir);
		
		
		mbMenu.add(mJuego);
		
		frJuego.setJMenuBar(mbMenu);
		
		
		lblPuntaje = new JLabel("Puntaje");
		lblPuntaje.setFont(retro.cargarFont("8-BIT WONDER.TTF", 18));
		lblPuntaje.setBounds(30, 25, 160, 20);
		lblPuntaje.setForeground(Color.WHITE);
		
		lblPuntos = new JLabel(Integer.toString(Controlador.getInstance().partida.puntaje));
		lblPuntos.setFont(retro.cargarFont("8-BIT WONDER.TTF", 18));
		lblPuntos.setBounds(170, 25, 100, 20);
		lblPuntos.setForeground(Color.GREEN);
		
		
		lblNivel = new JLabel("Nivel");
		lblNivel.setFont(retro.cargarFont("8-BIT WONDER.TTF", 18));
		lblNivel.setBounds(350, 25, 160, 20);
		lblNivel.setForeground(Color.WHITE);
		
		lblNumNivel = new JLabel(Integer.toString(Controlador.getInstance().partida.nivel));
		lblNumNivel.setFont(retro.cargarFont("8-BIT WONDER.TTF", 18));
		lblNumNivel.setBounds(445, 25, 20, 20);
		lblNumNivel.setForeground(Color.GREEN);
		
		
		lblVidas = new JLabel("Vidas");
		lblVidas.setFont(retro.cargarFont("8-BIT WONDER.TTF", 18));
		lblVidas.setForeground(Color.WHITE);
		lblVidas.setBounds(600, 25, 160, 20);

		lblNumVidas = new JLabel(Integer.toString(Controlador.getInstance().partida.jugador.vidas));
		lblNumVidas.setFont(retro.cargarFont("8-BIT WONDER.TTF", 18));
		lblNumVidas.setForeground(Color.GREEN);
		lblNumVidas.setBounds(695, 20, 40, 30);
		
		// Inicializar batería
		batView = Controlador.getInstance().partida.bateria.toView();
		lblBateria = new JLabel(imgBateria);
		batX = batView.getPosicionx(); batY = batView.getPosiciony();
		lblBateria.setBounds(batX, batY, 60, 28);		
		
		// Inicializar proyectil batería
		pbv = Controlador.getInstance().partida.pb.toView();
		lblProyBat = new JLabel(imgProyBat);
		proyX = pbv.getPosicionx(); proyY = pbv.getPosiciony();
		lblProyBat.setBounds(proyX, proyY, 4, 22);
		
		// Inicializar proyectil enemigo
		pev = Controlador.getInstance().partida.pe.toView();
		peX = pev.getPosicionx(); peY = pev.getPosiciony();
		lblProyNav = new JLabel(imgProyNav);
		lblProyNav.setBounds(peX, peY, 12, 28);
		
		
		Controlador.getInstance().partida.generarNaves();
		agregarNaves();
		agregarMuros();
		
		
		frJuego.add(lblBateria);
		frJuego.add(lblPuntaje);
		frJuego.add(lblPuntos);
		frJuego.add(lblNivel);
		frJuego.add(lblNumNivel);
		frJuego.add(lblVidas);
		frJuego.add(lblNumVidas);
		
	}
	
	private void dialogoNivel() {
		dlgNivelSuperado = new JDialog();
		dlgNivelSuperado.setSize(600, 400);
		dlgNivelSuperado.setResizable(false);
		dlgNivelSuperado.setVisible(true);
		dlgNivelSuperado.setTitle("Mensaje");
		dlgNivelSuperado.setLocationRelativeTo(frJuego);
		dlgNivelSuperado.getContentPane().setBackground(Color.BLACK);
		
		lblNivelSuperado = new JLabel("Nivel superado");		
		lblNivelSuperado.setFont(retro.cargarFont("8-BIT WONDER.TTF", 24));
		lblNivelSuperado.setForeground(Color.GREEN);
		lblNivelSuperado.setBackground(Color.BLACK);
		lblNivelSuperado.setBounds(140, 0, 400, 100);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setFont(retro.cargarFont("8-BIT WONDER.TTF", 16));
		btnContinuar.setForeground(Color.GREEN);
		btnContinuar.setBackground(Color.BLACK);
		btnContinuar.setBounds(162, 120, 260, 30);
		btnContinuar.setOpaque(false);
		btnContinuar.setContentAreaFilled(false);
		btnContinuar.setBorderPainted(false);
		btnContinuar.setFocusable(false);
		btnContinuar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnGuardarYSalir = new JButton("Guardar y Salir");
		btnGuardarYSalir.setFont(retro.cargarFont("8-BIT WONDER.TTF", 16));
		btnGuardarYSalir.setForeground(Color.GREEN);
		btnGuardarYSalir.setBackground(Color.BLACK);
		btnGuardarYSalir.setBounds(162, 160, 260, 30);
		btnGuardarYSalir.setOpaque(false);
		btnGuardarYSalir.setContentAreaFilled(false);
		btnGuardarYSalir.setBorderPainted(false);
		btnGuardarYSalir.setFocusable(false);
		btnGuardarYSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(retro.cargarFont("8-BIT WONDER.TTF", 16));
		btnSalir.setForeground(Color.GREEN);
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(162, 200, 260, 30);
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setFocusable(false);
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		dlgNivelSuperado.add(lblNivelSuperado);
		dlgNivelSuperado.add(btnContinuar);
		dlgNivelSuperado.add(btnGuardarYSalir);
		dlgNivelSuperado.add(btnSalir);
		
		dlgNivelSuperado.repaint();

	}
	
	private void dialogoGameOver() {
		dlgGameOver = new JDialog();
		dlgGameOver.setSize(600, 400);
		dlgGameOver.setResizable(false);
		dlgGameOver.setVisible(true);
		dlgGameOver.setTitle("Mensaje");
		dlgGameOver.setLocationRelativeTo(frJuego);
		dlgGameOver.getContentPane().setBackground(Color.BLACK);
		
		lblGameOver = new JLabel("Game Over");		
		lblGameOver.setFont(retro.cargarFont("8-BIT WONDER.TTF", 24));
		lblGameOver.setForeground(Color.GREEN);
		lblGameOver.setBackground(Color.BLACK);
		lblGameOver.setBounds(200, 0, 400, 100);
		
		btnGuardarYSalir2 = new JButton("Guardar y Salir");
		btnGuardarYSalir2.setFont(retro.cargarFont("8-BIT WONDER.TTF", 16));
		btnGuardarYSalir2.setForeground(Color.GREEN);
		btnGuardarYSalir2.setBackground(Color.BLACK);
		btnGuardarYSalir2.setBounds(162, 160, 260, 30);
		btnGuardarYSalir2.setOpaque(false);
		btnGuardarYSalir2.setContentAreaFilled(false);
		btnGuardarYSalir2.setBorderPainted(false);
		btnGuardarYSalir2.setFocusable(false);
		btnGuardarYSalir2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnSalir2 = new JButton("Salir");
		btnSalir2.setFont(retro.cargarFont("8-BIT WONDER.TTF", 16));
		btnSalir2.setForeground(Color.GREEN);
		btnSalir2.setBackground(Color.BLACK);
		btnSalir2.setBounds(162, 200, 260, 30);
		btnSalir2.setOpaque(false);
		btnSalir2.setContentAreaFilled(false);
		btnSalir2.setBorderPainted(false);
		btnSalir2.setFocusable(false);
		btnSalir2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		dlgGameOver.add(lblGameOver);
		dlgGameOver.add(btnGuardarYSalir2);
		dlgGameOver.add(btnSalir2);
		
		dlgGameOver.repaint();

	}
	
	private void dialogoReglas() {
		dlgReglas = new JDialog();
		dlgReglas.setSize(600, 400);
		dlgReglas.setResizable(false);
		dlgReglas.setVisible(true);
		dlgReglas.setTitle("Reglas");
		dlgReglas.setLocationRelativeTo(pnInicio);
		dlgReglas.getContentPane().setBackground(Color.BLACK);
		
		txtareaReglas = new JTextArea("El objetivo del juego es derrotar a las naves\nenemigas antes de que "
				+ "lleguen al final de la\npantalla. Para ello, disponemos de 3 vidas\niniciales y nuestra "
				+ "batería puede disparar\nproyectiles de plasma para eliminar a los\nenemigos. "
				+ "Hay 4 muros de energía que nos\nprotegen de los disparos,"
				+ "pero cuidado porque\nnuestros disparos infligen el doble de daño\nque los disparos rivales. "
				+ "Cada vez que\neliminamos una nave enemiga, sumamos\n10 puntos. "
				+ "Al eliminar todos los enemigos\nse avanza de nivel y se obtienen 200 puntos.\nCada 500, "
				+ "sumamos una vida extra.");
		txtareaReglas.setEditable(false);
		txtareaReglas.setFont(retro.cargarFont("PixelOperatorSC-Bold.ttf", 25)); // Cambiar font
		txtareaReglas.setForeground(Color.GREEN);
		txtareaReglas.setBackground(Color.BLACK);
		txtareaReglas.setBounds(10, 10, 640, 500);
		
		dlgReglas.add(txtareaReglas);
		dlgReglas.repaint();
	}
	
	private void dialogoControles() {
		dlgControles = new JDialog();
		dlgControles.setSize(450, 250);
		dlgControles.setResizable(false);
		dlgControles.setVisible(true);
		dlgControles.setTitle("Controles");
		dlgControles.setLocationRelativeTo(pnInicio);
		dlgControles.getContentPane().setBackground(Color.BLACK);
		
		lblControles = new JLabel(new ImageIcon(this.getClass().getResource("/images/controles.png")));
		lblControles.setBounds(15, 0, 400, 200);
		
		dlgControles.add(lblControles);
		
		dlgControles.repaint();
		
	}


//-------- Eventos --------------------------------------------------------------------------------------------------------------------------------    

	
	manejoBotones mb = new manejoBotones();
	manejoTeclas mt = new manejoTeclas();
	
	
	private void eventosVentanaInicio() {
		btnIniciarPartida.addActionListener(mb);
		btnVerRanking.addActionListener(mb);
		btnReglas.addActionListener(mb);
		btnControles.addActionListener(mb);
	}
		
	
	private void eventosVentanaRanking() {
		btnVolverRanking.addActionListener(mb);
	}
		
	
	private void eventosVentanaNombre() {
		btnJugar.addActionListener(mb);
		btnVolverNombre.addActionListener(mb);
		contKills = 0;
	}
		
	
	private void eventosVentanaJuego() {
		frJuego.addKeyListener(mt);
		miReiniciar.addActionListener(mb);
		miSalir.addActionListener(mb);
		miGuardarYSalir.addActionListener(mb);
		
		timerMovBat = new Timer();
	    tareaMovBat = new manejoMovimientoBateria();
	    timerMovBat.schedule(tareaMovBat, 0, 5);
		
	    
		timerMovNav = new Timer();
		tareaMovNav = new manejoMovimientoNaves();
		timerMovNav.schedule(tareaMovNav, 0, Controlador.getInstance().partida.velocidadNavesMS);
		
	}
		
	
	private void eventosDialogoNivel() {
		btnContinuar.addActionListener(mb);
		btnGuardarYSalir.addActionListener(mb);
		btnSalir.addActionListener(mb);
	}
	
	
	private void eventosDialogoGameOver() {
		btnGuardarYSalir2.addActionListener(mb);
		btnSalir2.addActionListener(mb);
	}
	
	
//-------- Métodos --------------------------------------------------------------------------------------------------------------------------------    
	
	// Agregar naves a ventana juego
	private void agregarNaves() {
		
		flagNaveLabel = 0; // Flag que cambia la imagen de la nave
		naveViews = new NaveEnemigaView[15]; // Lista de naveViews de partida
		int naveX; int naveY;
		for(int i = 0; i < 15; i++) {
			naveView = Controlador.getInstance().partida.naves[i].toView();
			naveViews[i] = naveView;
			naveView.setEstado(true);
			naveX = naveView.getPosicionx();
			naveY = naveView.getPosiciony();
			lblNaves[i] = new JLabel(imgNave);
			lblNaves[i].setBounds(naveX, naveY, naveView.getAncho(), naveView.getAlto());
			frJuego.add(lblNaves[i]);
			
		}
		
	}
	
	// Agregar muros a ventana juego
	private void agregarMuros() {
		
		muroViews = new MuroView[4];
		int muroX; int muroY;
		for(int i = 0; i < 4; i++) {
			muroView = Controlador.getInstance().partida.muros[i].toView();
			muroViews[i] = muroView;
			muroView.setEstado(true);
			muroView.setVida(20);
			muroX = muroView.getPosicionx();
			muroY = muroView.getPosiciony();
			lblMuros[i] = new JLabel(imgMuro1);
			lblMuros[i].setBounds(muroX, muroY, muroView.getAncho(), muroView.getAlto());
			frJuego.add(lblMuros[i]);
			
		}
	}
	
	// Modifica la imagen del muro según la vida restante
	private void cambiarImagenMuro(MuroView muroView, JLabel lblMuro) {
		
		int vida = muroView.getVida();
		
		if(20 >= vida && vida >= 16) {
			lblMuro.setIcon(new ImageIcon(this.getClass().getResource("/images/png_muro.png")));
		}
		else if(15 >= vida && vida >= 11) {
			lblMuro.setIcon(new ImageIcon(this.getClass().getResource("/images/png_muro2.png")));

		}
		else if(10 >= vida && vida >= 6) {
			lblMuro.setIcon(new ImageIcon(this.getClass().getResource("/images/png_muro3.png")));

		}
		else if(5 >= vida && vida >= 1) {
			lblMuro.setIcon(new ImageIcon(this.getClass().getResource("/images/png_muro4.png")));
		}
		else {
			lblMuro.setIcon(null);
		}
		
	}
	
	// Modifica la imagen de las naves cuando se mueven
	private void cambiarImagenNave(JLabel lblNave) {
		
		if(flagNaveLabel == 1) {
			lblNave.setIcon(imgNaveMov);
		}
		else {
			lblNave.setIcon(imgNave);
		}
		
	}
	
	// Agrega el ranking a la pantalla frRanking
	private void imprimirRanking(JLabel[] nombres, JLabel[] puntajes) {
		
		HashMap<String, String> filas = Controlador.getInstance().ranking.rankingToArray();
		
		int posy = 130;
		int cont = 0;
		for (String i : filas.keySet()) {
			nombres[cont] = new JLabel(i);
			nombres[cont].setFont(retro.cargarFont("8-BIT WONDER.TTF", 24));
			nombres[cont].setForeground(Color.WHITE);
			nombres[cont].setBackground(Color.BLACK);
			nombres[cont].setBounds(200, posy, 600, 30);
			
			puntajes[cont] = new JLabel(filas.get(i));
			puntajes[cont].setFont(retro.cargarFont("8-BIT WONDER.TTF", 24));
			puntajes[cont].setForeground(Color.WHITE);
			puntajes[cont].setBackground(Color.BLACK);
			puntajes[cont].setBounds(450, posy, 600, 30);
			
			pnRanking.add(nombres[cont]);
			pnRanking.add(puntajes[cont]);
			
			posy += 35;
		}
		
		pnRanking.repaint();
	}
	
	// Controla pasar de nivel
	private void ganarNivel() {
		
		pev.setPosicionx(0);
		pev.setPosiciony(0);
		pev.setEstado(false);
		lblProyNav.setBounds(0, 0, 0, 0);
		
		tareaMovBat.cancel();
		timerMovBat.cancel();
		timerMovBat.purge();
		
		tareaMovNav.cancel();
		timerMovNav.cancel();
		timerMovNav.purge();
		
		if(pev.isEstado()) {
			tareaDisparoEnemigo.cancel();
			timerDisparoEnemigo.cancel();
			timerDisparoEnemigo.purge();
		}
		
		if(pbv.isEstado()) {
			tareaDisparoBat.cancel();
			timerDisparoBat.cancel();
			timerDisparoBat.purge();
		}
		
		flag = "Derecha";
		Controlador.getInstance().partida.sumarPuntos(200);
		contVidaExtra += 200;
		
		dialogoNivel();
		eventosDialogoNivel();
		
	}
	
	// Controla perder nivel
	private void gameOver() {
		tareaMovBat.cancel();
		timerMovBat.cancel();
		timerMovBat.purge();
		
		tareaMovNav.cancel();
		timerMovNav.cancel();
		timerMovNav.purge();
		
		if(pev.isEstado()) {
			tareaDisparoEnemigo.cancel();
			timerDisparoEnemigo.cancel();
			timerDisparoEnemigo.purge();
		}
		
		if(pbv.isEstado()) {
			tareaDisparoBat.cancel();
			timerDisparoBat.cancel();
			timerDisparoBat.purge();
		}
		
		dialogoGameOver();
		eventosDialogoGameOver();
	}
	
	
//-------- Clases Internas -------------------------------------------------------------------------------------------------------------------------------------	
	
	class manejoBotones implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(btnIniciarPartida)) {
				ventanaNombre();
				eventosVentanaNombre();
				
			}
			if(e.getSource().equals(btnVerRanking)) {
				ventanaRanking();
				eventosVentanaRanking();
			}
			
			if(e.getSource().equals(btnReglas)) {
				dialogoReglas();
			}
			
			if(e.getSource().equals(btnControles)) {
				dialogoControles();
			}
			
			if(e.getSource().equals(btnJugar)) {
				String nameInput = txtfldNombre.getText();
				if(nameInput.length() > 8 || nameInput.length() < 1) {
					dlgErrorNombre = new JDialog();
					dlgErrorNombre = new JDialog();
					dlgErrorNombre.setSize(400, 200);
					dlgErrorNombre.setResizable(false);
					dlgErrorNombre.setVisible(true);
					dlgErrorNombre.setTitle("Error");
					dlgErrorNombre.setLocationRelativeTo(pnNombre);
					dlgErrorNombre.getContentPane().setBackground(Color.BLACK);
					
					txtAreaErrorNombre = new JTextArea("El nombre debe contener\n\nentre 1 y 8 caracteres");
					txtAreaErrorNombre.setEditable(false);
					txtAreaErrorNombre.setFont(retro.cargarFont("8-BIT WONDER.TTF", 14)); // Cambiar font
					txtAreaErrorNombre.setForeground(Color.GREEN);
					txtAreaErrorNombre.setBackground(Color.BLACK);
					txtAreaErrorNombre.setBounds(50, 50, 640, 500);

					dlgErrorNombre.add(txtAreaErrorNombre);
					
					dlgErrorNombre.repaint();
				}
				else {
					String difSelect = "";
					difSelect += cboxDificultad.getSelectedItem();
					Controlador.getInstance().iniciarPartida(difSelect);
					Controlador.getInstance().partida.nuevaPartida(nameInput, difSelect);
					g.remove(pnNombre);				
					ventanaJuego();
					eventosVentanaJuego();
				}
				
			}
			
			if(e.getSource().equals(btnVolverNombre)) {
				g.remove(pnNombre);
				
				ventanaInicio();
				eventosVentanaInicio();
			}
			
			if(e.getSource().equals(btnVolverRanking)) {
				g.remove(pnRanking);
				ventanaInicio();
				eventosVentanaInicio();
			}
			
			if(e.getSource().equals(miReiniciar)) {
				frJuego.dispose();
				tareaMovBat.cancel();
				timerMovBat.cancel();
				timerMovBat.purge();
				tareaMovNav.cancel();
				timerMovNav.cancel();
				timerMovNav.purge();
				if(pev.isEstado()) {
					tareaDisparoEnemigo.cancel();
					timerDisparoEnemigo.cancel();
					timerDisparoEnemigo.purge();
				}
				if(pbv.isEstado()) {
					tareaDisparoBat.cancel();
					timerDisparoBat.cancel();
					timerDisparoBat.purge();
				}
				flag = "Derecha";
				Controlador.getInstance().partida.puntaje = 0;
				contVidaExtra = 0;
				ventanaJuego();
				eventosVentanaJuego();
			}
			
			if(e.getSource().equals(miSalir)) {
				frJuego.dispose();
				Controlador.getInstance().partida.puntaje = 0;
				tareaMovBat.cancel();
				timerMovBat.cancel();
				timerMovBat.purge();
				tareaMovNav.cancel();
				timerMovNav.cancel();
				timerMovNav.purge();
				if(pev.isEstado()) {
					tareaDisparoEnemigo.cancel();
					timerDisparoEnemigo.cancel();
					timerDisparoEnemigo.purge();
				}
				if(pbv.isEstado()) {
					tareaDisparoBat.cancel();
					timerDisparoBat.cancel();
					timerDisparoBat.purge();
				}
				ventanaInicio();
				eventosVentanaInicio();
				flag = "Derecha";

			}
			
			if(e.getSource().equals(miGuardarYSalir)) {
				frJuego.dispose();
				Controlador.getInstance().partida.agregarRanking();
				tareaMovBat.cancel();
				timerMovBat.cancel();
				timerMovBat.purge();
				tareaMovNav.cancel();
				timerMovNav.cancel();
				timerMovNav.purge();
				if(pev.isEstado()) {
					tareaDisparoEnemigo.cancel();
					timerDisparoEnemigo.cancel();
					timerDisparoEnemigo.purge();
				}
				if(pbv.isEstado()) {
					tareaDisparoBat.cancel();
					timerDisparoBat.cancel();
					timerDisparoBat.purge();
				}
				ventanaInicio();
				eventosVentanaInicio();
				flag = "Derecha";

			}
			
			if(e.getSource().equals(btnContinuar)) {
				dlgNivelSuperado.dispose();
				frJuego.dispose();
				Controlador.getInstance().partida.nivel += 1;
				Controlador.getInstance().partida.velocidadNavesMS -= 50;
				
				ventanaJuego();
				eventosVentanaJuego();
				flag = "Derecha";

								
			}
			
			if(e.getSource().equals(btnGuardarYSalir)) {
				dlgNivelSuperado.dispose();
				frJuego.dispose();
				Controlador.getInstance().partida.agregarRanking();
				tareaMovBat.cancel();
				timerMovBat.cancel();
				timerMovBat.purge();
				tareaMovNav.cancel();
				timerMovNav.cancel();
				timerMovNav.purge();
				if(pev.isEstado()) {
					tareaDisparoEnemigo.cancel();
					timerDisparoEnemigo.cancel();
					timerDisparoEnemigo.purge();
				}
				if(pbv.isEstado()) {
					tareaDisparoBat.cancel();
					timerDisparoBat.cancel();
					timerDisparoBat.purge();
				}
				ventanaInicio();
				eventosVentanaInicio();
				flag = "Derecha";

			}
			
			if(e.getSource().equals(btnSalir)) {
				dlgNivelSuperado.dispose();
				frJuego.dispose();
				tareaMovBat.cancel();
				timerMovBat.cancel();
				timerMovBat.purge();
				tareaMovNav.cancel();
				timerMovNav.cancel();
				timerMovNav.purge();
				if(pev.isEstado()) {
					tareaDisparoEnemigo.cancel();
					timerDisparoEnemigo.cancel();
					timerDisparoEnemigo.purge();
				}
				if(pbv.isEstado()) {
					tareaDisparoBat.cancel();
					timerDisparoBat.cancel();
					timerDisparoBat.purge();
				}
				ventanaInicio();
				eventosVentanaInicio();
				flag = "Derecha";

			}
			
			if(e.getSource().equals(btnGuardarYSalir2)) {
				dlgGameOver.dispose();
				frJuego.dispose();
				Controlador.getInstance().partida.agregarRanking();
				tareaMovBat.cancel();
				timerMovBat.cancel();
				timerMovBat.purge();
				tareaMovNav.cancel();
				timerMovNav.cancel();
				timerMovNav.purge();
				if(pev.isEstado()) {
					tareaDisparoEnemigo.cancel();
					timerDisparoEnemigo.cancel();
					timerDisparoEnemigo.purge();
				}
				if(pbv.isEstado()) {
					tareaDisparoBat.cancel();
					timerDisparoBat.cancel();
					timerDisparoBat.purge();
				}
				ventanaInicio();
				eventosVentanaInicio();
				flag = "Derecha";

			}
			
			if(e.getSource().equals(btnSalir2)) {
				dlgGameOver.dispose();
				frJuego.dispose();
				tareaMovBat.cancel();
				timerMovBat.cancel();
				timerMovBat.purge();
				tareaMovNav.cancel();
				timerMovNav.cancel();
				timerMovNav.purge();
				if(pev.isEstado()) {
					tareaDisparoEnemigo.cancel();
					timerDisparoEnemigo.cancel();
					timerDisparoEnemigo.purge();
				}
				if(pbv.isEstado()) {
					tareaDisparoBat.cancel();
					timerDisparoBat.cancel();
					timerDisparoBat.purge();
				}
				ventanaInicio();
				eventosVentanaInicio();
				flag = "Derecha";

			}
					
		}
		
	}
	
	
	class manejoTeclas implements KeyListener {
		
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if(flagTeclas == 1) {
				
				if(key == KeyEvent.VK_RIGHT) {
										
					Controlador.getInstance().moverBateria("Derecha", batView);
					
				}
				
				if(key == KeyEvent.VK_LEFT) {
					
					Controlador.getInstance().moverBateria("Izquierda", batView);

				}
				
				if(key == KeyEvent.VK_SPACE) {
					if(pbv.isEstado() == false) {
						
						Controlador.getInstance().dispararBateria(batX, batY, pbv);
						
						lblProyBat.setBounds(batX+32, batY, 4, 18);
						frJuego.add(lblProyBat);
						frJuego.repaint();
						
						timerDisparoBat = new Timer();
						tareaDisparoBat = new manejoDisparoBat();
						timerDisparoBat.schedule(tareaDisparoBat, 0, 12);
					}
				}
				
			} 			
			
		}
		
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
				
				Controlador.getInstance().moverBateria("Frenar", batView);
				
			}
		}
		
		public void keyTyped(KeyEvent e) {}
		
	}
	
	
	// Timer para manejar el movimiento de la bateria y dinámca del juego
	class manejoMovimientoBateria extends TimerTask {
		public void run() {
			// Movimiento batería
			batX = batView.getPosicionx();
			
			if(batX < 26) {
				Controlador.getInstance().moverBateria("Frenar", batView);
				batX = 26;
			}
			
			if(batX > 698) {
				Controlador.getInstance().moverBateria("Frenar", batView);
				batX = 698;
			}
			
			velocidadBat = batView.getVelocidad(); 
			batX += velocidadBat;
			
			batView.setPosicionx(batX);
			lblBateria.setBounds(batX, batView.getPosiciony(), 67, 33);
			frJuego.repaint();
			
			// Control eliminar todas las naves
			if(contKills == 15) {
				contKills = 0;
				ganarNivel();
			}
				
			
	//------- Controlar disparo naves ----------------------------------------------------------------
			
			if(Math.random() <= 0.02) { // Cada 5 ms hay un 2% de chances de que alguna nave dispare
				int randomNum = ThreadLocalRandom.current().nextInt(0, 15);
				
				// Si el misil no está en pantalla y la nave existe
				if(pev.isEstado() == false && naveViews[randomNum].isEstado()) { 
					int xNav = 	naveViews[randomNum].getPosicionx();
					int yNav = 	naveViews[randomNum].getPosiciony();
					
					pev.setEstado(true);
					pev.setPosicionx(xNav + 20); // Para que el disparo salga del centro de la nave
					pev.setPosiciony(yNav);
					
					lblProyNav.setBounds(xNav, yNav, 4, 22);
					
					frJuego.add(lblProyNav);
					frJuego.repaint();
					
					timerDisparoEnemigo = new Timer();
					tareaDisparoEnemigo = new manejoDisparoNave();
					timerDisparoEnemigo.schedule(tareaDisparoEnemigo, 0, 12);
					
				}
			}
			
	//--------------------------------------------------------------------------------------------------------
			
			// Controlar sumar vida
			if(contVidaExtra >= 500) { // Suma vida extra cada 500 puntos
				contVidaExtra -= 500;
				Controlador.getInstance().partida.jugador.modificarVidas("Sumar");
				lblNumVidas.setText(Integer.toString(Controlador.getInstance().partida.jugador.vidas));
				lblNumVidas.setBounds(695, 25, 160, 20);
			}
		}
	};
	
	// Timer para manejar el movimiento de las naves enemigas
	class manejoMovimientoNaves extends TimerTask {
		public void run() {
			// Movimiento naves
			
			// Este primer for verifica si alguna nave llegó al borde de la pantalla
			if(flagY == 0) {
				for(int i = 0; i < 15; i++) {
					naveView = naveViews[i];
					if(naveView.isEstado()) {
						naveX = naveView.getPosicionx();
					}
					
					if((naveX >= 700 || naveX <= 50) && flagY == 0) {
						flagY = 1;
					}
					
				}
			}
			
			else {
				flagY = 0;
			}
			
			if(flagY == 0) {
				for(int i = 0; i < 15; i++) {
					naveView = naveViews[i];
					velNave = naveView.getVelocidad();
					anchoNave = naveView.getAncho();
					altoNave = naveView.getAlto();
					if(naveView.isEstado()) {
						naveX = naveView.getPosicionx();
						naveY = naveView.getPosiciony();
						if(flag == "Derecha") {
							naveView.setPosicionx(naveX + velNave);
							cambiarImagenNave(lblNaves[i]);
							lblNaves[i].setBounds(naveX + velNave, naveY, anchoNave, altoNave);
						}
						else {
							naveView.setPosicionx(naveX - velNave);
							cambiarImagenNave(lblNaves[i]);
							lblNaves[i].setBounds(naveX - velNave, naveY, anchoNave, altoNave);
						}
						
					}
				}
			}
			
			else {
				for(int i = 0; i < 15; i++) {
					naveView = naveViews[i];
					velNave = naveView.getVelocidad();
					anchoNave = naveView.getAncho();
					altoNave = naveView.getAlto();
					if(naveView.isEstado()) {
						naveX = naveView.getPosicionx();
						naveY = naveView.getPosiciony();
						naveView.setPosiciony(naveY + velNave);
						cambiarImagenNave(lblNaves[i]);
						lblNaves[i].setBounds(naveX, naveY + velNave, anchoNave, altoNave);
					}
				}
				if(flag == "Derecha") {
					flag = "Izquierda";
				}
				else {
					flag = "Derecha";
				}
				
			}
			
			if(flagNaveLabel == 0) {
				flagNaveLabel = 1;
			}
			else {
				flagNaveLabel = 0;
			}
						
			// Controlar si alguna nave llegó al final de la pantalla
			for(int i = 0; i < 15; i++) {
				if(naveViews[i].getPosiciony() + naveViews[i].getAlto() >= 540) {
					gameOver();
				}
			}
		}
			
	};
		
	// Timer para manejar el disparo de la batería
	class manejoDisparoBat extends TimerTask {
		public void run() {
			
			proyX = pbv.getPosicionx();
		    proyY = pbv.getPosiciony();
		    
			if(proyY > -36) {
				moverProyectil(proyX, proyY);
			}
			if(proyY < -20) {
				destruirProyectil();
			}
			
			// Controlar impacto muros
			for(int i = 0; i < 4; i++) {
				muroView = muroViews[i];
				
				// Si el disparo impacta un muro existente
				if(Controlador.getInstance().partida.muros[i].isImpactoBateria(proyX, proyY) && muroView.isEstado()) { 
					destruirProyectil();
					
					vidaMuro = muroView.getVida();
					muroView.setVida(vidaMuro - 2);
					cambiarImagenMuro(muroView, lblMuros[i]);
					
				}

				
				if(muroView.getVida() <= 0) { // Destruir muro
					muroView.setEstado(false);
				}
			}
			
			// Controlar impacto con naves
			for(int i = 0; i < 15; i++) {
				naveView = naveViews[i];
				proyX = pbv.getPosicionx();
				proyY = pbv.getPosiciony();
				naveX = naveView.getPosicionx();
				naveY = naveView.getPosiciony();
				if(Controlador.getInstance().partida.naves[i].isImpacto(proyX, proyY, naveX, naveY) && naveView.isEstado()) {
					destruirProyectil();
					naveView.setEstado(false);
					lblNaves[i].setBounds(0, 0, 0, 0);
					
					// Sumar puntos
					Controlador.getInstance().partida.sumarPuntos(10);
					contVidaExtra += 10;
					lblPuntos.setText(Integer.toString(Controlador.getInstance().partida.puntaje));
					lblPuntos.setFont(retro.cargarFont("8-BIT WONDER.TTF", 18));
					lblPuntos.setBounds(170, 25, 100, 20);
					lblPuntos.setForeground(Color.GREEN);
								
					contKills++;
				}
			}
		}
		
		private void moverProyectil(int x, int y) {
			pbv.setPosiciony(y-6);
			lblProyBat.setBounds(x+32, y, 4, 18);
			frJuego.repaint();
		}
		
		private void destruirProyectil() {
			pbv.setEstado(false);
			pbv.setPosicionx(0);
			pbv.setPosiciony(0);
			lblProyBat.setBounds(0, 0, 0, 0);
			
			tareaDisparoBat.cancel();
			timerDisparoBat.cancel();
			timerDisparoBat.purge();
		}
	};

	// Timer para manejar el disparo de las naves enemigas
	class manejoDisparoNave extends TimerTask {
		public void run() { 
						
			peX = pev.getPosicionx();
			peY = pev.getPosiciony();
			if(peY < 540 && pev.isEstado()) {
				moverDisparo(peX, peY);
			}
			if(peY >= 540) {
				destruirDisparo();
			}
			
			// Controlar impacto muros
				for(int i = 0; i < 4; i++) {
					muroView = muroViews[i];
					
					// Si el disparo impacta un muro existente
					if(Controlador.getInstance().partida.muros[i].isImpactoEnemigo(peX, peY) && muroView.isEstado()) { 
						destruirDisparo();

						vidaMuro = muroView.getVida();
						vidaMuro = muroView.getVida();
						muroView.setVida(vidaMuro - 1);
						
						cambiarImagenMuro(muroView, lblMuros[i]);
					}
					
					if(muroView.getVida() <= 0) { // Destruir muro
						muroView.setEstado(false);
					}
				}
			
			// Controlar impacto batería
			if(Controlador.getInstance().partida.bateria.isImpactoEnemigo(peX, peY, batX, batY)) {
				
				tareaMovBat.cancel();
				timerMovBat.cancel();
				timerMovBat.purge();
				
				tareaMovNav.cancel();
				timerMovBat.cancel();
				timerMovBat.purge();
				
				flagTeclas = 0;
				Controlador.getInstance().partida.jugador.modificarVidas("Restar");
				
				lblBateria.setIcon(new ImageIcon(this.getClass().getResource("/images/explosion_bat.gif")));
				int lx = batView.getPosicionx(); 
				int ly = batView.getPosiciony();
				lblBateria.setBounds(lx - 5, ly - 15, 75, 43);
				
				if(Controlador.getInstance().partida.jugador.vidas == 0) {
					
					gameOver();
				}
				
				else {
					// Timer para delay de volver a arrancar partida
					Timer timerMuerte = new Timer();
					TimerTask tareaMuerte = new TimerTask() {
						public void run() {
							lblNumVidas.setText(Integer.toString(Controlador.getInstance().partida.jugador.vidas));
							lblNumVidas.setFont(retro.cargarFont("8-BIT WONDER.TTF", 18));
							lblNumVidas.setForeground(Color.GREEN);
							lblNumVidas.setBounds(695, 20, 40, 30);
							
							batView.setPosicionx(360);
							batView.setPosiciony(540);
							batView.setVelocidad(0);
							lblBateria.setIcon(new ImageIcon(this.getClass().getResource("/images/png_bateria.png")));
							lblBateria.setBounds(360, 540, 60, 28);
							
							agregarMuros();

							flagTeclas = 1;
							
						}
					};
					

					timerMuerte.schedule(tareaMuerte, 3000);
					
					timerMovBat = new Timer();
					tareaMovBat = new manejoMovimientoBateria();
					timerMovBat.schedule(tareaMovBat, 3000, 5);

					timerMovNav = new Timer();
					tareaMovNav = new manejoMovimientoNaves();
					timerMovNav.schedule(tareaMovNav, 3000, Controlador.getInstance().partida.velocidadNavesMS);
					
					
					frJuego.repaint();
				}
			}
			
		}
		private void moverDisparo(int x, int y) {
			pev.setPosiciony(y+4);
			lblProyNav.setBounds(x, y+4, 12, 28);
			frJuego.repaint();
		}
		
		private void destruirDisparo() {

			pev.setEstado(false);
			pev.setPosicionx(0);
			pev.setPosiciony(0);
			lblProyNav.setBounds(0, 0, 0, 0);
			tareaDisparoEnemigo.cancel();
			timerDisparoEnemigo.cancel();
			timerDisparoEnemigo.purge();
			frJuego.repaint();
			
		}
	}

	
//--------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
}
