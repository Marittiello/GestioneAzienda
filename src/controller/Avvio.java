package controller;
import model.Dipendente;
import view.GestioneIO;
public class Avvio {

	public static void main(String[] args) {
		int scelta=0;
		GestioneIO gio= new GestioneIO();
		CrudeService cs= new CrudeService();
		int wait=0;
		do {
			gio.menu();
			scelta=gio.leggiIntero("Effettua Una Scelta Per Continuare: ");
			switch(scelta) {
			
			case 1:{
				Dipendente dipendente= new Dipendente();
				gio.form(dipendente);
				boolean risultatoInserimento=cs.inserisciDipendente(dipendente);
				gio.verificaOperazione(risultatoInserimento, " Aggiunta");
				gio.premiPerContinuare();
				break;
			}
			
			case 2:{
				
				gio.menu2();
				scelta=gio.leggiIntero("Effettua Una Scelta Per Continuare: ");

				switch(scelta) {
				case 1:{
					int idRicerca=gio.leggiIntero("Inserisci L'ID Da Ricercare");
					Dipendente dipendenteCercato=cs.leggi(idRicerca);
					gio.schedaDipendente(dipendenteCercato);
					gio.premiPerContinuare();
					break;
					
				}
				case 2:{
					String codFisc=gio.leggiStringa("Inserisci Il Codice Fiscale Da Ricercare");
					Dipendente dipendenteCercato=cs.leggi(codFisc);
					gio.schedaDipendente(dipendenteCercato);
					gio.premiPerContinuare();
					break;
					
				}
				}
				break;
			}
			
			case 3:{
				gio.tabella(cs.leggi());
				gio.premiPerContinuare();
				break;
			}
			
			case 4:{				
				gio.menu2();
				scelta=gio.leggiIntero("Effettua Una Scelta Per Continuare: ");

				switch(scelta) {
				case 1:{
					
					int idRicerca=gio.leggiIntero("Inserisci L'ID Da Eliminare");
					boolean risultatoInserimento=cs.rimuoviDipendente(idRicerca);
					gio.verificaOperazione(risultatoInserimento, " Rimosso");
					gio.premiPerContinuare();
					break;
					
				}
				case 2:{
					
					String codFisc=gio.leggiStringa("Inserisci Il Codice Fiscale Da Eliminare");
					boolean risultatoInserimento=cs.rimuoviDipendente(codFisc);
					gio.verificaOperazione(risultatoInserimento, " Rimosso");
					gio.premiPerContinuare();
					break;
					
				}
				}

			}
			case 5:{
				gio.statistiche(cs.leggi());
				gio.premiPerContinuare();
			}
			case 6:{
				String citta=gio.leggiStringa("Inserisci La Citta Da Ricercare: ");
				gio.statisticheByCitta(cs.leggi(), citta);
				gio.premiPerContinuare();
			}
			case 7:{
				gio.stampaMessaggio("Il Programma e' Terminato.");
			}
			}
		}while(scelta!=7);



	}

}
