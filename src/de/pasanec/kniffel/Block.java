package de.pasanec.kniffel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
	
	private int addiere(ArrayList<Wuerfel> aw) {
		int gw = 0;
		for(Wuerfel w : aw) {
			gw += w.getZahl();
		}
		return gw;
	}
	
	private int pruefeFigur(ArrayList<Wuerfel> aw, int a) {
		int sw = 1;
		int az = 0;
		int gesamtWert = 0;
		int[] zarray = {0,0,0,0,0,0};
		switch(a) {
		case 7: // Dreierpasch: Mindestens drei gleiche Zahlen (alle Augen zählen)
			az = 3;
			gesamtWert += addiere(aw);
			break;			
		
		case 8: // Viererpasch: Mindestens vier gleiche Zahlen (alle Augen zählen)
			az = 4;
			gesamtWert += addiere(aw);
			break;
		
		case 9: // Full House: Drei gleiche und zwei gleiche andere Zahlen (25 P)
			sw = 0;
			for(int i = 1; i <= 6; i++) {
				for(Wuerfel w : aw) {
					if(w.getZahl() == i) {
						zarray[i - 1]++;
					}
				}
			}
			for(int za: zarray) {
				if(za == 2) {
					for(int zz: zarray) {
						if(zz == 3) {
							gesamtWert = 25;
							break;
						}						
					}					
				}
			}
			return 0;
		
		case 10: // Kleine Straße: 4 aufeinanderfolgende Zahlen (30 P)
			sw = 2;
			az = 4;
			gesamtWert = 30;
			break;
		
		case 11: // Große Straße: 5 aufeinanderfolgende Zahlen (40 P)
			sw = 2;
			az = 5;
			gesamtWert = 40;
			break;
		
		case 12: // Kniffel: 5 gleiche Zahlen (50 P)
			az = 5;
			gesamtWert = 50;
			break;
		
		case 13: // Chance: Alle augen zählen			
			return addiere(aw);
			
		}
		// Switch1 Ende
		
		switch(sw) {
		case 1:
			for(int i = 1; i <= 6; i++) {
				for(Wuerfel w : aw) {
					if(w.getZahl() == i) {
						zarray[i - 1]++;
					}
				}
			}
			for(int za: zarray) {
				if(za >= az) {
					break;
				}
			}
			gesamtWert = 0;
			break;
		case 2:
			int counter = 0;
			for(Wuerfel w : aw) {
				zarray[counter] = w.getZahl();
				counter++;
			}
			counter = 0;
			Arrays.parallelSort(zarray);
			for(int i = 0; i < 5; i++) {
				if(zarray[i]+1 == zarray[i+1]) {
					counter++;
				}else {
					counter = 0;
				}
			}
			if(counter >= az) {
				break;
			}
			gesamtWert = 0;
			break;
		}		
		
		return gesamtWert;
	}
	
	
	
	
	
	
	
}
