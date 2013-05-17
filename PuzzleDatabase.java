import java.util.ArrayList;

public class PuzzleDatabase {

	private ArrayList<Puzzle> samplePuzzles = new ArrayList<Puzzle>();
	private ArrayList<Puzzle> solutionPuzzles = new ArrayList<Puzzle>();
	
	public PuzzleDatabase() {
		addSamplePuzzles();
	}

	private void addSamplePuzzles() 
	{
		Puzzle sample1 = new Puzzle();
		
		sample1.loadPuzzle("samplePuzzle1");
		sample1.makePositionsSet();

		samplePuzzles.add(sample1);
		
		Puzzle sampleSolution1 = new Puzzle();
		
		sampleSolution1.loadPuzzle("solution1");
		
		solutionPuzzles.add(sampleSolution1);
	}
	
	public Puzzle getPuzzle(int x) 
	{
		return samplePuzzles.get(x);
	}
	
	public Puzzle getSolution(String s) 
	{
		int count = 0;
		Puzzle solution = null;
		
		while (count != samplePuzzles.size()) {
			Puzzle temp = solutionPuzzles.get(count);
			if (temp.getID().equals(s)) {
				solution = temp;
			}
			count++;
		}
		return solution;
	}
}
