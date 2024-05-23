package controller;
import model.Dipendente;
public interface ICrudeService {

	public boolean inserisciDipendente(Dipendente dipendente);
	public Dipendente leggi(int idRicerca);
	public Dipendente[] leggi();
	public boolean rimuoviDipendente(int idRicerca);
	public Dipendente leggi(String cf);
	public boolean rimuoviDipendente(String cf);

}
