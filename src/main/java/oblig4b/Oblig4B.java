package oblig4b;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Oblig4B extends Application {

	@Override
	public void start (Stage primaryStage) {
		try {
			Parent fxmlRoot = FXMLLoader.load(getClass().getResource("main.fxml"));
			
			Scene scene = new Scene(fxmlRoot, 400, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			System.out.println("Could not display window due to error: \n" + e.toString());
		}
	}
	
	public static void main (String[] args) {
		launch(args);
	}
	
}