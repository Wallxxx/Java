package com.task.memory;

import com.task.employee.Employee;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocumentData {
    private static final List<Employee> data = new ArrayList<>();

    public static List<Employee> getData() {
        return data;
    }

    public static void load() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("src/main/resources/data.xml"));
            document.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList employees = (NodeList) xPath.compile("/office/employee")
                    .evaluate(document, XPathConstants.NODESET);

            for (int i = 0; i < employees.getLength(); ++i) {
                Node employee = employees.item(i);
                if (employee.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) employee;
                    data.add(new Employee(
                            Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()),
                            element.getElementsByTagName("name").item(0).getTextContent(),
                            element.getElementsByTagName("surname").item(0).getTextContent(),
                            element.getElementsByTagName("position").item(0).getTextContent(),
                            Integer.parseInt(element.getElementsByTagName("salary").item(0).getTextContent())
                    ));
                }
            }
        } catch (ParserConfigurationException | XPathExpressionException | IOException | SAXException e) {
            e.printStackTrace();
        }



        /*
        NodeList employees = document.getDocumentElement().getElementsByTagName("employee");
        System.out.println("Debug: " + employees.getLength());
        for (int i = 0; i < employees.getLength(); ++i) {
            Node employee = employees.item(i);
            NamedNodeMap attributes = employee.getAttributes();
            data.add(new Employee(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()),
                    attributes.getNamedItem("name").getNodeValue(),
                    attributes.getNamedItem("surname").getNodeValue(),
                    attributes.getNamedItem("position").getNodeValue(),
                    Integer.parseInt(attributes.getNamedItem("salary").getNodeValue())));
        }
         */
    }
}
