package Pages.ManagePage.List;

import AClass.*;
import AClass.Button.AButton;
import AClass.Frame.AFrame;
import BackEnd.DeleteInfo;
import Pages.ManagePage.ManagePanel;
import BackEnd.RowInfoHolder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

abstract public class ManageListPanel extends AImagePanel {

    private  int rowIdex=0;
    private static int size=20;
    private AButton backButton=new AButton("art/managmentsPage/register/animated/exitButton/normalE.png","art/managmentsPage/register/animated/exitButton/hoverE.png","art/managmentsPage/register/animated/exitButton/pressE.png",0,0,0,779);
    private AImagePanel holderPanel=new AImagePanel("art/managmentsPage/lists/static/background/holderBackground.png",81,0,0,0);
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
        editInfo();
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
    abstract void deleteRow();
  abstract void editInfo();
  public void updateInfo(int i,RowInfoHolder infoHolder){
      tableRows.get(i).infoHolder.id=infoHolder.id;
      tableRows.get(i).infoHolder.firstName=infoHolder.firstName;
      tableRows.get(i).infoHolder.lastName=infoHolder.lastName;
      tableRows.get(i).infoHolder.year=infoHolder.year;
      tableRows.get(i).infoHolder.month=infoHolder.month;
      tableRows.get(i).infoHolder.day=infoHolder.day;
      tableRows.get(i).infoHolder.phoneNo=infoHolder.phoneNo;
      tableRows.get(i).infoHolder.department=infoHolder.department;
      tableRows.get(i).infoHolder.gender=infoHolder.gender;
      tableRows.get(i).infoHolder.email=infoHolder.email;

      tableRows.get(i).initializeUI(infoHolder);
      AFrame.frame.repaint();


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
   public void addRow(RowInfoHolder infoHolder){
        tableRows.add(new ATableRow(infoHolder));
        panel.add(tableRows.get(tableRows.size()-1));
       AFrame.frame.validate();
       AFrame.frame.repaint();
        deleteRow();
        editInfo();
    }
}
