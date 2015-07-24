package com.makerimages.forklift;

public class Main {

	public static Forklift fork;
	
	public static void main(String[] args) {
		fork = new Forklift("Forklift Tech Demo",800,600);
	
		fork.init();
	}

}
