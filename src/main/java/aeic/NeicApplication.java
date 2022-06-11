package aeic;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan({"aeic","controller"})
public class NeicApplication {

	public static void main(String[] args) {
//		new File(DocumentsController.directory).mkdir();
		SpringApplication.run(NeicApplication.class, args);
	}

}
