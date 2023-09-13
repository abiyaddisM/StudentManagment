package Pages.ManagePage;

import AClass.AImagePanel;
import Pages.ManagePage.List.*;
import Pages.ManagePage.Register.*;
import BackEnd.RowInfoHolder;

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

    public static ManageOptionPanel manageOptionPanel=new ManageOptionPanel();
    public static TeacherRegisterPanel teacherRegisterPanel=new TeacherRegisterPanel("art\\managmentsPage\\register\\static\\background\\teacherBackground1.png");
    public static StaffRegisterPanel staffRegisterPanel=new StaffRegisterPanel("art\\managmentsPage\\register\\static\\background\\staffBackground.png");
    public static StudentRegisterPanel studentManageRegisterPanel=new StudentRegisterPanel("art\\managmentsPage\\register\\static\\background\\studentBackground1.png");
    static public StudentListPanel studentListPanel=new StudentListPanel("art\\managmentsPage\\lists\\static\\background\\studentBackground1.png",studentInfoHolders);
    static public TeacherListPanel teacherListPanel=new TeacherListPanel("art\\managmentsPage\\lists\\static\\background\\teacherBackground1.png",teacherInfoHolders);
    static public StaffListPanel staffListPanel=new StaffListPanel("art\\managmentsPage\\lists\\static\\background\\staffBackground1.png",staffInfoHolders);

    static public EditStudentPanel editStudentPanel=new EditStudentPanel();
    static public EditTeacherPanel editTeacherPanel=new EditTeacherPanel();
    static public EditStaffPanel editStaffPanel=new EditStaffPanel();

    public ManagePanel(){
        setVisible(false);
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
//        initilizeVisibility();
        add(manageOptionPanel);
        add(studentManageRegisterPanel);
        add(teacherRegisterPanel);
        add(staffRegisterPanel);
        add(studentListPanel);
        add(teacherListPanel);
        add(staffListPanel);
        add(editStudentPanel);
        add(editTeacherPanel);
        add(editStaffPanel);
    }
//    void initilizeVisibility(){
//        studentManageRegisterPanel.setPanelOff();
//        staffRegisterPanel.setPanelOff();
//        teacherRegisterPanel.setPanelOff();
//        teacherListPanel.setPanelOff();
//        studentListPanel.setPanelOff();
//        teacherListPanel.setPanelOff();
//        staffListPanel.setPanelOff();
//
//    }

    public static void backToOptionPanel(){
        manageOptionPanel.setPanelOn();
        studentManageRegisterPanel.setPanelOff();
        staffRegisterPanel.setPanelOff();
        teacherRegisterPanel.setPanelOff();
        teacherListPanel.setPanelOff();
        studentListPanel.setPanelOff();
        teacherListPanel.setPanelOff();
        staffListPanel.setPanelOff();
        editStudentPanel.setPanelOff();
        editTeacherPanel.setPanelOff();
        editStaffPanel.setPanelOff();
    }
    public static void hideAllExcept(AImagePanel panel) {
        AImagePanel[] panels = {manageOptionPanel,studentListPanel,staffListPanel,teacherListPanel,studentManageRegisterPanel,teacherRegisterPanel,staffRegisterPanel,editStudentPanel,editTeacherPanel,editStaffPanel};
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
            studentInfoHolders.add(new RowInfoHolder("0Q"+i,"Abiy","Addis","1997","April","2","Male","Students","abiy@gmail.com","0980633711"));
        }

    }
    static void getTeacherInfoFromDatabase(){
        //Connect the sql here and put the data of teachers here.
        for (int i = 0; i < 7; i++) {
            teacherInfoHolders.add(new RowInfoHolder("0Q"+i,"Abiy","Addis","1997","April","2","Male","Students","abiy@gmail.com","0980633711"));
        }

    }
    static void getStaffInfoFromDatabase(){
        //Connect the sql here and put the data of staffs here.
        for (int i = 0; i < 30; i++) {
            staffInfoHolders.add(new RowInfoHolder("0Q"+i,"Abiy","Addis","1997","April","2","Male","Students","abiy@gmail.com","0980633711"));
        }

    }
}
