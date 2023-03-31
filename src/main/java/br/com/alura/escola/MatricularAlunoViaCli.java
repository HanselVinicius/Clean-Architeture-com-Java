package br.com.alura.escola;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.alura.escola.gameficacao.aplicacao.GeraSeloAlunoNovato;
import br.com.alura.escola.gameficacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.gameficacao.infra.selo.RepositorioDeSelosEmMemoria;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;
import br.com.alura.escola.academico.domain.aluno.LogDeAlunoMatriculado;

public class MatricularAlunoViaCli {

    public static void main(String[] args) {
        String nome = "Fulano";
        String cpf = "123.456.789-00";
        String email = "fulano@email.com";



        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adcionar(new LogDeAlunoMatriculado());
        publicador.adcionar(new GeraSeloAlunoNovato(new RepositorioDeSelosEmMemoria()));

        MatricularAluno matricularAluno = new MatricularAluno(new RepositorioDeAlunosEmMemoria(),publicador);

        matricularAluno.execute(new MatricularAlunoDto(nome,cpf,email));
    }


}
