package functionality;

import java.util.ArrayList;
import java.util.HashMap;

import org.jdom2.DataConversionException;
import org.jdom2.Element;


public class AccountList {
	private int accountsCount = 0;
	private HashMap<Integer, ArrayList<Account>> accountList = new HashMap<Integer, ArrayList<Account>>();

	public HashMap<Integer, ArrayList<Account>> getAccountList() {
		return accountList;
	}

	public void setAccountList(HashMap<Integer, ArrayList<Account>> accountList) {
		this.accountList = accountList;
	}

	public void ReadFromXML(Element node) throws DataConversionException {
		for (Element e : node.getChildren("account")) {
			int userID = e.getAttribute("userID").getIntValue();
			int id = e.getAttribute("id").getIntValue();
			String name = e.getAttributeValue("name");
			double balance = e.getAttribute("balance").getDoubleValue();
			if (getAccountList().containsKey(userID)) {
				getAccountList().get(userID).add(new Account(id, name, balance, userID));
			}
			else
			{
				ArrayList<Account> newList = new ArrayList<Account>();
				newList.add(new Account(id, name, balance, userID));
				getAccountList().put(userID, newList);
			}
			accountsCount += 1;
		}
	}

	public void Initialize(int size) {
		for (int i = 0; i < size; i++){
			accountList.put(i, new ArrayList<Account>());
		}
	}

	public void AddAccount(int userID, String accountName, double accountBalance) {
		accountList.get(userID).add(new Account(accountsCount, accountName, accountBalance, userID));
		accountsCount++;
	}

	public void CreateNewUser(int userID) {
		accountList.put(userID, new ArrayList<Account>());
	}
	
}
