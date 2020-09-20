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
	   
		
		Box.row = row;
		Box.col = col;
		content = Player.EMPTY;
		clear();
		
	}
 
   /**
    * Clear the box content to EMPTY
    */
   public void clear() {
	   content = Player.EMPTY;
      
	   
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