//Classe para criar modelos de produtos na tela de carrinho

package com.mycompany.classes;

//Importações necessarias
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
//fim dads importações necessarias

public class ProdutoCarrinho 
{
    //Declaração de variaveis
        //Tamanhos do botao de X
        private static final int BUTTON_WIDTH = 40;
        private static final int BUTTON_HEIGHT = 30;

        //Tamanhos da foto do produto
        private static final int FOTO_WIDTH = 125;
        private static final int FOTO_HEIGHT = 125;

        //Y inicial do primeiro produto dentro do carrinho
        private static final int Y_OFFSET = 20;

        //espaço entre um produto e outro
        private static final int SPACE_BETWEEN_PRODUCTS = 175;

        //Lista para contabilizar quantos botoes de X existem
        private final ArrayList<JButton> botoesX = new ArrayList<>();

        //Lista para contabilizar quantas fotps de produtos existem
        private final ArrayList<JLabel> fotosProdutos = new ArrayList<>();

        //label para contabilizar quantos itens existem no carrinho
        private JLabel labelQtdCarrinho;
    //Fim da declaração de variaveis
        
//----------------------------------------------------------------------------------------------------------------------------------
        
//Declaração de métodos
    
    //Metodo para adicionar produto no carrinho
    public void addProduto(JPanel carrinho, JScrollPane scrollPane) 
    {
        JButton buttonXCompra = addBtFechar(carrinho);
        JLabel fotoProduto = addFotoProduto(carrinho);
        
        botoesX.add(buttonXCompra);
        fotosProdutos.add(fotoProduto);
        
        ajustarPanel(carrinho);
        carrinho.revalidate();
        carrinho.repaint();
        
        atualizarScrollPane(scrollPane);
        atualizarLabel();
    }
    
    //metodo para remover produto do carrinho
    public void removeProduto(JPanel panel, JButton buttonXCompra, int index, JScrollPane scrollPane) 
    {
        botoesX.remove(index);
        panel.remove(buttonXCompra);
        
        JLabel fotoProduto = fotosProdutos.remove(index);
        panel.remove(fotoProduto);
        
        atualizarPosicoes(panel, index);
        ajustarPanel(panel);
        panel.revalidate();
        panel.repaint();
        
        atualizarScrollPane(scrollPane);
        atualizarLabel();
    }
    
    //metodo para atualizar o scrollpane como visivel toda vez que houver pelo menos um item no carrinho
    private void atualizarScrollPane(JScrollPane scrollPane) 
    {
        scrollPane.setVisible(!botoesX.isEmpty());
    }
    
    //metodo para ajustar o tamanho do panel conforme a quantidade de itens no carrinho
    private void ajustarPanel(JPanel panel) 
    {
        int alturaNecessaria = Y_OFFSET + (botoesX.size() * SPACE_BETWEEN_PRODUCTS);
        panel.setPreferredSize(new Dimension(panel.getWidth(), alturaNecessaria));

        JScrollPane scrollPane = (JScrollPane) SwingUtilities.getAncestorOfClass(JScrollPane.class, panel);
        
        if (scrollPane != null) 
        {
            JPanel jPanel1 = (JPanel) scrollPane.getViewport().getView();
            jPanel1.setPreferredSize(new Dimension(jPanel1.getWidth(), alturaNecessaria));

            if (alturaNecessaria > scrollPane.getHeight()) 
            {
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            } 
            else 
            {
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            }

            scrollPane.revalidate();
            scrollPane.repaint();
        }
    }
    
    //metodo para atualizar as posicoes dos produtos caso algum seja removido do carrinho
    private void atualizarPosicoes(JPanel panel, int startIndex) 
    {
        for (int i = startIndex; i < botoesX.size(); i++) 
        {
            JButton botao = botoesX.get(i);
            JLabel foto = fotosProdutos.get(i);
            
            int newY = Y_OFFSET + (i * SPACE_BETWEEN_PRODUCTS);
            
            botao.setBounds(5, newY, BUTTON_WIDTH, BUTTON_HEIGHT);
            foto.setBounds(48, newY, FOTO_WIDTH, FOTO_HEIGHT); 
        }
    }
    
    //metodo para configurar o label que mostra a quantidade de itens no carrinho
    public void setLabel(JLabel label) 
    {
        this.labelQtdCarrinho = label;
        atualizarLabel();
    }
    
    //metodo para atualizar o label conforme a quantidade de itens no carrinho
    private void atualizarLabel() 
    {
        if (labelQtdCarrinho != null) 
        {
            if (botoesX.isEmpty()) 
            {
                labelQtdCarrinho.setText("Carrinho vazio.");
            } 
            else if (botoesX.size() == 1) 
            {
                labelQtdCarrinho.setText(botoesX.size() + " produto no carrinho.");
            } 
            else 
            {
                labelQtdCarrinho.setText(botoesX.size() + " produtos no carrinho.");
            }
        }
    }
    
//Fim da declaração de metodos
    
//----------------------------------------------------------------------------------------------------------------------------------

//Declaração de metodos para adição de componentes que estarao no carrinho 

    //adiciona o botao de X para excluir o item    
        private JButton addBtFechar(JPanel panel) 
        {
            JButton buttonXCompra = new JButton();
            buttonXCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/XCompra.png")));
            buttonXCompra.setBorder(null);
            buttonXCompra.setBorderPainted(false);
            buttonXCompra.setContentAreaFilled(false);
            buttonXCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            buttonXCompra.setFocusPainted(false);

            int yXCompras = Y_OFFSET + (botoesX.size() * SPACE_BETWEEN_PRODUCTS);

            buttonXCompra.setBounds(5, yXCompras, BUTTON_WIDTH, BUTTON_HEIGHT);

            buttonXCompra.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    removeProduto(panel, buttonXCompra, botoesX.indexOf(buttonXCompra), (JScrollPane) SwingUtilities.getAncestorOfClass(JScrollPane.class, panel));            
                }
            });

            buttonXCompra.addMouseListener(new MouseAdapter() 
            {
                @Override
                public void mouseEntered(MouseEvent e) 
                {
                    ImageIcon XCompraAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/XCompraAzul.png"));
                    buttonXCompra.setIcon(XCompraAzul);
                }

                @Override
                public void mouseExited(MouseEvent e) 
                {
                    ImageIcon XCompra = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/XCompra.png"));
                    buttonXCompra.setIcon(XCompra);
                }
            });

            panel.add(buttonXCompra);

            return buttonXCompra;
        }

    //adiciona a foto do produto
        private JLabel addFotoProduto(JPanel panel) 
        {
            JLabel fotocurso = new JLabel();
            fotocurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Formas/defaultfoto.png")));
            fotocurso.setBorder(null);

            int yFotoCurso = Y_OFFSET + (botoesX.size() * SPACE_BETWEEN_PRODUCTS);

            fotocurso.setBounds(48, yFotoCurso, FOTO_WIDTH, FOTO_HEIGHT); 

            panel.add(fotocurso);

            return fotocurso;   
        }
        
//Fim da declaração de metodos para adição de componentes que estarao no carrinho
}
