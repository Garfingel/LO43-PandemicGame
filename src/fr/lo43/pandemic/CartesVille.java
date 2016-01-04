public class CartesVille extends CartesJoueur {
	protected Salle Salle;
	public CartesVille(Salle s) {
		// TODO Auto-generated constructor stub
		super();
		Salle = s;
	}
	public CartesVille(CartesVille cv){
		super();
		Salle = cv.Salle;
	}
	
	public Salle get_Salle(){
		return Salle;
	}
	public String get_couleur(){
		return this.Salle.get_couleur();
	}
	public void afficher(){
		System.out.println("Carte Salle:\n");
		Salle.afficher();
	}
}
