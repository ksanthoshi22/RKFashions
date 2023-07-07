package RKFashionsEcommerce.Ecommercewebsite.controller;

import RKFashionsEcommerce.Ecommercewebsite.model.Enquiry;
import RKFashionsEcommerce.Ecommercewebsite.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EnquiryController {
    @Autowired
    EnquiryService enquiryService;
    @GetMapping("/inquiries")
    public String getInquiry(Model model){
        Enquiry enquiry = new Enquiry();
        model.addAttribute("inquiry", enquiry);
        return "contact";
    }
    @PostMapping("/inquiries")
    public String postInquiry( @ModelAttribute("inquiry") Enquiry enquiry) {

        enquiryService.saveInquiry(enquiry);
        return "success";

    }
    @GetMapping("/admin/inquiries")
    public String getInquiries(Model model) {
        List<Enquiry> inquiries = enquiryService.getAllInquiries();
        model.addAttribute("inquiries", inquiries);
        return "enquiries";
    }
}
