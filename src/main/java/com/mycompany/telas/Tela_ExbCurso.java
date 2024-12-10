//@author @pkmelo7

package com.mycompany.telas;

//Importações necessárias
import com.mycompany.classes.Curso;
import com.mycompany.classes.GerenciadorDeCarrinho;
import com.mycompany.classes.GerenciadorDeCategorias;
import com.mycompany.classes.ProdutoCarrinhoJanela;
import com.mycompany.classes.Session;
import com.mycompany.classes.Usuario;
import com.mycompany.scrollbar.ScrollBarCustom;
import static com.mycompany.telas.Tela_Menu.capitalizeFirstLetter;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;
//Fim das importações necessárias

public class Tela_ExbCurso extends javax.swing.JFrame {
    
    Session sessao = new Session();
    
    Curso curso = Session.getCursoSelecionado();
    
     //Variavel para trazer a classe ProdutoCarrinho
    ProdutoCarrinhoJanela produtoCarrinho = new ProdutoCarrinhoJanela();
    
    //Declaração de variáveis
    final int originalX = 10;
    final int targetX = 150;
    final int step = 10;

    Timer timer = new Timer(20, null);
        
    Font poppins;
    GraphicsEnvironment GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
    
    ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/icon.png")); 
    //Final da declaração de variáveis
    
    //Declaração de métodos
    
    private void abrirTelaCarrinho() throws FontFormatException, IOException, SQLException
        {
            Tela_Carrinho Carrinho = new Tela_Carrinho();
            this.dispose();
            Carrinho.setVisible(true);
        }
    
    private void abrirTelaLogin() throws FontFormatException, IOException
        {
            Tela_Login Login = new Tela_Login();
            this.dispose();
            Login.setVisible(true);
        }
    
    private void abrirTelaMenu() throws FontFormatException, IOException, SQLException
        {
            Tela_Menu TelaMenu = new Tela_Menu();
            this.dispose();
            TelaMenu.setVisible(true);
        }
    
    private void abrirTelaCursos() throws FontFormatException, IOException, SQLException
        {
            Tela_Cursos Cursos = new Tela_Cursos();
            this.dispose();
            Cursos.setVisible(true);
        }
    
    //cria o método abrirTela_Sobre, onde invoca a tela de sobre e fecha a tela atual
        private void abrirTelaSobre() throws FontFormatException, IOException, SQLException
        {
            Tela_Sobre Sobre = new Tela_Sobre();
            this.dispose();
            Sobre.setVisible(true);
        }
        
        private void abrirTelaConteudo() throws FontFormatException, IOException, SQLException
        {
            Tela_ExbConteudo Conteudo = new Tela_ExbConteudo();
            this.dispose();
            Conteudo.setVisible(true);
        }
    //Fim da declaração de métodos
        
