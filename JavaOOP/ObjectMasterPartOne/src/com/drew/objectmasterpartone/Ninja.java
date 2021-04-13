package com.drew.objectmasterpartone;

public class Ninja extends Human{
	public Ninja() {
		setStealth(10);
	}
	
	public void steal(Human human) {
		human.setHealth(human.getHealth() - getStealth());
		setHealth(getHealth() + getStealth());
		
	}
	
	public void runAway() {
		setHealth(getHealth() - 10);
	}
}
