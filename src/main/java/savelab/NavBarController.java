package savelab;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;


import java.io.IOException;

public class NavBarController {
    @FXML
    ImageView logoImage;

    @FXML
    Button homeButton;

    @FXML
    Button researchButton;

    @FXML
    Button peopleButton;

    @FXML
    Button locationButton;

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

            // Get the current stage from any active node reference
            Stage currentStage = (Stage) root.getScene().getWindow();
            if (currentStage != null) {
                Scene scene = new Scene(root);
                currentStage.setScene(scene);
                currentStage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}