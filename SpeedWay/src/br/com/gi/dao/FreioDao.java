package br.com.gi.dao;

import java.util.ArrayList;

import br.com.gi.objetos.Freio;


public class FreioDao {

	public ArrayList<Freio> lFreio;

	public FreioDao() {

		this.lFreio = new ArrayList<Freio>();

	}

	public void carregaDados() {

		Freio freio1 = new Freio();

		freio1.setModelo("C4P0");
		freio1.setIndice(10);

		this.lFreio.add(freio1);

		Freio freio2 = new Freio();

		freio2.setModelo("Patterson");
		freio2.setIndice(8);

		this.lFreio.add(freio2);

		Freio freio3 = new Freio();

		freio3.setModelo("Minarets");
		freio3.setIndice(7);

		this.lFreio.add(freio3);

		Freio freio4 = new Freio();

		freio4.setModelo("Tubator");
		freio4.setIndice(6);

		this.lFreio.add(freio4);

	}

}
