package RKFashionsEcommerce.Ecommercewebsite.repository;


import RKFashionsEcommerce.Ecommercewebsite.service.EnquiryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import RKFashionsEcommerce.Ecommercewebsite.model.Enquiry;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
public class EnquiryRepositoryTest {
    @Mock
    private EnquiryRepository enquiryRepository;

//    @Test
//    public void testSaveEnquiry() {
//        // Arrange
//        Enquiry enquiry = new Enquiry();
//        enquiry.setName("John Doe");
//        enquiry.setEmail("johndoe@example.com");
//        enquiry.setSubject("Enquiry Subject");
//        enquiry.setEnquiry("Enquiry message");
//
//        // Act
//        Enquiry savedEnquiry = enquiryRepository.save(enquiry);
//
//        // Assert
//        assertEquals(enquiry, savedEnquiry);
//    }
//
//    @Test
//    public void testFindById_ExistingEnquiry_ReturnsEnquiry() {
//        // Arrange
//        Enquiry enquiry = new Enquiry();
//        enquiry.setName("John Doe");
//        enquiry.setEmail("johndoe@example.com");
//        enquiry.setSubject("Enquiry Subject");
//        enquiry.setEnquiry("Enquiry message");
//
//        Enquiry savedEnquiry = enquiryRepository.save(enquiry);
//
//        // Act
//        Optional<Enquiry> foundEnquiryOptional = enquiryRepository.findById(savedEnquiry.getId());
//
//        // Assert
//        assertTrue(foundEnquiryOptional.isPresent());
//        assertEquals(savedEnquiry, foundEnquiryOptional.get());
//    }

    @Test
    public void testFindById_NonexistentEnquiry_ReturnsEmptyOptional() {
        // Arrange
        long nonexistentEnquiryId = 123456789L;

        // Act
        Optional<Enquiry> foundEnquiryOptional = enquiryRepository.findById(nonexistentEnquiryId);

        // Assert
        assertFalse(foundEnquiryOptional.isPresent());
    }

//    @Test
//    public void testFindAllEnquiries() {
//        // Arrange
//        Enquiry enquiry1 = new Enquiry();
//        enquiry1.setName("John Doe");
//        enquiry1.setEmail("johndoe@example.com");
//        enquiry1.setSubject("Enquiry Subject 1");
//        enquiry1.setEnquiry("Enquiry message 1");
//
//        Enquiry enquiry2 = new Enquiry();
//        enquiry2.setName("Jane Smith");
//        enquiry2.setEmail("janesmith@example.com");
//        enquiry2.setSubject("Enquiry Subject 2");
//        enquiry2.setEnquiry("Enquiry message 2");
//
//        enquiryRepository.save(enquiry1);
//        enquiryRepository.save(enquiry2);
//
//        // Act
//        List<Enquiry> enquiries = enquiryRepository.findAll();
//
//        // Assert
//
//        assertTrue(enquiries.contains(enquiry1));
//        assertTrue(enquiries.contains(enquiry2));
//
//    }
}

