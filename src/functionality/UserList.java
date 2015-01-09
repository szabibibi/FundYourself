package functionality;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class UserList {
	public ArrayList<User> userList = new ArrayList<User>();
	
	public void ReadFromFile(String fileName)
	{
		File f = new File(fileName);
		if (!f.exists()) {
			return;
		}
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document = builder.build(f);
			Element rootNode = document.getRootElement();
			for (Element currentElement : rootNode.getChildren()) {
				userList.add(new User(
						(int)currentElement.getAttribute("id").getLongValue(),
						currentElement.getAttribute("name").getValue(),
						currentElement.getAttribute("pass").getValue()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int GetValidUser(String userName, String password) {
		for (User u : userList) {
			if (u.name.equals(userName) && u.pass.equals(password))
				return u.id;
		}
		return -1;
	}

	public boolean hasUser(String userName) {
		for (User u : userList) {
			if (u.name.equals(userName))
				return true;
		}
		return false;
	}

	public void CreateUser(String newUsername, String newPassword) {
		userList.add(new User(userList.size(), newUsername, newPassword));
		WriteToFile();
	}

	private void WriteToFile() {
		Element root = new Element("users");
		Document doc = new Document(root);
		
		for (int i = 0; i < userList.size(); i++)
			userList.get(i).createXMLTree(root);
		
        try {
        	XMLOutputter xmlop = new XMLOutputter(Format.getPrettyFormat());
        	xmlop.output(doc, new FileOutputStream("users.xml"));
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}

	public int size() {
		return userList.size();
	}

	public String GetUserName(Integer userID) {
		return userList.get(userID).name;
	}

	public int GetUserID(String userName) {
		for (User u : userList) {
			if (u.name.equals(userName))
				return u.id;
		}
		return -1;
	}
}
