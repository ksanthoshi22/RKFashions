package RKFashionsEcommerce.Ecommercewebsite.service;


import RKFashionsEcommerce.Ecommercewebsite.dto.UserDto;
import RKFashionsEcommerce.Ecommercewebsite.exception.DataNotFoundException;
import RKFashionsEcommerce.Ecommercewebsite.exception.UserIdMismatchException;
import RKFashionsEcommerce.Ecommercewebsite.exception.UserNotFoundException;
import RKFashionsEcommerce.Ecommercewebsite.model.Role;
import RKFashionsEcommerce.Ecommercewebsite.model.User;
import RKFashionsEcommerce.Ecommercewebsite.model.UserRole;
import RKFashionsEcommerce.Ecommercewebsite.repository.RoleRepository;
import RKFashionsEcommerce.Ecommercewebsite.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public User createUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(List.of(createRoleIfNotExist(userDto)));
        return userRepository.save(user);
    }

    private Role createRoleIfNotExist(UserDto userDto) {
        UserRole userRole;
        if (userDto.getEmail().startsWith("admin")) {
            userRole = UserRole.ROLE_ADMIN;

        } else {
            userRole = UserRole.ROLE_USER;
        }
        Role role = roleRepository.findByName(userRole.name());
        if (role == null) {
            role = new Role();
            role.setName(userRole.name());
            return roleRepository.save(role);
        }
        return role;
    }


    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User findUser(Long id) throws DataNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(DataNotFoundException::new);
    }

    public User findUserByEmail(String email) throws DataNotFoundException {
        return userRepository.findByEmail(email);
    }

    public void deleteUser(Long id) throws DataNotFoundException {
        userRepository.findById(id)
                .orElseThrow(DataNotFoundException::new);
        userRepository.deleteById(id);
    }

    public User updateUser(User user, Long id) throws UserIdMismatchException, DataNotFoundException {
        if (user.getId() != id) {
            throw new UserIdMismatchException();
        }
        userRepository.findById(id)
                .orElseThrow(DataNotFoundException::new);
        return userRepository.save(user);
    }
}