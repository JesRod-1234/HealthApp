package se.iths.HealthApp.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.iths.HealthApp.Exception.EmptyException;

@RestController
public class AuthController {

    @GetMapping
    public String homepage(){
        throw new EmptyException("NAAAEEJ");
    }

    @GetMapping("userportal")
    public String userPortal () {
        return "Welcome, you are now authenticated";
    }

    @GetMapping("adminportal")
    public String adminPortal () {
        return "Welcome admin!";
    }
}
