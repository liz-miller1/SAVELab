package savelab;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HomeController {
    private int currentIndex = 0; // To track the current image index
    private List<Image> images;

    @FXML
    private StackPane contentArea;  // This will be the content area that changes based on the button clicked

    //buttons
    @FXML
    private Button btnImagesNext;
    @FXML
    private Button btnImagesPrev;

    //images
    @FXML
    private ImageView imageView;

    @FXML
    private void initialize() {

        Platform.runLater( () -> {
            Stage stage = (Stage) contentArea.getScene().getWindow();

            btnImagesNext = getNextImage();
            btnImagesPrev = getPreviousImage();
            imageView = homePageImages();

            HBox imageHBox = new HBox(10, btnImagesPrev, btnImagesNext);
            imageHBox.setAlignment(Pos.CENTER);
            imageHBox.setSpacing(10);

            Text teamName = new Text("San Antonio Virtual Environments (SAVE) Lab");
            teamName.setTextAlignment(TextAlignment.CENTER);
            teamName.setStyle("-fx-font-size: 15px; -fx-font-weight: bold;");
            teamName.fontProperty().bind(
                    Bindings.createObjectBinding(
                            () -> Font.font(Math.max(stage.getWidth() / 20, 10)),
                            stage.widthProperty()
                    )
            );

            Text missionStatement = new Text(getMissionStatement());
            missionStatement.setTextAlignment(TextAlignment.CENTER);
            missionStatement.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
            missionStatement.setFill(Color.TEAL);
            missionStatement.fontProperty().bind(
                    Bindings.createObjectBinding(
                            () -> Font.font(Math.max(stage.getWidth() / 30, 10)),
                            stage.widthProperty()
                    )
            );

            Text missionDescription = new Text(getMissionDescription());
            missionDescription.setTextAlignment(TextAlignment.CENTER);
            missionDescription.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-font-style:italic;");
            missionDescription.fontProperty().bind(
                    Bindings.createObjectBinding(
                            () -> Font.font(Math.max(stage.getWidth() / 50, 10)),
                            stage.widthProperty()
                    )
            );
            missionDescription.setWrappingWidth(500);

            VBox imageVbox = new VBox(10, imageView, imageHBox);
            imageVbox.setAlignment(Pos.CENTER); // Center-align all elements in the VBox
            imageVbox.setSpacing(10); // Space between ImageView and Button

            HBox centerInfo = new HBox(30, imageVbox, missionDescription);
            centerInfo.setAlignment(Pos.CENTER);
            VBox mainVbox = new VBox(20, teamName,missionStatement, centerInfo);
            mainVbox.setAlignment(Pos.CENTER);
            contentArea.getChildren().add(mainVbox);
        });
    }

    private ImageView homePageImages() {
        // Initialize image list
        images = new ArrayList<>();
        images.add(new Image(getClass().getResourceAsStream("/savelab/images/HomeImage1.jpeg")));
        images.add(new Image(getClass().getResourceAsStream("/savelab/images/HomeImage2.jpeg")));
        images.add(new Image(getClass().getResourceAsStream("/savelab/images/HomeImage3.png")));
        images.add(new Image(getClass().getResourceAsStream("/savelab/images/HomeImage4.jpeg")));
        images.add(new Image(getClass().getResourceAsStream("/savelab/images/HomeImage5.jpg")));

        // Set up the ImageView to display images
        imageView = new ImageView(images.get(currentIndex));
        imageView.setFitWidth(400);  // Set the desired width
        imageView.setPreserveRatio(true); // Preserve the image aspect ratio

        return imageView;
    }

    // Method to show the next image
    private void showNextImage() {
        currentIndex = (currentIndex + 1) % images.size(); // Loop back to the start
        imageView.setImage(images.get(currentIndex));
    }

    private void showPreviousImage() {
        currentIndex = (currentIndex - 1 + images.size()) % images.size(); // Loop back to the start
        imageView.setImage(images.get(currentIndex));
    }

    private Button getNextImage() {
        // Button to go to the next image
        Button nextButton = new Button("Next Image");
        nextButton.setOnAction(e -> showNextImage());

        return nextButton;
    }

    private Button getPreviousImage() {
        // Button to go to the next image
        Button prevButton = new Button("Previous Image");
        prevButton.setOnAction(e -> showPreviousImage());

        return prevButton;
    }

    private String getMissionStatement() {
        return "We make games to save the world.\n\n";
    }

    private String getMissionDescription() {
        return "The San Antonio Virtual Environments (SAVE) Lab conducts research in virtual reality, " +
                "augmented reality, mixed reality, simulation, 3D user interfaces, serious games, artificial " +
                "intelligence and deep learning. Our projects have applications to training, education, and healthcare.";
    }
}