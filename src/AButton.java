import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class AButton extends JPanel {

    protected ImageIcon normalIcon = new ImageIcon();
    protected ImageIcon pressIcon = new ImageIcon();
    protected ImageIcon hoverIcon = new ImageIcon();
    JLabel label=new JLabel();

    public AButton(String normalUrl, String hoverUrl, String pressUrl) {
        normalIcon.setImage(new ImageIcon(normalUrl).getImage());
        pressIcon.setImage(new ImageIcon(pressUrl).getImage());
        hoverIcon.setImage(new ImageIcon(hoverUrl).getImage());

        label.setIcon(normalIcon);
        label.setBounds(300, 150, normalIcon.getIconWidth(), normalIcon.getIconHeight());

        add(label);
        setOpaque(false);
        setBackground(Color.cyan);
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        setAnimation();
    }
    public AButton(String normalUrl, String hoverUrl, String pressUrl,int top,int left,int bottom,int right){
        this(normalUrl,hoverUrl,pressUrl);
        setBorder(new EmptyBorder(top,left,bottom,right));
    }






    public void setPosition(int xPos, int yPos) {
        setBounds(xPos, yPos, normalIcon.getIconWidth(), normalIcon.getIconHeight());
    }




    void setAnimation() {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                label.setIcon(pressIcon);  // Set the icon to pressed state
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                label.setIcon(hoverIcon);
            }
        });

        label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                label.setIcon(hoverIcon);
            }
        });

        AFrame.frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (!contains(e.getPoint())) {
                    label.setIcon(normalIcon);
                }
            }
        });
    }
}
