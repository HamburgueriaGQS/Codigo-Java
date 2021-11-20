/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import hamburgueria.Interface;
import hamburgueria.TelaCheckout;
import java.sql.Connection;
import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author Matheus
 */
public class ControllerCheckout {
    private TelaCheckout view;
    private Interface viewCheckout;

    public ControllerCheckout(TelaCheckout view) {
        this.view = view;
    }

    public ControllerCheckout(Interface viewCheckout) {
        this.viewCheckout = viewCheckout;
    }
    
    
    /*public void setEndereco(Usuario usuario) throws SQLException{
        
        String email = viewCheckout.getCampoEmail().getText();
        String senha = viewCheckout.getCampoSenha().getText();
        
        Usuario usuarioConsulta = new Usuario(email,senha);
        
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        
        String dadosCliente = usuarioDao.consulta(usuarioConsulta);
        
        String sql = "select from usuario where email = " + viewCheckout.getCampoEmail() +;
        
    }*/
    
    
}
