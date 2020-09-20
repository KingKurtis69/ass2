/**
 * The Box class models each individual box of the Grid
 */
public class Box {
	
	static Grid grid;
	Player content;			// The move this box holds (Empty, X, or O)
	static int row; 			// Row and column of this box (Not currently used but possibly useful in future updates)
	static int col;
 
   /**
    * Constructor
    */
	public Box(int row, int col) {
	   
		// TODO: Initialise the variables row, col, and content
		Box.row = row;
		Box.col = col;
		content = Player.EMPTY;
		
	}
 
   /**
    * Clear the box content to EMPTY
    */
   public static void clear() {
	   grid.board[row][col].content = Player.EMPTY;
      // TODO: Set the value of content to EMPTY (Remember this is an enum)
	   
   }
 
   /**
    * Display the content of the box
    */
   public void display() {
	   
	   if(content == Player.EMPTY){
		   System.out.print("   ");
	   }else if(content == Player.O) {
		   System.out.print(" O ");
	   }else if (content == Player.X) {
		   System.out.print(" X ");
	   }
	   // TODO: Print the content of this box (" X " if it Player.X, " O " for Player.O and "   " for Player.Empty)
	   // Hint: Can use an if-else or switch statement
	   
   }
}