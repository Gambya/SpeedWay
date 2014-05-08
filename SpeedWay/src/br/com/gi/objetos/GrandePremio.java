package br.com.gi.objetos;

import java.util.ArrayList;
import java.util.Random;

public class GrandePremio {
	private Pista pista;
	public ArrayList<Carro> carros;
	private Tempo tempo;
	
	public GrandePremio(Pista pista){
		this.setPista(pista);
		this.selecionarTempo();
		this.selecionarCarros();
	}
	
	private void selecionarCarros() {
		// TODO Auto-generated method stub
		
	}

	public Pista getPista() {
		return pista;
	}
	public void setPista(Pista pista) {
		this.pista = pista;
	}
	
	private Tempo selecionarTempo(){
		this.selecionarTemp();
		this.selecionarQtdAgua();
		return this.tempo;
	}
	private void selecionarQtdAgua() {
		Random chuvendo = new Random();
		if(chuvendo.nextBoolean()){
			Random qtdAgua = new Random();
			this.tempo.setQtdAguaPista(qtdAgua.nextInt(7)+1);
		}else{
			this.tempo.setQtdAguaPista(0);
		}
	}
	private void selecionarTemp(){
		Random gerador = new Random();
		int indice = gerador.nextInt(10);
		
		if(indice <= 3){
			Random temp = new Random();
			this.tempo.setTemperatura((temp.nextInt(10))+10);
		}else if(indice >= 4 && indice <= 6){
			Random temp = new Random();
			this.tempo.setTemperatura((temp.nextInt(10))+20);
		}else{
			Random temp = new Random();
			this.tempo.setTemperatura((temp.nextInt(10))+30);
		}
	}
}