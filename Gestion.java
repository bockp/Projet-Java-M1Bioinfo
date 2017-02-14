import java.io.*;
import java.util.*;
import java.util.regex.*;

//vider les fichiers avant execution du programme, recuperer donnees, afficher meilleur apprentissage (tous, et singe/souris), afficher si perfs associees au stress
public class Gestion
{

    public static int saisie_num() //
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

    public static float saisie_float() //
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

    public static String saisie_chaine() //
    {
	
	try{
	    BufferedReader buff = new BufferedReader (new InputStreamReader(System.in)); // on atteint buffreader a partir de sys.in
	    String chaine=buff.readLine();
	    return chaine;
	}
	catch(IOException e) {
	    System.out.println("Erreur"+e);
	    return null;
	}
    }

    public static void main(String[] argv)
    {
	Protocole protocole = new Protocole(); //possibilit de creeer plusieurs protocoles, si on rajoute des parametres dans le constructeur
	
        ArrayList animaux = new ArrayList();
	int jour = 0;
	boolean saisie = false;
	
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
                            saisie_animaux(animaux,especes,semaine);
                            animaux=new ArrayList(animaux);
                            break;
                        }
                    case 2 :
                        {
			    if (! animaux.isEmpty())
				{
                                saisie_resultats_semaine(animaux, tests_dispos, semaine, jour);
				saisie=true;
				}
                            else
                                System.out.println("Erreur, vous devez d'abord saisir des animaux.\n");
                            break;
                        }
                    case 3 :
                        {
                            if (! animaux.isEmpty())
                                afficher_animaux(animaux, semaine);
                            else
                                System.out.println("Erreur, vous devez d'abord saisir des animaux.\n");
                            break;
                        }
                    case 4 :
                        {
                            if (saisie == true)
                                afficher_apprentissage(animaux);
                            else
                                System.out.println("Erreur, vous devez d'abord saisir les donnees.\n");
                            break;
                        }
                    case 5 :
                        {
                            if (saisie == true)
                                afficher_meilleure_performance(animaux);
                            else
                                System.out.println("Erreur, vous devez d'abord saisir les donnees.\n");
                            break;
                        }
		    case 6 :
			{
			    if (saisie == true)
                                animaux_meilleures_performances(animaux);
                            else
                                System.out.println("Erreur, vous devez d'abord saisir les donnees.\n");
                            break;
			}
		    case 7 :
			{
			    if (saisie == true)
                                meilleure_espece(animaux);
                            else
                                System.out.println("Erreur, vous devez d'abord saisir les donnees.\n");
                            break;
			}
		    case 8 :
			{
			  if (saisie == true)
                                stress(animaux);
                            else
                                System.out.println("Erreur, vous devez d'abord saisir les donnees.\n");
                            break;
			}
		    case 9 :
			{
			    loadAnimalData(animaux,"Animaux",false);
			    System.out.println("Liste d'animaux chargee");
			    break;
			}
		    default :
			{
			    System.out.println("Erreur, votre choix est invalide");
			}	    
			
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
			System.out.println("Voulez-vous charger les donnees existantes ? (Y/N) "); //on suppose que les donnees de chaque jour sont coherentes avec les donnes precedentes (par exemple, si un animal est mort, il n'apparaitra pas dans les fichiers txt des jours suivants)
			choix = saisie_chaine();
			if (choix.equals("Y") || choix.equals("N"))
			    {
				x = false;
			    }
			else
			    {
				System.out.println("Choisissez Y ou N.\n");
			    }
		    }

		
		if(choix.equals("Y")){
		    System.out.println("Donnees chargees\n");
		    jour += 1;
		    try{
		    loadAnimalData(animaux,nomJour,true);
		    loaded = true;
		    }
		    catch(ClassCastException ex){
			System.out.println("Erreur, il y a une incoherence dans vos donnees, vous allez devoir saisir les donnees manuellement");
			erase(nomJour+".txt");
		    }
				      
		}
		else
		    {
			erase(nomJour+".txt");
		    }
		
		
		
		if(!loaded && animaux.size() != 0)
		    {
			jour = saisie_resultats(animaux, tests_dispos, semaine, jour); 
		    }

	    }
	System.out.println("Fin de la semaine");
    }
    
    public static int saisie_resultats(ArrayList animaux, Hashtable ht, List<String> semaine, int jour)
    {
	for (int i=0;i<animaux.size();i++)
	    {
		boolean x = true;
		
		Animal animal = (Animal)animaux.get(i);
		if (! (animal.getStatut() == "mort"))
		    {
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
			System.out.println("L'animal ne sera plus comptabilise");
                        animal.sauvegarder(semaine.get(jour)+".txt");
                    }
		    } //fin du if not animal mort
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
		

    public static void saisie_animaux(ArrayList animaux, ArrayList especes, List<String> semaine)
    {
	for(Iterator<String> e = semaine.iterator();e.hasNext();)
	    {
		String nomJour = e.next();
		erase(nomJour+".txt"); // eliminates the day files, as the user has chosen to create a new animal list from scratch, and they are therefore incompatible.
	    }

	
	for (int i=0;i<especes.size();i++)
	    {
		String espece = (String)especes.get(i);
		saisie_animaux_type(animaux, espece);
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
		    if((sexe.equals("M") || sexe.equals("F"))) { // saisie correcte, sinon recommence la saisie.
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
				if(groupe > 0){ // saisie correctement, sinon recommence la saisie.
				    x = false; 
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

    public static void afficher_animaux(ArrayList animaux, List<String> semaine)
    {

	 for(Iterator<String> e = semaine.iterator();e.hasNext();)
	    {
		String nomJour = e.next();
		
	    } // ??
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
                System.out.println("Animal "+animal.getId()+":");
                System.out.println("Apprentissage: "+animal.getProgression());
		System.out.println();
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

    public static void animaux_meilleures_performances(ArrayList animaux)
    {
	ArrayList meilleurs_animaux = new ArrayList(); //souris, singes, etc
	meilleurs_animaux.add(null);
	meilleurs_animaux.add(null);
	ArrayList<Integer> maxs = new ArrayList<Integer>(); //souris, singes, etc
	maxs.add(0);
	maxs.add(0);
	for (int i=0;i<animaux.size();i++)
            {
                Animal animal = (Animal)animaux.get(i);
		int perf = animal.getProgression();
		String espece = animal.getEspece();
		switch (espece)
		    {
		    case "souris":
			{			
			    if (perf > maxs.get(0))
				{
				    maxs.set(0,perf);
				    meilleurs_animaux.set(0,animal);
				}
			    break;
			}
		    case "singe":
			{			
			    if (perf > maxs.get(1))
				{
				    maxs.set(1,perf);
				    meilleurs_animaux.set(1,animal);
				}
			    break;
			}
			// rajouter cases pour d'autres especes
		    }
	    }
	try {
	System.out.println("Les animaux qui ont le meilleur apprentissage sont :");
	for (int j=0;j<meilleurs_animaux.size();j++)
	    {
		if (j==0)
		    System.out.println("Souris:");
		else if (j==1)
		    System.out.println("Singes:");
		Animal courant = (Animal)meilleurs_animaux.get(j);
		courant.afficher_infos();
	    }
	}
	catch (NullPointerException e) {
	    System.out.println("Erreur, aucun animal ne correspond"); //si la performance est negative
	}
    }

    public static void meilleure_espece(ArrayList animaux)
    {
	ArrayList<Integer> totaux = new ArrayList<Integer>(); //souris, singes, etc
	totaux.add(0);
	totaux.add(0);
	ArrayList<Integer> nbs = new ArrayList<Integer>(); //souris, singes, etc
	nbs.add(0);
	nbs.add(0);
	int val;
	int nb;
	for (int i=0;i<animaux.size();i++)
            {
                Animal animal = (Animal)animaux.get(i);
		int perf = animal.getProgression();
		String espece = animal.getEspece();
		switch (espece)
		    {
		    case "souris":
			{
			    nb = nbs.get(i);
			    nbs.set(0,nb++);
			    val= totaux.get(i);
			    totaux.set(0,val+perf);
			    break;
			}
		    case "singe":
			{
			    nb = nbs.get(i);
			    nbs.set(1,nb++);
			    val= totaux.get(i);
			    totaux.set(1,val+perf);
			    break;
			}
			// rajouter cases pour d'autres especes
		    }
	    }
	int moy_souris = totaux.get(0) / nbs.get(0);
	int moy_singes = totaux.get(1) / nbs.get(1);
	if (moy_souris > moy_singes)
	    System.out.println("Les souris ont le plus appris : moyenne = "+moy_souris);
	else
	    System.out.println("Les singes ont le plus appris : moyenne = "+moy_singes);
	
    }

    public static void stress(ArrayList animaux)
    {
	ArrayList<Integer> totaux = new ArrayList<Integer>(); //normaux, stresses
	totaux.add(0);
	totaux.add(0);
	ArrayList<Integer> nbs = new ArrayList<Integer>(); //normaux, stresses
	nbs.add(0);
	nbs.add(0);
	int val;
	int nb;
	for (int i=0;i<animaux.size();i++)
            {
                Animal animal = (Animal)animaux.get(i);
		int perf = animal.getProgression();
		String etat = animal.getEtat();
		for (int j=0;j<totaux.size();j++)
		    {
			nb = nbs.get(j);
			val= totaux.get(j);
			switch (etat)
			    {
			    case "normal":
				{
				    nbs.set(0,nb++);
				    totaux.set(0,val+perf);
				    break;
				}
			    default :
				{
				    nbs.set(1,nb++);
				    totaux.set(1,val+perf);
				    break;
				}
				// rajouter cases pour d'autres especes
			    }
		    }
	    }
	try {
	int moy_normaux = totaux.get(0) / nbs.get(0);
	int moy_stresses = totaux.get(1) / nbs.get(1);
	if (moy_normaux > moy_stresses)
	    System.out.println("Les individus non streses ont le plus appris : moyenne = "+moy_normaux);
	else
	    System.out.println("Les individus stresses ont le plus appris : moyenne = "+moy_stresses);
	}
	catch (ArithmeticException e){
	    System.out.println("Tous vos animaux sont dans le meme etat");
	}
    }
    
    public static int menu()
    {
         System.out.println("**MENU**\n\nSaisir les animaux: 1\nSaisir les donnees: 2\nAfficher la liste d'animaux: 3\nAfficher l'apprentissage des animaux: 4\nAfficher le jour de la meilleure performance des animaux: 5\nAfficher les animaux qui ont la meilleure progression: 6\nAfficher la meilleure espece: 7\nAfficher conclusion de l'etude: 8\nCharger une liste d'animaux: 9\n Quitter: 0\n");
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
    public static void loadAnimalData(ArrayList animaux, String nom, boolean replace) throws ClassCastException
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
	    
	    Singe temp1;
	    Souris temp2;
	    if(!replace){
		animaux.clear();
		temp1 = new Singe("M",1);
		temp1.resetIDs();
	    }
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

			    if(replace){
				for (int i=0;i<animaux.size();i++)
				    {
					Singe monkey = (Singe)animaux.get(i);
					if(monkey.getId() == Integer.valueOf(singe.group(1))){
					    monkey.setProgressionDirect(progression);
					    monkey.setMeilleurePerformance(meilPerfor); // set rest of information, then add to monkey
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
			    else
				{
				    temp1 = new Singe(sexe,poids);
				    temp1.setProgressionDirect(progression);
				    temp1.setMeilleurePerformance(meilPerfor); // set rest of information, then add to monkey
				    temp1.setPoidsDebutSemaine(poidsDebutSem);
				    temp1.setEtat();
				    if(statut.equals("mort"))
					{
					   temp1.mort();
					}
				   temp1.setResultat(res);
				    temp1.setMeilleurResultat(meilRes);
				    // ici, mettre une capacite a creer un nouvel objet du bon type et lui assigner les valeurs, avant de mettre ca dans une ArrayList anim et l'enregistrer comme
				    // Animaux.txt (si le boolean replace a ete mit en faux. aka on veut remplacer tout)
				    animaux.add(temp1);
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


			    if(replace){
				for (int i=0;i<animaux.size();i++)
				    {
					Souris mouse = (Souris)animaux.get(i);
					if(mouse.getId() == Integer.valueOf(souris.group(1))){
					    mouse.setProgressionDirect(progression);
					    mouse.setMeilleurePerformance(meilPerfor); // set rest of information, then add to mouse
					    mouse.setPoidsDebutSemaine(poidsDebutSem);
					    mouse.setEtat();
					    mouse.setGroup(groupe);
					    if(statut.equals("mort"))
						{
						    mouse.mort();
						}
					    mouse.setResultat(res);
					    mouse.setMeilleurResultat(meilRes);
					}
				    }
			    }
			    else
				{
				    temp2 = new Souris(sexe,poids,groupe);
				    temp2.setProgressionDirect(progression);
				    temp2.setMeilleurePerformance(meilPerfor); // set rest of information, then add to monkey
				    temp2.setPoidsDebutSemaine(poidsDebutSem);
				    temp2.setEtat();
				    if(statut.equals("mort"))
					{
					    temp2.mort();
					}
				    temp2.setResultat(res);
				    temp2.setMeilleurResultat(meilRes);
				    // ici, mettre une capacite a creer un nouvel objet du bon type et lui assigner les valeurs, avant de mettre ca dans une ArrayList anim et l'enregistrer comme
				    // Animaux.txt (si le boolean replace a ete mit en faux. aka on veut remplacer tout)
				    animaux.add(temp2);
				    
				}
			    
			    
			    
			}
		}
	}
	catch(FileNotFoundException e){System.out.println("Erreur, le fichier existe-t-il vraiment ?");}
	catch(IOException e){System.out.println("Erreur: "+ e);}
       

    }
}


// create menu option to load data from animal file to .txt + create script. if they create a new animal list, delete ALL day .txts
