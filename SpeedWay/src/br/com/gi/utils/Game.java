package br.com.gi.utils;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends JFrame implements KeyListener,Runnable {
	private BufferedImage backBuffer; // Nosso Buffer
	private int FPS; // Taxa de Atualização de tela
	private Dimension janela;
	private ImageIcon fundo;
	private ImageIcon logo;
	private Menu menu;
	private Graphics g;
		
	public Game(){
		this.FPS = 30;
		this.janela = Toolkit.getDefaultToolkit().getScreenSize();
		this.backBuffer = new BufferedImage(this.janela.getSize().width, this.janela.getSize().height, BufferedImage.TYPE_INT_RGB);
		this.setTitle("SpeedWay"); // Definindo o Título da Janela
		this.setSize(this.janela.getSize().width, this.janela.getSize().height); // Definindo Tamanho da Janela
		this.setLocationRelativeTo(null);// Centralizar janelas
		this.setResizable(false); // Não deixar redimencionar
		this.setUndecorated(true); // Retirar as Bordas da janela
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para o botão fechar finalizar a app
		this.setLayout(null); // Setando o layout do JFrame para null
		this.setVisible(true); // Deixando o JFrame Visível
		URL url = this.getClass().getResource("/assets/img/logo1.png"); // Pegando a logo para icone
		Image icone = Toolkit.getDefaultToolkit().getImage(url); // setando a logo para uma imagem
		this.setIconImage(icone); // Seta a imagem do icone
		this.fundo = new ImageIcon("src/assets/img/Splash.jpg"); // Instanciando a imagem do fundo
		this.logo = new ImageIcon("src/assets/img/logo.png"); // Instancia da imagem da logo do jogo
		this.g = this.getGraphics(); // Pegando o Graphics para desenhar
		// Instanciar um menu
		menu = new Menu(this.janela.getSize().width/2,this.janela.getSize().height/2, true); // Instanciando o Menu
		
		// adicionando um escutador de teclas
		this.addKeyListener(this); // Escutando o teclado
		
		// Aqui definimos os textos dos menus
		this.menu.itens.add("Start Game");
		this.menu.itens.add("Créditos");
		this.menu.itens.add("Sair do Game");
		
		this.menu.setBbg(backBuffer.getGraphics());
		
		// Chamar methodo desenhar
		this.desenhar();
	}
	
	public void desenhar(){
		// Printando fundo
		Graphics bbg = backBuffer.getGraphics(); 
		bbg.drawImage(this.fundo.getImage(),0,0,this); // Desenha o fundo no backBuffer
		
		// Desenhar logo
		bbg.drawImage(this.logo.getImage(), 0, 0, this.logo.getIconWidth()/4, this.logo.getIconHeight()/4, this);
		
		// Desenhar menu principal
		menu.drawMenu();
		this.scenes();
		
		// O desenho do backBuffer deve ser desenhado depois de tudo
		g.drawImage(backBuffer,0,0,this); // Desenha o backBuffer no Graphics do JFrame
	}
	
	public void scenes(){
		if(this.menu.getCenario() == 0){
			try {
				this.play();
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Throwable e){
				e.printStackTrace();
			}
		}else if(this.menu.getCenario() == 1){
			this.creditos();
		}else if(this.menu.getCenario() == 2){
			System.exit(0);
		}
	}
	
	private void creditos() {
		// TODO Auto-generated method stub
		
	}

	private void play() throws Throwable {
		Garagem garagem = new Garagem();
		this.finalize();
		this.dispose();
	}

	@Override
	public void run() {
		while(true){
			this.desenhar();
			try{
				Thread.sleep(1000/this.FPS);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		this.menu.controle(e);
		this.menu.returnMenu(e);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
