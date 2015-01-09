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

public class SuggestionInfo {
	private HashMap<Integer, ArrayList<Suggestion>> suggestionMap = new HashMap<Integer, ArrayList<Suggestion>>();

	public void ReadFromXML(Document document, UserList userList) throws ParseException {
		CreateEmptySuggestionsMap(userList.size());

		try {
			Element rootNode = document.getRootElement();
			ReadFromXML(rootNode.getChild("suggestions"));
		} catch (DataConversionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void CreateEmptySuggestionsMap(int size) {
		for (int i = 0; i < size; i++) {
			suggestionMap.put(i, new ArrayList<Suggestion>());
		}

	}

	private void ReadFromXML(Element rootNode) throws DataConversionException, ParseException {
		if (rootNode == null) {
			return;
		}
		
		for (Element e : rootNode.getChildren("suggestion")) {
			int id1 = e.getAttribute("source_id").getIntValue();
			int id2 = e.getAttribute("target_id").getIntValue();
			String text = e.getValue();
			String dateStr = e.getAttributeValue("date");
			boolean seen = e.getAttribute("seen").getBooleanValue();
			
			SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
			Date date = fmt.parse(dateStr);
			
			suggestionMap.get(id2).add(new Suggestion(id1, id2, text, date, seen));
		}

	}

	public void CreateNewUser(int userID) {
		suggestionMap.put(userID, new ArrayList<Suggestion>());
	}

	public void SerializeEverything(Element root) {
		Element suggestionsElem = new Element("suggestions");
		for (Entry<Integer, ArrayList<Suggestion>> e : suggestionMap.entrySet()) {
			for (Suggestion s : e.getValue()) {
				Element suggestionElem = new Element("suggestion");
				suggestionElem.setAttribute("source_id", "" + s.srcUser); 
				suggestionElem.setAttribute("target_id", "" + s.dstUser);
				suggestionElem.setAttribute("seen", "" + s.seen);
				
				SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
				String dateStr = fmt.format(s.date);
				
				suggestionElem.setAttribute("date", dateStr);
				
				suggestionElem.setText(s.text);
				
				suggestionsElem.addContent(suggestionElem);
			}
		}
		root.addContent(suggestionsElem);
	}

	public void AddSuggestion(int friendID, int userID, String text) {
		suggestionMap.get(userID).add(new Suggestion(friendID, userID, text));
	}

	public ArrayList<Suggestion> GetSuggestionList(int id) {
		return suggestionMap.get(id);
	}

	public void MarkAllSuggestionsAsRead(int id) {
		for (Suggestion s : suggestionMap.get(id)) {
			s.seen = true;
		}
	}
}
