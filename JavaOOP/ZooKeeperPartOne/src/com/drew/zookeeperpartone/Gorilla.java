package com.drew.zookeeperpartone;

public class Gorilla extends Mammal {
	public void throwSomething() {
		System.out.println("Gorilla has thrown something. Energy now at " + removeEnergy(5) + "!");
	}
	
	public void eatBananas() {
		System.out.println("Gorilla ate bananas, satisfaction level increased. Energy now at " + addEnergy(10) + "!");
	}
	
	public void climb() {
		System.out.println("Gorilla has climbed a tree. Energy now at " + removeEnergy(10) + "!");
	}
	
	public void showEnergy() {
		displayEnergy();
	}
}
