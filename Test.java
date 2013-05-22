
public class Test {

	Puzzle thePuzzle;
	
	public Test() {
		thePuzzle = new Puzzle();
	}

	public void runTests() {
		testAdd();
		testClear();
		testSolver();
	}
	
	//Tests solver
	private void testSolver() {
		boolean answer = true;
		boolean temp = false;
		
		temp = thePuzzle.checkPuzzle();
		
		if (temp) {
			System.out.println("Solver tests failed");
		}
		
		
		
		if (answer) {
			System.out.println("Solver tests passed");
		}
	}

	//Tests clear functions
	private void testClear() {
		thePuzzle.reset();
		boolean answer = true;
		
		int row = 0;
		int column = 0;
		
		while (column != 9 && answer == true) {
			while (row != 9 && answer == true) {
				if (thePuzzle.getValueAtPosition(row, column) != 0) {
					System.out.println("Clearing tests failed");
					answer = false;
				}
				row++;
			}
			row = 0;
			column++;
		}
		
		thePuzzle.addPosition(0, 0, 4);
		thePuzzle.addPosition(0, 1, 5);
		thePuzzle.clearPosition(0, 2);
		
		if (thePuzzle.getValueAtPosition(0, 2) != 0) {
			System.out.println("Clearing tests failed");
			answer = false;
		}
		
		thePuzzle.clearPosition(0, 1);
		
		if (thePuzzle.getValueAtPosition(0, 1) != 0) {
			System.out.println("Clearing tests failed");
			answer = false;
		}
		
		if (answer) {
			System.out.println("Clearing tests passed");
		}
	}

	//Test the add function
	private void testAdd() {
		boolean answer = true;
		
		thePuzzle.addPosition(0, 0, 1);
		
		if (thePuzzle.getValueAtPosition(0, 0) != 1) {
			System.out.println("Adding tests failed");
			answer = false;
		}
		
		thePuzzle.addPosition(0, 0, 0);
		
		if (thePuzzle.getValueAtPosition(0, 0) != 1) {
			System.out.println("Adding tests failed");
			answer = false;
		}
		
		thePuzzle.addPosition(0, 0, 10);
		
		if (thePuzzle.getValueAtPosition(0, 0) != 1) {
			System.out.println("Adding tests failed");
			answer = false;
		}
		
		int count = 0;
		
		while (count != 9 && answer == true) {
			thePuzzle.addPosition(count, count, 5);
			count++;
		}
		
		count = 0;
		while (count != 9 && answer == true) {
			if (thePuzzle.getValueAtPosition(count, count) != 5) {
				System.out.println("Adding tests failed");
				answer = false;
			}
			count++;
		}
		
		if (answer) {
			System.out.println("Adding tests passed");
		}
	}
	
	
	
}
