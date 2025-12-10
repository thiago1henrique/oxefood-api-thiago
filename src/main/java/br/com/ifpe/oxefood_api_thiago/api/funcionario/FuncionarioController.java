package br.com.ifpe.oxefood_api_thiago.api.funcionario;

import br.com.ifpe.oxefood_api_thiago.modelo.acesso.Perfil;
import br.com.ifpe.oxefood_api_thiago.modelo.funcionario.Funcionario;
import br.com.ifpe.oxefood_api_thiago.modelo.funcionario.FuncionarioService;
import br.com.ifpe.oxefood_api_thiago.modelo.funcionario.TipoFuncionario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionario")
@CrossOrigin
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<Funcionario> save(@RequestBody @Valid FuncionarioRequest request) {

        Funcionario funcionarioNovo = request.build();

        if (funcionarioNovo.getTipo().equals(TipoFuncionario.ADMINISTRADOR)) {
            funcionarioNovo.getUsuario().getRoles().add(new Perfil(Perfil.ROLE_FUNCIONARIO_ADMIN));
        } else if (funcionarioNovo.getTipo().equals(TipoFuncionario.OPERADOR)) {
            funcionarioNovo.getUsuario().getRoles().add(new Perfil(Perfil.ROLE_FUNCIONARIO_USER));
        }

        Funcionario funcionario = funcionarioService.save(funcionarioNovo);
        return new ResponseEntity<Funcionario>(funcionario, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Funcionario obterPorID(@PathVariable Long id) {
        return funcionarioService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable("id") Long id, @RequestBody FuncionarioRequest request) {
        funcionarioService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        funcionarioService.delete(id);
        return ResponseEntity.ok().build();
    }

} // A classe termina aqui