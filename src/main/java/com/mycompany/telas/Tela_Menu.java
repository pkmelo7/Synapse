//@author @pkmelo7

package com.mycompany.telas;

//Importações necessárias
import com.mycompany.classes.FontePersonalizada;
import com.mycompany.classes.GerenciadorDeCategorias;
import com.mycompany.classes.ProdutoCarrinhoJanela;
import com.mycompany.classes.Session;
import com.mycompany.classes.Usuario;
import com.mycompany.scrollbar.ScrollBarCustom;
import com.mycompany.scrollbar.ScrollBarCustom_Cursos;
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
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;
//Fim das importações necessárias

public class Tela_Menu extends javax.swing.JFrame {
    
    //Declaração de variáveis
        Session sessao = new Session();        
    
        //Variáveis para o movimento do logo Synapse
        final int originalX = 10;
        final int targetX = 150;
        final int step = 10;
        Timer timer = new Timer(20, null);
    
        //Variável para determinar se o checkbox que torna a senha visivel esta ativo ou nao
        boolean showing = false;
    
        //Variaveis para configurar a fonte como poppins
        Font poppins;
        GraphicsEnvironment GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        //Variavel para trazer o icone do projeto
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/icon.png"));
        
        //Variavel para trazer a classe ProdutoCarrinho
        ProdutoCarrinhoJanela produtoCarrinho = new ProdutoCarrinhoJanela();

    //Final da declaração de variáveis
        
    //Declaração de métodos
        //cria o método abrirTela_Carrinho, onde invoca a tela de carrinho e fecha a tela atual
        private void abrirTelaCarrinho() throws FontFormatException, IOException
        {
            Tela_Carrinho Carrinho = new Tela_Carrinho();
            this.dispose();
            Carrinho.setVisible(true);
        }
        //cria o método abrirTela_Sobre, onde invoca a tela de sobre e fecha a tela atual
        private void abrirTelaSobre() throws FontFormatException, IOException
        {
            Tela_Sobre Sobre = new Tela_Sobre();
            this.dispose();
            Sobre.setVisible(true);
        }
        //cria o método abrirTela_Login, onde invoca a tela de login e fecha a tela atual
        private void abrirTelaLogin() throws FontFormatException, IOException
        {
            Tela_Login Login = new Tela_Login();
            this.dispose();
            Login.setVisible(true);
        }
        
        private void abrirTelaCursos() throws FontFormatException, IOException, SQLException
        {
            Tela_Cursos Cursos = new Tela_Cursos();
            this.dispose();
            Cursos.setVisible(true);
        }
        
        public static String capitalizeFirstLetter(String text) 
        {
            if (text == null || text.isEmpty()) 
            {
                return text; // Retorna o texto original se for nulo ou vazio
            }
            return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
        }

    //Fim da declaração de métodos
        
