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
	    boolean x = true;
	    int t;
	    while(x){
		t=Gestion.saisie_num();
		if(t > 0){ 
		    temps=t;
		    x = false;
		} else {
		    System.out.println("Time must be over 0... your mouse can't teleport, nor can it reach the end before the test begins (unless you're VERY bad at what you're doing) !");
		}
	    }
	}
	    
	

}
