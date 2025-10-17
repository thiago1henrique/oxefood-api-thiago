package br.com.ifpe.oxefood_api_thiago.modelo.cliente;

import java.time.LocalDate;

import br.com.ifpe.oxefood_api_thiago.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

