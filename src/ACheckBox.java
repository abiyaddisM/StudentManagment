import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ACheckBox extends AButton {
    Boolean state=false;
    ImageIcon hoverPressIcon=new ImageIcon();
    ACheckBox(){
        super("art/loginPage/comp/userAndPass/check/normal.png","art/loginPage/comp/userAndPass/check/nHover.png","art/loginPage/comp/userAndPass/check/pNormal.png");
        hoverPressIcon.setImage(new ImageIcon("art/loginPage/comp/userAndPass/check/pHover.png").getImage());
    }
    ACheckBox(int top,int left,int bottom,int right){
        super("art/loginPage/comp/userAndPass/check/normal.png","art/loginPage/comp/userAndPass/check/nHover.png","art/loginPage/comp/userAndPass/check/pNormal.png",top,left,bottom,right);
        hoverPressIcon.setImage(new ImageIcon("art/loginPage/comp/userAndPass/check/pHover.png").getImage());

    }
    @Override
    void setAnimation(){
        System.out.println("kkk");
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!state){
                    state=true;
                    label.setIcon(hoverPressIcon);

                }else {
                    state=false;
                    label.setIcon(hoverIcon);
                }

            }

        });

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                addMouseListener(new MouseAdapter() {


                    @Override
                    public void mouseReleased(MouseEvent e) {
                        label.setIcon(hoverIcon);
                    }
                });
            }
        });
        label.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if(state){
                    label.setIcon(hoverPressIcon);
                }else{
                    label.setIcon(hoverIcon);
                }
            }
        });
        AFrame.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (!contains(e.getPoint())) {
                    if (state){
                        label.setIcon(pressIcon);
                    }else {
                        label.setIcon(normalIcon);
                    }
                }
            }
        });
    }
    boolean getState(){
        return state;
    }
}
