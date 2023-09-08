package Pages;
import AClass.*;
import src.*;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TopPanel extends AImagePanel {
    String art="art";
    ATab homeTab=new ATab("art/topBar/animate/homeButton/nNormalH.png","art/topBar/animate/homeButton/nHoverH.png",
            "art/topBar/animate/homeButton/nPressH.png","art/topBar/animate/homeButton/pNormalH.png"
            ,"art/topBar/animate/homeButton/pHoverH.png","art/topBar/animate/homeButton/pPressH.png",1);
    ATab courseTab=new ATab("art/topBar/animate/courseButton/nNormalC.png","art/topBar/animate/courseButton/nHoverC.png",
            "art/topBar/animate/courseButton/nPressC.png","art/topBar/animate/courseButton/pNormalC.png"
            ,"art/topBar/animate/courseButton/pHoverC.png","art/topBar/animate/courseButton/pPressC.png");
    ATab manageTab=new ATab(art+"/topBar/animate/manageButton/nNormalM.png","art/topBar/animate/manageButton/nHoverM.png",
            "art/topBar/animate/manageButton/nPressM.png","art/topBar/animate/manageButton/pNormalM.png"
            ,"art/topBar/animate/manageButton/pHoverM.png","art/topBar/animate/manageButton/pPressM.png");
    ATab settingTab=new ATab("art/topBar/animate/settingButton/nNormalS.png","art/topBar/animate/settingButton/nHoverS.png",
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
        homeTab.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                homeTab.setOff(courseTab,manageTab,settingTab);
                ControlPanels.showHome();
            }
        });
        courseTab.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                courseTab.setOff(homeTab,manageTab,settingTab);
                ControlPanels.showCourse();
            }
        });
        manageTab.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                manageTab.setOff(homeTab,courseTab,settingTab);
                ControlPanels.showManage();
                ManagePanel.backToOptionPanel();
            }
        });
        settingTab.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                settingTab.setOff(homeTab,courseTab,manageTab);
                ControlPanels.showSettings();
            }
        });
    }
}
