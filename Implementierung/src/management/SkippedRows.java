package management;

public class SkippedRows {

	private int row;
	private Exception error;
	
	public SkippedRows(int row, Exception error){
		this.row = row;
		this.error = error;
	}
	
	public int getRow() {
		return row;
	}
	
	public Exception getError() {
		return error;
	}
}
