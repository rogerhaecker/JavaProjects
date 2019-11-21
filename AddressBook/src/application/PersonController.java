package application;

import application.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PersonController {

	private Stage stage;
	private Main main;
	@FXML private Label lblFirstName;
	@FXML private Label lblLastName;
	@FXML private Label lblPhone;
	@FXML private Label lblStreet;
	@FXML private Label lblCity;
	@FXML private Label lblState;
	@FXML private Label lblZipCode;
	public void setMain(Main main, Stage stage)
	{
		this.main = main;
		this.stage = stage;
		
	}
	
	@FXML
	public void handleSave()
	{
		Person person = new Person(
				lblFirstName.getText(),
				lblLastName.getText(),
				lblPhone.getText(),
				lblStreet.getText(),
				lblCity.getText(),
				lblState.getText(),
				lblZipCode.getText());
		main.getPersonData().add(person);
	}
	
	@FXML
	public void handleCancel()
	{
		stage.close();	
	}
}
