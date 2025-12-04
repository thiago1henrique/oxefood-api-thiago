package br.com.ifpe.oxefood_api_thiago.modelo.categoriaProduto;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProdutoService {

    @Autowired
    private CategoriaProdutoRepository repository;

    @Transactional
    public CategoriaProduto save(CategoriaProduto categoriaProduto) {
        categoriaProduto.setHabilitado(Boolean.TRUE);
        return repository.save(categoriaProduto);
    }

    public void delete(Long id) {
        CategoriaProduto categoriaProduto = repository.findById(id).get();
        categoriaProduto.setHabilitado(Boolean.FALSE);
        repository.save(categoriaProduto);
    }

    public CategoriaProduto obterPorId(Long id) {
        return repository.findById(id).get();
    }

    public List<CategoriaProduto> listarTodos() {
        return repository.findAll();
    }

    @Transactional
    public void update(Long id, CategoriaProduto categoriaProdutoAlterado) {
        CategoriaProduto categoriaProduto = repository.findById(id).get();
        categoriaProduto.setDescricao(categoriaProdutoAlterado.getDescricao());

        repository.save(categoriaProduto);
    }

}
