import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Ctrl {
    public class FXMLDocumentController implements Initializable {

        @FXML
        private Label label;

        @FXML
        private Button button;

        private void handleButtonAction(ActionEvent event) throws IOException {
            System.out.println("You clicked me!");
            new Ctrl2();

        }

        @Override
        public void initialize(URL url, ResourceBundle rb) {

        }

    }
}
