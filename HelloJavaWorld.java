import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.ObjDoubleConsumer;

class Number {
    public float z;
}

public class HelloJavaWorld {




    public static void main(String[] args) {

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy MMM dd EEE");
        System.out.println(sdf1.format(Calendar.getInstance().getTime()));

        Spil s = new Spil();

        List<Igrac> igraci = new ArrayList<Igrac>();
        igraci.add(new Igrac("Prvi", 20, s));
        igraci.add(new Igrac("Drugi", 25, s));
        igraci.add(new Igrac("Treci", 30, s));
        igraci.add(new House(s)); //TODO limit

        for(Igrac i: igraci) {
            System.out.print(i.getName() + "\n");
            do {
                i.clearKarte();
                i.addKarta(s.getNextCard());
                i.addKarta(s.getNextCard());
            } while (i.lost);

            System.out.print("\n");
        }

        System.out.print("\n");

        int zbir = 0;
        int ulog = 0;

        for(Igrac i: igraci) {
            ulog = ulog + i.getBet();
            i.anotherCard();
        }

        //TODO check if two or more players have same score
        int max = 0;
        List<Igrac> maxIgraci = new ArrayList<>();

        for(Igrac i: igraci){

            if (!i.lost && i.zbir() >= max)
            {
                max = i.zbir();
               // maxIgraci.add(i);
            }
        }

        for(Igrac i: igraci)
        {
            if(i.zbir() == max) maxIgraci.add(i);
        }


            String maxIme = "";
            for (Igrac i: maxIgraci) {
                maxIme = maxIme + ",  " + i.getName();
            }

            if(maxIgraci.size() == 1) System.out.print("\n" +  maxIme +  " je pobijedio \n");
            else System.out.print("\n Igraci " +  maxIme +  " dijele dobitak \n");


        System.out.printf("\n");
        for (Igrac i: igraci) {
            System.out.printf("Igrac %-20s je imao zbir %02d \n",i.getName(),i.zbir());
        }

    }


}



