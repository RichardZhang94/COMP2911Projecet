import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Puzzle {

	private Position[][] sudokuGrid;
	private final int gridSize;
	private final int DUMMY;
	private String puzzleIdentifier;
	
	public Puzzle (String nameOfPuzzle) 
	{
		gridSize = 9;
		DUMMY = -1;
		sudokuGrid = new Position[gridSize][gridSize];
		puzzleIdentifier = nameOfPuzzle;
		
		Position dummyPosition = null;
		
		int row = 0;
		int column = 0;
		
		while (column != gridSize) 
		{
			while (row != gridSize) 
			{
				dummyPosition = new Position (row, column, DUMMY, true);
				sudokuGrid[row][column] = dummyPosition;
				row++;
			}
			row = 0;
			column++;
		}
	}
	
	public void addPosition (int x, int y, int val)
	{
		Position temp = sudokuGrid[x][y];
		
		if (temp.canChange()) {
			Position p = new Position (x, y, val, true);
			sudokuGrid[x][y] = p;
		}
	}
	
	public void clearPosition (int x, int y) 
	{
		
		Position temp = sudokuGrid[x][y];
		
		if (temp.canChange()) 
		{
			Position dummy = new Position (x, y, DUMMY, true);
			sudokuGrid[x][y] = dummy;
		}
		
	}
	
	public void reset()
	{
		int row = 0;
		int column = 0;
		
		while (column != gridSize)
		{
			
			while (row != gridSize) 
			{
				Position dummy = new Position (row, column, DUMMY, true);
				sudokuGrid[row][column] = dummy;
				row++;
			}
			
			row = 0;
			column++;
		}
	}
	
	public int getValueAtPosition (int x, int y) 
	{
		return sudokuGrid[x][y].getValue();
	}
	
	public void clearUnsetPositions()
	{
		int row = 0;
		int column = 0;
		
		while (column != gridSize)
		{
			
			while (row != gridSize) 
			{
				
				Position temp = null;
				
				temp = sudokuGrid[row][column];
				
				if (!temp.canChange()) {
					//do nothing
				} else {
					Position dummy = new Position (row, column, DUMMY, true);
					sudokuGrid[row][column] = dummy;
				}
				row++;
			}
			
			row = 0;
			column++;
		}
	}
	
	public void savePuzzle() {
		
		try 
		{
			File savedPuzzle = new File("C:/Users/User/Desktop/" + puzzleIdentifier + ".txt");
		    FileOutputStream fo = new FileOutputStream(savedPuzzle);
		    OutputStreamWriter osw = new OutputStreamWriter(fo);    
		    BufferedWriter w = new BufferedWriter(osw);
		    
		    int column = gridSize - 1;
		    int row = 0;
		    
		    while (column != 0) 
		    {
		    	while (row != gridSize) 
		    	{
		    		int val = getValueAtPosition(row, column); 
		    		w.write(val + " ");
		    		row++;
		    	}
		    	row = 0;
		    	w.newLine();
		    	column--;
		    }
		    w.close();
		} catch (IOException e) {
		    System.err.println("Problem has occured");
		}
	}
}
