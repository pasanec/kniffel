package de.pasanec.kniffel;

public class Wuerfel {
	private int zahl;

	public int getZahl() {
		return zahl;
	}

	private void setZahl(int zahl) {
		this.zahl = zahl;
	}
	
	public Wuerfel() {
		this.setZahl(wuerfeln());
	}
	
	private int wuerfeln(){
		return (int)(Math.random() * 6 + 1);
	}
	
	@Override
	public String toString() {
		String out = "";
		out += "Klasse: " + this.getClass().getSimpleName() + "\r\n";
		out += "Zahl: " + this.getZahl() + "\r\n";
		return out;
	}
	
}
