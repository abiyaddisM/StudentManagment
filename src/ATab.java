import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ATab  extends JPanel {
    ImageIcon nNormal;
    ImageIcon nHover;
    ImageIcon nPress;
    ImageIcon pNornal;
    ImageIcon pHover;
    ImageIcon pPress;
    JLabel label=new JLabel();
    boolean state=false;


    public ATab(String nNormal,String nHover,String nPress,String pNormal,String pHover,String pPress){
        this.nNormal=new ImageIcon(nNormal);
        this.nHover=new ImageIcon(nHover);
        this.nPress=new ImageIcon(nPress);
        this.pNornal=new ImageIcon(pNormal);
        this.pHover=new ImageIcon(pHover);
        this.pPress=new ImageIcon(pPress);
        label.setIcon(this.nNormal);
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        setOpaque(false);
        add(label);
        setAnimation();
    }
    public ATab(String nNormal,String nHover,String nPress,String pNormal,String pHover,String pPress,int i){
        this(nNormal,nHover,nPress,pNormal,pHover,pPress);
        label.setIcon(pNornal);
        state=true;
    }
    void setAnimation(){

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
               if(!state){
                   state=true;
                   label.setIcon(nPress);
               }else {

                   label.setIcon(pPress);
               }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(!state){

                    label.setIcon(nHover);
                }else {

                    label.setIcon(pHover);
                }

            }
        });
        label.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if(!state){
                    label.setIcon(nHover);
                }else{
                    label.setIcon(pHover);
                }
            }
        });
        AFrame.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (!contains(e.getPoint())) {
                    if (!state){
                        label.setIcon(nNormal);
                    }else {
                        label.setIcon(pNornal);
                    }
                }
            }
        });
    }

}
