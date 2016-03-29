import java.io.Console;
import java.util.*;
import java.util.function.ObjDoubleConsumer;

class Number {
    public float z;
}

public class HelloJavaWorld {

//    static float square(Number a){
//        a.z = a.z * a.z;
//        return a.z;
//    };
//
//    static float square(float a){
//        a = a * a;
//        return a;
//    };
//
//    static long add(long a, long b){
//        return a + b;
//    }
    public static void main(String[] args) {
//
//        Date d = new Date();
//        Date d1 = new Date();
//
//        int ii = d.compareTo(d1);
//        if ( ii > 0 )  System.out.print("D je veci od D1  ");
//        if ( ii < 0)  System.out.print("D je majni od D1  ");
//        if ( ii == 0 )  System.out.print("D je isit od D1  ");

//        System.out.print("D1 is " + d1.toString() + "\n");
//        System.out.print("Today is " + String.format("%tD %tT",d,d) + "\n");
        // Date Formats
        // F	ISO 8601 date	2004-02-09
//        D	U.S. formatted date (month/day/year)	02/09/2004
//        T	24-hour time	18:05:19
//        r	12-hour time	06:05:19 pm
//        R	24-hour time, no seconds	18:05
//        Y	Four-digit year (with leading zeroes)	2004
//        y	Last two digits of the year (with leading zeroes)	04
//        C	First two digits of the year (with leading zeroes)	20
//        B	Full month name	February
//        b	Abbreviated month name	Feb
//        m	Two-digit month (with leading zeroes)	02
//        d	Two-digit day (with leading zeroes)	03
//        e	Two-digit day (without leading zeroes)	9
//        A	Full weekday name	Monday
//        a	Abbreviated weekday name	Mon
        Spil s = new Spil();

        List<Igrac> igraci = new ArrayList<Igrac>();
        igraci.add(new Igrac("Prvi", 20, s));
        igraci.add(new Igrac("Drugi", 25, s));
        igraci.add(new Igrac("Treci", 30, s));

        Igrac house = new Igrac("House", 1000, s); //TODO limit

        for(Igrac i: igraci) {
            System.out.print(i.getName() + "\n");
            do {
                i.clearKarte();
                i.addKarta(s.getNextCard());
                i.addKarta(s.getNextCard());
            } while (i.lost);

            System.out.print("\n");
        }

        System.out.print(house.getName() + "\n");
        do {
            house.addKarta(s.getNextCard());
            house.addKarta(s.getNextCard());
        }while(house.lost);

        System.out.print("\n");

        int zbir = 0;


        for(Igrac i: igraci) {
            do {
                if (!i.anotherCard()) break;
                if (i.lost) {
                    System.out.print(i.getName() + " je izgubio " + i.zbir() + " \n");
                    break;
                }

            } while (true);

        }

        while (house.zbir() < 17) {
            house.addKarta(s.getNextCard());
        }

        if (house.lost) {
            System.out.print("\n Kuca je izgubila");
            return;
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

        if(house.zbir() > max)
        {
            System.out.print("\n Kuca je pobijedila");
        }
        else
        {
            String maxIme = "";
            for (Igrac i: maxIgraci) {
                maxIme = maxIme + ",  " + i.getName();
            }

            if(maxIgraci.size() == 1) System.out.print("\n" +  maxIme +  " je pobijedio \n");
            else System.out.print("\n Igraci " +  maxIme +  " dijele dobitak \n");
        }

    }


}



