public class Image extends Test {
    protected int nb_max=8;
    protected int nb_echecs;
    protected boolean reussite;
    
    public Image(int nb){
    nom = "Image";
    pop_visee = "singe";
    nb_echecs = nb;
    if (nb > nb_max)
	reussite=true;
    else
	reussite=false;
    } //l'utilisateur donne le nb d'echecs pour ce test

    public int getNbEchecs(){return nb_echecs;}
    public boolean getReussite() {return reussite;}
    public String getPopVisee(){return pop_visee;}


}
