package de.pasanec.kniffel;

import java.util.ArrayList;
import java.util.HashMap;

public class StartGame {
	private ArrayList<Person> personen;
	private HashMap<String, Integer> ergebnisse;
	private Wuerfelbecher wb;
	private Tisch ti;
	private GameMenu m;
	private int temp;
	
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
	private int getTemp() {
		return this.temp;
	}
	private void setTemp(int temp) {
		this.temp = temp;
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
		for(int i = 0; i < 13; i++) {
			System.out.println("---------------------------");
			System.out.println("Runde " + (i+1)  + " von 13");
			System.out.println("---------------------------");
			for(int j = 0; j < this.getPersonen().size(); j++) {
				System.out.println("Spieler " + (j+1) + "von " + this.getPersonen().size() + " - " + "Runde " + (i+1)  + " von 13");
				System.out.println("### " + this.getPersonen().get(j).getName() + "###");
				System.out.println(this.personen.get(j).ausgabe());
				this.getWb().setWuerfel(5);
				for(int k = 0; k < 2; k++) {
					 System.out.println(this.getWb().zeige());
					 this.getTi().hinzufuegen(this.getWb().getWuerfel());
					 this.getTi().loeschen(this.getM().m2());
					 if(this.getTi().getWuerfel().size() == 5) {
						 break;
					 }
					 this.getWb().setWuerfel(5 - this.getTi().getWuerfel().size());					 
				}
				this.setTemp(this.getM().m3());
				if(this.getTemp() == 0) {
					System.out.println("Das Spiel wurde abgebrochen.");
					return this.ergebnisse;
				}
				this.getPersonen().get(j).eingabe(this.getTi().getWuerfel(), this.getTemp());
				this.getErgebnisse().put(this.getPersonen().get(j).getName(), this.getPersonen().get(j).punkte());				
			}
		}
		System.out.println(this.getErgebnisse().get(this.getErgebnisse().size() - 1) + " hat gewonnen\r\n\r\n");
		return this.getErgebnisse();
	}
	
	
	
	
	
	
	
}
