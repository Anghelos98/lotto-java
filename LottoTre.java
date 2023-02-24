/* Simulatore Estrazioni del Lotto da riga di comando, Versione 3.0
 * 20/02/2022
 * © Angelo Pastorini, 2022
 */

import java.util.ArrayList;
import java.lang.Math.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LottoTre{
	public static String[] listaRuoteEstrazione = {"Bari", "Cagliari", "Firenze", "Genova", "Milano", "Napoli", "Palermo", "Roma", "Torino", "Venezia", "Nazionale"};
	public static ArrayList<Integer> numeriBari = new ArrayList<Integer>();
 	public static ArrayList<Integer> numeriCagliari = new ArrayList<Integer>();
	public static ArrayList<Integer> numeriFirenze = new ArrayList<Integer>();
	public static ArrayList<Integer> numeriGenova = new ArrayList<Integer>();
	public static ArrayList<Integer> numeriMilano = new ArrayList<Integer>();
	public static ArrayList<Integer> numeriNapoli = new ArrayList<Integer>();
	public static ArrayList<Integer> numeriPalermo = new ArrayList<Integer>();
	public static ArrayList<Integer> numeriRoma = new ArrayList<Integer>();
	public static ArrayList<Integer> numeriTorino = new ArrayList<Integer>();
	public static ArrayList<Integer> numeriVenezia = new ArrayList<Integer>();
	public static ArrayList<Integer> numeriNazionale = new ArrayList<Integer>();
	public static String[] listaRuote = {"Bari", "Cagliari", "Firenze", "Genova", "Milano", "Napoli", "Palermo", "Roma", "Torino", "Venezia", "Nazionale", "Tutte"};
	public static ArrayList<Integer> numeriUtente = new ArrayList<Integer>();
	public static ArrayList<Integer> numeriVintiMax = new ArrayList<Integer>();
	public static int indiceRuotaScelta;
	public static int numeriVinti=0;
	public static int numeriGiocati;
	public static int max;
	public static double puntata;
	public static double vincita;
	public static final String RED_BOLD = "\033[1;91m";
	public static final String WHITE_BRIGHT = "\033[0;97m";
	public static final String WHITE_BOLD = "\033[1;97m";
	public static final String RESET = "\033[0m";  
	// Lunghezza di arrayDiArray = 11
	public static ArrayList<ArrayList> arrayDiArray = new ArrayList<ArrayList>();
	
	public static void creaArray(){
		arrayDiArray.add(numeriBari);
		arrayDiArray.add(numeriCagliari);
		arrayDiArray.add(numeriFirenze);
		arrayDiArray.add(numeriGenova);
		arrayDiArray.add(numeriMilano);
		arrayDiArray.add(numeriNapoli);
	    arrayDiArray.add(numeriPalermo);
	    arrayDiArray.add(numeriRoma);
	    arrayDiArray.add(numeriTorino);
	    arrayDiArray.add(numeriVenezia);
	    arrayDiArray.add(numeriNazionale);
	}
	
	
	public static void messaggioRuote(){
		System.out.println(WHITE_BRIGHT+ "Scegli la ruota su cui puntare i numeri." + RESET);
		System.out.println(WHITE_BRIGHT+ "Seleziona tra le ruote seguenti, digitando il numero corrispondente e premi il tasto invio." + RESET);
		System.out.println(WHITE_BOLD+ "1. Bari");
		System.out.println("2. Cagliari");
		System.out.println("3. Firenze");
		System.out.println("4. Genova");
		System.out.println("5. Milano");
		System.out.println("6. Napoli");
		System.out.println("7. Palermo");
		System.out.println("8. Roma");
		System.out.println("9. Torino");
		System.out.println("10. Venezia");
		System.out.println("11. Nazionale");
		System.out.println("12. Tutte" + RESET);
	}
	
	public static void messaggioNumeriDaPuntare(){
		System.out.println(WHITE_BRIGHT + "Quanti numeri vuoi giocare?" + RESET);
	}
	public static void numeriDaPuntare() throws InterruptedException{
		Scanner obj = new Scanner(System.in);
		try { numeriGiocati = obj.nextInt();
			  if(numeriGiocati<1 || numeriGiocati>10){
				System.out.println(WHITE_BRIGHT + "Giocata non valida. Puoi puntare da 1 a 10 numeri." + RESET);
				LottoTre.numeriDaPuntare();
			}
		}catch(Exception e){
				System.out.println(WHITE_BRIGHT+"Input non valido. Riprovare."+RESET);
				LottoTre.numeriDaPuntare();
			}
	}
	
	public static void messaggioSceltaNumeri(){
		System.out.println(" ");
		System.out.println(WHITE_BRIGHT + "Scegli i " + numeriGiocati + " numeri da giocare e premi il tasto invio." + RESET);
	}
	
	
	public static void sceltaNumeri() {
		Scanner obj = new Scanner(System.in);
		for (int i = 0; i < numeriGiocati; i++) {
				numeriUtente.add(i, obj.nextInt());
			}
		}


	
	
	public static void controlloNumeriScelti(){
		Scanner obj3 = new Scanner(System.in);
		Collections.sort(numeriUtente);
		for(int i=0; i<numeriUtente.size() - 1; i++){
			while(numeriUtente.get(i+1)==numeriUtente.get(i)){
				System.out.println(WHITE_BRIGHT +"Hai già scelto il numero " + RED_BOLD + numeriUtente.get(i) + WHITE_BRIGHT + ".");
				System.out.println("Per favore scegline un altro."+ RESET);
				numeriUtente.set(i, obj3.nextInt());
				Collections.sort(numeriUtente);
				LottoTre.controlloNumeriScelti();

			}
		}
		
		
		for(int i=0; i<numeriUtente.size(); i++){
			while(numeriUtente.get(i)<=0 || numeriUtente.get(i)>90){
				System.out.println(WHITE_BRIGHT+ "Il numero " + RED_BOLD + numeriUtente.get(i) + WHITE_BRIGHT + " non è valido.");
				System.out.println("Inserisci un numero compreso tra 1 e 90." + RESET);
				numeriUtente.set(i, obj3.nextInt());
				Collections.sort(numeriUtente);
				LottoTre.controlloNumeriScelti();
			}
		}
		System.out.println(" ");
	}

		
	public static void scegliRuota(){
		Scanner obj2 = new Scanner(System.in);
		try{indiceRuotaScelta = obj2.nextInt();
			if(indiceRuotaScelta<12){
				System.out.println(WHITE_BRIGHT + "Hai scelto la ruota di " + RED_BOLD + listaRuote[indiceRuotaScelta-1] + WHITE_BRIGHT + "." + RESET);
			}else if(indiceRuotaScelta==12){
				System.out.println(WHITE_BRIGHT + "Hai scelto " + RED_BOLD +"tutte le ruote " + WHITE_BRIGHT + "(esclusa la ruota Nazionale)." + RESET);
			}else if(indiceRuotaScelta<0 || indiceRuotaScelta>12){
				System.out.println(WHITE_BRIGHT + "Scelta non valida. Riprovare." + RESET);
				LottoTre.scegliRuota();
			}
		}catch(Exception e){
			System.out.println(WHITE_BRIGHT + "Input non valido. Riprovare." + RESET);
			LottoTre.scegliRuota();
		}
	}

	public static void messaggioSceltaPuntata() {
		System.out.println(WHITE_BRIGHT + "Quanto vuoi puntare?" + RESET);
	}

	public static void sceltaPuntata() throws InterruptedException{
		Scanner obj = new Scanner(System.in);
		try {
			puntata = obj.nextDouble();
		}catch(Exception e) {
			Thread.sleep(500);
			System.out.println(WHITE_BRIGHT + "Input non valido. Riprovare." + RESET);
			System.out.println(" ");
			LottoTre.sceltaPuntata();
		}
		if(puntata<0){
			System.out.println(WHITE_BRIGHT + "Inserisci un numero valido per favore:" + RESET);
			LottoTre.sceltaPuntata();
		}
	}
	
	public static void messaggioEuroGiocati(){
		System.out.println(" ");
		System.out.println(WHITE_BRIGHT + "Hai puntato " + RED_BOLD +  puntata + " euro" + WHITE_BRIGHT +" su questi numeri:" + RESET);
		Collections.sort(numeriUtente);
		System.out.println(WHITE_BOLD + numeriUtente);
	}
		
	public static void ricapitolazioneGiocata(){
		if(indiceRuotaScelta<11){
			System.out.println(" ");
			System.out.println(WHITE_BRIGHT + "Ecco la tua giocata:" + RESET);
			System.out.println(" ");
			System.out.println(WHITE_BOLD + "Ruota di " + RED_BOLD + listaRuoteEstrazione[indiceRuotaScelta-1] + WHITE_BOLD + "." + RESET);
			System.out.println(WHITE_BOLD + "Numeri puntati:   " + numeriUtente + RESET);
			System.out.println(WHITE_BOLD + "Giocata: " + RED_BOLD + puntata + WHITE_BOLD + " euro.");
		}else if(indiceRuotaScelta==11){
			System.out.println(" ");
			System.out.println(WHITE_BRIGHT + "Ecco la tua giocata:" + RESET);
			System.out.println(" ");
			System.out.println(WHITE_BOLD + "Ruota di " + RED_BOLD + listaRuoteEstrazione[indiceRuotaScelta-1] + WHITE_BOLD + "." + RESET);
			System.out.println(WHITE_BOLD + "Numeri puntati:   " + numeriUtente + RESET);
			System.out.println(WHITE_BOLD + "Giocata: " + RED_BOLD + puntata + WHITE_BOLD + " euro.");
		}else if(indiceRuotaScelta==12){
			System.out.println(" ");
			System.out.println(WHITE_BRIGHT + "Ecco la tua giocata:" + RESET);
			System.out.println(" ");
			System.out.println(RED_BOLD + "Tutte le ruote" + WHITE_BRIGHT + " (esclusa la ruota Nazionale)." + RESET);
			System.out.println(WHITE_BOLD + "Numeri puntati:   " + numeriUtente + RESET);
			System.out.println(WHITE_BOLD + "Giocata: " + RED_BOLD + puntata + WHITE_BOLD + " euro.");
		}
	}
	
	
	public static void estrazione(){
		for(int i=0; i<arrayDiArray.size(); i++){
			for(int x=0; x<5; x++){
				arrayDiArray.get(i).add((int)(Math.random()*89)+1);
				Collections.sort(arrayDiArray.get(i));
			}
		}
	}
	
	
	public static void messaggioEstrazione() throws InterruptedException{
		System.out.println(WHITE_BRIGHT + "Di seguito, i numeri estratti sulle rispettive ruote." + RESET);
		for(int i=0; i<arrayDiArray.size() -1; i++){
			System.out.println(WHITE_BRIGHT + "Ruota di " + RED_BOLD + listaRuoteEstrazione[i] + WHITE_BRIGHT + "." + RESET);
			System.out.println(WHITE_BOLD + arrayDiArray.get(i) + RESET);
			System.out.println(" ");
			Thread.sleep(1500);
		}
		
		System.out.println(WHITE_BRIGHT + "Ruota " + RED_BOLD + listaRuoteEstrazione[10] + WHITE_BRIGHT + "." + RESET);
		System.out.println(WHITE_BOLD + arrayDiArray.get(10));
		System.out.println(" ");
		Thread.sleep(1500);
    }
	
	
	public static void controlloNumeriEstratti(){
		for(ArrayList<Integer> array : arrayDiArray){
			Collections.sort(array);
			for(int i=0; i<array.size() - 1; i++){
				while(array.get(i+1)==array.get(i)){
				    array.set(i, (int)(Math.random()*89)+1);
				    Collections.sort(array);
				    LottoTre.controlloNumeriEstratti();
				}
			}
		}
	}
	
					
	public static void confrontoNumeri(){
	if(indiceRuotaScelta==12){
		for(int y=0; y<10; y++){
			for(int x=0; x<5; x++){
				for(int i=0; i<numeriUtente.size(); i++){
					if(numeriUtente.get(i)==arrayDiArray.get(y).get(x)){
						numeriVinti++;
					}
				}
			 }
			 numeriVintiMax.add(numeriVinti);
			 numeriVinti=0;
		  }
		 max=Collections.max(numeriVintiMax);
	   }else if(indiceRuotaScelta<12){
		for(int i=0; i<5; i++){
			for(int x=0; x<numeriUtente.size(); x++){
				if(numeriUtente.get(x)==arrayDiArray.get(indiceRuotaScelta - 1).get(i)){
					numeriVinti++;
				}
			}
		   numeriVintiMax.add(numeriVinti);
		}
		max=Collections.max(numeriVintiMax);
	}
}
	
	
	public static void calcoloVincita(){
			switch(max){
			case 0:
				System.out.println(WHITE_BOLD + "Hai indovinato 0 numeri. Ritenta, sarai più fortunato!" + RESET);
				vincita=(puntata*0);
				break;
			case 1:
				if(indiceRuotaScelta==12){
					System.out.println(WHITE_BOLD + "Hai indovinato 1 numero sulla ruota di " + listaRuote[numeriVintiMax.indexOf(max)] +", ma avendo puntato su tutte le ruote non hai vinto.");
					System.out.println("Ritenta, sarai più fortunato!" + RESET);
					vincita=(puntata*0);
				}else{
				System.out.println(WHITE_BOLD + "Non male, hai indovinato 1 numero. Hai fatto ESTRATTO" + RESET);
				switch(numeriGiocati){
					case 1:
						vincita=(puntata*11.23);
						break;
					case 2:
						vincita=(puntata*5.62);
						break;
					case 3:
						vincita=(puntata*3.74);
						break;
					case 4:
						vincita=(puntata*2.81);
						break;
					case 5:
						vincita=(puntata*2.25);
						break;
					case 6:
						vincita=(puntata*1.87);
						break;
					case 7:
						vincita=(puntata*1.60);
						break;
					case 8:
						vincita=(puntata*1.40);
						break;
					case 9:
					    vincita=(puntata*1.25);
					    break;
					case 10:
						vincita=(puntata*1.12);
						break;
					}
				}
				break;
				
			case 2:
				System.out.println(WHITE_BOLD + "Complimenti! Hai fatto AMBO!" + RESET);
				switch(numeriGiocati){
					case 2:
						System.out.println(WHITE_BOLD + "... e per di più AMBO SECCO!" + RESET);
						vincita=(puntata*250.00);
						break;
					case 3:
						vincita=(puntata*83.33);
						break;
					case 4:
						vincita=(puntata*41.67);
						break;
					case 5:
						vincita=(puntata*25.00);
						break;
					case 6:
						vincita=(puntata*16.67);
						break;
					case 7:
						vincita=(puntata*11.90);
						break;
					case 8:
						vincita=(puntata*8.93);
						break;
					case 9:
						vincita=(puntata*6.94);
						break;
					case 10:
						vincita=(puntata*5.56);
						break;
					}
				break;
				
			case 3:
				System.out.println(WHITE_BOLD + "Complimenti! Hai fatto " + RED_BOLD +"TERNO!" + RESET);
				switch(numeriGiocati){
					case 3:
						System.out.println(WHITE_BOLD + "... e per di più " + RED_BOLD + "TERNO SECCO!" + RESET);
						vincita=(puntata*4500.00);
						break;
					case 4:
						vincita=(puntata*1125.00);
						break;
					case 5:
				        vincita=(puntata*450.00);
				        break;
				    case 6:
						vincita=(puntata*225.00);
						break;
					case 7:
						vincita=(puntata*128.57);
						break;
					case 8:
						vincita=(puntata*80.36);
						break;
					case 9:
						vincita=(puntata*53.57);
						break;
					case 10:
						vincita=(puntata*37.50);
						break;
					}
				break;
				
			case 4:
				System.out.println(WHITE_BOLD + "Sei davvero fortunato! Hai fatto " + RED_BOLD +"QUATERNA!" + RESET);
				switch(numeriGiocati){
					case 4:
						System.out.println(WHITE_BOLD + "... e per di più " + RED_BOLD +"QUATERNA SECCA!" + RESET);
						vincita=(puntata*120000.00);
						break;
					case 5:
						vincita=(puntata*24000.00);
						break;
					case 6:
						vincita=(puntata*8000.00);
						break;
					case 7:
						vincita=(puntata*3248.57);
						break;
					case 8:
						vincita=(puntata*1714.29);
						break;
					case 9:
						vincita=(puntata*952.38);
						break;
					case 10:
						vincita=(puntata*571.43);
						break;
					}
				break;
				 
			case 5:
				System.out.println(WHITE_BOLD + "COMPLIMENTI!!! HAI FATTO " + RED_BOLD +"CINQUINA!!! " + WHITE_BOLD + "FORTUNELLO CHE NON SEI ALTRO!!!" + RESET);
				switch(numeriGiocati){
					case 5:
						System.out.println(WHITE_BOLD + "... e per di più " + RED_BOLD + "CINQUINA SECCA!" + RESET);
						System.out.println(" È più probabile trovare la Papamobile in un concessionario Porsche...");
						System.out.println("... oppure che io sia un leprechaun viola che vive nel cappello della regina Elisabetta II");
						vincita=(puntata*6000000.00);
						break;
					case 6:
						vincita=(puntata*1000000.00);
						break;
					case 7:
						vincita=(puntata*285714.29);
						break;
					case 8:
						vincita=(puntata*107142.86);
						break;
					case 9:
						vincita=(puntata*47619.05);
						break;
					case 10:
						vincita=(puntata*23809.52);
						break;
					}
				break;
			}
			
		if(indiceRuotaScelta==12){
			if(max==0){
					System.out.println("Non hai vincite su nessuna delle ruote.");
			}else if(max>0){
					 vincita=(vincita/10);
					}System.out.println(WHITE_BRIGHT + "La tua vincita sulla ruota di " + RED_BOLD + listaRuote[numeriVintiMax.indexOf(max)] + WHITE_BRIGHT + " è di " + RED_BOLD + (vincita) + WHITE_BRIGHT + " euro." + RESET);
		}else if(indiceRuotaScelta <12){
			System.out.println(WHITE_BRIGHT + "La tua vincita sulla ruota di " + RED_BOLD + listaRuote[indiceRuotaScelta -1] + WHITE_BRIGHT + " è di " + RED_BOLD + vincita + WHITE_BRIGHT + " euro." + RESET);
		}
	}

				
	
	public static void calcoloVincitaNetta(){
		double tassa = (vincita/100)*8;
		double vincitaNetta = (vincita -tassa);
		System.out.println(" ");
		System.out.println(WHITE_BRIGHT + "La tua vincita, al netto dell'8% di tasse, è di " + RED_BOLD + vincitaNetta +  WHITE_BRIGHT + " euro." + RESET) ;
	} 
		
		
	public static void main(String[] args) throws InterruptedException{
		System.out.println(WHITE_BOLD + "Benvenuto nel Simulatore di Estrazioni del Lotto da riga di comando" + RESET);
		System.out.println("(Versione 3.0. © Angelo Pastorini, 2022)");
		Thread.sleep(2000);
		System.out.println(" "); 
		System.out.println(" ");
		LottoTre.creaArray();
		LottoTre.messaggioNumeriDaPuntare();
		LottoTre.numeriDaPuntare();
		LottoTre.messaggioSceltaNumeri();
 		LottoTre.sceltaNumeri();
		LottoTre.controlloNumeriScelti();
		LottoTre.messaggioRuote();
		LottoTre.scegliRuota();
		LottoTre.messaggioSceltaPuntata();
		LottoTre.sceltaPuntata();
		LottoTre.messaggioEuroGiocati();
		Thread.sleep(800);
		LottoTre.ricapitolazioneGiocata();
		Thread.sleep(1000);
		System.out.println(" ");
		System.out.println(WHITE_BRIGHT + "Estrazione in corso. Attendi e incrocia le dita!" + RESET);
		System.out.println(" ");
		Thread.sleep(3000);
		LottoTre.estrazione();
		LottoTre.controlloNumeriEstratti();
		LottoTre.confrontoNumeri();
		LottoTre.messaggioEstrazione();
		LottoTre.calcoloVincita();
		LottoTre.calcoloVincitaNetta();
	}
}
