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
	catch(IOException e) {return -1;}
	catch(NumberFormatException a) {return -1;}
    }

    public static float saisie_float()
    {	
	try{
	    BufferedReader buff = new BufferedReader (new InputStreamReader(System.in));
	    String chaine=buff.readLine();
	    float f = Float.parseFloat(chaine);
	    return f;
	}
	catch(IOException e) {return -1;}
	catch(NumberFormatException a) {return -1;}
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
	catch(IOException e) {
	    System.out.println(" impossible"+e);
	    return null;
	}
    }

    public static void main(String[] argv)
    {
	Protocole protocole = new Protocole(); //possibilité de crééer plusieurs protocoles, si on rajoute des paramètres dans le constructeur
	ArrayList animaux = new ArrayList();
	int jour = 0;
	
	ArrayList<String> especes = protocole.getEspeces();
	Hashtable tests_dispos = protocole.getTestsDispos();
	List<String> semaine = protocole.getSemaine();

	saisie_animaux(animaux,especes);

	for(Iterator<String> e = semaine.iterator();e.hasNext();)
	    {
		String nomJour = e.next();
		System.out.println(nomJour);
		
		jour = saisie_resultats(animaux, tests_dispos, semaine, jour);
		//sauvegarde_resultats
	    }
	System.out.println("Fin de la semaine");
	
    }
	    
	
    public static int saisie_resultats(ArrayList animaux, Hashtable ht, List<String> semaine, int jour)
    {
	for (int i=0;i<animaux.size();i++)
	    {
		boolean x = true;
		
		Animal animal = (Animal)animaux.get(i);
		System.out.println("Taper x si l'animal est mort");
		String reponse = "\\^^//";
		while (x){
		    reponse = saisie_chaine();  // 
		    if(!( reponse == null)){ //
			x = false; //
		    }
		    else {
			System.out.println("\nErreur. veuillez retaper la reponse.\n");
		    }
		}
		x = true;
		
		if (!(reponse.equals("x")))
		    {
			int resultat_courant = animal.getResultat();
			int resultat = 0;
			System.out.println("Donnez le poids de l'animal "+animal.getId()+" :");
			float poids = -1;
			while (x){
			    poids = saisie_float();  // test si le poids a ete
			    if(poids > 0){ // saisie correctement, sinon recommence le saisie.
				x = false; //
			    }
			    else {
				System.out.println("Erreur, veuillez retaper le poids.");
			    }
			}
			x = true;
			
			animal.setPoids(poids);
			ArrayList<String> tests = trouver_tests(animal, ht);
			// partie a modifier si changement de protocol.
			for (String test : tests)
			    {
				switch (test)
				    {
				    case "Labyrinthe":
					{
					    Labyrinthe lab = new Labyrinthe();
					    lab.saisie_utilisateur();
					    resultat=lab.getTemps();
					    break;
					}
				    case "Nourriture":
					{
					    Nourriture nour = new Nourriture();
					    nour.saisie_utilisateur();
					    resultat=nour.getNbEchecs();
					    break;
					}
				    case "Image":
					{
					    Image img = new Image();
					    img.saisie_utilisateur();
					    resultat=img.getNbEchecs();
					    break;
					}
				    //case "nvx test":
					//{
					    //nvx_test tst = new nvx_test();
					    //...
					    //break;
					//}
				    }
				
			    }
			animal.setResultat(resultat);
			if (semaine.get(jour) == semaine.get(0))
			    animal.setPoidsDebutSemaine(poids);
			else
			    animal.setProgression(resultat_courant);
			System.out.println();
			animal.sauvegarder(semaine.get(jour) + ".txt");
		    }
		//else
		//retirer animal de laliste
		
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
	boolean x = true;
	
	System.out.println("Nombre d'animaux de type "+espece+" a saisir ?");
	int nb = -1;
	while(x){
	    nb = saisie_num();
	    if(nb > 0){
		x = false;
	    } else {
		System.out.println("\nErreur, veuillez saisir a nouveau le nombre d'animaux:\n");
	    }
	}
	
	for (int i=0;i<nb;i++)
	    {
		x = true;
		System.out.println();
		String sexe = "\\o//";
		System.out.println("Sexe(M/F) ?");
		while (x){
		    sexe = saisie_chaine();
		    if((sexe.equals("M") || sexe.equals("F"))) { // saisie correcte, sinon recommence le saisie.
			x = false;
		    }
		    else {
			System.out.println("Erreur, veuillez retaper le sexe de l'animal.");
		    }
		}
		x = true;


		System.out.println("Poids ?");
		float poids = -1;
		while (x){
		    poids = saisie_float();  // test si le poids a ete
		    if(poids > 0){ // saisie correctement, sinon recommence le saisie.
			x = false; //
		    }
		    else {
			System.out.println("Erreur, veuillez retaper le poids.");
		    }
		}
		
		
		switch (espece) // liste espece a modifier si ajout de nouveaux especes
		    {
		    case "souris": 
			{
			    x = true;
			    System.out.println("Groupe ?");
			    int groupe = -1;
			    while (x){
				groupe = saisie_num();
				if(groupe > 0){ // saisie correctement, sinon recommence le saisie.
				    x = false; //
				}
				else {
				    System.out.println("Erreur, veuillez retaper le numero de groupe.");
				}
			    }
			    
			    
			    System.out.println();
			    Souris souris = new Souris(sexe, poids, groupe);
			    animaux.add(souris);
			    souris.sauvegarder("Animals.txt");
			    break;
			}
		    case "singe":
			{
			    System.out.println();
			    Singe singe = new Singe(sexe, poids);
			    animaux.add(singe);
			    singe.sauvegarder("Animals.txt");
			    break;
			}
		    }
	    }
    }
	
    
}
