import java.util.ArrayList;


public class Solver {
  public boolean solved(Puzzle attempt){
		  int startSquareX = 0;
		  int startSquareY = 0;
		  int endSquareX = 0;
		  int endSquareY = 0;
		  int row = 0;
		  int column = 0;
		  int checkerCounter = 0;
		  boolean solved = true;
		  ArrayList checker = new ArrayList(integer);
		  
			while(row != 9 && solved == true){
				while(column != 9 && solved == true){
		     
					while(checker.get(checkerCounter) != null){
						if (attempt(row)(column).getValue() == checker.get(checkerCounter)||(attempt(row)(column).getValue() == 0)){
							solved = false;
						}
						checkerCounter++;
					}
					checker.add(attempt(row)(column).getValue());
					checkerCounter = 0;
					column ++;
				}
				checker.clear();
				row++;
				colum = 0
			}
			row = 0;
			column = 0;
			checker.clear();
			  
			while(column != 9 && solved == true){
				while(row != 9 && solved == true){
		     
					while(checker.get(checkerCounter) != null){
						if ((attempt(row)(column).getValue() == checker.get(checkerCounter))||(attempt(row)(column).getValue() == 0)){
							solved = false;
						}
						checkerCounter++;
					}
					
					checker.add(attempt(row)(column).getValue());
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
			endSquareX = 3;
			endSquareY = 3;
			
			while(startSquareX != endSquareX && solved == true){
				while(startSquareY != endSquareY && solved == true){
		     
					while(checker.get(checkerCounter) != null){
						if (attempt(startSquareX)(startSquareY).getValue() == checker.get(checkerCounter)){
							solved = false;
						}
						checkerCounter++;
					}
					checker.add(attempt(startSquareX)(startSquareY).getValue());
					checkerCounter = 0;
					startSquareY ++;
				}
				startSquareX  ++;
			}
			checker.clear()
			
			//To check box 2 
			startSquareX = 3;
			startSquareY = 0;
			endSquareX = 6;
			endSquareY = 3;
			
			while(startSquareX != endSquareX && solved == true){
				while(startSquareY != endSquareY && solved == true){
		     
					while(checker.get(checkerCounter) != null){
						if (attempt(startSquareX)(startSquareY).getValue() == checker.get(checkerCounter)){
							solved = false;
						}
						checkerCounter++;
					}
					checker.add(attempt(startSquareX)(startSquareY).getValue());
					checkerCounter = 0;
					startSquareY ++;
				}
				startSquareX  ++;
			}
			checker.clear();
			
			//To check box 3
			startSquareX = 6;
			startSquareY = 0;
			endSquareX = 9;
			endSquareY = 3;
		  
		   while(startSquareX != endSquareX && solved == true){
		     while(startSquareY != endSquareY && solved == true){
		     
			   while(checker.get(checkerCounter) != null){
			     if (attempt(startSquareX)(startSquareY).getValue() == checker.get(checkerCounter)){
				   solved = false;
				}
				checkerCounter++;
			}
		      checker.add(attempt(startSquareX)(startSquareY).getValue());
			  checkerCounter = 0;
			  startSquareY ++;
			}
			 startSquareX  ++;
			}
			checker.clear();
			
			//To check box 4
			startSquareX = 0;
			startSquareY = 3;
			endSquareX = 3;
			endSquareY = 6;
		 
			while(startSquareX != endSquareX && solved == true){
				while(startSquareY != endSquareY && solved == true){
		     
					while(checker.get(checkerCounter) != null){
						if (attempt(startSquareX)(startSquareY).getValue() == checker.get(checkerCounter)){
							solved = false;
						}
						checkerCounter++;
					}
					checker.add(attempt(startSquareX)(startSquareY).getValue());
					checkerCounter = 0;
					startSquareY ++;
				}
				startSquareX  ++;
			}
			checker.clear();
			
			
			//To check box 5
			startSquareX = 3;
			startSquareY = 3;
			endSquareX = 6;
			endSquareY = 6;
		  
			while(startSquareX != endSquareX && solved == true){
				while(startSquareY != endSquareY && solved == true){
					while(checker.get(checkerCounter) != null){
						if (attempt(startSquareX)(startSquareY).getValue() == checker.get(checkerCounter)){
							solved = false;
						}
						checkerCounter++;
					}
					checker.add(attempt(startSquareX)(startSquareY).getValue());
					checkerCounter = 0;
					startSquareY ++;
				}
				startSquareX  ++;
			}
			checker.clear();
			
			//To check box 6
			startSquareX = 6;
			startSquareY = 3;
			endSquareX = 9;
			endSquareY = 6;

			while(startSquareX != endSquareX && solved == true){
				while(startSquareY != endSquareY && solved == true){
					while(checker.get(checkerCounter) != null){
						if (attempt(startSquareX)(startSquareY).getValue() == checker.get(checkerCounter)){
							solved = false;
						}
						checkerCounter++;
					}
					checker.add(attempt(startSquareX)(startSquareY).getValue());
					checkerCounter = 0;
					startSquareY ++;
				}
				startSquareX  ++;
			}
			checker.clear();
			
			//To check box 7
			startSquareX = 0;
			startSquareY = 6;
			endSquareX = 3;
			endSquareY = 9;
		 
			while(startSquareX != endSquareX && solved == true){
				while(startSquareY != endSquareY && solved == true){
		     
					while(checker.get(checkerCounter) != null){
						if (attempt(startSquareX)(startSquareY).getValue() == checker.get(checkerCounter)){
							solved = false;
						}
						checkerCounter++;
					}
					checker.add(attempt(startSquareX)(startSquareY).getValue());
					checkerCounter = 0;
					startSquareY ++;
				}
				startSquareX  ++;
			}
			checker.clear();
			
			//To check box 8
			startSquareX = 3;
			startSquareY = 6;
			endSquareX = 6;
			endSquareY = 9;
		  
			while(startSquareX != endSquareX && solved == true){
				while(startSquareY != endSquareY && solved == true){
		     
					while(checker.get(checkerCounter) != null){
						if (attempt(startSquareX)(startSquareY).getValue() == checker.get(checkerCounter)){
							solved = false;
						}
						checkerCounter++;
					}
					checker.add(attempt(startSquareX)(startSquareY).getValue());
					checkerCounter = 0;
					startSquareY ++;
				}
				startSquareX  ++;
			}
			checker.clear();
			
			//To check box 9
			startSquareX = 6;
			startSquareY = 6;
			endSquareX = 9;
			endSquareY = 9;
		  
			while(startSquareX != endSquareX && solved == true){
				while(startSquareY != endSquareY && solved == true){
		     
					while(checker.get(checkerCounter) != null){
						if (attempt(startSquareX)(startSquareY).getValue() == checker.get(checkerCounter)){
							solved = false;
						}
						checkerCounter++;
					}
					checker.add(attempt(startSquareX)(startSquareY).getValue());
					checkerCounter = 0;
					startSquareY ++;
				}
				startSquareX  ++;
			}
			checker.clear();
			
			return solved;
		}
}
