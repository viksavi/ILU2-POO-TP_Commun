package model;

public abstract class EntiteReservable<F extends Formulaire> {
	private CalendrierAnnuel calendrier;
	private int numId;
	
	public int getNumId() {
		return numId;
	}
	
	public void setNumId(int numId) {
		this.numId = numId;
	}
	
	public boolean estLibre(F formulaire) {
		int jour = formulaire.getJour();
		int mois = formulaire.getMois();
		return calendrier.estLibre(jour, mois);
	}
	
	public abstract boolean compatible();
	
	public abstract Reservation reserver();
}
