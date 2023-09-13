package Pages.ManagePage.Register;

import Pages.ManagePage.ManagePanel;
import BackEnd.RowInfoHolder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StaffRegisterPanel extends ManageRegisterPanel {
    public StaffRegisterPanel(String file) {
        super(file);
        initializeList();
        setPlacement();
        initializeComboBox();
        addComponents();
    }

    @Override
    void addComponents() {
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
    @Override
    void initializeList(){
        super.initializeList();
        studentBatchList=new String[]{"Guard","Janitor","Assistant","Receptionist"};

    }
    @Override
    void addButtonAction(){
        super.addButtonAction();
        MouseAdapter action=new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource()==saveButton.label) {
                    RowInfoHolder infoHolder=new RowInfoHolder(studentIdLabel.getText(),firstNameTextBox.getString(),lastNameTextBox.getString(),yearComboBox.getText(), monthComboBox.getText(),dayComboBox.getText(),genderComboBox.getText(),studentBatchComboBox.getText(),emailTextBox.getString(),phoneNoTextBox.getString());
                   infoHolder.display();
                    ManagePanel.staffListPanel.addRow(infoHolder);
                    ManagePanel.backToOptionPanel();
                    clearAll();
                }
            }
        };

        saveButton.label.addMouseListener(action);
    }


}