    public Tela_Menu() throws FontFormatException, IOException, SQLException {
        //cria a fonte poppins no projeto
        this.poppins = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Poppins-Bold.ttf"));
        initComponents(); 
        
        Session.outCursoSelecionado();
        
        //Configurar scrollbar vertical como customizada
        scrollbar.setVerticalScrollBar(new ScrollBarCustom());
        scrollbarCarrinho.setVerticalScrollBar(new ScrollBarCustom()); 
        
        FontePersonalizada fp = new FontePersonalizada();
        fp.carregarFonte();
        
        ScrollBarCustom_Cursos sb = new ScrollBarCustom_Cursos();
        sb.setOrientation(JScrollBar.HORIZONTAL);
        scrollDispCursos.setHorizontalScrollBar(sb);
        
        ScrollBarCustom_Cursos sb2 = new ScrollBarCustom_Cursos();
        sb2.setOrientation(JScrollBar.HORIZONTAL);
        scrollDispCursos1.setHorizontalScrollBar(sb2);
        
        String cat1 = categoria1.getText();
        String cat2 = categoria2.getText();
        
        GerenciadorDeCategorias gerenciador = new GerenciadorDeCategorias();
        gerenciador.listarCursosPorCategoria(this, cat1, panelDispCursos1, scrollDispCursos1);
        
        GerenciadorDeCategorias gerenciador2 = new GerenciadorDeCategorias();
        gerenciador2.listarCursosPorCategoria(this, cat2, panelDispCursos, scrollDispCursos);
        
        Usuario usu = null;
        
        if(sessao.isUserLoggedIn())
        {   
            labelPerfil.setVisible(true);
            usu = sessao.getLoggedUser();
            String user = usu.getUser();
            if(user != null)
            {
                String nomeUser = usu.getPrimeiroNomePorUsuario(user);
                labelPerfil.setText(capitalizeFirstLetter(nomeUser));
            }
        }
        else
        {
            labelPerfil.setVisible(false);
        }
    }
        
        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPerfil = new javax.swing.JPanel();
        buttonMeuPerfil = new javax.swing.JButton();
        buttonMeusCursos = new javax.swing.JButton();
        buttonLogout = new javax.swing.JButton();
        buttonSynapse = new javax.swing.JButton();
        buttonSynapseLogo = new javax.swing.JButton();
        fieldPesquisa = new javax.swing.JTextField();
        buttonXpesq = new javax.swing.JButton();
        buttonSobre = new javax.swing.JButton();
        buttonXTelas = new javax.swing.JButton();
        buttonCursos = new javax.swing.JButton();
        scrollbarCarrinho = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        carrinho = new javax.swing.JPanel();
        carrinho2 = new javax.swing.JPanel();
        buttonTelaCarrinho = new javax.swing.JButton();
        labelPerfil = new javax.swing.JLabel();
        buttonPerfil = new javax.swing.JButton();
        buttonLogin = new javax.swing.JButton();
        buttonCarrinho = new javax.swing.JButton();
        fundoBarraSup = new javax.swing.JLabel();
        buttonPR = new javax.swing.JButton();
        labelQtdCarrinho = new javax.swing.JLabel();
        scrollbar = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        buttonSeta = new javax.swing.JButton();
        categoria1 = new javax.swing.JLabel();
        scrollDispCursos1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        panelDispCursos1 = new javax.swing.JPanel();
        scrollDispCursos = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        panelDispCursos = new javax.swing.JPanel();
        categoria2 = new javax.swing.JLabel();
        barra = new javax.swing.JLabel();
        fundo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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

