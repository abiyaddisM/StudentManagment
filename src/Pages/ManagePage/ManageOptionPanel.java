package Pages.ManagePage;

import AClass.AImageLabel;
import AClass.Button.AButton;
import AClass.AImagePanel;
import BackEnd.AddInfo;
import Pages.ManagePage.ManagePanel;
import Pages.ManagePage.Register.ManageRegisterPanel;

import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ManageOptionPanel extends AImagePanel {

    static AImagePanel studentOption=new AImagePanel("art/managmentsPage/option/static/optionPanels/studentOption.png",43,22,0,0);
   static AButton studentViewButton=new AButton("art/managmentsPage/option/animate/view/normalV.png","art/managmentsPage/option/animate/view/hoverV.png",
            "art/managmentsPage/option/animate/view/pressV.png",0,0,8,0);
    static AButton studentAddButton=new AButton("art/managmentsPage/option/animate/add/normalA.png","art/managmentsPage/option/animate/add/hoverA.png",
            "art/managmentsPage/option/animate/add/pressA.png",0,20,8,0);
    //
    static AImagePanel teacherOption=new AImagePanel("art/managmentsPage/option/static/optionPanels/teacherOption.png",30,22,0,0);
    static AButton teacherViewButton=new AButton("art/managmentsPage/option/animate/view/normalV.png","art/managmentsPage/option/animate/view/hoverV.png",
            "art/managmentsPage/option/animate/view/pressV.png",0,0,8,0);
    static  AButton teacherAddButton=new AButton("art/managmentsPage/option/animate/add/normalA.png","art/managmentsPage/option/animate/add/hoverA.png",
            "art/managmentsPage/option/animate/add/pressA.png",0,20,8,0);
    //
    static AImagePanel staffOption=new AImagePanel("art/managmentsPage/option/static/optionPanels/staffOption.png",30,22,0,0);
    static AButton staffViewButton=new AButton("art/managmentsPage/option/animate/view/normalV.png","art/managmentsPage/option/animate/view/hoverV.png",
            "art/managmentsPage/option/animate/view/pressV.png",0,0,8,0);
    static AButton staffAddButton=new AButton("art/managmentsPage/option/animate/add/normalA.png","art/managmentsPage/option/animate/add/hoverA.png",
            "art/managmentsPage/option/animate/add/pressA.png",0,20,8,0);
    AImageLabel amountOfStudent=new AImageLabel("art/homePage/static/holder/holder.png",20,"Bold",0,0,0,-12);
    AImageLabel amountOfTeacher=new AImageLabel("art/homePage/static/holder/holder.png",20,"Bold",0,0,0,-12);
    AImageLabel amountOfStaff=new AImageLabel("art/homePage/static/holder/holder.png",20,"Bold",0,0,0,-12);

    public ManageOptionPanel() {
        super("art/managmentsPage/option/static/background/background.png",38,300,0,300);
        setNumberInfo();
        addPanels();
        addButtons();
        viewList();
    }
    void addPanels(){
        addMain(studentOption);
        addMain(teacherOption);
        addMain(staffOption);

    }
    void setNumberInfo(){
        amountOfStudent.setText("2,120/5,238");
        amountOfStudent.setColor(0xD1CEE7);

        amountOfTeacher.setText("155/350");
        amountOfTeacher.setColor(0xD1CEE7);

        amountOfStaff.setText("456/677");
        amountOfStaff.setColor(0xD1CEE7);
    }
    void addButtons(){
        studentOption.addMain(amountOfStudent);
        studentOption.addMain(studentViewButton);
        studentOption.addMain(studentAddButton);

        teacherOption.addMain(amountOfTeacher);
        teacherOption.addMain(teacherViewButton);
        teacherOption.addMain(teacherAddButton);

        staffOption.addMain(amountOfStaff);
        staffOption.addMain(staffViewButton);
        staffOption.addMain(staffAddButton);

    }
    static void viewList(){
        MouseListener mouseListener=new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==studentViewButton.label){
                    ManagePanel.hideAllExcept(ManagePanel.studentListPanel);
                }else if(e.getSource()==teacherViewButton.label){
                    ManagePanel.hideAllExcept(ManagePanel.teacherListPanel);
                } else if (e.getSource()==staffViewButton.label) {
                    ManagePanel.hideAllExcept(ManagePanel.staffListPanel);
                } else if (e.getSource()==studentAddButton.label) {
                    ManagePanel.hideAllExcept(ManagePanel.studentManageRegisterPanel);
//                    ManageRegisterPanel.studentIdLabel.setText(AddInfo.generateID());
                } else if (e.getSource()==teacherAddButton.label) {
                    ManagePanel.hideAllExcept(ManagePanel.teacherRegisterPanel);
                } else if (e.getSource()==staffAddButton.label) {
                    ManagePanel.hideAllExcept(ManagePanel.staffRegisterPanel);
                }
            }
        };
        studentViewButton.label.addMouseListener(mouseListener);
        teacherViewButton.label.addMouseListener(mouseListener);
        staffViewButton.label.addMouseListener(mouseListener);
        studentAddButton.label.addMouseListener(mouseListener);
        teacherAddButton.label.addMouseListener(mouseListener);
        staffAddButton.label.addMouseListener(mouseListener);
    }

}
