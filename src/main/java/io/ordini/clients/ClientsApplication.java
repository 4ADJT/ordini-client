package io.ordini.clients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@SpringBootApplication
@OpenAPIDefinition(servers = { @Server(url = "/", description = "Server URL") })
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class ClientsApplication {

  public static void main(String[] args) {
    SpringApplication.run(ClientsApplication.class, args);
  }

}
