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

public class ProdutoCarrinho 
{
    //Declaração de variaveis
        Curso Curso = new Curso();
        Usuario Usuario = new Usuario();
        
        //Tamanhos do botao de X
        private static final int BUTTON_WIDTH = 40;
        private static final int BUTTON_HEIGHT = 30;

        private static final int TEXTAREA_WIDTH = 790;
        private static final int TEXTAREA_HEIGHT = 80;
        
        //Tamanhos da foto do produto
        private static final int FOTO_WIDTH = 125;
        private static final int FOTO_HEIGHT = 125;
        
        //Tamanhos do nome do autor do produto
        private static final int AUTOR_WIDTH = 790;
        private static final int AUTOR_HEIGHT = 40;
        
        private static final int VALOR_WIDTH = 920;
        private static final int VALOR_HEIGHT = 50;

        //Y inicial do primeiro produto dentro do carrinho
        private static final int Y_OFFSET = 20;

        //espaço entre um produto e outro
        private static final int SPACE_BETWEEN_PRODUCTS = 175;

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
    public void addProduto(JPanel carrinho, JScrollPane scrollPane, int idCurso, JLabel label, JLabel labelValor) throws SQLException 
    {
        JButton buttonXCompra = addBtFechar(carrinho, scrollPane, label, labelValor, idCurso);
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
        atualizarLabel(label);
    }
    
    //metodo para remover produto do carrinho
    public void removeProduto(JPanel panel, JButton buttonXCompra, int index, JScrollPane scrollPane, JLabel label) 
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
        atualizarLabel(label);
    }
    
    //metodo para atualizar o scrollpane como visivel toda vez que houver pelo menos um item no carrinho
    private void atualizarScrollPane(JScrollPane scrollPane) 
    {
        if(Session.getItensNoCarrinho()==0)
        {
            scrollPane.setVisible(false);
        }
        else if(Session.getItensNoCarrinho()>0)
        {
            scrollPane.setVisible(true);
        }
    }
    
    //metodo para ajustar o tamanho do panel conforme a quantidade de itens no carrinho
    private void ajustarPanel(JPanel panel) 
    {
        int alturaNecessaria = Y_OFFSET + (botoesX.size() * SPACE_BETWEEN_PRODUCTS);
        panel.setPreferredSize(new Dimension(970, alturaNecessaria));
        
        System.out.println("panel "+panel.getWidth()+","+panel.getHeight());

        JScrollPane scrollPane = (JScrollPane) SwingUtilities.getAncestorOfClass(JScrollPane.class, panel);
        
        if (scrollPane != null) 
        {
            JPanel jPanel1 = (JPanel) scrollPane.getViewport().getView();
            jPanel1.setPreferredSize(new Dimension(970, alturaNecessaria));

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
            
            botao.setBounds(5, newY, BUTTON_WIDTH, BUTTON_HEIGHT);
            foto.setBounds(48, newY, FOTO_WIDTH, FOTO_HEIGHT);
            nome.setBounds(180, newY, TEXTAREA_WIDTH, TEXTAREA_HEIGHT);
            autor.setBounds(180, newY + 80, AUTOR_WIDTH, AUTOR_HEIGHT);
            valor.setBounds(48, newY + 120, VALOR_WIDTH, VALOR_HEIGHT);
        }
    }
    
//Fim da declaração de metodos
    
//----------------------------------------------------------------------------------------------------------------------------------

