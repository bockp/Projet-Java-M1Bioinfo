public class Labyrinthe extends Test {

    protected int temps;
    

    public Labyrinthe(int t){
    nom = "Labyrinthe";
    pop_visee = "souris";
    groupe_vise = 1;
    temps = t;
    } //l'utilisateur donne le temps qu'a mis la souris
    
    public int getTemps(){return temps;}
    public String getPopVisee(){return pop_visee;}
    public int getGroupeVisee(){return groupe_vise;}

}
