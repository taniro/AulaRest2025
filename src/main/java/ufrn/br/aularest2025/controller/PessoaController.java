package ufrn.br.aularest2025.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.br.aularest2025.core.exception.PessoaNotFoundExpection;
import ufrn.br.aularest2025.domain.Pessoa;
import ufrn.br.aularest2025.dto.PessoaRequestDto;
import ufrn.br.aularest2025.dto.PessoaResponseDto;
import ufrn.br.aularest2025.mapper.PessoaMapper;
import ufrn.br.aularest2025.service.PessoaService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    final PessoaService service;
    final PessoaMapper mapper;

    public PessoaController(PessoaService service, PessoaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<PessoaResponseDto> listar() {

        List<Pessoa> pessoas = service.listar();
        List<PessoaResponseDto> dtos = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {

            PessoaResponseDto localDto = mapper.doDto(pessoa);
            localDto.loadLinks(pessoa);

            dtos.add(localDto);
        }
        return dtos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDto> getJoiaById(@PathVariable long id){
        Optional<Pessoa> p = service.buscarPorId(id);
        if(p.isPresent()){

            PessoaResponseDto dto = mapper.doDto(p.get());

            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createJoia(@RequestBody PessoaRequestDto p) throws URISyntaxException {

        Pessoa pEntity = mapper.toEntity(p);

        /*
        for (Long id : p.getIdDosProdutos()){
            pEntity.addProduto(produtoService.findById(id));
        }
         */

        Pessoa pessoa = service.adicionar(pEntity);
        return ResponseEntity.created(new URI("/pessoas/"+pessoa.getId())).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJoiaById(@PathVariable long id) throws PessoaNotFoundExpection {

        Optional<Pessoa> p = service.buscarPorId(id);
        if(p.isEmpty()){
            throw new PessoaNotFoundExpection("Pessoa com id " + id + " não encontrada.");
        }
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateJoia(@RequestBody Pessoa p, @PathVariable long id){

        Optional<Pessoa> pessoa = service.buscarPorId(id);
        if(pessoa.isPresent()){
            return ResponseEntity.ok(service.alterar(p));
        }
        return ResponseEntity.notFound().build();
    }

}