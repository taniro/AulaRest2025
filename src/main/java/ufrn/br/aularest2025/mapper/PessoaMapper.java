package ufrn.br.aularest2025.mapper;

import org.mapstruct.Mapper;
import ufrn.br.aularest2025.domain.Pessoa;
import ufrn.br.aularest2025.dto.PessoaRequestDto;
import ufrn.br.aularest2025.dto.PessoaResponseDto;

@Mapper (componentModel = "spring")
public interface PessoaMapper {
    Pessoa toEntity(PessoaRequestDto pessoaRequestDto);
    PessoaResponseDto doDto(Pessoa pessoa);
}
