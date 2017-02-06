
public class Labyrinthe extends Test {
    protected int temps;

    public Labyrinthe(){
    nom = "Labyrinthe";   
    }
    
    public void setTemps(int t) {temps = t;}
    public void setPopVisee(String pop){pop_visee = pop;}
    public void setGroupeVisee(int group){groupe_visee = group;}
    
    public int getTemps(){return temps;}
    public String getPopVisee(){return pop_visee;}
    public int getGroupeVisee(){return groupe_visee;}

}
