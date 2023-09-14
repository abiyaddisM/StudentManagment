package BackEnd;

import java.sql.*;
import java.time.LocalDate;

public class EditInfo {
    static String jdbcUrl = "jdbc:mysql://localhost:3306/school_management";
    static String jdbcUsername = "root";
    static String jdbcPassword = "password";
    RowInfoHolder infoHolder;

    public EditInfo(RowInfoHolder infoHolder){
        this.infoHolder = infoHolder;
    }
    public void updateStudent(){
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

            String updateQuery = "UPDATE student SET first_name = ?, last_name = ?, date_of_birth = ?, gender = ? WHERE display_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            //String dob = infoHolder.year + "-" + infoHolder.month + "-" + infoHolder.day;
            int year = Integer.parseInt(infoHolder.year);
            int month = convertMonthStringToInt(infoHolder.month);
            int day = Integer.parseInt(infoHolder.day);
            LocalDate date = LocalDate.of(year, month, day);
            Date dob = Date.valueOf(date);

            String displayID = infoHolder.id;
            preparedStatement.setString(1, infoHolder.firstName );
            preparedStatement.setString(2, infoHolder.lastName);
            preparedStatement.setDate(3, dob);
            preparedStatement.setString(4, infoHolder.gender);
            preparedStatement.setString(5,infoHolder.id);

            preparedStatement.executeUpdate();

            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public int convertMonthStringToInt(String monthString) {
        switch (monthString.toLowerCase()) {
            case "january":
                return 1;
            case "february":
                return 2;
            case "march":
                return 3;
            case "april":
                return 4;
            case "may":
                return 5;
            case "june":
                return 6;
            case "july":
                return 7;
            case "august":
                return 8;
            case "september":
                return 9;
            case "october":
                return 10;
            case "november":
                return 11;
            case "december":
                return 12;
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "11":
                return 11;
            case "12":
                return 12;
            default:
                throw new IllegalArgumentException("Invalid month: " + monthString);
        }
    }
    public int getDepartmentID(){
        if (infoHolder.department.toLowerCase().equals("software engineer")){
            return 1;
        }
        else if(infoHolder.department.toLowerCase().equals("computer science")){
            return 2;
        }
        else if(infoHolder.department.toLowerCase().equals("data science")){
            return 3;
        }
        else if(infoHolder.department.toLowerCase().equals("Artificial Intelligence")){
            return 4;
        }
        return 0;
    }

}
