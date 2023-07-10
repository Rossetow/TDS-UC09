package br.senac.principal;

import br.senac.banco.ConexaoMysql;
import br.senac.banco.ConexaoMysql;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("=========Inserindo no banco===========");

        ConexaoMysql conexao = new ConexaoMysql();

        Connection conn = null;
        try {
            conn = conexao.obterConexao();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (conn != null){
            System.out.println("Conectado");
        } else {
            System.out.println("Não conectado");
        }
    }
}
