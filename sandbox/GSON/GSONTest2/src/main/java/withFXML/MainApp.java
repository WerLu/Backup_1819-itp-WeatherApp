package withFXML;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MainApp extends Application {

    public static void main(String[] args) { launch(args);}

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../../resources/MainView.fxml"));
        Pane root = loader.load();
        //AnchorPane retard = loader.load();
        MainCtrl ctrl = loader.getController();
        ctrl.setMainStage(primaryStage);

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setTitle("Resizer!");
        primaryStage.show();
    }
}
