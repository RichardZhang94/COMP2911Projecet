import java.util.ArrayList;
import java.util.Random;

public class PuzzleDatabase {

	private ArrayList<Puzzle> samplePuzzles = new ArrayList<Puzzle>();
	
	public PuzzleDatabase() {
		addSamplePuzzles();
	}

	//Adds the premade sample puzzles into list
	private void addSamplePuzzles() 
	{
		Puzzle sample1 = new Puzzle();
		
		int count = 1;
		
		while (count != 6) 
		{
			sample1.loadPuzzle("solution" + count);
			//System.out.println("sample1 id is " + sample1.getID());
			samplePuzzles.add(sample1);
			sample1 = new Puzzle();
			count++;
		}
		
		
	}
	
	//Clones a puzzle
	/**
	 * @param p the is puzzle to be cloned
	 * @return the cloned puzzle
	 */
	private Puzzle clone(Puzzle p)
	{
		int row = 0;
		int column = 0;
		Puzzle cloned = new Puzzle();
		
		while (column != 9) 
		{
			while (row != 9) 
			{
				Position temp = p.getPosition(row, column);
				cloned.addPosition(row, column, temp.getValue());
				row++;
			}
			row = 0;
			column++;
		}
		
		cloned.setID(p.getID());
		return cloned;
	}
	
	//Will return a random puzzle from list of puzzles with 25 squares removed
	/**
	 * @return a randomized puzzle with places taken out
	 */
	public Puzzle getPuzzle() 
	{
		Random getNum = new Random();
		
		int x = 0;
		int y = 0;
		
		x = getNum.nextInt(5);
		
		Puzzle temp = this.clone(samplePuzzles.get(x));
		
		int count = 25;
		
		while (count != 0) {
			x = getNum.nextInt(9);
			y = getNum.nextInt(9);
			
			Position p = temp.getPosition(x, y);
			
			if (p.getValue() == temp.DUMMY) 
			{
				//dont consider stuff already removed
			} 
			else 
			{
				temp.clearPosition(x, y);
				count--;
			}
		}
		
		temp.makePositionsSet();
		
		return temp;
	}
	
	//Testing purposes
	/**
	 * @param puzzleID is the id of the puzzle
	 * @return the solution to the puzzle
	 */
	public Puzzle getSolution(String puzzleID)
	{
		int count = 0;
		int puzzle = 0;
		
		while (count != samplePuzzles.size()) 
		{
			Puzzle temp = samplePuzzles.get(count);
			
			if (temp.getID().equals(puzzleID)) 
			{
				puzzle = count;
			}
			count++;
		}
		
		return samplePuzzles.get(puzzle);
	}
	
	//Mainly used for testing purposes
	/**
	 * @param p1 the puzzle to compare the solutions to
	 * @return whether the puzzle matches the solution
	 */
	public boolean comparePuzzle(Puzzle p1)
	{
		boolean answer = true;
		Puzzle solution = new Puzzle();
		char s = p1.getID().charAt(0);
		int x = s - 'A' + 1;
		
		solution.loadPuzzle("solution" + x);
		
		int row = 0;
		int column = 0;
		
		while (column != 9 && answer == true) 
		{
			while (row != 9 && answer == true) 
			{
				if (solution.getValueAtPosition(row, column) != p1.getValueAtPosition(row, column)) 
				{
					answer = false;
				}
				row++;
			}
			row = 0;
			column++;
		}
		return answer;
	}
}
