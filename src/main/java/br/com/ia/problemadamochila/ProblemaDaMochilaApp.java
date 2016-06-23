package br.com.ia.problemadamochila;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class ProblemaDaMochilaApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProblemaDaMochilaApp.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ProblemaDaMochilaApp.class, args);
    }
}
