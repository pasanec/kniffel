package de.pasanec.kniffel;

import java.util.ArrayList;

public class Person {
	private String name;
	private Block block;
	
	public String getName() {
		return this.name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public Block getBlock() {
		return this.block;
	}
	private void setBlock(Block block) {
		this.block = block;
	}
	
	public Person(String name) {
		this.setName(name);
		this.setBlock(new Block());
	}
	
	// Hilfsfunktionen zum einfachen Zugang
	
	public String ausgabe() {
		String out = name + "\r\n";
		out += "==================\r\n";
		out += this.getBlock().ausgabe();
		
		return out;
	}
	
	public int eingabe(ArrayList<Wuerfel> aw, int a) {
		return this.getBlock().eintragen(aw, a);
	}
	
	public int punkte() {
		return this.getBlock().rechneZusammen();
	}	
}
