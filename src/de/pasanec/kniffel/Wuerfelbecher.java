package de.pasanec.kniffel;

import java.util.ArrayList;

public class Wuerfelbecher {
	
	private ArrayList<Wuerfel> wuerfel;

	public ArrayList<Wuerfel> getWuerfel() {
		return wuerfel;
	}

	private void setWuerfel(int anzahl) {
		for(int i = 0 ; i < anzahl ; i++) {
			this.wuerfel.add(new Wuerfel());
		}
	}

	public Wuerfelbecher(int anzahl) {	
		this.setWuerfel(anzahl);
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

}
