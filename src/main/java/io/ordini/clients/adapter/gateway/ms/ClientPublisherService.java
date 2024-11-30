package io.ordini.clients.adapter.gateway.ms;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ClientPublisherService {

  private final StreamBridge streamBridge;

  public void publishNewClientEvent(String json) {

    boolean sent = streamBridge.send("new-client", json);
    if (sent) {
      log.info("Message sent to 'clients-exchange' with routing key: new-client");
    } else {
      log.error("Failed to send message to 'clients-exchange'");
    }
  }

}
