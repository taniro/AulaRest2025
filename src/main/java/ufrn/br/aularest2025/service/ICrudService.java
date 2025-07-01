package ufrn.br.aularest2025.service;

import ufrn.br.aularest2025.domain.Pessoa;

import java.util.List;
import java.util.Optional;

public interface ICrudService<T> {
    public List<T> listar();
    public Optional<T> buscarPorId(Long id);
    public T adicionar(T p);
    public T alterar(T p);
    public void remover(Long id);
}
