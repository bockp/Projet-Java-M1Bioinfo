import java.io.*;
import java.util.*;
import java.util.regex.*;

//vider les fichiers avant execution du programme, recuperer donnees, afficher meilleur apprentissage (tous, et singe/souris), afficher si perfs associees au stress
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
	Protocole protocole = new Protocole(); //possibilit de creeer plusieurs protocoles, si on rajoute des parametres dans le constructeur
	ArrayList animaux_init = new ArrayList();
        ArrayList animaux = new ArrayList();
	int jour = 0;
	
	ArrayList<String> especes = protocole.getEspeces();
	Hashtable tests_dispos = protocole.getTestsDispos();
	List<String> semaine = protocole.getSemaine();

	
	
        boolean stop = false;
        while(stop == false)
            {
                int choix = menu();
                switch (choix)
                    {
                    case 0 :
                        {
                            System.out.println("Au revoir\n");
                            stop = true;
                            break;
                        }
                    case 1 :
                        {
			    erase("Animaux.txt");
                            saisie_animaux(animaux_init,especes);
                            animaux=new ArrayList(animaux_init);
                            break;
                        }
                    case 2 :
                        {
			    if (! animaux.isEmpty())
                                saisie_resultats_semaine(animaux, tests_dispos, semaine, jour);
                            else
                                System.out.println("Erreur, vous devez d'abord saisir des animaux.\n");
                            break;
                        }
                    case 3 :
                        {
                            if (! animaux_init.isEmpty())
                                afficher_animaux(animaux_init);
                            else
                                System.out.println("Erreur, vous devez d'abord saisir des animaux.\n");
                            break;
                        }
                    case 4 :
                        {
                            if (! animaux_init.isEmpty())
                                afficher_apprentissage(animaux_init);
                            else
                                System.out.println("Erreur, vous devez d'abord saisir des animaux.\n");
                            break;
                        }
                    case 5 :
                        {
                            if (! animaux_init.isEmpty())
                                afficher_meilleure_performance(animaux_init);
                            else
                                System.out.println("Erreur, vous devez d'abord saisir des animaux.\n");
                            break;
                        }
			//case 6 :
			//	{
			//	    loads file data into animaux.txt, and that's it.
			//	}

                    }
            }
    }
    
    public static void saisie_resultats_semaine(ArrayList animaux, Hashtable tests_dispos, List<String> semaine, int jour)
    {
	
        for(Iterator<String> e = semaine.iterator();e.hasNext();)
	    {
		String nomJour = e.next();
		System.out.println(nomJour.toUpperCase() + "\n");
		File fichierJour = new File(nomJour + ".txt");
		boolean exists = fichierJour.exists();
		boolean loaded = false;
		boolean x = exists;
		String choix = "\\<0>//";
		while(x)
		    {
			System.out.println("Voulez-vous charger les données existants ? ");
			choix = saisie_chaine();
			if (choix.equals("Y") || choix.equals("N"))
			    {
				x = false;
			    }
			else
			    {
				System.out.println("Y or N only.\n");
			    }
		    }

		
		if(choix.equals("Y")){
		    jour += 1;
		    loadAnimalData(animaux,nomJour);
		    loaded = true;
				      
		}
		else
		    {
			erase(nomJour+".txt");
		    }
		
		
		
		if(!loaded && animaux.size() != 0)
		    {
			jour = saisie_resultats(animaux, tests_dispos, semaine, jour);
		    }
		if (animaux.size() == 0)
		    {
			System.out.println("Il ne reste aucun animal vivant, fin de l'experience");
			break;
		    }
	    }
	System.out.println("Fin de la semaine");
    }
    
    public static int saisie_resultats(ArrayList animaux, Hashtable ht, List<String> semaine, int jour)
    {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
	for (int i=0;i<animaux.size();i++)
	    {
		boolean x = true;
		
		Animal animal = (Animal)animaux.get(i);
                int index = animaux.indexOf(animal);
		System.out.println("Taper x si l'animal "+animal.getId()+"  est mort");
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
			int resultat_precedent = animal.getResultat();
                        int meilleur_resultat = animal.getMeilleurResultat();
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
			// partie a modifier si changement de protocole.
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
                            {
                            animal.setEtat();
			    animal.setProgression(resultat_precedent);
                            if (resultat < meilleur_resultat) //meilleur temps ou moins d'erreurs
                                {
                                    animal.setMeilleurResultat(resultat);
                                    animal.setMeilleurePerformance(semaine.get(jour));
                                }
                            }
			System.out.println();
			animal.sauvegarder(semaine.get(jour) + ".txt");
		    }
		else
                    {
                        animal.mort();
                        animal.sauvegarder(semaine.get(jour)+".txt");
                        indexes.add(index);
                    }
		
	    }
	jour++;
        for (int index : indexes)
            {
		try {
		    animaux.remove(index);
		}
		catch (IndexOutOfBoundsException e){
		    index-=1;
		    animaux.remove(index);
		}
            }
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
			    souris.sauvegarder("Animaux.txt");
			    break;
			}
		    case "singe":
			{
			    System.out.println();
			    Singe singe = new Singe(sexe, poids);
			    animaux.add(singe);
			    singe.sauvegarder("Animaux.txt");
			    break;
			}
		    }
	    }
    }

    public static void afficher_animaux(ArrayList animaux)
    {
        for (int i=0;i<animaux.size();i++)
            {
                Animal animal = (Animal)animaux.get(i);
                animal.afficher_infos();
            }
    }

    public static void afficher_apprentissage(ArrayList animaux)
    {
        for (int i=0;i<animaux.size();i++)
            {
                Animal animal = (Animal)animaux.get(i);
                System.out.println("Animal "+animal.getId()+" :\n");
                System.out.println("Apprentissage: "+animal.getProgression());
            }
    }

    public static void afficher_meilleure_performance(ArrayList animaux)
    {
        for (int i=0;i<animaux.size();i++)
            {
                Animal animal = (Animal)animaux.get(i);
                System.out.println("Animal "+animal.getId()+" :");
                System.out.println("Meilleure performance le: "+animal.getMeilleurePerformance());
                System.out.println();
            }
    }    
    
    public static int menu()
    {
        System.out.println("**MENU**\n\nSaisir les animaux: 1\nSaisir les donnees: 2\nAfficher la liste d'animaux: 3\nAfficher l'apprentissage des animaux: 4\nAfficher le jour de la meilleure performance des animaux: 5\nQuitter: 0\n");
        int choix = saisie_num();
        return choix;
    }
    
    // function of the Apocalypse.
    public static void erase(String file){
	try{
	    PrintWriter writer = new PrintWriter(file); // Opens the file to Write, which deletes it's content.
	    writer.close();
	}
	catch(FileNotFoundException e) {;} 
    }

    // fonction de chargement des données d'une journée
    public static void loadAnimalData(ArrayList animaux, String nom)
    {
	try {
	    BufferedReader lecteurDonnee = new BufferedReader(new FileReader(nom+".txt"));
	    String ligne;
	    String sexe;
	    float poids;
	    String statut;
	    String meilPerfor;
	    int progression;
	    int groupe;
	    int res;
	    int meilRes;
	    float poidsDebutSem;
	    
	   
	    while( (ligne = lecteurDonnee.readLine()) != null)
		{
		    Pattern formatSinge = Pattern.compile("Id:(\\S+) Espece:(\\S+) Sexe:(\\S) Poids:(\\S+) Statut:(\\S+) Progression:(\\S+) Etat:(\\S+) Jour_de_la_meilleure_performance:(\\S+) Resultat:(\\S+) Meilleur_resultat:(\\S+) Poids_debut_semaine:(\\S+)");
		    Pattern formatSouris = Pattern.compile("Id:(\\S+) Espece:(\\S+) groupe:(\\S+) Sexe:(\\S+) Poids:(\\S+) Statut:(\\S+) Progression:(\\S+) Etat:(\\S+) Jour_de_la_meilleure_performance:(\\S+) Resultat:(\\S+) Meilleur_resultat:(\\S+) Poids_debut_semaine:(\\S+)");



		    
		    Matcher singe = formatSinge.matcher(ligne);
		    Matcher souris = formatSouris.matcher(ligne);


		    // inserer un pattern, matcher, et if pour chaque nouvelle espece.
		    
		    if(singe.find())
			{
			    sexe = singe.group(3);
			    poids = Float.valueOf(singe.group(4));
			    statut = singe.group(5);
			    progression = Integer.valueOf(singe.group(6));
			    
			    meilPerfor = singe.group(8);
			    res = Integer.valueOf(singe.group(9));
			    meilRes = Integer.valueOf(singe.group(10));
			    poidsDebutSem = Float.valueOf(singe.group(11));
			    for (int i=0;i<animaux.size();i++)
				{
				    Animal monkey = (Animal)animaux.get(i);
				    if(monkey.getId() == Integer.valueOf(singe.group(1))){
					monkey.setProgressionDirect(progression);
					monkey.setMeilleurePerformance(meilPerfor); // set rest of information, then add to anim
					monkey.setPoidsDebutSemaine(poidsDebutSem);
					monkey.setEtat();
					if(statut.equals("mort"))
					    {
						monkey.mort();
					    }
					monkey.setResultat(res);
					monkey.setMeilleurResultat(meilRes);
				    }
				} 
			    


			    
			    
			    
			    
			}
		    if(souris.find())
			{
			    
			    groupe = Integer.valueOf(souris.group(3));
			    sexe = souris.group(4);
			    poids = Float.valueOf(souris.group(5));
			    statut = souris.group(6);
			    progression = Integer.valueOf(souris.group(7));
			    
			    meilPerfor = souris.group(9);
			    res = Integer.valueOf(souris.group(10));
			    meilRes = Integer.valueOf(souris.group(11));
			    poidsDebutSem = Float.valueOf(souris.group(12));

			    for (int i=0;i<animaux.size();i++)
				{
				    Animal mouse = (Animal)animaux.get(i);
				    if(mouse.getId() == Integer.valueOf(souris.group(1))){
					mouse.setProgressionDirect(progression);
					mouse.setMeilleurePerformance(meilPerfor); // set rest of information, then add to anim
					mouse.setPoidsDebutSemaine(poidsDebutSem);
					mouse.setEtat();
					if(statut.equals("mort"))
					    {
						mouse.mort();
					    }
					mouse.setResultat(res);
					mouse.setMeilleurResultat(meilRes);				    }
				} 
			    
			    
			    
			}
		}
	}
	catch(FileNotFoundException e){System.out.println("Erreur, le fichier existe-t-il vraiment ?");}
	catch(IOException e){System.out.println("Erreur: "+ e);}

    }
}


// create menu option to load data from animal file to .txt + create script. if they create a new animal list, delete ALL day .txts
