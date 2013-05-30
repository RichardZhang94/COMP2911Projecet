import javax.swing.JFrame;


public class GuiManager {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//sets up GUI display
		Test t = new Test();
		t.runTests();
		
		Gui gui = new Gui();
		gui.createStartScreen();
		gui.showStartScreen();
	}

}
