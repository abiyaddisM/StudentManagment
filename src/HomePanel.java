import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HomePanel extends AImagePanel {

    private AImagePanel aboutUsPanel=new AImagePanel("art\\homePage\\static\\aboutUs\\background.png");
    private AImagePanel statsPanel=new AImagePanel("art\\homePage\\static\\stats\\background.png");
    private AImagePanel yearCoursePanel=new AImagePanel("art\\homePage\\static\\year\\background.png");
    private AImagePanel totalStudentImage=new AImagePanel("art\\homePage\\static\\stats\\totalStudent.png");
    private AImagePanel totalTeacherImage=new AImagePanel("art\\homePage\\static\\stats\\totalTeacher.png");
    private AImagePanel totalStaffImage=new AImagePanel("art\\homePage\\static\\stats\\totalStaff.png");



    HomePanel(String file) {
        super(file);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,11,10));
        statsPanel.mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,11,5));
        addPanel();
        addStatsPanel();
    }
    void addPanel(){
     addMain(aboutUsPanel);
     addMain(statsPanel);
     addMain(yearCoursePanel);
    }
    void addStatsPanel(){
        statsPanel.addMain(totalStudentImage);
        statsPanel.addMain(totalTeacherImage);
        statsPanel.addMain(totalStaffImage);
    }
}
