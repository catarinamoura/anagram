package core;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;
//import java.util.concurrent.atomic;
import java.util.concurrent.atomic.AtomicLong;

/**
 * The Class Game.
 *  Class that defines the rules and process the Anagram game 
 */
public class Game {

	/** The leaderboard map. */
	private Hashtable<String, Integer> leaderboardMap = new Hashtable<String, Integer>();
	// private TreeMap leaderboard = new TreeMap();

	/**
	 * Calculate score.
	 * Check if the anagram is an anagram word and claculate the score
	 *
	 * @param word the word
	 * @param anagram the anagram
	 * @return the int
	 * @throws NullPointerException the null pointer exception
	 */
	public int calculateScore(String word, String anagram) throws NullPointerException {

		if (word.equals(null) || anagram.equals(null)) {
			System.out.println("Exception: The string word or anagram cannot be null");
			throw new NullPointerException();
		}

		if (word.equals(anagram)) {// word and anagram are the same
			return 0;
		}

		// check if the anagram has all the original letters from word
		char[] wordCharArray = word.toCharArray();
		char[] anagramCharArray = anagram.toCharArray();
		Arrays.sort(wordCharArray);
		Arrays.sort(anagramCharArray);

		if (Arrays.equals(wordCharArray, anagramCharArray)) { // is an Anagram
			return anagramCharArray.length;
		}

		return 0; // score 0, not an Anagram
	}

	/**
	 * Submit score.
	 * Associate the user id with score  and submit in a Map
	 * @param uid the uid
	 * @param score the score
	 */
	public void submitScore(String uid, int score) {

		if (leaderboardMap.containsKey(uid)) {
			// update the score
			int previousScore = ((Integer) leaderboardMap.get(uid)).intValue(); // will return a integer of type int
			leaderboardMap.put(uid, new Integer(previousScore + score));

		} else { // add the uid to the leaderboard
			leaderboardMap.put(uid, score);
		}
		// System.out.println(uid+": "+ leaderboard.get(uid));
	}

	/**
	 * Gets the leader board short version(max 5 entries).
	 *
	 * @param uid the user id 
	 * @return scopeList the leader board
	 */
	public List<core.Entry> getLeaderBoard(String uid) {

		List<core.Entry> scopeList = new ArrayList(); // entries list around the given uid
		if (!leaderboardMap.containsKey(uid)) { // the uid is not in the map
			 
			return scopeList; // return empty list
		}
		// create a list of map entries entry<K,V>, add all the leaderboard entries and sorted by value
		List<Map.Entry<String, Integer>> leaderboardList = new ArrayList<Map.Entry<String, Integer>>(
				leaderboardMap.entrySet());

		Collections.sort(leaderboardList, new Comparator<Map.Entry<String, Integer>>() {

			public int compare(Map.Entry<String, Integer> leftEntry, Map.Entry<String, Integer> rightEntry) {

				return (rightEntry.getValue()).compareTo(leftEntry.getValue());
			}
		});
		// after sort the values, select the entries for the new leadBoard 
		for (Map.Entry<String, Integer> entry : leaderboardList) {
			if (entry.getKey().equals(uid)) {//uid is in the map

				int index = leaderboardList.indexOf(entry);
				int size = leaderboardList.size();
				int startpos = 0; 
				int endpos = 0;
				int position = 1;  // position of uid in the full leader board 

				// present max 5 entries 2 top to uid + uid + 2 bellow to uid
				for(int i=2; i>=0; i--){
					if(index-i >= 0 && index+i < size){
						startpos = index - i;
						endpos = index + i;
						position =index - i + 1;
						break;
					}
					
					if(index+i < size){ //  shows i entries down 
						startpos = index;
						endpos = index+i;
						position = index + 1 ;
						break;
					}
					
					if(index-i >= 0){ // shows i entries up 
						startpos = index-i;
						endpos = index;
						position = index -i + 1 ;
						break;
					}
				}
				// position = 1 ;  // smaller LeaderBoard
					// setting the final leaderBoard
				for (Map.Entry<String, Integer> ent : leaderboardList.subList(startpos, endpos+1)) {
					scopeList.add(new core.Entry(ent.getKey(), ent.getValue(), position));
					position++;
				}
			}
		}
		System.out.println("\nLeader Board:"+ leaderboardList);
		return scopeList;
	}
}
