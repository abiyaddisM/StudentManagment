package Pages;

import src.RowInfoHolder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ManagePanel extends JPanel {
    static ArrayList<RowInfoHolder> studentInfoHolders=new ArrayList<>();
    static ArrayList<RowInfoHolder> teacherInfoHolders=new ArrayList<>();
    static ArrayList<RowInfoHolder> staffInfoHolders=new ArrayList<>();


    static  {
     getStudentInfoFromDatabase();
     getTeacherInfoFromDatabase();
     getStaffInfoFromDatabase();
    }

    static ManageOptionPanel manageOptionPanel=new ManageOptionPanel();

    static ManageRegisterPanel studentManageRegisterPanel=new ManageRegisterPanel("art\\managmentsPage\\register\\static\\background\\background3.png");
    static ManageListPanel studentListPanel=new ManageListPanel("art\\managmentsPage\\lists\\static\\background\\studentBackground.png",studentInfoHolders);
    static ManageListPanel teacherListPanel=new ManageListPanel("art\\managmentsPage\\lists\\static\\background\\teacherBackground.png",teacherInfoHolders);
    static ManageListPanel staffListPanel=new ManageListPanel("art\\managmentsPage\\lists\\static\\background\\staffBackground.png",staffInfoHolders);


    public ManagePanel(){
        setVisible(false);
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        initilizeVisibility();
        add(manageOptionPanel);
        add(studentManageRegisterPanel);
        add(studentListPanel);
        add(teacherListPanel);
        add(staffListPanel);
    }
    void initilizeVisibility(){
        studentManageRegisterPanel.setPanelOff();
        studentListPanel.setPanelOff();
        teacherListPanel.setPanelOff();
        staffListPanel.setPanelOff();
    }
    static void viewStudentList(){
        studentListPanel.setPanelOn();
        manageOptionPanel.setPanelOff();
    }
    static void viewTeacherList(){
        teacherListPanel.setPanelOn();
        manageOptionPanel.setPanelOff();
    }
    static void viewStaffList(){
        staffListPanel.setPanelOn();
        manageOptionPanel.setPanelOff();
    }
    static void viewAddStudent(){
        studentManageRegisterPanel.setPanelOn();
        manageOptionPanel.setPanelOff();
    }
    static void backToOptionPanel(){
        manageOptionPanel.setPanelOn();
        studentListPanel.setPanelOff();
        teacherListPanel.setPanelOff();
        staffListPanel.setPanelOff();
        studentManageRegisterPanel.setPanelOff();
    }
    static void getStudentInfoFromDatabase(){
        //Connect the sql here and put the data of students here.
        for (int i = 0; i < 10; i++) {
            studentInfoHolders.add(new RowInfoHolder("0Q"+i,"Abiy Addis","DBR2202","Male","Students"));
        }

    }
    static void getTeacherInfoFromDatabase(){
        //Connect the sql here and put the data of teachers here.
        for (int i = 0; i < 7; i++) {
            teacherInfoHolders.add(new RowInfoHolder("P1"+i,"Kim John Hun","CS","Female","Teachers"));
        }

    }
    static void getStaffInfoFromDatabase(){
        //Connect the sql here and put the data of staffs here.
        for (int i = 0; i < 30; i++) {
            staffInfoHolders.add(new RowInfoHolder("2H"+i,"Dr. Dre","Receptionist","Male","Staff"));
        }

    }
}
