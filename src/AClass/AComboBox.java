package AClass;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class AComboBox extends JPanel {
    ACheckBoxText comboBox;
    JPanel listBackground=new JPanel();
    AButtonText listButton[];
    AImagePanel listPanel;
    JWindow window=new JWindow();
    String listText[];
    public AComboBox(String[] listText){
        this.listText=listText;
        listButton=new AButtonText[listText.length];
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        setOpaque(false);
    }
    AComboBox(String []listText,int top,int left,int bottom,int right){
        this(listText);
        setBorder(new EmptyBorder(top,left,bottom,right));
    }

    public void setComboBox(String normalNUrl, String hoverNUrl, String normalPUrl, String hoverPUrl){
        comboBox=new ACheckBoxText(normalNUrl,hoverNUrl,normalPUrl,hoverPUrl);
    }
    public void setListButton(String normalUrl, String hoverUrl, String pressUrl){
        for (int i = 0; i < listText.length; i++) {
            listButton[i]=new AButtonText(normalUrl,hoverUrl,pressUrl);
            listButton[i].text.setText(listText[i]);
        }
    }
    public void addToListPanel(String backgroundUrl){
        add(comboBox);
        listPanel=new AImagePanel(backgroundUrl);
        listBackground.setBackground(new Color(0x1B1E2A));
        listBackground.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        listPanel.mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,3));
        for (int i = 0; i < listButton.length; i++) {
            listPanel.addMain(listButton[i]);

        }
//        addComboBoxPressAction();
        toolkitAction();

        listBackground.add(listPanel);
        window.add(listBackground);
        window.pack();
    }
    boolean state=false;
    private  int rowIdex = 0;

    public void addComboBoxPressAction(){
        comboBox.imagePanel.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point buttonLocation = comboBox.imagePanel.label.getLocationOnScreen();
                window.setBounds(buttonLocation.x,buttonLocation.y+40 ,listPanel.label.getWidth(),listPanel.label.getHeight());

                if (!state){
                    window.setVisible(true);
                    state=true;
                }
                listPanel.mainPanel.setBorder(new EmptyBorder(rowIdex,0,0,0));
            }
        });
        for (int i = 0; i < listButton.length; i++) {

            AButtonText button=listButton[i];
            button.label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    comboBox.setText(button.text.getText());
                }
            });


        }

    }
    public void addComboBoxScrollAction(){
        listPanel.mainPanel.addMouseWheelListener(new MouseWheelListener() {
            int speed=9;
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int rotation = e.getWheelRotation();
                if (rotation > 0) {

                    listPanel.mainPanel.setBorder(new EmptyBorder(rowIdex,0,0,0));
//                            tableRows.get((int) rowIdex).setVisible(false);
                    rowIdex-=speed;

                } else {

                    if(rowIdex<0) {
                        rowIdex += speed;
                        listPanel.mainPanel.setBorder(new EmptyBorder(rowIdex, 0, 0, 0));
                    }
                }
            }
        });
    }

    String getSelectedItem(){
        return comboBox.getText();
    }
    void toolkitAction(){
        for (int i = 0; i < listButton.length; i++) {

            AButtonText button=listButton[i];
            button.label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    comboBox.setText(button.text.getText());
                }
            });


        }
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        {
            toolkit.addAWTEventListener(event -> {
                if (event instanceof MouseEvent) {

                    MouseEvent mouseEvent = (MouseEvent) event;
                   if(mouseEvent.getID() == MouseEvent.MOUSE_CLICKED) {
                       if (mouseEvent.getButton()==MouseEvent.BUTTON1) {
                               if (!mouseEvent.getPoint().equals(listPanel.innerPanel.getMousePosition())&&!mouseEvent.getPoint().equals(comboBox.getMousePosition())) {
                                   if (state) {
                                       window.setVisible(false);
                                       state = false;
                                       rowIdex = 0;
                                       comboBox.flip();


                                   }

                           }


                           if (mouseEvent.getPoint().equals(comboBox.getMousePosition())) {
                               Point buttonLocation = comboBox.imagePanel.label.getLocationOnScreen();
                               window.setBounds(buttonLocation.x, buttonLocation.y + 40, listPanel.label.getWidth(), listPanel.label.getHeight());

                               if (!state) {
                                   window.setVisible(true);
                                   state = true;

                               }else{
                                   window.setVisible(false);
                                   state = false;
                                   rowIdex = 0;
                                   System.out.println("h");
                               }
                               listPanel.mainPanel.setBorder(new EmptyBorder(rowIdex, 0, 0, 0));
                           }

                       }
                   }


                }

            }, AWTEvent.MOUSE_EVENT_MASK);
        }
    }



}

