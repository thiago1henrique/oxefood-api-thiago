package br.com.ifpe.oxefood_api_thiago.modelo.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto) {
        return repository.save(produto);
    }
}
