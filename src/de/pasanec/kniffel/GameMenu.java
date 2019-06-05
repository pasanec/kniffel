package de.pasanec.kniffel;

import java.util.Scanner;

public class GameMenu {
	private String anzeigetext1;
	private String anzeigetext2;
	private String anzeigetext3;
	private String abfrage;
	private String[] ausgabe;
	private int[] numAusgabe;
	private Scanner sc;
	
	
	public String getAnzeigetext1() {
		return anzeigetext1;
	}
	private void setAnzeigetext1(String anzeigetext1) {
		this.anzeigetext1 = anzeigetext1;
	}
	public String getAnzeigetext2() {
		return anzeigetext2;
	}
	private void setAnzeigetext2(String anzeigetext2) {
		this.anzeigetext2 = anzeigetext2;
	}
	public String getAnzeigetext3() {
		return anzeigetext3;
	}
	public void setAnzeigetext3(String anzeigetext3) {
		this.anzeigetext3 = anzeigetext3;
	}
	public String getAbfrage() {
		return abfrage;
	}
	private void setAbfrage(String abfrage) {
		this.abfrage = abfrage;
	}	
	public String[] getAusgabe() {
		return ausgabe;
	}
	public void setAusgabe(String[] ausgabe) {
		this.ausgabe = ausgabe;
	}
	public GameMenu() {
		this.setAbfrage("-1");
		this.setAnzeigetext1("Wie viele Personen möchten mitspielen? Eingabe: ");
		this.setAnzeigetext2("Geben Sie Ihren Namen ein: ");
		this.setAnzeigetext3("0: Abbrechen\r\nWelches Feld moechten Sie eintragen?\r\n1: nur 1ser 2: nur 2er 3: nur 3er 4: nur 4er 5: nur 5er 6: nur 6er\r\n7: Dreierpasch 8: Viererpasch 9: Full-House (25P) 10: Kleine Strasse (30P) 11: Grosse Strasse (40P)\r\n12: 5X gleiche Augenzahl (50P) 13: Chance (Alle Augen zaehlen)\r\nBitte waehlen: ");
		
	}
	
	public String[] m1() {
		this.sc = new Scanner(System.in);
		this.setAbfrage("-1");
		while(this.getAbfrage() == "-1") {
			System.out.println(this.getAnzeigetext1());
			this.setAbfrage(sc.nextLine());
			if(Integer.parseInt(this.getAbfrage()) < 0 || Integer.parseInt(this.getAbfrage()) > 6) {
				System.out.println("Bitte geben Sie eine Ganzzahl zwischen 0 und 6 ein.");
				this.setAbfrage("-1");
			}else if(Integer.parseInt(this.getAbfrage()) == 0) {
				this.sc = null;
				this.setAusgabe(new String[1]);
				this.getAusgabe()[1] = this.getAbfrage();
				return this.getAusgabe();
			}
		}
		this.setAusgabe(new String[Integer.parseInt(this.getAbfrage())]);
		for(int i = 0; i < Integer.parseInt(this.getAbfrage()) - 1; i++) {
			System.out.println("Spieler " + (i+1) + ": " + this.anzeigetext2);
			this.getAusgabe()[i] = sc.nextLine();
		}
		this.sc = null;
		return this.getAusgabe();
	}
	
	public int m2() {
		this.sc = new Scanner(System.in);
		this.setAbfrage("-1");
		System.out.println(this.getAnzeigetext3());
		while(this.getAbfrage() == "-1") {
			System.out.println(this.getAnzeigetext1());
			this.setAbfrage(sc.nextLine());
			if(Integer.parseInt(this.getAbfrage()) < 0 || Integer.parseInt(this.getAbfrage()) > 13) {
				System.out.println("Bitte geben Sie eine Ganzzahl zwischen 0 und 13 ein.");
				this.setAbfrage("-1");
			}else if(Integer.parseInt(this.getAbfrage()) == 0) {
				this.sc = null;
				return 0;
			}
		}
		this.sc = null;
		return Integer.parseInt(this.getAbfrage());		
	}
	
	public int[] m3() {
		
		this.setAbfrage("-1");
		this.sc = new Scanner(System.in);
		while(this.getAbfrage() == "-1") {
			System.out.println("Welche Wuerfel moechten Sie behalten?\r\nGeben Sie die Nummern durch Kommata getrennt an: ");
			this.ausgabe = macheStringArray(this.sc.nextLine());
			if(this.ausgabe.length > 6) {
				System.out.println("Bitte geben Sie maximal 6 Zahlen an.");
				this.setAbfrage("-1");
				continue;				
			}
			
			
		}
	}
	
	private String[] macheStringArray(String str) {
		for(int i = 0; i > str.length(); i++) {
				if(str.charAt(i) == ' ') {
					str = str.replace(" ", "");
				}
		}
		return str.split(",");
	}

	
}
