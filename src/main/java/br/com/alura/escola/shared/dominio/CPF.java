package br.com.alura.escola.shared.dominio;

public class CPF {

    private String digitos;

    public CPF(String digitos) {
        String regex = "([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}-[0-9]{2})";
        if (!digitos.matches(regex)) {
            throw new IllegalArgumentException("CPF inválido: " + digitos);
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
