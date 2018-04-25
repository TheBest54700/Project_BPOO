package Cartes;

public class CartesServiteurs extends Cartes{
	
	private static int attaque;
	private static int vie;
	private static boolean Capacite;
	
	public CartesServiteurs(int mana, String nom,int attaque,int vie,boolean Capacite) {
		super(mana, nom);
		this.attaque=attaque;
		this.vie = vie;
	}
	
	public int getAttaque(){
		return attaque;
	}
	
	public int getVie() {
		return vie;
	}
	
	/*public static void main(String[] args) {
		int i;
		for(i=1;i<=9;i++)
		{
			CartesServiteurs y = new CartesServiteurs(i,"hhhh",i,i);
			System.out.println(y.getCout()+" "+y.getNom()+" "+y.getAttaque()+" "+y.getVie());
		}
	}*/
}