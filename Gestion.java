import java.io.*;
import java.util.*;

public class Gestion
{

    public static int saisie_num()
    {	
	try{
	    BufferedReader buff = new BufferedReader (new InputStreamReader(System.in));
	    String chaine=buff.readLine();
	    int num = Integer.parseInt(chaine);
	    return num;
	}
	catch(IOException e) {return 0;}
    }

    public static float saisie_float()
    {	
	try{
	    BufferedReader buff = new BufferedReader (new InputStreamReader(System.in));
	    String chaine=buff.readLine();
	    float f = Float.parseFloat(chaine);
	    return f;
	}
	catch(IOException e) {return 0;}
    }
    
    /**
	   Saisie d'une chaine de caracteres
	**/

    public static String saisie_chaine()
    {
	
	try{
	    BufferedReader buff = new BufferedReader (new InputStreamReader(System.in)); // on atteint buffreader a partir de sys.in
	    String chaine=buff.readLine();
	    return chaine;
	}
	catch(IOException e) {System.out.println(" impossible"+e);
	    return null;
	}
    }

    public static void main(String[] argv)
    {
	ArrayList animaux = new ArrayList();
	ArrayList<String> especes = new ArrayList<String>();
    especes.add("singe");
    especes.add("souris");
//arraylist especes definie dans protocole (protocole.getEspeces())

    Hashtable tests_dispos = new Hashtable();
    tests_dispos.put("Souris 1", new ArrayList<String>(Arrays.asList("Labyrinthe")));
    tests_dispos.put("Souris 2", new ArrayList<String>(Arrays.asList("Nourriture")));
    tests_dispos.put("Singe", new ArrayList<String>(Arrays.asList("Image")));

    List<String> semaine = Arrays.asList("Lundi","Mardi","Mercredi","Jeudi","Vendredi");
    int jour = 0;

    saisie_animaux(animaux,especes);

    for(Iterator<String> e = semaine.iterator();e.hasNext();)
	{
	    System.out.println("Nouveau jour");
	    saisie_resultats(animaux, tests_dispos, semaine, jour);
	}
    System.out.println("Fin de la semaine");

    }
	    
	
    public static int saisie_resultats(ArrayList animaux, Hashtable ht, List<String> semaine, int jour)
	{
	    for (int i=0;i<animaux.size();i++)
		{
			Animal animal = (Animal)animaux.get(i);
			System.out.println("Donnez le poids de l'animal:");
			float poids = saisie_float();
			animal.setPoids(poids);
			ArrayList<String> tests = trouver_tests(animal, ht);
			for (String test : tests)
			    {
				switch (test)
				    {
				    case "Labyrinthe":
					{
					    Labyrinthe lab = new Labyrinthe();
					    lab.saisie_utilisateur();
					    break;
					}
				    case "Nourriture":
					{
					    Nourriture nour = new Nourriture();
					    nour.saisie_utilisateur();
					    break;
					}
				    case "Image":
					{
					    Image img = new Image();
					    img.saisie_utilisateur();
					    break;
					}
				    }
			    }
			if (semaine.get(jour) == semaine.get(0))
			    animal.setPoidsDebutSemaine(poids);
	
		}
	    jour++;
	    return jour;
	}

    public static ArrayList<String> trouver_tests(Animal animal, Hashtable ht)
    {
	Enumeration pops = ht.keys();
	ArrayList<String> tests = new ArrayList<String>();
	while(pops.hasMoreElements())
	    {
		String pop = (String)pops.nextElement();
		if (pop == animal.getPop())
		    tests = (ArrayList<String>)ht.get(pop);
	    }
	return tests;
    }
		

    public static void saisie_animaux(ArrayList animaux, ArrayList especes)
    {
	
	for (int i=0;i<especes.size();i++)
	    {
		String espece = (String)especes.get(i);
		saisie_animaux_type(animaux,espece);
	    }
		
    }

    public static void saisie_animaux_type(ArrayList animaux, String espece)
    {
	System.out.println("Nombre d'animaux de type "+espece+" a saisir ?");
		int nb = saisie_num();
		for (int i=0;i<nb;i++)
		    {
			System.out.println();

			System.out.println("Sexe ?");
			String sexe = saisie_chaine();
			System.out.println("Poids ?");
			float poids = saisie_float();
			switch (espece) // a modifier si ajout d'autres especes
			    {
			    case "souris": 
				{
				    System.out.println("Groupe ?");
				    int groupe = saisie_num();
				    System.out.println();
				    Souris souris = new Souris(sexe, poids, groupe);
				    animaux.add(souris);
				    break;
				}
			    case "singe":
				{
				    System.out.println();
				    Singe singe = new Singe(sexe, poids);
				    animaux.add(singe);
				    break;
				}
			    }
		    }
    }
	
    
}
