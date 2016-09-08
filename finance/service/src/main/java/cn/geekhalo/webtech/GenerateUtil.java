package cn.geekhalo.webtech;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 
 * @author GIM
 *
 */
public class GenerateUtil {
	public static void main(String[] args) {
		
	}
	
	public void generateCode() throws Exception{
		String workspace = System.getProperty("user.dir");
		File f = new File(workspace+"/generator/mybatis_code_autoGenerator/mygenerator_mysql.xml");
		SAXReader reader = new SAXReader();
        Document doc = reader.read(f);
        List list = doc.selectNodes("/generatorConfiguration/context");
        Iterator iter = list.iterator();
        while(iter.hasNext()){
        	 Element elem = (Element)iter.next();
             Iterator iterElem = elem.elementIterator("table");
             if(iterElem.hasNext()){
                 Element remTitle = (Element)iterElem.next();
                 System.out.println(remTitle.getText());
             }
        }
        FileWriter newFile = new FileWriter(new File(workspace+"/generator/mybatis_code_autoGenerator/mygenerator_mysql1.xml"));
        XMLWriter newWriter = new XMLWriter(newFile);
        newWriter.write(doc);
        newWriter.close();
	}
}
