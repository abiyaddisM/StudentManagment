package Pages.ManagePage.Register;

import BackEnd.RowInfoHolder;
import Pages.ManagePage.ManagePanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditStaffPanel extends StaffRegisterPanel{
    public EditStaffPanel( ) {
        super("art/managmentsPage/edit/static/background/staffEditBackground.png");
        refreshButton.label.setIcon(new ImageIcon("art/managmentsPage/edit/static/background/holder.png"));

    }
    @Override
    void addButtonAction(){
        super.addButtonAction();
        MouseAdapter action=new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource()==saveButton.label) {
                    RowInfoHolder infoHolder=new RowInfoHolder(studentIdLabel.getText(),firstNameTextBox.getString(),lastNameTextBox.getString(),yearComboBox.getText(), monthComboBox.getText(),dayComboBox.getText(),genderComboBox.getText(),studentBatchComboBox.getText(),emailTextBox.getString(),phoneNoTextBox.getString());

                    ManagePanel.backToOptionPanel();
                    clearAll();
                }
            }
        };

        saveButton.label.addMouseListener(action);
    }

}
