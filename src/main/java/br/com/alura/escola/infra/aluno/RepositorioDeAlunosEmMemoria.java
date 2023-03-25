package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.AlunoNaoEncontrado;
import br.com.alura.escola.domain.aluno.CPF;
import br.com.alura.escola.domain.aluno.RepositorioDeAlunos;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosEmMemoria implements RepositorioDeAlunos {


    private final List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno);

    }

    @Override
    public Aluno buscaPorCpf(CPF cpf) {
        return this.matriculados.stream()
                .filter(a -> a.getCpf().equals(cpf.getDigitos())).findFirst().orElseThrow(() -> new AlunoNaoEncontrado(cpf));
    }
}
