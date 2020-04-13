package oblig4b;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.stage.Stage;

/**
 * Very simple test for JavaFX window that currently only tests by launching and
 * clicking on table.
 * 
 * @author Ruben Christoffer
 */
public class Oblig4BTest extends ApplicationTest {

	@Override
	public void start(Stage stage) throws Exception {
		Oblig4B oblig4b = new Oblig4B();
		oblig4b.start(stage);
	}

	@Test
	public void testStartupScene() {
		clickOn("#table");
	}

}
