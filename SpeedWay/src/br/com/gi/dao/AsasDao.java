package br.com.gi.dao;

import java.util.ArrayList;

import br.com.gi.objetos.Asas;

public class AsasDao {

	public ArrayList<Asas> lAsa;

	public AsasDao() {
		this.lAsa = new ArrayList<Asas>();
	}

	public void carregarDados() {
		Asas asa1 = new Asas();
		asa1.setModelo("McFly");
		asa1.setIndice(10);
		this.lAsa.add(asa1);

		Asas asa2 = new Asas();
		asa2.setModelo("bronco");
		asa2.setIndice(7);
		this.lAsa.add(asa2);

		Asas asa3 = new Asas();
		asa3.setModelo("Romefeller");
		asa3.setIndice(8);
		this.lAsa.add(asa3);

		Asas asa4 = new Asas();
		asa4.setModelo("Scylla");
		asa4.setIndice(6);
		this.lAsa.add(asa4);

	}

}
