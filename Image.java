public class Image extends Test {
    protected int nb_max=8;
    protected int nb_echecs;
    protected boolean reussite;
    
    public Image(){
    nom = "Image";
    pop_visee = "singe";
    } //l'utilisateur donne le nb d'echecs pour ce test

    public int getNbEchecs(){return nb_echecs;}
    public boolean getReussite() {return reussite;}
    public String getPopVisee(){return pop_visee;}
	
    public void saisie_utilisateur() //attention, repeter 5 fois
	{
            for (int i=0;i<5;i++)
                {
                    System.out.println("Nombre d'echecs ? ");
                    int nb=Gestion.saisie_num();
                    nb_echecs+=nb;
                }
             if (nb_echecs > nb_max)
                reussite=true;
             else
                reussite=false;
                
	}


}
