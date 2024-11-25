//@author pkmelo7
package com.mycompany.classes;

import com.mycompany.DAO.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Admin 
{
    Usuario usu = new Usuario(); 
    
    public void listarUsers(JTable table, JTextField field)
        {
            DefaultTableModel model = new DefaultTableModel
            (new String[]{"ID", "Nome", "Data de Nascimento", "Usuário", "Email", "Senha"}, 0)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // Impede a edição de qualquer célula
            }
        };

            String sql;

            if (field.getText().equals(""))
            {
                sql = "SELECT * FROM user";
            }
            else
            {
                sql = "SELECT * FROM user WHERE id LIKE ? OR nome LIKE ? OR dataNasc LIKE ? OR usuario LIKE ? OR email LIKE ? OR senha LIKE ?";
            }

            ConnectionFactory factory = new ConnectionFactory();

            try (Connection c = factory.obtemConexao())
            {
                PreparedStatement ps = c.prepareStatement(sql);

                if (!"".equals(field.getText())) 
                {
                    String searchText = "%" + field.getText() + "%";

                    ps.setString(1, searchText);
                    ps.setString(2, searchText);
                    ps.setString(3, searchText);
                    ps.setString(4, searchText);
                    ps.setString(5, searchText);
                    ps.setString(6, searchText);
                }

                ResultSet rs = ps.executeQuery();

                while (rs.next())
                {   
                    String txtcodigo = rs.getString("id");
                    String txtnome = rs.getString("nome");
                    String txtdtnasc = rs.getString("dataNasc");
                    String txtusuario = rs.getString("usuario");
                    String txtemail = rs.getString("email");
                    String txtsenha = rs.getString("senha");

                    model.addRow(new Object[]{txtcodigo, txtnome, txtdtnasc, txtusuario, txtemail, txtsenha});
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            table.setModel(model);
            
            table.getColumnModel().getColumn(0).setPreferredWidth(30);  
            table.getColumnModel().getColumn(1).setPreferredWidth(200); 
            table.getColumnModel().getColumn(2).setPreferredWidth(50); 
            table.getColumnModel().getColumn(3).setPreferredWidth(100); 
            table.getColumnModel().getColumn(4).setPreferredWidth(240);
            table.getColumnModel().getColumn(5).setPreferredWidth(100);
        }
     
    public void listarUsersEdit(JTable table, JTextField field)
        {
            DefaultTableModel model = new DefaultTableModel
            (new String[]{"ID", "Nome", "Data de Nascimento", "Usuário", "Email", "Senha"}, 0)
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;  // Impede a edição de qualquer célula
            }
        };

            String sql;

            if (field.getText().equals(""))
            {
                sql = "SELECT * FROM user";
            }
            else
            {
                sql = "SELECT * FROM user WHERE id LIKE ? OR nome LIKE ? OR dataNasc LIKE ? OR usuario LIKE ? OR email LIKE ? OR senha LIKE ?";
            }

            ConnectionFactory factory = new ConnectionFactory();

            try (Connection c = factory.obtemConexao())
            {
                PreparedStatement ps = c.prepareStatement(sql);

                if (!"".equals(field.getText())) 
                {
                    String searchText = "%" + field.getText() + "%";

                    ps.setString(1, searchText);
                    ps.setString(2, searchText);
                    ps.setString(3, searchText);
                    ps.setString(4, searchText);
                    ps.setString(5, searchText);
                    ps.setString(6, searchText);
                }

                ResultSet rs = ps.executeQuery();

                while (rs.next())
                {   
                    String txtcodigo = rs.getString("id");
                    String txtnome = rs.getString("nome");
                    String txtdtnasc = rs.getString("dataNasc");
                    String txtusuario = rs.getString("usuario");
                    String txtemail = rs.getString("email");
                    String txtsenha = rs.getString("senha");

                    model.addRow(new Object[]{txtcodigo, txtnome, txtdtnasc, txtusuario, txtemail, txtsenha});
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            table.setModel(model);
            
            table.getColumnModel().getColumn(0).setPreferredWidth(30);  
            table.getColumnModel().getColumn(1).setPreferredWidth(200); 
            table.getColumnModel().getColumn(2).setPreferredWidth(50); 
            table.getColumnModel().getColumn(3).setPreferredWidth(100); 
            table.getColumnModel().getColumn(4).setPreferredWidth(240);
            table.getColumnModel().getColumn(5).setPreferredWidth(100);
        }
    
    public boolean salvarAlteracoesUser(JTable table) {
    int rowCount = table.getRowCount();
    boolean allUpdatesSuccessful = true; // Variável para controlar o sucesso de todas as atualizações

    String sql = "UPDATE user SET nome = ?, dataNasc = ?, usuario = ?, email = ?, senha = ? WHERE id = ?";

    // Usando a ConnectionFactory para obter a conexão
    try (Connection conn = new ConnectionFactory().obtemConexao()) {
        // Começando a transação
        conn.setAutoCommit(false);

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < rowCount; i++) {
                // Obtendo os valores da tabela para cada linha
                String id = (String) table.getValueAt(i, 0); // ID da linha
                String nome = (String) table.getValueAt(i, 1); // Nome
                String dataNasc = (String) table.getValueAt(i, 2); // Data de Nascimento
                String user = (String) table.getValueAt(i, 3); // Usuário
                String email = (String) table.getValueAt(i, 4); // Email
                String senha = (String) table.getValueAt(i, 5); // Senha

                // Verifica se o usuário ou o email estão sendo alterados e já existem no banco
                boolean userChanged = !user.equals(getUserFromDatabase(id));  // Compara com o usuário atual no banco
                boolean emailChanged = !email.equals(getEmailFromDatabase(id));  // Compara com o email atual no banco

                // Se o usuário foi alterado e já existe no banco, exibe mensagem de erro
                if (userChanged && usu.verificaUserExiste(user)) {
                    System.out.println("Não foi possível alterar. Usuário já cadastrado.");
                    allUpdatesSuccessful = false;
                    break; // Interrompe o loop, pois já encontramos um erro
                }

                // Se o email foi alterado e já existe no banco, exibe mensagem de erro
                if (emailChanged && usu.verificaEmailExiste(email)) {
                    System.out.println("Não foi possível alterar. Email já cadastrado.");
                    allUpdatesSuccessful = false;
                    break; // Interrompe o loop, pois já encontramos um erro
                }

                // Configurando os parâmetros do PreparedStatement
                ps.setString(1, nome);
                ps.setString(2, dataNasc);
                ps.setString(3, user);
                ps.setString(4, email);
                ps.setString(5, senha);
                ps.setString(6, id);

                // Executando a atualização
                int affectedRows = ps.executeUpdate();

                // Se alguma linha não foi atualizada, define que a operação falhou
                if (affectedRows == 0) {
                    allUpdatesSuccessful = false;
                }
            }

            // Se todas as atualizações foram bem-sucedidas, commit na transação
            if (allUpdatesSuccessful) {
                conn.commit();
                System.out.println("Alterações salvas com sucesso!");
                return true;
            } else {
                // Se alguma atualização falhou, faz rollback
                conn.rollback();
                System.out.println("Erro: Algumas alterações não foram salvas.");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback(); // Caso ocorra erro, faz rollback
            return false;
        } finally {
            // Certificando-se de que o autocommit está habilitado novamente
            conn.setAutoCommit(true);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erro ao conectar ao banco de dados.");
        return false;
    }
}
    
    private String getUserFromDatabase(String id) throws SQLException {
    String sql = "SELECT usuario FROM user WHERE id = ?";
    try (Connection conn = new ConnectionFactory().obtemConexao();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getString("usuario");
        }
        return null; // Caso não encontre
    }
}

private String getEmailFromDatabase(String id) throws SQLException {
    String sql = "SELECT email FROM user WHERE id = ?";
    try (Connection conn = new ConnectionFactory().obtemConexao();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getString("email");
        }
        return null; // Caso não encontre
    }
}
    
     
    public boolean removeUser(JTable table, Object coluna)
        {
            String sql = "DELETE FROM user WHERE id = ?";

            ConnectionFactory cf = new ConnectionFactory();

            try 
            (
                Connection conn = cf.obtemConexao();
                PreparedStatement ps = conn.prepareStatement(sql);
            ) 
                {
                    ps.setObject(1, coluna); 
                    System.out.println(sql);

                    int affectedRows = ps.executeUpdate(); 
                    return affectedRows > 0;
                }   
            catch (SQLException e) 
            {
                e.printStackTrace();
                System.out.println("ERRO. Não foi possível remover.");
                return false;
            }
        }
    
//--------------------------------------------------------------------------------------------------------------
    
    //Lista para contabilizar quantos botoes de X existem
        private final ArrayList<JButton> botoesX = new ArrayList<>();
        
    //Lista para contabilizar quantos botoes de Editar existem
        private final ArrayList<JButton> botoesEditar = new ArrayList<>();
    
        
}
