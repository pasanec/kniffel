package de.pasanec.kniffel;

import java.util.ArrayList;
import java.util.HashMap;

public class StartGame {
	private ArrayList<Person> personen;
	private HashMap<String, Integer> ergebnisse;
	private Wuerfelbecher wb;
	private Tisch ti;
	private GameMenu m;
	
	public ArrayList<Person> getPersonen() {
		return this.personen;
	}
	private void setPersonen(ArrayList<Person> personen) {
		this.personen = personen;
	}
	private HashMap<String, Integer> getErgebnisse() {
		return ergebnisse;
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
	
	
	
	
	
	
}
