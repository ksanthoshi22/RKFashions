package RKFashionsEcommerce.Ecommercewebsite.repository;

import RKFashionsEcommerce.Ecommercewebsite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);
}
