package GiuaKi2Java;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class Thread implements Runnable {
    List<Student> students;

    public Thread(List<Student> students) {
        this.students = students;
    }

    public void run() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element root = doc.createElement("students");
            doc.appendChild(root);

            for (Student student : students) {
                Element studentElement = doc.createElement("student");
                root.appendChild(studentElement);

                Element idElement = doc.createElement("id");
                idElement.setTextContent(Integer.toString(student.id));
                studentElement.appendChild(idElement);

                Element nameElement = doc.createElement("name");
                nameElement.setTextContent(student.name);
                studentElement.appendChild(nameElement);

                Element addressElement = doc.createElement("address");
                addressElement.setTextContent(student.address);
                studentElement.appendChild(addressElement);

                Element ageElement = doc.createElement("age");
                ageElement.setTextContent(Integer.toString(student.age));
                studentElement.appendChild(ageElement);

                Element sumElement = doc.createElement("sum");
                sumElement.setTextContent(Integer.toString(student.sum));
                studentElement.appendChild(sumElement);

                Element isDigitElement = doc.createElement("isDigit");
                isDigitElement.setTextContent(Boolean.toString(student.isDigit));
                studentElement.appendChild(isDigitElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("kq.xml"));

            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
