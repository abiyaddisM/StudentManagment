package Pages;

import AClass.*;
import src.RowInfoHolder;

import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

public class ListPanel extends AImagePanel {

    private  int rowIdex=0;
    private static int size=20;
    private AButton backButton=new AButton("art\\managmentsPage\\lists\\animated\\backButton\\normal.png","art\\managmentsPage\\lists\\animated\\backButton\\hover.png",
            "art\\managmentsPage\\lists\\animated\\backButton\\press.png",0,0,0,779);
    private AImagePanel holderPanel=new AImagePanel("art\\managmentsPage\\lists\\static\\background\\holderBackground.png",81,0,0,0);

    ArrayList<ATableRow> tableRows = new ArrayList<ATableRow>();

    public ListPanel(String file, ArrayList<RowInfoHolder> infoHolder){
        super(file);
        setRowPlug(infoHolder);
        addPanels();
        backToOptionPanel();
        addRows();
        scrollFunction();
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
        holderPanel.mainPanel.setBorder(new EmptyBorder(5,0,0,0));
        for (Integer i = 0; i < tableRows.size(); i++) {
            ATableRow tableRow=tableRows.get(i);
            holderPanel.addMain(tableRow);
        }

    }




    void scrollFunction(){
        for (Integer i = 0; i < tableRows.size(); i++) {
            ATableRow textBox = tableRows.get(i);


            textBox.addMouseWheelListener(new MouseWheelListener() {
                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {
                    int rotation = e.getWheelRotation();
                    if (rotation > 0) {
                        if (rowIdex < tableRows.size() - 4) {
                            tableRows.get((int) rowIdex).setVisible(false);
                            rowIdex++;
                            System.out.println(rowIdex);
                        }
                    } else {
                        if (rowIdex >= 1) {
                            rowIdex--;
                            tableRows.get(rowIdex).setVisible(true);
                            System.out.println(rowIdex);
                        }
                    }
                }
            });
        }
    }
    void backToOptionPanel(){
        backButton.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManagePanel.backToOptionPanel();

            }
        });
    }
}
