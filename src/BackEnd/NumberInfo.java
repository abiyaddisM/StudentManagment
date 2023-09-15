package BackEnd;

import java.sql.*;

public class NumberInfo {
    static String jdbcUrl = "jdbc:mysql://localhost:3306/school_management";
    static String jdbcUsername = "root";
    static String jdbcPassword = "password";
    int rowCount;

    public int getStudentNumberInfo(){
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
            Statement statement = connection.createStatement();

            String query = "SELECT COUNT(*) FROM student";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                rowCount = resultSet.getInt(1); // Get the count from the first (and only) column
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rowCount;
    }
    public int getTeacherNumberInfo(){
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
            Statement statement = connection.createStatement();

            String query = "SELECT COUNT(*) FROM teacher";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                rowCount = resultSet.getInt(1); // Get the count from the first (and only) column
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rowCount;
    }

    public int getStaffNumberInfo(){
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
            Statement statement = connection.createStatement();

            String query = "SELECT COUNT(*) FROM staff";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                rowCount = resultSet.getInt(1); // Get the count from the first (and only) column
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rowCount;
    }
}
