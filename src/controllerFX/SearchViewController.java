package controllerFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import modelFX.IOntology;
import modelFX.SearchParameters;

public class SearchViewController implements Initializable {

	@FXML
	private ToggleGroup person;
	@FXML
	private RadioButton defaut;
	@FXML
	private RadioButton Businessman;
	@FXML
	private RadioButton Student;
	@FXML
	private CheckBox Shortstay;
	@FXML
	private CheckBox Longstay;
	@FXML
	private CheckBox Businesstravel;
	@FXML
	private CheckBox Plane;
	@FXML
	private CheckBox Train;
	@FXML
	private CheckBox Car;
	@FXML
	private CheckBox Cruiseship;
	@FXML
	private Button recommendButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		IOntology myOnt = new IOntology();
		defaut.setSelected(true);
		handleClickDefault();
	//	ObservableList<String> personList = FXCollections.observableArrayList(myOnt.getClasses().get("Person"));
	//	ObservableList<String> meanofList = FXCollections.observableArrayList(myOnt.getClasses().get("MeanOfTransport"));
		//ObservableList<String> travelList = FXCollections.observableArrayList(myOnt.getClasses().get("Travel"));

		//System.out.println(myOnt.getTriples());

	}
	public void handleClickBusinessMan()
	{
		selectCheckboxes("BusinessMan");
	}
	public void handleClickStudent()
	{
		selectCheckboxes("Student");

	}
	public void handleClickDefault()
	{
		selectCheckboxes("Default");
	}

	private void selectCheckboxes(String person)
	{
		unselectAll();
		if(person.equals("Student"))
		{
			for(String s : SearchParameters.getStudentData().get("travelsBy"))
			{
				switch(s)
				{
					case "Train":
						Train.setSelected(true);
						break;
					case "Plane":
						Plane.setSelected(true);
						break;
					case "CruiseShip":
						Cruiseship.setSelected(true);
						break;
					case "Car":
						Car.setSelected(true);
						break;
				}
			}
		}
		else if(person.equals("BusinessMan"))
		{
			for(String s : SearchParameters.getBusinessmanData().get("travelsBy"))
			{
				switch(s)
				{
					case "Train":
						Train.setSelected(true);
						break;
					case "Plane":
						Plane.setSelected(true);
						break;
					case "CruiseShip":
						Cruiseship.setSelected(true);
						break;
					case "Car":
						Car.setSelected(true);
						break;
				}
			}
		}
		else if(person.equals("Default"))
		{
			for(String s : SearchParameters.getRandomData().get("travelsBy"))
			{
				switch(s)
				{
					case "Train":
						Train.setSelected(true);
						Train.setDisable(true);
						break;
					case "Plane":
						Plane.setSelected(true);
						Plane.setDisable(true);
						break;
					case "CruiseShip":
						Cruiseship.setSelected(true);
						Cruiseship.setDisable(true);
						break;
					case "Car":
						Car.setSelected(true);
						Car.setDisable(true);
						break;
				}
			}
		}
	}
	private void unselectAll()
	{
		Shortstay.setSelected(false);
		Longstay.setSelected(false);
		Businesstravel.setSelected(false);
		Plane.setSelected(false);
		Train.setSelected(false);
		Car.setSelected(false);
		Cruiseship.setSelected(false);

		Shortstay.setDisable(false);
		Longstay.setDisable(false);
		Businesstravel.setDisable(false);
		Plane.setDisable(false);
		Train.setDisable(false);
		Car.setDisable(false);
		Cruiseship.setDisable(false);
	}
	public void handleClick() throws IOException
	{
		//SearchParameters.setPersonType(personType.getSelectionModel().getSelectedItem());
		//	SearchParameters.setTravelType(travelType.getSelectionModel().getSelectedItem());
			//SearchParameters.setMeanOfTransport(meanofTransport.getSelectionModel().getSelectedItem());

		Stage secondStage = (Stage) recommendButton.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("../viewFX/RecommendationView.fxml"));
		Scene scene = new Scene(root);
		secondStage.setScene(scene);
		secondStage.show();
	}

}
