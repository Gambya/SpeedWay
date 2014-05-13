package br.com.gi.dao;

import java.util.ArrayList;

import br.com.gi.objetos.Cambio;

public class CambioDao {

	public ArrayList<Cambio> lCambio;

	public CambioDao() {
		this.lCambio = new ArrayList<Cambio>();

	}

	public void carregaDados() {

		Cambio cambio1 = new Cambio();
		cambio1.setModelo("Optimus Prime");
		cambio1.setIndice(10);
		cambio1.setValor(00.00);
		this.lCambio.add(cambio1);

		Cambio cambio2 = new Cambio();
		cambio2.setModelo("Glub");
		cambio2.setIndice(8);
		cambio2.setValor(4000.00);
		this.lCambio.add(cambio2);

		Cambio cambio3 = new Cambio();
		cambio3.setModelo("kings");
		cambio3.setIndice(7);
		cambio3.setValor(3000.00);
		this.lCambio.add(cambio3);

		Cambio cambio4 = new Cambio();
		cambio4.setModelo("Samarino");
		cambio4.setIndice(6);
		cambio4.setValor(2000.00);
		this.lCambio.add(cambio4);
	}

}
