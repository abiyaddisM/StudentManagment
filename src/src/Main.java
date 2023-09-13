package src;
import AClass.Frame.ATitleBar;
import BackEnd.ControlPanels;
import Pages.*;
import AClass.Frame.AFrame;
import Pages.ManagePage.ManagePanel;

public class Main {
    public static void main(String[] args) {


        ATitleBar titleBar=new ATitleBar();
        LoginPanel loginPanel=new LoginPanel("art/loginPage/background/background.png");
        SignUpPanel signUpPanel=new SignUpPanel("art/signUp/static/background/background.png");
        TopPanel topPanel=new TopPanel("art/topBar/static/background.png");
        HomePanel homePanel=new HomePanel("art\\homePage\\static\\background\\background1.png");
        ManagePanel managePanel=new ManagePanel();
        AFrame frame=new AFrame();
        frame.add(titleBar);
        frame.add(loginPanel);
        frame.add(signUpPanel);
        frame.add(topPanel);
        frame.add((homePanel));
        frame.add(managePanel);

        ControlPanels controlPanels=new ControlPanels();
        ControlPanels.setLogin(loginPanel);
        ControlPanels.setSignUp(signUpPanel);
        ControlPanels.setTop(topPanel);
        ControlPanels.setHome(homePanel);
        ControlPanels.setManage(managePanel);
    }
}