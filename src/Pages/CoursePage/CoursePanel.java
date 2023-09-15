package Pages.CoursePage;

import AClass.AImagePanel;
import AClass.Button.AButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CoursePanel extends JPanel {
    public static AImagePanel optionPanel=new AImagePanel("art\\coursePage\\static\\background\\background.png",15,0,0,0);
    static AButton buttonSE=new AButton("art\\coursePage\\animate\\button\\normalSE.png","art\\coursePage\\animate\\button\\hoverSE.png","art\\coursePage\\animate\\button\\pressSE.png");
    static  AButton buttonCS=new AButton("art\\coursePage\\animate\\button\\normalCS.png","art\\coursePage\\animate\\button\\hoverCS.png","art\\coursePage\\animate\\button\\pressCS.png");
    static   AButton buttonDS=new AButton("art\\coursePage\\animate\\button\\normalDS.png","art\\coursePage\\animate\\button\\hoverDS.png","art\\coursePage\\animate\\button\\pressDS.png");
    static    AButton buttonAI=new AButton("art\\coursePage\\animate\\button\\normalAI.png","art\\coursePage\\animate\\button\\hoverAI.png","art\\coursePage\\animate\\button\\pressAI.png");

    static SECourse sECourse=new SECourse();
    static CSCourse cSCourse=new CSCourse();
    static DSCourse dSCourse=new DSCourse();
    static AICourse aICourse=new AICourse();
    public CoursePanel() {
        optionPanel. mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,6,0));
        optionPanel.mainPanel.setBorder(new EmptyBorder(10,0,0,0));
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        setVisible(false);
        setOpaque(false);
        hideAllExcept(optionPanel);
        addAction();
        addButton();
        addPanels();
    }
    void addButton(){
        optionPanel.addMain(buttonSE);
        optionPanel.addMain(buttonCS);
        optionPanel.addMain(buttonDS);
        optionPanel.addMain(buttonAI);
    }
    void addPanels(){
        add(optionPanel);
        add(sECourse);
        add(cSCourse);
        add(dSCourse);
        add(aICourse);
    }

     public static void hideAllExcept(Component component) {
        Component[] components = {optionPanel,sECourse,cSCourse,dSCourse,aICourse};
        for (Component c : components) {
            if (c != null && c != component) {
                c.setVisible(false);
            }else {
                c.setVisible(true);
            }
        }
    }
    void addAction(){
        MouseListener action=new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==buttonSE.label){
                    hideAllExcept(sECourse);
                } else if (e.getSource()==buttonCS.label) {
                    hideAllExcept(cSCourse);
                } else if (e.getSource()==buttonDS.label) {
                    hideAllExcept(dSCourse);
                } else if (e.getSource()==buttonAI.label) {
                    hideAllExcept(aICourse);
                }
            }
        };
        buttonSE.label.addMouseListener(action);
        buttonCS.label.addMouseListener(action);
        buttonDS.label.addMouseListener(action);
        buttonAI.label.addMouseListener(action);

    }
}
