package br.com.gi.utils;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class GaragemOptions extends JPanel {
	private JLabel jlTitulo;
	private JLabel jlPiloto;
	private JTextField piloto;
	private int jWidth = 300;
	private int jHeight = 600;
	
	public GaragemOptions(){
		this.setSize(this.jWidth, this.jHeight); // Definindo Tamanho da Janela
		this.setLayout(null);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, new Color(168,168,168), new Color(205,205,205)));
		jlTitulo = new JLabel("GARAGEM");
		jlTitulo.setForeground(new Color(255,0,0));
		jlTitulo.setFont(new Font("Arial",Font.ITALIC, 18));
		jlTitulo.setBounds((this.getSize().width/2)-(100/2), 5, 100, 20);
		jlPiloto = new JLabel("Nome do Piloto");
		jlPiloto.setForeground(new Color(255,0,0));
		jlPiloto.setFont(new Font("Arial",Font.ITALIC, 12));
		jlPiloto.setBounds((this.getSize().width/2)-(100/2), 15, 100, 20);
		piloto = new JTextField(20);
		this.add(jlTitulo);
		this.add(jlPiloto);
		this.add(piloto);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawRect(40, 200, this.jWidth, this.jHeight);
	}
}
