/**
 *Cette classe represente un singe
 * @see Animal
 * @author Peter Bock, Cecilia Ostertag
 */


public class Singe extends Animal
{
    /**
     *Constructeur de la classe Singe.
     * @param sexe : sexe du singe
     * @param poids : poids du singe
     * @see Animal#Animal(String, float)
     */
    
    public Singe(String sexe, float poids)
    {
	super(sexe, poids);
	this.espece = "singe";
        this.pop = "Singe";
	
    }

    /**
     *Affiche les informations du singe.
     * @see Animal#afficher_infos()
     */
    public void afficher_infos()
    {
	super.afficher_infos();
    }

    /**
     *Sauvegarde les informations du singe dans un ficher texte
     * @param filename : le nom du fichier txt
     * @see Animal#sauvegarder(String)
     */
    public void sauvegarder(String filename){super.sauvegarder(filename);}
}
