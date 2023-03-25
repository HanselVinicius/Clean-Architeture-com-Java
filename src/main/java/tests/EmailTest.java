package tests;

import br.com.alura.escola.domain.aluno.Email;
import org.junit.Assert;
import org.junit.Test;


public class EmailTest {

    @Test
   public void naodeveriaCriarEmailsComEnderecosInvalidos(){

        Assert.assertThrows(IllegalArgumentException.class,() -> new Email("emailinvalido"));
    }


}
