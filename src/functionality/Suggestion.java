package functionality;

import java.util.Date;

public class Suggestion {
	public int srcUser = -1;
	public int dstUser = -1;
	public String text = "";
	public Date date = new Date();
	public boolean seen = false;

	public Suggestion(int id1, int id2, String text, Date date, boolean seen) {
		this.srcUser = id1;
		this.dstUser = id2;
		this.text = text;
		this.date = date;
		this.seen = seen;
	}

	public Suggestion(int dstUser, int srcUser, String text) {
		this.srcUser = srcUser;
		this.dstUser = dstUser;
		this.text = text;
		this.date = new Date();
		this.seen = false;
	}

}
