
public class CartesInfection{
	protected Salle Salle;
	private Projet Projet;
	public CartesInfection(Salle s, Projet p) {
		// TODO Auto-generated constructor stub
		super();
		Salle = s;
		Projet = p;
	}
	
	public Salle get_Salle(){
		return this.Salle;
	}
	public void afficher(){
		System.out.println("Carte Infection:\n");
		this.Salle.afficher();
		this.Projet.afficher();
	}
}
