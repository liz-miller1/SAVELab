package savelab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BaseApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home-view.fxml"));

        Scene homeScene = new Scene(fxmlLoader.load());
        stage.setScene(homeScene);
        stage.setTitle("SAVELab");
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
    launch(args);
}
}

