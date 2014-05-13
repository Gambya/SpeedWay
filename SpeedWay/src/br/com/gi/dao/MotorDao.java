package br.com.gi.dao;

import java.util.ArrayList;

import br.com.gi.objetos.Motor;


public class MotorDao {
	public ArrayList<Motor> lmotor;

	public MotorDao() {
		this.lmotor = new ArrayList<Motor>();
	}
	
	
	public void carregarDados(){
		Motor motor1 = new Motor();
		motor1.setModelo("VW");
		motor1.setConsumo(0.600);
		motor1.setIndice(6);
		motor1.setPotencia(300);
		motor1.setValor(00.00);
		this.lmotor.add(motor1);
		
		
		Motor motor2  = new Motor();
		motor2.setModelo("lottus");
		motor2.setConsumo(0.548);
		motor2.setIndice(7);
		motor2.setPotencia(320);
		motor2.setValor(5000.00);
		this.lmotor.add(motor2);
		
		
		
		Motor motor3  = new Motor();
		motor3.setModelo("BMW");
		motor3.setConsumo(0.500);
		motor3.setIndice(9);
		motor3.setPotencia(339);
		motor3.setValor(8000.00);
		this.lmotor.add(motor3);
		
		
		Motor motor4  = new Motor();
		motor4.setModelo("Mercedes-Benz");
		motor4.setConsumo(0.510);
		motor4.setIndice(10);
		motor4.setPotencia(340);
		motor4.setValor(10000.00);
		this.lmotor.add(motor4);
	}

}
