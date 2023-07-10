package br.senac.principal;

import br.senac.banco.ConexaoMysql;
import br.senac.modulo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TstUsuarioInsert {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();

        usuario.setLogin("jose");
        usuario.setSenha("1234");
        usuario.setCargo("Aluno");
        usuario.setNivelAcesso(1);

        System.out.println("Inserindo usuário");
        try {
            usuario.salvar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
