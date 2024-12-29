package savelab;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;

import java.awt.Desktop;
import java.net.URI;

public class FooterController {

    @FXML
    Hyperlink contactUsLink;

    @FXML
    Hyperlink linkedinLink;

    @FXML
    Hyperlink twitterLink;

    @FXML
    Hyperlink researchLink;

    @FXML
    private void openContactUs() {
        openWebPage("http://yourwebsite.com/contact");
    }

    @FXML
    private void openLinkedIn() {
        openWebPage("https://www.linkedin.com/your-profile");
    }

    @FXML
    private void openTwitter() {
        openWebPage("https://twitter.com/your-profile");
    }

    @FXML
    private void openResearchPapers() {
        openWebPage("http://yourwebsite.com/research-papers");
    }

    private void openWebPage(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
