import java.io.*;
import java.util.*;

abstract class Animal
{
    public static int nb_animaux=0;
    
    protected int id;
    protected final String sexe;
    protected String espece;
    protected String pop;
    protected float poids_debut_semaine;
    protected float poids;
    protected String statut = "vivant"; // vivant ou mort
    protected int resultat;
    protected int progression = 0; // en pourcentage
    protected String etat = "normal"; // normal, fatigue, ou stress
    protected int meilleure_performance; //jour de la meilleur performance

    public Animal(String sexe,float poids)
    {
	this.sexe = sexe;
	this.poids = poids;
	this.nb_animaux++;
	this.id=nb_animaux;
    }

    public int getId() {return id;}
    public String getSexe() {return sexe;}
    public String getEspece() {return espece;}
    public String getPop() {return pop;}
    public float getPoids() {return poids;}
    public String getStatut() {return statut;}
    public int getResultat() {return resultat;}
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
    public void setResultat(int nombre)
    {
	this.resultat=nombre;
    }

    public void setProgression(int nombre)
    {
	this.progression=(int)(((resultat-nombre)/nombre)*100);
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

    public void sauvegarder(String filename)
    {
	try{
	    BufferedWriter buff = new BufferedWriter(new FileWriter(filename, true));
	    buff.write("Id: "+ id + "\n");
	    buff.write("Espece: "+ espece + "\n");
	    buff.write("Sexe: "+ sexe + "\n");
	    buff.write("Poids: "+ poids + "\n");
	    buff.write("Statut: "+ statut + "\n");
	    buff.write("Progression: "+ progression + "\n");
	    buff.write("Etat: "+ etat + "\n");
	    buff.write("Jour de la meilleure performance: "+ meilleure_performance + "\n");
	    buff.newLine();
	    buff.close();
	}
	catch(IOException e) {System.out.println("Erreur de sauvegarde: "+ e);}
    }
}
