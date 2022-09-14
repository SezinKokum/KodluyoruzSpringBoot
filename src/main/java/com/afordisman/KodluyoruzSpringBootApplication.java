package com.afordisman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//Security inactive
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
)

//Auditing
@EnableJpaAuditing(auditorAwareRef = "auditorAware" ) //AuditorAwareBean deki onje adı referans oluyor
public class KodluyoruzSpringBootApplication {

    public static void main(String[] args) {

        SpringApplication.run(KodluyoruzSpringBootApplication.class, args);
    }

}
