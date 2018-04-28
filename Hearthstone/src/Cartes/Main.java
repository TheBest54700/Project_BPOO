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
     * Insertion d'une carte � la fin de la main
     * Renvoie "Vrai" si l'insertion a bien �t� effectu�e.
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
     * Supprime la derni�re carte de la main
     * Renvoie "Vrai" si la suppression a bien �t� effectu�e.
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
      * Renvoie la 1�re carte de la main, sinon renvoie null si ce n'est pas possible.
      */
     public Cartes getPremiereCarte()
     {
     	if(this.NCartes != 0)
     		return this.ListeCartes[0];	
     	else
     		return null;
     }
     
     /**
      * Supprime la premi�re carte de la main
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
      * Renvoie une chaine de caract�res avec les cartes de la main.
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
      * Initialise la main � 0 carte.
      */
     public void InitMain()
     {
     	this.NCartes = 0;
     	this.ListeCartes = new Cartes[15];
     }
   
     public static void main(String arg[])
     {
    	 /**Premi�re main*/
 	     Main M = new Main();
 	     
 	     /**Cr�ation d'une carte*/
         Cartes C = new Cartes(1,"Busard affam�");
         
         /**On affiche les cartes dans la main (ici il n'y en a pas pour le moment donc �a affichera du vide)*/
         M.Afficher();
         
         /**On ins�re une carte dans la premi�re main*/
         if(M.insertCartes(C))
        	 
        	/**On affiche la main � nouveau (il y aura donc une carte cette fois)*/
            M.Afficher();
         
         /**Deuxi�me main*/
         Main MM = new Main(M);
         
         /**On affiche la deuxi�me main*/
         MM.Afficher();
         
         for(int i=0;i<1;i++)
         {
        	 /**On ins�re ici 2 fois la carte C dans la premi�re main (gr�ce � la boucle 'for')*/
        	 if(M.insertCartes(C))
        		 
        		 /**On affiche � nouveau la premi�re main*/
          	     M.Afficher();
         }
         
         for(int i=0;i<1;i++)
         {
        	 /**On supprime ici 2 fois la carte C dans la premi�re main 
        	 (cela servira � supprimer la derni�re carte si la main est trop remplie lors d'une insertion d'une carte 
        	 lors du tirage au d�but du tour du joueur)*/
        	 if(M.SuppDernCarte())
        		 
        		 /**On affiche � nouveau la premi�re main*/
          	     M.Afficher();
         }
         
         /**Initialisation de C avec d'autres param�tres*/
         C = new Cartes(2,"Golem des moissons");
         
         /**On ins�re la carte C dans la deuxi�me main*/
         MM.insertCartes(C);
         
         /**On affiche la deuxi�me main*/
         System.out.println(MM.toString());
    }
}
