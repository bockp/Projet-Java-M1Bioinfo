import java.io.*;

/**
 *Cette classe represente une souris
 * @see Animal
 */
public class Souris extends Animal
{
    /**
     *groupe auquel appartient la souris
     * @see Souris#Souris(String, float, int)
     * @see Souris#setGroup(int)
     */
    private int groupe;

    /**
     *Constructeur de la classe Souris.
     * @param sexe : sexe de la souris
     * @param poids : poids de la souris
     * @param groupe : groupe de la souris
     * @see Animal#Animal(String, float)
     */
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

    /**
     *Assigne un groupe a la souris, dans le cas ou on charge un fichier de donnes.
     * @param groupe : groupe de la souris
     */
    public void setGroup(int groupe){
	this.groupe = groupe;
	if (groupe == 1)
	    this.pop="Souris 1";
	else if (groupe == 2)
	    this.pop="Souris 2";
	
    }
    
    /**
     *Affiche les informations de la souris.
     * @see Animal#afficher_infos()
     */
    public void afficher_infos()
    {
    	super.afficher_infos();
	System.out.println("Groupe: "+groupe);
    }

    /**
     *Sauvegarde les informations de la souris dans un ficher texte
     * @param filename : le nom du fichier txt
     * @see Animal#sauvegarder(String)
     */
    public void sauvegarder(String filename)
    {
	try{
	    BufferedWriter buff = new BufferedWriter(new FileWriter(filename, true));
	    buff.write("Id:"+ id + " ");
	    buff.write("Espece:"+ espece + " ");
	    buff.write("groupe:"+ groupe + " ");
	    buff.write("Sexe:"+ sexe + " ");
	    buff.write("Poids:"+ poids + " ");
	    buff.write("Statut:"+ statut + " ");
	    buff.write("Progression:"+ progression + " ");
	    buff.write("Etat:"+ etat + " ");
	    buff.write("Jour_de_la_meilleure_performance:"+ meilleure_performance + " ");
	    buff.write("Resultat:" + resultat + " ");
	    buff.write("Meilleur_resultat:" + meilleur_resultat  + " ");
	    buff.write("Poids_debut_semaine:"+ poids_debut_semaine +" ");
	    buff.newLine();
	    buff.close();
	}
	catch(IOException e) {System.out.println("Erreur de sauvegarde: "+ e);}
    }
}
    

