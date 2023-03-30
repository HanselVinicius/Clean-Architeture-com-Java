package br.com.alura.escola.domain.selo;

import br.com.alura.escola.domain.aluno.CPF;

import java.util.List;

public interface RepositorioDeSelos {

    void guardaSelo(Selo selo);

    List<Selo> buscaSeloPorCpf(CPF cpf);



}
