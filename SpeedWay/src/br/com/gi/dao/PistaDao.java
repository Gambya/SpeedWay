package br.com.gi.dao;

import java.util.ArrayList;

import br.com.gi.objetos.Pista;

public class PistaDao {
	public ArrayList<Pista> lPistas;
	
	public PistaDao(){
		this.lPistas = new ArrayList<Pista>();
	}
	
	public void carregarDados(){
		Pista brasil = new Pista();
		brasil.setImgPista("/assets/img/pistas/brazil-interlagos.png");
		brasil.setNome("Grande Prêmio do Brasil");
		brasil.setTamanhoTotalPista(305939);
		brasil.setVoltas(71);
		brasil.setTamanhoPista(4309);
		brasil.setTempoEntradaSaidaBox(12);
		brasil.setAgressividade(70);
		this.lPistas.add(brasil);
		
		Pista eua = new Pista();
		eua.setImgPista("/assets/img/pistas/eua-indianapolis.png");
		eua.setNome("Grande Prêmio dos EUA");
		eua.setTamanhoTotalPista(306016);
		eua.setVoltas(73);
		eua.setTamanhoPista(4192);
		eua.setTempoEntradaSaidaBox(17);
		eua.setAgressividade(80);
		this.lPistas.add(eua);
	}
}
