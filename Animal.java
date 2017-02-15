import java.io.*;
import java.util.*;

/**
 * Animal est la classe representant un animal du laboratoire.
 * @see Souris
 * @see Singe
 * @author Peter Bock, Cecilia Ostertag
 */

public abstract class Animal
{
    /**
     * Le nombre d'animaux. Ce nombre est incremente a chaque appel au constructeur de la classe.
     * @see Animal#Animal(String, float)
     */
    private static int nb_animaux=0;

    /**
     * L'identifiant de l'animal. Cet id n'est pas modifiable.
     * @see Animal#Animal(String, float)
     * @see Animal#getId()
     */
    protected final int id;

    /**
     * Le sexe de l'animal (M ou F). Il n'est pas modifiable.
     * @see Animal#Animal(String, float)
     * @see Animal#getSexe()
     */
    protected final String sexe;

    /**
     * L'espece a laquelle appartient l'animal.
     * @see Animal#Animal(String, float)
     * @see Animal#getEspece()
     */
    protected String espece;

    /**
     * La population a laquelle appartient l'animal.
     * @see Animal#Animal(String, float)
     * @see Animal#getPop()
     */
    protected String pop;

    /**
     * Le poids de l'animal au debut de la semaine.
     * @see Animal#Animal(String, float)
     * @see Animal#setPoidsDebutSemaine(float)
     */
    protected float poids_debut_semaine;

    /**
     * Le poids de l'animal.
     * @see Animal#Animal(String, float)
     * @see Animal#getPoids()
     * @see Animal#setPoids(float)
     */
    protected float poids;

    /**
     * Le statut de l'animal (vivant ou mort).
     * @see Animal#Animal(String, float)
     * @see Animal#getStatut()
     * @see Animal#mort()
     */
    protected String statut = "vivant";

    /**
     * Le resultat journalier de chaque animal.
     * @see Animal#Animal(String, float)
     * @see Animal#getResultat()
     * @see Animal#setResultat(int)
     */
    protected int resultat;

    /**
     * La progression (ou taux d'apprentissage) de l'animal, en pourcentage.
     * @see Animal#Animal(String, float)
     * @see Animal#getProgression()
     * @see Animal#setProgression(int)
     * @see Animal#setProgressionDirect(int)
     */
    protected int progression = 0;

    /**
     * L'etat de stress de l'animal (normal, stres, ou fatigue).
     * @see Animal#Animal(String, float)
     * @see Animal#getEtat()
     * @see Animal#setEtat()
     */
    protected String etat = "normal";

    /**
     * Le meilleur resultat de l'animal jusqu'a un jour donne. 
     * Il est initialise a une valeur tres grande, pour servir de recherche de minimum.
     * @see Animal#Animal(String, float)
     * @see Animal#getMeilleurResultat()
     * @see Animal#setMeilleurResultat(int)
     */
    protected int meilleur_resultat = 10000000;

    /**
     * Le jour de la meilleure performance de l'animal jusqu'a un jour donne.
     * @see Animal#Animal(String, float)
     * @see Animal#getMeilleurePerformance()
     * @see Animal#setMeilleurePerformance(String)
     */
    protected String meilleure_performance = "\\";
    
    /**
     * Constructeur de la classe Animal. Affecte automatiquement un identifiant a l'animal.
     * @param sexe : sexe de l'animal
     * @param poids : poids de l'animal
     */
    public Animal(String sexe,float poids)
    {
	this.sexe = sexe;
	this.poids = poids;
	this.nb_animaux++;
	this.id=nb_animaux;
    }

    /**
     * Retourne l'id de l'animal.
     * @return id de l'animal
     */
    public int getId() {return id;}

    /**
     * Retourne le sexe de l'animal.
     * @return sexe de l'animal
     */
    public String getSexe() {return sexe;}

    /**
     * Retourne l'espece de l'animal.
     * @return espece de l'animal
     */
    public String getEspece() {return espece;}

    /**
     * Retourne la population de l'animal.
     * @return population de l'animal
     */
    public String getPop() {return pop;}

