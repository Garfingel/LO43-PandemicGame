
public class Professeur {
 protected static int nbrDeProfAffecter =0; 
public static Professeur p[]= new Professeur[6];
protected int _idSalle;

 public Professeur(int idSalle)throws ProfesseurException
 {
	 if(nbrDeProfAffecter<6  && !isThereProf(idSalle))
 	{
 		_idSalle=idSalle; 
 		nbrDeProfAffecter++;
       p[nbrDeProfAffecter-1]  =this; 		
 	} else throw new ProfesseurException();
	 
	 
 }
  
  public void setAffecterProf( int idSalle)
    {
	  _idSalle=idSalle; 
    	
    }
 
 public static Professeur get_professeur(int idSalle){
 int i; 
	 for(i=0;i<nbrDeProfAffecter && p[i]._idSalle!=idSalle ;i++); 

	 
	return ( i<nbrDeProfAffecter) ? p[i]: null;
 }
  
  
  public static boolean isThereProf(int idSalle)
{int i=0;
	for(i=0;i<nbrDeProfAffecter && p[i]._idSalle!=idSalle ;i++); 
	
	
	return i<nbrDeProfAffecter;
	
} 




}