package br.com.ifpe.oxefood_api_thiago.modelo.categoriaProduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<CategoriaProduto> listarTodos() {
        return repository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        CategoriaProduto categoriaProduto = repository.findById(id).get();
        categoriaProduto.setHabilitado(Boolean.FALSE);
        repository.save(categoriaProduto);
    }

    public CategoriaProduto obterPorID(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, CategoriaProduto categoriaProduto) {
        CategoriaProduto categoriaProdutoAtual = repository.findById(id).get();
        categoriaProdutoAtual.setDescricao(categoriaProduto.getDescricao());
        repository.save(categoriaProdutoAtual);
    }
}
