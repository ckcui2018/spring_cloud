package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.Service1Client;

@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
//@EnableEurekaClient
@EnableFeignClients(basePackages =("service"))
@RestController
public class FeignApp {

    @Autowired
    Service1Client service1Client;

    @GetMapping("/service2")
    public String test(){
        System.out.println(service1Client.getSvr1Test());
        System.out.println(service1Client.getSvr0Test());

        return "service2" + " -> " + service1Client.getSvr1Test() + " -> " + service1Client.getSvr0Test();
    }

    @GetMapping("/common")
    public String common(){
        System.out.println("common-figen");

        return "common-figen" + " -> " + service1Client.common() ;
    }


    public static void main(String[] args) {
        SpringApplication.run(FeignApp.class, args);
    }
}
