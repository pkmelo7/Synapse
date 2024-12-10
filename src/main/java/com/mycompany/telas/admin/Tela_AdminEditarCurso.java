//@author @pkmelo7

package com.mycompany.telas.admin;

//Importações necessárias
import com.mycompany.classes.Admin;
import com.mycompany.classes.Curso;
import com.mycompany.classes.Session;
import com.mycompany.classes.Usuario;
import com.mycompany.scrollbar.ScrollBarCustom_Admin;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MaskFormatter;
//Fim das importações necessárias

public class Tela_AdminEditarCurso extends javax.swing.JFrame {
    
    //Declaração de variáveis         
        
        //variavel para uso da fonte digital7
        Font digital7;
        GraphicsEnvironment GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
         //Variaveis para configurar a fonte como poppins
        Font poppins;
        
        //Variavel para trazer o icone do projeto
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/icon.png")); 
        
        Usuario usuario = new Usuario();
        Admin adm = new Admin();
        
        String user;
        
        MaskFormatter maskTempo;
        MaskFormatter maskValor;
        
       Timer timerAlerta;
        
        boolean cadastrado = false;
        
        boolean acaoConcluida = false;
    //Final da declaração de variáveis
    
    //Declaração de métodos
        
        public void abrirTelaAnterior() throws FontFormatException, IOException, SQLException
        {
            Tela_AdminCrudCursos TelaAnterior = new Tela_AdminCrudCursos();
            TelaAnterior.setVisible(true);
            this.dispose();
        }
   
        
    //Fim da declaração de métodos
        
