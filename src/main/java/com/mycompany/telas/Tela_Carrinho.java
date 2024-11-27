//@author @pkmelo7

package com.mycompany.telas;

//Importações necessárias
import com.mycompany.classes.ProdutoCarrinho;
import com.mycompany.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;
//Fim das importações necessárias

public class Tela_Carrinho extends javax.swing.JFrame
{
    //Declaração de variáveis
        //Variáveis para o movimento do logo Synapse
        final int originalX = 10;
        final int targetX = 150;
        final int step = 10;
        Timer timer = new Timer(20, null);
        
        //Variaveis para configurar a fonte poppins
        Font poppins;
        GraphicsEnvironment GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        //Variavel para trazer o icone do projeto
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/icon.png"));
        
        //Variavel para trazer a classe ProdutoCarrinho
        ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho();
    //Final da declaração de variáveis
        
    //Variavel provisoria para teste    
    int totalcarrinho = 0;
    
    //Declaração de métodos
    
    //cria o método abrirTela_Menu, onde invoca a tela de menu e fecha a tela atual
        private void abrirTelaMenu() throws FontFormatException, IOException, SQLException
        {
            Tela_Menu TelaMenu = new Tela_Menu();
            this.dispose();
            TelaMenu.setVisible(true);
        }
        
        //cria o método abrirTela_Sobre, onde invoca a tela de sobre e fecha a tela de cadastro
        private void abrirTela_Sobre() throws FontFormatException, IOException
        {
            Tela_Sobre Tela_Sobre = new Tela_Sobre();
            this.dispose();
            Tela_Sobre.setVisible(true);
        }
    //Fim da declaração de métodos
    
