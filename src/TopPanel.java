import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TopPanel extends AImagePanel {
    ATab homeTab=new ATab("art/topBar/animate/homeButton/nNormal.png","art/topBar/animate/homeButton/nHover.png",
            "art/topBar/animate/homeButton/nPress.png","art/topBar/animate/homeButton/pNormal.png"
            ,"art/topBar/animate/homeButton/pHover.png","art/topBar/animate/homeButton/pPress.png",1);
    ATab courseTab=new ATab("art/topBar/animate/courseButton/nNormal1.png","art/topBar/animate/courseButton/nHover1.png",
            "art/topBar/animate/courseButton/nPress1.png","art/topBar/animate/courseButton/pNormal1.png"
            ,"art/topBar/animate/courseButton/pHover1.png","art/topBar/animate/courseButton/pPress1.png");
    ATab manageTab=new ATab("art/topBar/animate/manageButton/nNormal2.png","art/topBar/animate/manageButton/nHover2.png",
            "art/topBar/animate/manageButton/nPress2.png","art/topBar/animate/manageButton/pNormal2.png"
            ,"art/topBar/animate/manageButton/pHover2.png","art/topBar/animate/manageButton/pPress2.png");
    ATab settingTab=new ATab("art/topBar/animate/settingButton/nNormal3.png","art/topBar/animate/settingButton/nHover3.png",
            "art/topBar/animate/settingButton/nPress3.png","art/topBar/animate/settingButton/pNormal3.png"
            ,"art/topBar/animate/settingButton/pHover3.png","art/topBar/animate/settingButton/pPress3.png");


    TopPanel(String file) {
        super(file);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,55,0));
        mainPanel.setBorder(new EmptyBorder(12,0,12,0));
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
