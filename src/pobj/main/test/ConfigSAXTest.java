package pobj.main.test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import pobj.config.Configuration;

public class ConfigSAXTest {
	public static void main(String[] args) {
		try {
			Configuration.importConfigurationData("test.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Configuration.getInstance().toString());

		try {
			Configuration.exportConfigurationData("test_export.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
