package br.com.alura.escola.gameficacao.dominio.selo;

import br.com.alura.escola.academico.domain.aluno.CPF;

import java.util.List;

public interface RepositorioDeSelos {

    void guardaSelo(Selo selo);

    List<Selo> buscaSeloPorCpf(CPF cpf);



}
