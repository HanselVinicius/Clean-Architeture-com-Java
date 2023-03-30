package br.com.alura.escola.academico.domain.aluno;

public class Telefone {
    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {

        if (ddd == null || numero == null)
            throw new IllegalArgumentException();

        if (ddd.matches("\\\\d{2}") || numero.matches("\\\\d{8}|\\\\d{9}")){
            throw new IllegalArgumentException("numero de telefone invalido");
        }
        this.ddd = ddd;
        this.numero = numero;
    }


    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }
}
