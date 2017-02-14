public class Singe extends Animal
{
    
    public Singe(String sexe, float poids)
    {
	super(sexe, poids);
	this.espece = "singe";
        this.pop = "Singe";
	
    }

    public void afficher_infos()
    {
	super.afficher_infos();
    }

    public void sauvegarder(String filename){super.sauvegarder(filename);}
}
