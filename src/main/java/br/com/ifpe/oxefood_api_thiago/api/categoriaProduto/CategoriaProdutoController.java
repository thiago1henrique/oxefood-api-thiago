package br.com.ifpe.oxefood_api_thiago.api.categoriaProduto;

import br.com.ifpe.oxefood_api_thiago.modelo.categoriaProduto.CategoriaProduto;
import br.com.ifpe.oxefood_api_thiago.modelo.categoriaProduto.CategoriaProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categorias-produtos")
@CrossOrigin

public class CategoriaProdutoController {

    @Autowired
    private CategoriaProdutoService service;

    @PostMapping
    public ResponseEntity<CategoriaProduto> save(@RequestBody CategoriaProdutoRequest request) {
        CategoriaProduto categoriaProduto = service.save(request.build());
        return new ResponseEntity<>(categoriaProduto, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoriaProduto> update(@PathVariable("id") Long id, @RequestBody CategoriaProdutoRequest request) {
        service.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<CategoriaProduto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("{id}")
    public CategoriaProduto obterPorId(@PathVariable Long id) {
        return service.obterPorID(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
