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
	    System.out.println("Nombre d'echecs ? ");
		int nb=Gestion.saisie_num();
		nb_echecs=nb;
		System.out.println("Taper o si le test est reussi : ");
		String resultat = Gestion.saisie_chaine();
		if (resultat == "o")
			reussite=true;
	}
}
