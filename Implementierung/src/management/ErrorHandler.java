package management;

import java.util.List;

public class ErrorHandler {
	
	private static ErrorHandler errorHandler;
	private String path;
	List<SkippedRows> skippedRows;

	private ErrorHandler() {
		
	}
	
	public static ErrorHandler getInstance() {
		if(errorHandler == null){
			errorHandler = new ErrorHandler();
		}
		return errorHandler;
	}
	
	public void addRows (int row, Exception error) {
		skippedRows.add(new SkippedRows(row,error));
		
		// Zeile -1 Für Programmfehler
	}
}
