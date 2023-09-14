package BackEnd;

import java.sql.*;

public class DeleteInfo {
    String displayID;
    int id;

    static String jdbcUrl = "jdbc:mysql://localhost:3306/school_management";
    static String jdbcUsername = "root";
    static String jdbcPassword = "password";

    public DeleteInfo(String displayID){
        this.displayID = displayID;
    }

    public void deleteStudent(){
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            String selectQuery = "SELECT student_id FROM student WHERE display_id = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, this.displayID);
            ResultSet resultSet = selectStatement.executeQuery();
            if(resultSet.next()) {
                this.id = resultSet.getInt("student_id");
            }
            String deletePhoneQuery = "DELETE FROM student_phone_number WHERE student_id = ?";
            PreparedStatement deletePhone = connection.prepareStatement(deletePhoneQuery);
            deletePhone.setInt(1, this.id);
            deletePhone.executeUpdate();
            String deleteEmailQuery = "DELETE FROM student_email WHERE student_id = ?";
            PreparedStatement deleteEmail = connection.prepareStatement(deleteEmailQuery);
            deleteEmail.setInt(1, this.id);
            deleteEmail.executeUpdate();
            String deleteSql = "DELETE FROM student WHERE student_id = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
            deleteStatement.setInt(1, this.id);
            deleteStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteTeacher(){
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            String selectQuery = "SELECT teacher_id FROM teacher WHERE display_id = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, this.displayID);
            ResultSet resultSet = selectStatement.executeQuery();
            if(resultSet.next()) {
                this.id = resultSet.getInt("teacher_id");
            }
            String deletePhoneQuery = "DELETE FROM teacher_phone_number WHERE teacher_id = ?";
            PreparedStatement deletePhone = connection.prepareStatement(deletePhoneQuery);
            deletePhone.setInt(1, this.id);
            deletePhone.executeUpdate();
            String deleteEmailQuery = "DELETE FROM teacher_email WHERE teacher_id = ?";
            PreparedStatement deleteEmail = connection.prepareStatement(deleteEmailQuery);
            deleteEmail.setInt(1, this.id);
            deleteEmail.executeUpdate();
            String deleteSql = "DELETE FROM teacher WHERE teacher_id = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
            deleteStatement.setInt(1, this.id);
            deleteStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
