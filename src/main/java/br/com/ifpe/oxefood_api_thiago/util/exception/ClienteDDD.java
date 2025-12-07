package br.com.ifpe.oxefood_api_thiago.util.exception;

public class ClienteDDD extends RuntimeException {
    public ClienteDDD() {
        super("DDD não permitido.");
    }
}
