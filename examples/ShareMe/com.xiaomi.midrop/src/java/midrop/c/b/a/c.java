/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.w3c.dom.Element
 *  org.w3c.dom.Node
 *  org.w3c.dom.NodeList
 */
package midrop.c.b.a;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class c {
    public static String a(Element element, String string2) {
        Element element2;
        if (element != null && (element2 = c.b(element, string2)) != null) {
            return element2.getTextContent();
        }
        return null;
    }

    public static Element b(Element element, String string2) {
        if (element != null) {
            NodeList nodeList = element.getChildNodes();
            for (int i2 = 0; i2 < nodeList.getLength(); ++i2) {
                Node node = nodeList.item(i2);
                if (node.getNodeType() != 1 || !node.getNodeName().equals((Object)string2)) continue;
                return (Element)node;
            }
        }
        return null;
    }
}

