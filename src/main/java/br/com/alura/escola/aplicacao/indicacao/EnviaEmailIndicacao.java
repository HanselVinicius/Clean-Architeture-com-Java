package br.com.alura.escola.aplicacao.indicacao;

import br.com.alura.escola.domain.aluno.Aluno;

public interface EnviaEmailIndicacao {

    void enviarPara(Aluno indicado);

}
