package client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController

//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthClientApp {

    @GetMapping("/demo")
    @PreAuthorize("hasAuthority('query-demo')")
    public String demo(){
        return "demo-0";
    }

    @GetMapping("/demo2")
    @PreAuthorize("hasAuthority('USER')")
    public String demo2(){
        return "demo-2";
    }

    @PostMapping("/demo3")
    @PreAuthorize("hasAuthority('USER')")
    public String demo3(){
        return "demo-3";
    }

    @GetMapping("/demo4")
    @PreAuthorize("hasAuthority('ADMIN,USER')")
    public String demo4(){
        return "demo-4";
    }

    public static void main(String[] args) {
        SpringApplication.run(AuthClientApp.class, args);
    }
}
