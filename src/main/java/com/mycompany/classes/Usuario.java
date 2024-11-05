//@author pkmelo7
package com.mycompany.classes;

import com.mycompany.DAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
    
    private int codigo;
    private String nome;
    private String user;
    private String email;
    private String senha;
    private String dtnasc;
    private boolean tpUser;

    public Usuario() {
    }

    public Usuario(String user, String senha) {
        this.user = user;
        this.senha = senha;
    }

    public Usuario(String nome, String user, String email, String senha, boolean tpUser) {
        this.nome = nome;
        this.user = user;
        this.email = email;
        this.senha = senha;
        this.tpUser = tpUser;
    }

    public Usuario(int codigo, String nome, String user, String email, String senha, boolean tpUser) {
        this.codigo = codigo;
        this.nome = nome;
        this.user = user;
        this.email = email;
        this.senha = senha;
        this.tpUser = tpUser;
    }
//----------------------------------------------------------------------------------------------------------------------------------
 
//Declaração de metodos
    
    //Metodo para cadastrar usuario no banco de dados
        public boolean cadastraUser() throws SQLException 
        {
        String sql = "INSERT INTO tb_usuario (nome, dtnasc, usuario, email, senha) values (?, ?, ?, ?, ?)";

        ConnectionFactory cf = new ConnectionFactory();

        try 
        (
            Connection conn = cf.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) 
            {
                ps.setString(1, getNome());
                ps.setString(2, getDtnasc());
                ps.setString(3, getUser());
                ps.setString(4, getEmail());
                ps.setString(5, getSenha()); 
            
                int affectedRows = ps.executeUpdate(); 
                return affectedRows > 0;
            }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.out.println("ERRO. Não foi possível cadastrar.");
            return false;
        }
    }
  
    //Metodo para validar o usuario e verificar se a senha esta correta    
        public int validaUser() throws SQLException 
        {
        String sql = "SELECT * FROM tb_usuario WHERE usuario = ?";
    
        ConnectionFactory cf = new ConnectionFactory();
    
        try 
        (
            Connection conn = cf.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) 
            {
                ps.setString(1, getUser());
                ResultSet rs = ps.executeQuery();
        
                if (rs.next()) 
                {
                    // Se o usuário existe, verifica a senha
                    String senhaRegistrada = rs.getString("senha");
            
                    if (senhaRegistrada.equals(getSenha())) 
                    {
                        return 1; // Senha correta
                    } 
                    else 
                    {
                        return 2; // Senha incorreta
                    }
                }   
                else 
                {
                    return 0; // Usuário não encontrado
                }
            } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.out.println("Erro ao localizar usuário.");
            throw e;
        }
    }

    //metodo para verificar se o usuario ja existe no banco de dados
        //busca por user ou email
        public boolean verificaUserExiste() throws SQLException 
        {
        String sql = "SELECT * FROM tb_usuario WHERE usuario = ? OR email = ?";
        ConnectionFactory cf = new ConnectionFactory();

        try (Connection conn = cf.obtemConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) 
        {
            ps.setString(1, getUser());
            ps.setString(2, getEmail());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            throw e;
        }
    }
    
    //Metodo para pegar o nome de um certo usuario
        public String getNomePorUsuario() throws SQLException 
        {
        String sql = "SELECT nome FROM tb_usuario WHERE usuario = ?";
        ConnectionFactory cf = new ConnectionFactory();

        try (Connection conn = cf.obtemConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) 
        {
            ps.setString(1, getUser());
            ResultSet rs = ps.executeQuery();
    
            if (rs.next()) 
            {
                return rs.getString("nome"); // Retorna o nome se encontrado
            } 
            else
            {
                return null; // Retorna null se o usuário não for encontrado
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw e;
        }
    }
    
//Fim da declaração de metodos
        
//----------------------------------------------------------------------------------------------------------------------------------
 
//Metodos getters and setters
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isTpUser() {
        return tpUser;
    }

    public void setTpUser(boolean tpUser) {
        this.tpUser = tpUser;
    }
    
    public String getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(String dtnasc) {
        this.dtnasc = dtnasc;
    }
}
