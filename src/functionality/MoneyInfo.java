package functionality;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.util.ArrayList;
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

	public void ReadFromFile(UserList userList) {
		CreateEmptyAccountList(userList.size());
		
		File f = new File("userInfo.xml");
		if (!f.exists()) {
			return;
		}
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document = builder.build(f);
			Element rootNode = document.getRootElement();
			getAccountList().ReadFromXML(rootNode.getChild("accounts"));
			getTransactions().ReadFromXML(rootNode.getChild("transactions"));
		} catch (Exception e) {
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
		SerializeEverything();
	}

	private void SerializeEverything() {
		Element root = new Element("UserInfo");
		Document doc = new Document(root);
		
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

		try {
        	XMLOutputter xmlop = new XMLOutputter(Format.getPrettyFormat());
        	xmlop.output(doc, new FileOutputStream("userInfo.xml"));
        } catch (IOException e) {
        	e.printStackTrace();
        }

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

	private void AddToTransactionList(int userID, Transaction trans) {
		transactions.getTransactionList().get(userID).add(trans);
	}
	
}