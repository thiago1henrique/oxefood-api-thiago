package br.com.ifpe.oxefood_api_thiago.util.exception;

public class ProdutoException extends RuntimeException {
    public static final String MSG_VALOR = "Não é permitido inserir produto com tal valor.";

    public ProdutoException(String msg) {

        super(String.format(msg));
    }

}
