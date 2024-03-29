package anagram;


import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import core.Game;
import test.AnagramTest;

/**
 * The Class Demo.
 */
public class Demo {
	
	/** The game. */
	private static Game game = new Game();
	
	/** The data boolean. */
	private static boolean dataBoolean = false;
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		generateData();
		TestRunner();
	}

	/**
	 * Generate data.
	 */
	public static void generateData(){
		try{
			// Null Situation
			//	game.calculateScore("jaja", null);
			//	game.calculateScore(null,"zz");

			game.submitScore("catarina", game.calculateScore("catarina","anircata")); // score 8
			game.submitScore("steve", game.calculateScore("npe","pen")); //score 3
			game.submitScore("omniata", game.calculateScore("ccesine","science")); // score 7
			game.submitScore("john", game.calculateScore("mcgdgd","ggddmi")); // score 0
			game.submitScore("mary", game.calculateScore("kersspea","speakers")); // score 8
			game.submitScore("elizabeth", game.calculateScore("gprogrammin","programming")); // score 11
			game.submitScore("jane", game.calculateScore("tingmese","meetings")); // score 8
			game.submitScore("sophia", game.calculateScore("sofa","sofa")); // score 0
			game.submitScore("catarina", game.calculateScore("nitormo","monitor")); // score 8 + 7 = 15
			game.submitScore("catarina", game.calculateScore("semoo","mouse")); // score 15 + 0 = 15
			game.submitScore("omniata", game.calculateScore("atda","data")); // score 7+4 = 11
			
			List<core.Entry> list = game.getLeaderBoard("jane");
			System.out.println("jane");
			PrintLeaderBoard(list);
			list = game.getLeaderBoard("catarina");
			System.out.println("catarina");
			PrintLeaderBoard(list);
			list = game.getLeaderBoard("sophia");
			System.out.println("sophia");
			PrintLeaderBoard(list);
			list = game.getLeaderBoard("john");
			System.out.println("john");
			PrintLeaderBoard(list);
			
			dataBoolean = true;
		}catch(NullPointerException e1){
			e1.printStackTrace();
		}catch(Exception e2){
			e2.printStackTrace();
		}
	}

	/**
	 * Test runner.
	 */
	public static void TestRunner(){
		Result result = JUnitCore.runClasses(AnagramTest.class); 
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString()); 
		}
		System.out.println(result.wasSuccessful());
	}
	
	/**
	 * Prints the leader board.
	 *
	 * @param list the list
	 */
	public static void PrintLeaderBoard(List<core.Entry> list){
		
		System.out.println("Position\tUID\t\tScore\t");
		System.out.println("======================================");
		for(core.Entry entry : list){
			System.out.println(" "+ entry.getPosition() + " \t\t" +entry.getUid()  + "\t\t " + entry.getScore());
		}

	}
	
	/**
	 * Gets the game.
	 *
	 * @return the game
	 */
	public Game getGame(){
			return game;
	}
	
	/**
	 * Gets the data boolean.
	 *
	 * @return the data boolean
	 */
	public boolean getDataBoolean(){
		return dataBoolean;
	}
	
}
