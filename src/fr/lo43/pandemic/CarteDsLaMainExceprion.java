import java.util.Scanner;


public class CarteDsLaMainExceprion extends Exception {
	
public 	 int CarteDsLaMainExceprion()
{ System.out.println("chisisser l'indice entre 0 et 7 de la carte a defaussez") ;
	Scanner sc= new Scanner(System.in);
return sc.nextInt();

}
	public String  getMessage()
	{
		
		return " vous avez  deja 7 carte ds la main choisisez une a supprimer";
		
	}

}
