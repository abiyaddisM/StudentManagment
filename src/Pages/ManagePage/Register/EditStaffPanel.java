package Pages.ManagePage.Register;

import BackEnd.EditInfo;
import BackEnd.RowInfoHolder;
import Pages.ManagePage.ManagePanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditStaffPanel extends ManageRegisterPanel{
    public EditStaffPanel( ) {
        super("art/managmentsPage/edit/static/background/staffEditBackground.png");
        refreshButton.label.setIcon(new ImageIcon("art/managmentsPage/edit/static/background/holder.png"));
        initializeList();
        setPlacement();
        initializeComboBox();
        addComponents();
    }
    @Override
    void initializeList(){
        super.initializeList();
        studentBatchList=new String[]{"Janitor","Guard","Receptionist","Assistant"};


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
    void addButtonAction(){
        super.addButtonAction();
        MouseAdapter action=new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource()==saveButton.label) {
                    RowInfoHolder infoHolder=new RowInfoHolder(studentIdLabel.getText(),firstNameTextBox.getString(),lastNameTextBox.getString(),yearComboBox.getText(), monthComboBox.getText(),dayComboBox.getText(),genderComboBox.getText(),studentBatchComboBox.getText(),emailTextBox.getString(),phoneNoTextBox.getString());
                    EditInfo editInfo = new EditInfo(infoHolder);
                    editInfo.updateStaff();
                    ManagePanel.backToOptionPanel();
                    clearAll();
                }
            }
        };

        saveButton.label.addMouseListener(action);
    }

}
