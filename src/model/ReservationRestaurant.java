package model;

public class ReservationRestaurant extends Reservation{
	private int numService;
	private int numTable;
	
	public ReservationRestaurant (int jour, int mois, int numService, int numTable) {
		super(jour, mois);
		this.numService = numService;
		this.numTable = numTable;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Le ");
		result.append(String.valueOf(jour));
		result.append("/");
		result.append(String.valueOf(mois));
		result.append("\n");
		result.append("Table ");
		result.append(String.valueOf(numTable));
		result.append(" pour le ");
		if (numService == 1) {
			result.append("premier");
		} else if (numService == 2) {
			result.append("deuxieme");
		}
		result.append(" service.");
		return result.toString();
	}
}
