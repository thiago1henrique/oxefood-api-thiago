package br.com.ifpe.oxefood_api_thiago.api.entregador;

import br.com.ifpe.oxefood_api_thiago.modelo.entregador.Entregador;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class EntregadorRequest {

    private String nome;
    private String cpf;
    private String rg;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String foneCelular;
    private String foneFixo;
    private int qtdEntregasRealizadas;
    private double valorFrete;
    private String enderecoRua;
    private String enderecoComplemento;
    private String enderecoNumero;
    private String enderecoBairro;
    private String enderecoCidade;
    private String enderecoCep;
    private String enderecoUf;
    private boolean ativo;

    public Entregador build() {
        return Entregador.builder()
                .nome(nome)
                .cpf(cpf)
                .rg(rg)
                .dataNascimento(dataNascimento)
                .foneCelular(foneCelular)
                .foneFixo(foneFixo)
                .qtdEntregasRealizadas(qtdEntregasRealizadas)
                .valorFrete(valorFrete)
                .enderecoRua(enderecoRua)
                .enderecoComplemento(enderecoComplemento)
                .enderecoNumero(enderecoNumero)
                .enderecoBairro(enderecoBairro)
                .enderecoCidade(enderecoCidade)
                .enderecoCep(enderecoCep)
                .enderecoUf(enderecoUf)
                .ativo(ativo)
                .build();
    }
}