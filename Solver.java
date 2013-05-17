import java.util.ArrayList;

public class Solver {
	
	private final int DUMMY = -1;
	
	public boolean solved(Puzzle attempt){
		int startSquareX = 0;
		int startSquareY = 0;
		int endSquareX = 0;
		int endSquareY = 0;
		int row = 0;
		int column = 0;
		int checkerCounter = 0;
		boolean solved = true;
		ArrayList<Integer> checker = new ArrayList<Integer>();
		Position temp = null;
		
		while (row != 9 && solved == true)
		{
			while (column != 9 && solved == true)
			{
		     
				//checker.get(checkerCounter) != null
				while (checkerCounter != checker.size())
				{
					temp = attempt.getPosition(row, column);
					
					if (temp.getValue() == checker.get(checkerCounter) || temp.getValue() == DUMMY) 
					{
						solved = false;
					}
					
					checkerCounter++;
				}
				
				checker.add(temp.getValue());
				checkerCounter = 0;
				column ++;
			}
			checker.clear();
			row++;
		}
		
		row = 0;
		column = 0;
		temp = null;
		checker.clear();
			  
		while(column != 9 && solved == true)
		{
			while(row != 9 && solved == true)
			{
		     
				while(checker.get(checkerCounter) != null)
				{
					
					temp = attempt.getPosition(row, column);
					
					if (temp.getValue() == checker.get(checkerCounter) || temp.getValue() == DUMMY) 
					{
						solved = false;
					}
					checkerCounter++;
				}
					
				checker.add(temp.getValue());
				checkerCounter = 0;
				row ++;
			}
				
			checker.clear();
			column  ++;
		}
		
		checker.clear();
			
		//To check box 1
		startSquareX = 0;
		startSquareY = 0;
		temp = null;
		endSquareX = 3;
		endSquareY = 3;
			
		while(startSquareX != endSquareX && solved == true)
		{
			while(startSquareY != endSquareY && solved == true)
			{
		     
				while(checker.get(checkerCounter) != null)
				{
					
					temp = attempt.getPosition(startSquareX, startSquareY);
					
					if (temp.getValue() == checker.get(checkerCounter))
					{
						solved = false;
					}
					checkerCounter++;
				}
				
				checker.add(temp.getValue());
				checkerCounter = 0;
				startSquareY++;
			}
			startSquareX++;
		}
		
		checker.clear();
			
			//To check box 2 
		temp = null;
		startSquareX = 3;
		startSquareY = 0;
		endSquareX = 6;
		endSquareY = 3;
		
		while(startSquareX != endSquareX && solved == true)
		{
			while(startSquareY != endSquareY && solved == true)
			{
		     
				while(checker.get(checkerCounter) != null)
				{
					
					temp = attempt.getPosition(startSquareX, startSquareY);
					
					if (temp.getValue() == checker.get(checkerCounter))
					{
						solved = false;
					}
					checkerCounter++;
				}
				
				checker.add(temp.getValue());
				checkerCounter = 0;
				startSquareY++;
			}
			startSquareX++;
		}
		
		checker.clear();
		temp = null;
			//To check box 3
		startSquareX = 6;
		startSquareY = 0;
		endSquareX = 9;
		endSquareY = 3;
	  
	   while(startSquareX != endSquareX && solved == true)
	   {
		   while(startSquareY != endSquareY && solved == true)
		   {
		    
			   while(checker.get(checkerCounter) != null)
			   {
				   
				   temp = attempt.getPosition(startSquareX, startSquareY);
				   
				   if (temp.getValue() == checker.get(checkerCounter))
				   {
					   solved = false;
				   }
				   
				   checkerCounter++;
			   }
			   
			   checker.add(temp.getValue());
			   checkerCounter = 0;
			   startSquareY++;
		   }
		   startSquareX++;
		}
			
	   	checker.clear();
	   	temp = null;
			//To check box 4
		startSquareX = 0;
		startSquareY = 3;
		endSquareX = 3;
		endSquareY = 6;
		 
		while(startSquareX != endSquareX && solved == true)
		{
			while(startSquareY != endSquareY && solved == true)
			{
		     
				while(checker.get(checkerCounter) != null)
				{
					
					temp = attempt.getPosition(startSquareX, startSquareY);
					
					if (temp.getValue() == checker.get(checkerCounter))
					{
						solved = false;
					}
					checkerCounter++;
				}
				
				checker.add(temp.getValue());
				checkerCounter = 0;
				startSquareY++;
			}
			startSquareX++;
		}
			
		checker.clear();
		temp = null;	
			
			//To check box 5
		startSquareX = 3;
		startSquareY = 3;
		endSquareX = 6;
		endSquareY = 6;
		 
		while(startSquareX != endSquareX && solved == true)
		{
			while(startSquareY != endSquareY && solved == true)
			{
				while(checker.get(checkerCounter) != null)
				{
					
					temp = attempt.getPosition(startSquareX, startSquareY);
					
					if (temp.getValue() == checker.get(checkerCounter))
					{
						solved = false;
					}
					checkerCounter++;
				}
				
				checker.add(temp.getValue());
				checkerCounter = 0;
				startSquareY++;
			}
			startSquareX++;
		}
			
		checker.clear();
		temp = null;
			//To check box 6
		startSquareX = 6;
		startSquareY = 3;
		endSquareX = 9;
		endSquareY = 6;

		while(startSquareX != endSquareX && solved == true)
		{
			while(startSquareY != endSquareY && solved == true)
			{
				while(checker.get(checkerCounter) != null)
				{
					temp = attempt.getPosition(startSquareX, startSquareY);
					
					if (temp.getValue() == checker.get(checkerCounter))
					{
						solved = false;
					}
					checkerCounter++;
				}
				
				checker.add(temp.getValue());
				checkerCounter = 0;
				startSquareY ++;
			}
			startSquareX  ++;
		}
			
		checker.clear();
		temp = null;	
			//To check box 7
		startSquareX = 0;
		startSquareY = 6;
		endSquareX = 3;
		endSquareY = 9;
		 
		while(startSquareX != endSquareX && solved == true)
		{
			while(startSquareY != endSquareY && solved == true)
			{
		     
				while(checker.get(checkerCounter) != null)
				{
					
					temp = attempt.getPosition(startSquareX, startSquareY);
					
					if (temp.getValue() == checker.get(checkerCounter))
					{
						solved = false;
					}
					checkerCounter++;
				}
				
				checker.add(temp.getValue());
				checkerCounter = 0;
				startSquareY ++;
			}
			startSquareX  ++;
		}
			
		checker.clear();
		temp = null;
		//To check box 8
		startSquareX = 3;
		startSquareY = 6;
		endSquareX = 6;
		endSquareY = 9;
		  
		while(startSquareX != endSquareX && solved == true)
		{
			while(startSquareY != endSquareY && solved == true)
			{
		     
				while(checker.get(checkerCounter) != null){
					
					temp = attempt.getPosition(startSquareX, startSquareY);
					
					if (temp.getValue() == checker.get(checkerCounter))
					{
						solved = false;
					}
					checkerCounter++;
				}
				
				checker.add(temp.getValue());
				checkerCounter = 0;
				startSquareY ++;
			}
			startSquareX  ++;
		}
			
		checker.clear();
		temp = null;	
			//To check box 9
		startSquareX = 6;
		startSquareY = 6;
		endSquareX = 9;
		endSquareY = 9;
		  
		while(startSquareX != endSquareX && solved == true)
		{
			while(startSquareY != endSquareY && solved == true)
			{
		     
				while(checker.get(checkerCounter) != null)
				{
					temp = attempt.getPosition(startSquareX, startSquareY);
					
					if (temp.getValue() == checker.get(checkerCounter))
					{
						solved = false;
					}
					checkerCounter++;
				}
				
				checker.add(temp.getValue());
				checkerCounter = 0;
				startSquareY ++;
			}
			startSquareX  ++;
		}
		
		checker.clear();
			
		return solved;
	}
}
