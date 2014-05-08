package br.com.gi.dao;

import java.util.ArrayList;

import br.com.gi.objetos.Chassis;

public class ChassisDao {

	public ArrayList<Chassis> lChassis;

	public ChassisDao() {
		this.lChassis = new ArrayList<Chassis>();

	}

	public void carregaDados() {

		Chassis chassi1 = new Chassis();
		chassi1.setModelo("Trudy Chacon");
		chassi1.setIndice(10);
		this.lChassis.add(chassi1);

		Chassis chassi2 = new Chassis();

		chassi2.setModelo("Thanator");
		chassi2.setIndice(9);
		this.lChassis.add(chassi2);

		Chassis chassi3 = new Chassis();
		chassi3.setModelo("Widmore");
		chassi3.setIndice(7);
		this.lChassis.add(chassi3);

		Chassis chassi4 = new Chassis();

		chassi4.setModelo("Brad Bellick");
		chassi4.setIndice(6);
		this.lChassis.add(chassi4);

	}

}
