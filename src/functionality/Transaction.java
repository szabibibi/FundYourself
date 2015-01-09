package functionality;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jdom2.Element;

public class Transaction {
	public enum Type {
		Expense (0),
		Income (1),
		Transfer (2);
		
		public int type;
		Type(int i) {
			this.type = i;
		}
	}
	
	public int id;
	public int userID;
	public int srcAcc;
	public int dstAcc;
	public double amount;
	public Type type;
	public String tag;
	public Date date;
	
	public Transaction (int id, int userID, String type, int src, int dst, double amount, String tag, Date date) {
		this.id = id;
		this.userID = userID;
		this.srcAcc = src;
		this.dstAcc = dst;
		this.amount = amount;
		this.tag = tag;
		this.date = date;
		
		if (type.equals("expense")) {
			this.type = Type.Expense;
			this.dstAcc = -1;
		}
		else if (type.equals("income")) {
			this.type = Type.Income;
			this.srcAcc = -1;
		}
		else if (type.equals("transfer"))
			this.type = Type.Transfer;
	}

	public void AddToXMLTree(Element transElem) {
		Element elem = new Element("transaction");
		elem.setAttribute("id", "" + id);
		elem.setAttribute("userID", "" + userID);
		elem.setAttribute("src", "" + srcAcc);
		elem.setAttribute("dst", "" + dstAcc);
		elem.setAttribute("amount", "" + amount);
		elem.setAttribute("tag", tag);
		elem.setAttribute("type", type.toString().toLowerCase());
		elem.setAttribute("date", (new SimpleDateFormat("dd/MM/yyyy")).format(date));
		
		transElem.addContent(elem);
	}
}
