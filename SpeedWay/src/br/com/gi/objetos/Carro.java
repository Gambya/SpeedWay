package br.com.gi.objetos;

public class Carro {
	private Motor motor;
	public Motor getMotor() {
		return motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	public Pneu getPneu() {
		return pneu;
	}
	public void setPneu(Pneu pneu) {
		this.pneu = pneu;
	}
	public Cambio getCambio() {
		return cambio;
	}
	public void setCambio(Cambio cambio) {
		this.cambio = cambio;
	}
	public Freio getFreio() {
		return freio;
	}
	public void setFreio(Freio freio) {
		this.freio = freio;
	}
	public int getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(int combustivel) {
		this.combustivel = combustivel;
	}
	public Suspensao getSuspensao() {
		return suspensao;
	}
	public void setSuspensao(Suspensao suspensao) {
		this.suspensao = suspensao;
	}
	public Asas getAsas() {
		return asas;
	}
	public void setAsas(Asas asas) {
		this.asas = asas;
	}
	private Pneu pneu;
	private Cambio cambio;
	private Freio freio;
	private int combustivel;
	private Suspensao suspensao;
	private Asas asas;
}
