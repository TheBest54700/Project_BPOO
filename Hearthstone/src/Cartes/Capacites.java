package Cartes;

public class Capacites {

	public CartesServiteurs[] Monstre;
	private boolean Provoc;
	/*public void Charge(boolean DirectAttack)
	{
		
		
		
	}
	public static void main(String[] args) {
		

	}*/
	
	public void Provocation(boolean Provoc)
	{
		Provoc = true;
		
		Monstre[0] = new CartesServiteurs(5,"Garde de Baie-du-butin",5,4,Provoc);
		Monstre[1] = new CartesServiteurs(4,"L'ogre-magi",4,4,Provoc);
		Monstre[2] = new CartesServiteurs(6,"Archimage",4,7,Provoc);
	}
}
