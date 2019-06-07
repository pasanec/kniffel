package de.pasanec.kniffel;

import java.util.ArrayList;

public class Wuerfelbecher {
	
	private ArrayList<Wuerfel> wuerfel;

	public ArrayList<Wuerfel> getWuerfel() {
		return this.wuerfel;
	}
	
	// benutzen
	public void setWuerfel(int anzahl) {
		this.wuerfel = new ArrayList<Wuerfel>();
		for(int i = 0 ; i < anzahl ; i++) {
			this.wuerfel.add(new Wuerfel());
		}
	}

	public Wuerfelbecher() {	
		this.setWuerfel(5);
	}
	
	@Override
	public String toString() {
		String out = "";
		out += "Klasse: " + this.getClass().getSimpleName() + "\r\n";
		out += "Werte: ";
		for(Wuerfel w : this.getWuerfel()) {
			out += w.getZahl() + " ";
		}
		out += "\r\n";
		return out;
	}
//	Nicht mehr benötigt (siehe Tisch)
//	public String zeige() {
//		String out = "";
//		out += "Werte:   ";
//		for(Wuerfel w : this.getWuerfel()) {
//			out += w.getZahl() + " ";
//		}
//		out += "\r\nWuerfel: ";
//		for(int i = 0; i < this.getWuerfel().size(); i++) {
//			out += (i+1) + " ";
//		}
//		out += "\r\n";
//		return out;		
//	}

}
