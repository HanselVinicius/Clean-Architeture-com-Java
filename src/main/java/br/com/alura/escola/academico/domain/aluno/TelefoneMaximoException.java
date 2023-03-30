package br.com.alura.escola.academico.domain.aluno;

public class TelefoneMaximoException extends RuntimeException {

    public TelefoneMaximoException() {
        super("Numero maximo de telefones ja atingido");
    }
}
