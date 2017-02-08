import java.util.*;

public class Protocol extends ArrayList{
    List<String> semaine = Arrays.asList("Lundi","Mardi","Mercredi","Jeudi","Vendredi");

    // objets de bases pour chaque test dans le protocol, permettant l'access
    // au conditions d'applications des tests.
    Labyrinthe lab = new Labyrinthe();
    Image img = new Image();
    Nourriture nourri = new Nourriture();

    List<Test> protocol = Arrays.asList(lab,img,nourri);


    public void experience(ArrayList animaux){
	String jour;
	int indexJournalier;
	for(Iterator<String> e = semaine.iterator();e.hasNext();){
	    jour = e.next();
	    indexJournalier = semaine.indexOf(jour);
	    for(Iterator<Animal> anm = animaux.iterator();anm.hasNext();){
		Animal animal = anm.next();
		int animalId = anm.getId();
		System.out.println("Donnez le poids de l'animal:");
		if(semaine[0] == jour){
		    animal.setPoidsDebutSemaine();
		}
		
		
	    }
	}
    }
}
