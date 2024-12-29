package savelab;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HomeController {
    @FXML
    private AnchorPane homePane;

    // Navigation actions for buttons
    @FXML
    private void goToHome() {
        loadView("home-view.fxml");
    }

    @FXML
    private void goToResearch() {
        loadView("research-view.fxml");
    }

    @FXML
    private void goToPeople() {
        loadView("people-view.fxml");
    }

    @FXML
    private void goToLocation() {
        loadView("location-view.fxml");
    }

    // Generic method to load different views
    private void loadView(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage primaryStage = (Stage) homePane.getScene().getWindow();
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}