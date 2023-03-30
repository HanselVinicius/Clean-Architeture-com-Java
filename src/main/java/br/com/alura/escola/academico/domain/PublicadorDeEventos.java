package br.com.alura.escola.academico.domain;

import java.util.ArrayList;
import java.util.List;

public class PublicadorDeEventos  {

    private List<Ouvinte> ouvintes = new ArrayList<>();

    public void Adcionar(Ouvinte ouvinte){
        this.ouvintes.add(ouvinte);
    }


    public void publicar(Evento evento){
        this.ouvintes.forEach(o->{
            o.processa(evento);
        });
    }




}
