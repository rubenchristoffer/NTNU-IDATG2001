import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oblig5a.views.ContactsApp;

/**
 * This class should be the first class that gets loaded when running a JAR file
 * 
 * @author Ruben Christoffer
 */
public final class Launcher {

	private static final Logger logger = LoggerFactory.getLogger(Launcher.class);

	public static void main(String[] args) {
		logger.info("Launching Oblig5A application...");
		ContactsApp.main(args);
	}

}
