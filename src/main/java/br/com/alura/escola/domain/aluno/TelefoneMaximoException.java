package br.com.alura.escola.domain.aluno;

public class TelefoneMaximoException extends RuntimeException {

    public TelefoneMaximoException() {
        super("Numero maximo de telefones ja atingido");
    }
}
