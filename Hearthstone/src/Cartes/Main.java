package Cartes;

public class Main {

	private Cartes ListeCartes[];
    private int NCartes;
   
   /**
    * Constructeur par initialisation.
    */ 
    public Main()
    {
        this.ListeCartes = new Cartes[15];
        this.NCartes = 0;
    }
   
    /**
    * Constructeur par copie.
    */
    public Main(Main M)
    {
    	this.ListeCartes = new Cartes[15];
        for(int i=0;i<M.NCartes;i++)
        {
            this.ListeCartes[i] = new Cartes(M.ListeCartes[i]);
        }
        this.NCartes = M.NCartes;
	
    }
	
    /**
     * Renvoie une main vide ou non.
     */
     public boolean estVide(){
    	 return this.NCartes == 0;
     }
     
     /**
      * Renvoie le nombre de cartes dans une main.
      */
     public int getNCard(){
     	return this.NCartes;
     }
    
    /**
     * Insertion d'une carte à la fin de la main
     * Renvoie "Vrai" si l'insertion a bien été effectuée.
     */
     public boolean insertCartes(Cartes C){
         if(this.NCartes < 15)
         {
             this.ListeCartes[this.NCartes] = new Cartes(C);
             this.NCartes++;
             return true;
         }
         else
        	 return false;
 	}
    
    /**
     * Supprime la dernière carte de la main
     * Renvoie "Vrai" si la suppression a bien été effectuée.
     */
     public boolean SuppDernCarte()
     {
         if(this.NCartes > 0)
         {
 			this.ListeCartes[this.NCartes-1]=null;
 			this.NCartes--;
 			return true;
 		}
 		else
 			return false;
     }    
     
     /**
      * Renvoie la 1ère carte de la main, sinon renvoie null si ce n'est pas possible.
      */
     public Cartes getPremiereCarte()
     {
     	if(this.NCartes != 0)
     		return this.ListeCartes[0];	
     	else
     		return null;
     }
     
     /**
      * Supprime la première carte de la main
      */
      public boolean SuppPremiereCarte()
      {
        if(this.NCartes > 0)
        {
          	for(int i=1; i<this.NCartes;i++)
          		this.ListeCartes[i-1]= this.ListeCartes[i];
  	    	this.ListeCartes[this.NCartes-1]=null;
  		 	this.NCartes--;
  			return true;
  		}
  		else
  			return false;
      }
     
     /**
      * Affiche une main
      */
     public void Afficher()
     {
       for(int i=0; i<this.NCartes;i++)
       {
          this.ListeCartes[i].Afficher();
       }
       System.out.println("");
     }
     
     /**
      * Renvoie une chaine de caractères avec les cartes de la main.
      */
     public String toString()
     {
     	String S = new String("");
     	for(int i=0; i<this.NCartes; i++)
     	{
     		S = S + this.ListeCartes[i].toString();
     		S = S + " ";
     	}
     	return S;
     }
   
     /**
      * Initialise la main à 0 carte.
      */
     public void InitMain()
     {
     	this.NCartes = 0;
     	this.ListeCartes = new Cartes[15];
     }
   
     public static void main(String arg[])
     {
    	 /**Première main*/
 	     Main M = new Main();
 	     
 	     /**Création d'une carte*/
         Cartes C = new Cartes(1,"Busard affamé");
         
         /**On affiche les cartes dans la main (ici il n'y en a pas pour le moment donc ça affichera du vide)*/
         M.Afficher();
         
         /**On insère une carte dans la première main*/
         if(M.insertCartes(C))
        	 
        	/**On affiche la main à nouveau (il y aura donc une carte cette fois)*/
            M.Afficher();
         
         /**Deuxième main*/
         Main MM = new Main(M);
         
         /**On affiche la deuxième main*/
         MM.Afficher();
         
         for(int i=0;i<1;i++)
         {
        	 /**On insère ici 2 fois la carte C dans la première main (grâce à la boucle 'for')*/
        	 if(M.insertCartes(C))
        		 
        		 /**On affiche à nouveau la première main*/
          	     M.Afficher();
         }
         
         for(int i=0;i<1;i++)
         {
        	 /**On supprime ici 2 fois la carte C dans la première main 
        	 (cela servira à supprimer la dernière carte si la main est trop remplie lors d'une insertion d'une carte 
        	 lors du tirage au début du tour du joueur)*/
        	 if(M.SuppDernCarte())
        		 
        		 /**On affiche à nouveau la première main*/
          	     M.Afficher();
         }
         
         /**Initialisation de C avec d'autres paramètres*/
         C = new Cartes(2,"Golem des moissons");
         
         /**On insère la carte C dans la deuxième main*/
         MM.insertCartes(C);
         
         /**On affiche la deuxième main*/
         System.out.println(MM.toString());
    }
}
