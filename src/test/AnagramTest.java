package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import anagram.Demo;
import core.Game;

/**
 * The Class AnagramTest.
 * JUnit test class, test the methods presented in the Game class 
 */
public class AnagramTest {
	
	/** The demo. */
	Demo demo = new Demo();
	
	/** The game. */
	Game game = demo.getGame();
	
	/**
	 * Test calculate score.
	 */
	@Test
	public void testCalculateScore() {
		assertEquals(game.calculateScore("catarina","anircata"),8);
		assertEquals(game.calculateScore("npe","pen"),3);
		assertEquals(game.calculateScore("ccesine","science"),7);
		assertEquals(game.calculateScore("mcgdgd","ggddmi"),0);
		assertEquals(game.calculateScore("kersspea","speakers"),8);
		assertEquals(game.calculateScore("gprogrammin","programming"),11);
		assertEquals(game.calculateScore("tingmese","meetings"),8);
		assertEquals( game.calculateScore("sofa","sofa"),0);
	}

	/**
	 * Test calculate score exception1.
	 */
	@Test(expected = NullPointerException.class) 
	public void testCalculateScoreException1() {
		game.calculateScore("axd", null);
	}
	
	/**
	 * Test calculate score exception2.
	 */
	@Test(expected = NullPointerException.class) 
	public void testCalculateScoreException2() {
		game.calculateScore(null,"zz");
	}
	
	/**
	 * Test calculate score exception3.
	 */
	@Test(expected = NullPointerException.class) 
	public void testCalculateScoreException3() {
		game.calculateScore(null,null);
	}
	
	
	/**
	 * Test leader board.
	 */
	@Test
	public void testLeaderBoard() {
		if(!demo.getDataBoolean()){
			demo.generateData();
		}
		List<core.Entry> list = game.getLeaderBoard("omniata");
		assertFalse(list.isEmpty());
		assertEquals(list.size(),5);
		assertEquals(list.get(2).getUid(),"omniata");
	}
	
	/**
	 * Test leader board top.
	 */
	@Test
	public void testLeaderBoardTop() {
		if(!demo.getDataBoolean()){
			demo.generateData();
		}
		List<core.Entry> list = game.getLeaderBoard("catarina");
		//anagram.Entry entry = new anagram.Entry("catarina",15,1);
		//assertTrue(list.contains(entry));
		assertFalse(list.isEmpty());
		assertEquals(list.size(),3);
		assertEquals(list.get(0).getUid(),"catarina");
	}
	
	/**
	 * Test leader board bottom.
	 */
	@Test
	public void testLeaderBoardBottom() {
		if(!demo.getDataBoolean()){
			demo.generateData();
		}
		List<core.Entry> list = game.getLeaderBoard("john");
		assertFalse(list.isEmpty());
		assertEquals(list.size(),3);
		assertEquals(list.get(2).getUid(),"john");
	}
}
