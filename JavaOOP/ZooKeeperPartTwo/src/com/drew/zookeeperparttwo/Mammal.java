package com.drew.zookeeperparttwo;

public class Mammal {
	private int energyLevel;

	public Mammal() {
		this.energyLevel = 100;
	}
	
	public int displayEnergy() {
		System.out.println("Energy: " + energyLevel);
		return energyLevel;
	}
	
	public int removeEnergy(int amount) {
		this.energyLevel -= amount;
		return energyLevel;
	}
	
	public int addEnergy(int amount) {
		this.energyLevel += amount;
		return energyLevel;
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
}
