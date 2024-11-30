//@author @pkmelo7

package com.mycompany.telas;

//Importações necessárias
import com.mycompany.classes.ProdutoCarrinhoJanela;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;
//Fim das importações necessárias

public class Tela_Padrao extends javax.swing.JFrame {
    
    //Declaração de variáveis
    final int originalX = 10;
    final int targetX = 150;
    final int step = 10;

    Timer timer = new Timer(20, null);
    
    boolean showing = false;
    
    Font poppins;
    GraphicsEnvironment GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
    
    ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/icon.png")); 
    Tela_Login Tela_Login = new Tela_Login();
    Tela_Cadastro Tela_Cadastro = new Tela_Cadastro();
    //Final da declaração de variáveis
    Tela_Sobre Tela_Sobre;
    
    //Declaração de métodos
    
    //Fim da declaração de métodos
        
    public Tela_Padrao() throws FontFormatException, IOException, SQLException {
        this.Tela_Sobre = new Tela_Sobre();
      
        this.poppins = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Poppins-Bold.ttf"));
        initComponents();        }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fundoPrincipal = new javax.swing.JPanel();
        scrollbar = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        carrinho = new javax.swing.JPanel();
        buttonSynapse = new javax.swing.JButton();
        buttonSynapseLogo = new javax.swing.JButton();
        fieldPesquisa = new javax.swing.JTextField();
        buttonXpesq = new javax.swing.JButton();
        buttonSobre = new javax.swing.JButton();
        buttonXTelas = new javax.swing.JButton();
        buttonCursos = new javax.swing.JButton();
        buttonCadastrarse = new javax.swing.JButton();
        buttonCarrinho = new javax.swing.JButton();
        fundoBarraSup = new javax.swing.JLabel();
        buttonPR = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Synapse Connect");
        setBackground(new java.awt.Color(224, 222, 222));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setIconImage(icon.getImage());
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 750));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        fundoPrincipal.setBackground(new java.awt.Color(224, 222, 222));
        fundoPrincipal.setForeground(new java.awt.Color(224, 222, 222));
        fundoPrincipal.setLayout(null);

        scrollbar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 82, 173), 2, true));
        scrollbar.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        carrinho.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout carrinhoLayout = new javax.swing.GroupLayout(carrinho);
        carrinho.setLayout(carrinhoLayout);
        carrinhoLayout.setHorizontalGroup(
            carrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        carrinhoLayout.setVerticalGroup(
            carrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(carrinho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(carrinho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        scrollbar.setViewportView(jPanel1);

        fundoPrincipal.add(scrollbar);
        scrollbar.setBounds(767, 105, 230, 245);

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

        buttonCarrinho.setFont(poppins.deriveFont(24f));
        buttonCarrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/Sacola.png"))); // NOI18N
        buttonCarrinho.setBorder(null);
        buttonCarrinho.setBorderPainted(false);
        buttonCarrinho.setContentAreaFilled(false);
        buttonCarrinho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonCarrinho.setFocusPainted(false);
        buttonCarrinho.setMaximumSize(new java.awt.Dimension(86, 19));
        buttonCarrinho.setMinimumSize(new java.awt.Dimension(86, 19));
        buttonCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCarrinhoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCarrinhoMouseExited(evt);
            }
        });
        buttonCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCarrinhoActionPerformed(evt);
            }
        });
        fundoPrincipal.add(buttonCarrinho);
        buttonCarrinho.setBounds(855, 62, 50, 30);

        fundoBarraSup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Formas/FundoBarraSup.png"))); // NOI18N
        fundoPrincipal.add(fundoBarraSup);
        fundoBarraSup.setBounds(0, 0, 1366, 164);

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

        jButton1.setText("ADD PRODUTO CARRINHO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        fundoPrincipal.add(jButton1);
        jButton1.setBounds(1010, 390, 220, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TelasCompletas/Janelas.png"))); // NOI18N
        fundoPrincipal.add(jLabel1);
        jLabel1.setBounds(0, 0, 1366, 768);

        getContentPane().add(fundoPrincipal);
        fundoPrincipal.setBounds(0, 0, 1366, 768);

        setBounds(-6, 0, 1366, 768);
    }// </editor-fold>//GEN-END:initComponents
//---------------------------------------------------------------------------------------------------------------------------------
    
//Início dos comandos do botão do Logo "Synapse Connect"
    //<null>
    private void buttonSynapseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSynapseActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buttonSynapseActionPerformed
    //Move o Logo "Synapse Connect" à posição final enquanto o mouse estiver em cima
    private void buttonSynapseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSynapseMouseEntered
        // TODO add your handling code here:
        timer.stop();
        timer = new Timer(20, new ActionListener() {
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
        // TODO add your handling code here:
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

    private void buttonPRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPRMouseEntered
        // TODO add your handling code here:
        ImageIcon PRAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/IconSynapseAzul.png"));
        buttonPR.setIcon(PRAzul);
    }//GEN-LAST:event_buttonPRMouseEntered

    private void buttonPRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPRMouseExited
        // TODO add your handling code here:
        ImageIcon PR = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/IconSynapsePreto.png"));
        buttonPR.setIcon(PR);
    }//GEN-LAST:event_buttonPRMouseExited

    private void buttonPRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPRActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buttonPRActionPerformed

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        // TODO add your handling code here:
        Tela_Login.setAlwaysOnTop(false);
        Tela_Login.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_formWindowIconified

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if ((evt.getKeyCode() == KeyEvent.VK_TAB) && (evt.isAltDown())) 
        {
            evt.consume();
        }
    }//GEN-LAST:event_formKeyPressed

    private void buttonXTelasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonXTelasMouseEntered
        // TODO add your handling code here:
        ImageIcon XTelasVerm = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/XFecharTelasVerm.png"));
        buttonXTelas.setIcon(XTelasVerm);
    }//GEN-LAST:event_buttonXTelasMouseEntered

    private void buttonXTelasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonXTelasMouseExited
        // TODO add your handling code here:
        ImageIcon XTelas = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/XFecharTelas.png"));
        buttonXTelas.setIcon(XTelas);
    }//GEN-LAST:event_buttonXTelasMouseExited

    private void buttonXTelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXTelasActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_buttonXTelasActionPerformed

    private void buttonCarrinhoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCarrinhoMouseEntered
        // TODO add your handling code here:
        ImageIcon SobreAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/SacolaAzul.png"));
        buttonCarrinho.setIcon(SobreAzul);
    }//GEN-LAST:event_buttonCarrinhoMouseEntered

    private void buttonCarrinhoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCarrinhoMouseExited
        // TODO add your handling code here:
        ImageIcon Sobre = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/Sacola.png"));
        buttonCarrinho.setIcon(Sobre);
    }//GEN-LAST:event_buttonCarrinhoMouseExited

    private void buttonCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCarrinhoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buttonCarrinhoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ProdutoCarrinhoJanela pcj = new ProdutoCarrinhoJanela();
        pcj.addProduto(carrinho, scrollbar);
    }//GEN-LAST:event_jButton1ActionPerformed
//Fim dos comandos do botão "Cadastrar-se"
      
//---------------------------------------------------------------------------------------------------------------------------------

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
            java.util.logging.Logger.getLogger(Tela_Padrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Padrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Padrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Padrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Tela_Padrao().setVisible(true);
                } catch (FontFormatException ex) {
                    Logger.getLogger(Tela_Padrao.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Tela_Padrao.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Tela_Padrao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCadastrarse;
    private javax.swing.JButton buttonCarrinho;
    private javax.swing.JButton buttonCursos;
    private javax.swing.JButton buttonPR;
    private javax.swing.JButton buttonSobre;
    private javax.swing.JButton buttonSynapse;
    private javax.swing.JButton buttonSynapseLogo;
    private javax.swing.JButton buttonXTelas;
    private javax.swing.JButton buttonXpesq;
    private javax.swing.JPanel carrinho;
    private javax.swing.JTextField fieldPesquisa;
    private javax.swing.JLabel fundoBarraSup;
    private javax.swing.JPanel fundoPrincipal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollbar;
    // End of variables declaration//GEN-END:variables
}
