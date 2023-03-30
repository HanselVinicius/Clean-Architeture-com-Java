package br.com.alura.escola.gameficacao.infra.selo;

import br.com.alura.escola.gameficacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.gameficacao.dominio.selo.Selo;
import br.com.alura.escola.academico.domain.aluno.CPF;

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
                .filter(selo -> selo.getCpfDoAluno().equals(cpf))
                .collect(Collectors.toList());
    }
}
