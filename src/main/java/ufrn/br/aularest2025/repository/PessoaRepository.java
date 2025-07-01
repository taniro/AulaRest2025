package ufrn.br.aularest2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.aularest2025.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
