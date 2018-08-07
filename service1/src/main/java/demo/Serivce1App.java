package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Serivce1App {

    @GetMapping("/service1")
    public String test(){
        return "service1";
    }

    @GetMapping("/common")
    public String common(){
        return "common-1" ;
    }

    public static void main(String[] args) {
        SpringApplication.run(Serivce1App.class, args);
    }
}
