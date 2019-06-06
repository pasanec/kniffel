package de.pasanec.kniffel;

import java.util.ArrayList;
import java.util.HashMap;

public class StartGame {
	private ArrayList<Person> personen;
	private HashMap<String, Integer> ergebnisse;
	private Wuerfelbecher wb;
	private Tisch ti;
	private GameMenu m;
	
	private ArrayList<Person> getPersonen() {
		return this.personen;
	}
	private void setPersonen(ArrayList<Person> personen) {
		this.personen = personen;
	}
	public HashMap<String, Integer> getErgebnisse() {
		return this.ergebnisse;
	}
	private void setErgebnisse(HashMap<String, Integer> ergebnisse) {
		this.ergebnisse = ergebnisse;
	}
	private Wuerfelbecher getWb() {
		return this.wb;
	}
	private void setWb(Wuerfelbecher wb) {
		this.wb = wb;
	}
	private Tisch getTi() {
		return this.ti;
	}
	private void setTi(Tisch ti) {
		this.ti = ti;
	}
	private GameMenu getM() {
		return this.m;
	}
	private void setM(GameMenu m) {
		this.m = m;
	}
	
	public StartGame() {
		this.setM(new GameMenu());
		if(this.getM().m0() == 1) {
			System.out.println("Robocop hat keine Zeit, er muss die Welt retten!");
		}
		this.setPersonen(new ArrayList<Person>());
		for(String name: this.getM().m1()) {
			this.getPersonen().add(new Person(name));
		}
		this.setErgebnisse(new HashMap<String, Integer>());
		for(Person person: this.getPersonen()) {
			this.getErgebnisse().put(person.getName(), 0);
		}
		this.setWb(new Wuerfelbecher());
		this.setTi(new Tisch());		
	}
	
	public HashMap<String, Integer> start(){
		return ergebnisse;
	}
	
	
	
	
	
	
	
}
