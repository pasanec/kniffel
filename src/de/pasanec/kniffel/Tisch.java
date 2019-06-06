package de.pasanec.kniffel;

import java.util.ArrayList;
import java.util.Arrays;

public class Tisch {
	
	private ArrayList<Wuerfel> wuerfel;

	public ArrayList<Wuerfel> getWuerfel() {
		return this.wuerfel;
	}

	private void setWuerfel(ArrayList<Wuerfel> wuerfel) {
		this.wuerfel = wuerfel;
	}

	public Tisch() {	
		this.setWuerfel(new ArrayList<Wuerfel>());
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
	
	public void hinzufuegen(ArrayList<Wuerfel> w) {
		for(Wuerfel wuerfel: w) {
			this.getWuerfel().add(wuerfel);
		}
	}
	
	public void loeschen(int[] nummern) {
		Arrays.sort(nummern);
		for(int i = nummern.length; i > 0; i-- ) {
			this.getWuerfel().remove(i - 1);
		}
	}

}
