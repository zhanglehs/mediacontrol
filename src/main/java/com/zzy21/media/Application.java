package com.zzy21.media;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Application implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8089);
    }

    @RequestMapping("/media/v1/query_source")
    String home() {
        return "{\"ip\":\"127.0.0.1\",\"udp_port\":8142,\"tcp_port\":8102,\"http_port\":8142}";
    }
}
