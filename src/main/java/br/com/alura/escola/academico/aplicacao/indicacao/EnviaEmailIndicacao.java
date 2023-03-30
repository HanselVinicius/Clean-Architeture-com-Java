package br.com.alura.escola.academico.aplicacao.indicacao;

import br.com.alura.escola.academico.domain.aluno.Aluno;

public interface EnviaEmailIndicacao {

    void enviarPara(Aluno indicado);

}
