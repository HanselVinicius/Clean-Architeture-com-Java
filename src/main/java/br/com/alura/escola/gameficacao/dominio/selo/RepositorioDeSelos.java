package br.com.alura.escola.gameficacao.dominio.selo;

import br.com.alura.escola.shared.dominio.CPF;

import java.util.List;

public interface RepositorioDeSelos {

    void guardaSelo(Selo selo);

    List<Selo> buscaSeloPorCpf(CPF cpf);



}
