import java.util.Scanner;				// Scanner required for player input

/**
 * The main class for the game Tic-Tac-Toe.
 * Controls the flow of the game, allowing each player to enter an option until the game ends.
 */

public class GameMain {
	private static Scanner scanner = new Scanner(System.in);  // Scanner for input
	
	private static Grid grid;					// The game board
	private boolean gameOver;			// Whether game is playing or over
	private Player winner;				// Winner of the game
	private Player currentPlayer;		// Current player (enum)
	private static String[] yesAnswerPool = new String[] {"Yes", "yes", "YES", "Y", "y"};
	private static String[] noAnswerPool = new String[] {"No", "no", "NO", "N", "n"};
 
   /**
    * Constructor
    * Sets up the game. Creates the grid and sets the values of the variables before calling the play method.
    */
   public GameMain() {
	   // Create the grid
	   grid = new Grid();
	   
	   // Reset the game variables to their defaults
	   gameOver = false;
	   winner = null;
	   
	   // Begin playing the game
	   currentPlayer = Player.X;
	   play();

   }
   
   /**
    * Controls the game play, rotates between player turns until a winner is decided.
    */
   public void play() {
	   do {
	         playerMove(currentPlayer);			// Have the player perform their move
	         grid.display();					// Display the current game board
	         checkForWinner(currentPlayer);		// Checks if the game has been won
	         
	         // Display results if game is over
	         if(gameOver) {
	        	 if(winner == Player.X) {
		        	 System.out.println("Player X wins!");
		         }else if(winner == Player.O) {
		        	 System.out.println("Player O wins!");
		         }else {
		        	 System.out.println("It was a draw!");
		         }
	        	 
	         }
	         
	         // Switch turn to the next player
	         if(currentPlayer == Player.X) {
	        	 currentPlayer = Player.O;
	         } else {
	        	 currentPlayer = Player.X;
	         }
	         
	      } while (!gameOver);  // repeat until game-over
   }
 
   /** 
    * Handles the player making their move, checks if the move is valid before making it.
    */
   public void playerMove(Player turnPlayer) {
	   
      boolean validInput = false;
      
      do {
    	  
    	  // Display instructions to the player
         if (turnPlayer == Player.X) {
            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
         } else {
            System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
        	 
         }
         
         // Obtains input from the player for both row and column
         int row = scanner.nextInt();
         int col = scanner.nextInt();
         
         // Decrease the value entered by 1 to compensate for the array index starting at 0
         row--;
         col--;
         
         // Verify the values the player entered are valid (position is valid and empty)
         if (row >= 0 && row < grid.ROWS && col >= 0 && col < grid.COLUMNS && grid.board[row][col].content == Player.EMPTY) {
        	 grid.board[row][col].content = turnPlayer;
        	 grid.currentRow = row;
        	 grid.currentCol = col;
        	 validInput = true;
         } else {
        	 System.out.println("Sorry the input that was entered was either incorrect"
        	 		+ " or the space is already taken. Please try again");
        	 // TODO: Display an error message that the move was not valid.
         }
         
      } while (!validInput);   // Repeat until input is valid
   }
 
   /**
    * Checks if the game has ended
    */
   public void checkForWinner(Player turnPlayer) {
      if (grid.hasWon(turnPlayer)) {
    	  gameOver = true;
    	  winner = turnPlayer;

      } else if (grid.isDraw()) {
    	  gameOver = true;
      }
   }
 
   /**
    * The main() method
    */
   public static void main(String[] args) {
	   boolean playAgain = true;
	   
	   do {
		   new GameMain();
		   System.out.println("Would you like to play again? (Y/N) ");
		   String userInput = scanner.next();
		   boolean validInput = checkValidInput(userInput, yesAnswerPool, noAnswerPool);
		   if (validInput == true) {
			   playAgain = checkPlayAgain(userInput, yesAnswerPool);
		   }
		   
	   }while(playAgain);
	}
   
   private static boolean checkPlayAgain(String userInput, String[] yesPool) {
	   boolean result = false; 
	   for(String answer : yesPool) {
		   if(userInput.matches(answer)) {
			   result = true;
			   break;
		   }
	   }
	   
	   if(result == false) {
		   System.out.println("Thanks for playing. See you next time!");
	   }
	   
	   return(result);
   }
   
   private static boolean checkValidInput(String userInput, String[] yesPool, String[] noPool) {
	   boolean result = false;
	   for (int i = 0; i < yesPool.length; i++) {
		   if((userInput.matches(yesPool[i])) || (userInput.matches(noPool[i]))) {
			   result = true;
			   break;
		   }
	   }
	   
	   if(result == false) {
		   System.out.println("Sorry what was entered wasn't within the parameters. Please try again");
	   }
	   return(result);
   }
}