package savelab;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ResearchController {

    @FXML
    private BorderPane researchPane;

    @FXML
    private VBox current;
    @FXML
    private VBox previous;

    @FXML
    private Label currentLabel;

    @FXML
    private Label previousLabel;

    @FXML
    private TitledPane paper1;
    @FXML
    private TitledPane paper2;
    @FXML
    private TitledPane paper3;
    @FXML
    private TitledPane paper4;
    @FXML
    private TitledPane paper5;
    @FXML
    private TitledPane paper6;
    @FXML
    private TitledPane paper7;
    @FXML
    private TitledPane paper8;
    @FXML
    private TitledPane paper9;

    @FXML
    private void initialize() {
        paper1.setText("Paper1");
        paper1.setContent(new Label("Paper1 here"));
        paper1.setExpanded(true);

        paper2.setText("Paper2");
        paper2.setContent(new Label("Paper2 here"));
        paper2.setExpanded(false);

        paper3.setText("Paper3");
        paper3.setContent(new Label("Paper3 here"));
        paper3.setExpanded(false);

        paper4.setText("Paper4");
        paper4.setContent(new Label("Paper4 here"));
        paper4.setExpanded(false);

        paper5.setText("Paper5");
        paper5.setContent(new Label("Paper5 here"));
        paper5.setExpanded(true);

        paper6.setText("Paper6");
        paper6.setContent(new Label("Paper6 here"));
        paper6.setExpanded(false);

        paper7.setText("Paper7");
        paper7.setContent(new Label("Paper7 here"));
        paper7.setExpanded(false);

        paper8.setText("Paper8");
        paper8.setContent(new Label("Paper8 here"));
        paper8.setExpanded(false);

    }
}
