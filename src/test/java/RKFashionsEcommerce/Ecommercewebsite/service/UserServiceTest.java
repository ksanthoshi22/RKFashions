package RKFashionsEcommerce.Ecommercewebsite.service;
import RKFashionsEcommerce.Ecommercewebsite.dto.UserDto;
import RKFashionsEcommerce.Ecommercewebsite.model.Role;
import RKFashionsEcommerce.Ecommercewebsite.model.User;
import RKFashionsEcommerce.Ecommercewebsite.repository.RoleRepository;
import RKFashionsEcommerce.Ecommercewebsite.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.stream.Stream;
import static org.mockito.ArgumentMatchers.any;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private RoleRepository roleRepository;

    private UserService userService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository, passwordEncoder, roleRepository);
        Mockito.when(roleRepository.save(any())).thenReturn(Mockito.mock(Role.class));
    }

    @ParameterizedTest
    @MethodSource("userDtoProvider")
    void testCreateUser(UserDto userDto) {
        User user = new User();
        user.setId(1L);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword("hashedPassword");
        user.setRoles(List.of(new Role()));

        Mockito.when(passwordEncoder.encode(userDto.getPassword())).thenReturn("hashedPassword");
        Mockito.when(userRepository.save(any(User.class))).thenReturn(user);

        User result = userService.createUser(userDto);

        Assertions.assertEquals(user.getId(), result.getId());
        Assertions.assertEquals(user.getFirstName(), result.getFirstName());
        Assertions.assertEquals(user.getLastName(), result.getLastName());
        Assertions.assertEquals(user.getEmail(), result.getEmail());
        Assertions.assertEquals(user.getPassword(), result.getPassword());
        Assertions.assertEquals(user.getRoles(), result.getRoles());

        Mockito.verify(userRepository, Mockito.times(1)).save(any(User.class));
    }

    private static Stream<Arguments> userDtoProvider() {
        return Stream.of(
                Arguments.of(createUserDto("John", "Doe", 30, "Male", 1234567890L, "john@example.com", "password")),
                Arguments.of(createUserDto("Jane", "Smith", 25, "Female", 9876543210L, "jane@example.com", "password"))
                // Add more test cases as needed
        );
    }

    private static UserDto createUserDto(String firstName, String lastName, int age, String gender, Long phoneNumber, String email, String password) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        userDto.setEmail(email);
        userDto.setPassword(password);
        return userDto;
    }
}