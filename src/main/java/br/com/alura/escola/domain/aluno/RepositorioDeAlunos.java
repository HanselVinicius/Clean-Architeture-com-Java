package br.com.alura.escola.domain.aluno;

import java.util.List;

public interface RepositorioDeAlunos {

    void matricular(Aluno aluno);

    Aluno buscaPorCpf(CPF cpf);





}
