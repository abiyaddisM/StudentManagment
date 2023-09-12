package AClass;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AImageLabel extends JPanel {
    public JPanel innerPanel=new JPanel();
    public JLabel mainLabel=new JLabel();
    public AImageLabel(String file,int size,String type){
        JLabel label=new JLabel( new ImageIcon(file));
        ImageIcon icon=new ImageIcon(file);
        label.setIcon(icon);

        mainLabel.setBackground(Color.black);
        mainLabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        mainLabel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        mainLabel.setOpaque(false);
        mainLabel.setFont(font(size,type));
        mainLabel.setForeground(new Color(0xB09A9A));

        innerPanel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        innerPanel.setLayout(null);
        innerPanel.setBackground(Color.red);
        innerPanel.setOpaque(false);
        innerPanel.add(mainLabel);

        label.setPreferredSize(new Dimension(icon.getIconWidth(),icon.getIconHeight()));

        setBackground(Color.cyan);
        setLayout(new OverlayLayout(this));
        setOpaque(false);

        add(innerPanel);
        add(label);

    }
    public AImageLabel(String file,int size,String type, int top, int left, int bottom, int right){
        this(file,size,type);
        setBorder(new EmptyBorder(top,left,bottom,right));
    }
    public AImageLabel(String file, int top, int left, int bottom, int right){
        this(file,12,"Regular");
        setBorder(new EmptyBorder(top,left,bottom,right));
    }
    public void setText(String text){
        mainLabel.setText(text);
    }
    Font font(float size,String type){

        try
        {
            File fontFile = new File("font/inter/Inter-"+type+".ttf");
            Font  customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(size);
            return customFont;

        }catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return null;
        }

    }

   public void setColor(int color){
        mainLabel.setForeground(new Color(color));
    }
    public String getText(){
        return mainLabel.getText();
    }
}
