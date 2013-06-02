import javax.swing.JFrame;


public class GuiManager {

	public static void main(String[] args) {
		//set up GUI display and show the start screen
		Gui gui = new Gui();
		gui.createStartScreen();
		gui.showStartScreen();
	}

}
