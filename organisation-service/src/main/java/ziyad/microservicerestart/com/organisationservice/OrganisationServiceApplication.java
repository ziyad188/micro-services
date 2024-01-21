package ziyad.microservicerestart.com.organisationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@OpenAPIDefinition(
		info = @Info(
				title = "Organization Service REST APIs",
				description = "Organization Service REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Mohammed ziyad",
						email = "mohdziyadk@gmail.com",
						url = "https://www.webwic.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.webwic.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Department-Service Doc",
				url = "https://www.webwic.com"
		)
)
@SpringBootApplication
public class OrganisationServiceApplication {
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(OrganisationServiceApplication.class, args);
	}

}
