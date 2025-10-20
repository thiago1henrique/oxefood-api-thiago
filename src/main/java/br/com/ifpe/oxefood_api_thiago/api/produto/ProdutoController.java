package br.com.ifpe.oxefood_api_thiago.api.produto;

import br.com.ifpe.oxefood_api_thiago.modelo.categoriaProduto.CategoriaProdutoService;
import br.com.ifpe.oxefood_api_thiago.modelo.produto.Produto;
import br.com.ifpe.oxefood_api_thiago.modelo.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin

public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Autowired
    private CategoriaProdutoService categoriaProdutoService;

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody ProdutoRequest request) {

        Produto produtoNovo = request.build();
        produtoNovo.setCategoriaProduto(categoriaProdutoService.obterPorID(request.getIdCategoria()));

        Produto produto = service.save(produtoNovo);
        return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("{id}")
    public Produto obterPorId(@PathVariable Long id) {
        return service.obterPorID(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") Long id, @RequestBody ProdutoRequest request) {
        Produto produto = request.build();
        produto.setCategoriaProduto(categoriaProdutoService.obterPorID(request.getIdCategoria()));
        service.update(id, produto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
