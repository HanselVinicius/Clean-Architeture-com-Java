package br.com.alura.escola.domain.aluno;

public class FabricaDeAluno {

    private Aluno aluno;

    public FabricaDeAluno comNomeCPFEmail(String nome,String cpf, String email){
        this.aluno = new Aluno(new CPF(cpf), nome,new Email(email));
        return this;
    }

    public FabricaDeAluno comTelefone(String ddd,String numero){
        this.aluno.adcionaTelefone(ddd,numero);
        return this;
    }

    public  Aluno criar(){
        return  this.aluno;
    }





}