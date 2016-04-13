import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackblack on 3/16/16.
 */


public class Spil implements ISpil {

    List<Karta> spil = new ArrayList<Karta>();
    static Image spilImage = null;

    public Spil(Image i){
        spilImage = i;
        new Spil();
    }

    public Spil() {
        int i = 0;
        for (int z = 0; z < 4; z++) //znak
        {
            for (int b = 2; b < 15; b++) //broj
            {
                spil.add(new Karta(b, z));
                i++;
            }
        }
    }

    static Image GetCardImage(Image cards, int broj, int slika) {
        int width = (int)cards.getWidth() / 13;
        int height = (int)cards.getHeight() / 4;
        int left = width * broj;
        int top = height * slika;

        PixelReader reader = cards.getPixelReader();
        WritableImage card = new WritableImage(reader, left, top, width - 1, height);

        return card;
    }

    public Karta getNextCard() {
        if (spil.size() == 0) return null;

        int radomBroj = (int) (Math.random() * (spil.size() - 1));
        Karta k = spil.get(radomBroj);
        spil.remove(k);
        //  k.image = GetCardImage(k.getBroj() - 2, k.getZnak() - 1);

        return k;
    }

    public void setNextCard(Karta k) {
        return;
    }

    static Image GetCardImage(int broj, int slika) {
        int width = (int) spilImage.getWidth() / 13;
        int height = (int) spilImage.getHeight() / 4;
        int left = width * broj;
        int top = height * slika;

        PixelReader reader = spilImage.getPixelReader();
        WritableImage card = new WritableImage(reader, left, top, width - 1, height);

        return card;
    }

}
