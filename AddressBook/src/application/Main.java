package application;
	
import application.controller.AddressBookController;
import application.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader= new FXMLLoader(Main.class.getResource("view/AddressBookView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			AddressBookController controller = loader.getController();
			controller.setMain(this);
			
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show(); 	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void PersonController()
	{
		try {
			FXMLLoader loader= new FXMLLoader(Main.class.getResource("view/NewPersonView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			PersonController controller = loader.getController();
			Stage stage = new Stage();
			controller.setMain(this, stage);
			
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private ObservableList<Person> personData = FXCollections.observableArrayList();
	public ObservableList<Person> getPersonData(){
		return personData;
	}
	
	public Main() {
		personData.add(new Person("Roger", "Haecker", "Beloit Ave", "Janesville", "WI", "53546","608-718-3248") );
		personData.add(new Person("Jerry", "Haecker", "Rogers Street", "milton", "WI", "53963", "262-894-3563"));
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
