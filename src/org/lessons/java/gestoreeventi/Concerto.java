package org.lessons.java.gestoreeventi;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

	//ATTRIBUTI CONCERTO
	private LocalTime oraEvento;
	private double prezzoEvento;
	
	
	//COSTRUTTORE CONCERTO
	public Concerto(String titoloEvento, LocalDate dataEvento, LocalTime oraEvento, double prezzoEvento, int postiTotali) {
		super(titoloEvento, dataEvento, postiTotali);
		this.oraEvento = oraEvento;
		this.prezzoEvento = prezzoEvento;
	}


	//GETTER E SETTER
	public LocalTime getOraEvento() {
		return oraEvento;
	}


	public void setOraEvento(LocalTime oraEvento) {
		this.oraEvento = oraEvento;
	}


	public double getPrezzoEvento() {
		return prezzoEvento;
	}


	public void setPrezzoEvento(double prezzoEvento) {
		this.prezzoEvento = prezzoEvento;
	}

	
	//METODO DATA E ORA FORMATTATA
	public String getDataOraFormattata() {
        LocalDateTime dataOraEvento = LocalDateTime.of(dataEvento, oraEvento);
        DateTimeFormatter dataOraFormattate = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataOraEvento.format(dataOraFormattate);
    }
	
	
	//METODO PREZZO FORMATTATO
	public String getPrezzoFormattato() {
        DecimalFormat prezzoFormattato = new DecimalFormat("#.00");
        return prezzoFormattato.format(prezzoEvento) + " €";
	}
	
	
	//OVVERIDE METODO TO STRING
	@Override
    public String toString() {
        return getDataOraFormattata() + " - " + titoloEvento + " - " + getPrezzoFormattato();
    }
}
