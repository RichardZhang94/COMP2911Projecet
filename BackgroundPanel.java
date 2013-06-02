import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;


public class BackgroundPanel extends JPanel{
	/**
	 * the background image of this panel
	 */
	private Image background;
	/**
	 * @param background the image to be used as the background
	 */
	public BackgroundPanel(Image background)
	{
		this.background = background;
	}
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
    public void paintComponent(Graphics g) {
		//drawing image to the panel
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }
}
