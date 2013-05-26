import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InputHandler implements ActionListener {
	
	private Gui gui;
	public InputHandler (Gui gui)
	{
		this.gui = gui;
	}
	public void actionPerformed(ActionEvent event) {
		char[] inputAsChar = event.getActionCommand().toCharArray();
		Integer input = inputAsChar[0] - 48;
		this.gui.setInputToUse(input);
		this.gui.setInputIndicator(input.toString());
		System.out.println("Input selected is " + input);
	}

}
