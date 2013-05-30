import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;


public class BackgroundPanel extends JPanel{
	private Image background;
	
	public BackgroundPanel(Image background)
	{
		this.background = background;
	}
	@Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }
}
