package br.senac.principal;

import br.senac.modulo.Usuario;

import java.sql.SQLException;

public class TstUsuarioUpdate {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.setLogin("rrosseto");
        usuario.setSenha("1234");
        usuario.setCargo("Aluno");
        usuario.setNivelAcesso(2);
        usuario.setId(3);

        System.out.println("Atualizando Usuario");
        try {
            usuario.atualizar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
