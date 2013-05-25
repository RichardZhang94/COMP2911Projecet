import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Gui{

	private JLabel label;
	private JButton button;
	private Integer inputToUse = 0;
	private JFrame startScreen;
	private JFrame sudokuGrid;
	public void setPuzzle(Puzzle puzzle)
	{
		JPanel sudokuGrid = new JPanel();	//making the sudoku grid
		sudokuGrid.setLayout(new GridLayout(9,9));
		sudokuGrid.setPreferredSize(new Dimension(500,500));
		Integer i = 1;
		Integer x = 0;
		Integer y = 0;
		GridButtonHandler gridButtonHandler = new GridButtonHandler(puzzle, this);
		while (i <= 81)
		{
			Integer value = puzzle.getValueAtPosition(x, y);
			button = new JButton(value.toString());
			String label = "";
			label = label.concat(x.toString());
			label = label.concat(y.toString());
			button.setName(label);
			if (value != 0)	//unchangeable buttons will be red and cannot be clicked
			{
				button.setBackground(Color.RED);
				button.setEnabled(false);
			}
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
		
		JPanel miscButtons	= new JPanel();			//making miscellaneous buttons
		MiscButtonHandler miscButtonHandler = new MiscButtonHandler(puzzle);
		miscButtons.setLayout(new GridBagLayout());
		button = new JButton("Save");
		button.setPreferredSize(new Dimension(120, 70));
		button.addActionListener(miscButtonHandler);
		miscButtons.add(button);
		button = new JButton("Check");
		button.setPreferredSize(new Dimension(120, 70));
		button.addActionListener(miscButtonHandler);
		miscButtons.add(button);
		
		JFrame sudokuFrame = new JFrame();				//creating the sudoku window
		sudokuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//exit when the 'x' button is clicked
		sudokuFrame.add(sudokuGrid, BorderLayout.NORTH);				//adding panels to the window
		sudokuFrame.add(inputPanel, BorderLayout.EAST);
		sudokuFrame.add(miscButtons, BorderLayout.WEST);
		sudokuFrame.setSize(700,700);						
		this.sudokuGrid = sudokuFrame;
	}
	public void showPuzzle()
	{
		this.sudokuGrid.setVisible(true);
	}
	public void hidePuzzle()
	{
		this.sudokuGrid.setVisible(false);
	}
	
	public void createStartScreen()
	{
		JPanel startScreenButtons = new JPanel();	//creating the panel which contains the start screen buttons
		startScreenButtons.setPreferredSize(new Dimension(500, 100));
		button = new JButton("Load game");
		button.addActionListener(new StartScreenButtonHandler(this));
		startScreenButtons.add(button, BorderLayout.WEST);
		button = new JButton("New game");
		button.addActionListener(new StartScreenButtonHandler(this));
		startScreenButtons.add(button, BorderLayout.EAST);
		JFrame startScreen = new JFrame();
		startScreen.add(startScreenButtons);
		startScreen.pack();
		this.startScreen = startScreen;
	}
	public void showStartScreen()
	{
		this.startScreen.setVisible(true);
	}
	public void hideStartScreen()
	{
		this.startScreen.setVisible(false);
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
