package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.shared.dominio.CPF;

public class AlunoNaoEncontrado extends RuntimeException {
    public AlunoNaoEncontrado(CPF cpf) {
        super("Aluno nao encontado com cpf " + cpf.getDigitos());
    }
}
