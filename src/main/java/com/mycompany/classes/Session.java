package com.mycompany.classes;


import com.mycompany.DAO.ConnectionFactory;
import com.mycompany.classes.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Session {
    // Atributo estático para armazenar o usuário logado
    private static Usuario loggedUser = null;
    private static Curso cursoSelecionado = null;
    private static Object codigoCurso = null;
    private static List<Integer> carrinhoCursos = new ArrayList<>();

    public static void adicionarAoCarrinho(int cursoId) {
        if (!carrinhoCursos.contains(cursoId)) {
            carrinhoCursos.add(cursoId);
        }
    }
    
    public static void removerDoCarrinho(int cursoId) {
        carrinhoCursos.remove((Integer) cursoId);
    }
    
    public static List<Integer> getCursosNoCarrinho() {
        return new ArrayList<>(carrinhoCursos);
    }
    
    public static int getItensNoCarrinho()
    {
        int itens = carrinhoCursos.size();
        return itens;
    }

    public static void limparCarrinho() {
        carrinhoCursos.clear();
    }
    
    // Método para setar o usuário logado
    public static void setLoggedUser(Usuario user) {
        loggedUser = user;
    }
    
    public static Curso listarCursoporId() throws SQLException
    {
        ConnectionFactory cf = new ConnectionFactory();
        
        String sql = "SELECT * FROM curso WHERE id = ?";
        
        try (Connection conn = cf.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setObject(1, codigoCurso);
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            Curso c = new Curso();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setAutorId(rs.getInt("autor_id"));
            c.setTempo(rs.getString("tempo")); 
                c.setNivel(rs.getString("nivel"));
                c.setPreco(rs.getString("preco"));
                c.setCategoria(rs.getString("categoria"));
                Curso cursoTemp = new Curso();
                c.setFotoCurso(cursoTemp.exibirImagemIcon(rs.getInt("id")));
                
                System.out.println("Curso listado: "+c.getNome());
                
                return c;
                } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para obter o usuário logado
    public static Usuario getLoggedUser() {
        return loggedUser;
    }

    // Método para verificar se existe um usuário logado
    public static boolean isUserLoggedIn() {
        return loggedUser != null;
    }

    // Método para deslogar o usuário (limpar as informações de sessão)
    public static void logout() {
        loggedUser = null;
    }

    // Método para verificar se o usuário está logado e obter o nome
    public static String getLoggedUserName() {
        return loggedUser != null ? loggedUser.getNome() : null;
    }

    public static void setCursoSelecionado(Curso curso)
    {
        cursoSelecionado = curso;
    }
    
    public static Curso getCursoSelecionado()
    {
        return cursoSelecionado;
    }
    
    public static boolean isCursoSelecionado()
    {
        return cursoSelecionado != null;
    }

    public static void outCursoSelecionado() {
        cursoSelecionado = null;
    }

    public static Object getCodigoCurso() {
        return codigoCurso;
    }

    public static void setCodigoCurso(Object aCodigoCurso) {
        codigoCurso = aCodigoCurso;
    }
}
