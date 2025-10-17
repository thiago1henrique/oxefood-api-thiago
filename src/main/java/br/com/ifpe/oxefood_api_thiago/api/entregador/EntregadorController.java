package br.com.ifpe.oxefood_api_thiago.api.entregador;

import br.com.ifpe.oxefood_api_thiago.modelo.entregador.Entregador;
import br.com.ifpe.oxefood_api_thiago.modelo.entregador.EntregadorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entregador")
@CrossOrigin

public class EntregadorController {

    @Autowired
    private EntregadorService service;

    @PostMapping
    public ResponseEntity<Entregador> save(@RequestBody EntregadorRequest request) {
        Entregador entregador = service.save(request.build());
        return new ResponseEntity<Entregador>(entregador, HttpStatus.CREATED);
    }
}
