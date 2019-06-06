package de.pasanec.kniffel;

import java.util.Scanner;

public class GameMenu {
	private String anzeigetext1;
	private String anzeigetext2;
	private String anzeigetext3;
	private String abfrage;
	private String[] ausgabe;
	private Scanner sc;
	private final int[] ALLEW = {1,2,3,4,5}; // für m3()
	
	
	private String getAnzeigetext1() {
		return this.anzeigetext1;
	}
	private void setAnzeigetext1(String anzeigetext1) {
		this.anzeigetext1 = anzeigetext1;
	}
	private String getAnzeigetext2() {
		return this.anzeigetext2;
	}
	private void setAnzeigetext2(String anzeigetext2) {
		this.anzeigetext2 = anzeigetext2;
	}
	private String getAnzeigetext3() {
		return this.anzeigetext3;
	}
	private void setAnzeigetext3(String anzeigetext3) {
		this.anzeigetext3 = anzeigetext3;
	}
	private String getAbfrage() {
		return this.abfrage;
	}
	private void setAbfrage(String abfrage) {
		this.abfrage = abfrage;
	}	
	private String[] getAusgabe() {
		return this.ausgabe;
	}
	private void setAusgabe(String[] ausgabe) {
		this.ausgabe = ausgabe;
	}	

	public GameMenu() {
		this.setAbfrage("-1");
		this.setAnzeigetext1("Wie viele Personen möchten mitspielen? Eingabe: ");
		this.setAnzeigetext2("Geben Sie Ihren Namen ein: ");
		this.setAnzeigetext3("0: Abbrechen\r\nWelches Feld moechten Sie eintragen?\r\n1: nur 1ser 2: nur 2er 3: nur 3er 4: nur 4er 5: nur 5er 6: nur 6er\r\n7: Dreierpasch 8: Viererpasch 9: Full-House (25P) 10: Kleine Strasse (30P) 11: Grosse Strasse (40P)\r\n12: 5X gleiche Augenzahl (50P) 13: Chance (Alle Augen zaehlen)\r\nBitte waehlen: ");
		
	}
	// Robocop
	public int m0() {
		this.sc = new Scanner(System.in);
		System.out.println("Moechten Sie gegen Robocop spielen? (J/n): ");
		this.setAbfrage(sc.nextLine());
		if(this.getAbfrage().toLowerCase() == "n") {
			return 0;
		}
		return 1;		
	}
	
	// Anzahl Personen
	public String[] m1() {
		this.sc = new Scanner(System.in);
		this.setAbfrage("-1");
		while(this.getAbfrage() == "-1") {
			System.out.println(this.getAnzeigetext1());
			this.setAbfrage(sc.nextLine());
			if(Integer.parseInt(this.getAbfrage()) < 1 || Integer.parseInt(this.getAbfrage()) > 6) {
				System.out.println("Bitte geben Sie eine Ganzzahl zwischen 1 und 6 ein.");
				this.setAbfrage("-1");
			}
		}
		// Namen eingeben
		this.setAusgabe(new String[Integer.parseInt(this.getAbfrage())]);
		for(int i = 0; i < Integer.parseInt(this.getAbfrage()); i++) {
			System.out.println("Spieler " + (i+1) + ": " + this.getAnzeigetext2());
			this.getAusgabe()[i] = sc.nextLine() + "(Spieler" + (i+1) + ")";
		}
		this.sc = null;
		return this.getAusgabe();
	}
	
	
	// Zu behaltende Würfel
	public int[] m2() {		
		this.setAbfrage("-1");
		this.sc = new Scanner(System.in);
		while(this.getAbfrage() == "-1") {
			System.out.println("Welche Wuerfel moechten Sie behalten? ([ENTER] = alle behalten)\r\nGeben Sie die Nummern durch Kommata getrennt an: ");
			this.abfrage = this.sc.nextLine();
			if(this.getAbfrage().length() == 0) {
				return ALLEW;
			}
			this.ausgabe = macheStringArray(abfrage);
			if(this.getAusgabe().length > 5 /*|| testeAufDuplikateInArray(this.getAusgabe()) == 1*/) {
				System.out.println("Bitte geben Sie maximal 5 individuelle Zahlen an.");
				this.setAbfrage("-1");
				continue;				
			}
			for(int wert: strArraytointArray(this.getAusgabe())) {
				if(wert < 1 || wert > 5) {
					System.out.println("Geben Sie bitte nur Werte zwischen 1 und 5 an!");
					this.setAbfrage("-1");
					break;
				}
			}
		}
		return strArraytointArray(ausgabe);
	}
	
	// Feld im Block auswählen
	public int m3() {
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
				// Aufrufende Funktion muss auf 0 prüfen
				return 0;
			}
		}
		this.sc = null;
		return Integer.parseInt(this.getAbfrage());		
	}

	
	
	// Hilfsfunktionen
	private String[] macheStringArray(String str) {
		for(int i = 0; i > str.length(); i++) {
				if(str.charAt(i) == ' ') {
					str = str.replace(" ", "");
				}
		}
		return str.split(",");
	}
	
	private int testeAufDuplikateInArray(String[] ausgabe) {
		int duplikat = 0;
		for(int i = 0; i < ausgabe.length; i++) {
			for (int j = 0; j < ausgabe.length; j++) {
				if(ausgabe[i] == ausgabe[j]) {
					duplikat++;
				}
			}
			if(duplikat > 1) {
				return 1;
			}
		}
		return 0;
	}
	
	private int[] strArraytointArray(String[] ausgabe) {
		int[] intarr = new int[ausgabe.length];
		for(int i = 0; i < intarr.length; i++) {
			intarr[i] = Integer.parseInt(ausgabe[i]);
		}
		return intarr;
	}
	
}
