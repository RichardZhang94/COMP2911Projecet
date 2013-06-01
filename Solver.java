import java.util.ArrayList;


public class Solver {
	public ArrayList<Integer> checker = new ArrayList<Integer>();
	
	//This function will check if the attempted puzzle is correct, that is it follows the rules of sudoku with regards to numbers and positions
	public boolean solved(Puzzle attempt)
	{
		int startSquareX = 0;
		int startSquareY = 0;
		int endSquareX = 0;
		int endSquareY = 0;
		int row = 0;
		int column = 0;
		int checkerCounter = 0;
		int arraySize = 0;
		boolean solved = true;
		  
		//We assume it is solved as it is more efficient to prove it is not and thus, avoid running redundant parts of the method.  
		while(row != 9 && solved == true)
		{
			while (column != 9 && solved == true)
			{
				while(checkerCounter != arraySize)
				{
					//This checks along a column, adding each value to the arraylist as we check, if any value occurs twice, solved becomes false or if we have any 0s
					if (attempt.getValueAtPosition(column,row) == checker.get(checkerCounter)
						||(attempt.getValueAtPosition(column,row)== 0))
					{
						solved = false;
						System.out.println(checkerCounter);
					}
					checkerCounter++;
				}
				//Sets the variables for the next position as well as adding the current value to the array list	
				checker.add(attempt.getValueAtPosition(column,row));
				checkerCounter = 0;
				arraySize++;
				column ++;
			}
			//Resets the array and positions for the next row
			checker.clear();
			arraySize = 0;
			row++;
			column = 0;
		}
			
		row = 0;
		column = 0;
		checker.clear();
			  
		while (column != 9 && solved == true)
		{
			while (row != 9 && solved == true)
			{
			
				while (checkerCounter != arraySize)
				{
					//This checks along a row, adding each value to the arraylist as we check, if any value occurs twice, solved becomes false or if we have any 0s
					if ((attempt.getValueAtPosition(column,row) == checker.get(checkerCounter))
						 ||(attempt.getValueAtPosition(column,row) == 0))
					{
						solved = false;
					}
					checkerCounter++;
				}
				//Sets the variables for the next position as well as adding the current value to the array list	
				checker.add(attempt.getValueAtPosition(column,row));
				checkerCounter = 0;
				row ++;
				arraySize++;
			}
			//Resets the array and positions for the next column
			checker.clear();
			column  ++;
			row = 0;
			arraySize = 0;
		}
		
		//Resets the array+size and prepares to check the all the boxes to see if they comply with the rules of sudoku (1 occurrence of each value in each 3x3 square)
		checker.clear();
		arraySize = 0;
			
		//To check box 1
		startSquareX = 0;
		startSquareY = 0;
		endSquareX = 3;
		endSquareY = 3;
			
		while (startSquareX != endSquareX && solved == true)
		{
				while (startSquareY != endSquareY && solved == true)
				{
					while (checkerCounter != arraySize)
					{
						if (attempt.getValueAtPosition(startSquareX,startSquareY) == checker.get(checkerCounter))
						{
							solved = false;
						}
						checkerCounter++;
					}
				checker.add(attempt.getValueAtPosition(startSquareX,startSquareY));
				checkerCounter = 0;
				startSquareY++;
				arraySize++;
				}
				startSquareX++;
		}
			
		checker.clear();
		arraySize = 0;
			
		//To check box 2 
		startSquareX = 3;
		startSquareY = 0;
		endSquareX = 6;
		endSquareY = 3;
			
		while (startSquareX != endSquareX && solved == true)
		{
			while (startSquareY != endSquareY && solved == true)
			{
				while(checkerCounter != arraySize)
				{
					if (attempt.getValueAtPosition(startSquareX,startSquareY) == checker.get(checkerCounter))
					{
						solved = false;
					}
					checkerCounter++;
				}
				checker.add(attempt.getValueAtPosition(startSquareX,startSquareY));
				checkerCounter = 0;
				startSquareY++;
			}
			startSquareX++;
		}
			
		checker.clear();
		arraySize = 0;
			
		//To check box 3
		startSquareX = 6;
		startSquareY = 0;
		endSquareX = 9;
		endSquareY = 3;
		  
		while (startSquareX != endSquareX && solved == true)
		{
			while (startSquareY != endSquareY && solved == true)
		    {
				while(checkerCounter != arraySize)
				{
					if (attempt.getValueAtPosition(startSquareX,startSquareY) == checker.get(checkerCounter))
					{
						solved = false;
					}
					checkerCounter++;
				}
				checker.add(attempt.getValueAtPosition(startSquareX,startSquareY));
				checkerCounter = 0;
				startSquareY++;
				arraySize++;
		    }
			startSquareX++;
		}
			
		checker.clear();
		arraySize = 0;
			
		//To check box 4
		startSquareX = 0;
		startSquareY = 3;
		endSquareX = 3;
		endSquareY = 6;
		 
		while (startSquareX != endSquareX && solved == true)
		{
			while (startSquareY != endSquareY && solved == true)
			{
				while (checkerCounter != arraySize)
				{
					if (attempt.getValueAtPosition(startSquareX,startSquareY) == checker.get(checkerCounter))
					{
						solved = false;
					}
					checkerCounter++;
				}
				checker.add(attempt.getValueAtPosition(startSquareX,startSquareY));
				checkerCounter = 0;
				startSquareY++;
				arraySize++;
			}
			startSquareX++;
		}
			
		checker.clear();
		arraySize = 0;
			
			
		//To check box 5
		startSquareX = 3;
		startSquareY = 3;
		endSquareX = 6;
		endSquareY = 6;
		  
		while (startSquareX != endSquareX && solved == true)
		{
			while (startSquareY != endSquareY && solved == true)
			{
				while (checkerCounter != arraySize)
				{
					if (attempt.getValueAtPosition(startSquareX,startSquareY) == checker.get(checkerCounter))
					{
						solved = false;
					}
					checkerCounter++;
				}
				checker.add(attempt.getValueAtPosition(startSquareX,startSquareY));
				checkerCounter = 0;
				startSquareY++;
				arraySize++;
			}
			startSquareX++;
		}
			
		checker.clear();
		arraySize = 0;
			
		//To check box 6
		startSquareX = 6;
		startSquareY = 3;
		endSquareX = 9;
		endSquareY = 6;

		while (startSquareX != endSquareX && solved == true)
		{
			while (startSquareY != endSquareY && solved == true)
			{
				while (checkerCounter != arraySize)
				{
					if (attempt.getValueAtPosition(startSquareX,startSquareY) == checker.get(checkerCounter))
					{
						solved = false;
					}
					checkerCounter++;
				}
				checker.add(attempt.getValueAtPosition(startSquareX,startSquareY));
				checkerCounter = 0;
				startSquareY++;
				arraySize++;
			}
			startSquareX++;
		}
			
		checker.clear();
		arraySize = 0;
			
		//To check box 7
		startSquareX = 0;
		startSquareY = 6;
		endSquareX = 3;
		endSquareY = 9;
		 
		while (startSquareX != endSquareX && solved == true)
		{
			while (startSquareY != endSquareY && solved == true)
			{
				while (checkerCounter != arraySize)
				{
					if (attempt.getValueAtPosition(startSquareX,startSquareY) == checker.get(checkerCounter))
					{
						solved = false;
					}
					checkerCounter++;
				}
				checker.add(attempt.getValueAtPosition(startSquareX,startSquareY));
				checkerCounter = 0;
				startSquareY++;
				arraySize++;
			}
			startSquareX++;
		}
			
		checker.clear();
		arraySize = 0;
			
		//To check box 8
		startSquareX = 3;
		startSquareY = 6;
		endSquareX = 6;
		endSquareY = 9;
		  
		while (startSquareX != endSquareX && solved == true)
		{
			while (startSquareY != endSquareY && solved == true)
			{
				while (checkerCounter != arraySize)
				{
					if (attempt.getValueAtPosition(startSquareX,startSquareY) == checker.get(checkerCounter)){
						solved = false;
					}
					checkerCounter++;
				}
				checker.add(attempt.getValueAtPosition(startSquareX,startSquareY));
				checkerCounter = 0;
				startSquareY++;
				arraySize++;
			}
			startSquareX++;
		}
		
		checker.clear();
		arraySize = 0;
			
		//To check box 9
		startSquareX = 6;
		startSquareY = 6;
		endSquareX = 9;
		endSquareY = 9;
		  
		while (startSquareX != endSquareX && solved == true)
		{
			while (startSquareY != endSquareY && solved == true)
			{
				while (checkerCounter != arraySize)
				{
					if (attempt.getValueAtPosition(startSquareX,startSquareY) == checker.get(checkerCounter))
					{
						solved = false;
					}
					checkerCounter++;
				}
				checker.add(attempt.getValueAtPosition(startSquareX,startSquareY));
				checkerCounter = 0;
				startSquareY++;
				arraySize++;
			}
			startSquareX++;
		}
			
		checker.clear();
		arraySize = 0;
		//The only way to return true is if we never went into any of the if loops, meaning we do not have any double occurrences or 0s.
		return solved;
	}
}
