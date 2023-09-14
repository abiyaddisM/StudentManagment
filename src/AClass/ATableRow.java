package AClass;

import AClass.Button.AButton;
import BackEnd.RowInfoHolder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ATableRow extends AImagePanel {
    public ALabel idText=new ALabel(125);
    public ALabel nameText=new ALabel(164);
    public ALabel yearText=new ALabel(119);
    public ALabel genderText=new ALabel(95);
    public ALabel placeText=new ALabel(140);
    public RowInfoHolder infoHolder;
    public AButton editButton=new AButton("art/managmentsPage/lists/animated/editButton/normal.png","art/managmentsPage/lists/animated/editButton/hover.png",
            "art/managmentsPage/lists/animated/editButton/press.png",0,40,0,0);
    public AButton deleteButton=new AButton("art/managmentsPage/lists/animated/deleteButton/normal.png","art/managmentsPage/lists/animated/deleteButton/hover.png",
            "art/managmentsPage/lists/animated/deleteButton/press.png",0,50,0,0);



    public ATableRow(RowInfoHolder infoHolder) {
        super("art/managmentsPage/lists/static/background/rowBackground2.png",0,0,3,0);
        this.infoHolder=infoHolder;
        mainPanel.setBorder(new EmptyBorder(3,0,0,0));
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        initializeUI(infoHolder);
        addTexts();
        addButton();
    }

    public void initializeUI(RowInfoHolder infoHolder) {

        idText.label.setFont(font(13));
        idText.label.setForeground(new Color(0xFFCFD5DE, true));
        idText.label.setBorder(new EmptyBorder(0,20,0,0));
        idText.setText(infoHolder.id);

        nameText.label.setFont(font(13));
        nameText.label.setForeground(new Color(0xFFCFD5DE, true));
        nameText.setText(infoHolder.firstName+" "+infoHolder.lastName);

        yearText.label.setFont(font(13));
        yearText.label.setForeground(new Color(0xFFCFD5DE, true));
        yearText.setText(infoHolder.year);

        genderText.label.setFont(font(13));
        genderText.label.setForeground(new Color(0xFFCFD5DE, true));
        genderText.setText(infoHolder.gender);

        placeText.label.setFont(font(13));
        placeText.label.setForeground(new Color(0xFFCFD5DE, true));
        placeText.setText(infoHolder.department);


    }
    private void addTexts(){
        addMain(idText);
        addMain(nameText);
        addMain(yearText);
        addMain(genderText);
        addMain(placeText);
    }
    private void addButton(){
        addMain(editButton);
        addMain(deleteButton);
    }


    Font font(float size){

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


}
class ALabel extends JPanel{
    JLabel label=new JLabel();
ALabel(int width){
    setBackground(new Color(0));
    setOpaque(false);
    setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
    setPreferredSize(new Dimension(width,18));


    label.setBackground(new Color(0x3EC4E8));
//    label.setOpaque(true);
    add(label);
}
void setText(String text){
    label.setText(text);
}
}