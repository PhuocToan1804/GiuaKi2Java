package GiuaKi2Java;

import GK2.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        java.lang.Thread t1 = new java.lang.Thread(new Thread1(students));
        java.lang.Thread t2 = new java.lang.Thread(new Thread2(students));
        java.lang.Thread t3 = new java.lang.Thread(new Thread3(students));
        java.lang.Thread t4 = new java.lang.Thread(new Thread(students));

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t4.start();
        try {
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        readAndDecodeResults("kq.xml");
    }

    public static void readAndDecodeResults(String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new File(fileName));

            NodeList studentList = doc.getElementsByTagName("student");

            for (int i = 0; i < studentList.getLength(); i++) {
                Element studentElement = (Element) studentList.item(i);

                int id = Integer.parseInt(studentElement.getElementsByTagName("id").item(0).getTextContent());
                String name = studentElement.getElementsByTagName("name").item(0).getTextContent();
                String address = studentElement.getElementsByTagName("address").item(0).getTextContent();
                int age = Integer.parseInt(studentElement.getElementsByTagName("age").item(0).getTextContent());
                int sum = Integer.parseInt(studentElement.getElementsByTagName("sum").item(0).getTextContent());
                boolean isDigit = Boolean.parseBoolean(studentElement.getElementsByTagName("isDigit").item(0).getTextContent());

                // In kết quả giải mã
                System.out.println("ID: " + id + ", Name: " + name + ", Address: " + address + ", Age: " + age + ", Sum: " + sum + ", Is Digit: " + isDigit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


