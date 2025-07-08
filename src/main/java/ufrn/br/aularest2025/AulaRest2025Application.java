package ufrn.br.aularest2025;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ufrn.br.aularest2025.core.security.RsaKeyProperties;
import ufrn.br.aularest2025.domain.Pessoa;
import ufrn.br.aularest2025.domain.SecurityUser;
import ufrn.br.aularest2025.repository.SecurityUserRepository;

@SpringBootApplication
@EnableConfigurationProperties (RsaKeyProperties.class)
public class AulaRest2025Application {

    public static void main(String[] args) {
        SpringApplication.run(AulaRest2025Application.class, args);
    }

    @Autowired
    SecurityUserRepository securityUserRerpository;

    @Autowired
    BCryptPasswordEncoder encoder;


    @PostConstruct
    public void started() {
        Pessoa p = new Pessoa("João", 20, true);

        SecurityUser securityUser = new SecurityUser();
        securityUser.setPessoa(p);
        securityUser.setUsername("admin");
        securityUser.setPassword(encoder.encode("admin"));

        securityUserRerpository.save(securityUser);
    }

}