        panelPerfil.setBackground(new java.awt.Color(255, 255, 255));
        panelPerfil.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 82, 173), 1, true));
        panelPerfil.setVisible(false);
        panelPerfil.setLayout(null);

        buttonMeuPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/MeuPerfil.png"))); // NOI18N
        buttonMeuPerfil.setBorder(null);
        buttonMeuPerfil.setBorderPainted(false);
        buttonMeuPerfil.setContentAreaFilled(false);
        buttonMeuPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonMeuPerfil.setFocusPainted(false);
        buttonMeuPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonMeuPerfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonMeuPerfilMouseExited(evt);
            }
        });
        buttonMeuPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMeuPerfilActionPerformed(evt);
            }
        });
        panelPerfil.add(buttonMeuPerfil);
        buttonMeuPerfil.setBounds(10, 13, 210, 40);

        buttonMeusCursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/MeusCursos.png"))); // NOI18N
        buttonMeusCursos.setBorder(null);
        buttonMeusCursos.setBorderPainted(false);
        buttonMeusCursos.setContentAreaFilled(false);
        buttonMeusCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonMeusCursos.setFocusPainted(false);
        buttonMeusCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonMeusCursosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonMeusCursosMouseExited(evt);
            }
        });
        buttonMeusCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMeusCursosActionPerformed(evt);
            }
        });
        panelPerfil.add(buttonMeusCursos);
        buttonMeusCursos.setBounds(10, 60, 210, 40);

        buttonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/Logout.png"))); // NOI18N
        buttonLogout.setBorder(null);
        buttonLogout.setBorderPainted(false);
        buttonLogout.setContentAreaFilled(false);
        buttonLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonLogout.setFocusPainted(false);
        buttonLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonLogoutMouseExited(evt);
            }
        });
        buttonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogoutActionPerformed(evt);
            }
        });
        panelPerfil.add(buttonLogout);
        buttonLogout.setBounds(10, 107, 210, 40);

        getContentPane().add(panelPerfil);
        panelPerfil.setBounds(1120, 110, 230, 210);

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
        getContentPane().add(buttonSynapse);
        buttonSynapse.setBounds(30, 0, 260, 160);

        buttonSynapseLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/IconSynapse.png"))); // NOI18N
        buttonSynapseLogo.setBorder(null);
        buttonSynapseLogo.setBorderPainted(false);
        buttonSynapseLogo.setContentAreaFilled(false);
        buttonSynapseLogo.setFocusPainted(false);
        getContentPane().add(buttonSynapseLogo);
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
        getContentPane().add(fieldPesquisa);
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
        getContentPane().add(buttonXpesq);
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
        getContentPane().add(buttonSobre);
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
        getContentPane().add(buttonXTelas);
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
        getContentPane().add(buttonCursos);
        buttonCursos.setBounds(1030, 62, 100, 30);

        scrollbarCarrinho.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 82, 173), 2, true));
        scrollbarCarrinho.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollbarCarrinho.setVisible(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(carrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1651, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(carrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 419, Short.MAX_VALUE))
        );

        scrollbarCarrinho.setViewportView(jPanel2);

        getContentPane().add(scrollbarCarrinho);
        scrollbarCarrinho.setBounds(767, 105, 230, 245);

        carrinho2.setBackground(new java.awt.Color(255, 255, 255));
        carrinho2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(69, 82, 173), 1, true));
        carrinho2.setVisible(false);
        carrinho2.setLayout(null);

        buttonTelaCarrinho.setFont(poppins.deriveFont(24f));
        buttonTelaCarrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/Carrinho.png"))); // NOI18N
        buttonTelaCarrinho.setBorder(null);
        buttonTelaCarrinho.setBorderPainted(false);
        buttonTelaCarrinho.setContentAreaFilled(false);
        buttonTelaCarrinho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonTelaCarrinho.setFocusPainted(false);
        buttonTelaCarrinho.setMaximumSize(new java.awt.Dimension(86, 19));
        buttonTelaCarrinho.setMinimumSize(new java.awt.Dimension(86, 19));
        buttonTelaCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonTelaCarrinhoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonTelaCarrinhoMouseExited(evt);
            }
        });
        buttonTelaCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTelaCarrinhoActionPerformed(evt);
            }
        });
        carrinho2.add(buttonTelaCarrinho);
        buttonTelaCarrinho.setBounds(15, 10, 200, 40);

        getContentPane().add(carrinho2);
        carrinho2.setBounds(767, 345, 230, 55);

        labelPerfil.setBackground(new java.awt.Color(102, 255, 102));
        labelPerfil.setFont(poppins.deriveFont(16f));
        labelPerfil.setForeground(new java.awt.Color(0, 0, 0));
        labelPerfil.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(labelPerfil);
        labelPerfil.setBounds(1190, 58, 110, 37);

        buttonPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/Conta.png"))); // NOI18N
        buttonPerfil.setBorder(null);
        buttonPerfil.setBorderPainted(false);
        buttonPerfil.setContentAreaFilled(false);
        buttonPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonPerfil.setFocusPainted(false);
        buttonPerfil.setMaximumSize(new java.awt.Dimension(86, 19));
        buttonPerfil.setMinimumSize(new java.awt.Dimension(86, 19));
        if(sessao.isUserLoggedIn())
        {
            buttonPerfil.setVisible(true);
        }
        else
        {
            buttonPerfil.setVisible(false);
        }
        buttonPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonPerfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonPerfilMouseExited(evt);
            }
        });
        buttonPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPerfilActionPerformed(evt);
            }
        });
        getContentPane().add(buttonPerfil);
        buttonPerfil.setBounds(1150, 52, 170, 50);

        buttonLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/Login.png"))); // NOI18N
        buttonLogin.setBorder(null);
        buttonLogin.setBorderPainted(false);
        buttonLogin.setContentAreaFilled(false);
        buttonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonLogin.setFocusPainted(false);
        buttonLogin.setMaximumSize(new java.awt.Dimension(86, 19));
        buttonLogin.setMinimumSize(new java.awt.Dimension(86, 19));
        if(sessao.isUserLoggedIn())
        {
            buttonLogin.setVisible(false);
        }
        else
        {
            buttonLogin.setVisible(true);
        }
        buttonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonLoginMouseExited(evt);
            }
        });
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(buttonLogin);
        buttonLogin.setBounds(1150, 52, 170, 50);

        buttonCarrinho.setFont(poppins.deriveFont(24f));
        buttonCarrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/Sacola.png"))); // NOI18N
        buttonCarrinho.setBorder(null);
        buttonCarrinho.setBorderPainted(false);
        buttonCarrinho.setContentAreaFilled(false);
        buttonCarrinho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonCarrinho.setFocusPainted(false);
        buttonCarrinho.setMaximumSize(new java.awt.Dimension(86, 19));
        buttonCarrinho.setMinimumSize(new java.awt.Dimension(86, 19));
        if(sessao.isUserLoggedIn())
        {
            buttonCarrinho.setVisible(true);
        }
        else
        {
            buttonCarrinho.setVisible(false);
        }
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
        getContentPane().add(buttonCarrinho);
        buttonCarrinho.setBounds(855, 62, 50, 30);

        fundoBarraSup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Formas/FundoBarraSup.png"))); // NOI18N
        getContentPane().add(fundoBarraSup);
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
        getContentPane().add(buttonPR);
        buttonPR.setBounds(1270, 658, 80, 70);

        labelQtdCarrinho.setFont(poppins.deriveFont(15f));
        labelQtdCarrinho.setForeground(new java.awt.Color(69, 82, 173));
        produtoCarrinho.setLabel(labelQtdCarrinho);
        getContentPane().add(labelQtdCarrinho);
        labelQtdCarrinho.setBounds(883, 50, 20, 20);

        scrollbar.setBorder(null);
        scrollbar.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollbar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menu.setLayout(null);

        buttonSeta.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        buttonSeta.setForeground(new java.awt.Color(255, 255, 255));
        buttonSeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/SetaMenu.png"))); // NOI18N
        buttonSeta.setBorder(null);
        buttonSeta.setBorderPainted(false);
        buttonSeta.setContentAreaFilled(false);
        buttonSeta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonSeta.setFocusPainted(false);
        buttonSeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonSetaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonSetaMouseExited(evt);
            }
        });
        buttonSeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSetaActionPerformed(evt);
            }
        });
        menu.add(buttonSeta);
        buttonSeta.setBounds(940, 1300, 320, 90);

        categoria1.setFont(poppins.deriveFont(40f));
        categoria1.setForeground(new java.awt.Color(255, 255, 255));
        categoria1.setText("Java");
        menu.add(categoria1);
        categoria1.setBounds(30, 525, 1300, 40);

        scrollDispCursos1.setBorder(null);
        scrollDispCursos1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollDispCursos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scrollDispCursos1.setVisible(false);

        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panelDispCursos1.setBackground(new java.awt.Color(69, 82, 173));
        panelDispCursos1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panelDispCursos1Layout = new javax.swing.GroupLayout(panelDispCursos1);
        panelDispCursos1.setLayout(panelDispCursos1Layout);
        panelDispCursos1Layout.setHorizontalGroup(
            panelDispCursos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1377, Short.MAX_VALUE)
        );
        panelDispCursos1Layout.setVerticalGroup(
            panelDispCursos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(panelDispCursos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDispCursos1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        scrollDispCursos1.setViewportView(jPanel3);

        menu.add(scrollDispCursos1);
        scrollDispCursos1.setBounds(0, 570, 1366, 300);

        scrollDispCursos.setBorder(null);
        scrollDispCursos.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollDispCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scrollDispCursos.setVisible(false);

        jPanel5.setBackground(new java.awt.Color(69, 82, 173));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panelDispCursos.setBackground(new java.awt.Color(69, 82, 173));
        panelDispCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panelDispCursosLayout = new javax.swing.GroupLayout(panelDispCursos);
        panelDispCursos.setLayout(panelDispCursosLayout);
        panelDispCursosLayout.setHorizontalGroup(
            panelDispCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1378, Short.MAX_VALUE)
        );
        panelDispCursosLayout.setVerticalGroup(
            panelDispCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(panelDispCursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDispCursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        scrollDispCursos.setViewportView(jPanel5);

        menu.add(scrollDispCursos);
        scrollDispCursos.setBounds(0, 950, 1366, 300);

        categoria2.setFont(poppins.deriveFont(40f));
        categoria2.setForeground(new java.awt.Color(255, 255, 255));
        categoria2.setText("Python");
        menu.add(categoria2);
        categoria2.setBounds(30, 905, 1300, 40);

        barra.setBackground(new java.awt.Color(255, 255, 255));
        barra.setOpaque(true);
        menu.add(barra);
        barra.setBounds(0, 886, 1366, 2);

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FundosTelas/FundoMenu.png"))); // NOI18N
        fundo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menu.add(fundo);
        fundo.setBounds(0, 0, 1366, 1450);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1450, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 1450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        scrollbar.setViewportView(jPanel1);

        getContentPane().add(scrollbar);
        scrollbar.setBounds(0, 160, 1366, 610);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TelasCompletas/Default.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1366, 190);

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
        try {
            abrirTelaSobre();
        } catch (FontFormatException ex) {
            Logger.getLogger(Tela_Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tela_Menu.class.getName()).log(Level.SEVERE, null, ex);
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
            try {
                // TODO add your handling code here:
                abrirTelaCursos();
            } catch (FontFormatException ex) {
                Logger.getLogger(Tela_Menu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Tela_Menu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Tela_Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
            // TODO add your handling code here:
        try {
            abrirTelaLogin();
        } catch (FontFormatException ex) {
            Logger.getLogger(Tela_Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tela_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonLoginActionPerformed
    //Faz o botão Cadastrar-se ficar Azul ao passar o mouse por cima
    private void buttonLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLoginMouseEntered
        // TODO add your handling code here:
        ImageIcon LoginAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/LoginAzul.png"));
        buttonLogin.setIcon(LoginAzul);
    }//GEN-LAST:event_buttonLoginMouseEntered
    //Faz o botão Cadastrar-se voltar à cor padrão ao tirar o mouse de cima
    private void buttonLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLoginMouseExited
        // TODO add your handling code here:
        ImageIcon Login = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/Login.png"));
        buttonLogin.setIcon(Login);
    }//GEN-LAST:event_buttonLoginMouseExited
//Fim dos comandos do botão "Cadastrar-se"

//---------------------------------------------------------------------------------------------------------------------------------

//Início dos comandos do botão "P&R"
    //<null>    
    private void buttonPRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPRMouseEntered
        // TODO add your handling code here:
        ImageIcon PRAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/IconSynapseAzul.png"));
        buttonPR.setIcon(PRAzul);
    }//GEN-LAST:event_buttonPRMouseEntered
    //Faz o botão P&R ficar Azul ao passar o mouse por cima
    private void buttonPRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPRMouseExited
        // TODO add your handling code here:
        ImageIcon PR = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/IconSynapsePreto.png"));
        buttonPR.setIcon(PR);
    }//GEN-LAST:event_buttonPRMouseExited
    //Faz o botão P&R voltar a cor padrão ao tirar o mouse de cima
    private void buttonPRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPRActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buttonPRActionPerformed
    //Fim dos comandos do botão "P&R"

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

//Inicio dos comandos do botão "Carrinho"
    //Faz o botão Carrinho ficar Azul ao passar o mouse por cima
    private void buttonCarrinhoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCarrinhoMouseEntered
        // TODO add your handling code here:
        ImageIcon SobreAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/SacolaAzul.png"));
        buttonCarrinho.setIcon(SobreAzul);
    }//GEN-LAST:event_buttonCarrinhoMouseEntered
    //Faz com que o botao mude de icone e volte a cor padrao ao tirar o mouse de cima
    private void buttonCarrinhoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCarrinhoMouseExited
        // TODO add your handling code here:
        ImageIcon Sobre = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/Sacola.png"));
        buttonCarrinho.setIcon(Sobre);
    }//GEN-LAST:event_buttonCarrinhoMouseExited
    //Abre a tela de Carrinho
    private void buttonCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCarrinhoActionPerformed
            // TODO add your handling code here:
        if(scrollbarCarrinho.isVisible())
        {
            scrollbarCarrinho.setVisible(false);
            carrinho2.setVisible(false);
        }
        else
        {
            scrollbarCarrinho.setVisible(true);
            carrinho2.setVisible(true);
        }
    }//GEN-LAST:event_buttonCarrinhoActionPerformed
