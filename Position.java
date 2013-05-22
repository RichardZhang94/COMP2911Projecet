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
	
	public int getXPosition() 
	{
		return xPosition;
	}
	
	public int getYPosition() 
	{
		return yPosition;
	}
	
	public int getValue() 
	{
		return value;
	}
	
	public boolean canChange() 
	{
		return canBeChanged;
	}
	
	public void removeVal (int valToRemove) {
		listOfPossibleVal.removeFirstOccurrence(valToRemove);
	}
	
	public boolean checkContains (int checkVal) {
		boolean answer = true;
		
		answer = listOfPossibleVal.contains(checkVal);
		
		return answer;
	}
}
