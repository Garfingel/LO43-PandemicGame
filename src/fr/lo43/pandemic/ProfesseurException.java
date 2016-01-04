import java.util.Scanner;


public class ProfesseurException extends Exception {
	ProfesseurException()
	{ 
		Scanner sc=new Scanner(System.in);
		
		System.out.println("vous avez attins le nbr maximal de prffessuer");
	
	}

  public boolean affecterProfExsitante(int posEtudiant)
 {Scanner sc=new Scanner(System.in);
	 
 System.out.println(" choisicer  id  d'une salle ou il a deja un proffeseurpour pour le metre dans la salle dans le quelle vous vous trouver");
		
int idSalle;
	
		idSalle=sc.nextInt(); 
		if(Professeur.isThereProf(idSalle))
		{	Professeur.get_professeur(idSalle).setAffecterProf(posEtudiant);
		  return true;
		}
		else return false; 
}
  


}