    public Tela_AdminEditarCurso() throws FontFormatException, IOException, SQLException {
        Curso c = Session.listarCursoporId();
        //cria as fontes do projeto
        this.poppins = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Poppins-Bold.ttf"));
        this.digital7 = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/digital-7.ttf"));
        initComponents();
        
        fieldNome.setText(c.getNome());
        
        Usuario usu = new Usuario();
        int id = c.getAutorId();

        String user = usu.getUserPorId(id);
        fieldIdAutor.setText(user);
        labelIdAutor.setVisible(false);
        fieldIdAutor.setForeground(new Color(0,178,6));
        
        fieldTempo.setText(c.getTempo());
        labelTempo.setVisible(false);
        fieldTempo.setFormatterFactory(new DefaultFormatterFactory(null));
        fieldTempo.setForeground(new Color(0,178,6));
        
        fieldValor.setText(c.getPreco());
        labelValor.setVisible(false);
        fieldValor.setForeground(new Color(0,178,6));
        
        fieldNivel.setText(c.getNivel());
        
        fieldCategoria.setText(c.getCategoria());
        
        String desc = c.getDescricaoporId(c.getId());
        
        textAreaDescricao.setText(desc);
        
        textAreaDescricao.repaint();
        textAreaDescricao.revalidate();
        textAreaDescricao.setVisible(true);
        scrollDescricao.setVisible(true);
        
        buttonXTelas.repaint();
        buttonXTelas.revalidate();
        
        scrollDescricao.setVerticalScrollBar(new ScrollBarCustom_Admin());
        
        configurarCampoAutor();
        
        String tempo = c.getTempo();
        
        try
        {
            if(!fieldTempo.getText().equals(tempo))
            {
            try
            {
                maskTempo = new MaskFormatter("##.##'h'");
                maskTempo.setPlaceholderCharacter('_');
                fieldTempo.setFormatterFactory(new DefaultFormatterFactory(maskTempo));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
            ((AbstractDocument) textAreaDescricao.getDocument()).setDocumentFilter(new DocumentFilter() {
            private final int LIMITE = 500; // Limite máximo de caracteres

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + string.length() <= LIMITE) {
                    super.insertString(fb, offset, string, attr);
                } else {
                    Toolkit.getDefaultToolkit().beep(); // Opcional: emite um som de aviso
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (fb.getDocument().getLength() - length + text.length() <= LIMITE) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    Toolkit.getDefaultToolkit().beep(); // Opcional: emite um som de aviso
                }
            }
        });
            
            int limiteCaracteres = 500;
            
            textAreaDescricao.getDocument().addDocumentListener(new DocumentListener() 
            {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    atualizarContador();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    atualizarContador();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    atualizarContador();
                }

                private void atualizarContador() 
                {
                    int caracteresDigitados = textAreaDescricao.getText().length();
                    contadorLabel.setText(caracteresDigitados + "/" + limiteCaracteres);
                }
            });

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAlerta = new javax.swing.JPanel();
        panelAlerta2 = new javax.swing.JPanel();
        labelAlerta = new javax.swing.JLabel();
        buttonOkAlerta = new javax.swing.JButton();
        labelContagem = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        buttonXTelas = new javax.swing.JButton();
        messageLabel1 = new javax.swing.JLabel();
        telaAdmin = new javax.swing.JPanel();
        buttonVoltar = new javax.swing.JButton();
        buttonCadastrar = new javax.swing.JButton();
        fieldNome = new javax.swing.JTextField();
        labelIdAutor = new javax.swing.JLabel();
        fieldIdAutor = new javax.swing.JFormattedTextField();
        labelTxtIdAutor = new javax.swing.JLabel();
        labelValor = new javax.swing.JLabel();
        fieldValor = new javax.swing.JFormattedTextField();
        labelTempo = new javax.swing.JLabel();
        fieldTempo = new javax.swing.JFormattedTextField();
        fieldNivel = new javax.swing.JTextField();
        fieldCategoria = new javax.swing.JTextField();
        contadorLabel = new javax.swing.JLabel();
        scrollDescricao = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        textAreaDescricao = new javax.swing.JTextArea();
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

        panelAlerta.setOpaque(false);
        panelAlerta.setVisible(false);
        panelAlerta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAlertaMouseClicked(evt);
            }
        });
        panelAlerta.setLayout(null);

        panelAlerta2.setBackground(new java.awt.Color(0, 0, 0));
        panelAlerta2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 8), 1, true));
        panelAlerta2.setForeground(new java.awt.Color(0, 255, 8));
        panelAlerta2.setLayout(null);

        labelAlerta.setFont(digital7.deriveFont(23f));
        labelAlerta.setForeground(new java.awt.Color(0, 255, 8));
        labelAlerta.setHorizontalAlignment(SwingConstants.CENTER);
        panelAlerta2.add(labelAlerta);
        labelAlerta.setBounds(7, 66, 490, 110);

        buttonOkAlerta.setBackground(new java.awt.Color(0, 0, 0));
        buttonOkAlerta.setFont(digital7.deriveFont(20f));
        buttonOkAlerta.setForeground(new java.awt.Color(0, 255, 8));
        buttonOkAlerta.setText("OK");
        buttonOkAlerta.setBorder(null);
        buttonOkAlerta.setBorderPainted(false);
        buttonOkAlerta.setContentAreaFilled(false);
        buttonOkAlerta.setFocusable(false);
        buttonOkAlerta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonOkAlertaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonOkAlertaMouseExited(evt);
            }
        });
        panelAlerta2.add(buttonOkAlerta);
        buttonOkAlerta.setBounds(355, 210, 100, 40);

        labelContagem.setBackground(new java.awt.Color(0, 0, 0));
        labelContagem.setFont(digital7.deriveFont(20f));
        labelContagem.setForeground(new java.awt.Color(0, 255, 8));
        labelContagem.setText("Tempo Restante: 5");
        labelContagem.setHorizontalAlignment(SwingConstants.RIGHT);
        panelAlerta2.add(labelContagem);
        labelContagem.setBounds(87, 210, 260, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FundosTelas/janelaAlertaAdmin.png"))); // NOI18N
        panelAlerta2.add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 281);

        panelAlerta.add(panelAlerta2);
        panelAlerta2.setBounds(433, 243, 500, 281);

        getContentPane().add(panelAlerta);
        panelAlerta.setBounds(0, 0, 1366, 768);

        panel.setBackground(new java.awt.Color(0, 0, 0));
        panel.setLayout(null);

        buttonXTelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/XFecharTelasAdmin.png"))); // NOI18N
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
        panel.add(buttonXTelas);
        buttonXTelas.setBounds(1280, 0, 86, 25);

        messageLabel1.setBackground(new java.awt.Color(0, 0, 0));
        messageLabel1.setFont(digital7.deriveFont(100f));
        messageLabel1.setForeground(new java.awt.Color(0, 255, 8));
        messageLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        messageLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel1.setVerticalAlignment(SwingConstants.TOP);
        String message = "Edicao de cursos";
        typingEffect(messageLabel1, message, buttonVoltar, telaAdmin);
        panel.add(messageLabel1);
        messageLabel1.setBounds(0, 0, 1366, 120);

        telaAdmin.setBackground(new java.awt.Color(0, 0, 0));
        telaAdmin.setForeground(new java.awt.Color(0, 0, 0));
        telaAdmin.setVisible(false);
        telaAdmin.setLayout(null);

        buttonVoltar.setBackground(new java.awt.Color(0, 0, 0));
        buttonVoltar.setFont(digital7.deriveFont(50f));
        buttonVoltar.setForeground(new java.awt.Color(0, 255, 8));
        buttonVoltar.setBorder(null);
        buttonVoltar.setBorderPainted(false);
        buttonVoltar.setContentAreaFilled(false);
        buttonVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonVoltar.setFocusPainted(false);
        buttonVoltar.setHorizontalAlignment(SwingConstants.LEFT);
        buttonVoltar.setVisible(false);
        buttonVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonVoltarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonVoltarMouseExited(evt);
            }
        });
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt);
            }
        });
        telaAdmin.add(buttonVoltar);
        buttonVoltar.setBounds(16, 700, 240, 60);

        buttonCadastrar.setBackground(new java.awt.Color(0, 0, 0));
        buttonCadastrar.setFont(digital7.deriveFont(75f));
        buttonCadastrar.setForeground(new java.awt.Color(0, 255, 8));
        buttonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/prosseguirAdm.png"))); // NOI18N
        buttonCadastrar.setBorder(null);
        buttonCadastrar.setBorderPainted(false);
        buttonCadastrar.setContentAreaFilled(false);
        buttonCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonCadastrar.setFocusPainted(false);
        buttonCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCadastrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCadastrarMouseExited(evt);
            }
        });
        buttonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarActionPerformed(evt);
            }
        });
        telaAdmin.add(buttonCadastrar);
        buttonCadastrar.setBounds(1044, 675, 200, 70);

        fieldNome.setBackground(new java.awt.Color(0, 0, 0));
        fieldNome.setFont(poppins.deriveFont(20f));
        fieldNome.setForeground(new java.awt.Color(0, 178, 6));
        fieldNome.setText("Nome do Curso");
        fieldNome.setBorder(null);
        fieldNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldNomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldNomeFocusLost(evt);
            }
        });
        telaAdmin.add(fieldNome);
        fieldNome.setBounds(190, 127, 1030, 50);

        labelIdAutor.setBackground(new java.awt.Color(0, 0, 0));
        labelIdAutor.setFont(poppins.deriveFont(20f));
        labelIdAutor.setForeground(new java.awt.Color(0, 178, 6));
        labelIdAutor.setText("User do Autor");
        labelIdAutor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        labelIdAutor.setOpaque(true);
        telaAdmin.add(labelIdAutor);
        labelIdAutor.setBounds(190, 208, 160, 50);

        fieldIdAutor.setBackground(new java.awt.Color(0, 0, 0));
        fieldIdAutor.setBorder(null);
        fieldIdAutor.setForeground(new java.awt.Color(0, 255, 8));
        fieldIdAutor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldIdAutor.setFont(poppins.deriveFont(18f));
        fieldIdAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIdAutorActionPerformed(evt);
            }
        });
        telaAdmin.add(fieldIdAutor);
        fieldIdAutor.setBounds(190, 208, 160, 50);
        telaAdmin.add(labelTxtIdAutor);
        labelTxtIdAutor.setBounds(170, 270, 210, 15);

        labelValor.setBackground(new java.awt.Color(0, 0, 0));
        labelValor.setFont(poppins.deriveFont(18f));
        labelValor.setForeground(new java.awt.Color(0, 178, 6));
        labelValor.setText("Valor");
        labelValor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        labelValor.setOpaque(true);
        telaAdmin.add(labelValor);
        labelValor.setBounds(1000, 208, 220, 50);

        fieldValor.setBackground(new java.awt.Color(0, 0, 0));
        fieldValor.setBorder(null);
        fieldValor.setForeground(new java.awt.Color(0, 255, 8));
        fieldValor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldValor.setToolTipText("");
        fieldValor.setFont(poppins.deriveFont(18f));
        fieldValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldValorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldValorFocusLost(evt);
            }
        });
        telaAdmin.add(fieldValor);
        fieldValor.setBounds(1000, 208, 220, 50);

        labelTempo.setBackground(new java.awt.Color(0, 0, 0));
        labelTempo.setFont(poppins.deriveFont(20f));
        labelTempo.setForeground(new java.awt.Color(0, 178, 6));
        labelTempo.setText("Tempo Total do Curso");
        labelTempo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        labelTempo.setOpaque(true);
        telaAdmin.add(labelTempo);
        labelTempo.setBounds(540, 208, 320, 50);

        fieldTempo.setBackground(new java.awt.Color(0, 0, 0));
        fieldTempo.setBorder(null);
        fieldTempo.setForeground(new java.awt.Color(0, 255, 8));
        fieldTempo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldTempo.setToolTipText("");
        fieldTempo.setFont(poppins.deriveFont(18f));
        fieldTempo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldTempoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldTempoFocusLost(evt);
            }
        });
        telaAdmin.add(fieldTempo);
        fieldTempo.setBounds(540, 208, 320, 50);

        fieldNivel.setBackground(new java.awt.Color(0, 0, 0));
        fieldNivel.setFont(poppins.deriveFont(18f));
        fieldNivel.setForeground(new java.awt.Color(0, 178, 6));
        fieldNivel.setText("Nivel do Curso");
        fieldNivel.setBorder(null);
        fieldNivel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldNivelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldNivelFocusLost(evt);
            }
        });
        telaAdmin.add(fieldNivel);
        fieldNivel.setBounds(190, 297, 450, 50);

        fieldCategoria.setBackground(new java.awt.Color(0, 0, 0));
        fieldCategoria.setFont(poppins.deriveFont(18f));
        fieldCategoria.setForeground(new java.awt.Color(0, 178, 6));
        fieldCategoria.setText("Categoria do Curso");
        fieldCategoria.setBorder(null);
        fieldCategoria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldCategoriaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldCategoriaFocusLost(evt);
            }
        });
        telaAdmin.add(fieldCategoria);
        fieldCategoria.setBounds(750, 297, 470, 50);

        contadorLabel.setForeground(new java.awt.Color(204, 204, 204));
        contadorLabel.setText("0/500");
        telaAdmin.add(contadorLabel);
        contadorLabel.setBounds(1245, 540, 110, 20);

        scrollDescricao.setBackground(new java.awt.Color(0, 0, 0));
        scrollDescricao.setBorder(null);
        scrollDescricao.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        textAreaDescricao.setBackground(new java.awt.Color(0, 0, 0));
        textAreaDescricao.setColumns(20);
        textAreaDescricao.setFont(poppins.deriveFont(18f));
        textAreaDescricao.setForeground(new java.awt.Color(0, 178, 6));
        textAreaDescricao.setRows(5);
        textAreaDescricao.setText("Descrição (opcional)");
        textAreaDescricao.setBorder(null);
        textAreaDescricao.setLineWrap(true);
        textAreaDescricao.setEditable(true);
        textAreaDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textAreaDescricaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textAreaDescricaoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textAreaDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textAreaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        scrollDescricao.setViewportView(jPanel1);

        telaAdmin.add(scrollDescricao);
        scrollDescricao.setBounds(182, 392, 1040, 240);

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FundosTelas/FundoCadastrarCurso2.png"))); // NOI18N
        telaAdmin.add(fundo);
        fundo.setBounds(0, 0, 1366, 768);

        panel.add(telaAdmin);
        telaAdmin.setBounds(0, 0, 1366, 768);

        getContentPane().add(panel);
        panel.setBounds(0, 0, 1366, 768);

        setBounds(-6, 0, 1366, 768);
    }// </editor-fold>//GEN-END:initComponents
