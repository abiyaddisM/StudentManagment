import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AFrame extends JPanel{

    static JFrame frame=new JFrame();
    {

        frame.setBounds(400, 200, 1200, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0x1B1E2A));
        frame.setVisible(true);
        frame.add(this);
    }
    {
        setBackground(new Color(0x1B1E2A));
        setBorder(new EmptyBorder(15,400,0,400));
        setLayout(new FlowLayout(FlowLayout.CENTER,0,22));


    }

}
