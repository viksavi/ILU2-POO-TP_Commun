package model;

public class Restaurant implements IEtablissement<FormulaireRestaurant> {
	
	private CentraleReservation<Table, FormulaireRestaurant> centrale = 
			new CentraleReservation<>(new Table[100]);
	private Table table;
	
	public void ajouterTable (int nbChaise) {
		Table table = new Table(nbChaise);
		table.setNumId(centrale.ajouterEntite(table));
	}
	
	public int[] donnerPossibilites (FormulaireRestaurant formulaire) {
		return centrale.donnerPosibilites(formulaire);
	}
	
	public Reservation reserver (int numEntite, FormulaireRestaurant formulaire) {
		return centrale.reserver(numEntite, formulaire);
	}
	
	private static class Table extends EntiteReservable<FormulaireRestaurant>{
		
		private int nbChaises;
		private CalendrierAnnuel calendrierDeuxiemeService;
		
		public Table (int nbChaises) {
			super();
			this.nbChaises = nbChaises;
			calendrierDeuxiemeService = new CalendrierAnnuel();
		}

		protected boolean compatible(FormulaireRestaurant formulaireRestaurant) {
			boolean compatible = false;
			int nbPersonnes = formulaireRestaurant.getNombrePersonnes();
			int jour = formulaireRestaurant.getJour();
			int mois = formulaireRestaurant.getMois();
			int numService = formulaireRestaurant.getNumService();
			if(nbPersonnes == nbChaises || nbPersonnes == nbChaises - 1 && ((numService == 0 && calendrier.estLibre(jour, mois))
				|| (numService == 1 && calendrierDeuxiemeService.estLibre(jour, mois)))){
					compatible = true;
			}
			
			return compatible;
		}

		protected Reservation reserver(FormulaireRestaurant formulaireRestaurant) {
			ReservationRestaurant reservation = null;
			int numService = formulaireRestaurant.getNumService();
			int jour = formulaireRestaurant.getJour();
			int mois = formulaireRestaurant.getMois();
			if((numService == 0 && calendrier.reserver(jour, mois)) 
					|| (calendrierDeuxiemeService.reserver(jour, mois))) {
				reservation = new ReservationRestaurant(jour, mois, numService, this.getNumId() - 1);
			}
			return reservation;
		}
		
		
	}

}
