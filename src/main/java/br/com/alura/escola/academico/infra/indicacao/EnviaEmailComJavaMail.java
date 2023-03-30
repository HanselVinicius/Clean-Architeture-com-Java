package br.com.alura.escola.academico.infra.indicacao;

import br.com.alura.escola.academico.aplicacao.indicacao.EnviaEmailIndicacao;
import br.com.alura.escola.academico.domain.aluno.Aluno;

public class EnviaEmailComJavaMail implements EnviaEmailIndicacao {
    @Override
    public void enviarPara(Aluno indicado) {
        //logica de envio de emails com java mail

    }
}
