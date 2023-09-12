package Pages.List;

import AClass.ATableRow;
import Pages.ManagePanel;
import src.RowInfoHolder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TeacherListPanel extends ManageListPanel{
    public TeacherListPanel(String file, ArrayList<RowInfoHolder> infoHolder) {
        super(file, infoHolder);
    }

    @Override
    void editInfo() {
        for (int i = 0; i < tableRows.size(); i++) {
            I = i;
            ATableRow row = tableRows.get(i);

            row.editButton.label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    row.infoHolder.display();
                    ManagePanel.backToOptionPanel();
                    ManagePanel.hideAllExcept(ManagePanel.editTeacherPanel);
                    ManagePanel.editTeacherPanel.setInformation(row.infoHolder);

                }
            });
        }
    }
}
