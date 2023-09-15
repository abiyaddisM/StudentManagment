package Pages.CoursePage;

import AClass.AImagePanel;
import AClass.Button.AButton;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DSCourse extends AImagePanel {
    static AButton exitButton = new AButton("art/managmentsPage/register/animated/exitButton/normalE.png", "art/managmentsPage/register/animated/exitButton/hoverE.png", "art/managmentsPage/register/animated/exitButton/pressE.png", 0, 0, 0, 230);

    public DSCourse() {
        super("art/coursePage/static/background/backgroundDS.png",15,0,0,0);
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        addMain(exitButton);
        addAction();
    }

    void addAction() {
        exitButton.label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CoursePanel.hideAllExcept(CoursePanel.optionPanel);
            }
        });
    }
}
