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
		pneu1.setModelo("Duro");
		pneu1.setDurabilidade(160);
		pneu1.setIndice(9);
		pneu1.setValor(00.00);
		this.lPneu.add(pneu1);
		
		Pneu pneu2 = new Pneu();
		pneu2.setModelo("Macio");
		pneu2.setDurabilidade(120);
		pneu2.setIndice(10);
		pneu2.setValor(1000.00);
		this.lPneu.add(pneu2);
		
		Pneu pneu3 = new Pneu();
		pneu3.setModelo("Chuva Forte");
		pneu3.setDurabilidade(135);
		pneu3.setIndice(8);
		pneu3.setValor(800.00);
		this.lPneu.add(pneu3);
		
		
		Pneu pneu4 = new Pneu();
		pneu4.setModelo("Intermediário");
		pneu4.setDurabilidade(137);
		pneu4.setIndice(9);
		pneu4.setValor(600.00);
		this.lPneu.add(pneu4);
	}
}