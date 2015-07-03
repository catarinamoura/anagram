package anagram;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Demo {

	private static Game game = new Game();
	
	public static void main(String[] args) {
		generateData();
		TestRunner();

	}

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
			List<anagram.Entry> list = game.getLeaderBoard("jane");
			PrintLeaderBoard(list);
			list = game.getLeaderBoard("mary");
			PrintLeaderBoard(list);
			list = game.getLeaderBoard("sophia");
			PrintLeaderBoard(list);

		}catch(NullPointerException e1){
			e1.printStackTrace();
		}catch(Exception e2){
			e2.printStackTrace();
		}
	}

	public static void TestRunner(){
		Result result = JUnitCore.runClasses(AnagramTest.class); 
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString()); 
		}
		System.out.println(result.wasSuccessful());
	}
	
	public static void PrintLeaderBoard(List<anagram.Entry> list){
		
		System.out.println("Position\tUID\t\tScore\t");
		System.out.println("======================================");
		for(anagram.Entry entry : list){
			System.out.println(" "+ entry.getPositon() + " \t\t" +entry.getUid()  + "\t\t " + entry.getScore());
		}

	}
	
	public Game getGame(){
			return game;
	}
}
