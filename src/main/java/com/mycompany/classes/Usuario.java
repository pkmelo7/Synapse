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
    private String dtnasc;
    private String user;
    private String email;
    private String senha;
    private boolean isAdmin;
    private static boolean isLoggedIn = false;
    
    public Usuario() {
    }

    public Usuario(String user, String senha) {
        this.user = user;
        this.senha = senha;
    }

    public Usuario(String nome, String user, String email, String senha) {
        this.nome = nome;
        this.user = user;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(int codigo, String nome, String user, String email, String senha) {
        this.codigo = codigo;
        this.nome = nome;
        this.user = user;
        this.email = email;
        this.senha = senha;
    }
//----------------------------------------------------------------------------------------------------------------------------------
 
//Declaração de metodos

    public boolean login() throws SQLException {
    int result = validaUser();
    if (result == 1) {
        // Usuário autenticado com sucesso
        if (loadAdminStatus()==0) {
            // Se o usuário for admin, configurar como admin
            Session.setLoggedUser(this);
            return true;  // ou direcionar para a tela de admin
        } else {
            Session.setLoggedUser(this);
            return true;  // Usuário regular, direcionar para a tela normal
        }
    } else {
        // Falha na autenticação
        return false;
    }
}

    public static boolean logout() {
        Session.logout();
        return true;
    }
    
    //Metodo para cadastrar usuario no banco de dados
        public boolean cadastraUser() throws SQLException 
        {
            String sql = "INSERT INTO user (nome, dataNasc, usuario, email, senha) values (?, ?, ?, ?, ?)";

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
        
        public boolean cadastraAdmin() throws SQLException 
        {
            String sql = "INSERT INTO user (nome, dataNasc, usuario, email, senha, is_admin) values (?, ?, ?, ?, ?, true)";

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
            String sql = "SELECT * FROM user WHERE usuario = ?";

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
                            setNome(rs.getString("nome"));
                            setDtnasc(rs.getString("dataNasc"));
                            setEmail(rs.getString("email"));
                            setAdmin(rs.getInt("is_admin") == 1);
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
        
        public boolean validaAcessoCurso(int idUsuario, int idCurso) throws SQLException
        {
            String sql = "SELECT * FROM acesso WHERE usuario_id = ? AND curso_id = ?";

            ConnectionFactory cf = new ConnectionFactory();

            try 
            (
                Connection conn = cf.obtemConexao();
                PreparedStatement ps = conn.prepareStatement(sql);
            )
            {
                ps.setInt(1, idUsuario);
                ps.setInt(2, idCurso);
                ResultSet rs = ps.executeQuery();
                System.out.println("Acesso encontrado");
                return rs.next();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
                System.out.println("Acesso não encontrado.");
                return false;
            }
        }
    //metodo para verificar se o usuario ja existe no banco de dados
        //busca por user
    //metodo para verificar se o usuario ja existe no banco de dados
        //busca por user
        public boolean verificaUserExiste() throws SQLException 
        {
            String sql = "SELECT * FROM user WHERE usuario = ?";
            ConnectionFactory cf = new ConnectionFactory();

            try (Connection conn = cf.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) 
            {
                ps.setString(1, getUser());
                ResultSet rs = ps.executeQuery();
                return rs.next();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
                throw e;
            }
        }
        
        public boolean verificaUserExiste(String user) throws SQLException 
        {
            String sql = "SELECT * FROM user WHERE usuario = ?";
            ConnectionFactory cf = new ConnectionFactory();

            try (Connection conn = cf.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) 
            {
                ps.setString(1, user);
                ResultSet rs = ps.executeQuery();
                return rs.next();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
                throw e;
            }
        }
        
        public boolean verificaEmailExiste() throws SQLException 
        {
            String sql = "SELECT * FROM user WHERE email = ?";
            ConnectionFactory cf = new ConnectionFactory();

            try (Connection conn = cf.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) 
            {
                ps.setString(1, getEmail());
                ResultSet rs = ps.executeQuery();
                return rs.next();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
                throw e;
            }
        }
        
        public boolean verificaEmailExiste(String email) throws SQLException 
        {
            String sql = "SELECT * FROM user WHERE email = ?";
            ConnectionFactory cf = new ConnectionFactory();

            try (Connection conn = cf.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) 
            {
                ps.setString(1, email);
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
            String sql = "SELECT nome FROM user WHERE usuario = ?";
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
        
        public String getNomePorId(int id) throws SQLException 
        {
            String sql = "SELECT nome FROM user WHERE id = ?";
            ConnectionFactory cf = new ConnectionFactory();

            try (Connection conn = cf.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) 
            {
                ps.setInt(1, id);
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
        
        public static int getIdPorUsuario(String usu) throws SQLException 
        {
            String sql = "SELECT id FROM user WHERE usuario = ?";
            ConnectionFactory cf = new ConnectionFactory();

            try (Connection conn = cf.obtemConexao();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, usu); // Substitua por seu método que retorna o nome do usuário
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    return rs.getInt("id"); // Retorna o ID encontrado
                } else {
                    throw new SQLException("Usuário não encontrado"); // Lança exceção se o usuário não for encontrado
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw e; // Propaga a exceção para o método chamador
            }
        }
        
        public String getUserPorId(int id) throws SQLException 
        {
            String sql = "SELECT usuario FROM user WHERE id = ?";
            ConnectionFactory cf = new ConnectionFactory();

            try (Connection conn = cf.obtemConexao();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, id); // Substitua por seu método que retorna o nome do usuário
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    return rs.getString("usuario"); // Retorna o ID encontrado
                } else {
                    throw new SQLException("Usuário não encontrado"); // Lança exceção se o usuário não for encontrado
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw e; // Propaga a exceção para o método chamador
            }
        }
        
        public String getPrimeiroNomePorUsuario(java.lang.String usu) throws SQLException 
        {
            String sql = "SELECT SUBSTRING_INDEX(nome, ' ', 1) AS primeiro_nome FROM user WHERE usuario = ?";
            ConnectionFactory cf = new ConnectionFactory();

            try (Connection conn = cf.obtemConexao();
                 PreparedStatement ps = conn.prepareStatement(sql)) 
            {
                ps.setString(1, usu);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) 
                {
                    return rs.getString("primeiro_nome"); // Retorna o primeiro nome se encontrado
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

        
        public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    public int loadAdminStatus() throws SQLException {
    String sql = "SELECT is_admin FROM user WHERE usuario = ?";
    ConnectionFactory cf = new ConnectionFactory();

    try (Connection conn = cf.obtemConexao();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, getUser());
        ResultSet rs = ps.executeQuery();

        if (rs.next()) { // Verifica se há resultado
            return rs.getInt("is_admin"); // Retorna o valor da coluna is_admin
        } else {
            return 2; // Caso o usuário não seja encontrado, retorna 0 por padrão
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw e; // Propaga a exceção para tratamento externo
    }
}
    
    public static void cadastraAcesso(int usuario_id, int curso_id)
    {
        String sql = "INSERT INTO acesso (usuario_id, curso_id) VALUES (?, ?)";

        ConnectionFactory cf = new ConnectionFactory();

        try 
        (
            Connection conn = cf.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) 
            {
                ps.setInt(1, usuario_id);
                ps.setInt(2, curso_id); 

                int affectedRows = ps.executeUpdate(); 
            }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            System.out.println("ERRO. Não foi possível cadastrar.");
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
    
    public String getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(String dtnasc) {
        this.dtnasc = dtnasc;
    }
}
