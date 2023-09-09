package AClass;

import src.RowInfoHolder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ATableRow extends AImagePanel {
    private ALabel idText=new ALabel(125);
    private ALabel nameText=new ALabel(167);
    private ALabel yearText=new ALabel(117);
    private ALabel genderText=new ALabel(95);
    private ALabel placeText=new ALabel(140);
    private AButton editButton=new AButton("art\\managmentsPage\\lists\\animated\\editButton\\normal.png","art\\managmentsPage\\lists\\animated\\editButton\\hover.png",
            "art\\managmentsPage\\lists\\animated\\editButton\\press.png",0,40,0,0);
    public AButton deleteButton=new AButton("art\\managmentsPage\\lists\\animated\\deleteButton\\normal.png","art\\managmentsPage\\lists\\animated\\deleteButton\\hover.png",
            "art\\managmentsPage\\lists\\animated\\deleteButton\\press.png",0,50,0,0);



    public ATableRow(RowInfoHolder infoHolder) {
        super("art\\managmentsPage\\lists\\static\\background\\rowBackground1.png");
        mainPanel.setBorder(new EmptyBorder(14,0,0,0));
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        initializeUI(infoHolder);
        addTexts();
        addButton();
    }

    private void initializeUI(RowInfoHolder infoHolder) {
        idText.label.setFont(font(15));
        idText.label.setForeground(new Color(0xFF799CD1, true));
        idText.label.setBorder(new EmptyBorder(0,20,0,0));
        idText.setText(infoHolder.id);

        nameText.label.setFont(font(15));
        nameText.label.setForeground(new Color(0xFF799CD1, true));
        nameText.setText(infoHolder.name);

        yearText.label.setFont(font(15));
        yearText.label.setForeground(new Color(0xFF799CD1, true));
        yearText.setText(infoHolder.thirdColumn);

        genderText.label.setFont(font(15));
        genderText.label.setForeground(new Color(0xFF799CD1, true));
        genderText.setText(infoHolder.gender);

        placeText.label.setFont(font(15));
        placeText.label.setForeground(new Color(0xFF799CD1, true));
        placeText.setText(infoHolder.placeHolder);


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