    public Tela_ExbCurso() throws FontFormatException, IOException, SQLException {
      
        this.poppins = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Poppins-Bold.ttf"));
        initComponents();
        
        // Atualizar painel do carrinho
        GerenciadorDeCarrinho gerenciador = new GerenciadorDeCarrinho();
        try
        {
            gerenciador.listarCarrinhoJanela(carrinho, scrollbarCarrinho, labelQtd, labelFQtd);
        }
        catch(Exception e)
        {
            System.out.println("não foi possivel listar");
        }
        
        scrollbarCarrinho.setVerticalScrollBar(new ScrollBarCustom());

        labelFoto.setBorder(new RoundedBorder(15));
        
        try
        {
            labelFoto.setIcon(new RoundImageIcon(curso.exibirImagemIconCursoExb(curso.getId())));
        }
        catch(Exception e)
        {
            ImageIcon iconDefault = new ImageIcon(getClass().getClassLoader().getResource("images/Formas/fotocursoDefault.png"));
            labelFoto.setIcon(new RoundImageIcon(iconDefault));
        }
        
        Usuario usu = new Usuario();
        int id = curso.getAutorId();
        String nome = usu.getNomePorId(id);
                
        labelAutor.setText("Criado por: "+nome);
        
        textAreaNome.setText(curso.getNome());
        
        textAreaDescricao.setText(curso.getDescricaoporId(curso.getId()));
        
        labelNivel.setText("Nivel: "+curso.getNivel());
        labelTempo.setText("Tempo de Duração: "+curso.getTempo());
        labelCategoria.setText("Categoria: "+curso.getCategoria());
        
        labelValor.setText(curso.getPreco());
        
        Usuario usuario = null;
        
        if(sessao.isUserLoggedIn())
        {   
            labelPerfil.setVisible(true);
            usuario = sessao.getLoggedUser();
            String user = usuario.getUser();
            int idUser = usuario.getIdPorUsuario(user);
            if(user != null)
            {
                String nomeUser = usuario.getPrimeiroNomePorUsuario(user);
                labelPerfil.setText(capitalizeFirstLetter(nomeUser));
                if(usuario.validaAcessoCurso(idUser, curso.getId()))
                {
                    buttonAcessarConteudo.setVisible(true);
                }
                else
                {
                    buttonAddCarrinho.setVisible(true);
                }
            }
        }
        else
        {
            labelPerfil.setVisible(false);
            buttonFazerLogin.setVisible(true);
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

        fundoPrincipal = new javax.swing.JPanel();
        labelQtd = new javax.swing.JLabel();
        labelFQtd = new javax.swing.JLabel();
        panelPerfil = new javax.swing.JPanel();
        buttonMeuPerfil = new javax.swing.JButton();
        buttonMeusCursos = new javax.swing.JButton();
        buttonLogout = new javax.swing.JButton();
        scrollbarCarrinho = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        carrinho = new javax.swing.JPanel();
        buttonCarrinho = new javax.swing.JButton();
        carrinho2 = new javax.swing.JPanel();
        buttonTelaCarrinho = new javax.swing.JButton();
        labelPerfil = new javax.swing.JLabel();
        buttonPerfil = new javax.swing.JButton();
        buttonLogin = new javax.swing.JButton();
        buttonSynapse = new javax.swing.JButton();
        buttonSynapseLogo = new javax.swing.JButton();
        fieldPesquisa = new javax.swing.JTextField();
        buttonXpesq = new javax.swing.JButton();
        buttonSobre = new javax.swing.JButton();
        buttonXTelas = new javax.swing.JButton();
        buttonCursos = new javax.swing.JButton();
        fundoBarraSup = new javax.swing.JLabel();
        buttonPR = new javax.swing.JButton();
        labelFoto = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        textAreaDescricao = new javax.swing.JTextArea();
        textAreaNome = new javax.swing.JTextArea();
        labelAutor = new javax.swing.JLabel();
        labelNivel = new javax.swing.JLabel();
        labelTempo = new javax.swing.JLabel();
        labelCategoria = new javax.swing.JLabel();
        labelValor = new javax.swing.JLabel();
        buttonAcessarConteudo = new javax.swing.JButton();
        buttonFazerLogin = new javax.swing.JButton();
        buttonAddCarrinho = new javax.swing.JButton();
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

        labelQtd.setFont(poppins.deriveFont(15f));
        labelQtd.setForeground(new java.awt.Color(255, 255, 255));
        labelQtd.setVisible(false);
        labelQtd.setHorizontalAlignment(SwingConstants.CENTER);
        fundoPrincipal.add(labelQtd);
        labelQtd.setBounds(890, 49, 19, 23);

        labelFQtd.setForeground(new java.awt.Color(69, 82, 173));
        labelFQtd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Formas/fundoQtd.png"))); // NOI18N
        labelFQtd.setText(" ");
        labelFQtd.setVisible(false);
        fundoPrincipal.add(labelFQtd);
        labelFQtd.setBounds(889, 50, 21, 21);

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

        fundoPrincipal.add(panelPerfil);
        panelPerfil.setBounds(1120, 110, 230, 210);

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

        fundoPrincipal.add(scrollbarCarrinho);
        scrollbarCarrinho.setBounds(767, 105, 230, 245);

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
        fundoPrincipal.add(buttonCarrinho);
        buttonCarrinho.setBounds(855, 62, 50, 30);

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

        fundoPrincipal.add(carrinho2);
        carrinho2.setBounds(767, 345, 230, 55);

        labelPerfil.setBackground(new java.awt.Color(102, 255, 102));
        labelPerfil.setFont(poppins.deriveFont(16f));
        labelPerfil.setForeground(new java.awt.Color(0, 0, 0));
        labelPerfil.setHorizontalAlignment(SwingConstants.CENTER);
        fundoPrincipal.add(labelPerfil);
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
        fundoPrincipal.add(buttonPerfil);
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
        fundoPrincipal.add(buttonLogin);
        buttonLogin.setBounds(1150, 52, 170, 50);

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
        fundoPrincipal.add(labelFoto);
        labelFoto.setBounds(60, 200, 350, 240);

        labelDescricao.setFont(poppins.deriveFont(24f));
        labelDescricao.setForeground(new java.awt.Color(69, 82, 173));
        labelDescricao.setText("Descrição");
        fundoPrincipal.add(labelDescricao);
        labelDescricao.setBounds(440, 300, 130, 40);

        textAreaDescricao.setEditable(false);
        textAreaDescricao.setBackground(new java.awt.Color(255, 255, 255));
        textAreaDescricao.setColumns(20);
        textAreaDescricao.setFont(poppins.deriveFont(18f));
        textAreaDescricao.setForeground(new java.awt.Color(153, 153, 153));
        textAreaDescricao.setLineWrap(true);
        textAreaDescricao.setRows(5);
        textAreaDescricao.setBorder(null);
        textAreaDescricao.setFocusable(false);
        fundoPrincipal.add(textAreaDescricao);
        textAreaDescricao.setBounds(450, 360, 760, 280);

        textAreaNome.setEditable(false);
        textAreaNome.setBackground(new java.awt.Color(255, 255, 255));
        textAreaNome.setColumns(20);
        textAreaNome.setFont(poppins.deriveFont(35f));
        textAreaNome.setForeground(new java.awt.Color(0, 0, 0));
        textAreaNome.setLineWrap(true);
        textAreaNome.setRows(5);
        textAreaNome.setBorder(null);
        textAreaNome.setFocusable(false);
        fundoPrincipal.add(textAreaNome);
        textAreaNome.setBounds(440, 200, 775, 100);

        labelAutor.setFont(poppins.deriveFont(25f));
        fundoPrincipal.add(labelAutor);
        labelAutor.setBounds(60, 450, 350, 40);

        labelNivel.setFont(poppins.deriveFont(25f));
        labelNivel.setForeground(new java.awt.Color(69, 82, 173));
        fundoPrincipal.add(labelNivel);
        labelNivel.setBounds(60, 500, 350, 40);

        labelTempo.setFont(poppins.deriveFont(25f));
        labelTempo.setForeground(new java.awt.Color(69, 82, 173));
        fundoPrincipal.add(labelTempo);
        labelTempo.setBounds(60, 550, 350, 40);

        labelCategoria.setFont(poppins.deriveFont(25f));
        labelCategoria.setForeground(new java.awt.Color(69, 82, 173));
        fundoPrincipal.add(labelCategoria);
        labelCategoria.setBounds(60, 600, 360, 40);

        labelValor.setFont(poppins.deriveFont(50f));
        labelValor.setForeground(new java.awt.Color(0, 0, 0));
        fundoPrincipal.add(labelValor);
        labelValor.setBounds(60, 660, 340, 60);

        buttonAcessarConteudo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        buttonAcessarConteudo.setForeground(new java.awt.Color(255, 255, 255));
        buttonAcessarConteudo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/acessarConteudo.png"))); // NOI18N
        buttonAcessarConteudo.setBorder(null);
        buttonAcessarConteudo.setBorderPainted(false);
        buttonAcessarConteudo.setContentAreaFilled(false);
        buttonAcessarConteudo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAcessarConteudo.setFocusPainted(false);
        buttonAcessarConteudo.setVisible(false);
        buttonAcessarConteudo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAcessarConteudoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAcessarConteudoMouseExited(evt);
            }
        });
        buttonAcessarConteudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAcessarConteudoActionPerformed(evt);
            }
        });
        fundoPrincipal.add(buttonAcessarConteudo);
        buttonAcessarConteudo.setBounds(920, 662, 300, 62);

        buttonFazerLogin.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        buttonFazerLogin.setForeground(new java.awt.Color(255, 255, 255));
        buttonFazerLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/acessoLogin.png"))); // NOI18N
        buttonFazerLogin.setBorder(null);
        buttonFazerLogin.setBorderPainted(false);
        buttonFazerLogin.setContentAreaFilled(false);
        buttonFazerLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonFazerLogin.setFocusPainted(false);
        buttonFazerLogin.setVisible(false);
        buttonFazerLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonFazerLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonFazerLoginMouseExited(evt);
            }
        });
        buttonFazerLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFazerLoginActionPerformed(evt);
            }
        });
        fundoPrincipal.add(buttonFazerLogin);
        buttonFazerLogin.setBounds(920, 662, 300, 62);

        buttonAddCarrinho.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        buttonAddCarrinho.setForeground(new java.awt.Color(255, 255, 255));
        buttonAddCarrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/addCarrinho.png"))); // NOI18N
        buttonAddCarrinho.setBorder(null);
        buttonAddCarrinho.setBorderPainted(false);
        buttonAddCarrinho.setContentAreaFilled(false);
        buttonAddCarrinho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAddCarrinho.setFocusPainted(false);
        buttonAddCarrinho.setVisible(false);
        buttonAddCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAddCarrinhoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAddCarrinhoMouseExited(evt);
            }
        });
        buttonAddCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddCarrinhoActionPerformed(evt);
            }
        });
        fundoPrincipal.add(buttonAddCarrinho);
        buttonAddCarrinho.setBounds(920, 662, 300, 62);

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FundosTelas/ExbCurso.png"))); // NOI18N
        fundoPrincipal.add(fundo);
        fundo.setBounds(0, 0, 1366, 768);

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
            Logger.getLogger(Tela_ExbCurso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tela_ExbCurso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_ExbCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            // TODO add your handling code here:
            abrirTelaSobre();
        } catch (FontFormatException ex) {
            Logger.getLogger(Tela_ExbCurso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tela_ExbCurso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_ExbCurso.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Tela_ExbCurso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tela_ExbCurso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_ExbCurso.class.getName()).log(Level.SEVERE, null, ex);
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

    private void buttonAddCarrinhoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddCarrinhoMouseEntered
        // TODO add your handling code here:
        ImageIcon addCarrinhoAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/addCarrinhoAzul.png"));
        buttonAddCarrinho.setIcon(addCarrinhoAzul);
    }//GEN-LAST:event_buttonAddCarrinhoMouseEntered

    private void buttonAddCarrinhoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddCarrinhoMouseExited
        // TODO add your handling code here:
        ImageIcon addCarrinho = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/addCarrinho.png"));
        buttonAddCarrinho.setIcon(addCarrinho);
    }//GEN-LAST:event_buttonAddCarrinhoMouseExited

    private void buttonAddCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddCarrinhoActionPerformed
        // TODO add your handling code here:
        try {
        if (curso != null) {
            Session.adicionarAoCarrinho(curso.getId());
            System.out.println("Curso adicionado ao carrinho: " + curso.getNome());
            
            // Atualizar painel do carrinho
            GerenciadorDeCarrinho gerenciador = new GerenciadorDeCarrinho();
            gerenciador.listarCarrinhoJanela(carrinho, scrollbarCarrinho, labelQtd, labelFQtd);
        } else {
            System.out.println("Nenhum curso selecionado.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }//GEN-LAST:event_buttonAddCarrinhoActionPerformed

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
        }   catch (SQLException ex) {
            Logger.getLogger(Tela_Menu.class.getName()).log(Level.SEVERE, null, ex);
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

    private void buttonLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLoginMouseEntered
        // TODO add your handling code here:
        ImageIcon LoginAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/LoginAzul.png"));
        buttonLogin.setIcon(LoginAzul);
    }//GEN-LAST:event_buttonLoginMouseEntered

    private void buttonLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLoginMouseExited
        // TODO add your handling code here:
        ImageIcon Login = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/Login.png"));
        buttonLogin.setIcon(Login);
    }//GEN-LAST:event_buttonLoginMouseExited

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

    private void buttonMeuPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMeuPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonMeuPerfilActionPerformed

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

    private void buttonMeusCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMeusCursosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonMeusCursosActionPerformed

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
        buttonAcessarConteudo.setVisible(false);
        buttonAddCarrinho.setVisible(false);
        buttonFazerLogin.setVisible(true);
    }//GEN-LAST:event_buttonLogoutActionPerformed

    private void buttonFazerLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonFazerLoginMouseEntered
        // TODO add your handling code here:
        ImageIcon FazLoginAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/acessoLoginAzul.png"));
        buttonFazerLogin.setIcon(FazLoginAzul);
    }//GEN-LAST:event_buttonFazerLoginMouseEntered

    private void buttonFazerLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonFazerLoginMouseExited
        // TODO add your handling code here:
        ImageIcon FazLogin = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/acessoLogin.png"));
        buttonFazerLogin.setIcon(FazLogin);
    }//GEN-LAST:event_buttonFazerLoginMouseExited

    private void buttonFazerLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFazerLoginActionPerformed
        try {
            // TODO add your handling code here:
            abrirTelaLogin();
        } catch (FontFormatException ex) {
            Logger.getLogger(Tela_ExbCurso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tela_ExbCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonFazerLoginActionPerformed

    private void buttonAcessarConteudoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAcessarConteudoMouseEntered
        // TODO add your handling code here:
        ImageIcon AcessarConteudoAzul = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/acessarConteudoAzul.png"));
        buttonAcessarConteudo.setIcon(AcessarConteudoAzul);
    }//GEN-LAST:event_buttonAcessarConteudoMouseEntered

    private void buttonAcessarConteudoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAcessarConteudoMouseExited
        // TODO add your handling code here:
        ImageIcon AcessarConteudo = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/acessarConteudo.png"));
        buttonAcessarConteudo.setIcon(AcessarConteudo);
    }//GEN-LAST:event_buttonAcessarConteudoMouseExited

    private void buttonAcessarConteudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAcessarConteudoActionPerformed
        try {
            // TODO add your handling code here:
            abrirTelaConteudo();
                    } catch (FontFormatException ex) {
            Logger.getLogger(Tela_ExbCurso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tela_ExbCurso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_ExbCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAcessarConteudoActionPerformed
//Fim dos comandos do botão "Cadastrar-se"
      
//---------------------------------------------------------------------------------------------------------------------------------

    static class RoundImageIcon implements Icon {
        private Image image;

        public RoundImageIcon(ImageIcon imageIcon) {
            this.image = imageIcon.getImage();
        }

        @Override
        public int getIconWidth() {
            return 350; // Largura do ícone, deve ser igual ao tamanho do botão
        }

        @Override
        public int getIconHeight() {
            return 240; // Altura do ícone, deve ser igual ao tamanho do botão
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            // Criando um objeto Graphics2D para pintar a imagem
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Criando uma máscara arredondada (corte da imagem)
            Shape clip = new RoundRectangle2D.Float(0, y, getIconWidth(), getIconHeight(), 15, 15); // Raio de 30
            g2.setClip(clip);

            // Desenhando a imagem dentro da forma arredondada
            g2.drawImage(image, 0, y, getIconWidth(), getIconHeight(), null);

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
            g2.drawRoundRect(0, y, width - 1, height - 1, radius, radius); // Desenhando o retângulo com bordas arredondadas
        }
    }
    
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
            java.util.logging.Logger.getLogger(Tela_ExbCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_ExbCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_ExbCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_ExbCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                    new Tela_ExbCurso().setVisible(true);
                } catch (FontFormatException ex) {
                    Logger.getLogger(Tela_ExbCurso.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Tela_ExbCurso.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Tela_ExbCurso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAcessarConteudo;
    private javax.swing.JButton buttonAddCarrinho;
    private javax.swing.JButton buttonCarrinho;
    private javax.swing.JButton buttonCursos;
    private javax.swing.JButton buttonFazerLogin;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JButton buttonLogout;
    private javax.swing.JButton buttonMeuPerfil;
    private javax.swing.JButton buttonMeusCursos;
    private javax.swing.JButton buttonPR;
    private javax.swing.JButton buttonPerfil;
    private javax.swing.JButton buttonSobre;
    private javax.swing.JButton buttonSynapse;
    private javax.swing.JButton buttonSynapseLogo;
    private javax.swing.JButton buttonTelaCarrinho;
    private javax.swing.JButton buttonXTelas;
    private javax.swing.JButton buttonXpesq;
    private javax.swing.JPanel carrinho;
    private javax.swing.JPanel carrinho2;
    private javax.swing.JTextField fieldPesquisa;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel fundoBarraSup;
    private javax.swing.JPanel fundoPrincipal;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelAutor;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelFQtd;
    private javax.swing.JLabel labelFoto;
    private javax.swing.JLabel labelNivel;
    private javax.swing.JLabel labelPerfil;
    private javax.swing.JLabel labelQtd;
    private javax.swing.JLabel labelTempo;
    private javax.swing.JLabel labelValor;
    private javax.swing.JPanel panelPerfil;
    private javax.swing.JScrollPane scrollbarCarrinho;
    private javax.swing.JTextArea textAreaDescricao;
    private javax.swing.JTextArea textAreaNome;
    // End of variables declaration//GEN-END:variables
}
