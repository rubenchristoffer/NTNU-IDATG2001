package oblig4b;

import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.stage.Stage;

/**
 * Very simple test for JavaFX window
 * that currently only tests by launching
 * and clicking on table.
 * @author Ruben Christoffer
 */
public class Oblig4BTest extends ApplicationTest {

	private Oblig4B oblig4b;
	
	@Override
	public void start(Stage stage) throws Exception {
		oblig4b = new Oblig4B();
		oblig4b.start(stage);
	}
	
	@AfterEach
	public void tearDown () throws TimeoutException {
		FxToolkit.hideStage();
	}
	
	@Test
	public void testStartupScene () {
		clickOn("#table");
	}
	
}
