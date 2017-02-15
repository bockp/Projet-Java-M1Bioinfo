import java.util.*;

/**
 * La classe Protocole sert a gerer les especes disponibles et le protocol experimentale (jours ou l'on fait les experiences).
 * @author Peter Bock, Cecilia Ostertag
 */

public class Protocole
{
	
    /**
    * Un ArrayList qui contiendra des strings, chacun correspondant a une espece d'animal disponibles pour le protocole.
	*/
    protected ArrayList<String> especes = new ArrayList<String>();
	
    /**
    * Un Hashtable donnant avec les tests disponibles en cles, et l'espece (et groupe) auquel il s'applique en valeur.
	*/	
    protected Hashtable tests_dispos = new Hashtable();
	
    /**
    * Une Liste de strings contenant le nom des jours inclut dans l'etude.
	* Si jamais l'etude depasse une semaine, il faudra numeroter les jours (Ex. Lundi1... Lundi2...).
	*/	
    protected List<String> semaine = Arrays.asList("Lundi","Mardi","Mercredi","Jeudi","Vendredi");

    /**
    * Constructeur de la classe Protocole.
	* C'est ici qu'il faudra ajouter les especes necessaire a l'etude,
	* ainsi qu'assigner les tests disponibles et leur domaine d'application (espece et groupe) au Hastable.
    */
    public Protocole()
    {
	especes.add("singe");
	especes.add("souris");
	tests_dispos.put("Souris 1", new ArrayList<String>(Arrays.asList("Labyrinthe")));
    tests_dispos.put("Souris 2", new ArrayList<String>(Arrays.asList("Nourriture")));
    tests_dispos.put("Singe", new ArrayList<String>(Arrays.asList("Image")));
    }

    /**
    * Retourne l'ArrayList contenant les especes de l'etude.
    * @return ArrayList avec nom des especes.
    */
    public ArrayList<String> getEspeces() {return especes;}
	
    /**
    * Retourne les tests et leur domaine d'applications.
    * @return Une Hashtable avec les tests associée a l'espces et le groupe auxquelle il s'applique.
    */
    public Hashtable getTestsDispos() {return tests_dispos;}
	
    /**
    * Retourne une liste des jours ou les tests seront appliquees.
    * @return List de Strings avec le nom de chaque jour du Protocole definit.
    */
    public List<String> getSemaine() {return semaine;}
}

