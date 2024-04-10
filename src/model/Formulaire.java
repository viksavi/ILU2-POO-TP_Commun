package model;

public abstract class Formulaire {
	protected int jour;
	protected int mois;
	protected int numEntite;
	
	protected Formulaire(int jour, int mois) {
		this.jour = jour;
		this.mois = mois;
	}
	
	protected int getNumEntite() {
		return numEntite;
	}
	
	protected void setNumEntite(int numEntite) {
		this.numEntite = numEntite;
	}
	
	protected int getMois() {
		return mois;
	}
	
	protected int getJour() {
		return jour;
	}
}
