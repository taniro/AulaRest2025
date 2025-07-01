package ufrn.br.aularest2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.aularest2025.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
