package net.liccioni.mockcloudservice;

import org.springframework.boot.SpringApplication;

public class TestMockCloudServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(MockCloudServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
