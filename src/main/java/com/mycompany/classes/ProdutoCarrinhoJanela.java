//Classe para criar modelos de produtos na tela de carrinho

package com.mycompany.classes;

//Importações necessarias
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
//fim dads importações necessarias

public class ProdutoCarrinhoJanela 
{
    //Declaração de variaveis
        Curso Curso = new Curso();
        Usuario Usuario = new Usuario();
    
        //Tamanhos do botao de X
        private static final int BUTTON_WIDTH = 20;
        private static final int BUTTON_HEIGHT = 20;
        
        private static final int TEXTAREA_WIDTH = 130;
        private static final int TEXTAREA_HEIGHT = 40;

        //Tamanhos da foto do produto
        private static final int FOTO_WIDTH = 55;
        private static final int FOTO_HEIGHT = 55;
        
        //Tamanhos do nome do autor do produto
        private static final int AUTOR_WIDTH = 130;
        private static final int AUTOR_HEIGHT = 15;
        
        //Tamanhos do valor do produto
        private static final int VALOR_WIDTH = 190;
        private static final int VALOR_HEIGHT = 25;

        //Y inicial do primeiro produto dentro do carrinho
        private static final int Y_OFFSET = 10;

        //espaço entre um produto e outro
        private static final int SPACE_BETWEEN_PRODUCTS = 100;

        //Lista para contabilizar quantos botoes de X existem
        private final ArrayList<JButton> botoesX = new ArrayList<>();

        //Lista para contabilizar quantas fotps de produtos existem
        private final ArrayList<JLabel> fotosProdutos = new ArrayList<>();
        
        // Lista para contabilizar os nomes dos cursos no carrinho
        private final ArrayList<JTextArea> nomesCursos = new ArrayList<>();
        
        private final ArrayList<JLabel> autoresCursos = new ArrayList<>();
        
        private final ArrayList<JLabel> valoresCursos = new ArrayList<>();

    //Fim da declaração de variaveis
        
//----------------------------------------------------------------------------------------------------------------------------------
        
//Declaração de métodos
    
    //Metodo para adicionar produto no carrinho
    public void addProduto(JPanel carrinho, JScrollPane scrollPane, int idCurso, JLabel labelQtd, JLabel labelFQtd) throws SQLException 
    {
        JButton buttonXCompra = addBtFechar(carrinho, scrollPane, idCurso, labelQtd, labelFQtd);
        JLabel fotoProduto = addFotoProduto(carrinho, idCurso);
        JTextArea nomeCurso = addNome(carrinho, idCurso);
        JLabel autorCurso = addAutor(carrinho, idCurso);
        JLabel valorCurso = addValor(carrinho, idCurso);
        
        botoesX.add(buttonXCompra);
        fotosProdutos.add(fotoProduto);
        nomesCursos.add(nomeCurso);
        autoresCursos.add(autorCurso);
        valoresCursos.add(valorCurso);
        
        System.out.println("tamanho da lista de botoes X "+ botoesX.size());
        
        ajustarPanel(carrinho);
        carrinho.revalidate();
        carrinho.repaint();
        
        atualizarScrollPane(scrollPane);
    }
    
    //metodo para remover produto do carrinho
    public void removeProduto(JPanel panel, JButton buttonXCompra, int index, JScrollPane scrollPane) 
    {
        botoesX.remove(index);
        panel.remove(buttonXCompra);
        
        JLabel fotoProduto = fotosProdutos.remove(index);
        panel.remove(fotoProduto);
        
        JTextArea nomeCurso = nomesCursos.remove(index);
        panel.remove(nomeCurso);
        
        JLabel autorCurso = autoresCursos.remove(index);
        panel.remove(autorCurso);
        
        JLabel valorCurso = valoresCursos.remove(index);
        panel.remove(valorCurso);
        
        atualizarPosicoes(panel, index);
        ajustarPanel(panel);
        panel.revalidate();
        panel.repaint();
        
        atualizarScrollPane(scrollPane);
    }
    
    //metodo para atualizar o scrollpane como visivel toda vez que houver pelo menos um item no carrinho
    private void atualizarScrollPane(JScrollPane scrollPane) 
    {
        if(Session.getItensNoCarrinho()==0)
        {
            scrollPane.setVisible(false);
        }
    }
    
