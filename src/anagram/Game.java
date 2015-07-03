package anagram;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;
//import java.util.concurrent.atomic;
import java.util.concurrent.atomic.AtomicLong;

public class Game {

	private Hashtable<String, Integer> leaderboardMap = new Hashtable<String, Integer>();
	// private TreeMap leaderboard = new TreeMap();

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

	public List<anagram.Entry> getLeaderBoard(String uid) {

		List<anagram.Entry> scopeList = new ArrayList(); // scope the list for 5
		// entries around
		// the given uid
		if (!leaderboardMap.containsKey(uid)) { // the uid is not in the
			// leaderboard return empty list
			return scopeList;
		}
		// create a list of map entries entry<K,V>, add all the leaderboard
		// entries and sorted by value
		List<Map.Entry<String, Integer>> leaderboardList = new ArrayList<Map.Entry<String, Integer>>(
				leaderboardMap.entrySet());

		Collections.sort(leaderboardList, new Comparator<Map.Entry<String, Integer>>() {

			public int compare(Map.Entry<String, Integer> leftEntry, Map.Entry<String, Integer> rightEntry) {

				return (rightEntry.getValue()).compareTo(leftEntry.getValue());
			}
		});
		
		for (Map.Entry<String, Integer> entry : leaderboardList) {
			if (entry.getKey().equals(uid)) {

				int index = leaderboardList.indexOf(entry);
				int size = leaderboardList.size();
				int startpos;
				int endpos;

				if (index == 0 || index == 1 || index == size - 2 || index == size - 1) {
					// exceptional cases, the uid is in the first, second,
					// second last or last position

					if (index == 0 || index == 1) { // first, second pos
						startpos = index;
						if (index + 2 <= size - 1) {// display two entries down
							endpos = index + 2;
						} else {
							if (index + 1 <= size - 1) {// display one entry down
								endpos = index + 1;
							} else { // display the entry himself
								endpos = index;
							}
						}

					} else { // second last and last position
						endpos = index;
						if (index - 2 <= size - 1) {// display two entries up
							startpos = index - 2;
						} else {
							if (index - 1 <= size - 1) {// display 1 entry up
								startpos = index - 1;
							} else {// display the entry himself
								startpos = index;
							}
						}
					}

				} else {
					// normal case -> five entries, 2 top to uid + uid + 2
					// bellow to uid
					startpos = index - 2;
					endpos = index + 2;
				}

				int position = leaderboardList.indexOf(entry) - 2 + 1; // real
				//int position = 1 ; ; // smaller Boarder
				// position
				for (Map.Entry<String, Integer> ent : leaderboardList.subList(startpos, endpos+1)) {
					scopeList.add(new anagram.Entry(ent.getKey(), ent.getValue(), position));
					position++;
				}
			}
		}
		System.out.println("Leader Board:"+ leaderboardList+"\n");
		return scopeList;
	}
}
