package br.com.gi.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class TextBox{

	private ArrayList<Character> digito;
	private Graphics g;
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean enable;
	private Color backgroundColor;
	private Color fColor;
	private Font font;
	private int tFont;
	private String string;
	private int padding;
	
	public TextBox(Graphics g){
		this.setG(g);
		this.setX(0);
		this.setY(0);
		this.setEnable(true);
		this.backgroundColor = new Color(255,255,255);
		this.fColor = new Color(0,0,0);
		this.setWidth(300);
		this.setHeight(40);
		this.tFont = 60;
		this.font = new Font("Arial", Font.BOLD, this.tFont);
		this.string = "";
		this.padding = 3;
	}
	
	public TextBox(Graphics g, int x, int y, boolean enable){
		this.setG(g);
		this.setX(x);
		this.setY(y);
		this.setEnable(enable);
		this.backgroundColor = new Color(255,255,255);
		this.fColor = new Color(0,0,0);
		this.setWidth(500);
		this.setHeight(40);
		this.tFont = 60;
		this.font = new Font("Arial", Font.BOLD, this.tFont);
		this.string = "";
		this.padding = 3;
	}

	// Getters and Setters
	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	private void apresentaTexto() {
		for(int i = 0; i < this.digito.size(); i++){
			this.string += this.digito.get(i);
		}
	}
	
	// Método de desenho do TextBox
	public void drawTextBox(){
		this.g.setFont(this.font);
		this.g.setColor(backgroundColor);
		this.g.fillRoundRect(this.x, this.y, this.width, this.height, 5, 5);
		this.g.setColor(fColor);
		this.g.drawRoundRect(this.x, this.y, this.width, this.height, 5, 5);
		this.g.setColor(this.fColor);
		this.g.drawString(this.string, this.x+this.padding, this.y+this.padding);
	}

	// Métodos da Interface que escuta o teclado
	public void controlTextBox(KeyEvent e) {
		char c = e.getKeyChar();
		if(e.getKeyCode() != e.VK_BACK_SPACE && e.getKeyCode() != e.VK_UP && e.getKeyCode() != e.VK_DOWN){
			this.digito.add(c);
			this.apresentaTexto();
		}
		if(e.getKeyCode() == e.VK_BACK_SPACE){
			this.digito.remove(this.digito.size()-1);
		}
	}
}
