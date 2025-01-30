package net.liccioni.mockcloudservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Slf4j
@SpringBootApplication
public class MockCloudServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockCloudServiceApplication.class, args);
    }

    @Bean
    public Consumer<Message<EchoMessage>> echoServiceInput(StreamBridge streamBridge) {
        return message -> {
            log.info("Consumed Message: {}", message);
            streamBridge.send("echo-service-output", message);
        };
    }
}
