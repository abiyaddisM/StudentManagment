package Pages.ManagePage.Register;

import BackEnd.AddInfo;
import BackEnd.RowInfoHolder;
import Pages.ManagePage.ManagePanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditStudentPanel extends StudentRegisterPanel {
    public EditStudentPanel() {
        super("art/managmentsPage/edit/static/background/studentEditBackground.png");
        refreshButton.label.setIcon(new ImageIcon("art/managmentsPage/edit/static/background/holder.png"));
    }

}

