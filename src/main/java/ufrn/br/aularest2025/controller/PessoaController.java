package ufrn.br.aularest2025.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.br.aularest2025.domain.Pessoa;
import ufrn.br.aularest2025.dto.PessoaRequestDto;
import ufrn.br.aularest2025.dto.PessoaResponseDto;
import ufrn.br.aularest2025.service.PessoaService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pessoa> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDto> getJoiaById(@PathVariable long id){
        Optional<Pessoa> p = service.buscarPorId(id);
        if(p.isPresent()){

            PessoaResponseDto dto = new PessoaResponseDto();
            dto.setNome(p.get().getNome());

            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createJoia(@RequestBody PessoaRequestDto p) throws URISyntaxException {

        Pessoa pEntity = new Pessoa();
        pEntity.setNome(p.getNome());
        pEntity.setIdade(p.getIdade());

        Pessoa pessoa = service.adicionar(pEntity);
        return ResponseEntity.created(new URI("/pessoas/"+pessoa.getId())).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJoiaById(@PathVariable long id){

        Optional<Pessoa> p = service.buscarPorId(id);
        if(p.isPresent()){
            service.remover(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
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