    public Tela_Carrinho() throws FontFormatException, IOException {
        //cria a fonte poppins no projeto
        this.poppins = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Poppins-Bold.ttf"));
        initComponents();
        //Configurar scrollbar vertical como customizada
        scrollbar.setVerticalScrollBar(new ScrollBarCustom());  
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fundoPrincipal = new javax.swing.JPanel();
        buttonSynapse = new javax.swing.JButton();
        buttonSynapseLogo = new javax.swing.JButton();
        fieldPesquisa = new javax.swing.JTextField();
        buttonXpesq = new javax.swing.JButton();
        buttonSobre = new javax.swing.JButton();
        buttonCursos = new javax.swing.JButton();
        buttonCadastrarse = new javax.swing.JButton();
        buttonXTelas = new javax.swing.JButton();
        buttonPR = new javax.swing.JButton();
        labelQtdCarrinho = new javax.swing.JLabel();
        buttonAplicarDesc = new javax.swing.JButton();
        labelDescontos = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        buttonFinalizarCompra = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        scrollbar = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        carrinho = new javax.swing.JPanel();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Synapse Connect");
        setBackground(new java.awt.Color(224, 222, 222));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setIconImage(icon.getImage());
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 750));
        getContentPane().setLayout(null);

        fundoPrincipal.setBackground(new java.awt.Color(224, 222, 222));
        fundoPrincipal.setForeground(new java.awt.Color(224, 222, 222));
        fundoPrincipal.setLayout(null);

        buttonSynapse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/NomeLogo.png"))); // NOI18N
        buttonSynapse.setBorder(null);
        buttonSynapse.setBorderPainted(false);
        buttonSynapse.setContentAreaFilled(false);
        buttonSynapse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonSynapse.setFocusPainted(false);
        buttonSynapse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonSynapseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonSynapseMouseExited(evt);
            }
        });
        buttonSynapse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSynapseActionPerformed(evt);
            }
        });
        fundoPrincipal.add(buttonSynapse);
        buttonSynapse.setBounds(30, 0, 260, 160);

        buttonSynapseLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/IconSynapse.png"))); // NOI18N
        buttonSynapseLogo.setBorder(null);
        buttonSynapseLogo.setBorderPainted(false);
        buttonSynapseLogo.setContentAreaFilled(false);
        buttonSynapseLogo.setFocusPainted(false);
        fundoPrincipal.add(buttonSynapseLogo);
        buttonSynapseLogo.setBounds(10, 0, 170, 160);

        fieldPesquisa.setBackground(new java.awt.Color(224, 222, 222));
        fieldPesquisa.setFont(poppins.deriveFont(14f));
        fieldPesquisa.setForeground(new java.awt.Color(128, 128, 128));
        fieldPesquisa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldPesquisa.setText("Pesquisar:");
        fieldPesquisa.setBorder(null);
        fieldPesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldPesquisaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldPesquisaFocusLost(evt);
            }
        });
        fieldPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPesquisaActionPerformed(evt);
            }
        });
        fundoPrincipal.add(fieldPesquisa);
        fieldPesquisa.setBounds(380, 50, 380, 50);

        buttonXpesq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/X.png"))); // NOI18N
        buttonXpesq.setBorder(null);
        buttonXpesq.setBorderPainted(false);
        buttonXpesq.setContentAreaFilled(false);
        buttonXpesq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonXpesq.setFocusPainted(false);
        buttonXpesq.setMaximumSize(new java.awt.Dimension(86, 19));
        buttonXpesq.setMinimumSize(new java.awt.Dimension(86, 19));
        buttonXpesq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonXpesqMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonXpesqMouseExited(evt);
            }
        });
        buttonXpesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXpesqActionPerformed(evt);
            }
        });
        fundoPrincipal.add(buttonXpesq);
        buttonXpesq.setBounds(780, 60, 40, 30);

        buttonSobre.setFont(poppins.deriveFont(24f));
        buttonSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/Sobre.png"))); // NOI18N
        buttonSobre.setBorder(null);
        buttonSobre.setBorderPainted(false);
        buttonSobre.setContentAreaFilled(false);
        buttonSobre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonSobre.setFocusPainted(false);
        buttonSobre.setMaximumSize(new java.awt.Dimension(86, 19));
        buttonSobre.setMinimumSize(new java.awt.Dimension(86, 19));
        buttonSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonSobreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonSobreMouseExited(evt);
            }
        });
        buttonSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSobreActionPerformed(evt);
            }
        });
        fundoPrincipal.add(buttonSobre);
        buttonSobre.setBounds(920, 62, 100, 30);

        buttonCursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/Cursos.png"))); // NOI18N
        buttonCursos.setBorder(null);
        buttonCursos.setBorderPainted(false);
        buttonCursos.setContentAreaFilled(false);
        buttonCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonCursos.setFocusPainted(false);
        buttonCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCursosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCursosMouseExited(evt);
            }
        });
        buttonCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCursosActionPerformed(evt);
            }
        });
        fundoPrincipal.add(buttonCursos);
        buttonCursos.setBounds(1030, 62, 100, 30);

        buttonCadastrarse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/Cadastrarse.png"))); // NOI18N
        buttonCadastrarse.setBorder(null);
        buttonCadastrarse.setBorderPainted(false);
        buttonCadastrarse.setContentAreaFilled(false);
        buttonCadastrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonCadastrarse.setFocusPainted(false);
        buttonCadastrarse.setMaximumSize(new java.awt.Dimension(86, 19));
        buttonCadastrarse.setMinimumSize(new java.awt.Dimension(86, 19));
        buttonCadastrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCadastrarseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCadastrarseMouseExited(evt);
            }
        });
        buttonCadastrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarseActionPerformed(evt);
            }
        });
        fundoPrincipal.add(buttonCadastrarse);
        buttonCadastrarse.setBounds(1150, 52, 170, 50);

        buttonXTelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/XFecharTelas.png"))); // NOI18N
        buttonXTelas.setBorder(null);
        buttonXTelas.setBorderPainted(false);
        buttonXTelas.setContentAreaFilled(false);
        buttonXTelas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonXTelas.setFocusPainted(false);
        buttonXTelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonXTelasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonXTelasMouseExited(evt);
            }
        });
        buttonXTelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXTelasActionPerformed(evt);
            }
        });
        fundoPrincipal.add(buttonXTelas);
        buttonXTelas.setBounds(1280, 0, 86, 25);

        buttonPR.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        buttonPR.setForeground(new java.awt.Color(255, 255, 255));
        buttonPR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/IconSynapsePreto.png"))); // NOI18N
        buttonPR.setBorder(null);
        buttonPR.setBorderPainted(false);
        buttonPR.setContentAreaFilled(false);
        buttonPR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonPR.setFocusPainted(false);
        buttonPR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonPRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonPRMouseExited(evt);
            }
        });
        buttonPR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPRActionPerformed(evt);
            }
        });
        fundoPrincipal.add(buttonPR);
        buttonPR.setBounds(1270, 658, 80, 70);

        labelQtdCarrinho.setFont(poppins.deriveFont(20f));
        labelQtdCarrinho.setForeground(new java.awt.Color(0, 0, 0));
        labelQtdCarrinho.setText("Carrinho vazio.");
        produtoCarrinho.setLabel(labelQtdCarrinho);
        fundoPrincipal.add(labelQtdCarrinho);
        labelQtdCarrinho.setBounds(10, 175, 940, 30);

        buttonAplicarDesc.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        buttonAplicarDesc.setForeground(new java.awt.Color(255, 255, 255));
        buttonAplicarDesc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/AplicarDesconto.png"))); // NOI18N
        buttonAplicarDesc.setBorder(null);
        buttonAplicarDesc.setBorderPainted(false);
        buttonAplicarDesc.setContentAreaFilled(false);
        buttonAplicarDesc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAplicarDesc.setFocusPainted(false);
        buttonAplicarDesc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAplicarDescMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAplicarDescMouseExited(evt);
            }
        });
        buttonAplicarDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAplicarDescActionPerformed(evt);
            }
        });
        fundoPrincipal.add(buttonAplicarDesc);
        buttonAplicarDesc.setBounds(863, 679, 80, 50);

        labelDescontos.setFont(poppins.deriveFont(24f));
        labelDescontos.setForeground(new java.awt.Color(156, 156, 156));
        labelDescontos.setText("Descontos aplicados: R$"+totalcarrinho);
        fundoPrincipal.add(labelDescontos);
        labelDescontos.setBounds(25, 725, 550, 30);

        labelTotal.setFont(poppins.deriveFont(40f));
        labelTotal.setForeground(new java.awt.Color(30, 30, 30));
        labelTotal.setText("R$"+totalcarrinho);
        fundoPrincipal.add(labelTotal);
        labelTotal.setBounds(25, 680, 550, 50);

        buttonFinalizarCompra.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        buttonFinalizarCompra.setForeground(new java.awt.Color(255, 255, 255));
        buttonFinalizarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/FinalizarCompra.png"))); // NOI18N
        buttonFinalizarCompra.setBorder(null);
        buttonFinalizarCompra.setBorderPainted(false);
        buttonFinalizarCompra.setContentAreaFilled(false);
        buttonFinalizarCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonFinalizarCompra.setFocusPainted(false);
        buttonFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFinalizarCompraActionPerformed(evt);
            }
        });
        fundoPrincipal.add(buttonFinalizarCompra);
        buttonFinalizarCompra.setBounds(1030, 684, 180, 50);

        jButton1.setText("ADD PRODUTO CARRINHO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        fundoPrincipal.add(jButton1);
        jButton1.setBounds(1010, 390, 220, 23);

        scrollbar.setBorder(null);
        scrollbar.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollbar.setVisible(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        carrinho.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carrinhoLayout = new javax.swing.GroupLayout(carrinho);
        carrinho.setLayout(carrinhoLayout);
        carrinhoLayout.setHorizontalGroup(
            carrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        carrinhoLayout.setVerticalGroup(
            carrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(carrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1651, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(carrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 419, Short.MAX_VALUE))
        );

        scrollbar.setViewportView(jPanel1);

        fundoPrincipal.add(scrollbar);
        scrollbar.setBounds(0, 205, 970, 420);

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FundosTelas/FundoCarrinho.png"))); // NOI18N
        fundoPrincipal.add(fundo);
        fundo.setBounds(0, -17, 1370, 800);

        getContentPane().add(fundoPrincipal);
        fundoPrincipal.setBounds(0, 0, 1366, 768);

        setBounds(-6, 0, 1366, 768);
    }// </editor-fold>//GEN-END:initComponents
//---------------------------------------------------------------------------------------------------------------------------------
    
//Início dos comandos do botão do Logo "Synapse Connect"
    //<null>
    private void buttonSynapseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSynapseActionPerformed
            try {
                // TODO add your handling code here:
                abrirTelaMenu();
            } catch (FontFormatException ex) {
                Logger.getLogger(Tela_Carrinho.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Tela_Carrinho.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Tela_Carrinho.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_buttonSynapseActionPerformed
    //Move o Logo "Synapse Connect" à posição final enquanto o mouse estiver em cima
    private void buttonSynapseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSynapseMouseEntered
        // TODO add your handling code here:
        timer.stop();
        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                int x = buttonSynapseLogo.getX();
                int y = buttonSynapseLogo.getY();

                if (x < targetX) {
                    buttonSynapseLogo.setLocation(x + step, y);
                }
            }
        });
        timer.start();
    }//GEN-LAST:event_buttonSynapseMouseEntered
    //Move o Logo "Synapse Connect" à posição inicial quando o mouse sair de cima
    private void buttonSynapseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSynapseMouseExited
        // TODO add your handling code here:
        timer.stop();
        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                int x = buttonSynapseLogo.getX();
                int y = buttonSynapseLogo.getY();

                if (x > originalX) {
                    buttonSynapseLogo.setLocation(x - step, y);
                }
            }
        });
        timer.start();
    }//GEN-LAST:event_buttonSynapseMouseExited
