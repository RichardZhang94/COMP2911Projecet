
public class DSolve {
  
	public void dSolve(Puzzle a){
		int x = 0;
		int y = 0;
	    int row = 0;
	    int column = 0;
	    int value =0;
	    boolean filled = false;
	    boolean checker = true;
	    
	    while(filled == false){
	    	
	    	
	    	while(column!=9 && checker == true){  //Checks if we have put something in everysquare
	    	  while(row!=9){
	    		if(a.getValueAtPosition(row,column) == 0){
	    			checker = false;
	    		}
	    		row++;
	    	  }
	    	row = 0;
	    	column++;
	    }
	   if(checker == true){
		   a.checkSolved();				//Checks if we have correctly done the puzzle
		   filled = true;
	   }
	     checker = true; //reset variable for the previous while loop
		   
	     
	     
	     while(column!=9){  
	    	  while(row!=9){
	    		if(a.getValueAtPosition(row,column) != 0){
	    			value = a.getValueAtPosition(row,column);
	    			setImpossible(a,row,column,value);
	    		}
	    		row++;
	    	  }  
	    	row = 0;
	    	column++;
	    }
	     
	   }
	    
	    
	    	
	}
	
	public void setImpossible(Puzzle a,int row, int column, int value){
		int rowTmp = 0;
	    int colTmp = 0;
	    
	    while(colTmp!=9){
	    	a.getPosition(row,colTmp).removeVal(value);
	    	colTmp++;
	    }
	    
	    while(rowTmp!=9){
	    	a.getPosition(rowTmp,column).removeVal(value);
	    	rowTmp++;
	    }
	    //Square 1
	    rowTmp = 0;
	    colTmp = 0;
	    if(row < 3 && column < 3){
	    	while(rowTmp != 3){
	    		while(colTmp!=3){
	    			a.getPosition(rowTmp,colTmp).removeVal(value);
	    			colTmp++;
	    		}
	    		   colTmp = 0;
	    		   rowTmp++;
	    	}
	    }
	    //Square 2
	    rowTmp = 0;
	    colTmp = 3;
	    if(row < 3 && column < 6 && column > 2){
	    	while(rowTmp != 3){
	    		while(colTmp!=6){
	    			a.getPosition(rowTmp,colTmp).removeVal(value);
	    			colTmp++;
	    		}
	    		   colTmp = 0;
	    		   rowTmp++;
	    	}
	    }
	    
	    rowTmp = 0;
	    colTmp = 0;
	    if(row < 3 && column < 3){
	    	while(rowTmp != 3){
	    		while(colTmp!=3){
	    			a.getPosition(rowTmp,colTmp).removeVal(value);
	    			colTmp++;
	    		}
	    		   colTmp = 0;
	    		   rowTmp++;
	    	}
	    }
	    
	    
	    rowTmp = 0;
	    colTmp = 0;
	    if(row < 3 && column < 3){
	    	while(rowTmp != 3){
	    		while(colTmp!=3){
	    			a.getPosition(rowTmp,colTmp).removeVal(value);
	    			colTmp++;
	    		}
	    		   colTmp = 0;
	    		   rowTmp++;
	    	}
	    }
	    
	    rowTmp = 0;
	    colTmp = 0;
	    if(row < 3 && column < 3){
	    	while(rowTmp != 3){
	    		while(colTmp!=3){
	    			a.getPosition(rowTmp,colTmp).removeVal(value);
	    			colTmp++;
	    		}
	    		   colTmp = 0;
	    		   rowTmp++;
	    	}
	    }
	    
	    rowTmp = 0;
	    colTmp = 0;
	    if(row < 3 && column < 3){
	    	while(rowTmp != 3){
	    		while(colTmp!=3){
	    			a.getPosition(rowTmp,colTmp).removeVal(value);
	    			colTmp++;
	    		}
	    		   colTmp = 0;
	    		   rowTmp++;
	    	}
	    }
	    
	    rowTmp = 0;
	    colTmp = 0;
	    if(row < 3 && column < 3){
	    	while(rowTmp != 3){
	    		while(colTmp!=3){
	    			a.getPosition(rowTmp,colTmp).removeVal(value);
	    			colTmp++;
	    		}
	    		   colTmp = 0;
	    		   rowTmp++;
	    	}
	    }
	    
	    rowTmp = 0;
	    colTmp = 0;
	    if(row < 3 && column < 3){
	    	while(rowTmp != 3){
	    		while(colTmp!=3){
	    			a.getPosition(rowTmp,colTmp).removeVal(value);
	    			colTmp++;
	    		}
	    		   colTmp = 0;
	    		   rowTmp++;
	    	}
	    }
	    
	    rowTmp = 0;
	    colTmp = 0;
	    if(row < 3 && column < 3){
	    	while(rowTmp != 3){
	    		while(colTmp!=3){
	    			a.getPosition(rowTmp,colTmp).removeVal(value);
	    			colTmp++;
	    		}
	    		   colTmp = 0;
	    		   rowTmp++;
	    	}
	    }
	}
}
