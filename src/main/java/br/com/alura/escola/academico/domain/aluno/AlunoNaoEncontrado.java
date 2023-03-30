package br.com.alura.escola.academico.domain.aluno;

public class AlunoNaoEncontrado extends RuntimeException {
    public AlunoNaoEncontrado(CPF cpf) {
        super("Aluno nao encontado com cpf " + cpf.getDigitos());
    }
}
