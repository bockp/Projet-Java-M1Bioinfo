public class Souris extends Animal
{
    private final String espece = "Souris";
    private final int groupe;
    
    public Souris(String sexe, float poids, int groupe)
    {
	super(sexe, poids);
	this.groupe=groupe;
    }

    public void afficher_infos()
    {
	System.out.println("Espece: "+espece);
	System.out.println("Groupe: "+groupe);
	super.afficher_infos();
    }
}
    

