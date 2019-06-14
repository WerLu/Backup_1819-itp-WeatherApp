package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        loader.load();
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("fxml2.fxml"));
        loader1.load();
        Ctrl ctrl1 = loader1.getController();

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("fxml3.fxml"));
        loader2.load();

        Ctrl ctrl2 = loader2.getController();
        Parent root = loader.getRoot();
        Ctrl ctrl = loader.getController();

        ctrl.loadFxml();
        primaryStage.setTitle("Weather");
        primaryStage.setScene(new Scene(root, 900, 500));


        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
