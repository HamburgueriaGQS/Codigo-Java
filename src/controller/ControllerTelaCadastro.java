/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import hamburgueria.TelaCadastro;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author Matheus
 */
public class ControllerTelaCadastro {
    private TelaCadastro view;

    public ControllerTelaCadastro(TelaCadastro view) {
        this.view = view;
    }

    public void salvaUsuario(){
        
        String nome = view.getCampoNome().getText();
        String sobrenome = view.getCampoSobrenome().getText();
        String email = view.getCampoEmail().getText();
        String senha = view.getCampoCadastroSenha().getText();
        String telefone = view.getCampoTelefone().getText();
        String cpf = view.getCampoCPF().getText();
        String cep = view.getCampoCEP().getText();
        String rua = view.getCampoRua().getText();
        String bairro = view.getCampoBairro().getText();
        String numero = view.getCampoNumero().getText();
        String cidade = view.getCampoCidade().getText();
        String estado = view.getCampoEstado().getText();
        
        

        Usuario usuario = new Usuario(nome,sobrenome,email,senha,telefone,cpf,cep,rua,bairro,numero,cidade,estado);
        
        
        try {
            
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.insert(usuario);
            
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
            
        } catch (SQLException e) {
        }
    }
}
