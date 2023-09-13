package Pages;
import AClass.*;
import AClass.Button.AButton;
import BackEnd.ControlPanels;
import Pages.ManagePage.ManagePanel;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;

public class HomePanel extends AImagePanel {

    private AImagePanel aboutUsPanel=new AImagePanel("art/homePage/static/aboutUs/background.png");
    private AImagePanel statsPanel=new AImagePanel("art/homePage/static/stats/background.png");
    private AImagePanel schoolYearPanel=new AImagePanel("art/homePage/static/year/background.png");

    private AImagePanel aboutUsTextImage=new AImagePanel("art/homePage/static/aboutUs/aboutUs.png");
    private AImageLabel aboutUsBoxImage=new AImageLabel("art/homePage/static/aboutUs/image.png",24,0,0,0);
    private AButton startButton=new AButton("art/homePage/animate/startButton/normal.png","art/homePage/animate/startButton/hover.png",
            "art/homePage/animate/startButton/press.png",216,0,0,230);

    private AImagePanel totalStudentImage=new AImagePanel("art/homePage/static/stats/totalStudents.png");
    private AButton totalStudentButton=new AButton("art/homePage/animate/addButton/2/normal.png","art/homePage/animate/addButton/2/hover.png",
            "art/homePage/animate/addButton/2/press.png");
    private AImagePanel totalTeacherImage=new AImagePanel("art/homePage/static/stats/totalTeachers.png");
    private AButton totalTeacherButton=new AButton("art/homePage/animate/addButton/3/normal.png","art/homePage/animate/addButton/3/hover.png",
            "art/homePage/animate/addButton/3/press.png");
    private AImagePanel totalStaffImage=new AImagePanel("art/homePage/static/stats/totalStaffs.png");
    private AButton totalStaffButton=new AButton("art/homePage/animate/addButton/1/normal.png","art/homePage/animate/addButton/1/hover.png",
            "art/homePage/animate/addButton/1/press.png");

    //This are the button numbers that go 1 2 3 4
    private AButton schoolYearOneButton=new AButton("art/homePage/animate/schoolYear/1/1Normal.png","art/homePage/animate/schoolYear/1/1Hover.png","art/homePage/animate/schoolYear/1/1Press.png");
    private AButton schoolYearTwoButton=new AButton("art/homePage/animate/schoolYear/2/1Normal.png","art/homePage/animate/schoolYear/2/1Hover.png","art/homePage/animate/schoolYear/2/1Press.png");
    private AButton schoolYearThreeButton=new AButton("art/homePage/animate/schoolYear/3/3Normal.png","art/homePage/animate/schoolYear/3/3Hover.png","art/homePage/animate/schoolYear/3/3Press.png");
    private AButton schoolYearFourButton=new AButton("art/homePage/animate/schoolYear/4/4Normal.png","art/homePage/animate/schoolYear/4/4Hover.png","art/homePage/animate/schoolYear/4/4Press.png");


    AImageLabel amountOfStudent=new AImageLabel("art/homePage/static/holder/holder.png",20,"Bold",0,0,0,30);
    AImageLabel amountOfTeacher=new AImageLabel("art/homePage/static/holder/holder.png",20,"Bold",0,0,0,30);
    AImageLabel amountOfStaff=new AImageLabel("art/homePage/static/holder/holder.png",20,"Bold",0,0,0,30);



    public HomePanel(String file) {
        super(file,10,0,0,0);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,11,10));
        statsPanel.mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,11,5));
        schoolYearPanel.mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,6,9));


        addPanel();
        addAboutUsPanel();
        addStatsPanel();
        addSchoolYearPanel();
        addButtonAction();
        setVisible(false);
    }
    void addPanel(){
     addMain(aboutUsPanel);
     addMain(statsPanel);
     addMain(schoolYearPanel);
    }
    void addAboutUsPanel(){
        aboutUsPanel.addMain(aboutUsTextImage);
        aboutUsPanel.addMain(aboutUsBoxImage);
        aboutUsTextImage.addMain(startButton);
    }
    void addStatsPanel(){
        setNumberInfo();
        totalStudentImage.addMain(amountOfStudent);
        totalStudentImage.addMain(totalStudentButton);
        statsPanel.addMain(totalStudentImage);
        totalTeacherImage.addMain(amountOfTeacher);
        totalTeacherImage.addMain(totalTeacherButton);
        statsPanel.addMain(totalTeacherImage);
        totalStaffImage.addMain(amountOfStaff);
        totalStaffImage.addMain(totalStaffButton);
        statsPanel.addMain(totalStaffImage);
    }
    void setNumberInfo(){
        amountOfStudent.setText("2,120/5,238");
        amountOfStudent.mainLabel.setBorder(new EmptyBorder(0,0,17,0));
        amountOfStudent.setColor(0xD1CEE7);

        amountOfTeacher.setText("155/350");
        amountOfTeacher.mainLabel.setBorder(new EmptyBorder(0,0,17,0));
        amountOfTeacher.setColor(0xD1CEE7);

        amountOfStaff.setText("456/677");
        amountOfStaff.mainLabel.setBorder(new EmptyBorder(0,0,17,0));
        amountOfStaff.setColor(0xD1CEE7);
    }
    void addSchoolYearPanel(){
        schoolYearPanel.addMain(schoolYearOneButton);
        schoolYearPanel.addMain(schoolYearTwoButton);
        schoolYearPanel.addMain(schoolYearThreeButton);
        schoolYearPanel.addMain(schoolYearFourButton);
    }
    void addButtonAction(){
        MouseListener addButtonAction=new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource()==totalStudentButton.label){
                    ControlPanels.executor.schedule(() -> {
                        TopPanel.hideAllExcept(TopPanel.manageTab);
                        ControlPanels.showManage(200);
                       ManagePanel.hideAllExcept(ManagePanel.studentManageRegisterPanel);
                    }, ControlPanels.delayInMilliSeconds, TimeUnit.MILLISECONDS);


                } else if (e.getSource()==startButton.label) {
                    ControlPanels.executor.schedule(() -> {
                        ControlPanels.showManage(200);
                        TopPanel.hideAllExcept(TopPanel.manageTab);
                        ManagePanel.hideAllExcept(ManagePanel.manageOptionPanel);
                    }, ControlPanels.delayInMilliSeconds, TimeUnit.MILLISECONDS);
                } else if (e.getSource()==totalTeacherButton.label) {
                    ControlPanels.executor.schedule(() -> {
                        ControlPanels.showManage(200);
                        TopPanel.hideAllExcept(TopPanel.manageTab);
                        ManagePanel.hideAllExcept(ManagePanel.teacherRegisterPanel);
                    }, ControlPanels.delayInMilliSeconds, TimeUnit.MILLISECONDS);

                } else if (e.getSource()==totalStaffButton.label) {
                    ControlPanels.executor.schedule(() -> {
                        ControlPanels.showManage(200);
                        TopPanel.hideAllExcept(TopPanel.manageTab);
                        ManagePanel.hideAllExcept(ManagePanel.staffRegisterPanel);
                    }, ControlPanels.delayInMilliSeconds, TimeUnit.MILLISECONDS);
                }
            }
        };
        startButton.label.addMouseListener(addButtonAction);
        totalStudentButton.label.addMouseListener(addButtonAction);
        totalTeacherButton.label.addMouseListener(addButtonAction);
        totalStaffButton.label.addMouseListener(addButtonAction);
    }
}
