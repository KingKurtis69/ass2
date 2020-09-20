/**
 * The grid represents the game board.
 */
public class Grid {
	// Define the amount of rows and columns
	int ROWS = 3;			// Rows
	int COLUMNS = 3;		// Columns
 
	Box[][] board;								// Represents the game board as a grid
	int currentRow;								// Row that was played last
	int currentCol;								// Column that was played last
 
	/**
	 * Constructor
	 */
   public Grid() {
      
      // TODO: Initialise the board array using ROWS and COLUMNS
      
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
            board[row][col] = new Box(row, col);
         }
      }
   }
 
   /**
    * Checks if the game has ended in a draw
    * One way to do this is to check that there are no empty positions left
    */
   public boolean isDraw() {
	
	   for(int row = 0; row < ROWS; row++) {
		   for(int col = 0; col < COLUMNS; col++) {
			   if(board[row][col].content == Player.EMPTY) {
				   return false;
			   }
		   }
	   }
	   
	   return true;
	   
	   // TODO: Check whether the game has ended in a draw. 
	   // Hint: Use a nested loop (see the constructor for an example). Check whether any of the Boxes in the board grid are Player.Empty. If they are, it is not a draw.
	   // Hint: Return false if it is not a draw, return true if there are not empty positions left
	   

   }
 
   /**
    * Return true if the turn player has won after making their move at the coordinate given
    */
   public boolean hasWon(Player player) {
	   // Row check
	   if(board[currentRow][0].content == player && board[currentRow][1].content == player && board[currentRow][2].content == player) {
		   return true;
	   }
	   // Column check
	   if (board[0][currentCol].content == player && board[1][currentCol].content == player && board[2][currentCol].content == player) {
		   return true;
	   }
	   // Diagonal check (check both directions)
	   if(board[0][0].content == player && board[1][1].content == player && board[2][2].content == player) {
		   return true;
	   }else if(board[3][0].content == player && board[1][1].content == player && board[0][3].content == player) {
		   return true;
	   }	   
	   // No one has won yet
	   return false;
   }
 
   /**
    * Draws the tic-tac-toe board to the screen
    */
   public void display() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
        	 
        	 // Draw the contents of the box
        	 board[row][col].display();
        	 
        	 // Draw the vertical line
        	 if (col < COLUMNS - 1) System.out.print("|");
        	 
    	 }
         System.out.println();
         
         // Draw the horizontal line
         if (row < ROWS - 1) {
        	 System.out.println("-----------");
         }
      }
   }
}