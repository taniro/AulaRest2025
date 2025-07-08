package ufrn.br.aularest2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.aularest2025.domain.SecurityUser;

import java.util.Optional;

public interface SecurityUserRepository extends JpaRepository<SecurityUser, Integer> {
    Optional<SecurityUser> findByUsername(String username);
}
