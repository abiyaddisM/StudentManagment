package Pages.ManagePage;

import AClass.AImagePanel;
import Pages.ManagePage.List.*;
import Pages.ManagePage.Register.*;
import BackEnd.RowInfoHolder;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class ManagePanel extends JPanel {
    static ArrayList<RowInfoHolder> studentInfoHolders=new ArrayList<>();
    static ArrayList<RowInfoHolder> teacherInfoHolders=new ArrayList<>();
    static ArrayList<RowInfoHolder> staffInfoHolders=new ArrayList<>();

    static String jdbcUrl = "jdbc:mysql://localhost:3306/school_management";
    static String jdbcUsername = "root";
    static String jdbcPassword = "password";


    static  {
     getStudentInfoFromDatabase();
     getTeacherInfoFromDatabase();
     getStaffInfoFromDatabase();
    }

    public static ManageOptionPanel manageOptionPanel=new ManageOptionPanel();
    public static TeacherRegisterPanel teacherRegisterPanel=new TeacherRegisterPanel("art/managmentsPage/register/static/background/teacherBackground1.png");
    public static StaffRegisterPanel staffRegisterPanel=new StaffRegisterPanel("art/managmentsPage/register/static/background/staffBackground.png");
    public static StudentRegisterPanel studentManageRegisterPanel=new StudentRegisterPanel("art/managmentsPage/register/static/background/studentBackground1.png");
    static public StudentListPanel studentListPanel=new StudentListPanel("art/managmentsPage/lists/static/background/studentBackground1.png",studentInfoHolders);
    static public TeacherListPanel teacherListPanel=new TeacherListPanel("art/managmentsPage/lists/static/background/teacherBackground1.png",teacherInfoHolders);
    static public StaffListPanel staffListPanel=new StaffListPanel("art/managmentsPage/lists/static/background/staffBackground1.png",staffInfoHolders);

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


        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            String selectSql = "SELECT student.first_name, student.last_name, student.date_of_birth, student.display_id,\n" +
                    "                    student.gender, student_email.email, student_phone_number.phone_number, department.department_name\n" +
                    "                    FROM student\n" +
                    "                    LEFT JOIN student_email ON student.student_id = student_email.student_id\n" +
                    "                    LEFT JOIN student_phone_number ON student.student_id = student_phone_number.student_id\n" +
                    "                    LEFT JOIN department ON student.department_id = department.department_id;";

            PreparedStatement selectStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String displayID = resultSet.getString("display_id");
                String gender = resultSet.getString("gender");
                String emailAddress = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
                String departmentName = resultSet.getString("department_name");

                Date sqlDate = resultSet.getDate("date_of_birth");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(sqlDate);

                String year = Integer.toString(calendar.get(Calendar.YEAR));
                String month = Integer.toString(calendar.get(Calendar.MONTH) + 1); // Adding 1 because months are zero-based
                String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));


                studentInfoHolders.add(new RowInfoHolder(displayID,firstName,lastName,year,month,day,gender,departmentName,emailAddress,phoneNumber));
            }
            resultSet.close();
            selectStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    static void getTeacherInfoFromDatabase(){
        //Connect the sql here and put the data of teachers here.
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            String selectSql = "SELECT teacher.first_name, teacher.last_name, teacher.date_of_birth, teacher.display_id,\n" +
                    "                    teacher.gender, teacher_email.email, teacher_phone_number.phone_number, department.department_name\n" +
                    "                    FROM teacher\n" +
                    "                    LEFT JOIN teacher_email ON teacher.teacher_id = teacher_email.teacher_id\n" +
                    "                    LEFT JOIN teacher_phone_number ON teacher.teacher_id = teacher_phone_number.teacher_id\n" +
                    "                    LEFT JOIN department ON teacher.department_id = department.department_id;";

            PreparedStatement selectStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String displayID = resultSet.getString("display_id");
                String gender = resultSet.getString("gender");
                String emailAddress = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
                String departmentName = resultSet.getString("department_name");

                Date sqlDate = resultSet.getDate("date_of_birth");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(sqlDate);

                String year = Integer.toString(calendar.get(Calendar.YEAR));
                String month = Integer.toString(calendar.get(Calendar.MONTH) + 1); // Adding 1 because months are zero-based
                String day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));


                teacherInfoHolders.add(new RowInfoHolder(displayID,firstName,lastName,year,month,day,gender,departmentName,emailAddress,phoneNumber));
            }
            resultSet.close();
            selectStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
    static void getStaffInfoFromDatabase(){
        //Connect the sql here and put the data of staffs here.
        for (int i = 0; i < 30; i++) {
            staffInfoHolders.add(new RowInfoHolder("0Q"+i,"Abiy","Addis","1997","April","2","Male","Students","abiy@gmail.com","0980633711"));
        }

    }
}
