package bg.softuni.moneyApp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/test")
public class TestController {

    @GetMapping
    public String getTest() {
        return "this is a test";
    }
}
