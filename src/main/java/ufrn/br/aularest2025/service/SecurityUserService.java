package ufrn.br.aularest2025.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ufrn.br.aularest2025.repository.SecurityUserRepository;

@Service
public class SecurityUserService implements UserDetailsService {

    private final SecurityUserRepository repository;

    public SecurityUserService(SecurityUserRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Buscando usuário: " + username);
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("not found user " + username));
    }
}
