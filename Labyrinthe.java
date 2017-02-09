public class Labyrinthe extends Test {

    protected int temps;
    

    public Labyrinthe(){
    nom = "Labyrinthe";
    pop_visee = "souris 1";
    } //l'utilisateur donne le temps qu'a mis la souris
    
    public int getTemps(){return temps;}
    public String getPopVisee(){return pop_visee;}
	
    public void saisie_utilisateur()
	{
	    System.out.println("Temps ?");
		int t=Gestion.saisie_num();
		temps=t;
	}
	

}
