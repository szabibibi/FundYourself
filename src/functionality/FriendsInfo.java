package functionality;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import org.jdom2.DataConversionException;
import org.jdom2.Document;
import org.jdom2.Element;

public class FriendsInfo {
	public HashMap<Integer, ArrayList<Integer>> friendsMap = new HashMap<Integer, ArrayList<Integer>>();
	
	public void ReadFromXML(Document document, UserList userList) {
		CreateEmptyFriendsMap(userList.size());

		try {
			Element rootNode = document.getRootElement();
			ReadFromXML(rootNode.getChild("friends"));
		} catch (DataConversionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void ReadFromXML(Element rootNode) throws DataConversionException {
		if (rootNode == null) {
			return;
		}
		
		for (Element e : rootNode.getChildren("friend")) {
			int id1 = e.getAttribute("source_id").getIntValue();
			int id2 = e.getAttribute("target_id").getIntValue();
			friendsMap.get(id1).add(id2);
		}

	}
	
	public void SerializeEverything(Element root) {
		Element friendsElem = new Element("friends");
		for (Entry<Integer, ArrayList<Integer>> e : friendsMap.entrySet()) {
			for (Integer id : e.getValue()) {
				Element friendElem = new Element("friend");
				friendElem.setAttribute("source_id", "" + e.getKey()); 
				friendElem.setAttribute("target_id", "" + id);
				friendsElem.addContent(friendElem);
			}
		}
		root.addContent(friendsElem);
	}


	private void CreateEmptyFriendsMap(int size) {
		for (int i = 0; i < size; i++) {
			friendsMap.put(i, new ArrayList<Integer>());
		}
	}

	public void AddFriend(int id, int friendID) {
		friendsMap.get(id).add(friendID);
	}

	public void CreateNewUser(int userID) {
		friendsMap.put(userID, new ArrayList<Integer>());
	}

}
