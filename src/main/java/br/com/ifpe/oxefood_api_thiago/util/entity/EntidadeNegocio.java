package br.com.ifpe.oxefood_api_thiago.util.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = { "id" })
public abstract class EntidadeNegocio implements Serializable {

    private Long id;

    private Boolean habilitado;

}
