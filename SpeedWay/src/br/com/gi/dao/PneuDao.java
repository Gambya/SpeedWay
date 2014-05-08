package br.com.gi.dao;

import java.util.ArrayList;

import br.com.gi.objetos.Pneu;

public class PneuDao {
	public ArrayList<Pneu> lPneu;

	public PneuDao() {
		this.lPneu = new ArrayList<Pneu>();
	}

	public void carregarDados() {
		Pneu pneu1 = new Pneu();
		pneu1.setModelo("Pirelli");
		pneu1.setDurabilidade(140);
		pneu1.setIndice(9);
		this.lPneu.add(pneu1);
		
		Pneu pneu2 = new Pneu();
		pneu2.setModelo("firestone");
		pneu2.setDurabilidade(150);
		pneu2.setIndice(10);
		this.lPneu.add(pneu2);
		
		Pneu pneu3 = new Pneu();
		pneu3.setModelo("Bridgestone");
		pneu3.setDurabilidade(135);
		pneu3.setIndice(8);
		this.lPneu.add(pneu3);
		
		
		Pneu pneu4 = new Pneu();
		pneu4.setModelo("Goodyear");
		pneu4.setDurabilidade(137);
		pneu4.setIndice(9);
		this.lPneu.add(pneu4);
		
		
	}
}