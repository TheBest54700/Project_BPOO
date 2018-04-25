package Cartes;

import java.util.Scanner;

public class Deck {
	
	private static Cartes[] nb_CartesSpe;
	private static CartesServiteurs[] nb_CartesServ;
	//private static Cartes[] nb_Spe;
	/*private static int attaque[]= {2,6,2,5,5,4,4,1,2};
	@SuppressWarnings("unused")
	private static int vie[]= {1,6,2,4,2,4,7,1,3};*/
	//private static int n = attaque.length;
	
	public Deck() {
		this.nb_CartesSpe= new Cartes[5];
		this.nb_CartesServ = new CartesServiteurs[10];
	}
	
	public static void main(String[] args) {
		int i,j;
		Deck y = new Deck();
        y.choixHero();
        System.out.println("Cartes Spéciales liées au Héro :");
        for(i=0;i<=4;i++)
        	System.out.println(nb_CartesSpe[i].getCout()+" "+nb_CartesSpe[i].getNom());
      
        System.out.println("Cartes Neutres :");
        for(j=0;j<=8;j++)
        {
        	System.out.println(nb_CartesServ[j].getCout()+" "+nb_CartesServ[j].getNom()+" "+nb_CartesServ[j].getAttaque()+" "+nb_CartesServ[j].getVie());
        }
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
				nb_CartesSpe[0]= new Cartes(7,"Choc de flamme");
				nb_CartesSpe[1]= new Cartes(2,"Eclair de givre");
				nb_CartesSpe[2]= new Cartes(2,"Intelligence des arcanes");
				nb_CartesSpe[3]= new Cartes(1,"image mirroir");
				nb_CartesSpe[4]= new Cartes(10,"Explosion pyrotechnique");
			}
			else if(Hero.equals("Rexxar")){
				nb_CartesSpe[0]= new Cartes(5,"Busard affamé"); 
				nb_CartesSpe[1]= new Cartes(1,"Marque du chasseur");
				nb_CartesSpe[2]= new Cartes(1,"Tir des arcanes");
				nb_CartesSpe[3]= new Cartes(3,"Lâchez les chiens");
				nb_CartesSpe[4]= new Cartes(3,"Ordre de tuer");
			}
			else
				throw new IllegalArgumentException("Nom héro incorrect");
		}while(erreur == 1);
		
		nb_CartesServ[0] = new CartesServiteurs(2,"Chasse-marée murloc",2,1,false);
		nb_CartesServ[1] = new CartesServiteurs(7,"Champion de Hurlevent",6,6,false);
		nb_CartesServ[2] = new CartesServiteurs(3,"Chef de raid",2,2,false);
		nb_CartesServ[3] = new CartesServiteurs(5,"Garde de Baie-du-butin",5,4,false);
		nb_CartesServ[4] = new CartesServiteurs(6,"La missilière téméraire",5,2,false);
		nb_CartesServ[5] = new CartesServiteurs(4,"L'ogre-magi",4,4,false);
		nb_CartesServ[6] = new CartesServiteurs(6,"Archimage",4,7,false);
		nb_CartesServ[7] = new CartesServiteurs(1,"Gnôme lépreux",1,1,false);
		nb_CartesServ[8] = new CartesServiteurs(3,"Golem des moissons",2,3,false);
		return Hero;	
	}
}