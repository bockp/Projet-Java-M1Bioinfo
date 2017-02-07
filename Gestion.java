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
	saisie_animaux(especes);

    }

    public static void saisie_animaux(ArrayList especes)
    {
	
	for (int i=0;i<especes.size();i++)
	    {
		System.out.println(i);
		String espece = (String)especes.get(i);
		saisie_animaux_type(espece);
	    }
		
    }

    public static void saisie_animaux_type(String espece)
    {
	System.out.println("Nombre d'animaux de type "+espece+" a saisir ?");
		int nb = saisie_num();
		for (int i=0;i<nb;i++)
		    {
			System.out.println();
			System.out.println("Sexe ?");
			String sexe = saisie_chaine();
			System.out.println("Poids ?");
			int poids = saisie_num();
			switch (espece) // a modifier si ajout d'autres especes
			    {
			    case "souris": 
				{
				    System.out.println("Groupe ?");
				    int groupe = saisie_num();
				    System.out.println();
				    Souris souris = new Souris(sexe, poids, groupe);
				    break;
				}
			    case "singe":
				{
				    System.out.println();
				    Singe singe = new Singe(sexe, poids);
				    break;
				}
			    }
		    }
    }
	
    
}
