package testing;

import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DomParserDTD {

	public static void main(String[] args) throws ParserConfigurationException,
	SAXException, IOException  {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		 
		
		Document document = builder.parse("add.xml");
		 
		document.getDocumentElement().normalize();
		 
		Element root = document.getDocumentElement();
		//System.out.println(root.getNodeName());
		 
		NodeList nList = document.getElementsByTagName("Address");
		System.out.println("============================");
		 
		for (int temp = 0; temp < nList.getLength(); temp++)
		{
		 Node node = nList.item(temp);
		 System.out.println("");    
		 if (node.getNodeType() == Node.ELEMENT_NODE)
		 {
			Element ele = (Element) node;
			System.out.println("Name: "    + ele.getElementsByTagName("Name").item(0).getTextContent());
			System.out.println("Univ : "  + ele.getElementsByTagName("University").item(0).getTextContent());
			System.out.println("Phone : "   + ele.getElementsByTagName("Phone").item(0).getTextContent());
		 }
		}
	}

}
