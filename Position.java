
public class Position {
	private int xPosition;
	private int yPosition;
	private int value;
	private boolean canBeChanged;
	
	public Position (int x, int y, int val, boolean beenSet) 
	{
		xPosition = x;
		yPosition = y;
		value = val;
		canBeChanged = beenSet;
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
}
