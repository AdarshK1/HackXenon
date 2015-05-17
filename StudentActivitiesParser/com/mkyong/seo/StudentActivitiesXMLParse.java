package com.mkyong.seo;
 
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.*;
import java.text.*;

public class StudentActivitiesXMLParse
{
   public static void main (String ... pedophiles) throws Exception
   {
      // set up parse
      File xml = new File ( "list_blocks.xml" );
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(xml);
      doc.getDocumentElement().normalize();
      // end set up
      System.out.println("Eight Period: ");
      NodeList nList = doc.getElementsByTagName("block");
      System.out.println("-------------------");
      for (int i = 0; i < nList.getLength(); i = i + 3)
      {
         Node nNode = nList.item(i);
         Element eElement = (Element) nNode;
         System.out.println("Date: " + eElement.getElementsByTagName("disp").item(0).getTextContent().substring(0, eElement.getElementsByTagName("disp").item(0).getTextContent().indexOf(",")));
         String raw = eElement.getElementsByTagName("str").item(0).getTextContent();
         String date = raw.substring(8,10) + "/" + raw.substring(5,7) + "/" + raw.substring(0,4);
         SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
         Date dt1=format1.parse(date);
         DateFormat format2=new SimpleDateFormat("EEEE"); 
         System.out.println("Day: " + format2.format(dt1));
         System.out.println("Block: " + eElement.getElementsByTagName("type").item(0).getTextContent());
         System.out.println("Name: " + eElement.getElementsByTagName("name").item(0).getTextContent());
         System.out.println("Description: " + eElement.getElementsByTagName("description").item(0).getTextContent());
         if (eElement.getElementsByTagName("name").item(1) != null)
            System.out.println("Room: " + eElement.getElementsByTagName("name").item(1).getTextContent());
         else
            System.out.println("Room: N/A");
         System.out.println();
      }
        
   }
}