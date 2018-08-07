package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Serivce0App {

    @GetMapping("/service0")
    public String test(){

        return "service0" ;
    }

    @GetMapping("/common")
    public String common(){

        return "common-0" ;
    }

    public static void main(String[] args) {
        SpringApplication.run(Serivce0App.class, args);
    }
}
