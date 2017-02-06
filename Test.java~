import java.io.*;
import java.util.*;

public class Test
{

    public static void main( String[] argv)
    {
	ArrayList animaux= new ArrayList();
	Souris souris = new Souris("M",2.5f,2);
	animaux.add(souris);
	Singe singe = new Singe("M",30f);
	animaux.add(singe);
	Souris souris2 = new Souris("F",1.5f,1);
	animaux.add(souris2);

	for (int i=0;i<animaux.size();i++)
	    {
		Animal animal=(Animal)animaux.get(i);
		animal.afficher_infos();
	    }
    }
}