    /**
     * Retourne le poids de l'animal.
     * @return poids de l'animal
     */
    public float getPoids() {return poids;}

    /**
     * Retourne le statut de l'animal.
     * @return statut de l'animal
     */
    public String getStatut() {return statut;}

    /**
     * Retourne le resultat de l'animal.
     * @return resultat de l'animal
     */
    public int getResultat() {return resultat;}

    /**
     * Retourne la progression de l'animal.
     * @return progression de l'animal
     */
    public int getProgression() {return progression;}

    /**
     * Retourne l'etat de l'animal.
     * @return etat de l'animal
     */
    public String getEtat() {return etat;}

    /**
     * Retourne le meilleur resultat de l'animal.
     * @return meilleur resultat de l'animal
     */
    public int getMeilleurResultat() {return meilleur_resultat;}

    /**
     * Retourne le jour de la meilleure performance de l'animal.
     * @return jour de la meilleure performance de l'animal
     */
    public String getMeilleurePerformance() {return meilleure_performance;}

    /**
     * Modifie le poids de l'animal
     * @param poids : le poids courant
     */
    public void setPoids(float poids)
    {
	this.poids=poids;
    }

    /**
     * Modifie le poids de l'animal au debut de la semaine
     * @param poids : le poids courant
     */
    public void setPoidsDebutSemaine(float poids)
    {
	this.poids_debut_semaine=poids;
    }

    /**
     * Modifie l'etat de l'animal
     */
    public void setEtat()
    {
	if (this.poids < this.poids_debut_semaine)
	    {
		this.etat="stress";
	    }
	if (this.poids < 10*((this.poids*100)/this.poids_debut_semaine))
	    {
		this.etat="fatigue";
	    }
    }

    /**
     * Modifie le resultat de l'animal
     * @param nombre : le resultat courant
     */
    public void setResultat(int nombre)
    {
	this.resultat=nombre;
    }

    /**
     * Modifie la progression de l'animal
     * @param nombre : le resultat precedent
     */
    public void setProgression(int nombre)
    {
	this.progression=(int)Math.abs((((resultat-nombre)*100)/Math.abs(nombre)));
    }

    /**
     * Modifie la progression de l'animal, a partir d'un fichier de donnees.
     * @param nombre : la valeur de progression enregistreee dans le fichier correspndant
     */
    public void setProgressionDirect(int nombre)
    {
	this.progression=nombre;
    }

    /**
     * Fait passer le statut de l'animal de vivant a mort, pour qu'il ne soit plus comptabilise dans l'etude.
     */
    public void mort()
    {
	this.statut="mort";
    }

    /**
     * Actualise le meilleur resultat de l'animal.
     * @param nombre : le resultat courant
     */
    public void setMeilleurResultat(int nombre)
    {
        this.meilleur_resultat=nombre;
    }

    /**
     * Actualise le jour de la meilleure performance de l'animal.
     * @param jour : le jour courant
     */
    public void setMeilleurePerformance(String jour) 
    {
	this.meilleure_performance=jour;
    }

    /**
     * Affiche les informations concernant l'animal.
     */
    public void afficher_infos()
    {
	System.out.println();
	System.out.println("Espece: "+espece);
	System.out.println("Id: "+id);
	System.out.println("Sexe: "+sexe);
	System.out.println("Poids: "+poids);
	System.out.println("Statut: "+statut);
	System.out.println("Progression: "+progression);
	System.out.println("Etat: "+etat);
    }

    /**
     * Enregistre les informations concernant l'animal, dans un fichier texte.
     * @param filename : le nom du fichier txt
     */
    public void sauvegarder(String filename)
    {
	try{
	    BufferedWriter buff = new BufferedWriter(new FileWriter(filename, true));
	    buff.write("Id:"+ id + " ");
	    buff.write("Espece:"+ espece + " ");
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

    /**
     * Supprime les identifiants des animaux existants
     */
    public void resetIDs(){nb_animaux = 0;}
}
