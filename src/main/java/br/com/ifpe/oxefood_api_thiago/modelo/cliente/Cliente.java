package br.com.ifpe.oxefood_api_thiago.modelo.cliente;

import br.com.ifpe.oxefood_api_thiago.modelo.enderecoCliente.EnderecoCliente;
import br.com.ifpe.oxefood_api_thiago.util.entity.EntidadeAuditavel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Cliente")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel  {

    @OneToMany(mappedBy = "cliente", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<EnderecoCliente> enderecos;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column
    private LocalDate dataNascimento;

    @Column(unique = true)
    private String cpf;

    @Column
    private String foneCelular;

    @Column
    private String foneFixo;

}

