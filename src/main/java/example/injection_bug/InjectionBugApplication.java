package example.injection_bug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InjectionBugApplication {

	public static void main(String[] args) {
		SpringApplication.run(InjectionBugApplication.class, args);
	}

}
