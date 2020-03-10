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
		int id1 = MEMBER_ARCHIVE.addMember(new Personals("Peter", "Pan", "peterpan@gmail.com", "tingeling"), LocalDate.of(2019, 8, 29));
		int id2 = MEMBER_ARCHIVE.addMember(new Personals("Lorem", "Ipsum", "lorem@ipsum.com", "loremipsum"), LocalDate.now());
		int id3 = MEMBER_ARCHIVE.addMember(new Personals("Ola", "Nordmann", "olanordmann@live.no", "passord123"), LocalDate.of(2000, 2, 22));
		int id4 = MEMBER_ARCHIVE.addMember(new Personals("Kari", "Tråd", "karitraad@gmail.com", "passord123"), LocalDate.of(2019, 8, 29));
		int id5 = MEMBER_ARCHIVE.addMember(new Personals("Nils", "Bakkestad", "nilsbakkestad@hotmail.com", "passord123"), LocalDate.of(2018, 1, 29));
		
		MEMBER_ARCHIVE.getMember(id1).registerPoints(25000);
		MEMBER_ARCHIVE.getMember(id2).registerPoints(50000);
		MEMBER_ARCHIVE.getMember(id3).registerPoints(1000);
		MEMBER_ARCHIVE.getMember(id4).registerPoints(100000);
		MEMBER_ARCHIVE.getMember(id5).registerPoints(10000);
		
		MEMBER_ARCHIVE.checkMembers(LocalDate.of(2020, 3, 10));
	}
	
	@Override
	public void start (Stage primaryStage) {
		try {
			Parent fxmlRoot = FXMLLoader.load(getClass().getResource("main.fxml"));
			
			MainController controller = getMainController(fxmlRoot);
			controller.setMemberArchive(MEMBER_ARCHIVE);
			
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