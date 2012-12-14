package pobj.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import pobj.config.xml.ConfigHandler;

public class Configuration implements AlgoGenParameter, Serializable {

	private static final long serialVersionUID = 1L;
	private Map<String, String> params = new HashMap<String, String>();
	private transient static Configuration instance = new Configuration();

	/** Map des paramètres */

	private Configuration() {
	}

	public static Configuration getInstance() {
		return instance;
	}

	/**
	 * Renvoie la clé du paramètre
	 * 
	 * @param param
	 *            Paramètre dont la clé est à obtenir
	 * @return Clé du paramètre
	 */
	public String getParameterValue(String param) {
		return params.get(param);
	}

	/**
	 * Ajoute une entrée de paramètre
	 * 
	 * @param param
	 *            Paramètre
	 * @param value
	 *            Valeur du paramètre
	 */
	public void setParameterValue(String param, String value) {
		params.put(param, value);
	}

	/**
	 * Charge un fichier de configuration
	 * 
	 * @param fileName
	 *            Nom du fichier à charger
	 * @throws IOException
	 */
	public static void chargerConfiguration(String fileName) throws IOException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		try {
			instance = (Configuration) ois.readObject();
		} catch (ClassCastException e) {
			throw new IOException(
					"Le fichier ne contient pas une Configuration.", e);
		} catch (ClassNotFoundException e) {
			throw new IOException("JVM does not know the type Configuration.",
					e);
		} finally {
			ois.close();
		}
	}

	/**
	 * Sauvegarder un fichier de configuration
	 * 
	 * @param fileName
	 *            Nom du fichier dans lequel la configuration sera sauvegardé
	 * @param cfg
	 *            Configuration à sauvegarder
	 * @throws IOException
	 */
	public static void sauverConfiguration(String fileName, Configuration cfg)
			throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(cfg);
		fos.close();
	}

	public static void importConfigurationData(String fileName)
			throws IOException, ParserConfigurationException, SAXException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		ConfigHandler parseHandler = new ConfigHandler();
		parser.parse(fileName, parseHandler);
	}

	public static void exportConfigurationData(String fileName)
			throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		Writer out = new OutputStreamWriter(fos);
		out.append("<configuration>\n");
		// loop through each fields
		for (Map.Entry<String, String> entry : Configuration.getInstance().params
				.entrySet()) {
			out.append("\t<parametre name='" + entry.getKey() + "' value='"
					+ entry.getValue() + "'/>\n");
		}
		out.append("</configuration>\n");
		out.close();
	}

	@Override
	public String toString() {
		return params.toString();
	}

}
