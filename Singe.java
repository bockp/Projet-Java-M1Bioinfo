public class Singe extends Animal
{
    private final String espece = "Singe";
    
    public Singe(String sexe, float poids)
    {
	super(sexe, poids);
	this.pop=this.espece;
    }

    public void afficher_infos()
    {
	System.out.println("Espece: "+espece);
	super.afficher_infos();
    }

    public void sauvegarder(String filename){super.sauvegarder(filename);}
}
