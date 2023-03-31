package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;
import br.com.alura.escola.academico.domain.aluno.Aluno;
import br.com.alura.escola.academico.domain.aluno.AlunoMatriculado;
import br.com.alura.escola.academico.domain.aluno.RepositorioDeAlunos;

public class MatricularAluno {

    private final RepositorioDeAlunos repositorio;
    private final PublicadorDeEventos publicadorDeEventos;
    public MatricularAluno(RepositorioDeAlunos repositorio,PublicadorDeEventos publicadorDeEventos) {
        this.repositorio = repositorio;
        this.publicadorDeEventos = publicadorDeEventos;
    }


    //PADRÃO COMMAND
    public void execute(MatricularAlunoDto dados){
        Aluno novo = dados.criarAluno();
        repositorio.matricular(novo);
        AlunoMatriculado evento = new AlunoMatriculado(novo.getCpf());
        publicadorDeEventos.publicar(evento);
    }

}
