import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackblack on 3/16/16.
 */
public class Spil {

    //Karta[] spil = new Karta[52];
    List<Karta> spil = new ArrayList<Karta>();

    public Spil()
    {
        int i = 0;
        for(int z = 0; z < 4; z++) //znak
        {
            for(int b=2; b < 15; b++) //broj
            {
                spil.add(new Karta(b,z));
                i++;
            }
        }
    }

    Karta getNextCard(){
        if (spil.size() == 0) return null;

        int radomBroj = (int)(Math.random() * (spil.size()-1));
        Karta k = spil.get(radomBroj);
        spil.remove(k);

        return k;
    }
}
