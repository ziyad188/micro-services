package ziyad.microservicerestart.com.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.client.WebClient;
//here we use enable feign client it is a type of communication between two services
@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service REST APIs",
				description = "Employee Service REST APIs Documentation",
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
@EnableFeignClients
public class EmployeeServiceApplication {
@Bean
public ModelMapper modelMapper() {
	return new ModelMapper();
}
//configuring webclient as spring beam
//	@Bean
//public WebClient webClient(){
//	return WebClient.builder().build();
//}
	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
