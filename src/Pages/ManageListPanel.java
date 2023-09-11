package Pages;

import AClass.*;
import src.RowInfoHolder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

public class ManageListPanel extends AImagePanel {

    private  int rowIdex=0;
    private static int size=20;
    private AButton backButton=new AButton("art\\managmentsPage\\register\\animated\\exitButton\\normalE.png","art\\managmentsPage\\register\\animated\\exitButton\\hoverE.png","art\\managmentsPage\\register\\animated\\exitButton\\pressE.png",0,0,0,779);
    private AImagePanel holderPanel=new AImagePanel("art\\managmentsPage\\lists\\static\\background\\holderBackground.png",81,0,0,0);
    private JPanel panel=new JPanel();


    ArrayList<ATableRow> tableRows = new ArrayList<ATableRow>();

    public ManageListPanel(String file, ArrayList<RowInfoHolder> infoHolder){
        super(file);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        panel.setOpaque(false);
        setRowPlug(infoHolder);
        addPanels();
        backToOptionPanel();
        addRows();
        scrollFunction();
        deleteRow();
    }

    void addPanels(){
        addMain(backButton);
        addMain(holderPanel);
    }




    void setRowPlug(ArrayList <RowInfoHolder> infoHolders){

        for (int i = 0; i < infoHolders.size(); i++) {
            RowInfoHolder infoHolder=infoHolders.get(i);
            tableRows.add(new ATableRow(infoHolder));
        }


    }
    void addRows(){
        holderPanel.mainPanel.setBorder(new EmptyBorder(-1,0,0,0));
        holderPanel.mainPanel.setLayout(new BorderLayout());
        holderPanel.addMain(panel);
        for (Integer i = 0; i < tableRows.size(); i++) {
            ATableRow tableRow=tableRows.get(i);
            panel.add(tableRow);
        }

    }




    void scrollFunction(){
        for (Integer i = 0; i < tableRows.size(); i++) {
            ATableRow textBox = tableRows.get(i);


            textBox.addMouseWheelListener(new MouseWheelListener() {
                int speed=25;
                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {
                    int rotation = e.getWheelRotation();
                    if (rotation > 0) {

                            panel.setBorder(new EmptyBorder(rowIdex,0,0,0));
//                            tableRows.get((int) rowIdex).setVisible(false);
                            rowIdex-=speed;
                            System.out.println(rowIdex);

                    } else {

                        if(rowIdex<0) {
                            rowIdex += speed;
                            panel.setBorder(new EmptyBorder(rowIdex, 0, 0, 0));
                            System.out.println(rowIdex);
                        }
                    }
                }
            });
        }
    }
    int I;
    void deleteRow(){
        for (int i = 0; i < tableRows.size(); i++) {
           I = i;
            ATableRow row = tableRows.get(i);

            row.deleteButton.label.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {

                 row.setPanelOff();
                   System.out.println(I);

               }
           });
        }
    }
    void backToOptionPanel(){
        backButton.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManagePanel.backToOptionPanel();
                rowIdex=0;
                panel.setBorder(new EmptyBorder(0,0,0,0));
            }
        });
    }
}
