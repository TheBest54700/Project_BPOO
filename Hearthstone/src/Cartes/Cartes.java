package Cartes;

public class Cartes{
	private int mana;
	private String nom;
	
 /**
  * Un constructeur d'un objet cartes
  */
 public Cartes(int mana, String nom) {
	 this.mana=setCout(mana);
	 this.nom=setNom(nom); 	
 }
 
 /**
  * Un constructeur d'un objet cartes par copie d'un autre objet cartes
  */
 
 public Cartes(Cartes C){
		this.mana = C.mana;
		this.nom = C.nom;
 }
 
 /**
  * Renvoie un nom
  */
 public String getNom() {
	 return nom;
 }
 
 /**
  * Renvoie un nom avec d'abord vérifications
  */
 public String setNom(String nom) {
	 if(nom == null)
		 throw new IllegalArgumentException("Le nom ne doit pas être null");
	 if(nom.equals(""))
		 throw new IllegalArgumentException("Le nom ne doit pas être vide");
	 return this.nom=nom;
 }
 
 /**
  * Renvoie un cout
  */
 public int getCout() {
	 return mana;
 }
 
 /**
  * Renvoie un cout avec d'abord vérifications
  */
 public int setCout(int mana) {
	 if(mana < 0 || mana >10)
		 throw new IllegalArgumentException("Cout incorrect");
	 return this.mana=mana;
 }
 
 /**
  * Compare deux cartes
  * Renvoie this.mana - C.mana
  *               =0 si this.mana = C.mana
  *               >0 si this.mana > C.mana
  *               <0 si this.mana < C.mana
  *                   
  */
 public int CompareCartes(Cartes C){
		return this.mana - C.mana;
 }
 
 public void Afficher(){
	System.out.print(this.mana+" "+this.nom+" \n");
 }
 
 /**
  * Renvoie une chaine de caractères avec les paramètres de la carte
  */
 public String toString(){
 	String S = ""+this.mana+this.getNom();
 	return S;
 }
 
 public static void main(String arg[])
 {

	 Cartes C1 = new Cartes(1, "Busard affamé");
     System.out.println(C1.mana+" "+C1.nom);
     System.out.println(C1.getCout()+" "+C1.getNom());
     C1.Afficher();
     Cartes C2 = new Cartes(C1);
     C2.Afficher();
     C2.mana = 2;
     System.out.println(""+C1.CompareCartes(C2));
 } 
}

