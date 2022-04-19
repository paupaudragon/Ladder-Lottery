package currentSource;

//import java.util.ArrayList;
//import java.util.List;
import java.awt.Font;
import edu.princeton.cs.algs4.StdDraw;

/**
* Keeps track of different variables as well as holds the code for the
* Introduction Screen and the End Game Screen.
* 
* @author madisonkonnick
*
*/
public class GameConfig {
	public int ActiveRound;
	public int TotalRounds;
	public boolean CoinInPlay;
	public int RoundsWon; // not sue what type this needs to be so int placeholder

	private static int Enter = 13;

	/**
	 * used for testing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// this tests how all the screens look
		// comment out when not testing
		StdDraw.setCanvasSize(1000, 800);
//		StdDraw.pause(10000);// Change later to change after a click/enter is registered
//		IntroScreen();
//		StdDraw.pause(10000);
//		StdDraw.clear();
		GameArea.main(args);
//		StdDraw.pause(3000);
//		StdDraw.clear();

//		EndGameScreen();
	}

	/**
	 * constructor
	 */
	public GameConfig() {

	}

	/**
	 * Screen shown at the beginning explaining the game, how to play, and the rules
	 * of the game. game starts when the button is clicked or enter/return is hit.
	 */
	public static void IntroScreen() {

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(50, 50, 450, 455);
		
		// Sets up the scale and the starter window area
		StdDraw.setScale(0, 100);
		StdDraw.enableDoubleBuffering();
		StdDraw.setPenColor(StdDraw.CYAN);
		StdDraw.filledRectangle(49, 63, 40, 27);
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.filledRectangle(49, 63, 39, 26);

		// Write the instructions and how to play
		Font title = new Font("Sans Serif", Font.BOLD, 50);
		Font subTitle = new Font("Sans Serif", Font.BOLD, 20);
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.setFont(title);
		StdDraw.text(49, 83, "Welcome to Ladder Lottery!");
		StdDraw.setPenColor(StdDraw.CYAN);
		StdDraw.setFont(subTitle);
		StdDraw.text(49, 79, "Game Description:");
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.setFont();
		StdDraw.text(49, 76, "This is a game of luck with a twist. Each Player is trying to reach the hidden goal");
		StdDraw.text(49, 74, " while avoiding Bombs and Coins. Each player chooses a way to traverse the graph.");
		StdDraw.setPenColor(StdDraw.CYAN);
		StdDraw.setFont(subTitle);
		StdDraw.text(49, 71, "How To Play:");
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.setFont();
		StdDraw.text(49, 68, "Each Player places where they want to start. Then each Player chooses how to traverse");
		StdDraw.text(49, 66,
				"the ladders. There are a couple ways to traverse the graph. Through BFS, DFS or DijkstraSP.");
		StdDraw.text(49, 64,
				"The Player who won the last round gets to choose first. There are coins and bombs hidden");
		StdDraw.text(49, 62,
				"along the path. When you cross a coin you gain points. When you hit a bomb you loose points.");
		StdDraw.text(49, 60, "Whoever reaches the goal in the least amount of hops gains points. The winner is ");
		StdDraw.text(49, 58, "determinded by who gains the most coins throught the rounds.");
		StdDraw.setPenColor(StdDraw.CYAN);
		StdDraw.setFont(subTitle);
		StdDraw.text(49, 55, "Rules:");
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.setFont();
		StdDraw.text(49, 52, "1. Tokens will cross any ladders that are traveling down.");
		StdDraw.text(49, 50, "2. Each Player only gets one algorithm.");
		StdDraw.text(49, 48, "3. Players cannot pick the same spot to start.");
		StdDraw.setPenColor(StdDraw.CYAN);
		StdDraw.setFont(subTitle);
		StdDraw.text(49, 45, "Press Enter to play.");
		StdDraw.text(49, 42, "Have Fun!");

		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.setFont();
		StdDraw.text(49, 39, "Authors: Samantha Tilo, Tingting Zhou, Maddie Konnick");

		StdDraw.show();
	}

	/**
	 * Asks whether or not the Player wants to use their coin
	 * 
	 * @return true if coin is used
	 */
	public boolean ChooseAlgoritm() {
		return false; // TODO
	}

	/**
	 * Keeps track of how many round each player has won
	 * 
	 * @param players
	 * @return the number of the player who won the round
	 */
	public int MatchWinner(/*Player[] players*/) {
		return 0;// TODO
	}
	
	
	/**
	 * Checking if the player has hit a coin or bomb
	 * and adding or subtracting the score.
	 * keeps track
	 * 
	 */
	public void coinsAndBombs()
	{
		
	}
	
	

	/**
	 * End of Game screen is shown after all the rounds have been played. It will
	 * display the first and second place players with the number of rounds won.
	 * 
	 * @param players
	 */
	public static void EndGameScreen(/* Player[] players */) {
		StdDraw.setScale(0, 100);
		StdDraw.enableDoubleBuffering();
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(50, 50, 450, 455);

		//sets up the base window
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledRectangle(49, 63, 29, 23);
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.filledRectangle(49, 63, 28, 22);

		//fonts
		Font title = new Font("Sans Serif", Font.BOLD, 50);
		Font subTitle = new Font("Sans Serif", Font.BOLD, 30);

		//GameOver
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setFont(title);
		StdDraw.text(49, 89, "GAME OVER");

		//First Player
		StdDraw.setPenColor(StdDraw.CYAN);
		StdDraw.setFont(title);
		StdDraw.text(49, 80, "First Place:");
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.setFont(subTitle);
		StdDraw.text(49, 74, "Player: " + "0" + " With: " + "#ofPoints");
		StdDraw.text(49, 70, "Coins Hit: " + "#ofcoins");
		StdDraw.text(49, 66, "Bombs Hit: " + "#ofcoins");

		//Second Player
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.setFont(title);
		StdDraw.text(49, 59, "Second Place:");
		StdDraw.setPenColor(StdDraw.PINK);
		StdDraw.setFont(subTitle);
		StdDraw.text(49, 53, "Player: " + "1" + " With: " + "#ofPoints");
		StdDraw.text(49, 49, "Coins Hit: " + "#ofcoins");
		StdDraw.text(49, 45, "Bombs Hit: " + "#ofcoins");

		StdDraw.show();
	}

}