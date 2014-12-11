package functionality;

public class Expense {
	public double amount;
	public String tag;
	public double percentage;
	
	public Expense(String tag, double amount, double percentage) {
		this.tag = tag;
		this.amount = amount;
		this.percentage = percentage;
	}
}