//---------------------------------------------------------------------------------------------------------------------------------

//Inicio dos comandos do botao Cursos
    //altera o texto pra frente ao passar o mouse por cima do botao
    private void buttonCadastrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCadastrarMouseEntered
        // TODO add your handling code here:
        ImageIcon prosseguir2 = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/prosseguirAdm2.png"));
        buttonCadastrar.setIcon(prosseguir2);
    }//GEN-LAST:event_buttonCadastrarMouseEntered
    //altera o texto de volta para a posicao padrao ao tirar o mouse de cima do botao
    private void buttonCadastrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCadastrarMouseExited
        // TODO add your handling code here:
        ImageIcon prosseguir = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/prosseguirAdm.png"));
        buttonCadastrar.setIcon(prosseguir);
    }//GEN-LAST:event_buttonCadastrarMouseExited
    //<null>
    private void buttonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        // Obter os valores dos campos
        String nome = null;
        int autorId = 0;
        String tempo = null;
        String nivel = null;
        String preco = null;
        String categoria = null;
        String descricao = null;
        
        if(fieldNome.getText().equals("Nome do Curso") || fieldNome.getText().equals(""))
        {
            labelAlerta.setText("Nome vazio, por favor preencha.");
            mensagemErro();
        }
        else
        {
            nome = fieldNome.getText();
        }
        
        
        
        autorId = 0;
            try {
                autorId = usuario.getIdPorUsuario(user);
            } catch (SQLException ex) {
                labelAlerta.setText("Autor invalido, tente novamente.");
                mensagemErro();
                Logger.getLogger(Tela_AdminCadastrarCurso.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        if(fieldTempo.getText().equals("") || labelTempo.isVisible())
        {
            labelAlerta.setText("Tempo vazio, por favor preencha.");
            mensagemErro();
        }
        else
        {
            if (!validarTempo(fieldTempo.getText())) 
            {
                labelAlerta.setText("Tempo invalido, tente novamente.");
                mensagemErro();
            }
            else
            {
               tempo = fieldTempo.getText();
            }
        }
        
        if(fieldNivel.getText().equals("Nivel do Curso") || fieldNivel.getText().equals(""))
        {
            labelAlerta.setText("Nivel vazio, por favor preencha.");
            mensagemErro();
        }
        else
        {
            nivel = fieldNivel.getText();
        }
        
        if(fieldValor.getText().equals("") || labelValor.isVisible())
        {
            labelAlerta.setText("Valor vazio, por favor preencha.");
            mensagemErro();
        }
        else
        {
            if (!validarValor(fieldValor.getText())) 
            {
                labelAlerta.setText("Valor invalido, tente novamente.");
                mensagemErro();
            }
            else
            {
               preco = fieldValor.getText();
            }
        }
             
        if(fieldCategoria.getText().equals("Categoria do Curso") || fieldCategoria.getText().equals(""))
        {
            labelAlerta.setText("Categoria vazia, por favor preencha.");
            mensagemErro();
        }
        else
        {
            categoria = fieldCategoria.getText();
        }
        
        if(textAreaDescricao.getText().equals("Descrição (opcional)") || textAreaDescricao.getText().equals(""))
        {
            labelAlerta.setText("Descricao vazia, por favor preencha.");
            mensagemErro();
        }
        else
        {
            descricao = textAreaDescricao.getText();
        }
        
        System.out.println(descricao);
        System.out.println(nome);
        System.out.println(autorId);
        System.out.println(tempo);
        System.out.println(nivel);
        System.out.println(preco);
        System.out.println(categoria);
 
        Curso c = null;
            try {
                c = Session.listarCursoporId();
            } catch (SQLException ex) {
                labelAlerta.setText("Não foi possivel listar pelo ID.");
                mensagemErro();
                Logger.getLogger(Tela_AdminEditarCurso.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        int idCurso = c.getId();
        System.out.println("id do Curso = "+idCurso);
                
            try {
                c.atualizaCurso(idCurso, nome, autorId, tempo, nivel, preco, categoria, descricao);
                cadastrado = true;
                labelAlerta.setText("Curso atualizado com sucesso.");
                mensagemErro();
            } catch (SQLException ex) {
                labelAlerta.setText("Não foi possivel atualizar o curso.");
                mensagemErro();
                Logger.getLogger(Tela_AdminEditarCurso.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_buttonCadastrarActionPerformed

    
    private void mensagemErro()
    {        
         // Garantir que o painel esteja visível após a exclusão
        panelAlerta.setVisible(true);

        // Revalide o layout para garantir que o painel seja renderizado corretamente
        panelAlerta.revalidate();
        panelAlerta.repaint();

        // Definir tempo inicial da contagem regressiva
        final int tempoInicial = 5;
        final int[] tempoRestante = {tempoInicial}; // Usamos um array para poder alterar o valor dentro do Timer

        // **Cancelar o Timer anterior, se houver** (importante para a segunda, terceira exclusão, etc.)
        if (timerAlerta != null && timerAlerta.isRunning()) 
        {
            timerAlerta.stop();  // Para o Timer atual, se já estiver em execução
        }

        // Criar o Timer para a contagem regressiva
        timerAlerta = new Timer(1000, new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                // Atualiza o texto da contagem regressiva
                if (tempoRestante[0] > 0) 
                {
                    tempoRestante[0]--;
                    labelContagem.setText("Tempo restante: " + tempoRestante[0]);
                } 
                else
                {
                    // Quando a contagem chega a 0, reinicia o tempo
                    tempoRestante[0] = tempoInicial; // Reinicia para 5 segundos
                    labelContagem.setText("Tempo restante: " + tempoRestante[0]);

                    // Esconde o painel após a contagem
                    panelAlerta.setVisible(false);

                    // Para o Timer
                    timerAlerta.stop();

                    acaoConcluida = true;
                    
                    if(cadastrado != false)
                    {
                        
                    }
                    else
                    {
                        System.out.println("usuario nao cadastrado");
                    }
                }
            }
        });

        // Inicia o Timer de contagem regressiva
        timerAlerta.start();

        // Ação do botão "OK" para fechar o painel antes do tempo
        buttonOkAlerta.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                // Para o Timer imediatamente
                if (timerAlerta != null) 
                {
                    timerAlerta.stop();
                }

                // Esconde o painel imediatamente
                panelAlerta.setVisible(false);

                acaoConcluida = true;
                
                if(cadastrado != false)
                    {
                  
                    }
                else
                {
                    System.out.println("usuario nao cadastrado");
                }

                // Opcional: Resetar a contagem se necessário (reiniciar a contagem para o próximo uso)
                tempoRestante[0] = tempoInicial; // Reinicia a contagem
                labelContagem.setText("Tempo restante: " + tempoRestante[0]);
            }
        });
    }
    
    private void limparCampos() 
    {
        fieldNome.setText("Nome do Curso");
        fieldNome.setForeground(new Color(0,178,6));
        
        fieldTempo.setText("");
        labelTempo.setVisible(true);
        
        fieldValor.setText("");
        labelValor.setVisible(true);
        
        fieldIdAutor.setText("");
        fieldIdAutor.setVisible(true);
        labelIdAutor.setVisible(true);

        
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/FundosTelas/FundoCadastrarCurso2.png"));
        fundo.setIcon(icon);
        
        fieldNivel.setText("Nivel do Curso");
        fieldNivel.setForeground(new Color(0,178,6));
        
        fieldCategoria.setText("Categoria do Curso");
        fieldCategoria.setForeground(new Color(0,178,6));
        
        textAreaDescricao.setText("Descrição (opcional)");
        textAreaDescricao.setForeground(new Color(0,178,6));
    }
    
    public boolean validarTempo(String entrada) {
    // Expressão regular para o formato "00.00h" até "99.99h"
    String regex = "\\d{2}\\.\\d{2}h";
    
    // Verifica se o texto corresponde ao padrão
    if (entrada.matches(regex)) {
        try {
            // Extrai as partes antes e depois do ponto
            String[] partes = entrada.substring(0, 5).split("\\.");
            int parteInteira = Integer.parseInt(partes[0]);
            int parteDecimal = Integer.parseInt(partes[1]);

            // Valida se as partes estão no intervalo de 00 a 99
            if (parteInteira >= 0 && parteInteira <= 99 && parteDecimal >= 0 && parteDecimal <= 99) {
                return true; // Formato válido
            }
        } catch (NumberFormatException e) {
            return false; // Caso ocorra erro ao converter para números
        }
    }
    return false; // Não está no formato correto
}
    
    public boolean validarValor(String valor) {
    // Expressão regular para o formato "R$00000,00"
    String regex = "R\\$\\d{1,5},\\d{2}";

    // Verifica se o texto corresponde ao padrão
    if (valor.matches(regex)) {
        try {
            // Remove o "R$" e substitui a vírgula por ponto para facilitar a conversão
            String valorNumerico = valor.replace("R$", "").replace(",", ".");
            double numero = Double.parseDouble(valorNumerico);

            // Valida se o número está no intervalo de 0.00 a 99999.99
            if (numero >= 0 && numero <= 99999.99) {
                return true; // Valor válido
            }
        } catch (NumberFormatException e) {
            return false; // Caso ocorra erro ao converter para número
        }
    }
    return false; // Não está no formato correto
}

//Fim dos comandos do botao Cursos

//---------------------------------------------------------------------------------------------------------------------------------


    private void buttonVoltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVoltarMouseEntered
        // TODO add your handling code here:
        if(buttonVoltar.getText().equals("<-- Voltar"))
            buttonVoltar.setText("<--  Voltar");
    }//GEN-LAST:event_buttonVoltarMouseEntered

    private void buttonVoltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVoltarMouseExited
        // TODO add your handling code here:
        if (buttonVoltar.getText().equals("<--  Voltar"))
            buttonVoltar.setText("<-- Voltar");
    }//GEN-LAST:event_buttonVoltarMouseExited

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed
            try {
                // TODO add your handling code here:
                abrirTelaAnterior();
            } catch (FontFormatException ex) {
                Logger.getLogger(Tela_AdminEditarCurso.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Tela_AdminEditarCurso.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Tela_AdminEditarCurso.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_buttonVoltarActionPerformed

    private void fieldNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNomeFocusGained
        // TODO add your handling code here:
        if (fieldNome.getText().equals("Nome do Curso")) {
            fieldNome.setText("");
            fieldNome.setForeground(new Color(0,255,8));
        }
    }//GEN-LAST:event_fieldNomeFocusGained

    private void fieldNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNomeFocusLost
        // TODO add your handling code here:
        if (fieldNome.getText().isEmpty()) {
            fieldNome.setForeground(new Color(0,178,6));
            fieldNome.setText("Nome do Curso");
        }
    }//GEN-LAST:event_fieldNomeFocusLost
     
    private void configurarCampoAutor() {
       // Adicionar um ouvinte de foco para limpar e restaurar o texto de placeholder
        fieldIdAutor.addFocusListener(new FocusListener() 
        {
            public void focusGained(FocusEvent e) 
            {
                // Quando o campo recebe foco, limpar o texto (se for o placeholder)
                if (labelIdAutor.isVisible()) 
                {
                    fieldIdAutor.setText("");
                    labelIdAutor.setVisible(false);
                    fieldIdAutor.setForeground(new Color(0, 255, 8)); // Cor verde, por exemplo
                }
            }

            public void focusLost(FocusEvent e) 
            {
                if (fieldIdAutor.getText().isEmpty()) 
                {
                    labelTxtIdAutor.setText("");
                    labelIdAutor.setVisible(true);
                }
                else
                {  
                    String usu = fieldIdAutor.getText();
                    Usuario verifUsu = new Usuario();
                    verifUsu.setUser(usu);
                    System.out.println(verifUsu.getUser());
                    try 
                    {
                        if(verifUsu.verificaUserExiste())
                        {
                            labelTxtIdAutor.setText("*Usuario válido");
                            labelTxtIdAutor.setForeground(new Color(0,255,8));
                            user = fieldIdAutor.getText();
                        }
                        else
                        {
                            labelTxtIdAutor.setText("*Usuario não encontrado");
                            labelTxtIdAutor.setForeground(Color.red);
                        }
                    } 
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(Tela_AdminEditarCurso.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
    private void fieldTempoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldTempoFocusGained
        // TODO add your handling code here:
        labelTempo.setVisible(false);
    }//GEN-LAST:event_fieldTempoFocusGained

    private void fieldTempoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldTempoFocusLost
        // TODO add your handling code here:
        String data = fieldTempo.getText();
        
        if (fieldTempo.getText().equals("__.__h")) 
        {
            labelTempo.setVisible(true);
        }
    }//GEN-LAST:event_fieldTempoFocusLost

    private void buttonXTelasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonXTelasMouseEntered
        // TODO add your handling code here:
        ImageIcon XTelasVerm = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/XFecharTelasAdmin2.png"));
        buttonXTelas.setIcon(XTelasVerm);
    }//GEN-LAST:event_buttonXTelasMouseEntered

    private void buttonXTelasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonXTelasMouseExited
        // TODO add your handling code here:
        ImageIcon XTelas = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/XFecharTelasAdmin.png"));
        buttonXTelas.setIcon(XTelas);
    }//GEN-LAST:event_buttonXTelasMouseExited

    private void buttonXTelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXTelasActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_buttonXTelasActionPerformed

    private void fieldValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldValorFocusGained
        // TODO add your handling code here:
        labelValor.setVisible(false);
    }//GEN-LAST:event_fieldValorFocusGained

    private void fieldValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldValorFocusLost
        // TODO add your handling code here:
        if (fieldValor.getText().isEmpty()) 
        {
            labelValor.setVisible(true);
        }
    }//GEN-LAST:event_fieldValorFocusLost

    private void fieldIdAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIdAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldIdAutorActionPerformed

    private void fieldNivelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNivelFocusGained
        // TODO add your handling code here:
         if (fieldNivel.getText().equals("Nivel do Curso")) {
            fieldNivel.setText("");
            fieldNivel.setForeground(new Color(0,255,8));
        }
    }//GEN-LAST:event_fieldNivelFocusGained

    private void fieldNivelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNivelFocusLost
        // TODO add your handling code here:
        if (fieldNivel.getText().isEmpty()) {
            fieldNivel.setForeground(new Color(0,178,6));
            fieldNivel.setText("Nivel do Curso");
        }
    }//GEN-LAST:event_fieldNivelFocusLost

    private void fieldCategoriaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldCategoriaFocusGained
        // TODO add your handling code here:
        if (fieldCategoria.getText().equals("Categoria do Curso")) {
            fieldCategoria.setText("");
            fieldCategoria.setForeground(new Color(0,255,8));
        }
    }//GEN-LAST:event_fieldCategoriaFocusGained

    private void fieldCategoriaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldCategoriaFocusLost
        // TODO add your handling code here:
        if (fieldCategoria.getText().isEmpty()) {
            fieldCategoria.setForeground(new Color(0,178,6));
            fieldCategoria.setText("Categoria do Curso");
        }
    }//GEN-LAST:event_fieldCategoriaFocusLost

    private void textAreaDescricaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textAreaDescricaoFocusGained
        // TODO add your handling code here:
        if (textAreaDescricao.getText().equals("Descrição (opcional)")) {
            textAreaDescricao.setText("");
            textAreaDescricao.setForeground(new Color(0,255,8));
        }
    }//GEN-LAST:event_textAreaDescricaoFocusGained

    private void textAreaDescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textAreaDescricaoFocusLost
        // TODO add your handling code here:
        if (textAreaDescricao.getText().isEmpty()) {
            textAreaDescricao.setForeground(new Color(0,178,6));
            textAreaDescricao.setText("Descrição (opcional)");
            contadorLabel.setText("0/500");
        }
    }//GEN-LAST:event_textAreaDescricaoFocusLost

    private void buttonOkAlertaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonOkAlertaMouseEntered
        // TODO add your handling code here:
        buttonOkAlerta.setFont(digital7.deriveFont(25f));
    }//GEN-LAST:event_buttonOkAlertaMouseEntered

    private void buttonOkAlertaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonOkAlertaMouseExited
        // TODO add your handling code here:
        buttonOkAlerta.setFont(digital7.deriveFont(20f));
    }//GEN-LAST:event_buttonOkAlertaMouseExited

    private void panelAlertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAlertaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelAlertaMouseClicked

    public boolean validarData(String data) 
    {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            format.setLenient(false); // Para garantir que a data seja válida
            // Parse da data fornecida
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(format.parse(data)); 

            // Obtém o ano da data fornecida
            int anoData = calendar.get(Calendar.YEAR);
            
            // Obtém o ano atual
            int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
            
            // Verifica se o ano é menor que o ano atual
            if (anoData > anoAtual) {
                return false; // Ano da data é menor que o ano atual
            }
            
            return true; // A data é válida e o ano é igual ou maior que o ano atual
        } catch (ParseException e) {
            return false; // Caso ocorra um erro no parse, a data é inválida
        }
    }
