import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jackblack on 3/16/16.
 */
public class Igrac {
    String _name;
    int _cipovi;
    Spil _s;
    private List<Karta> dobiveneKarte = new ArrayList<Karta>();

    public boolean anotherCard() {
        System.out.print(this.getName() + "\n Dali zelite jos jednu kartu");
        Scanner in = new Scanner(System.in);
        String odgovor = in.nextLine();

        if (odgovor.contains("Y"))
        {
            addKarta(_s.getNextCard());
            return true;
        }
        else return false;
    }

    public int compareTo(Igrac i){

        if (i.zbir() > this.zbir()) return 1;
        if (i.zbir() < this.zbir()) return -1;
        return 0;
    }

    public void addKarta(Karta k) {

        //normal execution
        try {
            dobiveneKarte.add(k);
            System.out.print("  " + this.getName() + " = " + k.getKarta());
            if (zbir() > 21) lost = true;
        }

        catch (Exception e){
            //error handling
            System.out.println( e.toString() );
        }
    }

    public void clearKarte() {
        dobiveneKarte.clear();
        lost = false;
    }
    public boolean lost = false;

    public String getName() { return _name;}
    public int getCipovi() {return _cipovi;}


    public int zbir() {
        int sum = 0;
        int brojAsova = 0;
        for (Karta k:dobiveneKarte) {
            if(k.getBroj() == 11) brojAsova++;
            sum += k.getBroj();
        }

        if (sum > 21 && brojAsova > 0)
        {
            while(sum > 21 && brojAsova>0 ){
                sum = sum -10;
                brojAsova--;
            }
        }
        return sum;
    }
    public Igrac(String name,int cipovi, Spil s)
    {
        _name = name;
        _cipovi = cipovi;
        _s = s;
    }
}
