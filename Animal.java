import java.io.*;
import java.util.*;

abstract class Animal
{
    public int nb_animaux=0;
    
    protected final int id;
    protected final String sexe;
    protected String espece;
    protected String pop;
    protected float poids_debut_semaine;
    protected float poids;
    protected String statut = "vivant"; // vivant ou mort
    protected int progression = 0; // en pourcentage
    protected String etat = "normal"; // normal, fatigue, ou stress
    protected int meilleure_performance; //jour de la meilleur performance

    public Animal(String sexe,float poids)
    {
	this.sexe = sexe;
	this.poids = poids;
	nb_animaux++;
	this.id=nb_animaux;
    }

    public int getId() {return id;}
    public String getSexe() {return sexe;}
    public String getEspece() {return espece;}
    public String getPop() {return pop;}
    public float getPoids() {return poids;}
    public String getStatut() {return statut;}
    public int getProgression() {return progression;}
    public String getEtat() {return etat;}
    public int getMeilleurePerformance() {return meilleure_performance;}
    
    public void setPoids(float poids)
    {
	this.poids=poids;
    }
    public void setPoidsDebutSemaine(float poids)
    {
	this.poids_debut_semaine=poids;
    }
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
    public void setProgression(int nombre)
    {
	this.progression=nombre;
    }
	
    public void mort()
    {
	this.statut="mort";
    }

    public void setMeilleurePerformance(int jour) //verif dans le main
    {
	this.meilleure_performance=jour;
    }

    public void afficher_infos()
    {
	System.out.println("Espece: "+espece);
	System.out.println("Id: "+id);
	System.out.println("Sexe: "+sexe);
	System.out.println("Poids: "+poids);
	System.out.println("Statut: "+statut);
	System.out.println("Progression: "+progression);
	System.out.println("Etat: "+etat);
	System.out.println();
    }

    public void sauvegarder() throws IOException
    {
	BufferedWriter buff = new BufferedWriter(new FileWriter("resultat.txt"));
	buff.write("Espece: "+espece);
	buff.write("Id: "+id);
	buff.write("Sexe: "+sexe);
	buff.write("Poids: "+poids);
	buff.write("Statut: "+statut);
	buff.write("Progression: "+progression);
	buff.write("Etat: "+etat);
	buff.write("Jour de la meilleure performance: "+meilleure_performance);
	buff.newLine();
    }
	
}
