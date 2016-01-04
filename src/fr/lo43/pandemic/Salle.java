

public class Salle{
	public static final int nbrColonLigne =5; 
	public static Salle _s [][] =new Salle [nbrColonLigne][nbrColonLigne] ;//matrice pour connaitre les Salle adjacente 
	// Seul les salle se trovant Directement en haut ou en bat dans la même colone sont adjacent
static int numInstance=0;
 private String _couleur;
protected int  idSalle;
protected int nbrCubes;



  //public est_foyer_d'infection;
public void afficher()
{
	System.out.println("idSalle=="+ idSalle + "\n couleur==" +  _couleur + "\n nbrCube==" + nbrCubes );
}
public Salle(String couleur){
	
	_couleur=couleur;
idSalle=numInstance; 
nbrCubes=0; 
_s[numInstance/nbrColonLigne][numInstance%nbrColonLigne]=this;
	
numInstance++;

}
public boolean estAdjacente(Salle s)
{

	return s.idSalle==this.idSalle || (s.idSalle/nbrColonLigne+1<nbrColonLigne  && s.idSalle == _s[s.idSalle/nbrColonLigne+1][s.idSalle%nbrColonLigne].idSalle) ||
			( s.idSalle/nbrColonLigne-1>-1   &&  s.idSalle == _s[s.idSalle/nbrColonLigne-1][s.idSalle%nbrColonLigne].idSalle); // Seul les salle se trovant Directement en haut ou en bat dans la même colone sont adjacent
}
public  static Salle[] get_salleAdjacente(Salle s)
{
Salle _sss[] = new Salle[2];
if(s.idSalle/nbrColonLigne+1<nbrColonLigne  && s.idSalle == _s[s.idSalle/nbrColonLigne+1][s.idSalle%nbrColonLigne].idSalle)
	_sss[0]=_s[s.idSalle/nbrColonLigne+1][s.idSalle%nbrColonLigne];

else _sss[0]=null;

		if( s.idSalle/nbrColonLigne-1>-1   &&  s.idSalle == _s[s.idSalle/nbrColonLigne-1][s.idSalle%nbrColonLigne].idSalle)
		       _sss[1]= _s[s.idSalle/nbrColonLigne-1][s.idSalle%nbrColonLigne];
		else _sss[1]=null;
		
	return _sss;}

public void ajouter_cube(Projet p) throws FoyerDinfectionException {

if(nbrCubes<3)
	{nbrCubes++;
	
	try {
		p.retirer1Cube();
	} catch (RetirerCubeException e) {
		
	}
	}
else throw new FoyerDinfectionException(this,p);//declaration de foyer d'infection

	
}
   public boolean supprimer_cube(Projet p) {
	 if(nbrCubes>0)
	 {  nbrCubes--;
	 
p.rende1cube();	 
return true;
	 }
	 
	return false;  
}

  public void AffecterProf(){
	try{  
	 new Professeur(idSalle);
	}
	catch(ProfesseurException e){}
	
  }
public String get_couleur() {
	return _couleur;
}
}