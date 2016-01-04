public class ActionBosseur extends Action {

  public ActionBosseur(Etudiant etu) {
		super(etu);
		// TODO Auto-generated constructor stub
	}

public boolean avancerDansProjet(Projet p) {
  while(super.avancerDansProjet(p));//cet boucle suprime tous les cube sur la salle concerner 
	
	return true;
  }

}