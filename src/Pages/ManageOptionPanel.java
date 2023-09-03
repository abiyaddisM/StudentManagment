package Pages;

import AClass.AButton;
import AClass.AImagePanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageOptionPanel extends AImagePanel {

    AImagePanel studentOption=new AImagePanel("art\\managmentsPage\\option\\static\\optionPanels\\studentOption.png",43,22,0,0);
    AButton studentViewButton=new AButton("art\\managmentsPage\\option\\animate\\view\\normalV.png","art\\managmentsPage\\option\\animate\\view\\hoverV.png",
            "art\\managmentsPage\\option\\animate\\view\\pressV.png",13,210,0,0);
    AButton studentAddButton=new AButton("art\\managmentsPage\\option\\animate\\add\\normalA.png","art\\managmentsPage\\option\\animate\\add\\hoverA.png",
            "art\\managmentsPage\\option\\animate\\add\\pressA.png",13,20,0,0);
    //
    AImagePanel teacherOption=new AImagePanel("art\\managmentsPage\\option\\static\\optionPanels\\teacherOption.png",30,22,0,0);
    AButton teacherViewButton=new AButton("art\\managmentsPage\\option\\animate\\view\\normalV.png","art\\managmentsPage\\option\\animate\\view\\hoverV.png",
            "art\\managmentsPage\\option\\animate\\view\\pressV.png",13,210,0,0);
    AButton teacherAddButton=new AButton("art\\managmentsPage\\option\\animate\\add\\normalA.png","art\\managmentsPage\\option\\animate\\add\\hoverA.png",
            "art\\managmentsPage\\option\\animate\\add\\pressA.png",13,20,0,0);
    //
    AImagePanel staffOption=new AImagePanel("art\\managmentsPage\\option\\static\\optionPanels\\staffOption.png",30,22,0,0);
    AButton staffViewButton=new AButton("art\\managmentsPage\\option\\animate\\view\\normalV.png","art\\managmentsPage\\option\\animate\\view\\hoverV.png",
            "art\\managmentsPage\\option\\animate\\view\\pressV.png",13,210,0,0);
    AButton staffAddButton=new AButton("art\\managmentsPage\\option\\animate\\add\\normalA.png","art\\managmentsPage\\option\\animate\\add\\hoverA.png",
            "art\\managmentsPage\\option\\animate\\add\\pressA.png",13,20,0,0);
    public ManageOptionPanel() {
        super("art\\managmentsPage\\option\\static\\background\\background.png",38,300,0,300);
        addPanels();
        addButtons();
        viewList();
    }
    void addPanels(){
        addMain(studentOption);
        addMain(teacherOption);
        addMain(staffOption);

    }
    void addButtons(){
        studentOption.addMain(studentViewButton);
        studentOption.addMain(studentAddButton);

        teacherOption.addMain(teacherViewButton);
        teacherOption.addMain(teacherAddButton);

        staffOption.addMain(staffViewButton);
        staffOption.addMain(staffAddButton);

    }
    void viewList(){
        studentViewButton.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManagePanel.viewStudentList();
            }
        });
        teacherViewButton.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManagePanel.viewTeacherList();
            }
        });
        staffViewButton.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManagePanel.viewStaffList();
            }
        });
    }

}
