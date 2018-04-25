package Cartes;

import java.util.Scanner;

public class Deck {
	
	private static Cartes[] nb_Cartes;
	//private static Cartes[] nb_Spe;
	/*private static int attaque[]= {2,6,2,5,5,4,4,1,2};
	@SuppressWarnings("unused")
	private static int vie[]= {1,6,2,4,2,4,7,1,3};*/
	//private static int n = attaque.length;
	
	public Deck() {
		this.nb_Cartes= new Cartes[15];
		//this.nb_Spe = new Cartes[5];
	}
	
	public static void main(String[] args) {
		int i;
		Deck y = new Deck();
        y.choixHero();
        for(i=0;i<=4;i++)
        	System.out.println(nb_Cartes[i].getCout()+" "+nb_Cartes[i].getNom());
		//System.out.println(n);
	}
	
	public static String choixHero() {
		
		String Hero = "";
		
		Scanner ss = new Scanner(System.in);
		System.out.println("Entrez le nom de votre héro :");
		int erreur = 1;
		int p = 0;
		
		do {
			Hero = ss.nextLine();
			try {
				p=Integer.parseInt(Hero);
			}
			catch(NumberFormatException e)
			{
				erreur = 0;
			}
			if(erreur == 1)
				System.out.println("Veuillez rentrer une chaine de caractères");
			
			if(Hero.equals("Jaina")) {
				nb_Cartes[0]= new Cartes(7,"Choc de flamme");
				nb_Cartes[1]= new Cartes(2,"Eclair de givre");
				nb_Cartes[2]= new Cartes(2,"Intelligence des arcanes");
				nb_Cartes[3]= new Cartes(1,"image mirroir");
				nb_Cartes[4]= new Cartes(10,"Explosion pyrotechnique");
			}
			else if(Hero.equals("Rexxar")){
				nb_Cartes[0]= new Cartes(5,"Busard affamé"); 
				nb_Cartes[1]= new Cartes(1,"Marque du chasseur");
				nb_Cartes[2]= new Cartes(1,"Tir des arcanes");
				nb_Cartes[3]= new Cartes(3,"Lâchez les chiens");
				nb_Cartes[4]= new Cartes(3,"Ordre de tuer");
			}
			else
				throw new IllegalArgumentException("Nom héro incorrect");
		}while(erreur == 1);
		
		return Hero;		
	}
}