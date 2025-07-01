package ufrn.br.aularest2025.service;


import org.springframework.stereotype.Service;
import ufrn.br.aularest2025.domain.Endereco;
import ufrn.br.aularest2025.repository.EnderecoRepository;

@Service
public class EnderecoService extends AbstractService<Endereco, EnderecoRepository> {

    public EnderecoService(EnderecoRepository repo) {
        super(repo);
    }
}
