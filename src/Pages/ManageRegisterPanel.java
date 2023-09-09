package Pages;

import AClass.*;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageRegisterPanel extends AImagePanel {

    String monthList[]={"January","February","March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String dayList[]=new String[31];
    String yearList[]=new String[100];
    String studentBatchList[]={"DBR2202","DBR2102","DBR2002","DBR1902"};
    String genderList[]={"Male","Female","None-Binary","Other"};

    AButton exitButton=new AButton("art\\managmentsPage\\register\\animated\\exitButton\\normalE.png","art\\managmentsPage\\register\\animated\\exitButton\\hoverE.png","art\\managmentsPage\\register\\animated\\exitButton\\pressE.png",0,0,0,600);
    ATextBox firstNameTextBox=new ATextBox("art/managmentsPage/register/animated/textBox/normalR.png","art/managmentsPage/register/animated/textBox/pressR.png");
    ATextBox lastNameTextBox=new ATextBox("art/managmentsPage/register/animated/textBox/normalR.png","art/managmentsPage/register/animated/textBox/pressR.png");
    ATextBox emailTextBox=new ATextBox("art/managmentsPage/register/animated/textBox/normalR.png","art/managmentsPage/register/animated/textBox/pressR.png");
    ATextBox phoneNoTextBox=new ATextBox("art/managmentsPage/register/animated/textBox/normalR.png","art/managmentsPage/register/animated/textBox/pressR.png");
    AComboBox monthComboBox=new AComboBox(monthList);
    AComboBox dayComboBox;
    AComboBox yearComboBox;
    AComboBox studentBatchComboBox=new AComboBox(studentBatchList);
    AComboBox genderComboBox=new AComboBox(genderList);
    AImageLabel studentIdLabel=new AImageLabel("art\\managmentsPage\\register\\static\\studentID\\holder.png");
    AButton refreshButton=new AButton("art\\managmentsPage\\register\\animated\\studentID\\normalR.png","art\\managmentsPage\\register\\animated\\studentID\\hoverR.png","art\\managmentsPage\\register\\animated\\studentID\\pressR.png");

    AButton clearButton=new AButton("art\\managmentsPage\\register\\animated\\saveAndClear\\normalC.png","art\\managmentsPage\\register\\animated\\saveAndClear\\hoverC.png","art\\managmentsPage\\register\\animated\\saveAndClear\\pressC.png");

    AButton saveButton=new AButton("art\\managmentsPage\\register\\animated\\saveAndClear\\normalS.png","art\\managmentsPage\\register\\animated\\saveAndClear\\hoverS.png","art\\managmentsPage\\register\\animated\\saveAndClear\\pressS.png");

    public ManageRegisterPanel(String file) {
        super(file);
        setVisible(false);
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        setBorder(new EmptyBorder(5,0,0,0));
        initializeComboBox();
        addComponents();
    }
    void addComponents(){
        addMain(exitButton);
        addMain(firstNameTextBox);
        addMain(lastNameTextBox);
        addMain(emailTextBox);
        addMain(monthComboBox);
        addMain(dayComboBox);
        addMain(yearComboBox);
        addMain(phoneNoTextBox);
        addMain(studentBatchComboBox);
        addMain(genderComboBox);
        addMain(studentIdLabel);
        addMain(refreshButton);
        addMain(clearButton);
        addMain(saveButton);
    }
    void initializeComboBox(){
        monthComboBox.setComboBox("art/managmentsPage/register/animated/birthDate/month/normalB.png","art/managmentsPage/register/animated/birthDate/month/normalB.png","art/managmentsPage/register/animated/birthDate/month/pressB.png","art/managmentsPage/register/animated/birthDate/month/pressB.png");
        monthComboBox.setListButton("art/managmentsPage/register/animated/birthDate/month/button/normalBY.png","art/managmentsPage/register/animated/birthDate/month/button/hoverBY.png","art/managmentsPage/register/animated/birthDate/month/button/pressBY.png");
        monthComboBox.addToListPanel("art/managmentsPage/register/static/birthDate/month/backgroundB.png");
        monthComboBox.addComboBoxScrollAction();

        dayComboBox.setComboBox("art/managmentsPage/register/animated/birthDate/smallSize/normalS.png","art/managmentsPage/register/animated/birthDate/smallSize/normalS.png","art/managmentsPage/register/animated/birthDate/smallSize/pressS.png","art/managmentsPage/register/animated/birthDate/smallSize/pressS.png");
        dayComboBox.setListButton("art/managmentsPage/register/animated/birthDate/smallSize/button/normalSS.png","art/managmentsPage/register/animated/birthDate/smallSize/button/hoverSS.png","art/managmentsPage/register/animated/birthDate/smallSize/button/pressS.png");
        dayComboBox.addToListPanel("art/managmentsPage/register/static/birthDate/smallSize/backgroundS1.png");
        dayComboBox.addComboBoxScrollAction();
        
        yearComboBox.setComboBox("art/managmentsPage/register/animated/birthDate/smallSize/normalS.png","art/managmentsPage/register/animated/birthDate/smallSize/normalS.png","art/managmentsPage/register/animated/birthDate/smallSize/pressS.png","art/managmentsPage/register/animated/birthDate/smallSize/pressS.png");
        yearComboBox.setListButton("art/managmentsPage/register/animated/birthDate/smallSize/button/normalSS.png","art/managmentsPage/register/animated/birthDate/smallSize/button/hoverSS.png","art/managmentsPage/register/animated/birthDate/smallSize/button/pressS.png");
        yearComboBox.addToListPanel("art/managmentsPage/register/static/birthDate/smallSize/backgroundS1.png");
        yearComboBox.addComboBoxScrollAction();
        
        studentBatchComboBox.setComboBox("art/managmentsPage/register/animated/birthDate/month/normalB.png","art/managmentsPage/register/animated/birthDate/month/normalB.png","art/managmentsPage/register/animated/birthDate/month/pressB.png","art/managmentsPage/register/animated/birthDate/month/pressB.png");
        studentBatchComboBox.setListButton("art/managmentsPage/register/animated/birthDate/month/button/normalBY.png","art/managmentsPage/register/animated/birthDate/month/button/hoverBY.png","art/managmentsPage/register/animated/birthDate/month/button/pressBY.png");
        studentBatchComboBox.addToListPanel("art/managmentsPage/register/static/birthDate/month/backgroundB1.png");

        genderComboBox.setComboBox("art/managmentsPage/register/animated/birthDate/month/normalB.png","art/managmentsPage/register/animated/birthDate/month/normalB.png","art/managmentsPage/register/animated/birthDate/month/pressB.png","art/managmentsPage/register/animated/birthDate/month/pressB.png");
        genderComboBox.setListButton("art/managmentsPage/register/animated/birthDate/month/button/normalBY.png","art/managmentsPage/register/animated/birthDate/month/button/hoverBY.png","art/managmentsPage/register/animated/birthDate/month/button/pressBY.png");
        genderComboBox.addToListPanel("art/managmentsPage/register/static/birthDate/month/backgroundB1.png");

        
    }
    {//initializeList
        int year=2023;
        for (Integer i = 0; i < 31; i++) {
            dayList[i]=String.valueOf(i+1);
        }
        dayComboBox=new AComboBox(dayList);
        for (int i = 0; i <100 ; i++) {
            yearList[i]=String.valueOf(year);
            year--;
        }
        yearComboBox=new AComboBox(yearList);
    }
    {
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
    {
        studentIdLabel.setText("PT1512");
        studentIdLabel.mainLabel.setBorder(new EmptyBorder(0,8,0,0));
        exitButton.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManagePanel.backToOptionPanel();
            }
        });
    }

}