package functionality;

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
	
	public Transaction (int id, int userID, String type, int src, int dst, double amount, String tag) {
		this.id = id;
		this.userID = userID;
		this.srcAcc = src;
		this.dstAcc = dst;
		this.amount = amount;
		this.tag = tag;
		
		if (type.equals("expense"))
			this.type = Type.Expense;
		else if (type.equals("income"))
			this.type = Type.Income;
		else if (type.equals("transfer"))
			this.type = Type.Transfer;
	}
}
