package testing;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParserschema {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory myFactory = DocumentBuilderFactory.newInstance();
		try {
			Boolean flag = false;
			DocumentBuilder myBuilder = myFactory.newDocumentBuilder();
			SchemaFactory mySchemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			try {
				((mySchemaFactory.newSchema(new File("MyXMLSchema.xsd"))).newValidator())
						.validate(new StreamSource(new File("schema.xml")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = true;

			}
			if (flag == true) {
				System.out.println("Error occured while validating xml");
			} else {
				System.out.println("Xml Validated with XSD");
				System.out.println("=======================");
				Document doc = myBuilder.parse("schema.xml");

				NodeList myNodeList = doc.getElementsByTagName("Address");
				for (int i = 0; i < myNodeList.getLength(); i++) {
					Node rootNode = myNodeList.item(i);
					if (rootNode.getNodeType() == rootNode.ELEMENT_NODE) {
						Element rNode = (Element) rootNode;
						NodeList childList = rNode.getChildNodes();
						for (int j = 0; j < childList.getLength(); j++) {
							Node cNode = childList.item(j);
							if (cNode.getNodeType() == Node.ELEMENT_NODE) {
								Element childs = (Element) cNode;
								NodeList list = childs.getChildNodes();
								for (int k = 0; k < list.getLength(); k++) {
									Node dataNodes = list.item(k);
									if (dataNodes.getNodeType() == Node.ELEMENT_NODE) {
										Element dataElements = (Element) dataNodes;
										System.out.println(
												dataElements.getTagName() + "=" + dataElements.getTextContent());

									}
								}

							}
							System.out.println("=======================");
						}

					}
				}
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
