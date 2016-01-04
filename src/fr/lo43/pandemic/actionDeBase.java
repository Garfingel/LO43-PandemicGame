import java.util.Scanner;



public class actionDeBase {

   protected Etudiant _etu;
  

  public  boolean traverser(Salle salleDestination)throws ActionException {
	  
	  if(_etu.position.estAdjacente(salleDestination))
	  {	  _etu.setPos(salleDestination);
	  return true;
	  }else 
		  throw new ActionException (); 
  }

  public boolean déplacementDéfinis(int indiceDeCarteDsMain) {
    if(_etu.nbrDecarteDsLaMain <=indiceDeCarteDsMain)
                 	return false; 
    
    
	_etu.setPos(_etu.main[indiceDeCarteDsMain].get_Salle());// appelle accesseur pour connaitre la Salle  indiquer dans la carte
	_etu.supprimerCarte(indiceDeCarteDsMain); 
	
	return true;
  }

  private boolean déplacementLibre(int indiceDeCarteDsMain,Salle choixSalle ) {
	  if(_etu.nbrDecarteDsLaMain <=indiceDeCarteDsMain    || _etu.main[indiceDeCarteDsMain].get_Salle().equals(_etu.position)==false)
	  return false;
 
	  _etu.setPos(choixSalle);
		_etu.supprimerCarte(indiceDeCarteDsMain); 
		//appele methode defaussez carte
		return true; 
  
  
  }

  private boolean ascenseur(Salle choixSalle) {
	  
	  if(Professeur.isThereProf(choixSalle.idSalle) && Professeur.isThereProf(_etu.position.idSalle)) 
	  {  _etu.setPos(choixSalle);
		
	   return true;	  
		   }
	  
	  
	  return false;
  }

  public actionDeBase(Etudiant etu) {
  _etu=etu;

  }
  

  public int passer() {
	  return -1;
  }

}