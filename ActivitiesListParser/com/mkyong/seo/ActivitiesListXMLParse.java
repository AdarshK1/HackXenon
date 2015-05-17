package com.mkyong.seo;
// gets name and room changed variable
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.*;
import java.text.*;

public class ActivitiesListXMLParse
{
   public static void main (String ... pedophiles) throws Exception
   {
      // set up parse
      File xml = new File ( "2977.xml" );
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(xml);
      doc.getDocumentElement().normalize();
      // end set up
      System.out.println("Activities: ");
      NodeList nList = doc.getElementsByTagName("activity");
      System.out.println("-------------------");
      for (int i = 0; i < nList.getLength(); i++)
      {
         Node nNode = nList.item(i);
         Element eElement = (Element) nNode;
         System.out.println("Name: " + eElement.getElementsByTagName("name").item(0).getTextContent());
         boolean rc = false;
         if (eElement.getElementsByTagName("roomchanged").item(0) == null)
            rc = false;
         else
            rc = Integer.parseInt(eElement.getElementsByTagName("roomchanged").item(0).getTextContent()) == 1;
         System.out.println(rc);
         System.out.println();
      }
        
   }
}