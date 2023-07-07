package RKFashionsEcommerce.Ecommercewebsite.service;

import RKFashionsEcommerce.Ecommercewebsite.model.Enquiry;

import RKFashionsEcommerce.Ecommercewebsite.repository.EnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnquiryService {
    @Autowired
    EnquiryRepository enquiryRepository;

    public Enquiry saveInquiry(Enquiry enquiry) {
        return enquiryRepository.save(enquiry);
    }

    public List<Enquiry> getAllInquiries() {
        return enquiryRepository.findAll();
    }
}