//---------------------------------------------------------------------------------------------------------------------------------

//metodos typpingEffect para criar o efeito das mensagens serem escritas
private static void typingEffect(JLabel label, String message, JButton bt1, JPanel panel) 
{
    Timer timer = new Timer(25, new ActionListener() 
    {
        private int index = 0;

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if (index < message.length()) 
            {
                label.setText(label.getText() + message.charAt(index));
                index++;
            }
            else 
            {
                ((Timer) e.getSource()).stop();
                panel.setVisible(true);
                bt1.setVisible(true);
                typingEffect(bt1, "<-- Voltar"); 
            }
        }
    });
    timer.start();
}

private static void typingEffect(JButton button, String message) 
{
    button.setText("");
    
    Timer timer = new Timer(25, new ActionListener() 
    {
        private int index = 0;

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if (index < message.length()) 
            {
                button.setText(button.getText() + message.charAt(index));
                index++;
            }
            else
            {
                ((Timer) e.getSource()).stop();
            }
        }
    });
    timer.start();
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
            java.util.logging.Logger.getLogger(Tela_AdminEditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_AdminEditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_AdminEditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_AdminEditarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                    new Tela_AdminEditarCurso().setVisible(true);
                } catch (FontFormatException ex) {
                    Logger.getLogger(Tela_AdminEditarCurso.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Tela_AdminEditarCurso.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Tela_AdminEditarCurso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCadastrar;
    private javax.swing.JButton buttonOkAlerta;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JButton buttonXTelas;
    private javax.swing.JLabel contadorLabel;
    private javax.swing.JTextField fieldCategoria;
    private javax.swing.JFormattedTextField fieldIdAutor;
    private javax.swing.JTextField fieldNivel;
    private javax.swing.JTextField fieldNome;
    private javax.swing.JFormattedTextField fieldTempo;
    private javax.swing.JFormattedTextField fieldValor;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelAlerta;
    private javax.swing.JLabel labelContagem;
    private javax.swing.JLabel labelIdAutor;
    private javax.swing.JLabel labelTempo;
    private javax.swing.JLabel labelTxtIdAutor;
    private javax.swing.JLabel labelValor;
    private javax.swing.JLabel messageLabel1;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelAlerta;
    private javax.swing.JPanel panelAlerta2;
    private javax.swing.JScrollPane scrollDescricao;
    private javax.swing.JPanel telaAdmin;
    private javax.swing.JTextArea textAreaDescricao;
    // End of variables declaration//GEN-END:variables
}