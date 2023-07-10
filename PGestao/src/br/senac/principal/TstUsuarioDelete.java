package br.senac.principal;

import br.senac.modulo.Usuario;

import java.sql.SQLException;

public class TstUsuarioDelete {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.setId(1);

        System.out.println("Deletando usuario");
        try {
            usuario.deletar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
