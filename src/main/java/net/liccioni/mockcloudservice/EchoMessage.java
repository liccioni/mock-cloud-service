package net.liccioni.mockcloudservice;

import lombok.Data;

@Data
public class EchoMessage {
    private final String message;
    private final String correlationId;
}