//Fim dos comandos do botão do Logo "Synapse Connect"
    
//---------------------------------------------------------------------------------------------------------------------------------
    
//Início dos comandos do field "Pesquisar"
    //<null>
    private void fieldPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPesquisaActionPerformed
    //Faz com que a palavra "Pesquisar" desapareça de dentro do field quando o foco é retomado
    private void fieldPesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldPesquisaFocusGained
        // TODO add your handling code here:
        if (fieldPesquisa.getText().equals("Pesquisar:")) {
            fieldPesquisa.setText("");
            fieldPesquisa.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_fieldPesquisaFocusGained
    //Faz com que a palavra "Pesquisar" apareça dentro do field quando o foco é perdido
    private void fieldPesquisaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldPesquisaFocusLost
        // TODO add your handling code here:
        if (fieldPesquisa.getText().isEmpty()) {
            fieldPesquisa.setForeground(Color.GRAY);
            fieldPesquisa.setText("Pesquisar:");
        }
    }//GEN-LAST:event_fieldPesquisaFocusLost
//Início dos comandos do botão "X" para o field "Pesquisar"
    //Faz com que ao clicar no botão "X", tudo que possa estar escrito dentro do field "Pesquisar" seja apagado e o field seja setado novamente como "Pesquisar" na cor cinza
    private void buttonXpesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXpesqActionPerformed
        // TODO add your handling code here:
        fieldPesquisa.setForeground(Color.GRAY);
        fieldPesquisa.setText("Pesquisar:");
    }//GEN-LAST:event_buttonXpesqActionPerformed
    //Faz o botão de X para o field "Pesquisar" ficar Azul ao passar o mouse por cima
    private void buttonXpesqMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonXpesqMouseEntered
        // TODO add your handling code here:
        ImageIcon XpesqAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/XAzul.png"));
        buttonXpesq.setIcon(XpesqAzul);
    }//GEN-LAST:event_buttonXpesqMouseEntered
    //Faz o botão de X para o field "Pesquisar" voltar à cor padrão ao tirar o mouse de cima
    private void buttonXpesqMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonXpesqMouseExited
        // TODO add your handling code here:
        ImageIcon Xpesq = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/X.png"));
        buttonXpesq.setIcon(Xpesq);
    }//GEN-LAST:event_buttonXpesqMouseExited
