package application.controller;

import application.Main;
import application.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonController {

	private Stage stage;
	private Main main;
	private Person person;
	private boolean okClicked = false;
	@FXML private TextField txtFirstName;
	@FXML private TextField txtLastName;
	@FXML private TextField txtPhone;
	@FXML private TextField txtStreet;
	@FXML private TextField txtCity;
	@FXML private TextField txtState;
	@FXML private TextField txtZipCode;
	public void setMain(Main main, Stage stage, Person person)
	{
		this.main = main;
		this.stage = stage;
		this.person = person;
		if(this.person != null)
		{
			setEditProperties();
		}
		
	}
	
	public boolean isOkClicked()
	{
		return okClicked;
	}
	@FXML
	public void handleSave()
	{
		if(this.person != null)
		{
			person.setFirstName(txtFirstName.getText());
			person.setLastName(txtLastName.getText());
			person.setPhoneNumber(txtPhone.getText());
			person.setStreet(txtStreet.getText());
			person.setCity(txtCity.getText());
			person.setState(txtState.getText());
			person.setZipCode(txtZipCode.getText());
			okClicked = true;
		}
		else
		{
			Person person = new Person(
					txtFirstName.getText(),
					txtLastName.getText(),
					txtPhone.getText(),
					txtStreet.getText(),
					txtCity.getText(),
					txtState.getText(),
					txtZipCode.getText());
			main.getPersonData().add(person);
		
		}
		stage.close();
	}
	
	public void setEditProperties()
	{
		txtFirstName.setText(this.person.getFirstName());
		txtLastName.setText(this.person.getLastName());
		txtPhone.setText(this.person.getPhoneNumber());
		txtStreet.setText(this.person.getStreet());
		txtCity.setText(this.person.getCity());
		txtState.setText(this.person.getState());
		txtZipCode.setText(this.person.getZipCode());
	}
	@FXML
	public void handleCancel()
	{
		stage.close();	
	}
}
