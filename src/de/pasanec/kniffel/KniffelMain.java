package de.pasanec.kniffel;

import java.util.HashMap;
import java.util.Iterator;

public class KniffelMain {
	
	public static void main(String[] args) {
		String listeOut = "";
//		int lCounter = 0;
		System.out.println("$$$$$$$$$$$$$$$$$$$");
		System.out.println("$  K N I F F E L  $");
		System.out.println("$$$$$$$$$$$$$$$$$$$\r\n\r\n");
		StartGame game = new StartGame();
		HashMap<String, Integer> liste = game.start();
		System.out.println("\r\n\r\n********Liste*********\r\n");
//		for(int i = liste.size() - 1; i <= 0; i--) {
//			lCounter++;
//			listeOut += lCounter + ". " + liste.get(i).toString() + "\r\n";
//		}
//		
		System.out.println(listeOut);
//		int counter = 1;
//		for(i = liste.size() - 1; i >= 0; i--) {
//			System.out.println(counter + liste.);
//			
//		}
		
		Iterator<String> itr = liste.keySet().iterator();
		Iterator<Integer> itv = liste.values().iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next() + ": " + itv.next());
			
		}

		
		
		
		

	}

}
