package functionality;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.DataConversionException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import functionality.Transaction.Type;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class MoneyInfo {
	private AccountList accountList = new AccountList();
	private TransactionList transactions = new TransactionList();

	public TransactionList getTransactions() {
		return transactions;
	}

	public void setTransactions(TransactionList transactions) {
		this.transactions = transactions;
	}

	public AccountList getAccountList() {
		return accountList;
	}

	public void setAccountList(AccountList accountList) {
		this.accountList = accountList;
	}

	public void ReadFromXML(Document document, UserList userList) {
		CreateEmptyAccountList(userList.size());

		try {
			Element rootNode = document.getRootElement();
			getAccountList().ReadFromXML(rootNode.getChild("accounts"));
			getTransactions().ReadFromXML(rootNode.getChild("transactions"));
		} catch (DataConversionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void CreateEmptyAccountList(int size) {
		accountList.Initialize(size);
		transactions.Initialize(size);
	}

	public void Clear() {
		
	}

	public boolean HasAccount(int userID, String accName) {
		for (Account a : accountList.getAccountList().get(userID)) {
			if (a.name.equals(accName))
				return true;
		}
		return false;
	}

	public int GetAccountID(int userID, String accName) {
		for (Account a : accountList.getAccountList().get(userID)) {
			if (a.name.equals(accName))
				return a.id;
		}
		return -1;
	}

	public void CreateTransaction(int userID, Transaction trans) {
		AddToTransactionList(userID, trans);
		ModifyAccounts(userID, trans);
	}

	public void SerializeEverything(Element root) {
		Element accElem = new Element("accounts");
		for (Entry<Integer, ArrayList<Account>> e : accountList.getAccountList().entrySet()) {
			for (Account a : e.getValue()) {
				a.AddToXMLTree(accElem);
			}
		}
		root.addContent(accElem);
		
		Element transElem = new Element("transactions");
		for (Entry<Integer, ArrayList<Transaction>> e : transactions.getTransactionList().entrySet()) {
			for (Transaction t : e.getValue()) {
				t.AddToXMLTree(transElem);
			}
		}
		root.addContent(transElem);
	}

	private void ModifyAccounts(int userID, Transaction trans) {
		if (trans.type == Transaction.Type.Expense) {
			GetAccount(userID, trans.srcAcc).balance -= trans.amount;
		}

		if (trans.type == Transaction.Type.Income) {
			GetAccount(userID, trans.dstAcc).balance += trans.amount;
		}

		if (trans.type == Transaction.Type.Transfer) {
			GetAccount(userID, trans.dstAcc).balance += trans.amount;
			GetAccount(userID, trans.srcAcc).balance -= trans.amount;
		}
}

	private Account GetAccount(int userID, int accID) {
		for (Account a : accountList.getAccountList().get(userID)) {
			if (a.id == accID) {
				return a;
			}
		}
		return null;
	}

	private Account GetAccount(int userID, String accName) {
		for (Account a : accountList.getAccountList().get(userID)) {
			if (a.name.equals(accName)) {
				return a;
			}
		}
		return null;
	}

	private void AddToTransactionList(int userID, Transaction trans) {
		transactions.AddTransaction(userID, trans);
	}

	public void UpdateOrCreateAccount(int userID, String accountName,
			double accountBalance) {
		Account a = GetAccount(userID, accountName);
		if (a == null) {
			CreateNewAccount(userID, accountName, accountBalance);
		}
		else {
			UpdateAccount(a, accountBalance);
		}
	}

	private void UpdateAccount(Account a, double accountBalance) {
		a.balance = accountBalance;
	}

	private void CreateNewAccount(int userID, String accountName,
			double accountBalance) {
		accountList.AddAccount(userID, accountName, accountBalance);
	}

	public double GetTotalExpenses(int userID) {
		double total = 0;
		ArrayList<Transaction> transactions = this.getTransactions().getTransactionList().get(userID);
		
		for (Transaction t : transactions) {
			if (t.type == Type.Expense) {
				total += t.amount;
			}
		}
		return total;
	}

	public HashMap<String, Expense> GetExpenses(MoneyInfo moneyInfo,
			int userID, double total) {
		HashMap<String, Expense> expenses = new HashMap<String, Expense>();
		ArrayList<Transaction> transactions = getTransactions().getTransactionList().get(userID);
		for (Transaction t : transactions) {
			if (t.type != Type.Expense)
				continue;
			if (expenses.containsKey(t.tag)) {
				expenses.get(t.tag).amount += t.amount;
			}
			else {
				Expense e = new Expense(t.tag, t.amount, 0);
				expenses.put(t.tag, e);
			}
		}
		
		for (Entry<String, Expense> e : expenses.entrySet()) {
			e.getValue().percentage = (e.getValue().amount / total) * 100;
		}
		return expenses;
	}

	public double GetTotalExpensesThisMonth(int userID) {
		double total = 0;
		ArrayList<Transaction> transactions = this.getTransactions().GetTransactionsThisMonth(userID);
		
		for (Transaction t : transactions) {
			if (t.type == Type.Expense) {
				total += t.amount;
			}
		}
		return total;
	}

	public HashMap<String, Expense> GetExpensesThisMonth(MoneyInfo moneyInfo,
			int userID, double total) {
		HashMap<String, Expense> expenses = new HashMap<String, Expense>();
		ArrayList<Transaction> transactions = getTransactions().GetTransactionsThisMonth(userID);
		for (Transaction t : transactions) {
			if (t.type != Type.Expense)
				continue;
			if (expenses.containsKey(t.tag)) {
				expenses.get(t.tag).amount += t.amount;
			}
			else {
				Expense e = new Expense(t.tag, t.amount, 0);
				expenses.put(t.tag, e);
			}
		}
		
		for (Entry<String, Expense> e : expenses.entrySet()) {
			e.getValue().percentage = (e.getValue().amount / total) * 100;
		}
		return expenses;
	}

	public void CreateNewUser(int userID) {
		accountList.CreateNewUser(userID);
		transactions.CreateNewUser(userID);
	}

	public void RemoveAccount(int userID, int accID) {
		//TODO
		return;
	}
	
}
