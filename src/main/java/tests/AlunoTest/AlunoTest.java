package tests.AlunoTest;

import br.com.alura.escola.academico.domain.aluno.Aluno;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.academico.domain.aluno.Email;
import br.com.alura.escola.academico.domain.aluno.TelefoneMaximoException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AlunoTest {
    private final Aluno aluno = new Aluno(new CPF("418.596.728-41"),
            "Vinicius",
            new Email("hanelvinicius@gmail.com"));




    @Test
    public void deveriaFalharAoInstanciarDoisMaisTelefones(){
        this.aluno.adcionaTelefone("016","992977903");
        this.aluno.adcionaTelefone("016","992977903");

        Assertions.assertThrowsExactly(TelefoneMaximoException.class,
                ()-> aluno.adcionaTelefone("016","992977903"));
    }


}
