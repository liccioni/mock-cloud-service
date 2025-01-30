package net.liccioni.mockcloudservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class EchoServiceController {

    private final StreamBridge streamBridge;

    public EchoServiceController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @PostMapping("/echo")
    public Mono<String> echoService(@RequestBody EchoMessage echoMessage) {
        log.info("Received: {}", echoMessage.getMessage());
        streamBridge.send("echo-service-send", MessageBuilder.withPayload(echoMessage).build());
        return Mono.just(echoMessage.getMessage());
    }
}
