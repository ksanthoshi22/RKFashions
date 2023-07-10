package RKFashionsEcommerce.Ecommercewebsite.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(DataAccessException.class)
    public String handleDataAccessException(DataAccessException ex, Model model) {
        // Log the exception or perform any necessary actions
        model.addAttribute("errorMessage", "An error occurred while retrieving inquiries.");
        return "errorPage";
    }
}
