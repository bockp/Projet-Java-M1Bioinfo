public class Singe extends Animal
{
    private final String espece1 = "Singe";
    
    public Singe(String sexe, float poids)
    {
	super(sexe, poids);
	this.pop=this.espece1;
	this.espece = espece1;
	
    }

    public void afficher_infos()
    {
	System.out.println("Espece: "+espece1);
	super.afficher_infos();
    }

    public void sauvegarder(String filename){super.sauvegarder(filename);}
}
