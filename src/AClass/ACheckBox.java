package AClass;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ACheckBox extends AButton {
    Boolean state=false;
    ImageIcon hoverPressIcon=new ImageIcon();
    ACheckBox(){
        super("art/loginPage/comp/userAndPass/check/normalN.png","art/loginPage/comp/userAndPass/check/hoverN.png","art/loginPage/comp/userAndPass/check/normalC1.png");
        hoverPressIcon.setImage(new ImageIcon("art/loginPage/comp/userAndPass/check/hoverC.png").getImage());
    }
    public ACheckBox(int top, int left, int bottom, int right){
        super("art/loginPage/comp/userAndPass/check/normalN.png","art/loginPage/comp/userAndPass/check/hoverN.png","art/loginPage/comp/userAndPass/check/normalC1.png",top,left,bottom,right);
        hoverPressIcon.setImage(new ImageIcon("art/loginPage/comp/userAndPass/check/hoverC.png").getImage());

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
            public void mouseExited(MouseEvent e) {
                if (state){
                    label.setIcon(pressIcon);
                }else {
                    label.setIcon(normalIcon);
                }
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

    }
    boolean getState(){
        return state;
    }

}
