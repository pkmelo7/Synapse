//Classe para criar modelos de produtos na tela de carrinho

package com.mycompany.classes;

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
import javax.swing.SwingUtilities;
import javax.swing.border.Border;



public class ProdutoCurso 
{
    //Declaração de variaveis   
    
        Curso Curso = new Curso();
    
        //Tamanhos do botao que possui a foto do curso
        private static final int FOTO_WIDTH = 355;
        private static final int FOTO_HEIGHT = 230;

        //Tamanhos do label com o nome do curso
        private static final int NOME_WIDTH = 350;
        private static final int NOME_HEIGHT = 40;
        
        //X inicial do primeiro produto dentro do scrollpane
        private static final int X_OFFSET = 30;
        
        //espaço entre um produto e outro horizontalmente
        private static final int SPACE_BETWEEN_PRODUCTS = 436;
        
        //Lista para contabilizar quantas fotos de produtos existem
        private final ArrayList<JButton> produtos = new ArrayList<>();

        //Lista para contabilizar quantos labels com nome de curso existem
        private final ArrayList<JLabel> nomesCurso = new ArrayList<>();
        
        
//----------------------------------------------------------------------------------------------------------------------------------
        
        public void addProduto(JPanel panelCursos, JScrollPane scrollPane, int idCurso) throws SQLException 
        {
            JButton foto = addFoto(panelCursos, idCurso);
            JLabel nomeCurso = addNome(panelCursos, idCurso);

            nomesCurso.add(nomeCurso);
            produtos.add(foto);

            ajustarPanel(panelCursos);
            panelCursos.revalidate();
            panelCursos.repaint();

            atualizarScrollPane(scrollPane);
            
            System.out.println("Adicionando curso: " + idCurso);
        }
        
//metodo para atualizar o scrollpane como visivel toda vez que houver pelo menos um item no carrinho
    private void atualizarScrollPane(JScrollPane scrollPane) 
    {
        scrollPane.setVisible(!produtos.isEmpty());
    }
        
    private void ajustarPanel(JPanel panel) 
    {
        int larguraNecessaria = X_OFFSET + (produtos.size() * SPACE_BETWEEN_PRODUCTS);
        panel.setPreferredSize(new Dimension(larguraNecessaria, 300));

        JScrollPane scrollPane = (JScrollPane) SwingUtilities.getAncestorOfClass(JScrollPane.class, panel);
        
        if (scrollPane != null) 
        {
            JPanel jPanel1 = (JPanel) scrollPane.getViewport().getView();
            jPanel1.setPreferredSize(new Dimension(larguraNecessaria, 300));

            if (larguraNecessaria > scrollPane.getWidth()) 
            {
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            } 
            else 
            {
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            }

            scrollPane.revalidate();
            scrollPane.repaint();
        }
        
        System.out.println("Dimensões do painel após ajuste: " 
        + panel.getWidth() + "x" + panel.getHeight());
    }
    
        public JLabel addNome(JPanel panel, int idCurso) throws SQLException 
        {
            // Carregar a fonte personalizada
            Font poppins = FontePersonalizada.getFonte(30f); // Obtém a fonte com tamanho 40

            FontePersonalizada fp = new FontePersonalizada();
            fp.carregarFonte();
            
            JLabel nomeCurso = new JLabel();
            nomeCurso.setFont(poppins); // Define a fonte personalizada
            nomeCurso.setForeground(new java.awt.Color(255,255,255)); // Cor do texto
            
            String nomeCursoReal = Curso.getNomeporId(idCurso);
            nomeCurso.setText(nomeCursoReal);
            
            nomeCurso.setAlignmentX(10.0F); // Alinhamento horizontal
            nomeCurso.setBorder(null); // Sem borda

            // Calcula a posição baseada no deslocamento e no espaço entre os nomes
            int xNomeCurso = X_OFFSET + (nomesCurso.size() * SPACE_BETWEEN_PRODUCTS);

            // Define a posição e o tamanho do JLabel
            nomeCurso.setBounds(xNomeCurso, 250, NOME_WIDTH, NOME_HEIGHT);

            // Adiciona o JLabel ao painel fornecido
            panel.add(nomeCurso);

            return nomeCurso;
        }

        
        public JButton addFoto(JPanel panel, int idImagem) 
        {
            JButton curso = new JButton();
            curso.setBackground(new java.awt.Color(102, 255, 0));
            curso.setBorder(new RoundedBorder(15));
            curso.setContentAreaFilled(false);
            curso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            curso.setFocusPainted(false);
            curso.setFocusable(false);
            
            ImageIcon imagemCurso = Curso.exibirImagemIcon(idImagem);
            {
                if(imagemCurso != null)
                {
                    curso.setIcon(new RoundImageIcon(imagemCurso));
                }
                else
                {
                    System.out.println("Imagem nao encontrada para o ID: "+ idImagem);
                }
            }
            
            panel.add(curso);
            

            int xCurso = X_OFFSET + (produtos.size() * SPACE_BETWEEN_PRODUCTS);

            curso.setBounds(xCurso, 15, FOTO_WIDTH, FOTO_HEIGHT);

            curso.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    
                }
            });

            curso.addMouseListener(new MouseAdapter() 
            {
                @Override
                public void mouseEntered(MouseEvent e) 
                {
                    
                }

                @Override
                public void mouseExited(MouseEvent e) 
                {
                    
                }
            });

            panel.add(curso);

            return curso;
        }
        
        static class RoundImageIcon implements Icon {
        private Image image;

        public RoundImageIcon(ImageIcon imageIcon) {
            this.image = imageIcon.getImage();
        }

        @Override
        public int getIconWidth() {
            return 355; // Largura do ícone, deve ser igual ao tamanho do botão
        }

        @Override
        public int getIconHeight() {
            return 230; // Altura do ícone, deve ser igual ao tamanho do botão
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
            g2.setStroke(new BasicStroke(2)); // Espessura da borda
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius); // Desenhando o retângulo com bordas arredondadas
        }
    }
        
}
