package AClass.Button;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AButton extends JPanel {

    protected ImageIcon normalIcon = new ImageIcon();
    protected ImageIcon pressIcon = new ImageIcon();
    protected ImageIcon hoverIcon = new ImageIcon();
    public JLabel label=new JLabel();

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

    boolean isMouseDown = false;
    void setAnimation() {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                label.setIcon(pressIcon);
                isMouseDown = true;// Set
            }
            @Override
            public void mouseClicked(MouseEvent e) {

                label.setIcon(hoverIcon);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isMouseDown = false;
                label.setIcon(normalIcon);

            }
            @Override
            public void mouseExited(MouseEvent e) {

                if (!isMouseDown){
                    label.setIcon(normalIcon);
                }

            }
            public void mouseEntered(MouseEvent e) {
                label.setIcon(hoverIcon);

            }
        });




    }
}
