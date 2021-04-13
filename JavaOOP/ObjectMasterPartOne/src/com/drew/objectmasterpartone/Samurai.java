package com.drew.objectmasterpartone;

public class Samurai extends Human{
	private int number = 0;
	
	public Samurai() {
		setHealth(200);
		number += 1;
	}
	
	public void deathBlow(Human human) {
		human.setHealth(0);
		setHealth(getHealth() / 2);
	}
	
	public void meditate() {
		setHealth(getHealth() + (getHealth() / 2));
	}
	
	public void howMany() {
		System.out.println("There are " + number + " Samurai.");
	}
}
