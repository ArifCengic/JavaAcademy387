import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.ObjDoubleConsumer;


public class HelloJavaWorld {

    public static void main(String[] args) throws IOException {

        Date d = new Date(); //date + time
        Date dd = Calendar.getInstance().getTime();

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy MMM dd EEE");
        System.out.println(sdf1.format(dd));

        System.out.println(String.format("Danas je %tT i %tB %s", dd, dd, "some string"));
        ISpil s = new TestSpil();
        s.setNextCard(new Karta(10,0));
        s.setNextCard(new Karta(8,0));
        s.setNextCard(new Karta(10,1));
        s.setNextCard(new Karta(8,1));
        s.setNextCard(new Karta(10,2));
        s.setNextCard(new Karta(8,2));
        s.setNextCard(new Karta(10,3));
        s.setNextCard(new Karta(8,3));

        s.setNextCard(new Karta(11,0));
        s.setNextCard(new Karta(11,1));
        s.setNextCard(new Karta(11,2));
        s.setNextCard(new Karta(11,3));

        List<Igrac> igraci = new ArrayList<Igrac>();
        igraci.add(new Igrac("Prvi", 20, s));
        igraci.add(new Igrac("Drugi", 25, s));
        igraci.add(new Igrac("Treci", 30, s));
        igraci.add(new House(s)); //TODO limit



        for(Igrac i: igraci) {
            System.out.print(i.getName() + "\n");
            do {
                i.clearKarte();
                i.addKarta();
                i.addKarta();
            } while (i.lost);

            System.out.print("\n");
        }

        System.out.print("\n");

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

            if(maxIgraci.size() == 1)
            {
                Igrac i = maxIgraci.get(0);
                i.addChip(ulog);
                System.out.print("\n" +  maxIme +  " je pobijedio " + ulog + " \n");
            }
            else {
                for(Igrac i:maxIgraci )
                {
                    i.addChip(ulog/maxIgraci.size());
                    //TODO round up
                }
                System.out.print("\n Igraci " + maxIme + " dijele dobitak " + ulog + " na " + maxIgraci.size() + " dijela \n");
            }

        PrintWriter out = new PrintWriter("File1.txt");
        try {

        System.out.printf("\n");
        for (Igrac i: igraci) {
            out.println((String.format("Igrac %-20s je imao zbir %02d %d \n",i.getName(),i.zbir(),i.getChips())));
            System.out.printf("Igrac %-20s je imao zbir %02d %d \n",i.getName(),i.zbir(),i.getChips());
        }

        }
        catch (Exception e){

            System.out.printf(e.getMessage());
         }
        finally {
            out.close();
        }
    }

    public void ReadFromFile() throws IOException {
        FileReader fr = new FileReader("FileReaderDemo.java");
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        fr.close();
    }
}



