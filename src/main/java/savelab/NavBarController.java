package savelab;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;


import java.io.IOException;

public class NavBarController {
    @FXML
    private ImageView logoView;

    @FXML
    Button homeButton;

    @FXML
    Button researchButton;

    @FXML
    Button peopleButton;

    @FXML
    Button locationButton;

    @FXML
    private void goToHome() { loadView("/savelab/home-view.fxml"); }

    @FXML
    private void goToResearch() {
        loadView("/savelab/research-view.fxml");
    }

    @FXML
    private void goToPeople() {
        loadView("/savelab/people-view.fxml");
    }

    @FXML
    private void goToLocation() {
        loadView("/savelab/location-view.fxml");
    }

    @FXML
    public void initialize() {
        // Load the image from resources
        Image logoImage = new Image(getClass().getResourceAsStream("/savelab/images/SAVELabLogo.jpg"));
        logoView.setImage(logoImage);
    }

    // Generic method to load different views
    private void loadView(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            Parent root = loader.load();

            // Get the current stage from any active node reference
            Scene currentScene = homeButton.getScene(); // Use any existing node
            if (currentScene != null) {
                // Replace the root of the current scene
                currentScene.setRoot(root);
            } else {
                System.err.println("Scene is null. Ensure logoView is properly initialized.");
            }

            // Image in the Upper Right Corner
            Image logoImage = new Image(getClass().getResourceAsStream("/savelab/images/SAVELabLogo.jpg"));
            logoView.setImage(logoImage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}