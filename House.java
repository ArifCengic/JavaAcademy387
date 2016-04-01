import java.util.Scanner;

/**
 * Created by jackblack on 3/30/16.
 */
public class House extends Igrac {

    public House(Spil s)
    {
        super("HOUSE", 100000, s);
    }

    public void anotherCard() {
        while (this.zbir() < 17) {
            this.addKarta(_s.getNextCard());
        }
    }

    public int getBet(){
        //ako je vise igraca
        return 0;
    }
}
