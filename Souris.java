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
	    buff.write("Id: "+ id + "\n");
	    buff.write("Espece: "+ espece + "\n");
	    buff.write("groupe: "+ groupe + "\n");
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
    

