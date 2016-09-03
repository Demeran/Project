import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Parser {
	private XmlPullParser xmlParser;

	public XMLStAXParser(String fileName) {
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			xmlParser = factory.newPullParser();
			xmlParser.setInput(new FileReader(fileName));
		} catch (XmlPullParserException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public List<Operator> getTariffsFromXmlFile() {
		String tagName;
		int tagDepth;
		Operator operator = new Operator();
		Tarify tarify;
		tarif tarif1;
		Parameters parameters;
		ArrayList<String> attachments = new ArrayList<String>();
		try {
			
			while (xmlParser.getEventType() != XmlPullParser.END_DOCUMENT) {
				tagName = xmlParser.getName();
				tagDepth = xmlParser.getDepth();
				switch (xmlParser.getEventType()) {
				case XmlPullParser.START_TAG:
					if (tagName.equals("Tarify")) {
						tarify = new Tarify();
						break;
					}
					if (tagName.equals("tarif")){
						tarif1 = new tarif();
						break;
					}
					if (tagName.equals("Parameters")){
						parameters = new Parameters();
						break;
					}
					break;
				case XmlPullParser.END_TAG:
					if (tagName.equals("tarif")){
						tarify.tarif.add(tarif1);
						break;
					}
					if (tagName.equals("Parameters")){
						tarif1.parameters.add(parameters);
						break;
						
					}
				}
			}	
		}
	}
	
}
