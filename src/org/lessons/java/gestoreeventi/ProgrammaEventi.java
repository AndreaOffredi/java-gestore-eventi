package org.lessons.java.gestoreeventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProgrammaEventi {

	//Attributi della classe
	private String titolo;
    private List<Evento> eventi;
    
    //Nel costruttore valorizzare il titolo, passato come parametro, e inizializzare la lista di eventi come una nuova ArrayList
    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }
    
    //metodo che aggiunge alla lista un Evento, passato come parametro
    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }
    
    //metodo che restituisce una lista con tutti gli eventi presenti in una certa data
    public List<Evento> getEventiPerData(LocalDate data) {
        return eventi.stream()
        		//Effettuiamo un filtro sulla lista in base alla data input da parametro
                .filter(evento -> evento.getDataEvento().equals(data))
                .collect(Collectors.toList());
    }
    
    //metodo che restituisce quanti eventi sono presenti nel programma
    public int getNumeroEventi() {
        return eventi.size();
    }
    
    //metodo che svuota la lista di eventi
    public void svuotaEventi() {
        eventi.clear();
    }
    
    //metodo che restituisce una stringa che mostra data-titolo
    @Override
    public String toString() {
        StringBuilder dataTitolo = new StringBuilder();
        //"appendiamo" al titolo della lista altre informazioni (data-evento)...
        dataTitolo.append(titolo).append("\n");
        eventi.stream()
        		//ordina gli eventi per data
                .sorted((e1, e2) -> e1.getDataEvento().compareTo(e2.getDataEvento()))
                //per ogni evento "appendiamo"
                .forEach(evento -> dataTitolo.append(evento.getDataEvento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                                     .append(" - ").append(evento.getTitoloEvento()).append("\n"));
        return dataTitolo.toString();
    }
}
