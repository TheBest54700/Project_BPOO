package Cartes;

import java.io.*;
import java.util.Scanner;

public class Jeu {
	
	private Joueurs J1;
	private Joueurs J2;
	private Main table;
    String Fichier;
    
    /**
     * Constructeur par initialisation.
     */
    public Jeu()
    {
    	J1 = new Joueurs();
    	J2 = new Joueurs();
    	table = new Main();
    	Fichier = new String();
    }
    
    /**
     * Renvoie un joueur selon son numéro.
     *  1 pour le joueur1.
     *  2 pour le joueur2.
     *  sinon null.
     */
    public Joueurs getJoueur(int a)
    {
    	if(a == 1)
    		return this.J1;
    	else if(a == 2)
    		return this.J2;
    	else
    		return null;
    }
    
    /**
     * Renvoie une main qui présente la table du jeu.
     */
    public Main getTable(){
    	return this.table;
    }
    
    /**
     * Renvoie le fichier de la partie.
     */
    public String getFichier(){
    	return this.Fichier;
    }
    
    /**
     * Initialise un tableau de carte avec un jeu de 3x5.
     */
    public static Cartes[] init(){
    	
    	Cartes C[];
    	C = new Cartes[15];  
    	
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
				C[0]= new Cartes(7,"Choc de flamme");
				C[1]= new Cartes(2,"Eclair de givre");
				C[2]= new Cartes(2,"Intelligence des arcanes");
				C[3]= new Cartes(1,"image mirroir");
				C[4]= new Cartes(10,"Explosion pyrotechnique");
			}
			else if(Hero.equals("Rexxar")){
				C[0]= new Cartes(5,"Busard affamé"); 
				C[1]= new Cartes(1,"Marque du chasseur");
				C[2]= new Cartes(1,"Tir des arcanes");
				C[3]= new Cartes(3,"Lâchez les chiens");
				C[4]= new Cartes(3,"Ordre de tuer");
			}
			else
				throw new IllegalArgumentException("Nom héro incorrect");
		}while(erreur == 1);
		
		C[5] = new CartesServiteurs(2,"Chasse-marée murloc",2,1,false);
		C[6] = new CartesServiteurs(7,"Champion de Hurlevent",6,6,false);
		C[7] = new CartesServiteurs(3,"Chef de raid",2,2,false);
		C[8] = new CartesServiteurs(5,"Garde de Baie-du-butin",5,4,false);
		C[9] = new CartesServiteurs(6,"La missilière téméraire",5,2,false);
		C[10] = new CartesServiteurs(4,"L'ogre-magi",4,4,false);
		C[11] = new CartesServiteurs(6,"Archimage",4,7,false);
		C[12] = new CartesServiteurs(1,"Gnôme lépreux",1,1,false);
		C[13] = new CartesServiteurs(3,"Golem des moissons",2,3,false);	
    		
    	return C;	
    }
    
    /**
     * Initialise un tableau de carte à partir d'une chaine de caractères.
     */
    public Cartes[] Chargerjeu(String S)
    {
    	Cartes[] C = new Cartes[15];
    	
    	if(S == null)
    		return null;
    	else
    	{
    		if(S.length() < 15)
    			 return null;
    		else
    		{
	    		for(int i=0;i<15;i++)
	    		{
	    			char Cr = S.charAt(i);
	    			C[i] = new Cartes((int)Cr - 48,"Charger");
	    		}
	    		return C;
    		}
    	}
    }
    /**
     * Initialise le fichier de la partie.
     */
    public void initFichier()
    {
    	this.Fichier = this.J1.toString();
    	this.Fichier = this.Fichier + this.J2.toString();
    	this.Fichier = this.Fichier + ".bjc";
    }
    
    /**
     * Enregistre les mains des deux joueurs.
     */
    public void enregistrer(BufferedWriter bw)
    {
           try
           {  
        	   bw.write("Joueur1 : "+this.J1.toString()+"\n");
        	   bw.write("Joueur2 : "+this.J2.toString()+"\n");	
           }catch(IOException e)
           {
           	  System.out.println(e.toString());
           } 	     
    	
    }
    
    /**
     * Lit une partie à partir du fichier de la partie.
     */
    @SuppressWarnings("deprecation")
	public void Lire(){
    	try{
    		
    		File f = new File("save/"+this.Fichier);
            FileInputStream fis = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);
            
             String S = dis.readLine();
             System.out.println(S);
             
             while(S != null)
             {
             	S = dis.readLine();
             	System.out.println(S);
             }         
              
            dis.close();
            bis.close();
            fis.close();
           
    	}catch(IOException e){
    		System.out.println("Error !" + e.toString());
    	}
    }
    
    /**
     * Distribue un jeu de carte pour les deux joueurs.
     */
    public void distribuer(Cartes C[]){
    	
    	int i=0;
    	if(C != null)
    	{
	    	while(i<15)
	    	{
	    		this.J1.ajoutCarte(C[i]);
	    		i++;
	    	}
	    	
	    	while(i<30)
	    	{
	    		this.J2.ajoutCarte(C[i]);
	    		i++;
	    	}
    	}
    }
   
    /**
     * Le joueur1 pose une carte.
     */
    public Cartes joueur1()
    {
       	Cartes C = this.J1.poserCarte();
    	if(C != null)
    	{
    		this.table.insertCartes(C);
    		return C;
    	}
    	else
    		return null;
    }
    
     /**
     * Le joueur2 pose une carte.
     */
     public Cartes joueur2()
     {
    	Cartes C = this.J2.poserCarte();
    	if(C != null)
    	{
    		this.table.insertCartes(C);
    		return C;
    	}
    	else
    		return null;
    }
    
    /**
     * Affiche la table du jeu. 
     */
    public void afficherTable(){
    	this.table.Afficher();
    }
}