//Fim dos comandos do botão "Carrinho"
    
//---------------------------------------------------------------------------------------------------------------------------------

//Inicio dos comandos do botão "Seta"/"Cursos"
    //Faz o botão Seta mudar de icone e aparecer a mensagem "Cursos" ao passar o mouse por cima
    private void buttonSetaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSetaMouseEntered
        // TODO add your handling code here:
        ImageIcon SetaCursos = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/SetaCursos.png"));
        buttonSeta.setIcon(SetaCursos);
    }//GEN-LAST:event_buttonSetaMouseEntered
    //Faz o botão Seta mudar de icone e voltar o simbolo de seta ao tirar o mouse de cima
    private void buttonSetaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSetaMouseExited
        // TODO add your handling code here:
        ImageIcon SetaMenu = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/SetaMenu.png"));
        buttonSeta.setIcon(SetaMenu);
    }//GEN-LAST:event_buttonSetaMouseExited
    //<null>
    private void buttonSetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSetaActionPerformed
            try {
                // TODO add your handling code here:
                abrirTelaCursos();
            } catch (FontFormatException ex) {
                Logger.getLogger(Tela_Menu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Tela_Menu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Tela_Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_buttonSetaActionPerformed

    private void buttonTelaCarrinhoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonTelaCarrinhoMouseEntered
        // TODO add your handling code here:
        ImageIcon CarrinhoAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/CarrinhoAzul.png"));
        buttonTelaCarrinho.setIcon(CarrinhoAzul);
    }//GEN-LAST:event_buttonTelaCarrinhoMouseEntered

    private void buttonTelaCarrinhoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonTelaCarrinhoMouseExited
        // TODO add your handling code here:
        ImageIcon Carrinho = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/Carrinho.png"));
        buttonTelaCarrinho.setIcon(Carrinho);
    }//GEN-LAST:event_buttonTelaCarrinhoMouseExited

    private void buttonTelaCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTelaCarrinhoActionPerformed
        try {
            // TODO add your handling code here:
            abrirTelaCarrinho();
        } catch (FontFormatException ex) {
            Logger.getLogger(Tela_Sobre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tela_Sobre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonTelaCarrinhoActionPerformed

    private void buttonPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPerfilMouseEntered
        // TODO add your handling code here:
        ImageIcon PerfilAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/ContaAzul.png"));
        buttonPerfil.setIcon(PerfilAzul);
        labelPerfil.setForeground(new Color(69,82,173));
    }//GEN-LAST:event_buttonPerfilMouseEntered

    private void buttonPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPerfilMouseExited
        // TODO add your handling code here:
        ImageIcon PerfilAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/Conta.png"));
        buttonPerfil.setIcon(PerfilAzul);
        labelPerfil.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_buttonPerfilMouseExited

    private void buttonPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPerfilActionPerformed
        if(panelPerfil.isVisible())
        {
            panelPerfil.setVisible(false);
        }
        else
        {
            panelPerfil.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonPerfilActionPerformed

    private void buttonMeuPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMeuPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonMeuPerfilActionPerformed

    private void buttonMeuPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMeuPerfilMouseEntered
        // TODO add your handling code here:
        ImageIcon PerfilAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/MeuPerfilAzul.png"));
        buttonMeuPerfil.setIcon(PerfilAzul);
    }//GEN-LAST:event_buttonMeuPerfilMouseEntered

    private void buttonMeuPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMeuPerfilMouseExited
        // TODO add your handling code here:
        ImageIcon Perfil = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/MeuPerfil.png"));
        buttonMeuPerfil.setIcon(Perfil);
    }//GEN-LAST:event_buttonMeuPerfilMouseExited

    private void buttonMeusCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMeusCursosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonMeusCursosActionPerformed

    private void buttonMeusCursosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMeusCursosMouseEntered
        // TODO add your handling code here:
        ImageIcon MeusCursosAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/MeusCursosAzul.png"));
        buttonMeusCursos.setIcon(MeusCursosAzul);
    }//GEN-LAST:event_buttonMeusCursosMouseEntered

    private void buttonMeusCursosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMeusCursosMouseExited
        // TODO add your handling code here:
        ImageIcon MeusCursos = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/MeusCursos.png"));
        buttonMeusCursos.setIcon(MeusCursos);
    }//GEN-LAST:event_buttonMeusCursosMouseExited

    private void buttonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogoutActionPerformed
        // TODO add your handling code here:
        Session.logout(); 
        buttonCarrinho.setVisible(false);
        buttonPerfil.setVisible(false);
        buttonLogin.setVisible(true);
        labelPerfil.setVisible(false);
        scrollbarCarrinho.setVisible(false);
        panelPerfil.setVisible(false);
        carrinho2.setVisible(false);
    }//GEN-LAST:event_buttonLogoutActionPerformed

    private void buttonLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLogoutMouseEntered
        // TODO add your handling code here:
        ImageIcon LogoutAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/LogoutAzul.png"));
        buttonLogout.setIcon(LogoutAzul);
    }//GEN-LAST:event_buttonLogoutMouseEntered

    private void buttonLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLogoutMouseExited
        // TODO add your handling code here:
        ImageIcon Logout = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/Logout.png"));
        buttonLogout.setIcon(Logout);
    }//GEN-LAST:event_buttonLogoutMouseExited
