package application.controller;

import application.Main;	
import application.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddressBookController {
	@FXML private Label lblFirstName;
	@FXML private Label lblLastName;
	@FXML private Label lblPhone;
	@FXML private Label lblStreet;
	@FXML private Label lblCity;
	@FXML private Label lblState;
	@FXML private Label lblZipCode;
	@FXML TableView<Person> tableView;
	@FXML TableColumn<Person, String> colFirstName;
	@FXML TableColumn<Person, String> colLastName;
	private Main main;
	
	public void setMain(Main main) 
	{
		this.main = main;
		System.out.println(this.main.getPersonData().get(0).getFirstName());
		tableView.setItems(main.getPersonData());
		
	}
	
	public void initialize() 
	{
		colFirstName.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		colLastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		
		tableView.getSelectionModel().selectedItemProperty().addListener(
				(observableList, oldValue, newValue) -> showDetails(newValue));
		
	}
	
	private void showDetails(Person person)
	{
		if(person != null)
		{
			lblFirstName.setText(person.getFirstName());
			lblLastName.setText(person.getLastName());
			lblPhone.setText(person.getPhoneNumber());
			lblCity.setText(person.getCity());
			lblStreet.setText(person.getStreet());
			lblState.setText(person.getState());
			lblZipCode.setText(person.getZipCode());
		}
	}

	public void refreshTableView()
	{
		tableView.setItems(null);
		tableView.layout();
		tableView.setItems(main.getPersonData());
		lblFirstName.setText("");
		lblLastName.setText("");
		lblPhone.setText("");
		lblCity.setText("");
		lblStreet.setText("");
		lblState.setText("");
		lblZipCode.setText("");
	}
	public void handleNew()
	{
		main.PersonController(null);
		
	}
	public void handleEdit() 
	{
		
		Person person = tableView.getSelectionModel().getSelectedItem();
		if(person != null)
		{
			boolean okClicked = main.PersonController(person);
			if(okClicked)
			{
				refreshTableView();
			}
		}
	
	}
	public void handleDelete()
	{
		int index = tableView.getSelectionModel().getSelectedIndex();
		 main.getPersonData().remove(index);
		
	}
	
}
