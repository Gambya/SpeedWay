package br.com.gi.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Menu {
	private int cenario;
	private int itemSelected = 0;
	public ArrayList<String> itens;
	private Graphics bbg;
	private boolean ativo;
	private int x;
	private int y;
	private int tamanhoFont;
	private int padding;
	private Font fonte;
	private Color corSelected;
	private Color corNSelected;
	
	public Menu(int x, int y, boolean ativo){
		this.cenario = -1;
		this.itemSelected = 0;
		this.itens = new ArrayList<String>();
		this.tamanhoFont = x/10;
		this.x = x;
		this.y = y;
		this.ativo = ativo;
		this.tamanhoFont = x/10;
		this.fonte = new Font("Arial", Font.BOLD, this.tamanhoFont);
		this.padding = 15;
		this.corSelected = new Color(255,0,0);
		this.corNSelected = new Color(255,255,255);
	}
	
	public void controle(KeyEvent e){
		if(this.ativo){
			this.controlarMenu(e);
		}
	}
	
	public void returnMenu(KeyEvent e){
		if(e.getKeyCode() == e.VK_ESCAPE){
			this.cenario = -1;
			this.ativo = true;
		}
	}

	private void controlarMenu(KeyEvent e) {
		if(e.getKeyCode() == e.VK_UP){
			this.itemSelected -= 1;
		}
		if(e.getKeyCode() == e.VK_DOWN){
			this.itemSelected +=1;
		}
		
		if(this.itemSelected >= this.itens.size()){
			this.itemSelected = 0;
		}
		if(this.itemSelected < 0){
			this.itemSelected = this.itens.size()-1;
		}
		
		if(e.getKeyCode() == e.VK_ENTER){
			this.cenario = this.itemSelected;
			this.ativo = false;
		}
	}
	
	public int getCenario() {
		return cenario;
	}

	public void drawMenu(){
		bbg.setFont(this.fonte);
		
		for (int i = 0; i < this.itens.size(); i++) {
			if(this.itemSelected == i){
				bbg.setColor(corSelected);
				bbg.drawString(this.itens.get(i), x,  y+(i*(this.tamanhoFont+this.padding)));
			}else{
				bbg.setColor(corNSelected);
				bbg.drawString(this.itens.get(i), x,  y+(i*(this.tamanhoFont+this.padding)));
			}
		}
	}
	
	public void setBbg(Graphics bbg) {
		this.bbg = bbg;
	}
}
