package RKFashionsEcommerce.Ecommercewebsite.security;


import RKFashionsEcommerce.Ecommercewebsite.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


    @Service
    public class CustomUserDetailsService implements UserDetailsService {

        private UserRepository userRepository;

        public CustomUserDetailsService(UserRepository userRepository) {
            super();
            this.userRepository = userRepository;
        }

        @Override
        public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
            RKFashionsEcommerce.Ecommercewebsite.model.User user = userRepository.findByEmail(usernameOrEmail);
            if (user != null) {
                return new User(user.getEmail(),
                        user.getPassword(),
                        user.getRoles().stream()
                                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                                .collect(Collectors.toList()));
            } else {
                throw new UsernameNotFoundException("Invalid email or password");
            }
        }
    }