//Fim dos comandos do botão "X" para o field "Pesquisar"
//Fim dos comandos do field "Pesquisar"
    
//---------------------------------------------------------------------------------------------------------------------------------

//Início dos comandos do botão "Sobre"
    //<null>
    private void buttonSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSobreActionPerformed
            try {
                // TODO add your handling code here:
                abrirTela_Sobre();
            } catch (FontFormatException ex) {
                Logger.getLogger(Tela_Carrinho.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Tela_Carrinho.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_buttonSobreActionPerformed
    //Faz o botão Sobre ficar Azul ao passar o mouse por cima
    private void buttonSobreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSobreMouseEntered
        // TODO add your handling code here:
        ImageIcon SobreAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/SobreAzul.png"));
        buttonSobre.setIcon(SobreAzul);
    }//GEN-LAST:event_buttonSobreMouseEntered
    //Faz o botão Sobre voltar à cor padrão ao tirar o mouse de cima
    private void buttonSobreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSobreMouseExited
        // TODO add your handling code here:
        ImageIcon Sobre = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/Sobre.png"));
        buttonSobre.setIcon(Sobre);
    }//GEN-LAST:event_buttonSobreMouseExited
//Fim dos comandos do botão "Sobre"

//---------------------------------------------------------------------------------------------------------------------------------
  