    //metodo para ajustar o tamanho do panel conforme a quantidade de itens no carrinho
    private void ajustarPanel(JPanel panel) 
    {
        int alturaNecessaria = Y_OFFSET + (botoesX.size() * SPACE_BETWEEN_PRODUCTS);
        panel.setPreferredSize(new Dimension(230, alturaNecessaria));
        
        System.out.println("panel "+panel.getWidth()+","+panel.getHeight());

        JScrollPane scrollPane = (JScrollPane) SwingUtilities.getAncestorOfClass(JScrollPane.class, panel);
        
        if (scrollPane != null) 
        {
            JPanel jPanel1 = (JPanel) scrollPane.getViewport().getView();
            jPanel1.setPreferredSize(new Dimension(230, alturaNecessaria));

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
            JTextArea nome = nomesCursos.get(i); // Caso a lista de nomes já exista
            JLabel autor = autoresCursos.get(i);
            JLabel valor = valoresCursos.get(i);
            
            int newY = 0;
            
            if(Session.getItensNoCarrinho()==1)
            {    
                newY = Y_OFFSET;
            }
            else if(Session.getItensNoCarrinho()>1)
            {
                newY = Y_OFFSET + (i * SPACE_BETWEEN_PRODUCTS);
            }
            
            botao.setBounds(3, newY, BUTTON_WIDTH, BUTTON_HEIGHT);
            foto.setBounds(25, newY, FOTO_WIDTH, FOTO_HEIGHT);
            nome.setBounds(84, newY, TEXTAREA_WIDTH, TEXTAREA_HEIGHT);
            autor.setBounds(84, newY + 40, AUTOR_WIDTH, AUTOR_HEIGHT);
            valor.setBounds(25, newY + 55, VALOR_WIDTH, VALOR_HEIGHT);
        }
    }
    
//Fim da declaração de metodos
    
//----------------------------------------------------------------------------------------------------------------------------------

//Declaração de metodos para adição de componentes que estarao no carrinho 

