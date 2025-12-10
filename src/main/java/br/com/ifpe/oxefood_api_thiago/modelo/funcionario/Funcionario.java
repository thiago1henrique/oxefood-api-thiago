package br.com.ifpe.oxefood_api_thiago.modelo.funcionario;

import br.com.ifpe.oxefood_api_thiago.modelo.acesso.Usuario;
import br.com.ifpe.oxefood_api_thiago.util.entity.EntidadeAuditavel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;

@Entity
@Table(name = "Funcionario")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario extends EntidadeAuditavel {

    @OneToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoFuncionario tipo;

    @Column
    private String nome;

    @Column
    private String cpf;

    @Column
    private String rg;

    @Column
    private LocalDate dataNascimento;

    @Column
    private String foneCelular;

    @Column
    private String foneFixo;

    @Column
    private Double salario;

    @Column
    private String enderecoRua;

    @Column
    private String enderecoNumero;

    @Column
    private String enderecoBairro;

    @Column
    private String enderecoCidade;

    @Column
    private String enderecoCep;

    @Column
    private String enderecoUf;

    @Column
    private String enderecoComplemento;

}
