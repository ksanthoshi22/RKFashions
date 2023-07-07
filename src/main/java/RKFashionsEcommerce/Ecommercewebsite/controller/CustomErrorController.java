package RKFashionsEcommerce.Ecommercewebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/error")
public class CustomErrorController {
    @RequestMapping("/404")
    public String handleNotFound() {
        // Custom handling for 404 Not Found error
        return "error/404"; // Return the path to your custom error page
    }
}
