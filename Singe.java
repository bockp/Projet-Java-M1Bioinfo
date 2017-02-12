public class Singe extends Animal
{
    //private final String espece1 = "Singe"; comme il n''est pas cree avant, l'espece devient null
    
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
