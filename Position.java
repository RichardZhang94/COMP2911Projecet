import java.util.LinkedList;

public class Position {
	private int xPosition;
	private int yPosition;
	private int value;
	private boolean canBeChanged;
	private LinkedList<Integer> listOfPossibleVal;
	
	
	public Position (int x, int y, int val, boolean beenSet) 
	{
		xPosition = x;
		yPosition = y;
		value = val;
		canBeChanged = beenSet;
		listOfPossibleVal = new LinkedList<Integer>();
		
		int count = 1;
		
		while (count != 10) 
		{
			listOfPossibleVal.add(count);
			count++;
		}
	}

	//Changes so this position can or can't be set
	/**
	 * @param canSet determines if this position can be changed
	 */
	public void changeSet(boolean canSet)
	{
		canBeChanged = canSet;
	}
	
	//Returns the x coordinate of position
	/**
	 * @return the x coordinate
	 */
	public int getXPosition() 
	{
		return xPosition;
	}
	
	//Returns y coordinate of position
	/**
	 * @return the y coordinate
	 */
	public int getYPosition() 
	{
		return yPosition;
	}
	
	//Returns value
	/**
	 * @return the value
	 */
	public int getValue() 
	{
		return value;
	}
	
	//Returns whether this value can be changed
	/**
	 * @return whether this value can be changed
	 */
	public boolean canChange() 
	{
		return canBeChanged;
	}
	
	//Removes a value this position can take
	/**
	 * @param valToRemove removes a value from the list of possible values
	 */
	public void removeVal (int valToRemove) 
	{
		listOfPossibleVal.removeFirstOccurrence(valToRemove);
	}
	
	//Checks if a value is possible
	/**
	 * @param checkVal is the value that is checked if contained in the list
	 * @return whether the value exists in the list
	 */
	public boolean checkContains (int checkVal) 
	{
		boolean answer = true;
		
		answer = listOfPossibleVal.contains(checkVal);
		
		return answer;
	}
	
	//Changes the value of position
	/**
	 * @param valToChangeTo is the value that this position changes to
	 */
	public void changeVal(int valToChangeTo) 
	{
		value = valToChangeTo;
	}
	
	//Gets the size of list of possible values
	/**
	 * @return the size of the list
	 */
	public int getListSize()
	{
		return listOfPossibleVal.size();
	}
	
	//Get last value of list
	/**
	 * @return returns the first value in the list as it should only be called when there is one value remaining
	 */
	public int getLastVal()
	{
		return listOfPossibleVal.getFirst();
	}

}
