package AClass;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class ATextBox extends JLabel {

    protected ImageIcon normalIcon = new ImageIcon("art/loginPage/comp/normalT.png");
    protected ImageIcon pressIcon = new ImageIcon("art/loginPage/comp/pressT.png");

    public JTextField textLabel = new JTextField();
    Toolkit toolkit = Toolkit.getDefaultToolkit();

    boolean state = false;

    public ATextBox() {

        // Set up the label with icon
        setIcon(normalIcon);
        setHorizontalAlignment(JLabel.CENTER);

        // Set up the text label (initially hidden)
        textLabel.setHorizontalAlignment(JLabel.LEFT);
        textLabel.setForeground(Color.WHITE); // Set text color
        textLabel.setBorder(null);
        textLabel.setOpaque(false);
        textLabel.setFont(font(15));
        textLabel.setBorder(new EmptyBorder(0, 11, 0, 0));
        textLabel.setEditable(true);
        textLabel.setCaretColor(new Color(0x3EC4E8));
        textLabel.setForeground(new Color(0xB5E9F8));


        // Add the text label on top of the icon label
        setLayout(new OverlayLayout(this));
        add(textLabel);

        // Add mouse click listener to show "hello" text
        textLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (state) {
                    state = false;
                    setIcon(normalIcon);
                    textLabel.setEditable(false);

                } else {
                    state = true;
                    setIcon(pressIcon);
                    textLabel.setEditable(true);


                }

                // Request focus for the textLabel after clicking
                textLabel.requestFocus();
            }
        });
        AFrame.frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                state = false;
                setIcon(normalIcon);
                textLabel.setEditable(false);
            }
        });

    }
    {
        toolkit.addAWTEventListener(event -> {
            if (event instanceof MouseEvent) {
                MouseEvent mouseEvent = (MouseEvent) event;
                if(mouseEvent.getButton()==1){
                    if(!mouseEvent.getPoint().equals(textLabel.getMousePosition())){
                        state = false;
                        setIcon(normalIcon);
                        textLabel.setEditable(false);
                    }

                }


            }
        }, AWTEvent.MOUSE_EVENT_MASK);
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



