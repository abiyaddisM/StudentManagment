package AClass.Button;
import AClass.AImagePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;

public class AButtonText extends JPanel {
    protected ImageIcon normalIcon ;
    protected ImageIcon pressIcon ;
    protected ImageIcon hoverIcon ;
    public AImagePanel label;
    public JLabel text;

    public AButtonText(String normalUrl, String hoverUrl, String pressUrl) {
        normalIcon= new ImageIcon(normalUrl);
        pressIcon= new ImageIcon(pressUrl);
        hoverIcon= new ImageIcon(hoverUrl);

        text=new JLabel("January");
        text.setForeground(new Color(0xBDBDCE));
        text.setFont(font(12));

        label=new AImagePanel(normalUrl);

        label.mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT,8,3));
        label.addMain(text);


        add(label);
        setOpaque(false);
        setBackground(Color.cyan);
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        setAnimation();
    }
    public AButtonText(String normalUrl, String hoverUrl, String pressUrl,int top,int left,int bottom,int right){
        this(normalUrl,hoverUrl,pressUrl);
        setBorder(new EmptyBorder(top,left,bottom,right));
    }


    void setAnimation() {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                label.label.setIcon(pressIcon);  // Set the icon to pressed state
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(label.contains(e.getPoint())){
                    label.label.setIcon(hoverIcon);
                }else{
                    label.label.setIcon(normalIcon);

                }
            }
            @Override
            public void mouseExited(MouseEvent e) {

                label.label.setIcon(normalIcon);

            }
        });

        label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                label.label.setIcon(hoverIcon);
            }
        });


    }
    Font font(float size){

        try
        {
            File fontFile = new File("font/inter/Inter-Regular.ttf");
            Font  customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(size);
            return customFont;

        }catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return null;
        }

    }
}

