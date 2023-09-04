package AClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;

public class AStringButton extends JLabel {
    Color normalColor = new Color(0x3EC4E8);
    Color pressColor = new Color(0x089ABC);
    Color hoverColor = new Color(0x5BDDFC);


    public AStringButton(String text, int size) {
        setFont(font(12));
        setText(text);
        setForeground(normalColor);
        setAnimation();
    }

    public AStringButton(String text) {
        this(text, 12);
    }

    public void setPosition(int xPos, int yPos) {
    }
    JLabel getThis(){
        return this;
    }

    void setAnimation() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setForeground(pressColor);  // Set the icon to pressed state
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setForeground(hoverColor);
            }
            public void mouseExited(MouseEvent e) {

                setForeground(normalColor);

            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                setForeground(hoverColor);
            }
        });

        AFrame.frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (!contains(e.getPoint())) {
                }
            }
        });
    }

    Font font(float size) {

        try {
            File fontFile = new File("font/Gilroy-Medium.ttf");
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(size);
            return customFont;

        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return null;
        }

    }
}
