package br.senac.modulo;

import br.senac.banco.ConexaoMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usuario {
    private int id;
    private String login;
    private String senha;
    private String cargo;
    private int nivel_acesso;

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setNivelAcesso(int nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getCargo() {
        return cargo;
    }

    public int getNivel_acesso() {
        return nivel_acesso;
    }


    public void salvar() throws SQLException, ClassNotFoundException {
        ConexaoMysql conexaoMysql = new ConexaoMysql();
        Connection con = null;

        con = conexaoMysql.obterConexao();

        PreparedStatement stmt = null;

        stmt = con.prepareStatement("INSERT INTO usuario(login, senha, cargo, nivel_acesso) VALUES (?,?,?,?)");

        stmt.setString(1, this.login);

        stmt.setString(2, this.senha);

        stmt.setString(3, this.cargo);

        stmt.setInt(4, this.nivel_acesso);

        stmt.executeUpdate();

    }

    public void atualizar() throws SQLException, ClassNotFoundException {
        ConexaoMysql conexaoMysql = new ConexaoMysql();
        Connection con = conexaoMysql.obterConexao();
        PreparedStatement stmt = null;

        stmt = con.prepareStatement("UPDATE usuario set login = ?,  senha = ?, cargo = ?, nivel_acesso = ? WHERE id = ?");
        stmt.setString(1, this.login);
        stmt.setString(2, this.senha);
        stmt.setString(3, this.cargo);
        stmt.setInt(4, this.nivel_acesso);
        stmt.setInt(5, this.id);

        stmt.executeUpdate();
    }

    public void deletar() throws SQLException, ClassNotFoundException {
        ConexaoMysql conexaoMysql = new ConexaoMysql();
        Connection con = conexaoMysql.obterConexao();
        PreparedStatement stmt = null;

        stmt = con.prepareStatement("DELETE FROM usuario WHERE id = ?");
        stmt.setInt(1, this.id);

        stmt.executeUpdate();
    }

    public void obterTodosUsuarios () throws SQLException, ClassNotFoundException {
        ConexaoMysql conexaoMysql = new ConexaoMysql();
        Connection con = conexaoMysql.obterConexao();
        PreparedStatement stmt = null;

        stmt = con.prepareStatement("SELECT id, login, senha, cargo, nivel_acesso FROM usuario;");
        ResultSet rs = stmt.executeQuery();

        ArrayList<Usuario> usuarioList = new ArrayList<>();

        while(rs.next()){
            System.out.println("--------------------------------------------------");
            System.out.println("ID: " + rs.getInt(1));
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Login: " + rs.getString("login"));
            System.out.println("Senha: " + rs.getString("senha"));
            System.out.println("Cargao: " + rs.getString("cargo"));
            System.out.println("Nivel de acesso: " + rs.getString("nivel_acesso"));
            System.out.println("-------------------------------------------------");
        }
    }
}
