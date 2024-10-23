package org.lessons.java.gestoreeventi;

import java.time.LocalDate;

public class Evento {

	//Attributi con le proprietà dell'evento
	private String titoloEvento;
	private LocalDate dataEvento;
	private int postiTotali;
	private int postiPrenotati;
	
	//Costruttore che richieda parametri e inizializzi a 0 posti prenotati
	public Evento(String titoloEvento, LocalDate dataEvento, int postiTotali) {
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
	
	
	
}
