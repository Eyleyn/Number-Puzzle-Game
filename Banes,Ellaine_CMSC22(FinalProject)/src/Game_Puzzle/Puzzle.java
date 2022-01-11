package Game_Puzzle;

/**Submitted By: ELLAINE B. BAÑES
*  CMSC 22 - Section 1 
*  Final Project - Number Puzzle
*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
/**Main program to complete the puzzle game.
 * This creates the main screen where it displays the number tiles
 * and move when the player click the tiles.
 */
@SuppressWarnings("serial")
/**
 * Main class
 */
public class Puzzle extends JPanel 
{ 
  public int Size;														//size to used in the entire program
  public int NumberTiles;												//use display number (buttons)
  public int Dimension;													//dimension of the grid and frame
  public static final Color FOREGROUND_COLOR = new Color(219,112,147);	//font color to used in the entire program
  public static final Random RANDOM = new Random();						//random method to display number
  public int[] ButtonTiles;												//list to hold the numbers
  public int TileSize;													//size of the tiles of the number
  public int BlankTile;													//blank space moves when the player clicks the number
  public int MarginGrid;												//margin of the grid
  public int GridSize;													//size of the Grid
  public boolean GameOver;												//holds True/False when the programs was solved or not
  
  /**
   * Creating the components for the frame 
   */
  public Puzzle(int size, int dimension, int margin) 
  {
    this.Size = size;													//refers to the object size	
    this.Dimension = dimension;											//refers to the object dimension	
    this.MarginGrid = margin;											//refers to the object margin
    
    NumberTiles = size * size - 1; 										//set the value the number tiles less the blank space
    ButtonTiles = new int[size * size];									//adds value to the array
    
    GridSize = (dimension - 2 * MarginGrid);							//size of the grid to display
    TileSize = GridSize / size;											//size of the tile that holds the number
    
    setPreferredSize(new Dimension(Dimension, Dimension + MarginGrid));	//layout the components
    setBackground(Color.WHITE);											//set the background color
    setForeground(FOREGROUND_COLOR);									//set font color from the FOREGROUND_COLOR
    setFont(new Font("SansSerif", Font.BOLD, 60));						//font and font size
    
    GameOver = true;													//GameOver set to true
    
    addMouseListener(new MouseAdapter() 
    {
    	/**
         * Event executed when button was clicked
         */
      @Override
      public void mousePressed(MouseEvent e) 
      {
        if (GameOver) 
        {
        	NewGame();													// if GameOver was true call NewGame method
        }
        else 															//if GameOver is False
        {																//it will let the user interacts the game by clicking
          int x_margin = e.getX() - MarginGrid;							//set the margin where the click happened
          int y_margin = e.getY() - MarginGrid;							//set the margin where the click happened
          
          if (x_margin < 0 || x_margin > GridSize  || y_margin < 0  || y_margin > GridSize)	//click position
            return;
          
          int column = x_margin / TileSize;								//get the column position of the number in the grid
          int row = y_margin / TileSize;								//get the row position of the number in the grid
          
          int column_blank = BlankTile % size;							//get the column positioned of the Blank tile in the grid
          int row_blank= BlankTile / size;								//get the row positioned of the Blank tile in the grid
          
          int ClickPosition = row * size + column;						//position of the click
          
          int ClickDirection = 0;										//holds the direction
          
          if (column == column_blank  &&  Math.abs(row - row_blank) > 0) //import math dictionary (Math Absolute Value)
        	  ClickDirection = (row - row_blank) > 0 ? size : -size;	//search the direction where the tile moves in column
          else if (row == row_blank && Math.abs(column - column_blank) > 0)	//import math dictionary (Math Absolute Value)
        	  ClickDirection = (column - column_blank) > 0 ? 1 : -1;	//search the direction where the tile moves in row
            
          if (ClickDirection != 0) 										//if ClickDirection is not equal to 0
          {
            do 
            {															//move the tile position
              int NewBlankPosition = BlankTile + ClickDirection;		//creates new Blank space
              ButtonTiles[BlankTile] = ButtonTiles[NewBlankPosition];	//equate the old Blank Tile to the new Blank tile position
              BlankTile = NewBlankPosition;								
            } while(BlankTile != ClickPosition);						//iterates when blank tile is not equal the clicked position
            
            ButtonTiles[BlankTile] = 0;									//set blank tile to 0
          }
          
          GameOver = isSolved();										//solved
        }
        
        repaint();														//repaint 
      }
    });
    
    NewGame();															//call NewGame method
  }
  /**
   * NewGame method will reset the game
   */
  public void NewGame() 
  {
    do 
    {
    	isReset(); 														//reset the initial state
    	ShuffleNumber(); 												//shuffle the number again
    } while(!isSolvable()); 											//iterates
    
    GameOver = false;													//GamOver set to false
  }
  /**
   * Reset the state of the game
   */
  public void isReset() 
  {
    for (int i = 0; i < ButtonTiles.length; i++) 						//Traverse the ButtonTiles
    {
    	ButtonTiles[i] = (i + 1) % ButtonTiles.length;					//set the length
    }
    
    BlankTile = ButtonTiles.length - 1;									//Blank tile was not included
  }
  
