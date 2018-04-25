package Cartes;

public class Cartes{
	private int mana;
	private String nom;
	
 public Cartes(int mana, String nom) {
	 this.mana=setCout(mana);
	 this.nom=setNom(nom); 	
 }
 
 public String getNom() {
	 return nom;
 }
 
 public String setNom(String nom) {
	 if(nom == null)
		 throw new IllegalArgumentException("Le nom ne doit pas être null");
	 if(nom.equals(""))
		 throw new IllegalArgumentException("Le nom ne doit pas être vide");
	 return this.nom=nom;
 }
 
 public int getCout() {
	 return mana;
 }
 
 public int setCout(int mana) {
	 if(mana < 0 || mana >10)
		 throw new IllegalArgumentException("Cout incorrect");
	 return this.mana=mana;
 }
}

