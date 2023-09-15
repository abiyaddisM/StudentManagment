package src;
import AClass.Frame.ATitleBar;
import BackEnd.ControlPanels;
import BackEnd.RememberMe;
import Pages.*;
import AClass.Frame.AFrame;
import Pages.CoursePage.CoursePanel;
import Pages.ManagePage.ManagePanel;

public class Main {
    public static void main(String[] args) {


        ATitleBar titleBar=new ATitleBar();
        LoginPanel loginPanel=new LoginPanel("art/loginPage/background/background.png");
        SignUpPanel signUpPanel=new SignUpPanel("art/signUp/static/background/background.png");
        TopPanel topPanel=new TopPanel("art/topBar/static/background.png");
        HomePanel homePanel=new HomePanel("art/homePage/static/background/background1.png");
        CoursePanel coursePanel=new CoursePanel();
        ManagePanel managePanel=new ManagePanel();
        SettingPanel settingPanel=new SettingPanel();
        AFrame frame=new AFrame();
        frame.add(titleBar);
        frame.add(loginPanel);
        frame.add(signUpPanel);
        frame.add(topPanel);
        frame.add((homePanel));
        frame.add(coursePanel);
        frame.add(managePanel);
        frame.add(settingPanel);


        ControlPanels.setLogin(loginPanel);
        ControlPanels.setSignUp(signUpPanel);
        ControlPanels.setTop(topPanel);
        ControlPanels.setHome(homePanel);
        ControlPanels.setCourse(coursePanel);
        ControlPanels.setManage(managePanel);
        ControlPanels.setSettings(settingPanel);
        boolean state= RememberMe.isRememberMeChecked();
        if(state){
            ControlPanels.showHome();
        }else {
            ControlPanels.showLogin();
        }
    }
}