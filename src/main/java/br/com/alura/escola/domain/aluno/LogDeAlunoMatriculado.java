package br.com.alura.escola.domain.aluno;

import br.com.alura.escola.domain.Evento;
import br.com.alura.escola.domain.Ouvinte;

import java.time.format.DateTimeFormatter;

public class LogDeAlunoMatriculado extends Ouvinte {

    @Override
    public void reageAo(Evento evento){

        String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy/ HH:mm"));
        System.out.println(String.format("Aluno com CPF %s matriculado em: %s",
                ((AlunoMatriculado) evento).getCpfDoAluno(),momentoFormatado));


    }



    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}
