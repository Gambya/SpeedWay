package br.com.gi.utils;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class StartCorrida extends JFrame implements Runnable{
		private int FPS;
		private Dimension janela;
		private BufferedImage backBuffer;
		private ImageIcon fundo;
		private Graphics g;
		public Thread tStartCorrida;
		private boolean flag;
		
	public StartCorrida(){
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
		this.fundo = new ImageIcon("src/assets/img/telaPista.png"); // Instanciando a imagem do fundo
		this.g = this.getGraphics(); // Pegando o Graphics para desenhar
		
		this.flag = false;
		
		this.desenhar();
	}
	@Override
	public void run() {
		while(!this.flag){
			this.desenhar();
			try{
				this.tStartCorrida.sleep(1000/this.FPS);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void desenhar(){
		// Printando fundo
		Graphics bbg = backBuffer.getGraphics(); 
		bbg.drawImage(this.fundo.getImage(),0,0,this.janela.getSize().width,this.janela.getSize().height,this); // Desenha o fundo no backBuffer
		
		
		// O desenho do backBuffer deve ser desenhado depois de tudo
		g.drawImage(backBuffer, 0, 0, this.janela.getSize().width, this.janela.getSize().height, this); // Desenha o backBuffer no Graphics do JFrame
	}
	

}
