package com.mycompany.classes;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GerenciadorDeCarrinho {

    private ProdutoCarrinhoJanela produtoCarrinhoJanela;
    private ProdutoCarrinho produtoCarrinho;

    public GerenciadorDeCarrinho() {
        produtoCarrinhoJanela = new ProdutoCarrinhoJanela();
        produtoCarrinho = new ProdutoCarrinho();
    }

    public void listarCarrinhoJanela(JPanel carrinho, JScrollPane scrollPane) throws SQLException {
        carrinho.removeAll(); // Limpa o painel
        
        List<Integer> idsCursosNoCarrinho = Session.getCursosNoCarrinho();

        // Adicionar cada curso no painel
        for (int cursoId : idsCursosNoCarrinho) {
            System.out.println("id do curso adicionado: "+cursoId);
                produtoCarrinhoJanela.addProduto(carrinho, scrollPane, cursoId);
        }
        
        // Atualizar o painel
        carrinho.revalidate();
        carrinho.repaint();
    }
    
    public void listarCarrinho(JPanel carrinho, JScrollPane scrollPane, JLabel label, JLabel labelValor) throws SQLException {
        carrinho.removeAll(); // Limpa o painel
        
        List<Integer> idsCursosNoCarrinho = Session.getCursosNoCarrinho();

        // Adicionar cada curso no painel
        for (int cursoId : idsCursosNoCarrinho) {
                produtoCarrinho.addProduto(carrinho, scrollPane, cursoId, label, labelValor);
        }
        
        // Atualizar o painel
        carrinho.revalidate();
        carrinho.repaint();
    }
    
    public void cadastrarAcessos(JPanel carrinho) throws SQLException
    {        
        List<Integer> idsCursosNoCarrinho = Session.getCursosNoCarrinho();

        Usuario usu = Session.getLoggedUser();
        String user = usu.getUser();
        int idUsu = Usuario.getIdPorUsuario(user);
        
        for (int cursoId : idsCursosNoCarrinho) {
                Usuario.cadastraAcesso(idUsu, cursoId);
                System.out.println("Acesso cadastrado com sucesso. Usuario: "+ idUsu+ ", Curso: "+ cursoId);
        }
        carrinho.removeAll();
    }
    
    public void atualizarLabelValor (JLabel label) throws SQLException
    {
        List<Integer> idsCursosNoCarrinho = Session.getCursosNoCarrinho();
        
        double soma = 0.0;
        
        for (int cursoId : idsCursosNoCarrinho) {
            Curso c = Session.listarCursoporId(cursoId);
            String preco = c.getPreco();
            String precoFormatado = preco.replace("R$", "").replace(",", ".");
            soma += Double.parseDouble(precoFormatado);
        }
        
        String resultadoFormatado = String.format("R$%.2f", soma);
        
        label.setText(resultadoFormatado);
    }
}
