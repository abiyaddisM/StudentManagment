package src;

import AClass.AButton;
import AClass.AFrame;
import AClass.AImagePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

public class TitleBar extends AImagePanel {


    AButton closeButton=new AButton("art\\titleBar\\animate\\button\\normalC.png","art\\titleBar\\animate\\button\\hoverC.png","art\\titleBar\\animate\\button\\pressC.png");
    AButton expandButton=new AButton("art\\titleBar\\animate\\button\\normalE.png","art\\titleBar\\animate\\button\\hoverE.png","art\\titleBar\\animate\\button\\pressE.png");
    AButton minimizeButton=new AButton("art\\titleBar\\animate\\button\\normalM.png","art\\titleBar\\animate\\button\\hoverM.png","art\\titleBar\\animate\\button\\pressM.png");
    public TitleBar() {
        super("art\\titleBar\\static\\background\\background.png");
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,4,0));
        mainPanel.setBorder(new EmptyBorder(5,1120,0,0));
        addAction();
        addButtons();
    }
    void addButtons(){
        addMain(minimizeButton);
        addMain(expandButton);
        addMain(closeButton);

    }
    public Point offset;
    int xPose=400,yPose=100;
    public boolean state=false;
    void addAction(){
        MouseListener action=new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource()==closeButton.label){
                    AFrame.frame.dispose();
                    System.exit(0);
                } else if (e.getSource()==expandButton.label) {
                    if (state){
                        AFrame.frame.setBounds(xPose, yPose, 1200, 800);
                        setBorder(new EmptyBorder(0,0,0,0));
                        state=false;
                    }else {
                        AFrame.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        setBorder(new EmptyBorder(0,720,0,0));
                        state=true;
                    }

                } else if (e.getSource()==minimizeButton.label) {
                    AFrame.frame.setExtendedState(JFrame.ICONIFIED);
                    state=false;
                    setBorder(new EmptyBorder(0,0,0,0));
                }
            }
        };
        closeButton.label.addMouseListener(action);
        expandButton.label.addMouseListener(action);
        minimizeButton.label.addMouseListener(action);




            addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    // Calculate the offset between the mouse click and the frame's position
                    offset = new Point(e.getXOnScreen() - AFrame.frame.getX(), e.getYOnScreen() - AFrame.frame.getY());
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    // Update the frame's position based on the mouse position and offset

                }
            });
            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {

                    xPose=e.getXOnScreen() - offset.x;

                    yPose=e.getYOnScreen() - offset.y;

                    if (yPose<0) {
                        yPose=0;
                    }
                    if (!state) {
                        AFrame.frame.setLocation(xPose, yPose);
                    }

                }
            });


    }
}
