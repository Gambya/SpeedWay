package br.com.gi.utils;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelGrandePremio extends JPanel {
	
	public PanelGrandePremio(){
		super();
		setOpaque(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(new Color(255,255,255,150));
		
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
