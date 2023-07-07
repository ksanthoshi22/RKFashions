package RKFashionsEcommerce.Ecommercewebsite.service;
        import RKFashionsEcommerce.Ecommercewebsite.model.Enquiry;
        import RKFashionsEcommerce.Ecommercewebsite.repository.EnquiryRepository;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.MockitoAnnotations;
        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.mockito.Mockito.when;

public class EnquiryServiceTest {

    @Mock
    private EnquiryRepository enquiryRepository;

    @InjectMocks
    private EnquiryService enquiryService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveInquiry() {
        // Arrange
        Enquiry enquiry = new Enquiry();
        enquiry.setName("John Doe");
        enquiry.setEmail("johndoe@example.com");
        enquiry.setSubject("Test subject");
        enquiry.setEnquiry("Test enquiry");

        when(enquiryRepository.save(enquiry)).thenReturn(enquiry);

        // Act
        Enquiry savedInquiry = enquiryService.saveInquiry(enquiry);

        // Assert
        assertEquals(enquiry, savedInquiry);
    }
}
