package org.lessons.java.gestoreeventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	//Attributi con le proprietà dell'evento
	private String titoloEvento;
	private LocalDate dataEvento;
	private int postiTotali;
	private int postiPrenotati;
	
	//Costruttore che richieda parametri e inizializzi a 0 posti prenotati
	public Evento(String titoloEvento, LocalDate dataEvento, int postiTotali) {
		if (dataEvento.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data insertia è già passata, inserisci una nuova data futura.");
        }
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }
		this.titoloEvento = titoloEvento;
		this.dataEvento = dataEvento;
		this.postiTotali = postiTotali;
		this.postiPrenotati = 0;
	}

	//Metodi Getter e Setter
	public String getTitoloEvento() {
		return titoloEvento;
	}

	public void setTitoloEvento(String titoloEvento) {
		this.titoloEvento = titoloEvento;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	//Metodo per posti disponibili
		public int postiDisponibili() {
			return postiTotali - postiPrenotati;
		}
	
	//Metodo per la Prenotazione dell'evento
	public void prenotazionePosti() {
		if(LocalDate.now().isAfter(dataEvento)) {
			System.out.println("L'evento è già passato.");
			return;
		}else if (postiPrenotati >= postiTotali) {
			throw new IllegalArgumentException("Numero di posti non disponibile");
		}else {
			postiPrenotati++;
		}
	}
	
	//Metodo per la Cancellazione dell'evento
	public void cancellazionePosti() {
		if(LocalDate.now().isAfter(dataEvento)) {
			System.out.println("L'evento è già passato.");
			return;
		}else if (postiPrenotati <= 0) {
			throw new IllegalArgumentException("Errore. Il numero di disdette non può essere maggiore al numero di prenotazioni effettuate.");
		}else {
			postiPrenotati--;
		}
	}
	
	//Overrade del metodo ToString
	@Override
	public String toString() {
		//definisco il formato della data
		DateTimeFormatter dataFormattata = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//ritorno il ToString data formattata - titolo
		return dataEvento.format(dataFormattata) + " - " + titoloEvento;
	}
}
