import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HomePanel extends AImagePanel {

    private AImagePanel aboutUsPanel=new AImagePanel("art\\homePage\\static\\aboutUs\\background.png");
    private AImagePanel statsPanel=new AImagePanel("art\\homePage\\static\\stats\\background.png");
    private AImagePanel schoolYearPanel=new AImagePanel("art\\homePage\\static\\year\\background.png");

    private AImagePanel aboutUsTextImage=new AImagePanel("art\\homePage\\static\\aboutUs\\aboutUs.png");
    private AImageLabel aboutUsBoxImage=new AImageLabel("art\\homePage\\static\\aboutUs\\image.png",24,0,0,0);
    private AButton startButton=new AButton("art\\homePage\\animate\\startButton\\normal.png","art\\homePage\\animate\\startButton\\hover.png",
            "art\\homePage\\animate\\startButton\\press.png",216,0,0,230);

    private AImagePanel totalStudentImage=new AImagePanel("art\\homePage\\static\\stats\\totalStudent.png");
    private AButton totalStudentButton=new AButton("art\\homePage\\animate\\addButton\\2\\normal.png","art\\homePage\\animate\\addButton\\2\\hover.png",
            "art\\homePage\\animate\\addButton\\2\\press.png",19,230,0,0);
    private AImagePanel totalTeacherImage=new AImagePanel("art\\homePage\\static\\stats\\totalTeacher.png");
    private AButton totalTeacherButton=new AButton("art\\homePage\\animate\\addButton\\3\\normal.png","art\\homePage\\animate\\addButton\\3\\hover.png",
            "art\\homePage\\animate\\addButton\\3\\press.png",19,230,0,0);
    private AImagePanel totalStaffImage=new AImagePanel("art\\homePage\\static\\stats\\totalStaff.png");
    private AButton totalStaffButton=new AButton("art\\homePage\\animate\\addButton\\1\\normal.png","art\\homePage\\animate\\addButton\\1\\hover.png",
            "art\\homePage\\animate\\addButton\\1\\press.png",19,230,0,0);

    //This are the button numbers that go 1 2 3 4
    private AButton schoolYearOneButton=new AButton("art\\homePage\\animate\\schoolYear\\1\\1Normal.png","art\\homePage\\animate\\schoolYear\\1\\1Hover.png","art\\homePage\\animate\\schoolYear\\1\\1Press.png");
    private AButton schoolYearTwoButton=new AButton("art\\homePage\\animate\\schoolYear\\2\\1Normal.png","art\\homePage\\animate\\schoolYear\\2\\1Hover.png","art\\homePage\\animate\\schoolYear\\2\\1Press.png");
    private AButton schoolYearThreeButton=new AButton("art\\homePage\\animate\\schoolYear\\3\\3Normal.png","art\\homePage\\animate\\schoolYear\\3\\3Hover.png","art\\homePage\\animate\\schoolYear\\3\\3Press.png");
    private AButton schoolYearFourButton=new AButton("art\\homePage\\animate\\schoolYear\\4\\4Normal.png","art\\homePage\\animate\\schoolYear\\4\\4Hover.png","art\\homePage\\animate\\schoolYear\\4\\4Press.png");





    HomePanel(String file) {
        super(file);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,11,10));
        statsPanel.mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,11,5));
        schoolYearPanel.mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,6,9));

        addPanel();
        addAboutUsPanel();
        addStatsPanel();
        addSchoolYearPanel();
        setVisible(false);
    }
    void addPanel(){
     addMain(aboutUsPanel);
     addMain(statsPanel);
     addMain(schoolYearPanel);
    }
    void addAboutUsPanel(){
        aboutUsPanel.addMain(aboutUsTextImage);
        aboutUsPanel.addMain(aboutUsBoxImage);
        aboutUsTextImage.addMain(startButton);
    }
    void addStatsPanel(){
        totalStudentImage.addMain(totalStudentButton);
        statsPanel.addMain(totalStudentImage);
        totalTeacherImage.addMain(totalTeacherButton);
        statsPanel.addMain(totalTeacherImage);
        totalStaffImage.addMain(totalStaffButton);
        statsPanel.addMain(totalStaffImage);
    }
    void addSchoolYearPanel(){
        schoolYearPanel.addMain(schoolYearOneButton);
        schoolYearPanel.addMain(schoolYearTwoButton);
        schoolYearPanel.addMain(schoolYearThreeButton);
        schoolYearPanel.addMain(schoolYearFourButton);
    }
}
