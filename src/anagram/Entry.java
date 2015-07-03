package anagram;

public class Entry {
	
	private String uid;
	private int score;
	private int positon ;
	
	public Entry(String uid, int score, int position) {
		this.uid = uid ;
		this.score = score;
		this.positon = position;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getPositon() {
		return positon;
	}

	public void setPositon(int positon) {
		this.positon = positon;
	}
}