//Inicio dos comandos do botão "Seta"/"Cursos" 
    
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
            java.util.logging.Logger.getLogger(Tela_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Tela_Menu().setVisible(true);
                } catch (FontFormatException ex) {
                    Logger.getLogger(Tela_Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Tela_Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Tela_Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barra;
    private javax.swing.JButton buttonCarrinho;
    private javax.swing.JButton buttonCursos;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JButton buttonLogout;
    private javax.swing.JButton buttonMeuPerfil;
    private javax.swing.JButton buttonMeusCursos;
    private javax.swing.JButton buttonPR;
    private javax.swing.JButton buttonPerfil;
    private javax.swing.JButton buttonSeta;
    private javax.swing.JButton buttonSobre;
    private javax.swing.JButton buttonSynapse;
    private javax.swing.JButton buttonSynapseLogo;
    private javax.swing.JButton buttonTelaCarrinho;
    private javax.swing.JButton buttonXTelas;
    private javax.swing.JButton buttonXpesq;
    private javax.swing.JPanel carrinho;
    private javax.swing.JPanel carrinho2;
    private javax.swing.JLabel categoria1;
    private javax.swing.JLabel categoria2;
    private javax.swing.JTextField fieldPesquisa;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel fundoBarraSup;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel labelPerfil;
    private javax.swing.JLabel labelQtdCarrinho;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel panelDispCursos;
    private javax.swing.JPanel panelDispCursos1;
    private javax.swing.JPanel panelPerfil;
    private javax.swing.JScrollPane scrollDispCursos;
    private javax.swing.JScrollPane scrollDispCursos1;
    private javax.swing.JScrollPane scrollbar;
    private javax.swing.JScrollPane scrollbarCarrinho;
    // End of variables declaration//GEN-END:variables
}