    //adiciona o botao de X para excluir o item    
        private JButton addBtFechar(JPanel carrinho, JScrollPane scrollPane, int idCurso, JLabel labelQtd, JLabel labelFQtd) 
        {
            JButton buttonXCompra = new JButton();
            buttonXCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/XCompraJanela.png")));
            buttonXCompra.setBorder(null);
            buttonXCompra.setBorderPainted(false);
            buttonXCompra.setContentAreaFilled(false);
            buttonXCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            buttonXCompra.setFocusPainted(false);

            int yXCompras = Y_OFFSET + (botoesX.size() * SPACE_BETWEEN_PRODUCTS);

            buttonXCompra.setBounds(3, yXCompras, BUTTON_WIDTH, BUTTON_HEIGHT);

            buttonXCompra.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    // Remover o curso da lista na session
                    Session.removerDoCarrinho(idCurso);

                    // Atualizar o carrinho (refazer a listagem dos cursos no painel)
                    try {
                        GerenciadorDeCarrinho gerenciador = new GerenciadorDeCarrinho();
                        gerenciador.listarCarrinhoJanela(carrinho, scrollPane, labelQtd, labelFQtd);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }                
                }
            });

            buttonXCompra.addMouseListener(new MouseAdapter() 
            {
                @Override
                public void mouseEntered(MouseEvent e) 
                {
                    ImageIcon XCompraAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/XCompraJanelaAzul.png"));
                    buttonXCompra.setIcon(XCompraAzul);
                }

                @Override
                public void mouseExited(MouseEvent e) 
                {
                    ImageIcon XCompra = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/XCompraJanela.png"));
                    buttonXCompra.setIcon(XCompra);
                }
            });

            carrinho.add(buttonXCompra);

            return buttonXCompra;
        }

    //adiciona a foto do produto
        private JLabel addFotoProduto(JPanel panel, int idImagem) 
        {
            JLabel fotocurso = new JLabel();
            fotocurso.setBorder(null);

            ImageIcon imagemCurso = Curso.exibirImagemIconCarrinhoJanela(idImagem);
            {
                if(imagemCurso != null)
                {
                    fotocurso.setIcon(new ProdutoCarrinhoJanela.RoundImageIcon(imagemCurso));
                }
                else
                {
                    System.out.println("Imagem nao encontrada para o ID: "+ idImagem);
                    ImageIcon iconDefault = new ImageIcon(getClass().getClassLoader().getResource("images/Formas/defaultfotoJanela.png"));
                    fotocurso.setIcon(new ProdutoCarrinhoJanela.RoundImageIcon(iconDefault));
                }
            }
            
            int yFotoCurso = Y_OFFSET + (botoesX.size() * SPACE_BETWEEN_PRODUCTS);

            fotocurso.setBounds(25, yFotoCurso, FOTO_WIDTH, FOTO_HEIGHT); 

            panel.add(fotocurso);

            return fotocurso;   
        }
        
        private JTextArea addNome(JPanel panel, int idCurso) throws SQLException 
        {
            // Carregar a fonte personalizada
            Font poppins = FontePersonalizada.getFonte(14f); // Obtém a fonte com tamanho

            FontePersonalizada fp = new FontePersonalizada();
            fp.carregarFonte();
            
            JTextArea nomecurso = new JTextArea();
            nomecurso.setEditable(false);
            nomecurso.setBackground(new java.awt.Color(255, 255, 255));
            nomecurso.setColumns(20);
            nomecurso.setFont(poppins);
            nomecurso.setForeground(new java.awt.Color(0, 0, 0));
            nomecurso.setLineWrap(true);
            nomecurso.setRows(5);
            nomecurso.setBorder(null);
            nomecurso.setFocusable(false);
            
            nomecurso.setText(Curso.getNomeporId(idCurso));
        
            int yNomeCurso = Y_OFFSET + (botoesX.size() * SPACE_BETWEEN_PRODUCTS);

            nomecurso.setBounds(84, yNomeCurso, TEXTAREA_WIDTH, TEXTAREA_HEIGHT); 

            panel.add(nomecurso);

            return nomecurso;   
        }
        
        private JLabel addAutor(JPanel panel, int idCurso) throws SQLException
        {
            // Carregar a fonte personalizada
            Font poppins = FontePersonalizada.getFonte(12f); // Obtém a fonte com tamanho

            FontePersonalizada fp = new FontePersonalizada();
            fp.carregarFonte();
            
            JLabel autor = new JLabel();
            autor.setBackground(new java.awt.Color(255, 255, 255));
            autor.setForeground(new Color(156,156,156));
            autor.setFont(poppins);
            
            autor.setText(Usuario.getNomePorId(Curso.getIdAutorporId(idCurso)));
            
            int yAutorCurso = Y_OFFSET + (botoesX.size() * SPACE_BETWEEN_PRODUCTS);

            autor.setBounds(84, yAutorCurso+40, AUTOR_WIDTH, AUTOR_HEIGHT); 

            panel.add(autor);
            
            return autor;          
        }
        
        private JLabel addValor(JPanel panel, int idCurso) throws SQLException
        {
            // Carregar a fonte personalizada
            Font poppins = FontePersonalizada.getFonte(20f); // Obtém a fonte com tamanho

            FontePersonalizada fp = new FontePersonalizada();
            fp.carregarFonte();
            
            JLabel valor = new JLabel();
            valor.setBackground(new java.awt.Color(255, 255, 255));
            valor.setForeground(new Color(0,0,0));
            valor.setFont(poppins);
            
            valor.setText(Curso.getValorporId(idCurso));
            
            int yAutorCurso = Y_OFFSET + (botoesX.size() * SPACE_BETWEEN_PRODUCTS);

            valor.setBounds(25, yAutorCurso+55, VALOR_WIDTH, VALOR_HEIGHT); 

            panel.add(valor);
            
            return valor;    
        }
        
//Fim da declaração de metodos para adição de componentes que estarao no carrinho
        
        static class RoundImageIcon implements Icon {
        private Image image;

        public RoundImageIcon(ImageIcon imageIcon) {
            this.image = imageIcon.getImage();
        }

        @Override
        public int getIconWidth() {
            return 55; // Largura do ícone, deve ser igual ao tamanho do botão
        }

        @Override
        public int getIconHeight() {
            return 55; // Altura do ícone, deve ser igual ao tamanho do botão
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            // Criando um objeto Graphics2D para pintar a imagem
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Criando uma máscara arredondada (corte da imagem)
            Shape clip = new RoundRectangle2D.Float(x, y, getIconWidth(), getIconHeight(), 15, 15); // Raio de 30
            g2.setClip(clip);

            // Desenhando a imagem dentro da forma arredondada
            g2.drawImage(image, x, y, getIconWidth(), getIconHeight(), null);

            g2.dispose();
        }
    }
        
        static class RoundedBorder implements Border {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 1, this.radius + 1);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.BLACK);  // Cor da borda
            g2.setStroke(new BasicStroke(1)); // Espessura da borda
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius); // Desenhando o retângulo com bordas arredondadas
        }
    }
}
