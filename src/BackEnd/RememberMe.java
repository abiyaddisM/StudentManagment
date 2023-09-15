package BackEnd;

import java.sql.*;

public class RememberMe {
    static String jdbcUrl = "jdbc:mysql://localhost:3306/school_management";
    static String jdbcUsername = "root";
    static String jdbcPassword = "password";
    boolean checkBoxValue;
    public boolean isRememberMeChecked(){
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);


            String query = "SELECT value FROM remember_me";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                checkBoxValue = resultSet.getBoolean("value");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return checkBoxValue;
    }

    public void updateCheckBoxValue(Boolean isChecked){
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            String updateQuery = "UPDATE remember_me SET value = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            if (isChecked){
                preparedStatement.setBoolean(1, true);
            }
            else{
                preparedStatement.setBoolean(1, false);
            }
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
