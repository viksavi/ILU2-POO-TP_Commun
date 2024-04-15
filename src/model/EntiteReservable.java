package model;

public abstract class EntiteReservable<F extends Formulaire> {
	protected CalendrierAnnuel calendrier;
	protected int numId;
	
	protected EntiteReservable() {
		calendrier = new CalendrierAnnuel();
	}
	
	protected int getNumId() {
		return numId;
	}
	
	protected void setNumId(int numId) {
		this.numId = numId;
	}
	
	protected boolean estLibre(F formulaire) {
		int jour = formulaire.getJour();
		int mois = formulaire.getMois();
		return calendrier.estLibre(jour, mois);
	}
	
	protected abstract boolean compatible(F formulaire);
	
	protected abstract Reservation reserver(F formulaire);
}