//Declaração de metodos para adição de componentes que estarao no carrinho 

    //adiciona o botao de X para excluir o item    
        private JButton addBtFechar(JPanel carrinho, JScrollPane scrollPane, JLabel label, JLabel labelValor, int idCurso) 
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
                    // Remover o curso da lista na session
                    Session.removerDoCarrinho(idCurso);
                    atualizarLabel(label);

                    // Atualizar o carrinho (refazer a listagem dos cursos no painel)
                    try {
                        GerenciadorDeCarrinho gerenciador = new GerenciadorDeCarrinho();
                        gerenciador.listarCarrinho(carrinho, scrollPane, label, labelValor);
                        gerenciador.atualizarLabelValor(labelValor);
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

            carrinho.add(buttonXCompra);

            return buttonXCompra;
        }

    //adiciona a foto do produto
        private JLabel addFotoProduto(JPanel panel, int idImagem) 
        {
            JLabel fotocurso = new JLabel();
            fotocurso.setBorder(null);

            ImageIcon imagemCurso = Curso.exibirImagemIconCarrinho(idImagem);
            {
                if(imagemCurso != null)
                {
                    fotocurso.setIcon(new ProdutoCarrinho.RoundImageIcon(imagemCurso));
                }
                else
                {
                    System.out.println("Imagem nao encontrada para o ID: "+ idImagem);
                    ImageIcon iconDefault = new ImageIcon(getClass().getClassLoader().getResource("images/Formas/defaultfoto.png"));
                    fotocurso.setIcon(new ProdutoCarrinhoJanela.RoundImageIcon(iconDefault));
                }
            }
            
            int yFotoCurso = Y_OFFSET + (botoesX.size() * SPACE_BETWEEN_PRODUCTS);

            fotocurso.setBounds(48, yFotoCurso, FOTO_WIDTH, FOTO_HEIGHT); 

            panel.add(fotocurso);

            return fotocurso;   
        }
        
        private JTextArea addNome(JPanel panel, int idCurso) throws SQLException 
        {
            // Carregar a fonte personalizada
            Font poppins = FontePersonalizada.getFonte(35f); // Obtém a fonte com tamanho

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

            nomecurso.setBounds(180, yNomeCurso, TEXTAREA_WIDTH, TEXTAREA_HEIGHT); 

            panel.add(nomecurso);

            return nomecurso;   
        }
        
        private JLabel addAutor(JPanel panel, int idCurso) throws SQLException
        {
            // Carregar a fonte personalizada
            Font poppins = FontePersonalizada.getFonte(25); // Obtém a fonte com tamanho

            FontePersonalizada fp = new FontePersonalizada();
            fp.carregarFonte();
            
            JLabel autor = new JLabel();
            autor.setBackground(new java.awt.Color(255, 255, 255));
            autor.setForeground(new Color(156,156,156));
            autor.setFont(poppins);
            
            autor.setText(Usuario.getNomePorId(Curso.getIdAutorporId(idCurso)));
            
            int yAutorCurso = Y_OFFSET + (botoesX.size() * SPACE_BETWEEN_PRODUCTS);

            autor.setBounds(180, yAutorCurso+80, AUTOR_WIDTH, AUTOR_HEIGHT); 

            panel.add(autor);
            
            return autor;          
        }
        
        private JLabel addValor(JPanel panel, int idCurso) throws SQLException
        {
            // Carregar a fonte personalizada
            Font poppins = FontePersonalizada.getFonte(37); // Obtém a fonte com tamanho

            FontePersonalizada fp = new FontePersonalizada();
            fp.carregarFonte();
            
            JLabel valor = new JLabel();
            valor.setBackground(new java.awt.Color(255, 255, 255));
            valor.setForeground(new Color(0,0,0));
            valor.setFont(poppins);
            
            valor.setText(Curso.getValorporId(idCurso));
            
            int yAutorCurso = Y_OFFSET + (botoesX.size() * SPACE_BETWEEN_PRODUCTS);

            valor.setBounds(48, yAutorCurso+120, VALOR_WIDTH, VALOR_HEIGHT); 

            panel.add(valor);
            
            return valor;    
        }
    
    //metodo para atualizar o label conforme a quantidade de itens no carrinho
    public void atualizarLabel(JLabel label) 
    {
        if (label != null) 
        {
            if (Session.getItensNoCarrinho()==0) 
            {
                label.setText("Carrinho vazio.");
            } 
            else if (Session.getItensNoCarrinho() == 1) 
            {
                label.setText(Session.getItensNoCarrinho() + " produto no carrinho.");
            } 
            else 
            {
                label.setText(Session.getItensNoCarrinho() + " produtos no carrinho.");
            }
        }
    }
        
//Fim da declaração de metodos para adição de componentes que estarao no carrinho

        static class RoundImageIcon implements Icon {
        private Image image;

        public RoundImageIcon(ImageIcon imageIcon) {
            this.image = imageIcon.getImage();
        }

        @Override
        public int getIconWidth() {
            return 125; // Largura do ícone, deve ser igual ao tamanho do botão
        }

        @Override
        public int getIconHeight() {
            return 125; // Altura do ícone, deve ser igual ao tamanho do botão
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
