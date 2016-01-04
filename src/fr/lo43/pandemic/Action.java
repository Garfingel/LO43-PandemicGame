import java.util.Scanner;

public class Action extends actionDeBase {

public Action(Etudiant etu)
{
super(etu);	
}
  
  public boolean affecterProf()throws ActionException  {
	  
		Scanner sc=new Scanner(System.in);
		
		System.out.println("choisicer l'indice de la carte à jouer");
		
		int indiceDeCarteDsMain=sc.nextInt();
		sc.close();
		
	  if(_etu.nbrDecarteDsLaMain <=indiceDeCarteDsMain    || _etu.main[indiceDeCarteDsMain].get_Salle().equals(_etu.position)==false)//
throw new ActionException();	  

	
	
	  try {
		new Professeur(_etu.position.idSalle);
		_etu.supprimerCarte(indiceDeCarteDsMain);
	
		return true;
	
		
	  } catch (ProfesseurException e) {
		
		  
		  return e.affecterProfExsitante(_etu.position.idSalle);
	}
	  

  }

  public boolean TrouverSolution( Projet p) {
	 Scanner sc  =new Scanner(System.in);
	  if(_etu.nbrDecarteDsLaMain<5 || !Professeur.isThereProf(_etu.position.idSalle) )
                      return false;
	  
	  int indice[] = new int [5];
	  System.out.println(" saisicer l'indice des 5 carte de même couleur  ");
	  for(int i : indice)
		  i=sc.nextInt(); 
	  
	  //verification si les 5 couleur sont du même couleur
	String couleur = _etu.main[0].get_couleur();//accesseur de la Classe carte
	  for (int i : indice)
		 if(_etu.main[i].get_couleur().equals(couleur)==false)	 
				 return false;
	  
	  p.solutionTrouver();
	for(int i : indice)  
	{	_etu.supprimerCarte(i);
	
	
	
	}
	
	return true;
  }

  public boolean avancerDansProjet(Projet p) {

	    
	  
	  
	  
	  return _etu.position.supprimer_cube(p);  
	  
  }

  public boolean rendreProjet(Projet p) {
	  
	  p.eradiquer();
  return  p.getEstEradique();
  }

  public boolean PartageConnaissance(int indiceDeLacare,Etudiant etu_destination) {
	  if(_etu.position.equals(etu_destination.position) )
		  if(_etu.main[indiceDeLacare].get_Salle().equals(_etu.position))
		  {
			  etu_destination.prendre1Carfte(_etu.main[indiceDeLacare]);
			  _etu.supprimerCarte(indiceDeLacare);
			  return true;
		  }
  return false;
  }

}