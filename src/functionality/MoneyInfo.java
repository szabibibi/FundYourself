package functionality;

import java.io.File;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class MoneyInfo {
	private AccountList accountList = new AccountList();

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void CreateEmptyAccountList(int size) {
		accountList.Initialize(size);
	}

	public void Clear() {
		
	}
	
}
