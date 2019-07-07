package com.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.Timestamp;
import java.sql.Date;
import java.util.Properties;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringApplication {

	public static void main(String[] args) {
//		ConfigurableApplicationContext context = SpringApplication.run(DemoSpringApplication.class, args);
//		Employee emp = context.getBean(Employee.class);
//		emp.display();
		System.out.println("Begins.....");
		java.util.Properties p = new Properties();
		String res="/META-INF/maven/com.example.demoSpring/my-artefact/pom.properties";
		java.io.InputStream is = p.getClass().getResourceAsStream(res);
		try {
			if (is == null) {
				p.load(is);
				String name = p.getProperty("name");
				System.out.println(name);
			} else {
				System.out.println("null got returned");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
