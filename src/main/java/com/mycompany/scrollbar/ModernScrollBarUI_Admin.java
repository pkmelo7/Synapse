// @author pkmelo7

//Cria uma scrollbar modernizada customizavel

/*Para utilizar pode arrastar o arquivo para dentro do frame ou usar o comando:

(nomedoscrollpanel/scrollbar).setVerticalScrollBar(new ScrollBarCustom());*/

package com.mycompany.scrollbar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ModernScrollBarUI_Admin extends BasicScrollBarUI 
{
    int THUMB_SIZE = 0;
    
    protected void setThumbBounds(int x, int y, int width, int height) 
    {
        super.setThumbBounds(x, y, width, height);
        int scrollBarLength = scrollbar.getOrientation() == JScrollBar.VERTICAL ? scrollbar.getHeight() : scrollbar.getWidth();
        int maxScroll = scrollbar.getMaximum() - scrollbar.getVisibleAmount();
        int thumbSize = (int) ((double) scrollbar.getVisibleAmount() / (double) (maxScroll + scrollbar.getVisibleAmount()) * scrollBarLength);
        thumbSize = Math.max(THUMB_SIZE, thumbSize);
        
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) 
        {
            scrollbar.setPreferredSize(new Dimension(scrollbar.getWidth(), thumbSize));
        } 
        else 
        {
            scrollbar.setPreferredSize(new Dimension(thumbSize, scrollbar.getHeight()));
        }
    }
   
    @Override
    protected JButton createIncreaseButton(int i)
    {
        return new ScrollBarButton();
    }
    
    @Override
    protected JButton createDecreaseButton(int i)
    {
        return new ScrollBarButton();
    }
    
    protected void paintTrack(Graphics grphcs, JComponent jc, Rectangle rctngl)
    {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int orientation = scrollbar.getOrientation();
        int size;
        int x;
        int y;
        int width;
        int height;
        if(orientation == JScrollBar.VERTICAL)
        {
            size = rctngl.width / 2;
            x = rctngl.x + ((rctngl.width - size) / 2);
            y = rctngl.y;
            width = size;
            height = rctngl.height;
        }
        else
        {
            size = rctngl.height / 2;
            y = rctngl.y + ((rctngl.height - size) / 2);
            x = 0;
            width = rctngl.width;
            height = size;
        }
        //modificavel para mudar a cor de fundo da barra
        g2.setColor(new Color(12,12,12));
        g2.fillRect(x, y, width, height);
    }

    protected void paintThumb(Graphics grphcs, JComponent jc, Rectangle rctngl)
    {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = rctngl.x;
        int y = rctngl.y;
        int width = rctngl.width;
        int height = rctngl.height;
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL)
        {
            y += 8;
            height -= 16;
        }
        else
        {
            x += 8;
            width -= 16;
        }
        g2.setColor(scrollbar.getForeground());
        g2.fillRoundRect(x,y,width,height,10,10);
    }
    private class ScrollBarButton extends JButton
    {
        public ScrollBarButton()
        {
            setBorder(BorderFactory.createEmptyBorder());
        }
        public void paint(Graphics grphcs)
        {
            
        }
    }
}
