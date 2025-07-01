package ufrn.br.aularest2025.service;


import org.springframework.stereotype.Service;
import ufrn.br.aularest2025.domain.Pessoa;
import ufrn.br.aularest2025.repository.PessoaRepository;

@Service
public class PessoaService extends AbstractService<Pessoa, PessoaRepository> {
    public PessoaService(PessoaRepository repository) {
        super(repository);
    }
}
