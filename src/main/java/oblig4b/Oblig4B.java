package oblig4b;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oblig2.MemberArchive;
import oblig2.Personals;

/**
 * This is the main class for Oblig 4B.
 * 
 * @author Ruben Christoffer
 */
public class Oblig4B extends Application {

	private static final Logger logger = LoggerFactory.getLogger(Oblig4B.class);
	private static final MemberArchive MEMBER_ARCHIVE = new MemberArchive();

	/**
	 * Constructs the object required for launching Oblig4B.
	 */
	public Oblig4B() {
		logger.debug("Adding test members");

		int id1 = MEMBER_ARCHIVE.addMember(new Personals("Peter", "Pan", "peterpan@gmail.com", "tingeling"),
				LocalDate.of(2019, 8, 29));
		int id2 = MEMBER_ARCHIVE.addMember(new Personals("Lorem", "Ipsum", "lorem@ipsum.com", "loremipsum"),
				LocalDate.now());
		int id3 = MEMBER_ARCHIVE.addMember(new Personals("Ola", "Nordmann", "olanordmann@live.no", "passord123"),
				LocalDate.of(2000, 2, 22));
		int id4 = MEMBER_ARCHIVE.addMember(new Personals("Kari", "Tråd", "karitraad@gmail.com", "passord123"),
				LocalDate.of(2019, 8, 29));
		int id5 = MEMBER_ARCHIVE.addMember(
				new Personals("Nils", "Bakkestad", "nilsbakkestad@hotmail.com", "passord123"),
				LocalDate.of(2018, 1, 29));

		logger.debug("Set points for test members");

		MEMBER_ARCHIVE.getMember(id1).registerPoints(25000);
		MEMBER_ARCHIVE.getMember(id2).registerPoints(50000);
		MEMBER_ARCHIVE.getMember(id3).registerPoints(1000);
		MEMBER_ARCHIVE.getMember(id4).registerPoints(100000);
		MEMBER_ARCHIVE.getMember(id5).registerPoints(10000);

		logger.debug("Upgrade members if possible");
		MEMBER_ARCHIVE.checkMembers(LocalDate.of(2020, 3, 10));
	}

	@Override
	public void start(Stage primaryStage) {
		logger.info("Starting primary stage...");

		Parent fxmlRoot = null;

		try {
			logger.debug("Loading FXML");
			fxmlRoot = FXMLLoader.load(getClass().getResource("main.fxml"));
		} catch (Exception e) {
			logger.error("Failed to load FXML!", e);
			throw new RuntimeException("Could not load FXML", e);
		}

		logger.debug("Initializing main controller");
		MainController controller = getMainController(fxmlRoot);
		controller.setMemberArchive(MEMBER_ARCHIVE);

		logger.debug("Showing window");
		primaryStage.setScene(new Scene(fxmlRoot, 600, 400));
		primaryStage.setTitle("Oblig 4");
		primaryStage.show();
	}

	/**
	 * This method looks for the MainController based on a given Node.
	 * 
	 * @param node is a JavaFX node that either itself or has a parent that contains
	 *             the MainController
	 * @return MainController instance or throws RuntimeException
	 */
	private static MainController getMainController(Node node) {
		logger.trace("Getting main controller...");

		Object controller = null;

		do {
			logger.trace("Current node: " + node);

			controller = node.getProperties().get("maincontroller");
			node = node.getParent();
		} while (controller == null && node != null);

		logger.trace("Found main controller");

		return (MainController) controller;
	}

	/**
	 * THis function is used for starting the actual GUI.
	 * 
	 * @param args is the args you want to pass into JavaFX launch.
	 */
	public static void startGUI(String[] args) {
		logger.info("Launching Oblig4B main window...");
		launch(args);
	}

}