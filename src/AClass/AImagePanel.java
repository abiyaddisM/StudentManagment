package AClass;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AImagePanel extends JPanel {
    public JPanel innerPanel=new JPanel();
   public JPanel mainPanel=new JPanel();
   public JLabel label=new JLabel();
    public AImagePanel(String file){
        ImageIcon icon=new ImageIcon(file);
        label.setIcon(icon);

        mainPanel.setBackground(Color.black);
        mainPanel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        mainPanel.setOpaque(false);

        innerPanel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        innerPanel.setLayout(null);
        innerPanel.setBackground(Color.red);
        innerPanel.setOpaque(false);
        innerPanel.add(mainPanel);

        label.setPreferredSize(new Dimension(icon.getIconWidth(),icon.getIconHeight()));

        setBackground(Color.cyan);
        setLayout(new OverlayLayout(this));
        setOpaque(false);

        add(innerPanel);
        add(label);

    }
    public AImagePanel(String file, int top, int left, int bottom, int right){
        this(file);
      setBorder(new EmptyBorder(top,left,bottom,right));
    }
   public void addMain(Component component){
        mainPanel.add(component);
    }
    public void setPanelOff(){
        setVisible(false);
    }
    public void setPanelOn(){
        setVisible(true);
    }
}
