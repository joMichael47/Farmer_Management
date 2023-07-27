package com.isj.webapp.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class HelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}

    /*@GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping("/division")
    public String division(@RequestParam(value = "a") int a,@RequestParam(value = "b") int b) {

            return "resultat="+(b!=0?(a/b):"Erreur");

    }*/


}

/*mvnw spring-boot:run*/
/*http://localhost:8080/hello*/

