package co.edu.uco.spaonline.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.spaonline.controller"})
public class SpaOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaOnlineApplication.class, args);
	}

}
