package model;

public interface IEtablissement<F extends Formulaire> {
	public int[] donnerPossibilites(F formulaire);
	public Reservation reserver(int numEntite, F formulaire);
}
