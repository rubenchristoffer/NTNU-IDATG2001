import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oblig4b.Oblig4B;

/**
 * This class should be the first class that gets loaded
 * when running a JAR file
 * @author Ruben Christoffer
 */
public final class Launcher {

	private static final Logger logger = LoggerFactory.getLogger(Launcher.class);
	
	public static void main (String[] args) {
		logger.info("Launching Oblig4B application...");
		Oblig4B.startGUI(args);
	}
	
}
