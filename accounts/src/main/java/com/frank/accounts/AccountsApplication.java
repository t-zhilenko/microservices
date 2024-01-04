package com.frank.accounts;

import com.frank.accounts.dto.AccountsContactInfoDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
/*@ComponentScans({ @ComponentScan("com.frank.accounts.controller") })
@EnableJpaRepositories("com.frank.accounts.repository")
@EntityScan("com.frank.accounts.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDTO.class})
@OpenAPIDefinition(
		info = @Info(title = "Account microservice REST API Documentation",
		description = "Frank bank microservice REST API Documentation",
		version = "v1",
		contact = @Contact(name = "Tetiana Zhylenko", email = "t.zhilenko@gmail.com"),
		license = @License(name = "Apache 2.0")),
		externalDocs = @ExternalDocumentation(
				description = "Frank bank documentation",
				url = "http://localhost:8080/swagger-ui/index.html")
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
