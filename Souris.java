public class Souris extends Animal
{
    private final int groupe;
    
    public Souris(String sexe, float poids, int groupe)
    {
	super(sexe, poids);
	this.groupe=groupe;
	this.espece="souris";
	if (groupe == 1)
	    this.pop="Souris 1";
	else if (groupe == 2)
	    this.pop="Souris 2";
    }

    public void afficher_infos()
    {
    	super.afficher_infos();
	System.out.println("Groupe: "+groupe);
    }
}
    

