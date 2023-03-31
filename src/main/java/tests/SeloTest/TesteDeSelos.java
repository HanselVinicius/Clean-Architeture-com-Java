package tests.SeloTest;


import br.com.alura.escola.gameficacao.dominio.selo.Selo;
import br.com.alura.escola.gameficacao.infra.selo.RepositorioDeSelosEmMemoria;
import br.com.alura.escola.shared.dominio.CPF;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class TesteDeSelos {

    private final CPF cpf = new CPF("418.596.728-41");;
    private final Selo selo = new Selo(cpf,"Novato");

    @Test
    public void  seloDeveriaSerPersistido(){
        RepositorioDeSelosEmMemoria repositorio = new RepositorioDeSelosEmMemoria();
        repositorio.guardaSelo(selo);
        List<Selo> lista = repositorio.buscaSeloPorCpf(cpf);
        Selo retorno = lista.get(0);


        Assertions.assertEquals(retorno.getCpfDoAluno(), cpf);

    }


}
