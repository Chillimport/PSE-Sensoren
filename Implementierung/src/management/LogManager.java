package management;
import java.io.IOException;
import java.util.logging.*;

public class LogManager {

	private static LogManager logManager;
	private final static Logger LOGGER = Logger.getLogger("LogEx");
    private FileHandler txtFile;
    private SimpleFormatter formatterTxt;

    private LogManager () throws SecurityException, IOException {
    	setup();
    }
    
	private void setup() throws SecurityException, IOException{
		LOGGER.setLevel(Level.ALL);
		txtFile = new FileHandler("Logging.txt");
		
		formatterTxt = new SimpleFormatter();
	    txtFile.setFormatter(formatterTxt);
	    LOGGER.addHandler(txtFile);
	}
	
	public void writeToLog(String message, boolean severe){
		if(severe){
			LOGGER.severe(message);
		}
		else{
			LOGGER.info(message);
		}
	}
	
	public static LogManager getInstance() throws SecurityException, IOException {
		if(logManager == null){
			logManager = new LogManager();
		}
		return logManager;
	}
}

