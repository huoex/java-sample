package hex.com.test14.dom2;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//import org.xml.sax.InputSource;

/**
 * DOM生成和解析XML文档
 * 
 */
public class XmlReader {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		XmlReader reader = new XmlReader();
	}

	public XmlReader() {
		// （1）得到 DOM 解析器的工厂实例
		DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
		try {
			// （2）从 DOM 工厂获得 DOM 解析器
			DocumentBuilder domBuilder = domfac.newDocumentBuilder();
			// （3）把要解析的 XML 文档转化为输入流，以便 DOM 解析器解析它
			InputStream is = new FileInputStream(new File("doctest.xml"));
			// （4）解析 XML 文档的输入流，得到一个 Document
			Document doc = domBuilder.parse(is);
			// ibaits 里用到读xml的方式
//			Document doc = domBuilder.parse(new InputSource(is));
			// （5）得到 XML 文档的根节点
			Element root = doc.getDocumentElement();
			// （6）到节点的子节点
			NodeList books = root.getChildNodes();
			if (books != null) {
				for (int i = 0; i < books.getLength(); i++) {
					Node book = books.item(i);
					if (book.getNodeType() == Node.ELEMENT_NODE) {
						// （7）取得节点的属性值
						String email = book.getAttributes()
								.getNamedItem("email").getNodeValue();
						System.out.println(email);
						// 注意，节点的属性也是它的子节点。它的节点类型也是Node.ELEMENT_NODE
						// （8）轮循子节点
						for (Node node = book.getFirstChild(); node != null; node = node
								.getNextSibling()) {
							if (node.getNodeType() == Node.ELEMENT_NODE) {
								if (node.getNodeName().equals("name")) {
									String name = node.getNodeValue();
									String name1 = node.getFirstChild()
											.getNodeValue();
									System.out.println(name);
									System.out.println(name1);
								}
								if (node.getNodeName().equals("price")) {
									String price = node.getFirstChild()
											.getNodeValue();
									System.out.println(price);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}