package com.drew.zookeeperparttwo;

public class Bat extends Mammal {
	public Bat() {
		setEnergyLevel(300);
	}
	public void fly() {
		System.out.println("Bat has flown. Energy now at " + removeEnergy(50) + "!");
	}
	
	public void eatHumans() {
		System.out.println("Bye bye human. Energy now at " + addEnergy(25) + "!");
	}
	
	public void attackTown() {
		System.out.println("AAAAAAAAAHHHHHHHHHHHHHHHttack on town. Energy now at " + removeEnergy(100) + "!");
	}
	
	public void showEnergy() {
		displayEnergy();
	}
}

