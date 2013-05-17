import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Gui{

	private JLabel label;
	private JButton button;
	private Puzzle sudokuGrid;
	private Integer inputToUse = 0;
	public Gui (Puzzle puzzle)
	{
		sudokuGrid = puzzle;
		JPanel sudokuGrid = new JPanel();	//setting up the sudoku grid
		sudokuGrid.setLayout(new GridLayout(9,9));
		sudokuGrid.setPreferredSize(new Dimension(500,500));
		Integer i = 1;
		Integer x = 0;
		Integer y = 0;
		GridButtonHandler gridButtonHandler = new GridButtonHandler(puzzle, this);
		while (i <= 81)
		{
			button = new JButton("0");
			String label = "";
			label = label.concat(x.toString());
			label = label.concat(y.toString());
			button.setName(label);
			button.setPreferredSize(new Dimension(30, 30));
			button.addActionListener(gridButtonHandler);
			sudokuGrid.add(button);
			i++;
			if (x < 8)
			{
				x++;
			}
			else
			{
				x = 0;
				y++;
			}
		}
		JPanel inputLabel = new JPanel();
		label = new JLabel("Input");
		inputLabel.setLayout(new FlowLayout());		//making the input label
		inputLabel.add(label);
		JPanel inputGrid = new JPanel();
		inputGrid.setLayout(new GridLayout(3,3));	//making the input grid
		inputGrid.setPreferredSize(new Dimension(200,200));
		InputHandler inputHandler = new InputHandler(this);
		i = 1;
		while (i <= 9)
		{
			String s = i.toString();
			button = new JButton(s);
			button.setPreferredSize(new Dimension(40, 40));
			button.addActionListener(inputHandler);
			inputGrid.add(button);
			i++;
		}
		JPanel inputPanel = new JPanel();			//input panel consists of the input grid and the input label
		inputPanel.setLayout(new BorderLayout());
		inputPanel.add(inputLabel, BorderLayout.NORTH);
		inputPanel.add(inputGrid, BorderLayout.CENTER);
		JFrame frame = new JFrame();				//creating actual window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//exit when the 'x' button is clicked
		frame.add(sudokuGrid, BorderLayout.NORTH);				//adding panels to the window
		frame.add(inputPanel, BorderLayout.EAST);
		frame.setSize(700,700);						//packing the window to fit the frame size
		frame.setVisible(true);						//show window
	}
	public void setInputToUse (Integer input)
	{
		this.inputToUse = input;
	}
	public Integer getInputToUse()
	{
		return this.inputToUse;
	}
}