//Início dos comandos do botão "Cursos"
    //<null>
    private void buttonCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCursosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCursosActionPerformed
    //Faz o botão Cursos ficar Azul ao passar o mouse por cima
    private void buttonCursosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCursosMouseEntered
        // TODO add your handling code here:
        ImageIcon CursosAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/CursosAzul.png"));
        buttonCursos.setIcon(CursosAzul);
    }//GEN-LAST:event_buttonCursosMouseEntered
    //Faz o botão Sobre voltar à cor padrão ao tirar o mouse de cima
    private void buttonCursosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCursosMouseExited
        // TODO add your handling code here:
        ImageIcon Cursos = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/Cursos.png"));
        buttonCursos.setIcon(Cursos);
    }//GEN-LAST:event_buttonCursosMouseExited
//Fim dos comandos do botão "Cursos"

//---------------------------------------------------------------------------------------------------------------------------------
 
//Início dos comandos do botão "Cadastrar-se"
    //<null>
    private void buttonCadastrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarseActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_buttonCadastrarseActionPerformed
    //Faz o botão Cadastrar-se ficar Azul ao passar o mouse por cima
    private void buttonCadastrarseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCadastrarseMouseEntered
        // TODO add your handling code here:
        ImageIcon LoginAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/CadastrarseAzul.png"));
        buttonCadastrarse.setIcon(LoginAzul);
    }//GEN-LAST:event_buttonCadastrarseMouseEntered
    //Faz o botão Cadastrar-se voltar à cor padrão ao tirar o mouse de cima
    private void buttonCadastrarseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCadastrarseMouseExited
        // TODO add your handling code here:
        ImageIcon Login = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/Cadastrarse.png"));
        buttonCadastrarse.setIcon(Login);
    }//GEN-LAST:event_buttonCadastrarseMouseExited
//Fim dos comandos do botão "Cadastrar-se"
    
//---------------------------------------------------------------------------------------------------------------------------------

//Início dos comandos do botão "PR"
    //Faz o botão PR ficar Azul ao passar o mouse por cima
    private void buttonPRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPRMouseEntered
        // TODO add your handling code here:
        ImageIcon PRAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/IconSynapseAzul.png"));
        buttonPR.setIcon(PRAzul);
    }//GEN-LAST:event_buttonPRMouseEntered
    //Faz o botão PR voltar à cor padrão ao tirar o mouse de cima
    private void buttonPRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPRMouseExited
        // TODO add your handling code here:
        ImageIcon PR = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/IconSynapsePreto.png"));
        buttonPR.setIcon(PR);
    }//GEN-LAST:event_buttonPRMouseExited
    //<null>
    private void buttonPRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPRActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buttonPRActionPerformed
