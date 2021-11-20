/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author PC Casa
 */
public class UsuarioDAO {
    
    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    
    public void insert(Usuario usuario) throws SQLException{
        
        String sql = "insert into usuario(nome,sobrenome,email,senha,telefone,cpf,cep,rua,bairro,numero,cidade,estado) values('"+usuario.getNome()+"','"+usuario.getSobrenome()+"','"+usuario.getEmail()+"','"+usuario.getSenha()+"',"
                + "'"+usuario.getTelefone()+"','"+usuario.getCPF()+"','"+usuario.getCEP()+"','"+usuario.getRua()+"','"+usuario.getBairro()+"','"+usuario.getNumero()+"','"+usuario.getCidade()+"','"+usuario.getEstado()+"');";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        
    }
    
    public void update(Usuario usuario) throws SQLException{
        
        String sql = "update usuario set nome = ?,sobrenome = ?,email = ?,senha = ?,telefone = ?,cpf = ?,cep = ?,rua = ?,bairro = ?,numero = ?,cidade = ?,estado = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getSobrenome());
        statement.setString(3, usuario.getEmail());
        statement.setString(4, usuario.getSenha());
        statement.setString(5, usuario.getTelefone());
        statement.setString(6, usuario.getCPF());
        statement.setString(7, usuario.getCEP());
        statement.setString(8, usuario.getRua());
        statement.setString(9, usuario.getBairro());
        statement.setString(10, usuario.getNumero());
        statement.setString(11, usuario.getCidade());
        statement.setString(12, usuario.getEstado());
        statement.setInt(13, usuario.getId());
        statement.execute();
    }
    
    public boolean existeNoBancoPorEmailESenha(Usuario usuario) throws SQLException {
        String sql = "select * from usuario where email = ? and senha = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, usuario.getEmail());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        
        ResultSet resultado = statement.getResultSet();
        return resultado.next();
    }

    /*public String consulta(Usuario usuario) throws SQLException{
        String sql = "select from usuario where email = ? and senha = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, usuario.getEmail());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        
        ResultSet resultado = statement.getResultSet();
        return
    }*/
    
}
