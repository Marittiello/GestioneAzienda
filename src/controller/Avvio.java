package controller;
import model.Dipendente;
import view.GestioneIO;
public class Avvio {

	public static void main(String[] args) {
		int scelta=0;
		GestioneIO gio= new GestioneIO();
		CrudeService cs= new CrudeService();

		do {
			gio.menu();
			scelta=gio.leggiIntero("Effettua Una Scelta Per Continuare: ");
			switch(scelta) {
			
			case 1:{
				Dipendente dipendente= new Dipendente();
				gio.form(dipendente);
				boolean risultatoInserimento=cs.inserisciDipendente(dipendente);
				gio.verificaOperazione(risultatoInserimento, " Aggiunta");
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
					break;
					
				}
				case 2:{
					String codFisc=gio.leggiStringa("Inserisci Il Codice Fiscale Da Ricercare");
					Dipendente dipendenteCercato=cs.leggi(codFisc);
					gio.schedaDipendente(dipendenteCercato);
					break;
					
				}
				}
				break;
			}
			
			case 3:{
				gio.tabella(cs.leggi());
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
					break;
					
				}
				case 2:{
					
					String codFisc=gio.leggiStringa("Inserisci Il Codice Fiscale Da Eliminare");
					boolean risultatoInserimento=cs.rimuoviDipendente(codFisc);
					gio.verificaOperazione(risultatoInserimento, " Rimosso");
					break;
					
				}
				}

			}
			case 5:{
				gio.statistiche(cs.leggi());
			}
			case 6:{
				String citta=gio.leggiStringa("Inserisci la citta da ricercare: ");
				gio.statisticheByCitta(cs.leggi(), citta);
			}
			}
		}while(scelta!=7);



	}

}
