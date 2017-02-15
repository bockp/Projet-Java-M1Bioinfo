/**
* La classe Test est une classe abstraite servant de base pour la construction des classes de test spécifiques.
* Elle sert de base aux classes Nourriture, Image et Labyrinthe
* @see Nourriture
* @see Image
* @see Labyrinthe
* 
* @author Peter Bock, Cecilia Ostertag
*/

public abstract class Test{
   
    /**
    * Le nom d'un test. chaque test definiera son nom dans son constructeur.
    */
    protected String nom;
    /**
    * La population visee par l'etude. 
    * Elle sera composee de: 'nomEspece numeroDeGroupe'.
    */
    protected String pop_visee;
    /**
    * Retourne le nom du test.
    * @return nom du test
    */
    public String getNom() {return nom;}
    /**
    * Retourne la population visee par le test.
    * @return population visee
    */
    public String getPopVisee() {return pop_visee;}

    /**
    * Fonction abstraite qui sera redefinit par chaque test pour permettre a l'utilisateur de saisir les information 
    * necessaire au test en question.
    */
    abstract void saisie_utilisateur();

}
