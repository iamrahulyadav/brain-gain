package com.opendevsolutions.quiz.lib;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

public class XmlParser extends Activity {
	static String title = "MyXmlParser";

	public XmlParser() {
	}

	private static String getXml(InputStream is) throws IOException {

		BufferedInputStream bis = new BufferedInputStream(is);
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		int result = bis.read();
		while (result != -1) {
			byte b = (byte) result;
			buf.write(b);
			result = bis.read();
		}
		return buf.toString();
	}

	public String getXmlFromAssets(String filename, Context c) {

		String xml = null;
		try {
			InputStream ins = c.getAssets().open(filename);
			Log.d(title + ": ", "success ins");
			xml = getXml(ins);
			Log.d(title + ": ", "success getXml");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			Log.e(title + ": ", e.getMessage());
		}
		return xml;
	}

	public Document getDomElement(String xml) {

		Document doc = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xml));
			doc = db.parse(is);

		} catch (ParserConfigurationException e) {
			Log.e(title + ": ", e.getMessage());
			return null;
		} catch (SAXException e) {
			Log.e(title + ": ", e.getMessage());
			return null;
		} catch (IOException e) {
			Log.e(title + ": ", e.getMessage());
			return null;
		}
		return doc;
	}

	/**
	 * Getting node value
	 * 
	 * @param elem
	 *            element
	 **/
	private final String getElementValue(Node elem) {
		Node child;
		if (elem != null) {
			if (elem.hasChildNodes()) {
				for (child = elem.getFirstChild(); child != null; child = child.getNextSibling()) {
					if (child.getNodeType() == Node.TEXT_NODE || child.getNodeType() == Node.CDATA_SECTION_NODE) {
						//Log.i("TYPE", "" + child.getNodeType());
						//return child.getTextContent();
						return child.getNodeValue();
					}
				}
			}
		}
		return "";
	}

	/**
	 * Getting node value
	 * 
	 * @param Element
	 *            node
	 * @param key
	 *            string
	 **/
	public String getValue(Element item, String str) {
		NodeList n = item.getElementsByTagName(str);
		return this.getElementValue(n.item(0));
	}
	
	public ArrayList<String> getAllValues(Element item, String str) {
		NodeList n = item.getElementsByTagName(str);

		ArrayList<String> chs = new ArrayList<String>();
		for (int i = 0; i < n.getLength(); i++) {
			chs.add(this.getElementValue(n.item(i)));
		}

		return chs;
	}
}
