package org.lessons.java.gestoreeventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//1) Creare un evento test
		Evento nuovoEvento = new Evento("Rock Festival", LocalDate.of(2024, Month.DECEMBER, 13), 20);
		
		System.out.println("Prossimo Evento: " + nuovoEvento.toString() + ", numero totale di posti disponibili "
							+ nuovoEvento.getPostiTotali() + ".");
		
		//2) Chiedere all'utente quante prenotazioni vuole fare
		Scanner scan = new Scanner(System.in);
		System.out.println("Quante posti vuoi prenotare? ");
		int numeroPosti = scan.nextInt();
		
			/* altro modo disponibile per la verifica del numero di posti prenotabili, che ci consente di richiedere in loop
			// all'utente il numero di posti fino a quando non la smette di commette un errore.
			int numeroPosti = 0;
			boolean inputValido = false;
			
			while(!inputValido) {
				System.out.println("Quante posti vuoi prenotare? ");
				numeroPosti = scan.nextInt();
				
				if (numeroPosti <= 0) {
	                System.out.println("Il numero di prenotazioni deve essere positivo. Riprova.");
	            } else if (numeroPosti > (nuovoEvento.getPostiTotali() - nuovoEvento.getPostiPrenotati())) {
	                System.out.println("Non ci sono posti disponibili per il numero richiesto di prenotazioni. Riprova.");
	            } else {
	                inputValido = true;
	            }
			} */
		
		//Creiamo un ciclo for per inserire il numero di prenotazioni dell'utente
		for (int i = 0; i < numeroPosti; i++) {
			nuovoEvento.prenotazionePosti();
		}
		
		//3) Stampa posti prenotati e posti disponibili
		System.out.println("Posti prenotati: " + nuovoEvento.getPostiPrenotati());
		System.out.println("Posti disponibili: " + nuovoEvento.postiDisponibili());
		
		//4) Provare ad effetturare una disdetta
		System.out.println("Quante posti vuoi disdire? ");
		int numeroPostiDisdetta = scan.nextInt();
		
			/* altro modo disponibile per la verifica del numero di posti da disdire, che ci consente di richiedere in loop
			//all'utente il numero di posti fino a quando non la smette di commette un errore.
			int numeroPostiDisdetta = 0;
			boolean inputValidoDisdetta = false;
			
			while(!inputValidoDisdetta) {
				System.out.println("Quante posti vuoi disdire? ");
				numeroPostiDisdetta = scan.nextInt();
				
				if (numeroPostiDisdetta <= 0) {
	                System.out.println("Il numero di posti da disdire deve essere positivo. Riprova.");
	            } else if (numeroPostiDisdetta > nuovoEvento.getPostiPrenotati()) {
	                System.out.println("Il numero di disdette non può essere maggiore al numero di prenotazioni effettuate. Riprova.");
	            } else {
	            	inputValidoDisdetta = true;
	            }
			} */
		
		//Creiamo un ciclo for per inserire il numero di prenotazioni dell'utente
		for (int i = 0; i < numeroPostiDisdetta; i++) {
			nuovoEvento.cancellazionePosti();
		}
		
		//5) Stampa posti prenotati e posti disponibili
		System.out.println("Posti prenotati: " + nuovoEvento.getPostiPrenotati());
		System.out.println("Posti disponibili: " + nuovoEvento.postiDisponibili());
		
		
		//STEP 3 - Test funzionamento classe Concerto
		Concerto nuovoConcerto = new Concerto("Afro Raduno", LocalDate.of(2025, Month.APRIL, 20), LocalTime.of(20, 45), 19.987, 100);
		System.out.println(nuovoConcerto.toString());
	}
}
