package cn.com.smartdevices.bracelet.upgrade;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class k {
    private DocumentBuilder a;

    private DocumentBuilder a() {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }

    public Element a(InputStream inputStream) {
        Element element = null;
        try {
            if (this.a == null) {
                this.a = a();
            }
            element = this.a.parse(new BufferedInputStream(inputStream)).getDocumentElement();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return element;
    }
}
