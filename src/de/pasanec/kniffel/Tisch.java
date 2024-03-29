package de.pasanec.kniffel;

import java.util.ArrayList;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

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
		if(nummern.length == 0) {
			this.getWuerfel().clear();
			return;
		}
		Arrays.sort(nummern);
		ArrayList<Wuerfel> temp = new ArrayList<Wuerfel>();
		for(int n: nummern) {
			temp.add(this.getWuerfel().get(n - 1));
		}
		this.getWuerfel().clear();
		for(int i = 0; i < temp.size(); i++) {
			this.getWuerfel().add(temp.get(i));
		}
	}
	
	public String zeige() {
		String out = "";
		out += "Werte:   ";
		for(Wuerfel w : this.getWuerfel()) {
			out += w.getZahl() + " ";
		}
		out += "\r\nWuerfel: ";
		for(int i = 0; i < this.getWuerfel().size(); i++) {
			out += (i+1) + " ";
		}
		out += "\r\n";
		return out;		
	}
	
	public String zeigeSortiert() {
		int[] temp = new int[this.getWuerfel().size()];
		String out = "\r\n";
		out += "Werte:   ";
		int i = 0;
		for(Wuerfel w : this.getWuerfel()) {
			temp[i] = w.getZahl();
			i++;
		}
		Arrays.sort(temp);
		for(int w : temp) {
			out += w + " ";
		}		
		out += "(sortiert)\r\n";
		return out;		
	}

}
