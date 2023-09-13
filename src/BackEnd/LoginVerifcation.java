package BackEnd;

import javax.swing.*;
import java.sql.*;

public class LoginVerifcation {

    static String jdbcUrl = "jdbc:mysql://localhost:3306/school_management";
    static String jdbcUsername = "root";
    static String jdbcPassword = "password";

    String username, password;

    public LoginVerifcation(String username, String password){
        this.username = username;
        this.password = password;
    }
    public boolean verifyAccount(){

        try{
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            String query = "SELECT password FROM user_login WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                String pass = resultSet.getString("password");

                if (pass.equals(password)){
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "username and password do not match", "login error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "username doesn't exist", "login error", JOptionPane.ERROR_MESSAGE);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
