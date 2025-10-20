package br.com.ifpe.oxefood_api_thiago.modelo.produto;

import br.com.ifpe.oxefood_api_thiago.modelo.categoriaProduto.CategoriaProduto;
import br.com.ifpe.oxefood_api_thiago.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "Produto")
@SQLRestriction("habilitado = true")

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Produto extends EntidadeAuditavel {

    @ManyToOne
    private CategoriaProduto categoriaProduto;

    @Column
    private String codigo;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private double valorUnitario;

    @Column
    private int tempoEntregaMinimo;

    @Column
    private int tempoEntregaMaximo;
}
