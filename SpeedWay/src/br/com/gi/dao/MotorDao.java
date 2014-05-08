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
		motor1.setModelo("Mercedes-Benz");
		motor1.setConsumo(0.600);
		motor1.setIndice(10);
		motor1.setPotencia(367);
		this.lmotor.add(motor1);
		
		
		Motor motor2  = new Motor();
		motor2.setModelo("BMW");
		motor2.setConsumo(0.548);
		motor2.setIndice(9);
		motor2.setPotencia(350);
		this.lmotor.add(motor2);
		
		
		
		Motor motor3  = new Motor();
		motor3.setModelo("VW");
		motor3.setConsumo(0.500);
		motor3.setIndice(7);
		motor3.setPotencia(300);
		this.lmotor.add(motor3);
		
		
		Motor motor4  = new Motor();
		motor4.setModelo("lottus");
		motor4.setConsumo(0.510);
		motor4.setIndice(8);
		motor4.setPotencia(340);
		this.lmotor.add(motor4);
		
		
		
		
		
		
	}

}
