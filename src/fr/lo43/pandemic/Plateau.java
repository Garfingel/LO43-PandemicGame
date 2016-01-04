/*package fr.lo43.pandemic;

import fr.lo43.pandemic.Carte.CarteEpidemie;
import fr.lo43.pandemic.Carte.CarteEvenement;
import fr.lo43.pandemic.Carte.CarteInfection;
import fr.lo43.pandemic.Carte.CarteVille;
import fr.lo43.pandemic.Carte.Cartes;
import fr.lo43.pandemic.Etudiants.Etudiant;
import fr.lo43.pandemic.Etudiants.Role;
import fr.lo43.pandemic.Salles.Salle;
import fr.lo43.pandemic.infection.Infection;
import fr.lo43.pandemic.projet.Projet;*/

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Plateau {

	
	private final int nbCartesInfection=25;
	private final int nbCartesJoueur=60;
	private final int nbCartesEpidemie=6;
	private final int nbCartesEvenement=12;
	private final int nbCartesVille=nbCartesJoueur-nbCartesEpidemie-nbCartesEvenement;
	
	private int difficulty;
	private static boolean victory, defeat;
	private int nbjoueurs;
	private List<Etudiant> joueurs;
	private Salle salles;
	private boolean remede;
	private Projet p;
	
	private int delaiProjet;
	private int nbFoyersInfection;
	private int maxFoyersInfection;
	
	private Cartes cartesJoueur;
	private Cartes cartesInfection;
	
	//private int remainingTurns;
	
	
	public Plateau()
	{		
		this.initGame();
	}
	
	
	public void initGame()
	{
		
		this.initValeurs();
		this.initSalles();
		this.initJoueurs();
		this.initCartes();
		this.initCubes();
		
		/*
		Résumé de l'initialisation du jeu:
		
		initialiser valeurs
			taux d'infection
			foyers d'infection
			remèdes
			nbtours
			
		créer salles
			créer salles
			placer station atlanta
		
		créer joueurs
			créer étudiant (role)*nbjoueurs
			placer joueurs à atlanta		
		
		générer cartes
			(Créer et Mélanger cartes rôles)
			créer cartes joueurs
			distribuer cartes joueurs
			créer nb piles cartes joueurs
			créer cartes épidémie
			mettre cartes épidémies dans piles
			fusionner piles
			créer et mélanger cartes infection
		
		placer les cubes maladie sur les salles
			piocher 3 cartes ajouter 3 cubes sur chaque salle
			piocher 3 cartes ajouter 2 cubes sur chaque salle
			piocher 3 cartes ajouter 1 cubes sur chaque salle
		
		 */
	}
	
	public void playGameTurn()
	{
		ListIterator<Etudiant> it=joueurs.listIterator();

		while(it.hasNext())
		{
			this.playTurn((Etudiant)it.next());
		}
		
		
	}
	
	public void playTurn(Etudiant joueur){
		// Les vérifications de bonnes saisie n'ont pas été réalisés.
		int rep1,rep2,a = 0;
		while((a != -1)||(a<4)){
			a++;
			System.out.println("Actions Possibles: (Selon votre Role)\n0 : Affecter Prof\n1Avancer Dans Projet\n2Déplacement vers une salle (non adjacente, necessite une carte)\n");
			System.out.println("3 Partage de connaissance (Non disponible)\n4 Passer\n5 Rendre Projet\n6 Traverser (salle adjacente)\n7 Trouver Solution\n");
			Scanner sc = new Scanner(System.in);
			System.out.println("Saisissez votre choix:\n");
			rep1 = sc.nextInt();
			switch(rep1){
			case 0 : try {
					joueur.action.affecterProf();
				} catch (ActionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			case 1 : joueur.action.avancerDansProjet(p);
			break;
			case 2 : System.out.println("Vers quelle ville voulez vous vous deplacer ?\n");
					rep2 = sc.nextInt();
					joueur.action.déplacementDéfinis(rep2);
			break;
			case 3 : //joueur.action.PartageConnaissance(indiceDeLacare, etu_destination);
			break;
			case 4 : a=joueur.action.passer();
					sc.close();
			break;
			case 5 : joueur.action.rendreProjet(p);
			break;
			case 6 : Salle s[] = joueur.position.get_salleAdjacente(joueur.position);
					System.out.println("Ou voulez vous aller ?\n");
					for(int i=0;i<2;i++){
						System.out.println("Salle " + i +":\n");
						s[i].afficher();
					}
					rep2 = sc.nextInt();
				try {
					joueur.action.traverser(s[rep2]);
				} catch (ActionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			case 7 : joueur.action.TrouverSolution(p);
			}
		sc.close();
		}
		/*for(joueur.getNbActions())	
			joueur.action()
			
		joueur.tirercarte()*/
	}
	
	public static boolean gameIsOver()
	{
		if(defeat || victory)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void setVictory()
	{
		victory=true;
	}
	
	public static void setDefeat()
	{
		defeat=true;
	}
	
	public void decreaseDelaiProjet()
	{
		if((--this.delaiProjet)<=0)
		{
			Plateau.setDefeat();
		}
	}
	
	public void increaseNbFoyersInfection()
	{
		if((++this.nbFoyersInfection)>maxFoyersInfection)
		{
			Plateau.setDefeat();
		}
	}
	
	public static void jouerInfecteur()
	{
		
	}
	
	public void initValeurs()
	{
		difficulty=1;
		victory=false;
		defeat=false;
		nbjoueurs=5;
		joueurs=new LinkedList<Etudiant>();
		
		this.delaiProjet=8;
		this.nbFoyersInfection=0;
		this.maxFoyersInfection=8;
		
		remede=false;
		p = new Projet("Rouge");
		
		
		/*
 		initialiser valeurs
			taux d'infection
			foyers d'infection
			remèdes
			nbtours
			
		
 		*/
	}
	
	public void initSalles()
	{
		String couleur="Rouge";
		
		this.salles=new Salle(couleur);
		
		for(int i=0;i<24;i++)
		{
			new Salle(couleur);
		}
		
		/*
 		créer salles
			créer salles
			placer station atlanta
		
		
 		*/
	}
	
	public void initJoueurs()
	{
		/*for(int i=0;i<this.nbjoueurs;i++)
		{
			this.joueurs.add(new Etudiant("Joueur "+i, new RoleE("role")), salles._s[0][0]);
		}*/
				
			this.joueurs.add(new Etudiant(Role.amiProf));
			this.joueurs.add(new Etudiant(Role.bosseur));
			this.joueurs.add(new Etudiant(Role.curieux));
			this.joueurs.add(new Etudiant(Role.expediteur));
			this.joueurs.add(new Etudiant(Role.inteligent));
		/*
 		créer joueurs
			créer étudiant (role)*nbjoueurs
			placer joueurs à atlanta		
		
			
 		*/
	}
	
	public void initCartes()
	{
		//création des cartes infection
		this.cartesInfection=new Cartes();
		
		int i,j;
		for(i=0;i<this.nbCartesInfection/5;i++)
		{
			for(j=0;j<this.nbCartesInfection/5;j++)
			{
				this.cartesInfection.add_carte(new CartesInfection(salles._s[i][j], new Projet("Rouge")));
			}
		}
		
		//création des cartes joueur
		this.cartesJoueur=new Cartes();
		
		for(i=0;i<this.nbCartesVille;i++)
		{
			this.cartesJoueur.add_carte(new CartesVille(salles));
		}
		
		for(i=0;i<this.nbCartesEvenement;i++)
		{
			this.cartesJoueur.add_carte((int)(Math.random()*this.nbCartesJoueur+1), new CartesEvenement());
		}
		
		int pas=this.nbCartesJoueur/10;
		
		
		//distribution des cartes joueurs
		ListIterator<Etudiant> it=joueurs.listIterator();
		
		while(it.hasNext())
		{
			for(i=0;i<((int)(7/this.nbjoueurs+1));i++)
			{
				it.next().prendre1Carfte((CartesVille)this.cartesJoueur.piocher_dessus());
				//it.next().prendre1Carfte(this.cartesInfection.piocher_dessous()); usless
			}
		}

		//création et insertion des cartes épidémie
		for(i=0;i<this.nbCartesEpidemie*pas;i=i+pas)
		{
			this.cartesJoueur.add_carte(i, new CartesEpidemie());
		}
		

		
		/*
 		générer cartes
			Créer et Mélanger cartes rôles
			créer cartes joueurs
			distribuer cartes joueurs
			créer nb piles cartes joueurs
			créer cartes épidémie
			mettre cartes épidémies dans piles
			fusionner piles
			créer et mélanger cartes infection		
 		*/
	}
	
	public void initCubes()
	{
		
		for (int i=0;i<3;i++)
		{
			for (int j=0;j<3;j++)
			{
				for (int k=0;k<i;k++)
				{
					try {
						((CartesInfection)this.cartesInfection.piocher_dessus()).get_Salle().ajouter_cube(new Projet("Rouge"));
					} catch (FoyerDinfectionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		
		
		/*
 		placer les cubes maladie sur les salles
			piocher 3 cartes ajouter 3 cubes sur chaque salle
			piocher 3 cartes ajouter 2 cubes sur chaque salle
			piocher 3 cartes ajouter 1 cubes sur chaque salle	
 		*/
	}
	
	
	public static void main(String[] args) {
		
			Plateau CurrentGame=new Plateau();
			
			CurrentGame.initGame();
			
			while(CurrentGame.gameIsOver()==false)
				CurrentGame.playGameTurn();
		Cartes lol=new Cartes();
		lol.piocher_dessus();
	}

}