  /**
   * Shuffle the display number
   */
  public void ShuffleNumber() 
  {
    int num = NumberTiles;												//variable num will hold the value of Number tiles
    
    while (num > 1) 													//while num is greater than 1 (first number)
    {
      int random = RANDOM.nextInt(num--);								//randomize number
      int temp = ButtonTiles[random];									//set temp as the value of random in Button Tiles
      ButtonTiles[random] = ButtonTiles[num];							//equate num and random in the list
      ButtonTiles[num] = temp;											//last, set the value of num equal to the temp
    }
  }
  
  /**
   * checks if the random number in the puzzle was solvable
   */
  public boolean isSolvable() 
  {
    int count = 0;														//variable count will count the inversion
    
    for (int i = 0; i < NumberTiles; i++) 								//traverse the NumberTiles
    {
      for (int j = 0; j < i; j++) 
      {
        if (ButtonTiles[j] > ButtonTiles[i])							//check if the preceded tile has greater value
          count++;														//if true, count increment
      }
    }
    return count % 2 == 0;												//inversion must be even in order top solve the puzzle
  }
  
  /**
   * checks if puzzle was solved
   */
  public boolean isSolved() 
  {
    if (ButtonTiles[ButtonTiles.length - 1] != 0) 						//if the blank tile was not in the position
      return false;														//return isSolved = False
    
    for (int i = NumberTiles - 1; i >= 0; i--) 							//if the blank tile was in the position
    {																	//iterates in reverse order
      if (ButtonTiles[i] != i + 1)										//checks if the tile value is different from the other one
        return false;      												//return false
    }
    return true;														//Otherwise, the puzzle was solved
  }
  
  /**
   * creates grid
   */
  public void CreateGrid(Graphics2D Grid) 
  {
    for (int i = 0; i < ButtonTiles.length; i++) 						//creating the tiles given the 2D array
    {
      int row = i / Size;												//creating the row
      int column = i % Size;											//creating the column
      
      int x = MarginGrid + column * TileSize;							//x margin
      int y = MarginGrid + row * TileSize;								//y margin
      
      if(ButtonTiles[i] == 0) 											//blank tile case where the check mark printed
      {
        if (GameOver) 													//if GameOver was true (puzzle was solved)
        {
        	Grid.setColor(FOREGROUND_COLOR);							//set the color of the text
        	DrawCenteredString(Grid, "\u2713", x, y);					//display a check mark to show that the puzzle was solved
        }
        continue;
      }
      
      Grid.setColor(getForeground());									//set font color of the grid
      Grid.fillRoundRect(x, y, TileSize, TileSize, 25, 25);				//set the size of the tile 
      Grid.setColor(Color.BLACK);										//border color of the tiles
      Grid.drawRoundRect(x, y, TileSize, TileSize, 25, 25);				//creates round rectangle for the number tile
      Grid.setColor(Color.WHITE);										//font color
      
      DrawCenteredString(Grid, String.valueOf(ButtonTiles[i]), x , y);	//makes the text centered by calling the method
    }
  }
  
  /**
   * Provides the reset string and design
   */
  public void ResetString(Graphics2D Grid) 
  {
    if (GameOver) 														//if Gameover was true
    {
    	Grid.setFont(getFont().deriveFont(Font.BOLD, 18));				//set font size
    	Grid.setColor(FOREGROUND_COLOR);								//set color of the text
    	String s = "RESET";												//acts like a button
    	Grid.drawString(s, (getWidth() - Grid.getFontMetrics().stringWidth(s)) / 2, 
          getHeight() - MarginGrid);									//prints on the position
    }
  }
  
  /**
   * Centers and aligned the text 
   */
  public void DrawCenteredString(Graphics2D Grid, String s, int x, int y) 
  {
    FontMetrics fm = Grid.getFontMetrics();								//renders particular font
    int ascend = fm.getAscent();										//holds the distance of the font top of the baseline
    int descend = fm.getDescent();										//holds the distance of the font bottom of the baseline
    Grid.drawString(s,  x + (TileSize - fm.stringWidth(s)) / 2, 
        y + (ascend + (TileSize - (ascend + descend)) / 2));			//aligned 
  }
  
  /**
   * clears the graphic on the panel and repaint() will redraw all graphics
   */
  @Override
  public void paintComponent(Graphics Grid) 
  {
    super.paintComponent(Grid);
    Graphics2D g2D = (Graphics2D) Grid;
    g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    CreateGrid(g2D);
    ResetString(g2D);
  }
  
  public static void main(String[] args) 
  {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Number Puzzle Game");								//Title for the frame
      frame.setResizable(false);
      frame.add(new Puzzle(4, 550, 30), BorderLayout.CENTER);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
    });
  }
}