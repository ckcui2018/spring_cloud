package oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.provider.authentication.TokenExtractor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@ComponentScan
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class OAuth2App {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2App.class, args);
    }

    @GetMapping("/login")
    public String login(@RequestParam("username") String username) {

        System.out.println("username:  " + username);
        return "login-0";
    }


    @GetMapping("/logout")
    public String logout() {

        System.out.println("logout:");

        return "logout-0";
    }
}
