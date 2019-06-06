package de.pasanec.kniffel;

public class Wuerfel {
	private int zahl;

	public int getZahl() {
		return this.zahl;
	}

	private void setZahl(int zahl) {
		this.zahl = zahl;
	}
	
	public Wuerfel() {
		this(6);
	}
	
	public Wuerfel(int seiten) {
		this.setZahl(wuerfeln(seiten));
	}
	
	private int wuerfeln(int seiten){
		return (int)(Math.random() * seiten + 1);
	}
	
	@Override
	public String toString() {
		String out = "";
		out += "Klasse: " + this.getClass().getSimpleName() + "\r\n";
		out += "Zahl: " + this.getZahl() + "\r\n";
		return out;
	}
	
}
