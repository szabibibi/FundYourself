package functionality;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class UserInfo {
	public MoneyInfo moneyInfo = new MoneyInfo();
	public FriendsInfo friendsInfo = new FriendsInfo();
	public SuggestionInfo suggestionInfo = new SuggestionInfo();
	
	public void ReadFromFile(UserList userList) {
		File f = new File("userInfo.xml");
		if (!f.exists()) {
			return;
		}
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document = builder.build(f);
			moneyInfo.ReadFromXML(document, userList);
			friendsInfo.ReadFromXML(document, userList);
			suggestionInfo.ReadFromXML(document, userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void CreateNewUser(int userID) {
		moneyInfo.CreateNewUser(userID);
		friendsInfo.CreateNewUser(userID);
		suggestionInfo.CreateNewUser(userID);
		SerializeEverything();
	}

	private void SerializeEverything() {
		Element root = new Element("UserInfo");
		Document doc = new Document(root);
		moneyInfo.SerializeEverything(root);
		friendsInfo.SerializeEverything(root);
		suggestionInfo.SerializeEverything(root);
		
		try {
        	XMLOutputter xmlop = new XMLOutputter(Format.getPrettyFormat());
        	xmlop.output(doc, new FileOutputStream("userInfo.xml"));
        } catch (IOException e) {
        	e.printStackTrace();
        }

	}

	public void RemoveAccount(int userID, int accID) {
		moneyInfo.RemoveAccount(userID, accID);
		SerializeEverything();
	}

	public void UpdateOrCreateAccount(int userID, String accountName, double accountBalance) {
		moneyInfo.UpdateOrCreateAccount(userID, accountName, accountBalance);
		SerializeEverything();
	}

	public void CreateTransaction(int userID, Transaction retrieveTransaction) {
		moneyInfo.CreateTransaction(userID, retrieveTransaction);
		SerializeEverything();
	}

	public void AddFriend(int id, int friendID) {
		friendsInfo.AddFriend(id, friendID);
		SerializeEverything();
	}

	public void AddSuggestion(int friendID, int userID, String text) {
		suggestionInfo.AddSuggestion(friendID, userID, text);
		SerializeEverything();
	}

	public void MarkSuggestionAsRead(int id, Suggestion suggestion) {
		suggestion.seen = true;
		SerializeEverything();
	}

	public void MarkAllSuggestionsAsRead(int id) {
		suggestionInfo.MarkAllSuggestionsAsRead(id);
		SerializeEverything();
	}

}
