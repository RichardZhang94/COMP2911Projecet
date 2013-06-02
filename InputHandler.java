import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InputHandler implements ActionListener {
	
	/**
	 * the gui containing this listener
	 */
	private Gui gui;
	public InputHandler (Gui gui)
	{
		this.gui = gui;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent event) {
		//input required stored as a char
		char[] inputAsChar = event.getActionCommand().toCharArray();
		//subtract 48 to get the int value
		Integer input = inputAsChar[0] - 48;
		//update the input value and the input indicator
		this.gui.setInputToUse(input);
		this.gui.setInputIndicator(input.toString());
		System.out.println("Input selected is " + input);
	}

}
