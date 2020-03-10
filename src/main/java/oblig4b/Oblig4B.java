package oblig4b;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oblig2.MemberArchive;
import oblig2.Personals;

public class Oblig4B extends Application {
	
	private MemberArchive MEMBER_ARCHIVE = new MemberArchive();
	
	public Oblig4B() {
		// Add test members
		MEMBER_ARCHIVE.addMember(new Personals("Peter", "Pan", "peterpan@gmail.com", "tingeling"), LocalDate.of(2019, 8, 29));
		MEMBER_ARCHIVE.addMember(new Personals("Lorem", "Ipsum", "lorem@ipsum.com", "loremipsum"), LocalDate.now());
		MEMBER_ARCHIVE.addMember(new Personals("Ola", "Nordmann", "olanordmann@live.no", "passord123"), LocalDate.of(2000, 2, 22));
		MEMBER_ARCHIVE.addMember(new Personals("Kari", "Tråd", "karitraad@gmail.com", "passord123"), LocalDate.of(2019, 8, 29));
		MEMBER_ARCHIVE.addMember(new Personals("Nils", "Bakkestad", "nilsbakkestad@hotmail.com", "passord123"), LocalDate.of(2018, 1, 29));
	}
	
	@Override
	public void start (Stage primaryStage) {
		try {
			Parent fxmlRoot = FXMLLoader.load(getClass().getResource("main.fxml"));
			
			MainController controller = getMainController(fxmlRoot);
			MEMBER_ARCHIVE.getMembers().forEach(member -> controller.addBonusMembers(member));
			
			primaryStage.setScene(new Scene(fxmlRoot, 600, 400));
			primaryStage.setTitle("Oblig 4");
			primaryStage.show();
		} catch (Exception e) {
			System.out.println("Could not display window due to error: \n" + e.toString());
		}
	}
	
	public static MainController getMainController (Node node) {
	    Object controller = null;
	    
	    do {
	        controller = node.getProperties().get("maincontroller");
	        node = node.getParent();
	    } while (controller == null && node != null);
	    
	    return (MainController) controller;
	}
	
	public static void main (String[] args) {
		launch(args);
	}
	
}