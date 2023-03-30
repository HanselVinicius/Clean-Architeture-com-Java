package tests;

import br.com.alura.escola.academico.domain.aluno.Aluno;
import br.com.alura.escola.academico.domain.aluno.CPF;
import br.com.alura.escola.academico.domain.aluno.Email;
import org.junit.Before;
import org.junit.Test;

public class AlunoTest {
    private Aluno aluno;

    @Test
    @Before
    void deveriaInstanciarAluno(){
        aluno = new Aluno(new CPF("41.596.728.41"),
                "Vinicius",
                new Email("hanelvinicius@gmail.com"));
    }


}
