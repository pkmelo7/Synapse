//@author @pkmelo7

package com.mycompany.telas.admin;

//Importações necessárias
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
//Fim das importações necessárias

public class Tela_Admin1 extends javax.swing.JFrame {
    
    //Declaração de variáveis 
        //variavel para uso da fonte digital7
        Font digital7;
        GraphicsEnvironment GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        //Variavel para trazer o icone do projeto
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/icon.png")); 
    //Final da declaração de variáveis
    
    //Declaração de métodos
        //cria o metodo abrirTelaAdmin2 onde abre a segunda tela de admin
        private void abrirTelaAdmin2() throws FontFormatException, IOException
        {
            Tela_Admin2 admin2 = new Tela_Admin2();
            admin2.setVisible(true);
            this.dispose();
        }
    //Fim da declaração de métodos
        
    public Tela_Admin1() throws FontFormatException, IOException {
        //cria a fonte digital7 no projeto
        this.digital7 = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/digital-7.ttf"));
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaAdmin = new javax.swing.JPanel();
        messageLabel1 = new javax.swing.JLabel();
        buttonNext = new javax.swing.JButton();

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

        telaAdmin.setBackground(new java.awt.Color(0, 0, 0));
        telaAdmin.setForeground(new java.awt.Color(0, 0, 0));
        telaAdmin.setLayout(null);

        messageLabel1.setBackground(new java.awt.Color(0, 0, 0));
        messageLabel1.setFont(digital7.deriveFont(100f));
        messageLabel1.setForeground(new java.awt.Color(0, 255, 8));
        messageLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        messageLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        String message = "Ola admin, seja bem-vindo!";
        typingEffect(messageLabel1, message, buttonNext);
        telaAdmin.add(messageLabel1);
        messageLabel1.setBounds(0, 284, 1366, 201);

        buttonNext.setBackground(new java.awt.Color(0, 0, 0));
        buttonNext.setForeground(new java.awt.Color(0, 0, 0));
        buttonNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Botoes/Next.png"))); // NOI18N
        buttonNext.setBorder(null);
        buttonNext.setBorderPainted(false);
        buttonNext.setContentAreaFilled(false);
        buttonNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonNext.setFocusPainted(false);
        buttonNext.setVisible(false);
        buttonNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonNextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonNextMouseExited(evt);
            }
        });
        buttonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextActionPerformed(evt);
            }
        });
        telaAdmin.add(buttonNext);
        buttonNext.setBounds(1115, 573, 170, 90);

        getContentPane().add(telaAdmin);
        telaAdmin.setBounds(0, 0, 1366, 768);

        setBounds(-6, 0, 1366, 768);
    }// </editor-fold>//GEN-END:initComponents
//---------------------------------------------------------------------------------------------------------------------------------

//Inicio dos comandos do botao Seta/Next
    //abre a tela seguinte de admin ao apertar no botao
    private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextActionPerformed
            // TODO add your handling code here:
        try { abrirTelaAdmin2();
        } catch (FontFormatException ex) {
            Logger.getLogger(Tela_Admin1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tela_Admin1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonNextActionPerformed
    //muda o icone da seta para uma seta maior ao passar o mouse por cima do botao
    private void buttonNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNextMouseEntered
        // TODO add your handling code here:
        ImageIcon Next2 = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/Next2.png"));
        buttonNext.setIcon(Next2);
    }//GEN-LAST:event_buttonNextMouseEntered
    //muda o icone da seta para uma seta padrao ao tirar o mouse de cima do botao
    private void buttonNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNextMouseExited
        // TODO add your handling code here:
        ImageIcon Next = new ImageIcon(getClass().getClassLoader().getResource("images/Botoes/Next.png"));
        buttonNext.setIcon(Next);
    }//GEN-LAST:event_buttonNextMouseExited
//Fim dos comandos do botao Seta/Next

//---------------------------------------------------------------------------------------------------------------------------------

//metodo typpingEffect para criar o efeito das mensagens serem escritas
private static void typingEffect(JLabel label, String message, JButton buttonNext)
{
    Timer timer = new Timer(50, new ActionListener()
    {
        private int index =0;
            
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (index < message.length())
            {
                label.setText(label.getText()+message.charAt(index));
                index++;
            }
            else
            {
                ((Timer)e.getSource()).stop();
                buttonNext.setVisible(true);
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
            java.util.logging.Logger.getLogger(Tela_Admin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Admin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Admin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Admin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                    new Tela_Admin1().setVisible(true);
                } catch (FontFormatException ex) {
                    Logger.getLogger(Tela_Admin1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Tela_Admin1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonNext;
    private javax.swing.JLabel messageLabel1;
    private javax.swing.JPanel telaAdmin;
    // End of variables declaration//GEN-END:variables
}