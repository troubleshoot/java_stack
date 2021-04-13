package com.drew.objectmasterpartone;

public class HumanTest {

	public static void main(String[] args) {
		Human nat = new Human();
		Human drew = new Human();
		nat.attack(drew);
		System.out.println(drew.getHealth());
		Wizard john = new Wizard();
		john.heal(drew);
		System.out.println(drew.getHealth());
		john.fireball(drew);
		System.out.println(drew.getHealth());
		Ninja gabe = new Ninja();
		gabe.steal(drew);
		System.out.println(drew.getHealth());
		gabe.runAway();
		System.out.println(gabe.getHealth());
		Samurai sam = new Samurai();
		sam.deathBlow(drew);
		System.out.println(drew.getHealth());
		System.out.println(sam.getHealth());
		sam.meditate();
		System.out.println(sam.getHealth());
		sam.howMany();

	}

}
