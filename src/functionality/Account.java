package functionality;

import org.jdom2.Element;

public class Account {
	public int id;
	public String name;
	public double balance;
	public int userID;
	
	public Account(int id, String name, double balance, int userID) {
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.userID = userID;
	}

	public void AddToXMLTree(Element accElem) {
		Element elem = new Element("account");
		elem.setAttribute("id", "" + id);
		elem.setAttribute("name", name);
		elem.setAttribute("balance", "" + balance);
		elem.setAttribute("userID", "" + userID);
		accElem.addContent(elem);
	}
}
