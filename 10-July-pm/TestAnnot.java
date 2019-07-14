package com.accolite.au;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TestAnnot {
	public static void main(String[] args) {
		UseAnnot test = new UseAnnot();
		Servlet s = test.getClass().getAnnotation(Servlet.class);
		test.print();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			Element root = doc.createElement("web-app");// ROOT
			doc.appendChild(root);
			Element subroot = doc.createElement("servlet");
			root.appendChild(subroot);
			Element servletName = doc.createElement("servlet-name");
			servletName.appendChild(doc.createTextNode(s.servletName().toString()));
			subroot.appendChild(servletName);
			Element cls = doc.createElement("servlet-class");
			cls.appendChild(doc.createTextNode(UseAnnot.class.getName()));
			subroot.appendChild(cls);
			Element subroot2 = doc.createElement("servlet-mapping");
			root.appendChild(subroot2);
			Element servletName2 = doc.createElement("servlet-name");
			servletName2.appendChild(doc.createTextNode(s.servletName().toString()));
			subroot2.appendChild(servletName2);
			Element url = doc.createElement("url-pattern");
			url.appendChild(doc.createTextNode(s.urlPattern().toString()));
			subroot2.appendChild(url);
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			Source sou = new DOMSource(doc);
			Result res = new StreamResult(new FileOutputStream("XmlOutput.xml"));
			transformer.transform(sou, res);
			System.out.println("Corresponding Xml for the custom Servlet Annotation is created successfully!");
		} catch (ParserConfigurationException pe) {
			pe.printStackTrace();
		} catch (TransformerConfigurationException e){
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
