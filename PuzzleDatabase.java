import java.util.ArrayList;
import java.util.Random;

public class PuzzleDatabase {

	private ArrayList<Puzzle> samplePuzzles = new ArrayList<Puzzle>();
	
	public PuzzleDatabase() {
		addSamplePuzzles();
	}

	private void addSamplePuzzles() 
	{
		Puzzle sample1 = new Puzzle();
		
		int count = 1;
		
		while (count != 6) {
			sample1.loadPuzzle("solution" + count);
			samplePuzzles.add(sample1);
			count++;
		}
		
		
	}
	
	//Will return a random puzzle from list of puzzles with 8 squares removed
	public Puzzle getPuzzle() 
	{
		Random getNum = new Random();
		
		int x = getNum.nextInt(5);
		int y = 0;
		
		Puzzle temp = samplePuzzles.get(x);
		
		int count = 8;
		
		while (count != 0) {
			x = getNum.nextInt(8);
			y = getNum.nextInt(8);
			
			Position p = temp.getPosition(x, y);
			
			if (p.getValue() == temp.DUMMY) {
				//dont consider stuff already removed
			} else {
				temp.clearPosition(x, y);
				count--;
			}
		}
		
		temp.makePositionsSet();
		
		return temp;
	}
	
}
