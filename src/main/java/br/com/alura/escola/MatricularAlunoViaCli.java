package br.com.alura.escola;

import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.domain.PublicadorDeEventos;
import br.com.alura.escola.domain.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoViaCli {

    public static void main(String[] args) {
        String nome = "Fulano";
        String cpf = "123.456.789-00";
        String email = "fulano@email.com";


        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.Adcionar(new LogDeAlunoMatriculado());

        MatricularAluno matricularAluno = new MatricularAluno(new RepositorioDeAlunosEmMemoria(),publicador);

        matricularAluno.execute(new MatricularAlunoDto(nome,cpf,email));
    }


}
