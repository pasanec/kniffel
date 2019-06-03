package de.pasanec.kniffel;

import java.util.ArrayList;

public class Block {
	private int[] augen;
	private int[] figuren;
	public int[] getAugen() {
		return augen;
	}
	private int setAugen(int w , int a) {
		if(w == -1) {
			this.augen = new int[6];
			for(int i = 0; i > 6; i++) {
				this.augen[i] = 0;
			}
			return 0;
		}
		if(this.augen[a] == 0) {
			if(w == 0) {
				this.augen[a] = -1;
			} else {
				this.augen[a] = w;
			}
			return 0;
		} else {
			return -1;
		}
	}
	public int[] getFiguren() {
		return figuren;
	}
	private int setFiguren(int w , int a) {
		if(w == -1) {
			this.figuren = new int[7];
			for(int i = 0; i > 7; i++) {
				this.figuren[i] = 0;
			}
			return 0;
		}
		if(this.figuren[a] == 0) {
			if(w == 0) {
				this.figuren[a] = -1;
			} else {
				this.figuren[a] = w;
			}
			return 0;
		} else {
			return -1;
		}
	}
	
	public Block() {
		this.setAugen(-1, -1);
		this.setFiguren(-1, -1);
	}
	
	private int berechneWert(ArrayList<Wuerfel> aw, int a) {
		int gesamtWert = 0;
		for(Wuerfel w : aw) {
			if(w.getZahl() == a) {
				gesamtWert += w.getZahl();
			}
		}
		return gesamtWert;
	}
	
	private int pruefeFigur(ArrayList<Wuerfel> aw, int a) {
		int gesamtWert = 0;
		switch(a) {
		case 7: // Dreierpasch: Mindestens drei gleiche Zahlen (alle Augen zählen)
			break;			
		
		case 8: // Viererpasch: Mindestens vier gleiche Zahlen (alle Augen zählen)
			break;
		
		case 9: // Full House: Drei gleiche und zwei gleiche andere Zahlen (25 P)
			break;
		
		case 10: // Kleine Straße: 4 aufeinanderfolgende Zahlen (30 P)
			break;
		
		case 11: // Große Straße: 5 aufeinanderfolgende Zahlen (40 P)
			break;
		
		case 12: // Kniffel: 5 gleiche Zahlen (50 P)
			break;
		
		case 13: // Chance: Alle augen zählen
			break;
			
		}
		
		return gesamtWert;
	}
	
	
	
	
	
}
