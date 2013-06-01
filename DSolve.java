public class DSolve {
    //A variable boolean to be used as an indication if the dynamic solver has solved the puzzle.
	private boolean failed;
    
    //This entire class is the dynamic solver, the constructor itself runs part of a method in aiding the dynamic solver in doing its job.
    //The several as a whole, utilizes several temporary variables which are designed to aid in ease of writing the methods and making the code more efficient (rowTmp, colTmp) and booleans which are meant to be early breaks, further optimizing run time.
	
    //There is no need to call separate methods in this class. All methods are called within the constructor, the class is self-managed, it only needs to be constructed in the parent call.
    //The constructor contains a loop and counter for that loop, the loop will go through the puzzle and solve it, each iteration of the loop solving more and more of the puzzle.
  
    public DSolve(Puzzle solving){
	    int row = 0;
	    int column = 0;
	    int value =0;
	    boolean done = false;
	    boolean failed = false;
	    int counter = 0;
	   
	    //This part of the method goes through each of the puzzle's 81 squares (at worst) 81 times and applies the class's methods each time.
	    //The function breaks (via while loop condition) after 81 repeats (to prevent a useless infinite loop) or if all 81 squares have a value (indicating it is done).
	    while (done != true && failed != true) 
	    {  
	    	//Traverses the entire puzzle by going through each row (0-8) then incrementing the column and resetting row back to 0.
	    	while (column != 9) 
	    	{  
	    		while (row != 9) 
	    		{
	    			//Prepares to run the setImpossible method. Will only run it for appropiate squares (squares we have not checked yet).
	    			if (solving.getValueAtPosition(column,row) != 0 && solving.getPosition(column,row).getListSize() !=0)
	    			{
	    				value = solving.getValueAtPosition(column,row);
	    				setImpossible(solving,column,row,value);
	    			}
	    			//Runs the two solver methods whilst also incrementing across the row for the next square.
	    			setValueSingleElement(solving);
	    			setValueSpecialCases(solving);
	    			row++;
	    		} 
	    		//Increments the column and resets the row so it can go through the row for the next column.
	    		row = 0;
	    		column++;
	    	}
	    	//Resets parameters except for counter and proceeds to go through it again.
	    	row = 0;
	    	column = 0;
	    	counter++;
	    	
	    	//The infinite loop failsafe.
	    	if (counter == 81) {
	    		failed = true;
	    	}
	    	
	    	//Calls the filled function to see if we have got a value for all 81 squares.
	    	done = filled(solving);
	    }
	    
	}
    
    //If the solver failed to do its job and it "timed out" after the 81 loops above, it will return a fail. 81 was chosen because it is enough time to assume the worst (and notably logically impossible)
    //case that it had to solve each square once per loop.
	public boolean didNotSolve()
	{
		return failed;
	}
	
	//Checks if we have put something in every square which means we have (hopefully) solved the puzzle and that we can break the solver's loop so it will not return a fail.
	private boolean filled(Puzzle solving)
	{
	    int column = 0;
	    int row = 0;
		boolean filled = true;
		
		//Goes through the entire grid, all 81 squares and checks if they have had a value put into them.
	    while (column != 9 && filled == true)
	    {  
	    	while (row != 9)
	    	{
	    		//If any square is a 0, meaning we are not done, set filled to false and break the loop.
	    		if (solving.getValueAtPosition(column,row) == 0)
	    		{
	    			filled = false;
	    		}
	    		row++;
	    	}
	    	row = 0;
	    	column++;
	    }
      return filled;
	}
	
	//This function does one thing and one thing alone, it, using a single position's location and value (which is non 0) and removes the possible values of the positions which are directly relate  to that position.
	//The related positions are those which correspond to the rules of Sudoku, it will remove the value of that position from the linked lists of positions in the same row, same column and same square as the specified element.
	private void setImpossible(Puzzle solving,int column, int row, int value)
	{
	    int rowTmp = 0;
	    int colTmp = 0;
	    
	    //Sets the impossible value along the column, removing all occurences of the value from the list of possible values for each square in the same column
	    while (colTmp != 9)
	    {
	    	if (solving.getPosition(colTmp,row).checkContains(value))
	    	{
	    		solving.getPosition(colTmp,row).removeVal(value);
	    	}
	    	colTmp++;
	    }
	    
	  //Sets the impossible value along the row, removing all occurences of the value from the list of possible values for each square in the same row.
	    while (rowTmp != 9)
	    {
	    	if (solving.getPosition(column, rowTmp).checkContains(value))
	    	{
	    		solving.getPosition(column,rowTmp).removeVal(value);
	    	}
	    	rowTmp++;
	    }
	    
	    //The following 9 if statements cover all the 9 different possible squares the position can be in and removes all occurences of the value from the list of possible values for each square in the same square.
	    
	    //Case if element is in Square 1
	    rowTmp = 0;
	    colTmp = 0;
	    
	    if (row < 3 && column < 3)
	    {
	    	while (rowTmp != 3)
	    	{
	    		while (colTmp != 3)
	    		{
	    			if (solving.getPosition(colTmp, rowTmp).checkContains(value))
	    			{
	    				solving.getPosition(colTmp,rowTmp).removeVal(value);
	    		    }
	    			colTmp++;
	    		}
	    		colTmp = 0;
	    		rowTmp++;
	    	}
	    }
	    
	    //Case if element is in Square 2
	    rowTmp = 0;
	    colTmp = 3;
	    if (row < 3 && column < 6 && column > 2)
	    {
	    	while (rowTmp != 3)
	    	{
	    		while (colTmp != 6)
	    		{
	    			if (solving.getPosition(colTmp, rowTmp).checkContains(value))
	    			{
	    				solving.getPosition(colTmp,rowTmp).removeVal(value);
	    		    }
	    			colTmp++;
	    		}
	    		colTmp = 3;
	    		rowTmp++;
	    	}
	    }
	    
	    //Case if element is in Square 3
	    rowTmp = 0;
	    colTmp = 6;
	    if (row < 3 && column < 9 && column > 5) 
	    {
	    	while (rowTmp != 3)
	    	{
	    		while (colTmp != 9)
	    		{
	    			if (solving.getPosition(colTmp, rowTmp).checkContains(value))
	    			{
	    				solving.getPosition(colTmp,rowTmp).removeVal(value);
	    		    }
	    			colTmp++;
	    		}
	    		colTmp = 6;
	    		rowTmp++;
	    	}
	    }
	    
	    //Case if element is in Square 4
	    rowTmp = 3;
	    colTmp = 0;
	    if (row < 6 && column < 3 && row > 2)
	    {
	    	while (rowTmp != 6)
	    	{
	    		while (colTmp != 3)
	    		{
	    			if (solving.getPosition(colTmp, rowTmp).checkContains(value))
	    			{
	    				solving.getPosition(colTmp,rowTmp).removeVal(value);
	    		    }
	    			colTmp++;
	    		}
	    		colTmp = 0;
	    		rowTmp++;
	    	}
	    }
	    
	    //Case if element is in Square 5
	    rowTmp = 3;
	    colTmp = 3;
	    if (row < 6 && column < 6 && row > 2 && column > 2)
	    {
	    	while (rowTmp != 6)
	    	{
	    		while (colTmp != 6)
	    		{
	    			if (solving.getPosition(colTmp, rowTmp).checkContains(value))
	    			{
	    				solving.getPosition(colTmp,rowTmp).removeVal(value);
	    		    }
	    			colTmp++;
	    		}
	    		colTmp = 3;
	    		rowTmp++;
	    	}
	    }
	    
	    //Case if element is in Square 6
	    rowTmp = 3;
	    colTmp = 6;
	    if (row < 6 && column < 9 && row > 2 && column > 5)
	    {
	    	while (rowTmp != 6)
	    	{
	    		while (colTmp!=9)
	    		{
	    			if (solving.getPosition(colTmp, rowTmp).checkContains(value))
	    			{
	    				solving.getPosition(colTmp,rowTmp).removeVal(value);
	    		    }
	    			colTmp++;
	    		}
	    		colTmp = 6;
	    		rowTmp++;
	    	}
	    }
	    
	    //Case if element is in Square 7
	    rowTmp = 6;
	    colTmp = 0;
	    if (row < 9 && column < 3 && row > 5)
	    {
	    	while (rowTmp != 9)
	    	{
	    		while (colTmp!=3)
	    		{
	    			if (solving.getPosition(colTmp, rowTmp).checkContains(value))
	    			{
	    				solving.getPosition(colTmp,rowTmp).removeVal(value);
	    		    }
	    			colTmp++;
	    		}
	    		colTmp = 0;
	    		rowTmp++;
	    	}
	    }
	    
	    //Case if element is in Square 8
	    rowTmp = 6;
	    colTmp = 3;
	    if (row < 9 && column < 6 && column > 2 && row > 5)
	    {
	    	while (rowTmp != 9)
	    	{
	    		while (colTmp != 6)
	    		{
	    			if(solving.getPosition(colTmp, rowTmp).checkContains(value))
	    			{
	    				solving.getPosition(colTmp,rowTmp).removeVal(value);
	    		    }
	    			colTmp++;
	    		}
	    		colTmp = 3;
	    		rowTmp++;
	    	}
	    }
	    
	    rowTmp = 6;
	    colTmp = 6;
	    if (row < 9 && column < 9 && row > 5 && column > 5)
	    {
	    	while(rowTmp != 9)
	    	{
	    		while(colTmp != 9)
	    		{
	    			if (solving.getPosition(colTmp, rowTmp).checkContains(value))
	    			{
	    				solving.getPosition(colTmp,rowTmp).removeVal(value);
	    		    }
	    			colTmp++;
	    		}
	    		colTmp = 6;
	    		rowTmp++;
	    	}
	    }
	}
	
	//This function relies heavily on the "setImpossible" function. How this function works is, once the setImpossible function has run enough times, certain positions will have
	//only 1 element in their list of possible values. By logical reasoning, this last remaining element must be the value of that square and this function scans the puzzle
	//finds the positions with only 1 element in its array list which has not had its value set (i.e value = 0) and, sets the value to that number.
	private void setValueSingleElement(Puzzle solving)
	{
		int value = 0;
		int row = 0;
		int column = 0;
		
		//Traverses all 81 squares, seeing which values can be set and sets them.
		while (row != 9)
		{
			while (column != 9)
			{
				
				//If there is only one possible value left in the position's list, that value must be the square's actual value. So we acquire that value and set it to the position.
				if (solving.getPosition(column, row).getListSize() == 1 
					&& solving.getValueAtPosition(column,row) == 0)
				{
					value = solving.getPosition(column, row).getLastVal();
					solving.changeValueAtPosition(column, row, value);
				}
				column++;
			}
			column = 0;
			row++;
		}
	}

	//This function is designed to encompass certain cases which the above solver may not be able to deal with. 
	//This method slows down the run time of the program and the program is perfectly capable of running without but this method is to catch special circumstances (not all but many).
	private void setValueSpecialCases(Puzzle solving)
	{
		int row = 0;
		int column = 0;
		int colTmp = 0;
		int rowTmp = 0;

		int counter = 1;
		boolean onlyValue = true;
		boolean changed = false;
		
		//Goes through every position
		while (row != 9)
		{
			while (column != 9)
			{
				//If the value has not yet been solved for, we go into the main part of the method.
				if (solving.getValueAtPosition(column,row) == 0)
				{  
					//This loop goes through 1-9, checking if the element contains any of them, if it does, proceeds to run the if loop.
					while (counter != 10 && changed != true)
					{
						rowTmp = 0;
						colTmp = 0;
						//So the position contains the value of counter, we now check if it is the only occurrence of that value in its row/column/square.
						if (solving.getPosition(column, row).checkContains(counter))
						{   
							//We assume that there is no other occurrence, if there is we set the variable to false so we can have an early break as we have established it is not the only possibility in the row.
							while (rowTmp != 9 && onlyValue == true && changed != true)
							{
								if (solving.getPosition(column,rowTmp).checkContains(counter)&& rowTmp != row)
								{
									onlyValue = false;
								}
								rowTmp++;
							}
							
							//If there is no other occurrence, it must be at the current position and this will set that position to the correct value.
							if (onlyValue == true  && changed!= true)
							{
								solving.changeValueAtPosition(column, row, counter);
								clearing(solving, column, row, counter);
								changed = true;
							}
				
							onlyValue = true;
				   
							//We assume that there is no other occurrence, if there is we set the variable to false so we can have an early break as we have established it is not the only possibility in the column.
							while (colTmp != 9 && onlyValue == true && changed != true)
							{
								if (solving.getPosition(colTmp,row).checkContains(counter)&& colTmp != column)
								{
									onlyValue = false;
								}
								colTmp++;
							}
							
							//If there is no other occurrence, it must be at the current position and this will set that position to the correct value
							if (onlyValue == true  && changed != true)
							{
								solving.changeValueAtPosition(column, row, counter);
								clearing(solving, column, row, counter);
								changed = true;
						
							}
					  
							onlyValue = true;
							
							//Now we check the square which the position is contained in and check if it is the only possibility for the "checker" value in that square.
				
							//Case if element is in Square 1
							rowTmp = 0;
							colTmp = 0;
							if (row < 3 && column < 3)
							{
								while (rowTmp != 3)
								{
									while (colTmp != 3)
									{
										if (solving.getPosition(colTmp, rowTmp).checkContains(counter))
										{
											if(rowTmp == row && colTmp == column){
											
											}else{
										
												onlyValue = false;
											}
										}
										colTmp++;
									}
									colTmp = 0;
									rowTmp++;
								}
							}
			    
							//Case if element is in Square 2
							rowTmp = 0;
							colTmp = 3;
							if (row < 3 && column < 6 && column > 2)
							{
								while (rowTmp != 3)
								{
									while (colTmp !=6 )
									{
										if (solving.getPosition(colTmp, rowTmp).checkContains(counter))
										{
											if(rowTmp == row && colTmp == column){
											
											}else{
										
												onlyValue = false;
											}
										}
										colTmp++;
									}
									colTmp = 3;
									rowTmp++;
								}
							}
			    
							//Case if element is in Square 3
							rowTmp = 0;
							colTmp = 6;
							if (row < 3 && column < 9 && column > 5)
							{
								while (rowTmp != 3)
								{
									while (colTmp != 9)
									{
										if (solving.getPosition(colTmp, rowTmp).checkContains(counter))
										{
											if(rowTmp == row && colTmp == column){
											
											}else{
										
												onlyValue = false;
											}
										}
										colTmp++;
									}
									colTmp = 6;
									rowTmp++;
								}
							}
			    
							//Case if element is in Square 4
							rowTmp = 3;
							colTmp = 0;
							if (row < 6 && column < 3 && row > 2)
							{
								while (rowTmp != 6)
								{
									while (colTmp != 3)
									{
										if (solving.getPosition(colTmp, rowTmp).checkContains(counter))
										{
											if(rowTmp == row && colTmp == column){
											
											}else{
										
												onlyValue = false;
											}
										}
										colTmp++;
									}
									colTmp = 0;
									rowTmp++;
								}
							}
			    
							//Case if element is in Square 5
							rowTmp = 3;
							colTmp = 3;
							if (row < 6 && column < 6 && row > 2 && column > 2)
							{
								while (rowTmp != 6)
								{
									while (colTmp != 6)
									{
										if (solving.getPosition(colTmp, rowTmp).checkContains(counter))
										{
											if(rowTmp == row && colTmp == column){
											
											}else{
										
												onlyValue = false;
											}
										}
										colTmp++;
									}
									colTmp = 3;
									rowTmp++;
								}
							}
			    
							//Case if element is in Square 6
							rowTmp = 3;
							colTmp = 6;
							if (row < 6 && column < 9 && row > 2 && column > 5)
							{
								while (rowTmp != 6)
								{
									while (colTmp != 9)
									{
										if (solving.getPosition(colTmp, rowTmp).checkContains(counter))
										{
											if(rowTmp == row && colTmp == column){
											
											}else{
										
												onlyValue = false;
											}
										}
										colTmp++;
									}
									colTmp = 6;
									rowTmp++;
								}
							}
			    
							//Case if element is in Square 7
							rowTmp = 6;
							colTmp = 0;
							if (row < 9 && column < 3 && row > 5)
							{
								while (rowTmp != 9)
								{
									while (colTmp != 3)
									{
										if (solving.getPosition(colTmp, rowTmp).checkContains(counter))
										{
											if(rowTmp == row && colTmp == column){
											
											}else{
										
												onlyValue = false;
											}
										}
										colTmp++;
									}
									colTmp = 0;
									rowTmp++;
								}
							}
			    
							//Case if element is in Square 8
							rowTmp = 6;
							colTmp = 3;
							if (row < 9 && column < 6 && column > 2 && row > 5)
							{
								while (rowTmp != 9)
								{
									while(colTmp != 6)
									{
										if (solving.getPosition(colTmp, rowTmp).checkContains(counter))
										{
											if(rowTmp == row && colTmp == column){
											
											}else{
										
												onlyValue = false;
											}
										}
										colTmp++;
									}
									colTmp = 3;
									rowTmp++;
								}	
							}
			    
							//Case if element is in Square 9
							rowTmp = 6;
							colTmp = 6;
							if (row < 9 && column < 9 && row > 5 && column > 5)
							{
								while (rowTmp != 9)
								{
									while (colTmp != 9)
									{
										if (solving.getPosition(colTmp, rowTmp).checkContains(counter))
										{
											if(rowTmp == row && colTmp == column){
											
											}else{
										
												onlyValue = false;
											}
										}
										colTmp++;
									}
									colTmp = 6;
									rowTmp++;
								}
							}
							
							//If there is no other occurrence, it must be at the current position and this will set that position to the correct value
							if (onlyValue == true  && changed!= true)
							{
								solving.changeValueAtPosition(column, row, counter);
								clearing(solving, column, row, counter);
								changed = true;
							}
							onlyValue = true;
						}	
						counter++;
						onlyValue = true;
					}
				}	
				column++;
				counter = 1;
				changed = false;
				onlyValue = true;
			}
			row++;
			column = 0;
		}
	} 
	
	
	//A function which is meant to work in conjunction with the special case removals, it ensures that there will not be unusual conflicts with the other function.
	//To be precise, this function removes all the other elements in the special case's position's linked list of possible elements so it can be utilized by the "setImpossible" function which is called at the end of this function as insurance.
	public void clearing(Puzzle solving, int column,int row,int value){
		int tmp = 0;
		
		while(tmp!= 10){
			if(solving.getPosition(column,row).checkContains(tmp)&& tmp != value)
			{
				solving.getPosition(column,row).removeVal(tmp);
			}
			tmp ++;
		}
		setImpossible(solving, column, row, value);
	}
	
}
	


