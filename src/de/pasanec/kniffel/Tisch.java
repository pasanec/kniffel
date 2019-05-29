package de.pasanec.kniffel;

import java.util.ArrayList;

public class Tisch {
	
	private ArrayList<Wuerfel> wuerfel;

	public ArrayList<Wuerfel> getWuerfel() {
		return wuerfel;
	}

	private void setWuerfel(ArrayList<Wuerfel> wuerfel) {
		this.wuerfel = wuerfel;
	}

	public Tisch(ArrayList<Wuerfel> wuerfel) {	
		this.setWuerfel(wuerfel);
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
