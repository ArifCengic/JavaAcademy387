/**
 * Created by jackblack on 3/14/16.
 */
class Karta
{
    static final String[] znakovi = {"Pik", "Hertz", "Tref", "Karo"};

    private int broj;  //attribute, property of the object
    private String znak; //fields , instance variable

    public  Karta(int broj, int znak){
        this.setBroj(broj);
        this.setZnak(znak);
    }
    public int getBroj() { return this.broj;}
    public boolean setBroj(int value){
        if(value > 1 && value < 15)
        {
            broj = value;
            return true;
        }
        return false;
    }

    public String getKarta(){
        String rezultat = "";

        switch (broj)
        {
            case 11:
                rezultat = "As" + "-" + znak;
                break;
            case 12:
                rezultat = "Žandar" + "-" + znak;
                break;
            case 13:
                rezultat = "Dama" + "-" + znak;
                break;
            case 14:
                rezultat = "Kralj" + "-" + znak;
                break;
            default:
                rezultat = broj + "-" + znak;
                break;
        }

        return rezultat;
    }

    public boolean setZnak(int value) {
        if(value >= 0 && value < 4)
        {
            znak = znakovi[value];
            return true;
        }

        return false;
    }

    public boolean setZnak(String value) {
        boolean found = false;

        for(int i = 0 ; i < znakovi.length; i++ ){
            if(value == znakovi[i]) {
                found = true;
                znak = value;
            }
        }
        return found;
    }
}

