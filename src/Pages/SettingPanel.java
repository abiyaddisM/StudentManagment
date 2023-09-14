package Pages;

import AClass.AImagePanel;
import AClass.Button.AButton;
import AClass.Frame.AFrame;
import BackEnd.LoginVerifcation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class SettingPanel extends JPanel {

   

    static AButton exitGroupButton=new AButton("art/managmentsPage/register/animated/exitButton/normalE.png","art/managmentsPage/register/animated/exitButton/hoverE.png","art/managmentsPage/register/animated/exitButton/pressE.png",0,0,0,230);

    static AButton groupButton=new AButton("art\\settingPage\\animate\\button\\normalGM.png","art\\settingPage\\animate\\button\\hoverGM.png","art\\settingPage\\animate\\button\\pressGM.png",60,100,0,100);
    static AButton signOutButton=new AButton("art\\settingPage\\animate\\button\\normalSO.png","art\\settingPage\\animate\\button\\hoverSO.png","art\\settingPage\\animate\\button\\pressSO.png",0,60,0,60);
    static AButton exitButton=new AButton("art\\settingPage\\animate\\button\\normalE.png","art\\settingPage\\animate\\button\\hoverE.png","art\\settingPage\\animate\\button\\pressE.png");

    static   AImagePanel settingPage=new AImagePanel("art\\settingPage\\static\\background\\background.png");
    static  AImagePanel groupMemberImage=new AImagePanel("art\\settingPage\\static\\background\\groupMembers.png");
    static   ALabel textLabel=new ALabel(270);

    public SettingPanel(){
        textLabel.setText(username);
        textLabel.label.setFont(font(28));

        setBorder(new EmptyBorder(20,0,0,0));
        settingPage.mainPanel.setBorder(new EmptyBorder(40,0,0,0));
        settingPage.mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,18));
        setVisible(false);
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        setOpaque(false);
        addButtons();
        buttonAction();

        groupMemberImage.setPanelOff();
        groupMemberImage.addMain(exitGroupButton);

        add(settingPage);
        add(groupMemberImage);
    }

    void addButtons(){
        settingPage.addMain(textLabel);
        settingPage.addMain(groupButton);
        settingPage.addMain(signOutButton);
        settingPage.addMain(exitButton);

    }
    void buttonAction(){
        MouseListener action=new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==groupButton.label){
                    settingPage.setPanelOff();
                    groupMemberImage.setPanelOn();

                } else if (e.getSource()==signOutButton.label) {

                } else if (e.getSource()==exitButton.label) {
                    AFrame.frame.dispose();
                    System.exit(0);
                } else if (e.getSource()==exitGroupButton.label) {
                    backToSettings();
                }
            }
        };
        groupButton.label.addMouseListener(action);
        signOutButton.label.addMouseListener(action);
        exitButton.label.addMouseListener(action);
        exitGroupButton.label.addMouseListener(action);
    } Font font(float size){

        try
        {
            File fontFile = new File("font/inter/Inter-Regular.ttf");
            Font  customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(size);
            return customFont;

        }catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return null;
        }


    }

public static void backToSettings(){
        settingPage.setPanelOn();
        groupMemberImage.setPanelOff();
}
}
class ALabel extends JPanel{
    JLabel label=new JLabel();
    ALabel(int width){
        setBackground(new Color(0));
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        setPreferredSize(new Dimension(width,40));


        label.setBackground(new Color(0x3EC4E8));
//    label.setOpaque(true);
        label.setForeground(new Color(0xFFFFFF));
        add(label);
    }
    void setText(String text){
        label.setText(text);
    }

}