package anagram;

/**
 * The Class Entry.
 * The object in the leaderboard
 */
public class Entry {
	
	/** The uid. */
	private String uid;
	
	/** The score. */
	private int score;
	
	/** The position. */
	private int position ;
	
	/**
	 * Instantiates a new entry.
	 *
	 * @param uid the uid
	 * @param score the score
	 * @param position the position
	 */
	public Entry(String uid, int score, int position) {
		this.uid = uid ;
		this.score = score;
		this.position = position;
	}

	/**
	 * Gets the uid.
	 *
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * Sets the uid.
	 *
	 * @param uid the new uid
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score the new score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Gets the position.
	 *
	 * @return the positon
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 *
	 * @param positon the new position
	 */
	public void setPosition(int position) {
		this.position = position;
	}
}
