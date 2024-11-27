//@author pkmelo7

package com.mycompany.classes;

import com.mycompany.DAO.ConnectionFactory;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Curso 
{
    private int id;
    private String nome;
    private int autorId;
    private BigDecimal tempo;
    private String nivel;
    private BigDecimal preco;
    private String categoria;
    private String descricao;
    private ImageIcon fotoCurso; 
    
    public int cadastraCurso() throws SQLException
    {
        String sql = "INSERT INTO curso (nome, autor_id, tempo, nivel, preco, categoria, descricao) VALUES (?,?,?,?,?,?,?)";
                
        ConnectionFactory cf = new ConnectionFactory();
        
        try
        (
            Connection conn = cf.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        )
        {
            ps.setString(1, getNome());        // nome do curso
            ps.setInt(2, getAutorId());        // id do autor (relacionamento com a tabela User)
            ps.setBigDecimal(3, getTempo());   // tempo do curso (DECIMAL)
            ps.setString(4, getNivel());       // nível do curso (ex: "Básico", "Avançado")
            ps.setBigDecimal(5, getPreco());   // preço do curso (DECIMAL)
            ps.setString(6, getCategoria());   // categoria do curso (ex: "Tecnologia", "Negócios")
            ps.setString(7, getDescricao());   // descrição do curso

            int affectedRows = ps.executeUpdate(); 
            if (affectedRows > 0) 
            {
                // Recuperar o ID gerado automaticamente
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) 
                {
                    if (generatedKeys.next()) 
                    {
                        return generatedKeys.getInt(1); // Retorna o ID do curso
                    }
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    public List<Curso> buscarCursosPorCategoria(java.lang.String categoria) 
    {
        List<Curso> cursos = new ArrayList<>();

        ConnectionFactory cf = new ConnectionFactory();
        
        String sql = "SELECT * FROM curso WHERE categoria = ?";
        
        try (Connection conn = cf.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, categoria);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Curso curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setAutorId(rs.getInt("autor_id"));
            curso.setTempo(rs.getBigDecimal("tempo")); 
                curso.setNivel(rs.getString("nivel"));
                curso.setPreco(rs.getBigDecimal("preco"));
                curso.setCategoria(rs.getString("categoria"));
                Curso cursoTemp = new Curso();
                curso.setFotoCurso(cursoTemp.exibirImagemIcon(rs.getInt("id")));
                cursos.add(curso);
            }
            
            System.out.println("Cursos recuperados: " + cursos.size());
            for (Curso curso : cursos) 
            {
                System.out.println("Curso: " + curso.getNome() + ", ID: " + curso.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cursos;
    }
    
    public void inserirImagem(String caminhoImagem, int curso_id) 
    {
        String sql = "INSERT INTO imagens (curso_id, imagem) VALUES (?, ?)";

        ConnectionFactory cf = new ConnectionFactory();

        try 
        (
            Connection conn = cf.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            InputStream inputStream = new FileInputStream(new File(caminhoImagem))
        ) 
        {
            // Configurar os parâmetros
            ps.setInt(1, curso_id);
            ps.setBlob(2, inputStream);

            int linhasAfetadas = ps.executeUpdate();
            System.out.println("Imagem armazenada com sucesso! Linhas afetadas: " + linhasAfetadas);
        } 
        catch (FileNotFoundException e) 
        {
            System.err.println("Arquivo de imagem não encontrado: " + caminhoImagem);
            e.printStackTrace();
        }
        catch (SQLException e) 
        {
            System.err.println("Erro ao armazenar a imagem no banco de dados.");
            e.printStackTrace();
        } 
        catch (Exception e) 
        {
            System.err.println("Erro inesperado ao armazenar a imagem.");
            e.printStackTrace();
        }
    }
    
    public ImageIcon exibirImagemIcon(int idCurso) 
    {   
        String sql = "SELECT imagem FROM imagens WHERE curso_id = ?";

        ConnectionFactory cf = new ConnectionFactory();
        
        try 
            (
                Connection conn = cf.obtemConexao();
                PreparedStatement ps = conn.prepareStatement(sql);
            ) 
        {

            ps.setInt(1, idCurso);

            try (ResultSet resultado = ps.executeQuery()) {
                if (resultado.next()) {
                    byte[] dadosImagem = resultado.getBytes("imagem");

                    if (dadosImagem != null) {
                        // Converter os dados binários em um objeto de imagem
                        ByteArrayInputStream bais = new ByteArrayInputStream(dadosImagem);
                        Image imagem = ImageIO.read(bais);

                        if (imagem != null) {
                            // Redimensionar a imagem para caber no JFrame
                            Image imagemRedimensionada = imagem.getScaledInstance(355, 230, Image.SCALE_SMOOTH);
                            return new ImageIcon(imagemRedimensionada);
                        } else {
                            System.out.println("Erro ao converter os dados em imagem.");
                        }
                    } else {
                        System.out.println("Nenhuma imagem encontrada para o ID fornecido.");
                    }
                } else {
                    System.out.println("Nenhum registro encontrado.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public String getNomeporId(int idCurso) throws SQLException
    {
        String sql = "SELECT nome FROM curso WHERE id = ?";

        ConnectionFactory cf = new ConnectionFactory();

        try 
        (
            Connection conn = cf.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) 
        {
                ps.setInt(1, idCurso);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) 
                {
                    return rs.getString("nome"); // Retorna o nome se encontrado
                } 
                else
                {
                    return null; // Retorna null se o curso não for encontrado
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                throw e;
            }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public BigDecimal getTempo() {
        return tempo;
    }

    public void setTempo(BigDecimal tempo) {
        this.tempo = tempo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageIcon getFotoCurso() {
        return fotoCurso;
    }

    public void setFotoCurso(ImageIcon fotoCurso) {
        this.fotoCurso = fotoCurso;
    }
    
}
