import java.util.Scanner;

public class ActionAmiProf extends Action {

  public ActionAmiProf(Etudiant etu) {
		super(etu);
		// TODO Auto-generated constructor stub
	}

public boolean affecterProf() {
 
	System.out.println("choisisez l'id de la salle où vous voulez metre affecter une prof"); 
	Scanner sc=new Scanner(System.in);
	int idSalle=sc.nextInt();
	
	try {
		new Professeur(idSalle);
	
		return true;
	
		
	  } catch (ProfesseurException e) {
		
		  
		  return e.affecterProfExsitante(_etu.position.idSalle);
	}
	  

  }

}