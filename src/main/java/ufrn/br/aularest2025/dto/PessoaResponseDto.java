package ufrn.br.aularest2025.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import ufrn.br.aularest2025.controller.PessoaController;
import ufrn.br.aularest2025.domain.Endereco;
import ufrn.br.aularest2025.domain.Pessoa;

@Data
public class PessoaResponseDto extends RepresentationModel<PessoaResponseDto> {
    private String nome;

    public void loadLinks(Pessoa pessoa) {
        this.add(WebMvcLinkBuilder.linkTo(PessoaController.class).slash(pessoa.getId()).withSelfRel());
        this.add(WebMvcLinkBuilder.linkTo(PessoaController.class).withRel("pessoas"));
        this.add(WebMvcLinkBuilder.linkTo(PessoaController.class).slash(pessoa.getId()).withRel("delete"));
    }
}
