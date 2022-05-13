package se.iths.HealthApp.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("userportal")
    public String userPortal() {
        return "Welcome, you are now authenticated";
    }

    @GetMapping("adminportal")
    public String adminPortal() {
        return "Welcome admin!";
    }
}
