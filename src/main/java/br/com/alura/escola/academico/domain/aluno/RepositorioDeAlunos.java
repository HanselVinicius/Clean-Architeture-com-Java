package br.com.alura.escola.academico.domain.aluno;

public interface RepositorioDeAlunos {

    void matricular(Aluno aluno);

    Aluno buscaPorCpf(CPF cpf);





}
