import java.util.Scanner;
public class Etudiant {

 protected Role _role;

 Salle position;

  protected CartesVille [] main;

 protected int nbrDecarteDsLaMain; 
 protected int nb_actions;

  public Action action;
public Etudiant(  Role r)
{
 	_role=r;
main= new  CartesVille[8];//si il a 8 carte ds la main  on suprimera  un des 8 imidiantement
position=Salle._s[0][0];
nbrDecarteDsLaMain=0;



if (_role.equals(Role.amiProf)) action=new ActionAmiProf(this);
if (_role.equals(Role.inteligent)) action= new ActionInteligent(this);
if (_role.equals(Role.bosseur))action=new ActionBosseur(this);
if (_role.equals(Role.curieux))action=new ActionCurieux(this);
if (_role.equals(Role.expediteur))action=new ActionExpediteur(this);

System.out.println(_role.get_infoAvantageRole());
}
public void supprimerCarte(int indiceCarte)
{ 
 for(int i=indiceCarte ; i<nbrDecarteDsLaMain-1;i++)
	 main[i]=main[i+1];
 
 nbrDecarteDsLaMain--;

}

  public void prendre1Carfte(CartesVille c) {
	
 
	
  
		  main[nbrDecarteDsLaMain]=c;
	  
	  nbrDecarteDsLaMain++;

	  if(nbrDecarteDsLaMain>7) 
  { Scanner sc= new Scanner(System.in); 
	 System.out.println("vous avez  deja 7 carte ds la main choisisez l'indice entre 0 et 7  d' une a supprimer"); 

	 supprimerCarte( sc.nextInt());	 
	 sc.close();

  }
   
  
	  
  
  }

 /* public void carte_évènement_spécial(Carte c) {
	  int temp;
	  Scanner sc = new Scanner(System.in);
	  
	  switch(c.toString())//des accesseur pour avoir   la couleur,la salle concerner et le nom de la carte .
	  {case "suprimerCatre":System.out.println("donnez l'indice de la carte que vous voulez supprimer de la defauce");
		   temp=sc.nextInt();
	  c.suprimeDefausse(temp);//une méthode : pour supprimer une carte de la défausse de propagation .
	  break; 
	  
	  case "prevision" :  Carte.pop6Carte(); Carte.trier6() ; push6Carte(); // une methode pour trier les six carte 
	  case "subventions publiques ": 
	  
	  }
	
 
  }*/

 
  public void setPos(Salle nouvPos) {  position=nouvPos;
  }

}