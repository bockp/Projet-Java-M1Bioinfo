/**
 * La classe Image represente un des tests disponibles.
 * elle ne s'applique que aux singes, et est une extension de la classe Test.
 * @see Test
 *
 * @author Peter Bock, Cecilia Ostertag
 */

public class Image extends Test {
     /**
     * Le nombre d'echec maximale admit, au dessus le test est considere comme un echec.
     */
    protected int nb_max=8;
     /**
     * Le nombre d'echec qu'a fait le singe durant l'experience en cours.
     */
    protected int nb_echecs;
     /**
     * Boolean indiquant si le test est une reussite (True) ou un echec (False).
     */
    protected boolean reussite;
    
	
     /**
     * Constructeur de la classe Image. determine la population visee par le test et son nom.
     */
    public Image(){
    nom = "Image";
    pop_visee = "singe";
    } //l'utilisateur donne le nb d'echecs pour ce test

     /**
     * Retourne le nombre d'echecs du singe au test en cours.
     * @return nombre d'echecs du singe.
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
     * L'experience de ce test est fait 5 fois durant le test,
     * et la moyenne des echecs permet de determiner si le test est reussit ou non.
     */
    public void saisie_utilisateur() // repete 5x l'experience
	{
          for (int i=0;i<5;i++) 
                {
		    boolean x = true;
		    System.out.println("Nombre d'echecs ? (exp:"+(i+1)+")");
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
                    nb_echecs+=nb;
                }
	    nb_echecs=nb_echecs/5;
             if (nb_echecs > nb_max)
                reussite=true;
             else
                reussite=false;

	}
}
