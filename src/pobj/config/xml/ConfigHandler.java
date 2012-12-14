package pobj.config.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import pobj.config.Configuration;

public class ConfigHandler extends DefaultHandler {
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if ("parametre".equals(qName)) {
			luParametre(attributes.getValue("name"),
					attributes.getValue("value"));
		}
	}

	private void luParametre(String name, String value) {
		Configuration.getInstance().setParameterValue(name, value);
	}
}