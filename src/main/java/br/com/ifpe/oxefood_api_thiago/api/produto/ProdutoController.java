package br.com.ifpe.oxefood_api_thiago.api.produto;

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

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody ProdutoRequest request) {
        Produto produto = service.save(request.build());
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
}
