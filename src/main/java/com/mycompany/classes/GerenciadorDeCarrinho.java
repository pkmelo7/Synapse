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
    
    public void listarCarrinho(JPanel carrinho, JScrollPane scrollPane, JLabel label) throws SQLException {
        carrinho.removeAll(); // Limpa o painel
        
        List<Integer> idsCursosNoCarrinho = Session.getCursosNoCarrinho();

        // Adicionar cada curso no painel
        for (int cursoId : idsCursosNoCarrinho) {
                produtoCarrinho.addProduto(carrinho, scrollPane, cursoId, label);
        }
        
        // Atualizar o painel
        carrinho.revalidate();
        carrinho.repaint();
    }
}