//Fim dos comandos do botão "PR"
    
//---------------------------------------------------------------------------------------------------------------------------------

//Início dos comandos do botão X para fechar a aplicação
    //Faz com que o botao mude de icone e fique vermelho ao passar o mouse por cima
    private void buttonXTelasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonXTelasMouseEntered
        // TODO add your handling code here:
        ImageIcon XTelasVerm = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/XFecharTelasVerm.png"));
        buttonXTelas.setIcon(XTelasVerm);
    }//GEN-LAST:event_buttonXTelasMouseEntered
    //Faz com que o botao mude de icone e volte a cor padrao ao tirar o mouse de cima
    private void buttonXTelasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonXTelasMouseExited
        // TODO add your handling code here:
        ImageIcon XTelas = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/XFecharTelas.png"));
        buttonXTelas.setIcon(XTelas);
    }//GEN-LAST:event_buttonXTelasMouseExited
    //Fecha a aplicação ao apertar no botao X
    private void buttonXTelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXTelasActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_buttonXTelasActionPerformed
//Fim dos comandos do botão X para fechar a aplicação

//---------------------------------------------------------------------------------------------------------------------------------

//Início dos comandos do botão "Aplicar" na parte de cupom
    //Faz o botão Aplicar ficar Azul ao passar o mouse por cima
    private void buttonAplicarDescMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAplicarDescMouseEntered
        // TODO add your handling code here:
        ImageIcon AplicarDescAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/AplicarDescontoAzul.png"));
        buttonAplicarDesc.setIcon(AplicarDescAzul);
    }//GEN-LAST:event_buttonAplicarDescMouseEntered
    //Faz o botão Aplicar voltar à cor padrão ao tirar o mouse de cima
    private void buttonAplicarDescMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAplicarDescMouseExited
        // TODO add your handling code here:
        ImageIcon AplicarDesc = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/AplicarDesconto.png"));
        buttonAplicarDesc.setIcon(AplicarDesc);
    }//GEN-LAST:event_buttonAplicarDescMouseExited
    //<null>
    private void buttonAplicarDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAplicarDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAplicarDescActionPerformed
//Fim dos comandos do botão "Aplicar" na parte de cupom

//---------------------------------------------------------------------------------------------------------------------------------
    
    //botao teste para adicionar itens ao carrinho
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        produtoCarrinho.addProduto(carrinho, scrollbar);
    }//GEN-LAST:event_jButton1ActionPerformed

//---------------------------------------------------------------------------------------------------------------------------------

//Início dos comandos do botão "Finalizar Compra"
    //<null>
    private void buttonFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFinalizarCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonFinalizarCompraActionPerformed
//Fim dos comandos do botão "Finalizar Compra"
    
//---------------------------------------------------------------------------------------------------------------------------------
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Carrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Carrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Carrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Carrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Tela_Carrinho().setVisible(true);
                } catch (FontFormatException ex) {
                    Logger.getLogger(Tela_Carrinho.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Tela_Carrinho.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAplicarDesc;
    private javax.swing.JButton buttonCadastrarse;
    private javax.swing.JButton buttonCursos;
    private javax.swing.JButton buttonFinalizarCompra;
    private javax.swing.JButton buttonPR;
    private javax.swing.JButton buttonSobre;
    private javax.swing.JButton buttonSynapse;
    private javax.swing.JButton buttonSynapseLogo;
    private javax.swing.JButton buttonXTelas;
    private javax.swing.JButton buttonXpesq;
    private javax.swing.JPanel carrinho;
    private javax.swing.JTextField fieldPesquisa;
    private javax.swing.JLabel fundo;
    private javax.swing.JPanel fundoPrincipal;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelDescontos;
    private javax.swing.JLabel labelQtdCarrinho;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JScrollPane scrollbar;
    // End of variables declaration//GEN-END:variables
}
