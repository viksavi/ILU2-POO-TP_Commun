package model;

public class CentraleReservation <E extends EntiteReservable<F>, F extends Formulaire>{
	private E[] entitesReservables;
	private int nbEntite = 0;
	
	public CentraleReservation(E[] entitesReservables) {
		this.entitesReservables = entitesReservables;
	}
	
	public int ajouterEntite(E entite) {
		entitesReservables[nbEntite] = entite;
		nbEntite++;
		return nbEntite;
	}
	
	public int[] donnerPosibilites(F formulaireUtilisateur) {
		int[] tableauResult = new int[nbEntite];
		for (int i = 0; i < nbEntite; i++) {
			if(entitesReservables[i].compatible(formulaireUtilisateur)) {
				tableauResult[i] = entitesReservables[i].getNumId();
			} else {
				tableauResult[i] = 0;
			}
		}
		return tableauResult;
	}
	
	public Reservation reserver(int numEntite, F formulaire) {
		E entite = entitesReservables[numEntite];
		formulaire.setNumEntite(entite.getNumId());
		return entite.reserver(formulaire);
	}
}
