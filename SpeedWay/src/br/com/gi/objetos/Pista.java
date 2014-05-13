package br.com.gi.objetos;


public class Pista {
	private String Nome;
	private Pneu pneuPista;
	private int tamanhoPista;
	private int voltas;
	private int tamanhoTotalPista;
	private int agressividade;
	private int tempoEntradaSaidaBox;
	private Cambio cambio;
	private Suspensao suspensao;
	private Freio freio;
	private String ImgPista;
	
	public String getImgPista() {
		return ImgPista;
	}
	public void setImgPista(String img) {
		ImgPista = img;
	}
	public Cambio getCambio() {
		return cambio;
	}
	public void setCambio(Cambio cambio) {
		this.cambio = cambio;
	}
	public Suspensao getSuspensao() {
		return suspensao;
	}
	public void setSuspensao(Suspensao suspensao) {
		this.suspensao = suspensao;
	}
	public Freio getFreio() {
		return freio;
	}
	public void setFreio(Freio freio) {
		this.freio = freio;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Pneu getPneuPista() {
		return pneuPista;
	}
	public void setPneuPista(Pneu pneuPista) {
		this.pneuPista = pneuPista;
	}
	public int getTamanhoPista() {
		return tamanhoPista;
	}
	public void setTamanhoPista(int tamanhoPista) {
		this.tamanhoPista = tamanhoPista;
	}
	public int getVoltas() {
		return voltas;
	}
	public void setVoltas(int voltas) {
		this.voltas = voltas;
	}
	public int getTamanhoTotalPista() {
		return tamanhoTotalPista;
	}
	public void setTamanhoTotalPista(int tamanhoTotalPista) {
		this.tamanhoTotalPista = tamanhoTotalPista;
	}
	public int getAgressividade() {
		return agressividade;
	}
	public void setAgressividade(int agressividade) {
		this.agressividade = agressividade;
	}
	public int getTempoEntradaSaidaBox() {
		return tempoEntradaSaidaBox;
	}
	public void setTempoEntradaSaidaBox(int tempoEntradaSaidaBox) {
		this.tempoEntradaSaidaBox = tempoEntradaSaidaBox;
	}
}
