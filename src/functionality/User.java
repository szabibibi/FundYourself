package functionality;

import org.jdom2.Element;

public class User {
	public int id;
	public String name;
	public String pass;
	
	public User(int id, String name, String pass) {
		this.id = id;
		this.name = name;
		this.pass = pass;
	}

	public void createXMLTree(Element root) {
		Element userElem = new Element("user");
		userElem.setAttribute("id", "" + id);
		userElem.setAttribute("name", name);
		userElem.setAttribute("pass", pass);
		root.addContent(userElem);
	}
}
