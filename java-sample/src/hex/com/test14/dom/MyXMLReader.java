package hex.com.test14.dom;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.dom4j.io.SAXReader;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * {@link}http://www.iteye.com/topic/181865
 * 
 * @author Administrator
 * 
 */
public class MyXMLReader extends DefaultHandler {

	java.util.Stack tags = new java.util.Stack();

	public MyXMLReader() {
		super();
	}

	/**
	 * DOM方式
	 * 
	 * @since V2.0
	 * @author David.Wei
	 * @date 2008-4-11
	 * @return void
	 */
	public void DOM() {
		long lasting = System.currentTimeMillis();

		try {
			File f = new File("xmltest.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			NodeList nl = doc.getElementsByTagName("node");
			for (int i = 0; i < nl.getLength(); i++) {
				System.out.println("|| Name:  |"
						+ doc.getElementsByTagName("name").item(i)
								.getFirstChild().getNodeValue());
				System.out.println("||Space:  |"
						+ doc.getElementsByTagName("space").item(i)
								.getFirstChild().getNodeValue());
//				System.out.println("-------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DOM RUNTIME："
				+ (System.currentTimeMillis() - lasting) + " MS");
	}

	/**
	 * DOM方式
	 * 
	 * @author hex
	 * @date 2014-8-17
	 * @return void
	 */
	public void DOM2() {
		long lasting = System.currentTimeMillis();
		XMLStreamReader reader = null;
		BufferedInputStream stream = null;
		File file = new File("xmltest.xml");
		XMLInputFactory factory = XMLInputFactory.newInstance();
		try {
			stream = new BufferedInputStream(new FileInputStream(file));
			reader = factory.createXMLStreamReader(stream);
			while (reader.hasNext()) {
				int eventType = reader.next();
				if (eventType == XMLStreamReader.START_ELEMENT) {
					String elementName = reader.getName().toString();

					if (elementName.equals("name")) {
						System.out.println("|| Name:  |"
								+ reader.getElementText());
					} else if (elementName.equals("space")) {
						System.out.println("||Space:  |"
								+ reader.getElementText());
					}
				}
				// System.out.println("-------------------------------------------------");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		System.out.println("DOM2 RUNTIME："
				+ (System.currentTimeMillis() - lasting) + " MS");
	}

	/**
	 * SAX方式
	 * 
	 * @since V2.0
	 * @author David.Wei
	 * @date 2008-4-11
	 * @return void
	 */
	public void SAX() {

		long lasting = System.currentTimeMillis();
		try {
			SAXParserFactory sf = SAXParserFactory.newInstance();
			SAXParser sp = sf.newSAXParser();
			MyXMLReader reader = new MyXMLReader();
			sp.parse(new InputSource("xmltest.xml"), reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("SAX RUNTIME："
				+ (System.currentTimeMillis() - lasting) + " MS");
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attrs) {
		tags.push(qName);
	}

	public void characters(char ch[], int start, int length)
			throws SAXException {
		String tag = (String) tags.peek();
		if (tag.equals("name")) {
			System.out.println("|| Name:  |" + new String(ch, start, length));
		}
		if (tag.equals("space")) {
			System.out.println("||Space:  |" + new String(ch, start, length));
		}
		// System.out.println("-------------------------------------------------");
	}

	/**
	 * JDOM方式
	 * 
	 * @since V2.0
	 * @author David.Wei
	 * @date 2008-4-11
	 * @return void
	 */
	public void JDOM() {
		long lasting = System.currentTimeMillis();
		try {
			SAXBuilder builder = new SAXBuilder();
			org.jdom.Document doc = builder.build(new File("xmltest.xml"));
			Element foo = doc.getRootElement();
			List allChildren = foo.getChildren();
			for (int i = 0; i < allChildren.size(); i++) {
				System.out.println("|| Name:  |"
						+ ((Element) allChildren.get(i)).getChild("name")
								.getText());
				System.out.println("||Space:  |"
						+ ((Element) allChildren.get(i)).getChild("space")
								.getText());
//				System.out.println("-------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("JDOM RUNTIME："
				+ (System.currentTimeMillis() - lasting) + " MS");
	}

	/**
	 * DOM4J方式
	 * 
	 * @since V2.0
	 * @author David.Wei
	 * @date 2008-4-11
	 * @return void
	 */
	public void DOM4J() {
		long lasting = System.currentTimeMillis();
		try {
			File f = new File("xmltest.xml");
			SAXReader reader = new SAXReader();
			org.dom4j.Document doc = reader.read(f);
			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (Iterator i = root.elementIterator("node"); i.hasNext();) {
				foo = (org.dom4j.Element) i.next();
				System.out.println("|| Name:  |" + foo.elementText("name"));
				System.out.println("||Space:  |" + foo.elementText("space"));
//				System.out.println("-------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DOM4J RUNTIME："
				+ (System.currentTimeMillis() - lasting) + " MS");
	}

	public static void main(String arge[]) {
		MyXMLReader myXML = new MyXMLReader();
		System.out.println("=====================DOM=========================");
		myXML.DOM();
		System.out.println("=====================DOM2========================");
		myXML.DOM2();
		System.out.println("=====================SAX=========================");
		myXML.SAX();
		System.out.println("=====================JDOM========================");
		myXML.JDOM();
		System.out.println("=====================DOM4J=======================");
		myXML.DOM4J();
		System.out.println("=================================================");
	}
}