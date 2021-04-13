package com.drew.objectmasterpartone;

public class Wizard extends Human{
	
	public Wizard() {
		setHealth(80);
		setIntelligence(8);
	}
	
	public void heal(Human human) {
		human.setHealth(100);
	}
	
	public void fireball(Human human) {
		human.setHealth(human.getHealth() - (getIntelligence() * 3));
	}
}