package tests.AlunoTest;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.academico.domain.aluno.Aluno;
import br.com.alura.escola.academico.domain.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.academico.domain.aluno.Email;
import br.com.alura.escola.academico.domain.aluno.TelefoneMaximoException;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;

public class AlunoTest {

    private  Aluno aluno;


    @Before
    public void instanciaAluno(){
       aluno  = new Aluno(new CPF("418.596.728-41"),
                "Vinicius",
                new Email("hanelvinicius@gmail.com"));
    }


    @Test
    public void deveriaCifrarSenha(){
        String senha = "1234";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i< bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff)+ 0x100,0x66));
            }
            String senhaCifrada = sb.toString();


            Assertions.assertNotEquals(senhaCifrada, senha);


        }catch (NoSuchAlgorithmException ex){
            throw new RuntimeException();
        }
    }

    @Test
    public void deveriaFalharAoInstanciarDoisMaisTelefones(){
        aluno.adcionaTelefone("016","992977903");
        aluno.adcionaTelefone("016","992977903");

        Assertions.assertThrowsExactly(TelefoneMaximoException.class,
                ()-> aluno.adcionaTelefone("016","992977903"));
    }

    @Test
    public void naodeveriaCriarEmailsComEnderecosInvalidos(){

        Assert.assertThrows(IllegalArgumentException.class,() -> new Email("emailinvalido"));
    }

    @Test
    public void alunoDeveriaSerPersistido(){
        // Mock -> Mockito
        RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adcionar(new LogDeAlunoMatriculado());
        MatricularAluno userCase = new MatricularAluno(repositorio,publicador);

        MatricularAlunoDto dados = new MatricularAlunoDto("Fulano",
                "418.596.728-41",
                "viniciushansel@email.com");

        userCase.execute(dados);


        Aluno alunoEncontrado = repositorio.buscaPorCpf(new CPF("418.596.728-41"));

        assertEquals("Fulano", alunoEncontrado.getNome());

    }





}
