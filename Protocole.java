import java.util.*;

public class Protocole
{
    protected ArrayList<String> especes = new ArrayList<String>();
    protected Hashtable tests_dispos = new Hashtable();
    protected List<String> semaine = Arrays.asList("Lundi","Mardi","Mercredi","Jeudi","Vendredi");

    public Protocole()
    {
	especes.add("singe");
	especes.add("souris");
	tests_dispos.put("Souris 1", new ArrayList<String>(Arrays.asList("Labyrinthe")));
    tests_dispos.put("Souris 2", new ArrayList<String>(Arrays.asList("Nourriture")));
    tests_dispos.put("Singe", new ArrayList<String>(Arrays.asList("Image")));
    }

    public ArrayList<String> getEspeces() {return especes;}
    public Hashtable getTestsDispos() {return tests_dispos;}
    public List<String> getSemaine() {return semaine;}
}

