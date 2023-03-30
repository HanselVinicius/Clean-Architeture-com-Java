package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.academico.domain.Evento;

import java.time.LocalDateTime;

public class AlunoMatriculado implements Evento {


    private final CPF cpfDoAluno;
    private final LocalDateTime momento;


    public AlunoMatriculado(CPF cpfDoAluno) {
        this.cpfDoAluno = cpfDoAluno;
        this.momento = LocalDateTime.now();
    }



    public CPF getCpfDoAluno() {
        return cpfDoAluno;
    }

    @Override
    public LocalDateTime momento() {
        return this.momento;
    }
}
