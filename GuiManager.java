import javax.swing.JFrame;


public class GuiManager {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//sets up GUI display
		Puzzle sudokuGrid = new Puzzle();
		Gui gui = new Gui(sudokuGrid);		
	}

}
