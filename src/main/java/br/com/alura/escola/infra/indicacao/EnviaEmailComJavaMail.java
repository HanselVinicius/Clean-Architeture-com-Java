package br.com.alura.escola.infra.indicacao;

import br.com.alura.escola.aplicacao.indicacao.EnviaEmailIndicacao;
import br.com.alura.escola.domain.aluno.Aluno;

public class EnviaEmailComJavaMail implements EnviaEmailIndicacao {
    @Override
    public void enviarPara(Aluno indicado) {
        //logica de envio de emails com java mail

    }
}
