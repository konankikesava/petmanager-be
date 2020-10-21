package ee.cgi.kk.petmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class PetmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetmanagerApplication.class, args);
	}

}
