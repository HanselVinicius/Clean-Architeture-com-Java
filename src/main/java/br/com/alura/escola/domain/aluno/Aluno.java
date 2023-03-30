package br.com.alura.escola.domain.aluno;

import java.util.ArrayList;
import java.util.List;

//AGGREGATE ROOT
public class Aluno {


    //classes que possuem um indentificador que diferencie as instancias são entidades
    private CPF cpf;
    private String nome;

    private Email email;
    private List<Telefone> telefones = new ArrayList<>();

    private String senha;

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adcionaTelefone(String ddd , String numero){
        if (telefones.size() == 2){
            throw new TelefoneMaximoException();
        }
        this.telefones.add(new Telefone(ddd,numero));
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEndereco();
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
}
