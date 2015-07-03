package anagram;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramTest {
	
	Demo demo = new Demo();
	Game game = demo.getGame();
	
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

	@Test(expected = NullPointerException.class) public void testCalculateScoreException() {
		game.calculateScore("jaja", null);
		game.calculateScore(null,"zz");
	}
	
	@Test
	public void testLeaderBoard() {
		//assertEquals(game.getLeaderBoard(""));
		
	}
	
}
