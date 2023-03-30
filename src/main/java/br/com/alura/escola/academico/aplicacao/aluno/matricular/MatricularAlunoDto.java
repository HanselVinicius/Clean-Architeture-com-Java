package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.academico.domain.aluno.Aluno;
import br.com.alura.escola.academico.domain.aluno.CPF;
import br.com.alura.escola.academico.domain.aluno.Email;

public class MatricularAlunoDto {
    private String nomeAluno;
    private String cpfAluno;
    private String emailAluno;


    public MatricularAlunoDto(String nomeAluno, String cpfAluno, String emailAluno) {
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.emailAluno = emailAluno;
    }

    public Aluno criarAluno() {
        CPF cpf = new CPF(this.cpfAluno);
        Email email = new Email(this.emailAluno);

        return new Aluno(cpf,this.nomeAluno,email);
    }
}
