

public class Projet {

 private boolean estEradique;

 private boolean _solutionTrouver;

 private String _couleur;

  int nbrCubeEnStock;

public Projet(String couleur)
{ 
	couleur=_couleur; 
	_solutionTrouver=false;
	estEradique=false;
	nbrCubeEnStock=24;
	
}
public void afficher()
{
	System.out.println("eradiquer==" + estEradique + " _solutionTrouver==" + _solutionTrouver + "nbr de cube  en  stock=="  +  nbrCubeEnStock + "couleur== " + _couleur) ;
}
 public void retirer1Cube() throws RetirerCubeException{
	if(nbrCubeEnStock==0)
		throw new RetirerCubeException(); 
	else 
		nbrCubeEnStock--;
	
	
	
}
 public void rende1cube()
 {
	 nbrCubeEnStock++;
	 
 }
  
  public void solutionTrouver()
  {
	  _solutionTrouver=true;
  }
  
  public void eradiquer() {
	  if(nbrCubeEnStock==24 && get_solutionTrouver())
	  estEradique=true;
	  else System.out.println("les condition pour eradiquerune maladie ne sont pas reuinis");
  }
  
public boolean getEstEradique() {
	return estEradique;
}
public boolean get_solutionTrouver() {
	return _solutionTrouver;
}

}