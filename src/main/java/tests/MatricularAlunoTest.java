package tests;

import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.domain.PublicadorDeEventos;
import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.CPF;
import br.com.alura.escola.domain.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatricularAlunoTest {



    @Test
    public void alunoDeveriaSerPersistido(){
        // Mock -> Mockito
        RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.Adcionar(new LogDeAlunoMatriculado());
        MatricularAluno userCase = new MatricularAluno(repositorio,publicador);

        MatricularAlunoDto dados = new MatricularAlunoDto("Fulano",
                "418.596.728-41",
                "viniciushansel@email.com");

        userCase.execute(dados);


        Aluno alunoEncontrado = repositorio.buscaPorCpf(new CPF("418.596.728-41"));

        assertEquals("Fulano", alunoEncontrado.getNome());

    }

}
