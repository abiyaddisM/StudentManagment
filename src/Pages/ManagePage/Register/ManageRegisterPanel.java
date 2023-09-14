package Pages.ManagePage.Register;

import AClass.*;
import AClass.Button.AButton;
import AClass.Button.AComboBox;
import AClass.TextArea.ATextBox;
import BackEnd.AddInfo;
import Pages.ManagePage.ManagePanel;
import BackEnd.RowInfoHolder;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

abstract  public class ManageRegisterPanel extends AImagePanel {

//a
    String monthList[];
    String dayList[]=new String[31];
    String yearList[]=new String[100];
    String studentBatchList[];
    String genderList[];



    AButton exitButton=new AButton("art/managmentsPage/register/animated/exitButton/normalE.png","art/managmentsPage/register/animated/exitButton/hoverE.png","art/managmentsPage/register/animated/exitButton/pressE.png",0,0,0,600);
    ATextBox firstNameTextBox=new ATextBox("art/managmentsPage/register/animated/textBox/normalR.png","art/managmentsPage/register/animated/textBox/pressR.png");
    ATextBox lastNameTextBox=new ATextBox("art/managmentsPage/register/animated/textBox/normalR.png","art/managmentsPage/register/animated/textBox/pressR.png");
    ATextBox emailTextBox=new ATextBox("art/managmentsPage/register/animated/textBox/normalR.png","art/managmentsPage/register/animated/textBox/pressR.png");
    ATextBox phoneNoTextBox=new ATextBox("art/managmentsPage/register/animated/textBox/normalR.png","art/managmentsPage/register/animated/textBox/pressR.png");
    AImageLabel studentIdLabel=new AImageLabel("art/managmentsPage/register/static/studentID/holder.png",12,"Regular");
    AButton refreshButton=new AButton("art/managmentsPage/register/animated/studentID/normalR.png","art/managmentsPage/register/animated/studentID/hoverR.png","art/managmentsPage/register/animated/studentID/pressR.png");

    AButton clearButton=new AButton("art/managmentsPage/register/animated/saveAndClear/normalC.png","art/managmentsPage/register/animated/saveAndClear/hoverC.png","art/managmentsPage/register/animated/saveAndClear/pressC.png");

    AButton saveButton=new AButton("art/managmentsPage/register/animated/saveAndClear/normalS.png","art/managmentsPage/register/animated/saveAndClear/hoverS.png","art/managmentsPage/register/animated/saveAndClear/pressS.png");
    AComboBox monthComboBox=new AComboBox();
    AComboBox dayComboBox=new AComboBox();
    AComboBox yearComboBox= new AComboBox();
    AComboBox studentBatchComboBox=new AComboBox();
    AComboBox genderComboBox=new AComboBox();

    public ManageRegisterPanel(String file) {
        super(file);
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        setBorder(new EmptyBorder(5,0,0,0));
        studentIdLabel.setText(AddInfo.generateID());
        studentIdLabel.mainLabel.setBorder(new EmptyBorder(0,8,0,0));
        addButtonAction();

    }
   abstract void addComponents();



    void initializeComboBox() {
        monthComboBox.addString(monthList);
        monthComboBox.setComboBox("art/managmentsPage/register/animated/birthDate/month/normalB.png","art/managmentsPage/register/animated/birthDate/month/normalB.png","art/managmentsPage/register/animated/birthDate/month/pressB.png","art/managmentsPage/register/animated/birthDate/month/pressB.png");
        monthComboBox.setListButton("art/managmentsPage/register/animated/birthDate/month/button/normalBY.png","art/managmentsPage/register/animated/birthDate/month/button/hoverBY.png","art/managmentsPage/register/animated/birthDate/month/button/pressBY.png");
        monthComboBox.addToListPanel("art/managmentsPage/register/static/birthDate/month/backgroundB.png");
        monthComboBox.addComboBoxScrollAction();

        dayComboBox.addString(dayList);
        dayComboBox.setComboBox("art/managmentsPage/register/animated/birthDate/smallSize/normalS.png","art/managmentsPage/register/animated/birthDate/smallSize/normalS.png","art/managmentsPage/register/animated/birthDate/smallSize/pressS.png","art/managmentsPage/register/animated/birthDate/smallSize/pressS.png");
        dayComboBox.setListButton("art/managmentsPage/register/animated/birthDate/smallSize/button/normalSS.png","art/managmentsPage/register/animated/birthDate/smallSize/button/hoverSS.png","art/managmentsPage/register/animated/birthDate/smallSize/button/pressS.png");
        dayComboBox.addToListPanel("art/managmentsPage/register/static/birthDate/smallSize/backgroundS1.png");
        dayComboBox.addComboBoxScrollAction();

        yearComboBox.addString(yearList);
        yearComboBox.setComboBox("art/managmentsPage/register/animated/birthDate/smallSize/normalS.png","art/managmentsPage/register/animated/birthDate/smallSize/normalS.png","art/managmentsPage/register/animated/birthDate/smallSize/pressS.png","art/managmentsPage/register/animated/birthDate/smallSize/pressS.png");
        yearComboBox.setListButton("art/managmentsPage/register/animated/birthDate/smallSize/button/normalSS.png","art/managmentsPage/register/animated/birthDate/smallSize/button/hoverSS.png","art/managmentsPage/register/animated/birthDate/smallSize/button/pressS.png");
        yearComboBox.addToListPanel("art/managmentsPage/register/static/birthDate/smallSize/backgroundS1.png");
        yearComboBox.addComboBoxScrollAction();

        studentBatchComboBox.addString(studentBatchList);
        studentBatchComboBox.setComboBox("art/managmentsPage/register/animated/birthDate/month/normalB.png","art/managmentsPage/register/animated/birthDate/month/normalB.png","art/managmentsPage/register/animated/birthDate/month/pressB.png","art/managmentsPage/register/animated/birthDate/month/pressB.png");
        studentBatchComboBox.setListButton("art/managmentsPage/register/animated/birthDate/month/button/normalBY.png","art/managmentsPage/register/animated/birthDate/month/button/hoverBY.png","art/managmentsPage/register/animated/birthDate/month/button/pressBY.png");
        studentBatchComboBox.addToListPanel("art/managmentsPage/register/static/birthDate/month/backgroundB1.png");

        genderComboBox.addString(genderList);
        genderComboBox.setComboBox("art/managmentsPage/register/animated/birthDate/month/normalB.png","art/managmentsPage/register/animated/birthDate/month/normalB.png","art/managmentsPage/register/animated/birthDate/month/pressB.png","art/managmentsPage/register/animated/birthDate/month/pressB.png");
        genderComboBox.setListButton("art/managmentsPage/register/animated/birthDate/month/button/normalBY.png","art/managmentsPage/register/animated/birthDate/month/button/hoverBY.png","art/managmentsPage/register/animated/birthDate/month/button/pressBY.png");
        genderComboBox.addToListPanel("art/managmentsPage/register/static/birthDate/month/backgroundB1.png");
    }


