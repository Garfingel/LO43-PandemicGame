import java.util.Scanner;
import java.util.Vector;

public class ActionInteligent extends Action {

    
  public ActionInteligent(Etudiant etu) {
		super(etu);
		
	}

public boolean TrouverSolution(Projet p) {
  
	 Scanner sc  =new Scanner(System.in);
	  if(_etu.nbrDecarteDsLaMain<4 || !Professeur.isThereProf(_etu.position.idSalle) )
                     return false;
	  
	  int indice[] = new int [4];
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
	
	//defausser la carte
	
	}
	
	return true;
	
	

  }

}