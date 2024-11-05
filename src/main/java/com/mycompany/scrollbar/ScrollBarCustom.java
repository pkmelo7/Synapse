//@author pkmelo7

//Cria um scrollbar customizado

/*Para utilizar pode arrastar o arquivo para dentro do frame ou usar o comando:

(nomedoscrollpanel/scrollbar).setVerticalScrollBar(new ScrollBarCustom());*/

package com.mycompany.scrollbar;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar
{
    public ScrollBarCustom()
    {
        setUI(new ModernScrollBarUI());
        //Modificavel para alterar as dimensoes da barra
        setPreferredSize(new Dimension(8 , 8));
        //modificavel para alterar a cor do botao da barra
        setForeground(new Color(69,82,173));
        setBackground(Color.WHITE);
    }
}
