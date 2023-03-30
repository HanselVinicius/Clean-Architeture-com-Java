package br.com.alura.escola.infra.selo;

import br.com.alura.escola.domain.aluno.CPF;
import br.com.alura.escola.domain.selo.RepositorioDeSelos;
import br.com.alura.escola.domain.selo.Selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelos {

    private final List<Selo> selos = new ArrayList<>();

    @Override
    public void guardaSelo(Selo selo) {
        this.selos.add(selo);
    }

    @Override
    public List<Selo> buscaSeloPorCpf(CPF cpf) {
        return this.selos.stream()
                .filter(selo -> selo.getCpfDoAluno())
                .collect(Collectors.toList());
    }
}
