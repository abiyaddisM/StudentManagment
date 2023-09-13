package AClass.Button;
import AClass.AImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class ACheckBoxText extends JPanel {
    Boolean state=false;

    protected ImageIcon normalNIcon ;
    protected ImageIcon hoverNIcon ;
    protected ImageIcon normalPIcon ;
    protected ImageIcon hoverPIcon ;
    private JLabel text;

    public AImagePanel imagePanel;
    ACheckBoxText(String normalN,String hoverN,String normalP,String hoverP){
        normalNIcon=new ImageIcon(normalN);
        hoverNIcon=new ImageIcon(hoverN);
        normalPIcon=new ImageIcon(normalP);
        hoverPIcon=new ImageIcon(hoverP);

        text=new JLabel("");
        text.setForeground(new Color(0x578ADE));
        text.setFont(font(13));

        imagePanel=new AImagePanel(normalN);
        imagePanel.mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT,11,11));
        imagePanel.addMain(text);

        add(imagePanel);
        setOpaque(false);
        setBackground(Color.cyan);
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        setAnimation();
    }
    void setAnimation(){
        System.out.println("kkk");
        imagePanel.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!state){
                    state=true;
                    imagePanel.label.setIcon(hoverPIcon);

                }else {
                    state=false;
                    imagePanel.label.setIcon(hoverNIcon);
                }

            }

        });

        imagePanel.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                addMouseListener(new MouseAdapter() {


                    @Override
                    public void mouseReleased(MouseEvent e) {
                        imagePanel.label.setIcon(hoverNIcon);
                    }
                });
            }
            public void mouseExited(MouseEvent e) {
                if (state){
                    imagePanel.label.setIcon(normalPIcon);
                }else {
                    imagePanel.label.setIcon(normalNIcon);
                }
            }

        });
        imagePanel.label.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if(state){
                    imagePanel.label.setIcon(hoverPIcon);
                }else{
                    imagePanel.label.setIcon(hoverNIcon);
                }
            }
        });

    }
    String getText(){
        return text.getText();
    }
    void setText(String text){
        this.text.setText(text);
    }
    void flip(){
        if(state){
            imagePanel.label.setIcon(normalNIcon);
            state=false;
        }else {
            imagePanel.label.setIcon(normalPIcon);
            state=true;

        }
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
