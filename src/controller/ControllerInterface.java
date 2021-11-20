/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import hamburgueria.Interface;
import hamburgueria.TelaVendas;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author Matheus
 */
public class ControllerInterface {
    private Interface view;

    public ControllerInterface(Interface view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        //buscar um usuario da view
        String email = view.getCampoEmail().getText();
        String senha = view.getCampoSenha().getText();
        
        Usuario usuarioAutenticar = new Usuario(email,senha);
        
        //verificar se existe no banco de dados
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        
        boolean existe = usuarioDao.existeNoBancoPorEmailESenha(usuarioAutenticar);
        if(existe){
            TelaVendas menuCardapio = new TelaVendas();
            menuCardapio.setVisible(true);
            view.dispose();
        }
        else{
        JOptionPane.showMessageDialog(view, "Email ou senha inválidos");
        }
        //se existir, redirecionar para menu
        
    }
    
    
}
