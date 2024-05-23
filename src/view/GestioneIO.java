package view;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import model.Dipendente;
@SuppressWarnings("resource")
public class GestioneIO implements IGestoreIO{

	@Override
	public String leggiStringa(String messaggio) {
		Scanner input= new Scanner(System.in);
		System.out.println(messaggio);
		return input.nextLine();
	}

	@Override
	public int leggiIntero(String messaggio) {
		Scanner input= new Scanner(System.in);
		System.out.println(messaggio);
		return Integer.parseInt(input.nextLine());
		
	}

	@Override
	public Double leggiDecimale(String messaggio) {
		Scanner input= new Scanner(System.in);
		System.out.println(messaggio);
		return Double.parseDouble(input.nextLine());
		
	}

	@Override
	public Date leggiData(String messaggio) {
		System.out.println(messaggio);
		int giorno=leggiIntero("Inserisci il giorno: ");
		int mese=leggiIntero("Inserisci il mese: ") ;
		int anno=leggiIntero("Inserisci l'anno: ");
		return Date.valueOf(LocalDate.of(anno, mese, giorno));
		
	}

	@Override
	public void form(Dipendente dipendente) {
		dipendente.nome=leggiStringa("Inserisci il nome: ");
		dipendente.cognome=leggiStringa("Inserisci il cognome: ");
		dipendente.cf=leggiStringa("Inserisci il Codice Fiscale: ");
		dipendente.dataNascita=leggiData("Inserisci la data di nascita: ");
		dipendente.citta=leggiStringa("Inserisci la citta: ");
		dipendente.stipendio=leggiDecimale("Inserisci lo stipendio: ");
		dipendente.anniEsperienza=leggiIntero("Inserisci gli anni di esperienza accumulati: ");
	}

	@Override
	public void schedaDipendente(Dipendente dipendente) {
		
		if(dipendente!=null) {
		System.out.println("ID: "+dipendente.id);
		System.out.println("Nome: "+dipendente.nome);
		System.out.println("Cognome: "+dipendente.cognome);
		System.out.println("Codice Fiscale: "+dipendente.cf);
		System.out.println("Data Di Nascita: "+dipendente.dataNascita);
		System.out.println("Citta: "+dipendente.citta);
		System.out.println("Stipendio: "+dipendente.stipendio);
		System.out.println("Anni Di Esperienza: "+dipendente.anniEsperienza);
		System.out.println("**********************");
		}
		else {
			System.out.println("Dipendente non trovato");
		}
	}

	@Override
	public void verificaOperazione(boolean risultato, String nomeOp) {
		if(risultato) {
			System.out.println(nomeOp+" Avvenut* Con Successo.");
		}
		else {
			System.err.println(nomeOp+" Annullat*.");
		}
	}

	@Override
	public void tabella(Dipendente[] azienda) {
		int dipendentiTrovati=0;
		for(int i=0;i<azienda.length;i++) {
			if(azienda[i]!=null) {
				schedaDipendente(azienda[i]);
				dipendentiTrovati++;
			}
		}
		if(dipendentiTrovati==0) {
			System.out.println("Non Ci Sono Dipendenti Nel DB.");
		}
		else {
			System.out.println("**********************");
			System.out.println("Totale Dipendenti: "+dipendentiTrovati);
			System.out.println("**********************");
		}
	}

	@Override
	public void menu() {
		System.out.println("*********MENU*********");
		System.out.println("1)Aggiungi Dipendente: ");
		System.out.println("2)Leggi Dipendente: ");
		System.out.println("3)Leggi Dipendenti: ");
		System.out.println("4)Rimuovi Dipendente: ");
		System.out.println("5)Statistiche");
		System.out.println("6)Ricerca Statistiche");
		System.out.println("7)Termina Programma: ");
		System.out.println("**********************");
	}

//	5)Statistiche;
//	NB: questa opzione deve stampare:
//	-il numero di dipendenti;
//	-lo stipendio medio;
//	-il valore medio degli anni di esperienza.
	
	@Override
	public void stampaMessaggio(String messaggio) {
		System.out.println(messaggio);
	}

	@Override
	public void statistiche(Dipendente[] azienda) {
		int dipendentiTrovati=0;
		Double addStipendi=0.0;
		int anniEsp=0;
		for(int i=0;i<azienda.length;i++) {
			if(azienda[i]!=null) {
				dipendentiTrovati++;
			}
		}
		for(int i=0;i<azienda.length;i++) {
			if(azienda[i]!=null) {
				azienda[i].stipendio=addStipendi;
			}
		}
		for(int i=0;i<azienda.length;i++) {
			if(azienda[i]!=null) {
				azienda[i].anniEsperienza=anniEsp;
			}
		}
		System.out.println("Numero Dipendenti: "+dipendentiTrovati);
		System.out.println("Stipendio Medio: "+(addStipendi/dipendentiTrovati));
		System.out.println("Media Anni D'Esperienza: "+(anniEsp/dipendentiTrovati));

	}	
	
	@Override
	public void statisticheByCitta(Dipendente[] azienda, String citta) {
		
	}

	@Override
	public void menu2() {
		System.out.println("*********************");
		System.out.println("1)Tramite ID. ");
		System.out.println("2)Tramite Codice Fiscale. ");
		System.out.println("*********************");
		
	}

}
