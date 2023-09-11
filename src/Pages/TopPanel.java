package Pages;
import AClass.*;
import src.*;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;

public class TopPanel extends AImagePanel {
    String art="art";
   static ATab homeTab=new ATab("art/topBar/animate/homeButton/nNormalH.png","art/topBar/animate/homeButton/nHoverH.png",
            "art/topBar/animate/homeButton/nPressH.png","art/topBar/animate/homeButton/pNormalH.png"
            ,"art/topBar/animate/homeButton/pHoverH.png","art/topBar/animate/homeButton/pPressH.png",1);
    static ATab courseTab=new ATab("art/topBar/animate/courseButton/nNormalC.png","art/topBar/animate/courseButton/nHoverC.png",
            "art/topBar/animate/courseButton/nPressC.png","art/topBar/animate/courseButton/pNormalC.png"
            ,"art/topBar/animate/courseButton/pHoverC.png","art/topBar/animate/courseButton/pPressC.png");
   static ATab manageTab=new ATab("art/topBar/animate/manageButton/nNormalM.png","art/topBar/animate/manageButton/nHoverM.png",
            "art/topBar/animate/manageButton/nPressM.png","art/topBar/animate/manageButton/pNormalM.png"
            ,"art/topBar/animate/manageButton/pHoverM.png","art/topBar/animate/manageButton/pPressM.png");
  static  ATab settingTab=new ATab("art/topBar/animate/settingButton/nNormalS.png","art/topBar/animate/settingButton/nHoverS.png",
            "art/topBar/animate/settingButton/nPressS.png","art/topBar/animate/settingButton/pNormalS.png"
            ,"art/topBar/animate/settingButton/pHoverS.png","art/topBar/animate/settingButton/pPressS.png");


    public TopPanel(String file) {
        super(file,10,0,0,0);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,34,0));
        mainPanel.setBorder(new EmptyBorder(7,0,12,0));
        addPanel();
        addActionListener();
        setVisible(false);
    }
    void addPanel(){
        addMain(homeTab);
        addMain(courseTab);
        addMain(manageTab);
        addMain(settingTab);
    }
    void addActionListener(){


        MouseListener actionListener=new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource()==homeTab.label){
                    hideAllExcept(homeTab);
                    ControlPanels.showHome();
                } else if (e.getSource()==courseTab.label) {
                    hideAllExcept(courseTab);
                    ControlPanels.showCourse();
                } else if (e.getSource()==manageTab.label) {
                    hideAllExcept(manageTab);
                    ControlPanels.showManage(0);
                    ManagePanel.backToOptionPanel();
                } else if (e.getSource()==settingTab.label) {
                    hideAllExcept(settingTab);
                    ControlPanels.showSettings();
                }
            }
            @Override
            public void mouseReleased(MouseEvent e){
                if (e.getSource()==homeTab.label){
                    hideAllExcept(homeTab);
                    ControlPanels.showHome();
                } else if (e.getSource()==courseTab.label) {
                    hideAllExcept(courseTab);
                    ControlPanels.showCourse();
                } else if (e.getSource()==manageTab.label) {
                    hideAllExcept(manageTab);
                    ControlPanels.showManage(0);
                    ManagePanel.backToOptionPanel();
                } else if (e.getSource()==settingTab.label) {
                    hideAllExcept(settingTab);
                    ControlPanels.showSettings();
                }
            }
        };
        homeTab.label.addMouseListener(actionListener);
        courseTab.label.addMouseListener(actionListener);
        manageTab.label.addMouseListener(actionListener);
        settingTab.label.addMouseListener(actionListener);
    }
    public static void hideAllExcept(ATab tab) {
        ATab[] tabs = {homeTab,courseTab,manageTab,settingTab};
        for (ATab c : tabs) {
            if (c != null && c != tab) {
                c.setOff();
            }else {
                c.setOn();
            }
        }
    }
}
