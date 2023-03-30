package br.com.alura.escola.academico.domain.aluno;

public class CPF {

    private String digitos;

    public CPF(String digitos) {
        if (!digitos.matches("([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})\n")){
            throw new IllegalArgumentException("cpf invalido");
        }
        this.digitos = digitos;
    }

    public String getDigitos() {
        return digitos;
    }


    @Override
    public String toString() {
        return "CPF{" +
                "digitos='" + digitos + '\'' +
                '}';
    }
}
