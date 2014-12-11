package functionality;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.jdom2.DataConversionException;
import org.jdom2.Element;

public class TransactionList {
	private int transactionsCount = 0;
	private HashMap<Integer, ArrayList<Transaction>> transactions = new HashMap<Integer, ArrayList<Transaction>>();

	public int getTransactionsCount() {
		return transactionsCount;
	}

	public void setTransactionsCount(int transactionsCount) {
		this.transactionsCount = transactionsCount;
	}

	public HashMap<Integer, ArrayList<Transaction>> getTransactions() {
		return transactions;
	}

	public void setTransactions(HashMap<Integer, ArrayList<Transaction>> transactions) {
		this.transactions = transactions;
	}

	public HashMap<Integer, ArrayList<Transaction>> getTransactionList() {
		return getTransactions();
	}

	public void setTransactionList(HashMap<Integer, ArrayList<Transaction>> transactions) {
		this.setTransactions(transactions);
	}

	public void ReadFromXML(Element node) throws DataConversionException, ParseException {
		for (Element e : node.getChildren("transaction")) {
			int id = e.getAttribute("id").getIntValue();
			int userID = e.getAttribute("userID").getIntValue();
			int src = -1, dst = -1;
			double amount;
			String type, tag;
			String dateStr = e.getAttribute("date").getValue();
			SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
			Date date = fmt.parse(dateStr);
			
			if (e.getAttribute("src") != null){
				src = e.getAttribute("src").getIntValue();
			}
			
			if (e.getAttribute("dst") != null){
				dst = e.getAttribute("dst").getIntValue();
			}
			
			amount = e.getAttribute("amount").getDoubleValue();
			type = e.getAttributeValue("type");
			tag = e.getAttributeValue("tag");
			
			if (getTransactionList().containsKey(userID)) {
				getTransactionList().get(userID).add(new Transaction(id, userID, type, src, dst, amount, tag, date));
			}
			else
			{
				ArrayList<Transaction> newList = new ArrayList<Transaction>();
				newList.add(new Transaction(id, userID, type, src, dst, amount, tag, date));
				getTransactionList().put(userID, newList);
			}
			setTransactionsCount(getTransactionsCount() + 1);
		}
	}

	public void Initialize(int size) {
		for (int i = 0; i < size; i++){
			getTransactions().put(i, new ArrayList<Transaction>());
		}
	}

	public void AddTransaction(int userID, Transaction trans) {
		// TODO Auto-generated method stub
		transactions.get(userID).add(trans);
		transactionsCount += 1;
	}

	public ArrayList<Transaction> GetTransactionsThisMonth(int userID) {
		ArrayList<Transaction> trans = new ArrayList<Transaction>();
		Date currentDate = new Date();
		for (Transaction t : transactions.get(userID)) {
			long time1 = currentDate.getTime();
			long time2 = t.date.getTime();
			String strTime = (new SimpleDateFormat("dd/MM/yyyy")).format(t.date);
			long timeDiff = time1 - time2;
			timeDiff = (int)(timeDiff/(1000*60*60*24));
			if (timeDiff <= 30) {
				trans.add(t);
			}
		}
		return trans;
	}

}
