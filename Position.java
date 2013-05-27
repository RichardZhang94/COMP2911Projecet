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
		
		while (count != 10) {
			listOfPossibleVal.add(count);
			count++;
		}
	}
	
	//Changes so this position can or can't be set
	public void changeSet(boolean canSet)
	{
		canBeChanged = canSet;
	}
	
	//Returns the x coordinate of position
	public int getXPosition() 
	{
		return xPosition;
	}
	
	//Returns y coordinate of position
	public int getYPosition() 
	{
		return yPosition;
	}
	
	//Returns value
	public int getValue() 
	{
		return value;
	}
	
	//Returns whether this value can be changed
	public boolean canChange() 
	{
		return canBeChanged;
	}
	
	//Removes a value this position can take
	public void removeVal (int valToRemove) 
	{
		listOfPossibleVal.removeFirstOccurrence(valToRemove);
	}
	
	//Checks if a value is possible
	public boolean checkContains (int checkVal) 
	{
		boolean answer = true;
		
		answer = listOfPossibleVal.contains(checkVal);
		
		return answer;
	}
	
	//Changes the value of position
	public void changeVal(int valToChangeTo) 
	{
		value = valToChangeTo;
	}
}
