public class Nourriture extends Test {
    protected int nb_echecs;
    protected boolean reussite;

    public Nourriture(int nb, boolean resultat){
    nom = "Nourriture";
    pop_visee = "souris";
    groupe_vise = 2;
    nb_echecs = nb;
    reussite = resultat; 
    } //l'utilisateur donne le nb d'echecs et dit si la souris a reussi ou non (a faire dans Gestion)pour ce test

    public int getNbEchecs(){return nb_echecs;}
    public boolean getReussite() {return reussite;}
    public String getPopVisee(){return pop_visee;}
    public int getGroupe_vise() {return groupe_vise;}
}
