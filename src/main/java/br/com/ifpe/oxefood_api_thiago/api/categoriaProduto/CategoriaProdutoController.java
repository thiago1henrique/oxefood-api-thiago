package br.com.ifpe.oxefood_api_thiago.api.categoriaProduto;

import br.com.ifpe.oxefood_api_thiago.modelo.categoriaProduto.CategoriaProduto;
import br.com.ifpe.oxefood_api_thiago.modelo.categoriaProduto.CategoriaProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias-produtos")
@CrossOrigin

public class CategoriaProdutoController {

    @Autowired
    private CategoriaProdutoService categoriaProdutoService;

    @PostMapping
    public ResponseEntity<CategoriaProduto> save(@RequestBody CategoriaProdutoRequest request) {
        CategoriaProduto categoriaProduto = categoriaProdutoService.save(request.build());
        return ResponseEntity.ok().body(categoriaProduto);
    }

    @GetMapping
    public List<CategoriaProduto> listarTodos() {
        return categoriaProdutoService.listarTodos();
    }

    @GetMapping("/{id}")
    public CategoriaProduto obterPorId(@PathVariable Long id) {
        return categoriaProdutoService.obterPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaProdutoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProduto> update(@PathVariable("id") Long id, @RequestBody CategoriaProdutoRequest request) {
        categoriaProdutoService.update(id, request.build());

        return ResponseEntity.ok().build();
    }

}
