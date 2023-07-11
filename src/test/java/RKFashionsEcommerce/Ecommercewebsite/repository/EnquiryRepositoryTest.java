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



    @Test
    public void testFindById_NonexistentEnquiry_ReturnsEmptyOptional() {
        // Arrange
        long nonexistentEnquiryId = 123456789L;

        // Act
        Optional<Enquiry> foundEnquiryOptional = enquiryRepository.findById(nonexistentEnquiryId);

        // Assert
        assertFalse(foundEnquiryOptional.isPresent());
    }

}

