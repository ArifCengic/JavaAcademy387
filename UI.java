import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by jackblack on 4/11/16.
 */
public class UI extends Application {
    static StackPane root;
    static int brkarti = 0;

    static void initUI() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new StackPane();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void dodajKartu (Image kartaimg) {
        ImageView karta = new ImageView(kartaimg);
        root.getChildren().add(karta);
        karta.setTranslateY(brkarti*20);
    }


}
