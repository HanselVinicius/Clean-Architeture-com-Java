package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.domain.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioDeAlunosComJDBC  implements RepositorioDeAlunos {


    private final Connection connection;

    public RepositorioDeAlunosComJDBC(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void matricular(Aluno aluno) {
        try {
            String sql = "INSERT INTO ALUNOS VALUES(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,aluno.getCpf());
            ps.setString(2,aluno.getNome());
            ps.setString(3,aluno.getEmail());
            ps.execute();

            sql = "INSERT INTO ALUNOS VALUES(?,?)";
            ps = connection.prepareStatement(sql);
            for (Telefone telefone: aluno.getTelefones()) {
                ps.setString(1,telefone.getDdd());
                ps.setString(2,telefone.getNumero());
                ps.execute();

            }
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Aluno buscaPorCpf(CPF cpf) {
        try {
            String sql = "SELECT * FROM ALUNOS WHERE cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,cpf.getDigitos());
            ResultSet rs = ps.executeQuery();
            Boolean encontrou = rs.next();
            if (!encontrou){
                throw new AlunoNaoEncontrado(cpf);
            }
            String nome = rs.getString("nome");
            Email email = new Email(rs.getString("email"));
            Aluno encontrado = new Aluno(cpf,nome,email);

            Long id = rs.getLong("id");
            sql = "SELECT ddd,numero FROM TELEFONE WHERE aluno_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                String numero = rs.getString("numero");
                String ddd = rs.getString("ddd");
                encontrado.adcionaTelefone(ddd,numero);
            }

            return encontrado;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}
