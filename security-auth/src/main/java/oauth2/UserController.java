package oauth2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/user")
    public Principal user(Principal user){

        System.out.println("/user/");
        return user;
    }
    @GetMapping("/order")
    public String order(){

        System.out.println("/order/");
        return "order";
    }

}
