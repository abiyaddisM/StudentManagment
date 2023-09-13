package Pages;
import AClass.*;
import AClass.Button.AButton;
import AClass.Button.ACheckBox;
import AClass.Button.AStringButton;
import AClass.TextArea.ATextBox;
import BackEnd.ControlPanels;
import BackEnd.LoginVerifcation;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class LoginPanel extends AImagePanel {
    static boolean state=true;

   private AImageLabel loginImage=new AImageLabel("art/loginPage/comp/loginIcon.png",61,163,36,163);//The login image at the top
    private AImageLabel usernameImage=new AImageLabel("art/loginPage/comp/userAndPass/username.png",0,0,5,0);//The "username" text above the text box's
    private ATextBox usernameBox=new ATextBox();//Text box for the username
    private AImageLabel passwordImage=new AImageLabel("art/loginPage/comp/userAndPass/password.png",25,0,5,0);//The "password" text in between the text box's
    private AImageLabel.APasswordTextBox passwordBox=new AImageLabel.APasswordTextBox();//Text box for the password
    private ACheckBox checkBox=new ACheckBox(15,0, 17,0);//A check boc
    private AImageLabel rememberMeImage=new AImageLabel("art/loginPage/comp/userAndPass/rememberMe.png",17,5,17,178);//The "remember me" text below the text box's
    private AStringButton forgotPasswordButton=new AStringButton("Forgot Password?");//A string button for that says "Forgort Password?"
    private AButton loginbutton=new AButton("art/loginPage/comp/login/normal3.png","art/loginPage/comp/login/hover.png","art/loginPage/comp/login/press2.png",42,0,82,0);
    private AImageLabel dontHaveAccImage=new AImageLabel("art/loginPage/comp/login/dontHaveAcc.png",0,0,2,0);
    private AStringButton signUpButton=new AStringButton("Sign up");





    public LoginPanel(String file) {
        super(file,40,0,0,0);
        addToPanel();
        addLoginbuttonAction();
        addSignUpButtonAction();
        mainPanel.setBorder(new EmptyBorder(0,28,0,28));

    }
    void addToPanel(){
        addMain(loginImage);
        addMain(usernameImage);
        addMain(usernameBox);
        addMain(passwordImage);
        addMain(passwordBox);
        addMain(checkBox);
        addMain(rememberMeImage);
        addMain(forgotPasswordButton);
        addMain(loginbutton);
        addMain(dontHaveAccImage);
        addMain(signUpButton);
    }
    Component getThisPanel(){
        return this;
    }
    void addLoginbuttonAction(){
        loginbutton.label.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                String username=usernameBox.textLabel.getText();
                String password=passwordBox.textLabel.getText();
                LoginVerifcation loginVerifcation = new LoginVerifcation(username, password);
                    if (loginVerifcation.verifyAccount()){
                        ControlPanels.executor.schedule(() -> {
                            ControlPanels.showHome();
                        }, ControlPanels.delayInMilliSeconds, TimeUnit.MILLISECONDS);
                    }


            }
        });
    }
    void addSignUpButtonAction(){
        signUpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                usernameBox.textLabel.setText("");
                passwordBox.textLabel.setText("");
                ControlPanels.showSignUp();
            }
        });
    }



}
