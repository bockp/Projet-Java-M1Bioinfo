/**
 * La classe Nourriture represente un des tests disponibles.
 * 
 * elle ne s'applique qu'au groupe 2 des souris, et est une extension de la classe Test.
 * @see Test
 *
 * PRINCIPE :
 *
 * Dans un espace clos, on positionne 5 cachettes et dans l’une d’entre elles on met de la nourriture. 
 * On note si la souris est capable de trouver la cachette et après combien de visites des cachettes. 
 * Si au bout d’un certain temps prédéfini, elle n’a pas trouvé on considère que c’est un échec.
 *
 * @author Peter Bock, Cecilia Ostertag
 */


public class Nourriture extends Test {
     
     /**
     * Le nombre d'echec de la souris avant de trouver la cachette.
     */
    protected int nb_echecs;
     /**
     * Boolean indiquant si le test est une reussite (True) ou un echec (False).
     */
    protected boolean reussite = false;
     /**
     * Constructeur de la classe Nourriture. determine la population visee par le test et son nom.
     */
    public Nourriture(){
	nom = "Nourriture";
	pop_visee = "souris 2";
    } //l'utilisateur donne le nb d'echecs et dit si la souris a reussi ou non (a faire dans Gestion)pour ce test

     /**
     * Retourne le nombre d'echecs de la souris au test en cours.
     * @return nombre d'echecs de la souri.
     */
    public int getNbEchecs(){return nb_echecs;}
	
     /**
     * Retourne le boolean indiquant la reussite ou l'echec du test.
     * @return un boolean. true pour reussite, false pour echec.
     */
    public boolean getReussite() {return reussite;}
	
     /**
     * Retourne la population visee par ce test
     * @return un string indiquant quels animaux sont concernee par le test.
     */
    public String getPopVisee(){return pop_visee;}
    
     /**
     * Fonction permettant a l'utilisateur d'entrer les donnees associee a un animal ayant fait ce test.
     * Verifie que le nombre d'echec est bien superieur a 0.
     * Demande a l'utilisateur si le test est reussit (la souris a trouvee la cachette a temps) ou non.
     */	
    public void saisie_utilisateur()
    {
	boolean x = true;
	System.out.println("Nombre d'echecs ? ");
	int nb = -1;
	while (x){
	    nb = Gestion.saisie_num();
	    if(nb >= 0){ // saisie correctement, sinon recommence le saisie.
		x = false; //
	    }
	    else {
		System.out.println("Erreur, veuillez retaper le nombre d'echecs.");
	    }
	}
	x = true;

	nb_echecs=nb;
	System.out.println("Taper x si le test est reussi : ");
	String resultat = Gestion.saisie_chaine();
	if (resultat == "x")
	    reussite=true;
    }
}
