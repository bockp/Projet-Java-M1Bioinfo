public class Nourriture extends Test {
    protected int nb_echecs;
    protected boolean reussite = false;

    public Nourriture(){
	nom = "Nourriture";
	pop_visee = "souris 2";
    } //l'utilisateur donne le nb d'echecs et dit si la souris a reussi ou non (a faire dans Gestion)pour ce test

    public int getNbEchecs(){return nb_echecs;}
    public boolean getReussite() {return reussite;}
    public String getPopVisee(){return pop_visee;}
    
    public void saisie_utilisateur()
    {
	boolean x = true;
	System.out.println("Nombre d'echecs ? ");
	int nb = -1;
	while (x){
	    nb = Gestion.saisie_num();
	    if(nb >= 0){ // saisie correctement, sinon recommence le saisie.
		x = false; //
	    }
	    else {
		System.out.println("Erreur, veuillez retaper le nombre d'echecs.");
	    }
	}
	x = true;

	nb_echecs=nb;
	System.out.println("Taper x si le test est reussi : ");
	String resultat = Gestion.saisie_chaine();
	if (resultat == "x")
	    reussite=true;
    }
}
