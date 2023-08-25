import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AImagePanel extends JPanel {
    JPanel innerPanel=new JPanel();
    JPanel mainPanel=new JPanel();
    JLabel label=new JLabel();
    AImagePanel(String file){
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
    void addMain(Component component){
        mainPanel.add(component);
    }
}
