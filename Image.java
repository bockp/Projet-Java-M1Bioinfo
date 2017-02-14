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
	
    public void saisie_utilisateur() // repete 5x l'experience
	{
          for (int i=0;i<5;i++) 
                {
		    boolean x = true;
		    System.out.println("Nombre d'echecs ? (exp:"+(i+1)+")");
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
                    nb_echecs+=nb;
                }
	    nb_echecs=nb_echecs/5;
             if (nb_echecs > nb_max)
                reussite=true;
             else
                reussite=false;

	}
}
