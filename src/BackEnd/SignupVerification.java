package BackEnd;

import javax.swing.*;
import java.sql.*;

public class SignupVerification {
    static String jdbcUrl = "jdbc:mysql://localhost:3306/school_management";
    static String jdbcUsername = "root";
    static String jdbcPassword = "password";

    String username;
    String password ;
    String confirmPassword;

    public SignupVerification(String username, String password, String confirmPassword){
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
    public void registerUser() {

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            if (usernameExists(connection)) {
                JOptionPane.showMessageDialog(null, "username already exists", "signup error", JOptionPane.ERROR_MESSAGE);
            }
            else if (verifyPasswordIntegrity(password)){
                JOptionPane.showMessageDialog(null, "Password is not secure enough", "signup error",JOptionPane.ERROR_MESSAGE);
            }
            else {
                if (password.equals(confirmPassword)) {
                    addUser(connection, username, password);
                    ControlPanels.showLogin();
                } else {
                    JOptionPane.showMessageDialog(null, "passwords do not match", "signup Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean usernameExists(Connection connection) {
        String selectQuery = "SELECT username FROM user_login WHERE username = ?";
        try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
            selectStatement.setString(1, username);
            ResultSet resultSet = selectStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void addUser(Connection connection, String username, String password) {
        String insertQuery = "INSERT INTO user_login(username, password) VALUES(?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean verifyPasswordIntegrity(String password){
        if (password.equals("")){
            return true;
        }
        return false;
    }
}
