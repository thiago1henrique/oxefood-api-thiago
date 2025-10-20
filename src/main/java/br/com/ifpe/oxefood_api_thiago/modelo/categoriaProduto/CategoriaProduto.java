package br.com.ifpe.oxefood_api_thiago.modelo.categoriaProduto;

import br.com.ifpe.oxefood_api_thiago.util.entity.EntidadeNegocio;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "CategoriaProduto")
@SQLRestriction( "habilitado = true")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategoriaProduto extends EntidadeNegocio {

    @Column
    private String descricao;
}
