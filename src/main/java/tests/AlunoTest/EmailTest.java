package tests.AlunoTest;

import br.com.alura.escola.academico.domain.aluno.Email;
import org.junit.Assert;
import org.junit.Test;


public class EmailTest {

    @Test
   public void naodeveriaCriarEmailsComEnderecosInvalidos(){

        Assert.assertThrows(IllegalArgumentException.class,() -> new Email("emailinvalido"));
    }


}
