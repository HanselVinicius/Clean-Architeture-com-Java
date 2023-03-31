package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.shared.dominio.CPF;

public interface RepositorioDeAlunos {

    void matricular(Aluno aluno);

    Aluno buscaPorCpf(CPF cpf);





}
