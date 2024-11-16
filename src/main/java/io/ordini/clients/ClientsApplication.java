package io.ordini.clients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(servers = { @Server(url = "/", description = "Server URL") })
public class ClientsApplication {

  public static void main(String[] args) {
    SpringApplication.run(ClientsApplication.class, args);
  }

}