    void initializeList(){
        int year=2023;
        for (Integer i = 0; i < 31; i++) {
            dayList[i]=String.valueOf(i+1);
        }

        for (int i = 0; i <100 ; i++) {
            yearList[i]=String.valueOf(year);
            year--;
        }
        monthList=new String[]{"January","February","March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        studentBatchList=new String[]{"DBR2202","DBR2102","DBR2002","DBR1902"};
        genderList= new String[]{"Male","Female","None-Binary","Other"};

    }
   public void setPlacement() {
        firstNameTextBox.setBorder(new EmptyBorder(142,60,0,0));
        lastNameTextBox.setBorder(new EmptyBorder(142,34,0,0));
        emailTextBox.setBorder(new EmptyBorder(52,60,0,0));
        monthComboBox.setBorder(new EmptyBorder(52,34,0,0));
        dayComboBox.setBorder(new EmptyBorder(52,10,0,0));
        yearComboBox.setBorder(new EmptyBorder(52,10,0,0));
        phoneNoTextBox.setBorder(new EmptyBorder(54 ,60,0,0));
        studentBatchComboBox.setBorder(new EmptyBorder(54 ,34,0,0));
        genderComboBox.setBorder(new EmptyBorder(54 ,37,0,0));
        studentIdLabel.setBorder(new EmptyBorder(54,60,0,0));
        refreshButton.setBorder(new EmptyBorder(54,5,0,0));
        clearButton.setBorder(new EmptyBorder(54,257,0,0));
        saveButton.setBorder(new EmptyBorder(54,13,0,0));
    }
    public void setInformation(RowInfoHolder infoHolder){
        firstNameTextBox.textLabel.setText(infoHolder.firstName);
        lastNameTextBox.textLabel.setText(infoHolder.lastName);
        emailTextBox.textLabel.setText(infoHolder.email);
        monthComboBox.setText(infoHolder.month);
        dayComboBox.setText(infoHolder.day);
        yearComboBox.setText(infoHolder.year);
        phoneNoTextBox.textLabel.setText(infoHolder.phoneNo);
        studentBatchComboBox.setText(infoHolder.department);
        genderComboBox.setText(infoHolder.gender);
        studentIdLabel.setText(infoHolder.id);
    }
    void clearAll(){
        ATextBox box[]={firstNameTextBox,lastNameTextBox,emailTextBox,phoneNoTextBox,};
        AComboBox box1[]={monthComboBox,dayComboBox,yearComboBox,studentBatchComboBox,genderComboBox};

        for(ATextBox b: box){
            b.resetText();
        }
        for(AComboBox b: box1){
            b.resetText();
        }
    }
     void addButtonAction(){
        MouseAdapter action=new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource()==exitButton.label){
                    clearAll();
                    ManagePanel.backToOptionPanel();
                } else if (e.getSource()==clearButton.label) {
                   clearAll();
                }else if (e.getSource()==refreshButton.label) {
                    studentIdLabel.setText(AddInfo.generateID());
                }
            }
        };
         exitButton.label.addMouseListener(action);
         clearButton.label.addMouseListener(action);
         refreshButton.label.addMouseListener(action);

     }


    
}
