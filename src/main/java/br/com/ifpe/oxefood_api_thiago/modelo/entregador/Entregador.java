package br.com.ifpe.oxefood_api_thiago.modelo.entregador;

import br.com.ifpe.oxefood_api_thiago.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;

@Builder
@Entity
@Table(name = "Entregador")
@SQLRestriction("habilitado = true")

@Data
@EqualsAndHashCode(callSuper = true)

@AllArgsConstructor
@NoArgsConstructor

public class Entregador extends EntidadeAuditavel {

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
    private int qtdEntregasRealizadas;

    @Column
    private double valorFrete;

    @Column
    private String enderecoRua;

    @Column
    private String enderecoComplemento;

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
    private boolean ativo;
}
