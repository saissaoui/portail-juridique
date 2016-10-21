package fr.artefrance.daj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class PortailJuridiqueWsApplication {
    public static void main(String[] args) {
        SpringApplication.run(
                PortailJuridiqueWsApplication.class,
                args);
    }
}
