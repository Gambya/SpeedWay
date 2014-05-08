package br.com.gi.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JPanel;

public class Panel extends JPanel {
	private Image img;      
    private int x;    
    private int y;    
    private Dimension janela;
    
    public Panel(){
    	this.x = 0;
    	this.y = 0;
    	URL urlimg = Toolkit.getDefaultToolkit().getClass().getResource("../../../assets/img/gt5.jpg");
    	this.img =  Toolkit.getDefaultToolkit().getImage(urlimg);
    	this.janela = Toolkit.getDefaultToolkit().getScreenSize();
    	this.setOpaque(false);
    }    
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(this.img, this.x,this.y, this.janela.getSize().width, this.janela.getSize().height, this);
	}
}
