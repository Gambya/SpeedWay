package br.com.gi.dao;

import java.util.ArrayList;

import br.com.gi.objetos.Suspensao;

public class SuspensaoDao {

	public ArrayList<Suspensao> lSuspensao;

	public SuspensaoDao() {

		this.lSuspensao = new ArrayList<Suspensao>();

	}

	public void carregaDados() {

		Suspensao suspensao1 = new Suspensao();
		suspensao1.setModelo("Cosmic Buffer");
		suspensao1.setIndice(6);
		suspensao1.setValor(00.00);
		this.lSuspensao.add(suspensao1);

		Suspensao suspensao2 = new Suspensao();
		suspensao2.setModelo("Padawan");
		suspensao2.setIndice(7);
		suspensao2.setValor(800.00);
		this.lSuspensao.add(suspensao2);

		Suspensao suspensao3 = new Suspensao();
		suspensao3.setModelo("Breathe");
		suspensao3.setIndice(9);
		suspensao3.setValor(1000.00);
		this.lSuspensao.add(suspensao3);

		Suspensao suspensao4 = new Suspensao();
		suspensao4.setModelo("Exodus");
		suspensao4.setIndice(10);
		suspensao4.setValor(1200.00);
		this.lSuspensao.add(suspensao4);
	}

}
