package management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
	
	public void write() throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer;
		writer = new PrintWriter(path, "UTF-8");
		for(SkippedRows skip : skippedRows){
			writer.println(Integer.toString(skip.getRow()) + skip.getError().toString());
		}
		writer.close();
	}
}
