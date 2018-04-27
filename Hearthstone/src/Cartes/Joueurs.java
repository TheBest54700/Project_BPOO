package Cartes;

import java.util.*;

public class Joueurs {
	
	 	private Main M;
	    private List ListeMain;
	    
	    /**
	     * Constructeur par initialisation.
	     */
	    public Joueurs()
	    {
	       this.ListeMain = new Vector();
	       M = new Main();
	    }
	    
	    /**
	     * Ajoute une main a l'historique des mains jouées.
	     */
	    public void ajoutMain()
	    {
	    	 Main tempo = new Main(this.M);
	    	 this.ListeMain.add(M);
	    }
	    
	    /**
	     * Ajoute une carte dans la main courante du joueur.
	     */
	    public void ajoutCarte(Cartes C)
	    {
	    	this.M.insertCartes(C);
	    }
	    
	    /**
	     * Pose une carte et renvoie la premiere carte et la supprime la carte de la main courante.
	     */
	    public Cartes poserCarte()
	    {
	    	Cartes C;
	    	C = new Cartes(this.M.getPremiereCarte());
	    	this.M.SuppPremiereCarte();
	    	return C;
	    }
	    
	    /**
	     * Renvoie si le joueur a perdu ou non.
	     */
	    public boolean Perdu()
	    {
	    	return this.M.estVide();
	    }
	    
	    /**
	     * Affiche la main courante.
	     */
	    public void Afficher()
	    {
	    	this.M.Afficher();
	    }
	    
	    /**
	     * Affiche l'historique des mains.
	     */
	    public void afficherHist()
	    { 
	    	int i;
	    	for(i=0;i<this.ListeMain.size();i++)
	    	{
	    		Main t = (Main) this.ListeMain.get(i);
	    		t.Afficher();
	    	}
	    }

	    /**
	     * Renvoie une chaine de caractére avec les cartes dans l'ordre de la main courante
	     */    
	    public String toString()
	    {
	    	return this.M.toString();
	    }
}
