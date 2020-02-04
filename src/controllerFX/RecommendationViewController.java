package controllerFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RecommendationViewController implements Initializable {

	@FXML
	private Button gobackButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {


	}

	public void handleClick() throws IOException
	{
		Stage secondStage = (Stage) gobackButton.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("../viewFX/SearchView.fxml"));
		Scene scene = new Scene(root);
		secondStage.setScene(scene);
		secondStage.show();
	}

}
