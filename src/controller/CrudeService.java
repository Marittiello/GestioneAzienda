package controller;

import model.Dipendente;

public class CrudeService implements ICrudeService{
	Dipendente[] azienda= new Dipendente [5];
	int idAutoInc=1;
	@Override

	public boolean inserisciDipendente(Dipendente dipendente) {
		dipendente.id=idAutoInc;
		for(int i=0;i<azienda.length;i++){
			if(azienda[i]==null) {
				azienda[i]=dipendente;
				idAutoInc++;
				return true;
			}
		}
		return false;
	}

	@Override
	public Dipendente leggi(int idRicerca) {

		for(int i=0;i<azienda.length;i++) {
			if(azienda[i]!=null) {
				if(azienda[i].id==idRicerca) {
					return azienda[i];
				}
			}
		}
		return null;
	}

	@Override
	public Dipendente[] leggi() {
		return azienda;
	}

	@Override
	public boolean rimuoviDipendente(int idRicerca) {
		for(int i=0;i<azienda.length;i++) {
			if(azienda[i].id==idRicerca) {
				azienda[i]=null;
				return true;
			}
		}
		return false;
	}

	@Override
	public Dipendente leggi(String codFisc) {
		for(int i=0;i<azienda.length;i++) {
			if(azienda[i]!=null) {
				if(azienda[i].cf.equals(codFisc)) {
					return azienda[i];
				}
			}
		}
		return null;
	}

	@Override
	public boolean rimuoviDipendente(String codFisc) {

		for(int i=0;i<azienda.length;i++) {
			if(azienda[i].cf.equals(codFisc)) {
				azienda[i]=null;
				return true;
			}
		}
		return false;
	}
}

