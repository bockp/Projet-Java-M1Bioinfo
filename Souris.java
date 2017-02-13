import java.io.*;
public class Souris extends Animal
{
    private final int groupe;
    
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

    public void afficher_infos()
    {
    	super.afficher_infos();
	System.out.println("Groupe: "+groupe);
    }

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
    

