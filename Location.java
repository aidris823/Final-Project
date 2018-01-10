
public class Location {
    private int row;
    private char col;
    
    
    public Location(String s) throws IllegalArgumentException {
	char col = s.charAt(0);
	int row;
	try {
	    Integer i = Integer.decode(s.substring(1,2));
	    row = i.intValue();
	} catch (NumberFormatException nfe) {
	    throw new IllegalArgumentException(s + " could not be parsed into " +
					       "a Location");
	}
	checkRowCol(col, row);
	this.row = row;
	this.col = col;
    }
    
    public Location(char col, int row) throws IllegalArgumentException {
	checkRowCol(col, row);
	this.row = row;
	this.col = col;
    }
   
    public Location(int colIndex, int rowIndex) throws IllegalArgumentException {
	this((char)('a'+colIndex), rowIndex+1);
    }
    
   
    private void checkRowCol(char col, int row) throws IllegalArgumentException {
	if (row < 1 || row > 8)
	    throw new IllegalArgumentException("Row is bad: " + row);
	if (col < 'a' || col > 'h')
	    throw new IllegalArgumentException("Column is bad: " + col);
    }
    
   
    public int getRow() {
	return row;
    }
    
   
    public char getCol() {
	return col;
    }
    
    public int getRowIndex() {
	return row-1;
    }
    
   
    public int getColIndex() {
	return (col-'a');
    }
    
   
    public String toString() {
	return ""+col+row;
    }
    
    
    public boolean equals(Object o) {
	if (o.getClass()!=this.getClass())
	    return false;
	Location o2 = (Location)o;
	return (row == o2.getRow() && col == o2.getCol());
    }
    
    
    public static Location[] diagLocations(Location start, Location end) {
	if (Math.abs(end.getRow()-start.getRow())!=
	    Math.abs(end.getCol()-start.getCol()))
	    throw new IllegalArgumentException();
	Location[] array = new Location[Math.abs(end.getRow() - start.getRow())];
	int rInc;
	if (end.getRow() > start.getRow())
	    rInc = 1;
	else
	    rInc = -1;
	int cInc;
	if (end.getCol() > start.getCol())
	    cInc = 1;
	else
	    cInc = -1;
	for (int i = 0; i < array.length; i++) {
	    array[i] = new Location(
				    (char)(start.getCol()+((i+1)*cInc)),
				    start.getRow()+((i+1)*rInc) );
	}
	return array;
    }
    
    
    public static Location[] colLocations(Location start, Location end) {
	if (start.getCol() != end.getCol())
	    throw new IllegalArgumentException();
	Location[] array = new Location[Math.abs(end.getRow() - start.getRow())];
	int inc;
	if (end.getRow() > start.getRow())
	    inc = 1;
	else
	    inc = -1;
	for (int i = 0; i < array.length; i++) {
	    array[i] = new Location( start.getCol(),
				     start.getRow()+((i+1)*inc) );
	}
	return array;
    }
    
    
    public static Location[] rowLocations(Location start, Location end) {
	if (start.getRow() != end.getRow())
	    throw new IllegalArgumentException();
	Location[] array = new Location[Math.abs(end.getCol() - start.getCol())];
	int inc;
	if (end.getCol() > start.getCol())
	    inc = 1;
	else
	    inc = -1;
	for (int i = 0; i < array.length; i++) {
	    array[i] = new Location(
				    (char)(start.getCol()+((i+1)*inc)),
				    start.getRow());
	}
	return array;
    }
}
