import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jackblack on 3/16/16.
 */
public class Igrac {
    protected String _name;
    private int _cipovi;
    private ISpil _s;
    private List<Karta> dobiveneKarte = new ArrayList<Karta>();

    public int addChip(int dobitak)
    {
        _cipovi = _cipovi + dobitak;
        return _cipovi;
    }

    public int getChips() { return  _cipovi;}

     public int getBet(){

         int ulog = 0;
         boolean error = false;
         do {
             System.out.print(this.getName() + "\n Koliko zelite uloziti");
             Scanner in = new Scanner(System.in);
             String odgovor = in.nextLine();

             //TODO error checking
             try {
                 ulog = Integer.parseInt(odgovor);
             }
             catch (Exception e)
             {
                 System.out.print(this.getName() + "\n Invalid input");
                 error = true;
                 continue;
             }

             if (ulog > _cipovi) {
                 System.out.print(this.getName() + "\n Iznos veci od broja zetona");
                 error = true;
                 continue;
             }

             error = false;
         } while(error);

        _cipovi = _cipovi - ulog;
        return ulog;
    }

    public void anotherCard() {
        String odgovor;
        while( this.zbir() < 21)
        {
            System.out.print(this.getName() + "\n Dali zelite jos jednu kartu");
            Scanner in = new Scanner(System.in);
            odgovor = in.nextLine();

            if (odgovor.contains("Y")) addKarta();
            else break;

        }
    }

    public int compareTo(Igrac i){

        if (i.zbir() > this.zbir()) return 1;
        if (i.zbir() < this.zbir()) return -1;
        return 0;
    }

    public void addKarta() {

        //normal execution
        try {
            Karta k = _s.getNextCard();
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

    public Igrac(String name,int cipovi, ISpil s)
    {
        _name = name;
        _cipovi = cipovi;
        _s = s;
    }
    public Igrac()
    {

    }
}
