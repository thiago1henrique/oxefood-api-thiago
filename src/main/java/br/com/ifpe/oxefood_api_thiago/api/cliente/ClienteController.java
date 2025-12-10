package br.com.ifpe.oxefood_api_thiago.api.cliente;

import br.com.ifpe.oxefood_api_thiago.modelo.acesso.UsuarioService;
import br.com.ifpe.oxefood_api_thiago.modelo.cliente.Cliente;
import br.com.ifpe.oxefood_api_thiago.modelo.cliente.ClienteService;
import br.com.ifpe.oxefood_api_thiago.modelo.enderecoCliente.EnderecoCliente;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteRequest clienteRequest, HttpServletRequest request) throws BadRequestException {

        // 1. Construímos o objeto cliente separadamente
        Cliente clienteRequisicao = clienteRequest.build();

        // Validações manuais (mantive sua lógica)
        StringBuilder erros = new StringBuilder();

        if (clienteRequisicao.getNome() == null || clienteRequisicao.getNome().equals("")) {
            erros.append("O campo Nome é de preenchimento obrigatório. ");
        }

        if (clienteRequisicao.getFoneCelular() != null && (clienteRequisicao.getFoneCelular().length() < 8 || clienteRequisicao.getFoneFixo().length() > 20)) {
            erros.append("O campo Fone tem que ter entre 8 e 20 caracteres. ");
        }

        if (erros.length() > 0) {
            throw new BadRequestException(erros.toString());
        }

        // 2. Passamos o cliente E o usuário logado para o serviço (conforme Slide 19)
        Cliente clienteSalvo = clienteService.save(clienteRequisicao, usuarioService.obterUsuarioLogado(request));

        return new ResponseEntity<Cliente>(clienteSalvo, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Cliente obterPorID(@PathVariable Long id) {
        return clienteService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody ClienteRequest clienteRequest, HttpServletRequest request) {

        clienteService.update(id, clienteRequest.build(), usuarioService.obterUsuarioLogado(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }

//    aula 18 abaixo

    @PostMapping("/endereco/{clienteId}")
    public ResponseEntity<EnderecoCliente> adicionarEnderecoCliente(@PathVariable("clienteId") Long clienteId, @RequestBody @Valid EnderecoClienteRequest request) {

        EnderecoCliente endereco = clienteService.adicionarEnderecoCliente(clienteId, request.build());
        return new ResponseEntity<EnderecoCliente>(endereco, HttpStatus.CREATED);
    }

    @PutMapping("/endereco/{enderecoId}")
    public ResponseEntity<EnderecoCliente> atualizarEnderecoCliente(@PathVariable("enderecoId") Long enderecoId, @RequestBody EnderecoClienteRequest request) {

        EnderecoCliente endereco = clienteService.atualizarEnderecoCliente(enderecoId, request.build());
        return new ResponseEntity<EnderecoCliente>(endereco, HttpStatus.OK);
    }

    @DeleteMapping("/endereco/{enderecoId}")
    public ResponseEntity<Void> removerEnderecoCliente(@PathVariable("enderecoId") Long enderecoId) {

        clienteService.removerEnderecoCliente(enderecoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/endereco")
    public List<EnderecoCliente> listarEnderecosCliente(@PathVariable Long id) {
        return clienteService.listarEnderecosCliente(id);
    }

    @GetMapping("/endereco/{id}")
    public EnderecoCliente obterEnderecoPorID(@PathVariable Long id) {
        return clienteService.obterEnderecoPorID(id);
    }

}

