package br.com.alura.escola.academico.domain.aluno;

public class Email {

    //classes que não possuem uma diferenciação  entre elas são VALUE OBJECTS
    private String endereco;


    public Email(String endereco) {

        if (endereco == null || !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$")){
            throw new IllegalArgumentException("E-mail invalido");
        }
        this.endereco = endereco;
    }


    public String getEndereco() {
        return endereco;
    }
}
