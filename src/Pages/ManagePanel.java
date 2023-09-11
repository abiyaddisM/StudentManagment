package Pages;

import AClass.AImagePanel;
import Pages.Register.StudentRegisterPanel;
import Pages.Register.TeacherRegisterPanel;
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
    static TeacherRegisterPanel teacherRegisterPanel=new TeacherRegisterPanel("art\\managmentsPage\\register\\static\\background\\teacherBackground1.png");

    static StudentRegisterPanel studentManageRegisterPanel=new StudentRegisterPanel("art\\managmentsPage\\register\\static\\background\\studentBackground1.png");
    static ManageListPanel studentListPanel=new ManageListPanel("art\\managmentsPage\\lists\\static\\background\\studentBackground1.png",studentInfoHolders);
    static ManageListPanel teacherListPanel=new ManageListPanel("art\\managmentsPage\\lists\\static\\background\\teacherBackground1.png",teacherInfoHolders);
    static ManageListPanel staffListPanel=new ManageListPanel("art\\managmentsPage\\lists\\static\\background\\staffBackground1.png",staffInfoHolders);


    public ManagePanel(){
        setVisible(false);
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        initilizeVisibility();
        add(manageOptionPanel);
        add(studentManageRegisterPanel);
        add(teacherRegisterPanel);
        add(studentListPanel);
        add(teacherListPanel);
        add(staffListPanel);
    }
    void initilizeVisibility(){
        studentManageRegisterPanel.setPanelOff();
        teacherListPanel.setPanelOff();
        studentListPanel.setPanelOff();
        teacherListPanel.setPanelOff();
        staffListPanel.setPanelOff();

    }

    public static void backToOptionPanel(){
        manageOptionPanel.setPanelOn();
        studentListPanel.setPanelOff();
        teacherListPanel.setPanelOff();
        staffListPanel.setPanelOff();
        studentManageRegisterPanel.setPanelOff();
        teacherRegisterPanel.setPanelOff();
    }
    public static void hideAllExcept(AImagePanel panel) {
        AImagePanel[] panels = {manageOptionPanel,studentListPanel,staffListPanel,teacherListPanel,studentManageRegisterPanel,teacherRegisterPanel};
        for (AImagePanel c : panels) {
            if (c != null && c != panel) {
                c.setPanelOff();
            }else {
                c.setPanelOn();
            }
        }
    }
    static void getStudentInfoFromDatabase(){
        //Connect the sql here and put the data of students here.
        for (int i = 0; i < 10; i++) {
            studentInfoHolders.add(new RowInfoHolder("0Q"+i,"Abiy Addis","20","Male","Students"));
        }

    }
    static void getTeacherInfoFromDatabase(){
        //Connect the sql here and put the data of teachers here.
        for (int i = 0; i < 7; i++) {
            teacherInfoHolders.add(new RowInfoHolder("P1"+i,"Kim John Hun","45","Female","Teachers"));
        }

    }
    static void getStaffInfoFromDatabase(){
        //Connect the sql here and put the data of staffs here.
        for (int i = 0; i < 30; i++) {
            staffInfoHolders.add(new RowInfoHolder("2H"+i,"Dr. Dre","65","Male","Staff"));
        }

    }
}
