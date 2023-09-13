package BackEnd;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ControlPanels {
    static int tabsDelay=5;
    public static int delayInMilliSeconds = 150;
    public static ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);


    private static Component login, signUp, top,home, course, manage, settings;
    public ControlPanels(Component login, Component signUp, Component top,Component home, Component settings, Component manage, Component course) {
        ControlPanels.login = login;
        ControlPanels.signUp = signUp;
        ControlPanels.top = top;
        ControlPanels.home =home;
        ControlPanels.settings = settings;
        ControlPanels.manage = manage;
        ControlPanels.course = course;
    }
    public ControlPanels(){
        this(new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel());
    }

    public static void setLogin(Component login) {
        ControlPanels.login = login;
    }

    public static void setSignUp(Component signUp) {
        ControlPanels.signUp = signUp;
    }

    public static void setTop(Component top) {
        ControlPanels.top = top;
    }
    public static void setHome(Component home) {
        ControlPanels.home = home;
    }

    public static void setSettings(Component settings) {
        ControlPanels.settings = settings;
    }

    public static void setManage(Component manage) {
        ControlPanels.manage = manage;
    }

    public static void setCourse(Component course) {
        ControlPanels.course = course;
    }


    private static void hideAllExcept(Component component) {
        Component[] components = {login, signUp, top,home, settings, manage, course};
        for (Component c : components) {
            if (c != null && c != component) {
                c.setVisible(false);
            }
        }
    }
    private static void hideAllExcept(Component component,Component component1) {
        Component[] components = {login, signUp, top,home, settings, manage, course};
        for (Component c : components) {
            if (c != null && c != component && c!=component1) {
                c.setVisible(false);
            }
        }
    }

    public static void showSignUp() {
        ControlPanels.executor.schedule(() -> {
            signUp.setVisible(true);
            hideAllExcept(signUp);
        }, ControlPanels.delayInMilliSeconds, TimeUnit.MILLISECONDS);
    }

    public static void showLogin() {
        ControlPanels.executor.schedule(() -> {
            login.setVisible(true);
            hideAllExcept(login);
        }, ControlPanels.delayInMilliSeconds, TimeUnit.MILLISECONDS);
    }

    public static void showHome() {
        ControlPanels.executor.schedule(() -> {
            top.setVisible(true);
            home.setVisible(true);
            hideAllExcept(top,home);
        }, ControlPanels.delayInMilliSeconds+tabsDelay, TimeUnit.MILLISECONDS);
    }

    public static void showSettings() {
        ControlPanels.executor.schedule(() -> {
            settings.setVisible(true);
            hideAllExcept(top,settings);
        }, ControlPanels.delayInMilliSeconds+tabsDelay, TimeUnit.MILLISECONDS);

    }

    public static void showManage(int time) {
        ControlPanels.executor.schedule(() -> {
            manage.setVisible(true);
            hideAllExcept(top,manage);
        }, ControlPanels.delayInMilliSeconds+tabsDelay-time, TimeUnit.MILLISECONDS);

    }

    public static void showCourse() {
        ControlPanels.executor.schedule(() -> {
            course.setVisible(true);
            hideAllExcept(top,course);
        }, ControlPanels.delayInMilliSeconds+tabsDelay, TimeUnit.MILLISECONDS);

    }
}
