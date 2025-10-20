package br.com.ifpe.oxefood_api_thiago.modelo.cliente;

import java.time.LocalDate;
import java.util.List;

import br.com.ifpe.oxefood_api_thiago.util.entity.EntidadeAuditavel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

@Builder
@Entity
@Table(name = "Cliente")
@SQLRestriction("habilitado = true")

@Data
@EqualsAndHashCode(callSuper = true)

@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel  {

    @OneToMany(mappedBy = "cliente", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<EnderecoCliente> enderecos;


    @Column
    private String nome;

    @Column
    private LocalDate dataNascimento;

    @Column
    private String cpf;

    @Column
    private String foneCelular;

    @Column
    private String foneFixo;

}

