package AClass;

import AClass.Frame.AFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    public static class APasswordTextBox extends JLabel {

        protected ImageIcon normalIcon = new ImageIcon("art/loginPage/comp/normalT.png");
        protected ImageIcon pressIcon = new ImageIcon("art/loginPage/comp/pressT.png");

        public JPasswordField textLabel = new JPasswordField();
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        boolean state = false;

        public APasswordTextBox() {
            setLayout(new BorderLayout());

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
                      /*  state = false;
                        setIcon(normalIcon);
                        textLabel.setEditable(false);*/

                    } else {
                        state = true;
                        setIcon(pressIcon);
                        textLabel.setEditable(true);


                    }

                    // Request focus for the textLabel after clicking
                    textLabel.requestFocus();
                }

            });
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

            AFrame.frame.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    state = false;
                    setIcon(normalIcon);
                    textLabel.setEditable(false);
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
}
