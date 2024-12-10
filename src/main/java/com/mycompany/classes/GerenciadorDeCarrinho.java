package com.mycompany.classes;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
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

    public void listarCarrinhoJanela(JPanel carrinho, JScrollPane scrollPane, JLabel labelQtd, JLabel labelFQtd) throws SQLException {
        carrinho.removeAll(); // Limpa o painel
        
        List<Integer> idsCursosNoCarrinho = Session.getCursosNoCarrinho();

        // Adicionar cada curso no painel
        for (int cursoId : idsCursosNoCarrinho) {
            System.out.println("id do curso adicionado: "+cursoId);
                produtoCarrinhoJanela.addProduto(carrinho, scrollPane, cursoId, labelQtd, labelFQtd);
        }
        
        // Atualizar o painel
        carrinho.revalidate();
        carrinho.repaint();
        atualizarLabelQuantidade(labelQtd, labelFQtd);
    }
    
    public void listarCarrinho(JPanel carrinho, JScrollPane scrollPane, JLabel label, JLabel labelValor, JButton buttonFC) throws SQLException {
        carrinho.removeAll(); // Limpa o painel
        
        List<Integer> idsCursosNoCarrinho = Session.getCursosNoCarrinho();

        // Adicionar cada curso no painel
        for (int cursoId : idsCursosNoCarrinho) {
                produtoCarrinho.addProduto(carrinho, scrollPane, cursoId, label, labelValor, buttonFC);
        }
        
        // Atualizar o painel
        carrinho.revalidate();
        carrinho.repaint();
        atualizarBotao(buttonFC);
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
    
    public void atualizarBotao(JButton buttonFC)
    {
        List<Integer> idsCursosNoCarrinho = Session.getCursosNoCarrinho();
        
        if (idsCursosNoCarrinho.size()>0)
        {
            buttonFC.setVisible(true);
        }
        else
        {
            buttonFC.setVisible(false);
        }
    }
    
    public void atualizarLabelQuantidade(JLabel labelQtd, JLabel labelFQtd)
    {
        List<Integer> idsCursosNoCarrinho = Session.getCursosNoCarrinho();
        
        if(idsCursosNoCarrinho.size()==0)
        {
            labelQtd.setVisible(false);
            labelFQtd.setVisible(false);
        }
        else if (idsCursosNoCarrinho.size()>0)
        {
            labelQtd.setVisible(true);
            labelFQtd.setVisible(true);
            labelQtd.setText(""+idsCursosNoCarrinho.size());
        }
    }
}
