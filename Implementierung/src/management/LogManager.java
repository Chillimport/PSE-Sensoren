package management;
import java.io.IOException;
import java.util.logging.*;

public class LogManager {

	private static LogManager logManager;
	private final static Logger LOGGER = Logger.getLogger("LogEx");
    private FileHandler txtFile;
    private SimpleFormatter formatterTxt;

    private LogManager () {
    	try{
    	setup();
    	}
    	catch(SecurityException e){
    		System.out.println("Something went wrong while initializing the Log");
    		// Wo hin?
    	}
    	catch(IOException e){
    		System.out.println("Something went wrong while initializing the Log");
    		// Wo hin?
    	}
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
	
	public LogManager getInstance() {
		if(logManager == null){
			logManager = new LogManager();
		}
		return logManager;
	}
}

