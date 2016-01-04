
public class FoyerDinfectionException extends Exception {

	public FoyerDinfectionException(Salle s,Projet p)
	{
		System.out.println("foyer d'infection");
		Salle _s[] =Salle.get_salleAdjacente(s); 
		
		if(_s[0]!=null)
			try {
				_s[0].ajouter_cube(p);
			} catch (FoyerDinfectionException e) {
		
			}
		if(_s[1]!=null)
			try {
				_s[1].ajouter_cube(p);
			} catch (FoyerDinfectionException e) {
				
			}
	}

}
