
public enum Role {
	amiProf("Etudiant Super Amis Des Professeur  ,pourras affecter un professeur à une sale contre  une seule action"),
	bosseur("Etudiant Super Bosseur, Pourras enlever Tous les cube Sur une Sale"),
	curieux(" Etudiant Super Curieux, pourras donner une carte à un  autre  Etudiant sans restriction par rapport  aux Sales"),
	expediteur("poura manipuler les pion des autre joueurs"),
	inteligent("Etudiant Super Intelligent, pourras découvrir  la solution du projet avec seulement  4 carte");
	String _infoAvantageRole;
	
 Role(String infoAvantageRole)
	{
		this._infoAvantageRole=infoAvantageRole;
		
	}
	public String get_infoAvantageRole() {
		return _infoAvantageRole;
	}
	
}
