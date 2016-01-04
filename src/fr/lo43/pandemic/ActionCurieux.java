public class ActionCurieux extends Action {

  public ActionCurieux(Etudiant etu) {
		super(etu);
		// TODO Auto-generated constructor stub
	}

public boolean PartageConnaissance(int indiceDeLacare,Etudiant etu_destination) {
 
	etu_destination.prendre1Carfte(_etu.main[indiceDeLacare]);
	  _etu.supprimerCarte(indiceDeLacare);
	return true;
  }

}