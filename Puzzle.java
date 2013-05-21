import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Puzzle {

	private Position[][] sudokuGrid;
	private final int gridSize;
	private final int DUMMY;
	private String puzzleIdentifier;
	private String puzzleID;
	
	public Puzzle() 
	{
		gridSize = 9;
		DUMMY = 0;
		sudokuGrid = new Position[gridSize][gridSize];
		
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
	
	public void addPosition(int x, int y, int val)
	{
		if (isLegal(x) && isLegal(y) && isLegalVal(val))
		{
			Position temp = sudokuGrid[x][y];
			
			if (temp.canChange()) {
				Position p = new Position (x, y, val, true);
				sudokuGrid[x][y] = p;
			}
		} else 
		{
			System.out.println("Invalid coordinates or value");
		}
		
	}
	
	public void makePositionsSet()
	{
		int row = 0;
		int column = 0;
		
		while (column != gridSize)
		{
			
			while (row != gridSize) 
			{
				Position temp = sudokuGrid[row][column];
				if (temp.getValue() != DUMMY) {
					Position setPosition = new Position(row, column, temp.getValue(), false);
					sudokuGrid[row][column] = setPosition;
				}
				row++;
			}
			
			row = 0;
			column++;
		}
	}
	
	public void clearPosition (int x, int y) 
	{
		if (isLegal(x) && isLegal(y)) 
		{
			
			Position temp = sudokuGrid[x][y];
			
			if (temp.canChange()) 
			{
				Position dummy = new Position (x, y, DUMMY, true);
				sudokuGrid[x][y] = dummy;
			}
		} else 
		{
			System.out.println("Invalid coordinates");
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
		int value = 0;
		
		if (isLegal(x) && isLegal(y))
		{
			value = sudokuGrid[x][y].getValue();
		} else 
		{
			System.out.println("Invalid coordinates");
		}
		
		return value;
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
	
	public void setPuzzleName(String name) 
	{
		puzzleIdentifier = name;
	}
	
	public void setID(String x) 
	{
		puzzleID = x;
	}
	
	public String getID() 
	{
		return puzzleID;
	}
	
	public void savePuzzle() 
	{
		
		try 
		{
			File savedPuzzle = new File("C:/Users/User/Desktop/sudoku/userPuzzles/" + puzzleIdentifier + ".txt");
		    FileOutputStream fo = new FileOutputStream(savedPuzzle);
		    OutputStreamWriter osw = new OutputStreamWriter(fo);    
		    BufferedWriter w = new BufferedWriter(osw);
		    
		    int column = 0;
		    int row = 0;
		    
		    w.write(puzzleID);
		    w.newLine();
		    while (column != gridSize) 
		    {
		    	while (row != gridSize) 
		    	{
		    		int val = getValueAtPosition(row, column); 
		    		w.write(val + " ");
		    		row++;
		    	}
		    	row = 0;
		    	w.newLine();
		    	column++;
		    }
		    w.close();
		} catch (IOException e) {
		    System.out.println("Problem has occured");
		}
	}
	
	public void loadPuzzle(String filename) 
	{
		String s = null;
		
		if (filename.contains("samplePuzzle") && filename.contains("solution")) {
			s = "C:/Users/User/Desktop/sudoku/";
		} else {
			s = "C:/Users/User/Desktop/sudoku/userPuzzles/";
		}
		
		try
		{
			//System.out.println("hi");
			Scanner sc = new Scanner(new FileReader(s + filename + ".txt")); 
			//System.out.println("hi");
			readPuzzle(sc);
			
			sc.close();
		}
		
		catch (NoSuchElementException n) 
		{
			
		}
		
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found!");
		}
		
	}

	private void readPuzzle(Scanner sc) 
	{
		int row = 0;
		int column = 0;
		
		String id = sc.next();
		puzzleID = id;
		while (column != gridSize) 
		{
			while (row != gridSize) 
			{
				//System.out.println("hi");
				//String stemp = sc.next();
				int val = sc.nextInt();
				//System.out.println("hi");
				this.addPosition(row, column, val);
				row++;
			}
			row = 0;
			column++;
		}

		//System.out.println("completed");
	}
	
	public boolean checkPuzzle() {
		Solver check = new Solver();
		boolean answer = false;
		
		answer = check.solved(this);
		
		return answer;
	}

	private boolean isLegal(int x) {
		boolean answer = true;
		
		if (x >= gridSize) {
			answer = false;
		}
		
		return answer;
	}
	
	private boolean isLegalVal(int x) {
		boolean answer = false;
		
		if (x > 0 && x < 10) {
			answer = true;
		}
		
		return answer;
	}
}
