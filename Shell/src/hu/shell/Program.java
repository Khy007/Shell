package hu.shell;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Program {
	public static void main(String[] args) throws InterruptedException {
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
	
		Feltolt feltolt=(Feltolt)factory.getBean("feltolt");
		feltolt.proc();
		
		Rendez rendez=(Rendez)factory.getBean("rendez");
		rendez.proc();
		
		Kiir kiir=(Kiir)factory.getBean("kiir");
		kiir.proc();
	
	}

}
