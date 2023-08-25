import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AImageLabel extends JPanel {
    AImageLabel(String file){
        ImageIcon icon=new ImageIcon(file);
        JLabel label=new JLabel(icon);
        add(label);
        setOpaque(false);
        setBackground(Color.cyan);
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
    }
    AImageLabel(String file,int top,int left,int bottom,int right){
        this(file);
        setBorder(new EmptyBorder(top,left,bottom,right));
    }
}
