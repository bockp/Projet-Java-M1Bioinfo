/**
 * La classe Labyrinthe represente un des tests disponibles.
 * elle ne s'applique que au groupe 1 des souris, et est une extension de la classe Test.
 * @see Test
 *
 * PRINCIPE: 
 * 
 * On mesure le temps que la souris met pour atteindre la sortie d'un labyrinthe,
 * On considère que la sortie est toujours au même endroit d’une expérimentation à l’autre.
 *
 * @author Peter Bock, Cecilia Ostertag
 */

public class Labyrinthe extends Test {
     /**
     * Le temps qu'a prit la souris pour trouver la sortie du labyrinthe.
     */
    protected int temps;
    
     /**
     * Constructeur de la classe Labyrinthe. determine la population visee par le test et son nom.
     */
    public Labyrinthe(){
    nom = "Labyrinthe";
    pop_visee = "souris 1";
    } //l'utilisateur donne le temps qu'a mis la souris
    
     /**
     * Retourne le temps qu'a prit la souris pour sortir du labyrinthe.
     * @return temps pour resoudre le labyrinthe.
     */
    public int getTemps(){return temps;}
	
     /**
     * Retourne la population visee par ce test.
     * @return la population visee.
     */
    public String getPopVisee(){return pop_visee;}

     /**
     * Fonction permettant a l'utilisateur d'entrer les donnees associee a un animal ayant fait ce test.
     * Verifie que le temps de resolution est superieure a 0.
     */
    public void saisie_utilisateur()
	{
	    System.out.println("Temps ?");
	    boolean x = true;
	    int t;
	    while(x){
		t=Gestion.saisie_num();
		if(t > 0){ 
		    temps=t;
		    x = false;
		} else {
		    System.out.println("Time must be over 0... your mouse can't teleport, nor can it reach the end before the test begins !");
		}
	    }
	}
	    
	

}
